class Solution {
    public int longestConsecutive(int[] nums) {
        // num, {lowerlength, upperlength}
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for(int num:nums){
            map.put(num, new Integer[]{0, 0});
        }
        int max = 0;
        HashSet<Integer> covered = new HashSet<>();
        for(Map.Entry<Integer, Integer[]> row: map.entrySet()){
            int key = row.getKey();
            Integer[] value = row.getValue();
            if(!covered.contains(key)){
                covered.add(key);
                while(map.containsKey(key+value[1]+1)){
                    value[1]++;
                    covered.add(key+value[1]+1);
                }
                while(map.containsKey(key-value[0]-1)){
                    value[0]++;
                    covered.add(key-value[0]-1);
                }
            }
            int length = value[0] + value[1] + 1;
            if(max<length){
                max = length;
            }
        }
        return max;
    }
}