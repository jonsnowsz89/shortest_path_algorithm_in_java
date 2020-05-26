package challenges;

import java.util.ArrayList;



public class shortest_path {
	
	static Object[][] loadData() {
		Object[][]  data= new Object[][]{
			{"A","B",2.0},
			{"A","C",4.0},
			{"A","V",3.0},
			
			{"B","E",7.0},
			{"B","F",4.0},
			{"B","G",6.0},
			
			{"C","E",3.0},
			{"C","F",2.0},
			{"C","G",4.0},
			
			{"D","E",4.0},
			{"D","F",1.0},
			{"D","G",5.0},
			
			{"E","H",1.0},
			{"E","I",4.0},
			
			{"F","H",6.0},
			{"F","I",3.0},
			
			{"G","H",3.0},
			{"G","I",3.0},
			
			{"H","J",3.0},
			
			{"I","J",4.0},
			
		};
		
		
		return data;
	}
	
	

	
	static convert2Obj []convertAll(Object[][] map){
		
		
		convert2Obj []data=new convert2Obj[map.length];
		for (int i=0;i<map.length;i++) {
			String from=(String) map[i][0];
			String to=(String) map[i][1];
			double weight=(double) map[i][2] ;
			
			data[i]=new convert2Obj(from,to,weight);
			
		}
		
		
		return data;
	}
	
	
	
	static ArrayList findpath(convert2Obj[] data,String start,String end) {
		
		ArrayList<convert2Obj> paths = new ArrayList<convert2Obj>();
		for(convert2Obj ob:data) {
			
			
			if( ob.From==end || ob.To==end) {
				paths.add(ob);
				
			}
			
		}
		
		
		
		
		
		return null;
	}
		
		static ArrayList findNodes(convert2Obj[] data) {
			// convert2Obj is an array of object 
			
			ArrayList<String> nodes = new ArrayList<String>();
			// nodes an empty list to store names of cities
			
			for(convert2Obj ob:data) {
				// ob is an object that hold 
				// ob.From ----->String that hold the name of first city
				//ob.To ----->String that hold the name of Second city
				
				
				if (nodes.isEmpty()) {
					nodes.add(ob.From); // add the first city to empty  Arraylist
					
					if(ob.From!=ob.To) {
						nodes.add(ob.To);
					}
					
					
				}else {//  add the  cities to the node  Arraylist
					
					for (String st:nodes) { // i need to over loop the node list to avoid duplicated names
						
						if(ob.From.equals( st )) {
							nodes.add(st); // error is here in this line
						}
						
						
						if(ob.To.equals( st) ) {
							nodes.add(st);
						}
					}
				}
			}
			return nodes;
		} // end of findNodes method
		
	
	public static void main(String[] args) {
		// Data
		Object[][]  map=loadData();
		
		//convert data to object
		convert2Obj []data=convertAll( map);
		
		
		String start_point="A";
		String end_point="j";
		
		
		
		ArrayList<convert2Obj[]> paths = new ArrayList<convert2Obj[]>();
		 ArrayList<String> names= findNodes( data) ;
		 for(String s:names)
			 System.out.println(s);
		
		
	}//main method
	
	
	

}// class




class convert2Obj{
	
	 String From;
	 String To;
	 double Weight;
	private boolean visitesEdge;
	convert2Obj(String f,String t,double w){
		this.From=f;
		this.To=t;
		this.Weight=w;
		this.visitesEdge=false;
		
	}
	
	
	
	void setEdge() {
		this.visitesEdge=true;
	}
	
	void show() {
		
		System.out.println(this.From+" --> "+this.To+" : "+this.Weight);
	}
	
}
