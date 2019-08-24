//  判断分数排等级



class Love2
{
        public static void main(String[] args)
       {    String result = adb((int)99.11); 
            System.out.println(" 对应的等级是: "+ result);
        }
        public static String adb(int abcc){
               String adb = "";//用于储存对应的等级
                if(abcc>=90 && abcc<=100)
                 {     
                 adb = "A等级";
                 }else  if(abcc>=80 && abcc<=89)
                 {
                 adb = "B等级";
                 }else  if(abcc>=70 && abcc<=79)
                 {
                  adb = "C等级";
                 
                  }else  if(abcc>=60 && abcc<=69)
                 {
                  adb = "D等级";
                  } return adb ;                           
         }
}