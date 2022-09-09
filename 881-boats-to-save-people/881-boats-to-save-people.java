class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int li=0;
        int ri=people.length-1;
        while(li<=ri){
            if(people[li]+people[ri]<=limit){
                ans++;
                li++;
                ri--;
            }
            else if(people[ri]<=limit){
                ans++;
                ri--;
            }
            else{
                li++;
            }
        }
        return ans;
    }
}