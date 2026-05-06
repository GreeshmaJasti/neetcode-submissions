class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();

        for(int i = 0; i < m; i++){
            int start = matrix[i][0], end = matrix[i][n-1];
            if(target == start || target == end)
                return true;
            else if(target > start && target < end){
                for(int j = 0; j < n; j++){
                    if(target == matrix[i][j])
                        return true;
                }
                return false;
            }
        }
        return false;
    }
};
