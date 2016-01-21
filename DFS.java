import java.util.ArrayList;
/*
	 DFS dfs = new DFS(4);
	 dfs.addEdge(0, 1);
	 dfs.addEdge(0, 2);
	 dfs.addEdge(1, 2);
	 dfs.addEdge(2, 0);
	 dfs.addEdge(2, 3);
	 dfs.addEdge(3, 3);
	
	 dfs.printDFS();
 */

public class DFS {

	private ArrayList<Integer>[] mAdjacentList;
	private boolean[] mIsVisitedList;
	private int mSize;

	DFS(int size) {
		mSize = size;
		mAdjacentList = new ArrayList[mSize];
		mIsVisitedList = new boolean[mSize];
		// Mark all the vertices as not visited
		for (int i = 0; i < mSize; i++) {
			mAdjacentList[i] = new ArrayList<Integer>(0);
			mIsVisitedList[i] = false;
		}
	}

	public void addEdge(int i, int j) {
		mAdjacentList[i].add(j);
	}

	private void DFSUtil(int vertex) {
		// Mark the current node as visited and print it
		mIsVisitedList[vertex] = true;
		System.out.println(vertex);

		// Recur for all the vertices adjacent to this vertex
		if (mAdjacentList[vertex].size() > 0) {
			int index = 0;
			while (index < mAdjacentList[vertex].size()) {
				int newVertexToCheck = mAdjacentList[vertex].get(index);
				if (!mIsVisitedList[newVertexToCheck]) {
					DFSUtil(newVertexToCheck);
				}
				index++;
			}
		}

	}

	public void printDFS() {
		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < mSize; i++) {
			if (!mIsVisitedList[i]) {
				DFSUtil(i);
			}
		}
	}

}
