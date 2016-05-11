package schedulers;

import java.util.List;
import java.util.Vector;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;


/***
 * This scheduler makes network selection without any look into the future.
 * @author QZ61P8
 *
 */
public class GreedyOnlineScheduler extends GreedyScheduler {

	public GreedyOnlineScheduler(NetworkGenerator ng, FlowGenerator tg) {
		super(ng, tg);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Scheduler calculates network selection for each time slot separately:
	 * (1) select most critical flow
	 * (2) select best matching network available in current time slot
	 * (3) assign to network as much as possible
	 */
	
	@Override
	protected void calculateInstance_internal(String logfile) {
		//initialize network preference vector
		Vector<Vector<Integer>> flowsToNets = new Vector<Vector<Integer>>();
		Vector<Integer> chunksToAllocate = new Vector<Integer>();
		for(Flow flow : tg.getFlows()){
			flowsToNets.add(sortNetworkIDs(flow));
			chunksToAllocate.add(flow.getChunks());
		}

		List<Integer> flow_order = sortByFlowCriticality();
		
		for (int t=0; t<ng.getTimeslots(); t++){
			//assign each active flow to best matching network
			for(int f0=0;f0<tg.getFlows().size();f0++){
				int f=flow_order.get(f0);
				Flow flow= tg.getFlows().get(f);
				int chunksMaxTp = (int)(flow.getChunksMax()/flow.getWindowMax());	//get average maximum throughput for later allocation
				//assign only within preferred time frame of flow
				if(flow.getStartTime()<=t && flow.getDeadline()>=t){
					int n0=0;					
					int allocated=0;
					
					while(allocated==0 && n0<ng.getNetworks().size()){
						int n=flowsToNets.get(f).get(n0);
						if(calcVio(flow, ng.getNetworks().get(n))<0){
							if(chunksToAllocate.get(f)<chunksMaxTp){
								allocated=allocate(f, t, n, chunksToAllocate.get(f)); //do not allocate more chunks than required
							}else{
								allocated=allocate(f, t, n, chunksMaxTp);
							}
							chunksToAllocate.set(f, chunksToAllocate.get(f)-allocated);
						}
						n0++;
					}
					
				}
			}
			
		}

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "GreedyOnline";
	}

}