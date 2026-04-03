class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> generatedParenthesis = new ArrayList<>();
        Queue<String> generations = new LinkedList<>();
        generations.add("(");
        generations.add(")");

        for(int i = 1; i < n + n; i++) {
            int size = generations.size();
            for(int j = 0; j < size; j++) {
                String currentParenthesis = generations.remove();
                generations.add(currentParenthesis + "(");
                generations.add(currentParenthesis + ")");
            }
        }

        for(String currentGenerated : generations) {
            if(currentGenerated.charAt(0) == ')') {
                continue;
            }
            if(isValid(currentGenerated)) {
                generatedParenthesis.add(currentGenerated);
            }
        }

        return generatedParenthesis;
    }

    private boolean isValid(String currentGenerated) {
        int open = 0;

        for(int i = 0; i < currentGenerated.length(); i++) {
            if(currentGenerated.charAt(i) == '(') {
                open++;
            } else {
                if(open == 0) {
                    return false;
                }
                open--;
            }
        }

        return open == 0 ? true : false;
    }
}

// ( )
// (( () )( ))
// 