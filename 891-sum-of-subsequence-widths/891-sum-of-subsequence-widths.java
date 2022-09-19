class Solution {
    long Mod=1000000007L;
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long ans=0;
        int lo=0;
        int hi=nums.length-1;
        long pow=1;
        while(lo<nums.length&&hi>=0){
            ans=(ans+pow*nums[lo]-pow*nums[hi])%Mod;
            lo++;
            hi--;
            pow=(pow*2)%Mod;
        }
        return (int)ans;
    }
}