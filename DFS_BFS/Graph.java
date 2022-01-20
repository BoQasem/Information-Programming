import java.util.*;

public class Graph {

	ArrayList<Node> nodes;
	int[][] matrix;

	Graph(int size) {
		nodes = new ArrayList<>(size);
		matrix = new int[size][size];

	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void addNode(Node item) {
		nodes.add(item);
	}

	public void addEdge(int src, int dst) {
		matrix[src][dst] = 1;
	}

	public boolean checkEdge(int src, int dst) {
		if (matrix[src][dst] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void print() {
		System.out.print("  ");
		for (int i = 0; i < nodes.size(); i++) {
			System.out.print(nodes.get(i).data + " ");
		}
		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum;
	}

	// legacy function 
	void DFSStack(int src, boolean[] visited) {
		Stack<Character> stk = new Stack<>();
		stk.push(nodes.get(src).data);
		System.out.println(nodes.get(src).data + " is visited");
		visited[src] = true;

		int preSrc = 0;
		while (!stk.empty()) {
			int i = 0;
			while (i < matrix[src].length) {
				if (sum(matrix[src]) == 0) // in case if row cosist zeros.
					break;

				if (matrix[src][i] == 1 && !visited[i]) {
					stk.push(nodes.get(i).data);
					visited[i] = true;
					System.out.println(nodes.get(i).data + " is visited");
					preSrc = src;
					src = i;
					i = 0;
				} else {
					i++;
				}
			}
			stk.pop();
			src = preSrc; // back to previous source(src).
		}
	}

	public void DFS_Stack(int src) {
		Stack<Integer> stk = new Stack<>();
		boolean[] visited = new boolean[matrix.length];

		stk.push(src);
		visited[src] = true;

		while (stk.size() != 0) {

			src = stk.pop();
			System.out.println(nodes.get(src).data + " = visited");

			for (int i = matrix[src].length - 1; i >= 0; i--) {
				if (matrix[src][i] == 1 && !visited[i]) {
					stk.push(i);
					visited[i] = true;
				}
			}
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

	public void BFS_Queue(int src) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];

		queue.offer(src);
		visited[src] = true;

		while (queue.size() != 0) {

			src = queue.poll();
			System.out.println(nodes.get(src).data + " is visited");

			for (int i = 0; i < matrix[src].length; i++) {
				if (matrix[src][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public void search(int start) {
		boolean[] visited = new boolean[nodes.size()];
		// DFS_Rec(start,visited);
		// DFS_Stack(start);
		// BFS_Queue(start);
	}
}
