package myopic;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Myopic {
	
	/*Double[][] data = {
			{0.0,24.0,18.0,33.0},  //A
			{24.0,0.0,25.0,12.0},  //B
			{18.0,25.0,0.0,15.0},  //C
			{33.0,12.0,15.0,0.0}   //D
	};
	
	Double demand[] = {15.0,5.0,11.0,16.0};
	
	*/
	
	Double[][] data = {{0.0,5.323532662,6.041522987,7.273238618,8.802272434,5.522680509,8.521150157,1.640121947,9.786725704,8.159656856,9.992997548,7.516648189,3.106444913,4.87954916,8.360023923,7.003570518,5.629387178,4.243819035,3.5,5.573149917},
			{5.323532662,0.0,4.808326112,8.268010643,5.894064811,6.003332408,8.005623024,3.889730068,7.962411695,5.571355311,7.180529228,3.847076812,4.936598019,8.249242389,4.210700654,2.334523506,6.618912297,7.170076708,4.805205511,4.841487375},
			{6.041522987,4.808326112,0.0,3.736308338,2.983286778,1.843908891,3.220248438,4.609772229,3.8,2.28035085,4.024922359,2.828427125,3.176476035,5.412023651,3.785498646,3.956008089,2.53179778,4.410215414,2.729468813,0.5656854249},
			{7.273238618,8.268010643,3.736308338,0.0,5.65154846,2.28035085,2.334523506,6.5,4.5607017,5.06359556,5.993329626,6.428063472,4.341658669,3.7,7.302739212,7.692203845,1.780449381,3.40147027,4.10487515,3.492849839},
			{8.802272434,5.894064811,2.983286778,5.65154846,0.0,4.580392996,3.811823711,7.242237223,2.420743687,0.7071067812,1.303840481,2.102379604,6.129437168,8.241965785,2.343074903,3.894868419,5.1623638,7.310950691,5.68594759,3.54682957},
			{5.522680509,6.003332408,1.843908891,2.28035085,4.580392996,0.0,3.001666204,4.459820624,4.569463864,3.883297568,5.381449619,4.669047012,2.418677324,3.661966685,5.629387178,5.643580424,0.7,2.758622845,2.061552813,1.4},
			{8.521150157,8.005623024,3.220248438,2.334523506,3.811823711,3.001666204,0.0,7.375635566,2.247220505,3.395585369,3.832753579,5.189412298,5.414794548,5.866856058,5.882176468,6.795586803,3.059411708,5.314132102,5.035871325,3.354101966},
			{1.640121947,3.889730068,4.609772229,6.5,7.242237223,4.459820624,7.375635566,0.0,8.405355436,6.621933252,8.464632302,5.883026432,2.163330765,4.965883607,6.720119047,5.390732789,4.741307836,4.049691346,2.416609195,4.201190308},
			{9.786725704,7.962411695,3.8,4.5607017,2.420743687,4.569463864,2.247220505,8.405355436,0.0,2.441311123,1.811077028,4.404543109,6.768308504,7.920227269,4.763402146,6.200806399,4.887739764,7.220110802,6.334824386,4.219004622},
			{8.159656856,5.571355311,2.28035085,5.06359556,0.7071067812,3.883297568,3.395585369,6.621933252,2.441311123,0.0,1.843908891,1.979898987,5.43783045,7.545197148,2.507987241,3.764306045,4.477722635,6.606814664,4.992995093,2.842534081},
			{9.992997548,7.180529228,4.024922359,5.993329626,1.303840481,5.381449619,3.832753579,8.464632302,1.811077028,1.843908891,0.0,3.352610923,7.200694411,8.987213139,3.383784863,5.107837116,5.872818744,8.139410298,6.753517602,4.565084884},
			{7.516648189,3.847076812,2.828427125,6.428063472,2.102379604,4.669047012,5.189412298,5.883026432,4.404543109,1.979898987,3.352610923,0.0,5.360037313,8.134494453,0.9848857802,1.802775638,5.360037313,7.077428912,4.964876635,3.2984845},
			{3.106444913,4.936598019,3.176476035,4.341658669,6.129437168,2.418677324,5.414794548,2.163330765,6.768308504,5.43783045,7.200694411,5.360037313,0.0,3.313608305,6.32455532,5.56596802,2.6,2.236067977,0.4472135955,2.640075756},
			{4.87954916,8.249242389,5.412023651,3.7,8.241965785,3.661966685,5.866856058,4.965883607,7.920227269,7.545197148,8.987213139,8.134494453,3.313608305,0.0,9.11811384,8.713208364,3.1144823,1.104536102,3.50142828,4.875448697},
			{8.360023923,4.210700654,3.785498646,7.302739212,2.343074903,5.629387178,5.882176468,6.720119047,4.763402146,2.507987241,3.383784863,0.9848857802,6.32455532,9.11811384,0.0,1.902629759,6.315061362,8.062257748,5.936328832,4.272001873},
			{7.003570518,2.334523506,3.956008089,7.692203845,3.894868419,5.643580424,6.795586803,5.390732789,6.200806399,3.764306045,5.107837116,1.802775638,5.56596802,8.713208364,1.902629759,0.0,6.338769597,7.611832894,5.263078947,4.257933771},
			{5.629387178,6.618912297,2.53179778,1.780449381,5.1623638,0.7,3.059411708,4.741307836,4.887739764,4.477722635,5.872818744,5.360037313,2.6,3.1144823,6.315061362,6.338769597,0.0,2.332380758,2.332380758,2.1},
			{4.243819035,7.170076708,4.410215414,3.40147027,7.310950691,2.758622845,5.314132102,4.049691346,7.220110802,6.606814664,8.139410298,7.077428912,2.236067977,1.104536102,8.062257748,7.611832894,2.332380758,0.0,2.4,3.858756276},
			{3.5,4.805205511,2.729468813,4.10487515,5.68594759,2.061552813,5.035871325,2.416609195,6.334824386,4.992995093,6.753517602,4.964876635,0.4472135955,3.50142828,5.936328832,5.263078947,2.332380758,2.4,0.0,2.19317122},
			{5.573149917,4.841487375,0.5656854249,3.492849839,3.54682957,1.4,3.354101966,4.201190308,4.219004622,2.842534081,4.565084884,3.2984845,2.640075756,4.875448697,4.272001873,4.257933771,2.1,3.858756276,2.19317122,0.0}};
	
	Double demand[] = {100.0,800.0,50.0,20.0,500.0,20.0,40.0,500.0,60.0,70.0,80.0,700.0,900.0,600.0,500.0,1200.0,800.0,300.0,400.0,500.0};
	
	
	Map<Double[],String> wareHouseReferenceName = new HashMap<Double[],String>();
	
	public void init(){
		for (int i = 0; i < data.length; i++) {
			wareHouseReferenceName.put(data[i], ""+(i+1));
		}
	}
	
	public Set<List<Double[]>> getCombinations(List<Double[]> choosen){
		
		
		
		List<Double[]>  combineWith =  new ArrayList<Double[]>();
		for (int i = 0; i < data.length; i++) {
			combineWith.add(data[i]);
		}
		
		Set<List<Double[]>> combined = new HashSet<List<Double[]>>();
		
		if(choosen == null){
			for (int i = 0; i < combineWith.size(); i++) {
				List<Double[]> element  = new ArrayList<Double[]>();
				element.add(combineWith.get(i));
				combined.add(element);
			}
			return combined;
		}

		
		for (int i = 0; i < combineWith.size(); i++) {
			List<Double[]> list = new ArrayList<Double[]>();
			list.add(combineWith.get(i));
			for (int j = 0; j < choosen.size(); j++) {
					if(choosen.get(j).equals(combineWith.get(i)))
					{
						continue;
					}
					list.add(choosen.get(j));
			}
			if(list.size()>1)
				combined.add(list);
		}
		return combined;
	}
	
	
	
	
	
	double size = data[0].length;
	
	
	public void driver(){
		
		List<Double[]> choosen = new ArrayList<Double[]>();
		choosen.add(data[12]);
		
		int i = 0;
		double value = 0;
		for (i = 0; i < size-1; i++) {
			Set<List<Double[]>> choosenW = getCombinations(choosen);
			SetOfWareHouses choosenSetofWareHouses = getChoosenSetWareHouse(choosenW); 
			choosen = choosenSetofWareHouses.warehouses;
			value = choosenSetofWareHouses.value;
			printChosenHouses(choosen,i,value);
			System.out.println("***********");
		}
		printChosenHouses(choosen,i,value);
		
		
	}
	
	private void printChosenHouses(List<Double[]> choosen, int i,double value) {
		// TODO Auto-generated method stub
		System.out.println("Choosen houses at iteration "+i + " Value "+value);
		for (int j = 0; j < choosen.size(); j++) {
			System.out.println("\t "+wareHouseReferenceName.get(choosen.get(j)));
		}
	}

	SetOfWareHouses getChoosenSetWareHouse(Set<List<Double[]>> choosenW ){
		
		PriorityQueue<SetOfWareHouses> listOfSetofWareHouses = new PriorityQueue<>(choosenW.size(), new Comparator<SetOfWareHouses>() {
			@Override
			public int compare(SetOfWareHouses o1, SetOfWareHouses o2) {
				// TODO Auto-generated method stub
				if(o1.value < o2.value)
					return -1;
				else if(o1.value > o2.value)
					return 1;
				else
					return 0;
			}
		});
	
		Iterator<List<Double[]>> iterator = choosenW.iterator();
		while(iterator.hasNext()){
			List<Double[]> set = iterator.next();
			double weigthedDistance = getWeightedDistance(set);
			listOfSetofWareHouses.add(new SetOfWareHouses(set, weigthedDistance));
		}
		
		SetOfWareHouses minimumSetofWareHouses = listOfSetofWareHouses.peek();

		return minimumSetofWareHouses;
	}
	
	class SetOfWareHouses{
		List<Double[]> warehouses;
		Double value ;
		
		public SetOfWareHouses(List<Double[]> warehouses, Double value){
			this.warehouses = warehouses;
			this.value = value;
		}

	}
	
	public static void main(String[] args) {
		Myopic myopic = new Myopic();
		
		/*List<Double[]> wareHouses = new ArrayList<Double[]>();
		
		wareHouses.add(myopic.data[2]);
		wareHouses.add(myopic.data[3]);*/

		
		//System.out.println(myopic.data[2].equals(myopic.data[2]));
		
		//System.out.println(myopic.getWeightedDistance(wareHouses));
		
		myopic.init();
		myopic.driver();
		
		
	}
	
	public double getWeightedDistance(List<Double[]> distances){
		
		double value = 0.0;
		for (int i = 0; i < size; i++) {
			List<Double> list = new ArrayList<Double>();
			for (int j = 0; j < distances.size(); j++) {
				list.add(distances.get(j)[i]);
			}
			value+=getMinium(list)*demand[i];
		} 
		return value;
	}
	
	public double getMinium(List<Double> distances){
		PriorityQueue<Double> priorityQueue = new PriorityQueue<>(distances.size());
		priorityQueue.addAll(distances);
		return priorityQueue.peek();
	}
	
}	
