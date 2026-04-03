class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String currentString : strs) {
            encodedString.append(currentString);
            encodedString.append("ñ");
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        String[] decodedString = str.split("ñ", -1);
        List<String> result = new ArrayList<>();

        for(String decode : decodedString) {
            result.add(decode);
        }

        result.remove(result.size() - 1);
        return result;
    }
}
