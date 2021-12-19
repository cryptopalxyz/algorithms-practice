package c5;

public class DoubleSqurtx {
    public double mySqrt(double x) {
        //找最大的ans，满足ans*ans <=x
        //比如x=8， 0, 1, 2, 3, 4， 0*0<8, 1*1<8...为 1 1 1 0 0
        double left = 0;// 边界
        double right = x;//边界
        while (right - left > 1e-7   ) {
            double mid = (left + right  ) /2;
            if (mid*mid <=x)
                left = mid;  //不必要+1
            else
                right = mid; //不必要-1
        }
        return right;
    }

}
