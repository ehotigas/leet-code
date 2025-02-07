public class Problem9 {
    public static boolean isPalindrome(int x) {
        String out = "";
        String xString = Integer.toString(x);
        for (int idx = 0; idx < xString.length(); idx++) {
            out += xString.charAt((xString.length() - 1) - idx);
        }
        return out.equals(xString);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
