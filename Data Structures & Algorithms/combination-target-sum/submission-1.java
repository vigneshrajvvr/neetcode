class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        combinationSumHelper(0, candidates, target, new ArrayList<>(), results);

        return results;
    }

    private void combinationSumHelper(int index, int[] candidates, int target, List<Integer> currentCombination, List<List<Integer>> results) {
        if(target == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            combinationSumHelper(i, candidates, target - candidates[i], currentCombination, results);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }
}