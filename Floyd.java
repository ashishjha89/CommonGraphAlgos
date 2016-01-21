public class Floyd {
/*
 * 		int mat[][] = new int[4][4];
		mat[0][0] = 0;
		mat[0][1] = 999;
		mat[0][2] = 3;
		mat[0][3] = 999;
		
		mat[1][0] = 2;
		mat[1][1] = 0;
		mat[1][2] = 999;
		mat[1][3] = 999;
		
		mat[2][0] = 999;
		mat[2][1] = 7;
		mat[2][2] = 0;
		mat[2][3] = 1;
		
		mat[3][0] = 6;
		mat[3][1] = 999;
		mat[3][2] = 999;
		mat[3][3] = 0;
		
		new Floyd().printFloydMatrix(mat, 4);
 */
	public void printFloydMatrix(int[][] mat, int size) {
		int[][] floyd = mat;
		// FORM FLOYD MATRIX
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					floyd[i][j] = getSmaller(floyd[i][j], floyd[i][k]
							+ floyd[k][j]);
				}
			}
		}
		// DISPLAY FLOYD MATRIX
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(floyd[i][j] + "  ");
			}
		}
	}

	private int getSmaller(int i, int j) {
		return i < j ? i : j;
	}

}
