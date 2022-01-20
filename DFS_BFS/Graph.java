import java.util.*;

public class Graph {
	
    ArrayList<Node> nodes;
    int[][] matrix;
	
    Graph(int size){
        nodes = new ArrayList<>();
	matrix = new int[size][size];
    }
	
	void addNode(Node node) {
		nodes.add(node);
	}	
	
	void addEdge(int src, int dst) {	
		matrix[src][dst] = 1;
	}	
	
	boolean checkEdge(int src, int dst) {	
		if(matrix[src][dst] == 1) 
			return true;
		else 
			return false;
	}	
	
	void print() {	
		System.out.print("  ");
		for(Node node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}	
	
	int sum(int[] arr){
		int sum = 0; 
		for(int i=0; i<arr.length; i++){
			sum += arr[i]; 
		}
		return sum; 
	}

	void DFSStack(int src, boolean[] visited){
		Stack<Character> stk = new Stack<>();
		stk.push(nodes.get(src).data);  
		System.out.println(nodes.get(src).data + " is visited"); 
		visited[src] = true; 

		int preSrc = 0; 
		while(!stk.empty()){ 
			int i=0;	
			while(i<matrix[src].length){
				if(sum(matrix[src]) == 0){ // in case if row cosist zeros.
					break; 
				}
				if(matrix[src][i] == 1 && !visited[i]){
					stk.push(nodes.get(i).data);
					visited[i] = true; 
					System.out.println(nodes.get(i).data + " is visited"); 
					preSrc = src; 
					src = i; 
					i = 0; 
				}else{
					i++; 
				}
			}
			stk.pop(); 
			src = preSrc; // back to previous source(src). 
		}
	}

	void DFSRec(int src, boolean[] visited){
		if(visited[src])
			return; 
		else{
			visited[src] = true; 
			System.out.println(nodes.get(src).data + " is visited"); 
			for(int i=0; i<matrix[src].length; i++){
				if(matrix[src][i] == 1)
					DFSRec(i, visited);
			}
		return; // in case if row cosist zeros.
		}
	}

	void depthFirstSearch(int src){
		boolean[] visited = new boolean[nodes.size()];
		DFSRec(src, visited);
		//DFSStack(src, visited);
	}
	
}
