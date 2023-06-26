
public class 2020b96-Qs{

  
//q1 - maxSumKnight
public static int maxSumKnight(int[][] mat){
    boolean[][] visited = new boolean[mat.length][mat.length]; //make a boolean copy of mat to track visited cells
    int first_value = mat[0][0]; //value of starting point
	return maxSumKnight(mat,0,0,0, visited,first_value); //overload
}
  
public static int maxSumKnight(int[][] mat, int i, int j, int sum, boolean[][] visited, int last_value){

	if (i>mat.length-1 || j>mat[0].length-1 || i<0 || j<0) //if out of bounds
		return Integer.MIN_VALUE;

    int current_value = mat[i][j];
    if (visited[i][j] || Math.abs(current_value-last_value)>1){ //check if a visited cell or if the difference between values is above 1 
        return Integer.MIN_VALUE;
    }

	if (i==mat.length-1 && j==mat[0].length-1){ //if end of mat
		return sum+mat[i][j];
    }

    visited[i][j] = true; //mark visited cell as true
    last_value = mat[i][j];//current value to pass into the recursion
  
  //simplification of the knight moves - knight has 8 moves max. 2 north-west, 2 north-east, 2 south-west, 2 south-east.
	int northWestPaths = Math.max(maxSumKnight(mat, i-1, j-2, sum+mat[i][j],visited, last_value), maxSumKnight(mat, i-2, j-1, sum+mat[i][j], visited, last_value));

	int northEastPaths = Math.max(maxSumKnight(mat, i-2, j+1, sum+mat[i][j],visited, last_value), maxSumKnight(mat, i-1, j+2, sum+mat[i][j], visited, last_value));

	int southWestPaths = Math.max(maxSumKnight(mat, i+1, j-2, sum+mat[i][j], visited, last_value), maxSumKnight(mat, i+2, j-1, sum+mat[i][j], visited, last_value));

	int southEastPaths = Math.max(maxSumKnight(mat, i+2, j+1, sum+mat[i][j], visited, last_value), maxSumKnight(mat, i+1, j+2, sum+mat[i][j], visited, last_value));
  
  //find max sum between all paths
	return Math.max(Math.max(northWestPaths, northEastPaths),Math.max(southWestPaths, southEastPaths));
  }
  // I am sure there is a way to do it without the boolean[][] visited. Happy for any suugestions. 
}
