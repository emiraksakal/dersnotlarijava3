public class GlobalVariable {
    static int day=365; // static koymazsan algılamaz

    public static void main(String[] args) {

       // System.out.println(day);
        int sum=0;
        for (int i=32;i>=1;i/=2){
            for (int j=32;j>=1;j--){
                sum++;
            }
        } System.out.println(sum);
    }
}
