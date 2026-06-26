class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Treating whole matrix as a 1Darray, and applying Binary Search
        // To find rowNo, colNo - mid / cols, mid % cols
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = (rows*cols)-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int rowNo = mid / cols, colNo = mid % cols;
            if(matrix[rowNo][colNo] == target)
                return true;
            else if(matrix[rowNo][colNo] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}
