class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //as eating time monotonely decreases as eating speed increases
        //need to get the min speed under constraint of h hours
        //so search the left bound of eating speed(to get longer eating time)
        // using long to prevent from exceeding
        int left = 1, right = 1000000000 + 1;//[left, right)
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (eatingTime(piles, mid) == h) {
                right = mid;
            } else if (eatingTime(piles, mid) < h) {
                // eat too fast
                right = mid;
            } else if (eatingTime(piles, mid) > h) {
                // eat too slowly
                left = mid + 1;
            }
        }
        return (eatingTime(piles, left) > h) ? -1 : left;
    }
    
    public int eatingTime(int[] piles, int speed) {
        int time = 0;
        for(int pile : piles) {
            time += pile / speed;
            if (pile % speed > 0) {
                time++;
            }
        }
        return time;
    }
}