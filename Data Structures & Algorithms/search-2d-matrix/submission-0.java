class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowPossibility = -1;
        int start = 0;
        int end = matrix.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                rowPossibility = mid;
                break;
            } else if(target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(rowPossibility == -1) {
            return false;
        }

        start = 0;
        end = matrix[rowPossibility].length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(target == matrix[rowPossibility][mid]) {
                return true;
            } else if(target < matrix[rowPossibility][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}