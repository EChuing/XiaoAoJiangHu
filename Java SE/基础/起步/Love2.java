//  �жϷ����ŵȼ�



class Love2
{
        public static void main(String[] args)
       {    String result = adb((int)99.11); 
            System.out.println(" ��Ӧ�ĵȼ���: "+ result);
        }
        public static String adb(int abcc){
               String adb = "";//���ڴ����Ӧ�ĵȼ�
                if(abcc>=90 && abcc<=100)
                 {     
                 adb = "A�ȼ�";
                 }else  if(abcc>=80 && abcc<=89)
                 {
                 adb = "B�ȼ�";
                 }else  if(abcc>=70 && abcc<=79)
                 {
                  adb = "C�ȼ�";
                 
                  }else  if(abcc>=60 && abcc<=69)
                 {
                  adb = "D�ȼ�";
                  } return adb ;                           
         }
}