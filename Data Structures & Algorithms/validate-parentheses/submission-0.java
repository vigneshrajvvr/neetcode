class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                braces.add(s.charAt(i));
            } else {
                if(braces.isEmpty()) {
                    return false;
                } 
                
                if(s.charAt(i) == ')' && braces.peek() != '(' ||
                   s.charAt(i) == '}' && braces.peek() != '{' ||
                   s.charAt(i) == ']' && braces.peek() != '[') {
                    return false;
                } 

                braces.pop();
            }
        }

        return braces.isEmpty();
    }
}
