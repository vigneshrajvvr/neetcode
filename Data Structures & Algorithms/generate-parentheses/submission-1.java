class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> generatedParenthesis = new ArrayList<>();
        generateValidParenthesis("", n, generatedParenthesis, 0, 0);
        return generatedParenthesis;
    }

    private void generateValidParenthesis(String currentParenthesis, int n, List<String> generatedParenthesis, int open, int closed) {
        if(currentParenthesis.length() == n + n) {
            generatedParenthesis.add(currentParenthesis);
            return;
        }

        if(open < n) {
            generateValidParenthesis(currentParenthesis + "(", n, generatedParenthesis, open + 1, closed);
        }

        if(open > closed) {
            generateValidParenthesis(currentParenthesis + ")", n, generatedParenthesis, open, closed + 1);
        }
    }
}