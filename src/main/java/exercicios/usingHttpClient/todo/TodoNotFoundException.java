package exercicios.usingHttpClient.todo;

public class TodoNotFoundException extends Throwable{
    public TodoNotFoundException(String message){
        super(message);
    }
}
