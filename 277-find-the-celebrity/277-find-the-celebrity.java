/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
// The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.
public class Solution extends Relation {
    public int findCelebrity(int n) {
        // 0-indexed
        // find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense)
        // Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
        
        // assume 0 is the celebrity
        int candidate = 0;
        for (int other = 1; other < n; other++) {
            if (knows(candidate, other) || !knows(other, candidate)) {
                candidate = other;
            }
        }
        
        // check if the candidate is celebrity
        for (int other = 0; other < n; other++) {
            if (other == candidate) {
                continue;
            }
            // not a celebrity
            if (knows(candidate, other) || !knows(other, candidate)) {
                return - 1;
            }
        }
        
        return candidate;
    }
}