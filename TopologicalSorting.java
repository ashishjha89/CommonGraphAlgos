import java.util.ArrayList;
/*
 * 		TopologicalSorting topologicalSorting = new TopologicalSorting(6);
		topologicalSorting.addEdge(5, 2);
		topologicalSorting.addEdge(5, 0);
		topologicalSorting.addEdge(4, 0);
		topologicalSorting.addEdge(4, 1);
		topologicalSorting.addEdge(2, 3);
		topologicalSorting.addEdge(3, 1);

		topologicalSorting.printTopologicalSorting();
 */
public class TopologicalSorting {

	private ArrayList<Integer>[] mAdjacentList;
	private boolean[] mIsVisitedList;
	private int[] mTopologicalStack;
	private int mStackIndex;
	private int mSize;

	TopologicalSorting(int size) {
		mSize = size;
		mAdjacentList = new ArrayList[mSize];
		mIsVisitedList = new boolean[mSize];
		mTopologicalStack = new int[mSize];
		mStackIndex = 0;
		// Mark all the vertices as not visited
		for (int i = 0; i < mSize; i++) {
			mAdjacentList[i] = new ArrayList<Integer>(0);
			mIsVisitedList[i] = false;
		}
	}

	public void addEdge(int i, int j) {
		mAdjacentList[i].add(j);
	}

	private void TopologicalSortingUtil(int vertex) {
		// Mark the current node as visited and print it
		mIsVisitedList[vertex] = true;

		// Recur for all the vertices adjacent to this vertex
		if (mAdjacentList[vertex].size() > 0) {
			int index = 0;
			while (index < mAdjacentList[vertex].size()) {
				int newVertexToCheck = mAdjacentList[vertex].get(index);
				if (!mIsVisitedList[newVertexToCheck]) {
					TopologicalSortingUtil(newVertexToCheck);
				}
				index++;
			}
		}

		// Push current vertex to stack which stores result
		mTopologicalStack[mStackIndex++] = vertex;

	}

	public void printTopologicalSorting() {
		// Call the recursive helper function to store Topological Sort
		// starting from all vertices one by one
		for (int i = 0; i < mSize; i++) {
			if (!mIsVisitedList[i]) {
				TopologicalSortingUtil(i);
			}
		}

		// Print contents of stack
		for (int i = mStackIndex - 1; i >= 0; i--) {
			System.out.println(mTopologicalStack[i]);
		}

	}

}
