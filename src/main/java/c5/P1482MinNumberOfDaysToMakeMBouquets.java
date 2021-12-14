package c5;

public class P1482MinNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int latestBloomDay = 0;
        for (int bloom: bloomDay)
            latestBloomDay = Math.max(latestBloomDay, bloom);
        int left = 0;
        int right = latestBloomDay + 1;// why?

        while (left < right) {
            int mid = (left + right) /2;
            if (validate(bloomDay, m, k, mid))
                right = mid; //因为要天数小为最佳
            else
                left = mid  + 1;
        }

        if (right == latestBloomDay + 1) return  -1;
        return right;
    }

    boolean validate(int[] bloomDay, int m, int k, int now) {
        int bouquet = 0;
        int consecutive = 0;//连续的
        for (int bloom: bloomDay) {
            if (bloom <= now) {
                consecutive ++ ;
                if (consecutive == k) { //可以扎一束花
                    bouquet ++;
                    consecutive = 0;
                }

            }else {
                consecutive = 0; //不连续，清0

            }
        }

        return bouquet >= m;
    }
}
class SolutionP1482 {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,12,7,7};
        P1482MinNumberOfDaysToMakeMBouquets p = new P1482MinNumberOfDaysToMakeMBouquets();
        p.minDays(nums, 2, 3);

    }
}
