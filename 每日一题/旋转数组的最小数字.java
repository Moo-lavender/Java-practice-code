/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null) return 0;
        int left = 0,right = array.length - 1;
        int mid = (left + right) >> 1;
        while (left < right){
            mid = (left + right) >> 1;
            if (right - left == 1) return array[right];
            
            //如果都相等就要进行线性探测
            if (array[left] == array[mid] && array[mid] == array[right]) {
               int min = array[left];
                for (int i = left + 1; i < right; i ++) {
                    min = array[i] < min ? array[i] : min;
                }
                return min;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }
}