
import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import schedulers.Scheduler;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import visualization.Plot;
import visualization.VisualizationPack;

import ToolSet.EvaluationScenarioCreator;


public class Test {
	
	private static ArrayList<Integer> costOpt = new ArrayList<Integer>();
	private static ArrayList<Integer> costGreedy4 = new ArrayList<Integer>();
	private static ArrayList<Integer> costRandom = new ArrayList<Integer>();
	private static Vector<Scheduler> scheds = new Vector<Scheduler>();
	
	public static void initArray() {
		setCostOpt(new ArrayList<Integer>());
		setCostGreedy4(new ArrayList<Integer>());
		setCostRandom(new ArrayList<Integer>());
	}
	
	public static boolean testLongTerm(FlowGenerator tg, NetworkGenerator ngReal, boolean plotBool, String path, String logpath) {
		if (logpath.length() == 0) {
			logpath= "my_logs"+File.separator+"eval_4_4_3";
		}
		
		int c_opt=0;
		boolean first = true;
		scheds = new Vector<Scheduler>();
	
		scheds= EvaluationScenarioCreator.initSchedulers(ngReal, tg);
		int i = 0;
		for (Scheduler scheduler : scheds) {
			////////System.out.println("schedule name: " + scheduler.getType());
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = formatter.format(Calendar.getInstance().getTime());
			////////System.out.println(" "+scheduler.getType() + ", starting at "+date);

			scheduler.calculateInstance(logpath, true);

		}

		if(plotBool){
			Plot plot = new Plot(new VisualizationPack(ngReal, tg, scheds));
		}
		return true;
	}
	

	
	public static void testVariousFlows() {
		/*
		int f=3;
		int t=200;
		int n=2;
		int rep=1;
		String logpath= "my_logs"+File.separator+"eval_4_4_3_omnet";
		
		int c_opt=0;
		boolean first = true;
		double array[] = {60.27387829524284, 61.78794557200155, 56.398160599607436, 56.597401023347366, 55.10802698396002, 66.89042687286806, 60.39268948039116, 52.67180420131863, 58.20352143397995, 62.500584544587994, 69.87601619306245, 63.951297724819476, 60.420160254324834, 65.08135558091845, 67.16851209458872, 51.62203417036748, 52.972252443938544, 53.21554305607194, 56.39228349132178, 60.270196437520816, 69.98396559764473, 70.42709971747345, 74.7306205118064, 70.51956740871277, 65.47694747220429, 74.33598174712053, 71.08403153263946, 69.73771484606273, 66.58568102213034, 70.8085976214164, 70.9047680487049, 64.67341161795778, 74.66259014607988, 72.16341746593525, 73.27187715891479, 69.77952657093918, 69.96288161070792, 69.18690945033185, 71.84190455125031, 73.72204890098457, 74.65135809960047, 77.19654965271208, 79.6047289926002, 79.97143449129177, 84.01089252838614, 81.26498143932982, 80.04741314039937, 79.04016630632566, 83.52452809813688, 81.23876327760726, 83.25367711418333, 79.32898043441443, 83.3190415857005, 79.09590401168074, 76.78584484328832, 83.5835900631536, 83.75715495408193, 81.42415619656192, 81.26869513984111, 80.2761386399079, 89.20248205705249, 87.68459331344101, 90.4500762855034, 88.51776354273873, 89.65274029826655, 89.76947603241997, 88.0040779950358, 86.57677671999232, 89.16479821633168, 92.44109737443866, 90.52860621979099, 88.04110587727845, 86.94149095565572, 90.64060189302687, 90.4135296005249, 89.13381667166678, 93.29073504181731, 89.20773771024446, 91.31047620014934, 86.39582991282855, 100.01900925558158, 100.81089454597449, 99.0783006586118, 100.08975474959814, 99.87913989880883, 99.62741340401978, 100.7350037604595, 100.19793209674998, 101.57650455670012, 100.40989733235547, 99.32516850990129, 100.67106391476031, 101.61068786712558, 99.78243652589896, 96.64547981693696, 98.29759616390486, 100.12567626818452, 98.76926588407844, 101.04269704672153, 97.81456055187209, 90.24803741704116, 91.48343853011876, 91.3432370448617, 91.15996162081579, 92.2884857452548, 91.23772661848878, 94.20876274314762, 90.98925737569954, 90.00403682529758, 87.8971968713552, 91.09955042425419, 90.17857012140426, 90.3964187187084, 89.33882480717106, 91.6297700075969, 95.49799635093163, 87.30161333777377, 86.58815746145932, 90.82086924326664, 85.64875351374297, 85.05604945886199, 83.52986971899222, 79.5926895223106, 76.17673619313364, 74.86617997615528, 77.3783505588137, 80.93439318293085, 77.68698625887524, 80.38897879568307, 74.81625385813732, 83.25701918531333, 82.40464310739155, 87.99766048828795, 74.61740654360656, 79.24561820581964, 80.06591048545263, 82.4455299850382, 81.97139838607795, 79.22412993665475, 82.1084914960012, 71.54642396525925, 61.185407814907684, 73.00036084140498, 68.09196349130008, 65.38595146404445, 63.94576270804937, 69.91494054592958, 70.78734867082363, 65.5089068322599, 72.97781534519432, 76.60790580786782, 77.69039996159269, 67.01851851985228, 71.1360117765448, 62.26818183872828, 66.20036569371864, 78.77682046633515, 66.429853349035, 72.50556058105381, 69.03307492361147, 70.04305320528331, 50.2781064706872, 58.80467506182014, 61.56912215981979, 62.22518472560139, 65.05495074685732, 59.32992991629777, 51.2923691440093, 61.78841892656008, 59.12430907968295, 67.47665348256054, 56.35736366616752, 64.53526433661655, 61.0323009618857, 50.56154954360411, 51.40535497063225, 64.7106987121317, 60.10530149854568, 55.87817799661889, 60.0235696069235, 47.308745708414165, 46.081035467313406, 65.96823097378895, 51.25730455926973, 46.6414907913655, 43.53493681283253, 61.23226690962074, 52.61481846626817, 51.79399664486953, 49.04651601187941, 43.77441478498045, 49.06739796444578, 57.28659459183894, 54.564171882873424, 50.37380104738012, 63.37350122421796, 44.0932238379037, 50.49172545066877, 56.01728532974308, 48.49818653748974};

		int capacity[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			capacity[i] = (int) (array[i]*1.75);
		}
		NetworkGenerator ng = new NetworkGenerator();
		// ng.initNG(capacity);
		ng.addNetwork(Network.getCellular(200, 100));
		ng.addNetwork(Network.getWiFi(20, 85, 5));
		ng.addNetwork(Network.getWiFi(20, 65, 20));
		ng.addNetwork(Network.getWiFi(20, 65, 35));
		ng.addNetwork(Network.getWiFi(20, 65, 50));


		FlowGenerator tg = new FlowGenerator();
		tg.addFlow(Flow.LiveStram(25, 150, 60*125)); // 0
		tg.addFlow(Flow.BufferableStream(5, 70, 70*70)); // 1
		tg.addFlow(Flow.BufferableStream(30, 50, 50*50)); // 2
		tg.addFlow(Flow.Interactive(40, 50)); // 3
		tg.addFlow(Flow.Background(300, 30, 100)); // 4
		Vector<Scheduler> scheds= EvaluationScenarioCreator.initSchedulers(ng, tg);
		int i = 0;
		for (Scheduler scheduler : scheds) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = formatter.format(Calendar.getInstance().getTime());
			////////System.out.println(" "+scheduler.getType() + ", starting at "+date);

			scheduler.calculateInstance(logpath);
			JsonLogger.array2Json(scheduler.getSchedule(), "schedule + " + i);
			i++;
			
			//debug: check if optimization has lowest cost
			if(first){
				c_opt=scheduler.getCost();
				first=false;     
			}else{
				if(scheduler.getCost()<c_opt){
					System.err.println("OPT STILL NOT BEST");
				}
			}

		}

		if(true){
			Plot plot = new Plot(new VisualizationPack(ng, tg, scheds));
		}
*/
		
	}
	
