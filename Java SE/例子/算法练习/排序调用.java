import java.util.*;// 导入文件包 Arrays
class szgj2
{
   public static void main(String[] args)
   {
      int[] arr = {2, 45, 78, 30, 55, 11, 6,14};

      Arrays.sort(arr);//排序

      int index = Arrays.binarySearch(arr, 14);//二分查找法

      //数组遍历
      String info = Arrays.toString(arr);
      System.out.println("数组元素："+ info+ "二分查找值为："+ index);
       
   }
}//笔试 或考试时 不要使用 只能用手写的
