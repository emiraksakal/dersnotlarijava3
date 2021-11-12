public class Ayşe {
    public static void main(String[] args) {
        int sum=0;
        for (int i=1;i<=1000;i++) {
            sum= sum+ i;
        }
        System.out.println(sum);
        deneme(10);
    }

    static void deneme(int x) {
        if (x%2==0) {
            System.out.println("2böl");
        }
        if (x%5==0) {
            System.out.println("5böl");
        }
        if (x%10==0) {
            System.out.println("10böl");
        }

    }
}
