package common;


/*

arr[i] 值为元素
ind[i] 为下标

 */
public class IndexAsElement {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        int[] ind = new int[n];

        for (int i=0;i<n;i++)
            arr[i]=i;

        for (int i=0;i<n;i++)
            ind[i]=i;

        for (int i=0;i<n;i++) {
            System.out.println(arr[i] - ind[i]);
            System.out.println(arr[i]);
            System.out.println(arr[ind[i]] );
        }
    }
}
