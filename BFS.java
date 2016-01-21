import java.util.ArrayList;
/*
 *       BFS bfs = new BFS(4);
		 bfs.addEdge(0, 1);
		 bfs.addEdge(0, 2);
		 bfs.addEdge(1, 2);
		 bfs.addEdge(2, 0);
		 bfs.addEdge(2, 3);
		 bfs.addEdge(3, 3);

		 bfs.printBFS(2);
 */
public class BFS {

	private ArrayList<Integer>[] mAdjacentList;
	private boolean[] mIsVisitedList;
	private int[] mBFSQueue;
	private int mSize;
	private int mQueueRearIndex;

	BFS(int size) {
		mSize = size;
		mAdjacentList = new ArrayList[mSize];
		mIsVisitedList = new boolean[mSize];
		mBFSQueue = new int[mSize];
		mQueueRearIndex = -1;
		// Mark all the vertices as not visited
		for (int i = 0; i < mSize; i++) {
			mAdjacentList[i] = new ArrayList<Integer>(0);
			mIsVisitedList[i] = false;
		}
	}

	public void addEdge(int i, int j) {
		mAdjacentList[i].add(j);
	}

	public void printBFS(int startVertex) {
		mIsVisitedList[startVertex] = true;
		mBFSQueue[++mQueueRearIndex] = startVertex;
		while (mQueueRearIndex >= 0) {
			int vertex = mBFSQueue[mQueueRearIndex--];
			System.out.println(vertex);
			if (mAdjacentList[vertex].size() > 0) {
				int index = 0;
				while (index < mAdjacentList[vertex].size()) {
					int newVertexToCheck = mAdjacentList[vertex].get(index);
					if (!mIsVisitedList[newVertexToCheck]) {
						mIsVisitedList[newVertexToCheck] = true;
						mBFSQueue[++mQueueRearIndex] = newVertexToCheck;
					}
					index++;
				}
			}
		}
	}

}
