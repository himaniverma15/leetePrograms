package backtracking;

// Java program to print all permutations of a
// given string.
public class Permutation {

    // Function call
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permute(str, 0, n - 1);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                System.out.println("before first swap");
                str = swap(str, l, i);
                System.out.println("after first swap " + str);
                permute(str, l + 1, r);
                System.out.println("after permute");

                str = swap(str, l, i);
                System.out.println("after sec swap"+ str);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

// This code is contributed by Mihir Joshi
