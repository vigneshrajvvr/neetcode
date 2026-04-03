class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2Helper(candidates, target, 0, new ArrayList<>(), results);

        Set<List<Integer>> uniqueCombinations = new HashSet<>();

        for(List<Integer> combination : results) {
            uniqueCombinations.add(new ArrayList<>(combination));
        }

        results = new ArrayList<>();

        for(List<Integer> uniqueCombination : uniqueCombinations) {
            results.add(uniqueCombination);
        }

        return results;
    }

    private void combinationSum2Helper(int[] candidates, int target, int index, List<Integer> currentCombination, List<List<Integer>> results) {
        if(target == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        } else if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, currentCombination, results);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}