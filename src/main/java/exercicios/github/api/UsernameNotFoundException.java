package exercicios.github.api;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message){
        super(message);
    }
}
