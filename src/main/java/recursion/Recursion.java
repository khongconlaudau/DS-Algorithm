package recursion;

public class Recursion {
    public static void main(String[] args) {
        printPattern(1);
    }

    public static void printPattern(int n){
        if (n==6) return;

        for(int i=0; i<n; i++){
            System.out.print("*");
        }
        System.out.println();
        printPattern(n+1);
    }
}
