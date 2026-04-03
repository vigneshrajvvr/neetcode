class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> combinations = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();
        
        combinationSumHelper(0, 0, candidates, target, combinations, new ArrayList<>());

        for(List<Integer> list : combinations) {
            results.add(list);
        }

        return results;
    }

    private void combinationSumHelper(int index, int sum, int[] candidates, int target, Set<List<Integer>> combinations, List<Integer> currentCombination) {
        if(sum == target) {
            combinations.add(new ArrayList<>(currentCombination));
        }
        if(index == candidates.length) {
            return;
        }
        if(sum > target) {
            return;
        }
        
        currentCombination.add(candidates[index]);
        combinationSumHelper(index, candidates[index] + sum, candidates, target, combinations, currentCombination);

        currentCombination.remove(currentCombination.size() - 1);
        combinationSumHelper(index + 1, sum, candidates, target, combinations, currentCombination);
    }
}