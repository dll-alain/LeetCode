package indi.alain.Leetcode.onetoten;


/**
 * @author dll
 * @date 20220512
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        //快慢指针法
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

}
