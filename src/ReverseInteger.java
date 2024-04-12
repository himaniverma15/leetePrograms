public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        int reversedNumber = 0;
        while (x != 0) {
            reversedNumber = reversedNumber * 10 + (x % 10);
            x = x / 10;
        }
        reversedNumber = (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE) ? 0 : (int) reversedNumber;
        System.out.println(reversedNumber);
    }
}