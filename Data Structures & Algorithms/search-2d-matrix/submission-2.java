class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowNo = 0;

        for(int i = 0; i < rows; i++){
            if(matrix[i][0] <= target && target <= matrix[i][cols-1]){
                rowNo = i;
                break;
            }
        }

        for(int i = 0; i < cols; i++){
            if(target == matrix[rowNo][i])
                return true;
        }
        return false;
    }
}
