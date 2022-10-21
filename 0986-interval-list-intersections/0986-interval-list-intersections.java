class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        LinkedList<int[]> result = new LinkedList();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            // if intersect
            if (a2 >= b1 && b2 >= a1) {
                int start = Math.max(a1, b1);
                int end = Math.min(a2, b2);
                result.add(new int[]{start, end});
            }
            // move the point that is left behind
            if (a2 > b2) {
                ++j;
            } else {
                ++i;
            }
        }
        return result.toArray(new int[0][0]);
    }
}