package Activities;

 abstract class Book{
     String Title;
     abstract void setTitle(String s);
     String getTitle(){
         return Title;
     }
 }
 class MyBook extends Book{
     @Override
     public void setTitle(String s) {
        Title = s;
     }
 }

public class Activity5 {
     public static void main(String[] args){
         String Title = "This is a new book";
         MyBook newNovel = new MyBook();
         newNovel.setTitle(Title);
         System.out.println("The title is: " +newNovel.getTitle());
     }
}
