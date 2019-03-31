package pl.academy.code.data;

import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookRepository {
    private List<Book> bookRepository = new LinkedList<>();
    private static BookRepository repositoryInstance = null;

    private BookRepository() {
        try {
            this.bookRepository.add(new Book("Pan Tadeusz", 400, 40.00));
            this.bookRepository.add(new Book("W pustyni i w puszczy", 350, 37.99));
            this.bookRepository.add(new Book("Thinking In Java", 1300, 99.99));
            this.bookRepository.add(new Book("Java w 21 dni", 250, 31.99));
            this.bookRepository.add(new Book("Ogniem i mieczem", 400, 37.99));
        } catch (IdiotBookNameException | NotEnoughPagesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Book book) {
        this.bookRepository.add(book);
    }

    public void printBooks() {
        System.out.println(this.bookRepository);
    }

    public static BookRepository getBookRepositoryInstance() {
        if(BookRepository.repositoryInstance == null) {
            BookRepository.repositoryInstance = new BookRepository();
        }

        return BookRepository.repositoryInstance;
    }

    public void sortBooks(Comparator c) {
        this.bookRepository.sort(c);
    }

    public void sortBooksByPages() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if(!(o instanceof Book)) {
                    return -1;
                }

                if(!(t1 instanceof Book)) {
                    return -1;
                }

                return ((Book) o).getPages() - ((Book) t1).getPages();
            }
        };

        this.bookRepository.sort(c);
    }

    public void sortBooksByPrice() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if(!(o instanceof Book)) {
                    return -1;
                }

                if(!(t1 instanceof Book)) {
                    return -1;
                }

                return (int) ((((Book) o).getPrice() - ((Book) t1).getPrice()) * 100);
            }
        };

        this.bookRepository.sort(c);
    }

    public void sortBooksByTitle() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if(!(o instanceof Book)) {
                    return -1;
                }

                if(!(t1 instanceof Book)) {
                    return -1;
                }

                return ((Book) o).getTitle().compareTo(((Book) t1).getTitle());
            }
        };

        this.bookRepository.sort(c);
    }
}
