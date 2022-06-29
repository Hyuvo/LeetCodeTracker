class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int weight : weights) {
            //the min cap must be at least the max weight
            left = weight > left ? weight : left;
            //ship all weights in 1 day
            right += weight;
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(shipTime(weights, mid) == days) {
                right = mid - 1;
            } else if (shipTime(weights, mid) > days) {
                left = mid + 1;
            } else if (shipTime(weights, mid) < days) {
                right = mid - 1;
            }
        }
        
        return left;
        
    }
    
    public int shipTime(int[] weights, int capacity) {
        int shipTime = 0;
        for(int i = 0; i < weights.length;) {
            //init a cap for a day
            int dayCap = capacity;
            //if there're packs to load, keep loading
            while(i < weights.length) {
                //if exeed the daily cap, end the day
                if(dayCap < weights[i]) {
                    break;
                } else { //keep loading the boat for today
                    dayCap -= weights[i];
                    ++i;
                }                    
            }
            shipTime++;
        }
        return shipTime;
    }
}