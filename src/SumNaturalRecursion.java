public class SumNaturalRecursion {
    public static void main(String[] args) {
        System.out.println(it(4));
        System.out.println(rec(4));


    }

    private static int rec(int n) {
        if(n==1){
            return 1;
        }
        return n+rec(n-1);

    }

    private static int it(int n) {
        int result=0;
        for(int i=1;i<=n;i++){
            result+=i;

        }
        return result;
    }

}
