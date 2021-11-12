public class DigitCount {


        static int digit_count(int n) {      // neden static // factorial de de static yazıyormuşuz
            if (n == 1)
                return 1;
             else
                return 1 + digit_count(n / 2);
    }


    public static void main(String[] args) {
        System.out.println( digit_count(45));
    }

}





