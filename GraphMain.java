public class GraphMain {

	public static void main(String[] args) {
		 BFS bfs = new BFS(4);
		 bfs.addEdge(0, 1);
		 bfs.addEdge(0, 2);
		 bfs.addEdge(1, 2);
		 bfs.addEdge(2, 0);
		 bfs.addEdge(2, 3);
		 bfs.addEdge(3, 3);

		 bfs.printBFS(2);
	}

}
