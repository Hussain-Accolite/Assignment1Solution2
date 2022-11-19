package Assignment;
import java.util.*;

class edge{
	int s,d,w;
	edge(int source,int destination,int weight){
		this.s = source;
		this.d = destination;
		this.w = weight;
	}
	int getSource() {
		return this.s;
	}
	int getDestination() {
		return this.d;
	}
	int getWeight() {
		return this.w;
	}
}
class pair{
	   Integer des, wei;
	   public pair(Integer de, Integer wgh) {
	       this.des = de;
	       this.wei = wgh;
	   }
	   Integer getKey(){
	       return this.des;
	   }
	   Integer getValue(){
	       return this.wei;
	   }
}
 class Graph{
	int vertices;
	LinkedList<edge>[] Ge;
	
	Graph(int vertices){
		this.vertices = vertices;
		Ge = new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			Ge[i] = new LinkedList<>();
		}
	}
	public void addVertices(int source,int destination,int weight) {
		edge ed = new edge(source,destination,weight);
		Ge[source].addFirst(ed);
}
	public void printG(){
		for(int i=0;i<vertices;i++) {
			LinkedList<edge> list = Ge[i];
			for(int j = 0;j<list.size();j++) {
				System.out.print("  "+i+ "--> "+ list.get(j).d+" weight:  "+ list.get(j).w);
			}
			System.out.println();
		}
	}
	public pair[] get(Integer src) {
		
		return null;
	}
}

public class solution2 {
		
		public static void main(String[] args) {
			int vertices =6;
			Graph graph = new Graph(vertices);
			graph.addVertices(0, 1,12);
			graph.addVertices(0, 2, 13);
			graph.addVertices(0, 3, 11);
			graph.addVertices(0, 4, 8);
			graph.addVertices(1, 2, 3);
			graph.addVertices(3, 2, 4);
			graph.addVertices(4, 3, 7);
			//graph.printG();
			ArrayList<ArrayList<pair>> totalPath =  new ArrayList<ArrayList<pair>>();;
			ArrayList<pair> path = new ArrayList<pair>();
			System.out.println("enter source");
			Scanner sn = new Scanner(System.in);
			String x = sn.nextLine().toUpperCase();
			System.out.println("enter destination");
			String y = sn.nextLine().toUpperCase();
			Integer src = x.charAt(0)- 'A';
		    Integer des = y.charAt(0) - 'A';
		    sn.close();
			dfs(graph, totalPath, path,src,des,0 );
			int totalPathCount = totalPath.size();
		       int totalDistance = 0;
		       for(ArrayList<pair> it: totalPath){
		           for(pair it1 : it) {
		               totalDistance += it1.getValue();
		           }
		       }
		       System.out.println((double) totalDistance / totalPathCount);
		       
			
		}
		
		private static void dfs(Graph g, ArrayList<ArrayList<pair>> totalPath, ArrayList<pair> path, Integer src, Integer des, Integer wgh) {
		       path.add(new pair(src, wgh));
		       if(src.equals(des)){
//		    	   for(int i = 0; i < path.size(); i++) {
//		    		   System.out.print(path.get(i).getKey() + " ");
//		    	   }
//		    	   System.out.println();
		           totalPath.add(new ArrayList<pair>(path));
		       }
		       for(edge e : g.Ge[src]) {
		    	 
		    	        int des1 = e.getDestination();
		    	        int wgh1 = e.getWeight();
			           dfs(g, totalPath, path, des1, des, wgh1);
		      } 
		       
              path.remove(path.size() - 1);
		   
		   }
		
	
}
