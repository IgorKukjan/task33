package by.task.kukjan.exception;

public class PaperException extends Exception{
    public PaperException(){
        super();
    }

    public PaperException(String message){
        super(message);
    }

    public PaperException(Exception e) {
        super(e);
    }

    public PaperException(String message, Exception e) {
        super(message, e);
    }
}
