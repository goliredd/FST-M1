package Activities;

class CustomException extends Exception{
    private String message = null;
    public CustomException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
public class Activity8 {
    public static void main(String[] args) {
    try{
        Activity8.exceptionTest("Will print to console");
        Activity8.exceptionTest(null);
        } catch(CustomException CE){
        System.out.println(CE.getMessage());
    }
    }
    static void exceptionTest(String s) throws CustomException {
        if (s == null) {
            throw new CustomException("String is Null");
        } else {
            System.out.println(s);
        }
    }
}