package pl.academy.code.exceptions;

public class IdiotBookNameException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Tytuł książki jest głupi !!";
    }
}
