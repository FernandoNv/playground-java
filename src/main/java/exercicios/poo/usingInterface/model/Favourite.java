package exercicios.poo.usingInterface.model;

public class Favourite {

    public void add(Audio audio){
        if(audio.getRate() >= 9 ){
            System.out.println("Great choice!!");
        }else{
            System.out.println("Good choice.");
        }
    }
}
