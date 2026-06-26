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

        int low = 0, high = cols-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(matrix[rowNo][mid] == target)
                return true;
            else if(matrix[rowNo][mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}
