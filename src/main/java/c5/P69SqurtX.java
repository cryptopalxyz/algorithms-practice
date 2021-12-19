package c5;

public class P69SqurtX {
    public int mySqrt(int x) {
        //找最大的ans，满足ans*ans <=x
        //比如x=8， 0, 1, 2, 3, 4， 0*0<8, 1*1<8...为 1 1 1 0 0
        int left = 0;// 边界
        int right = x;//边界
        while (left < right ) {
            int mid = (left + right + 1 ) /2;
            if (mid <=x/mid) //为了避免int*int超出范围
                left = mid;
            else
                right = mid - 1;
        }
        return right;
    }

}
