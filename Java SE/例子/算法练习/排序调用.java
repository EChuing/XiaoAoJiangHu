import java.util.*;// �����ļ��� Arrays
class szgj2
{
   public static void main(String[] args)
   {
      int[] arr = {2, 45, 78, 30, 55, 11, 6,14};

      Arrays.sort(arr);//����

      int index = Arrays.binarySearch(arr, 14);//���ֲ��ҷ�

      //�������
      String info = Arrays.toString(arr);
      System.out.println("����Ԫ�أ�"+ info+ "���ֲ���ֵΪ��"+ index);
       
   }
}//���� ����ʱ ��Ҫʹ�� ֻ������д��
