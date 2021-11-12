public class reverseArrayExample {


    static  public void reverse(int[] a) {
        for(int i = 0; i < a.length/2; i++)
        {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }

    }

    public static void main(String[] args) {
      /*  int array[] = {1,2,3,4,5};
        reverse(array);
        for (int element: array) {
            System.out.println(element);
        }*/
        int a = 3, b = 5, c;
        c = a++ + b; //a++ ve +aa farkını öğren
        System.out.println("a: " + a); // a: 4
        System.out.println("b: " + b); // b: 5
        System.out.println("c: " + c); // c: 8
    }
}



