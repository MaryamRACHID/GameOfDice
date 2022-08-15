package businessObjects;

public class Message {

    //attributs
    private String text;




    //Constructeur
    public Message() {

    }

    public Message(String text) {
        super();
        this.text = text;
    }


    //toString Overriding
    @Override
    public String toString() {
        return text;
    }


    //Getter&Setter
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
