package ToolSet.Decider;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import schedulingIOModel.CostFunction;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class GreedyDecider2 extends GreedyDecider {

	public GreedyDecider2(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg, NEW_RATING);
		name = "GreedyDecider2";
	}

	/**
	 * @param flowIndex
	 * @param rate boolean if you just need the rating (true) or if it should be scheduled (false)
	 * rate=true deletes the current schedule. It should be used only on fresh instances/before scheduling. 
	 */
	protected int scheduleFlow(int flowIndex, boolean rate) {
		Flow flow = tg.getFlows().get(flowIndex);
		Set<Integer> usedSlots = new HashSet<Integer>(); //each flow can use only one network in each time slot
		int chunksMaxTp = (int) (flow.getTokensMax());///flow.getWindowMax());	//get average maximum throughput for later allocation
		int chunksToAllocate = flow.getTokens();

		//sort networks according to match with flow
		Vector<Integer> networkIDs = sortNetworkIDs(flow);
		//			System.out.println("##################################  Flow "+flowIndex+"; Network order: "+networkIDs);

		//############## 2. Network choice according to flow matching #################
		//try to allocate in networks in descending order according to match
		for (int n1 = 1; n1 < networkIDs.size() && chunksToAllocate > 0; n1++) {
			int n = networkIDs.get(n1);
			//Network net = ng_tmp.getNetworks().get(n);
			//			System.out.println("########### Flow "+flowIndex +"   Network "+n);

			for (int t = Math.max(0, getStartTime(flow) - tl_offset); t < Math.min(ng.getTimeslots(),
					getDeadline(flow) + tl_offset) && chunksToAllocate > 0; t++) {
				//do only allocate if allocation leads to cost reduction
				if (scheduleDecision(flowIndex, n, t)) {

					//do not allocate more than once in same time slot
					if (!usedSlots.contains(t)) {
						//					System.out.println("remaining chunks "+chunksToAllocate);
						int allocated = 0;
						//						System.out.println("chunks maxTP: "+chunksMaxTp+"; chunksToAllocate: "+chunksToAllocate);
						int chunks = chunksMaxTp;
						if (NEW_RATING_ESTIMATOR) {
							int rating = calcVio(flowIndex, n) + //stateless reward + network match
							//											cs.getStatefulReward(f, t)+
									cs.getTimeMatch(flowIndex, t) / getAvMinTp(tg.getFlows().get(flowIndex));
							if (rating > schedule_decision_limit) {
								chunks = flow.getTokensMin();
							}
						}
						//						if(chunksToAllocate<chunksMaxTp){
						allocated = allocate(flowIndex, t, n, Math.min(chunksToAllocate, chunks)); //do not allocate more chunks than required and flow can provide
						//						}else{
						//							allocated=allocate(flowIndex, t, n, chunksMaxTp); //do not allocate more than flow can provide 
						//						}	
						//						System.out.println("remaining tokens "+chunksToAllocate+"; allocated: "+allocated);
						chunksToAllocate -= allocated;

						//update internal state of allocation
						if (allocated > 0) {
							if (NEW_RATING_ESTIMATOR) {
								cs.updateStatefulReward(flowIndex, t, allocated);
							}
							//								System.out.println("allocated "+allocated+ " t="+t+" n="+n0 +" remaining "+chunksToAllocate);
							usedSlots.add(t); //mark slot as used
							//remove capacity from network
							if (!rate) {
								//rate=false
								int remaining_chunks = ng_tmp.getNetworks().get(n).getCapacity().get(t) - allocated;
								//							System.out.println(remaining_chunks+" rem, alloc "+ allocated);
								ng_tmp.getNetworks().get(n).getCapacity().set(t, remaining_chunks);
							} else {
								//rate=true
								int[][][] sched = getTempSchedule(); //hold schedule
								setTempSchedule(getEmptySchedule()); //reset schedule
								return new CostFunction(ng_tmp, tg).costViolation(sched); //calculate rating
							}

						}
					}
				}
			}
		}
		return 0;
	}
}
