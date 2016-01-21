public class Warshall {
/*
 * 		int mat[][] = new int[4][4];
		mat[0][0] = 0;
		mat[0][1] = 1;
		mat[0][2] = 0;
		mat[0][3] = 0;
		
		mat[1][0] = 0;
		mat[1][1] = 0;
		mat[1][2] = 0;
		mat[1][3] = 1;
		
		mat[2][0] = 0;
		mat[2][1] = 0;
		mat[2][2] = 0;
		mat[2][3] = 0;
		
		mat[3][0] = 1;
		mat[3][1] = 0;
		mat[3][2] = 1;
		mat[3][3] = 0;
		
		new Warshall().printWarshallMatrix(mat, 4);
 */
	public void printWarshallMatrix(int[][] mat, int size) {
		int[][] warshall = mat;
		// FORM WARSHALL MATRIX
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					warshall[i][j] = (warshall[i][j] | warshall[i][k]
							& warshall[k][j]);
				}
			}
		}
		// DISPLAY WARSHALL MATRIX
		for(int i=0;i<size;i++){
			System.out.println();
			for(int j=0;j<size;j++){
				System.out.print(warshall[i][j] + "  ");
			}
		}
	}

}
