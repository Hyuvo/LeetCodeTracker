import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //as eating time monotonely decreases as eating speed increases
        //need to get the min speed under constraint of h hours
        //so search the left bound of eating speed(to get longer eating time)
        long left = 1;
        long right = 1000000000;
        // for(int pile : piles) {
        //     if(pile > right) right = pile;
        // }
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (eatingTime(piles, mid) == h) {
                right = mid;
            } else if (eatingTime(piles, mid) < h) {
                right = mid;
            } else if (eatingTime(piles, mid) > h) {
                left = mid + 1;
            }
        }        
        return (int) left;
    }
    
    public long eatingTime(int[] piles, long speed) {
        long time = 0;
        for (long pile : piles) {
            time += pile / speed;
            if (pile % speed > 0) {
                time++;
            }
        }
        return time;
    }
}