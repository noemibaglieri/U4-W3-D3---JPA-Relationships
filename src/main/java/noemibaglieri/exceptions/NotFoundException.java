package noemibaglieri.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("I can't find this Event id (" + id + "). Try again");
    }
}
