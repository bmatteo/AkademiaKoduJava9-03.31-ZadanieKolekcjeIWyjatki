package pl.academy.code;

import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.experyment.ExpClass;
import pl.academy.code.gui.Menu;
import pl.academy.code.model.Book;

public class Main {
    public static void main(String[] args) {
        //Menu.helloMenu();
        try {
            Book book = new Book("", 234, 44);
        } catch (IdiotBookNameException | NotEnoughPagesException e) {
            System.out.println(e.getMessage());
        }

    }
}
