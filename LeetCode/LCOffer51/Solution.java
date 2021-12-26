package cn.delingw.LeetCode.LCOffer51;

import java.util.Arrays;

/**
 * @author delingw
 * @version 1.0
 * 剑指offer、51 数组中的逆序对
 * 解法一、暴力解法  两个for循环   时间复杂度 O(n^2)  超时
 * 解法二、利用归并排序  时间复杂度O(nlogn)
 *  解释: (从小到大)我们知道我们在归并的过程中,左边区间的值 如果比右边区间的值小 那么就构不成逆序,但是如果右边区间的值比左边区间的值还要小,那么那些还没有被归并的数值,则就构成了逆序
 * 举例:
 * i指针指向左边区间索引为1的位置,其中值为nums[1]=2,而j指针指向右边区间索引为mid+1的位置,其中nums[mid+1]=1,i和j相比,arr[1]>arr[mid+1],那么它的逆序数则为(mid-i+1)
 * 这里加1是因为我用的左闭右闭。
 * 不要考虑j-i+1 你记住->合并的是两个有序的区间
 */

/**
 * 暴力解法 O(n^2)
 */
//class Solution {
//    //0 <= 数组长度 <= 50000   一个25亿的数据,肯定是要很久的
//    private int resNums = 0;
//
//    public int reversePairs(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    resNums++;
//                }
//            }
//        }
//        return resNums;
//    }
//}

/**
 * 解法二 归并排序解法  O(nlogn)
 */
public class Solution {
    public int reversePairs(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        return sort(nums, 0, nums.length - 1, tmp);
    }


    private int sort(int[] nums, int l, int r, int[] tmp) {
        if (l >= r) {
            return 0;
        }
        // 考虑溢出 加法变减法
        int mid = l + (r - l) / 2;
        int resNums = 0;
        // 两个递归
        // 左边
        resNums += sort(nums, l, mid, tmp);
        //右边
        resNums += sort(nums, mid + 1, r, tmp);
        // 左边的小于右边的则不用合并
        if (nums[mid] > nums[mid + 1]) {
            resNums += merge(nums, l, mid, r, tmp);
        }
        return resNums;
    }

    // 合并
    private int merge(int[] nums, int l, int mid, int r, int[] tmp) {
        // 左闭右闭
        System.arraycopy(nums, l, tmp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        int resNums = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = tmp[j];
                j++;
            } else if (j > r) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                resNums += mid - i + 1;
                nums[k] = tmp[j];
                j++;
            }

        }
        return resNums;
    }
}
