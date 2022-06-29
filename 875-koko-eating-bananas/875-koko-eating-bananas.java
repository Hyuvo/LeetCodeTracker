import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //as eating time monotonely decreases as eating speed increases
        //need to get the min speed under constraint of h hours
        //so search the left bound of eating speed(to get longer eating time)
        int left = 1;
        int right = 1000000000 + 1;
        // for(int pile : piles) {
        //     if(pile > right) right = pile;
        // }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (eatingTime(piles, mid) == h) {
                right = mid;
            } else if (eatingTime(piles, mid) < h) {
                right = mid;
            } else if (eatingTime(piles, mid) > h) {
                left = mid + 1;
            }
        }        
        return left;
    }
    
    public int eatingTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += pile / speed;
            if (pile % speed > 0) {
                time++;
            }
        }
        return time;
    }
}