	public static void genInitSolution() {
		int f=1;
		int t=200;
		int n=1;
		int rep=1;
		String logpath= "my_logs"+File.separator+"eval_4_4_3_omnet";
		/*
		int c_opt=0;
		boolean first = true;
		double array[] = {60.27387829524284, 61.78794557200155, 56.398160599607436, 56.597401023347366, 55.10802698396002, 66.89042687286806, 60.39268948039116, 52.67180420131863, 58.20352143397995, 62.500584544587994, 69.87601619306245, 63.951297724819476, 60.420160254324834, 65.08135558091845, 67.16851209458872, 51.62203417036748, 52.972252443938544, 53.21554305607194, 56.39228349132178, 60.270196437520816, 69.98396559764473, 70.42709971747345, 74.7306205118064, 70.51956740871277, 65.47694747220429, 74.33598174712053, 71.08403153263946, 69.73771484606273, 66.58568102213034, 70.8085976214164, 70.9047680487049, 64.67341161795778, 74.66259014607988, 72.16341746593525, 73.27187715891479, 69.77952657093918, 69.96288161070792, 69.18690945033185, 71.84190455125031, 73.72204890098457, 74.65135809960047, 77.19654965271208, 79.6047289926002, 79.97143449129177, 84.01089252838614, 81.26498143932982, 80.04741314039937, 79.04016630632566, 83.52452809813688, 81.23876327760726, 83.25367711418333, 79.32898043441443, 83.3190415857005, 79.09590401168074, 76.78584484328832, 83.5835900631536, 83.75715495408193, 81.42415619656192, 81.26869513984111, 80.2761386399079, 89.20248205705249, 87.68459331344101, 90.4500762855034, 88.51776354273873, 89.65274029826655, 89.76947603241997, 88.0040779950358, 86.57677671999232, 89.16479821633168, 92.44109737443866, 90.52860621979099, 88.04110587727845, 86.94149095565572, 90.64060189302687, 90.4135296005249, 89.13381667166678, 93.29073504181731, 89.20773771024446, 91.31047620014934, 86.39582991282855, 100.01900925558158, 100.81089454597449, 99.0783006586118, 100.08975474959814, 99.87913989880883, 99.62741340401978, 100.7350037604595, 100.19793209674998, 101.57650455670012, 100.40989733235547, 99.32516850990129, 100.67106391476031, 101.61068786712558, 99.78243652589896, 96.64547981693696, 98.29759616390486, 100.12567626818452, 98.76926588407844, 101.04269704672153, 97.81456055187209, 90.24803741704116, 91.48343853011876, 91.3432370448617, 91.15996162081579, 92.2884857452548, 91.23772661848878, 94.20876274314762, 90.98925737569954, 90.00403682529758, 87.8971968713552, 91.09955042425419, 90.17857012140426, 90.3964187187084, 89.33882480717106, 91.6297700075969, 95.49799635093163, 87.30161333777377, 86.58815746145932, 90.82086924326664, 85.64875351374297, 85.05604945886199, 83.52986971899222, 79.5926895223106, 76.17673619313364, 74.86617997615528, 77.3783505588137, 80.93439318293085, 77.68698625887524, 80.38897879568307, 74.81625385813732, 83.25701918531333, 82.40464310739155, 87.99766048828795, 74.61740654360656, 79.24561820581964, 80.06591048545263, 82.4455299850382, 81.97139838607795, 79.22412993665475, 82.1084914960012, 71.54642396525925, 61.185407814907684, 73.00036084140498, 68.09196349130008, 65.38595146404445, 63.94576270804937, 69.91494054592958, 70.78734867082363, 65.5089068322599, 72.97781534519432, 76.60790580786782, 77.69039996159269, 67.01851851985228, 71.1360117765448, 62.26818183872828, 66.20036569371864, 78.77682046633515, 66.429853349035, 72.50556058105381, 69.03307492361147, 70.04305320528331, 50.2781064706872, 58.80467506182014, 61.56912215981979, 62.22518472560139, 65.05495074685732, 59.32992991629777, 51.2923691440093, 61.78841892656008, 59.12430907968295, 67.47665348256054, 56.35736366616752, 64.53526433661655, 61.0323009618857, 50.56154954360411, 51.40535497063225, 64.7106987121317, 60.10530149854568, 55.87817799661889, 60.0235696069235, 47.308745708414165, 46.081035467313406, 65.96823097378895, 51.25730455926973, 46.6414907913655, 43.53493681283253, 61.23226690962074, 52.61481846626817, 51.79399664486953, 49.04651601187941, 43.77441478498045, 49.06739796444578, 57.28659459183894, 54.564171882873424, 50.37380104738012, 63.37350122421796, 44.0932238379037, 50.49172545066877, 56.01728532974308, 48.49818653748974};

		int capacity[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			capacity[i] = (int) array[i];
		}
		NetworkGenerator ng = new NetworkGenerator();
		ng.initNG(capacity);
		FlowGenerator tg = new FlowGenerator();
		tg.initTG(200);
		Vector<Scheduler> scheds= EvaluationScenarioCreator.initSchedulers(ng, tg);
		for (Scheduler scheduler : scheds) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = formatter.format(Calendar.getInstance().getTime());
			////////System.out.println(" "+scheduler.getType() + ", starting at "+date);

			scheduler.calculateInstance(logpath);
			
			//debug: check if optimization has lowest cost
			if(first){
				c_opt=scheduler.getCost();
				first=false;     
			}else{
				if(scheduler.getCost()<c_opt){
					System.err.println("OPT STILL NOT BEST");
				}
			}

		}*/

		if(true){
	//		Plot plot = new Plot(new VisualizationPack(ng, tg, scheds));
		}

	}

	public static ArrayList<Integer> getCostOpt() {
		return costOpt;
	}

	public static void setCostOpt(ArrayList<Integer> costOptVar) {
		costOpt = costOptVar;
	}

	public static ArrayList<Integer> getCostGreedy4() {
		return costGreedy4;
	}

	public static void setCostGreedy4(ArrayList<Integer> costGreedy4) {
		Test.costGreedy4 = costGreedy4;
	}

	public static ArrayList<Integer> getCostRandom() {
		return costRandom;
	}

	public static void setCostRandom(ArrayList<Integer> costRandom) {
		Test.costRandom = costRandom;
	}

	public static Vector<Scheduler> getScheds() {
		return scheds;
	}

	public static void setScheds(Vector<Scheduler> scheds) {
		Test.scheds = scheds;
	}

}