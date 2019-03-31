package pl.academy.code.gui;

import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Scanner;

public class Menu {
    /*
    1. Dodaj ksiazke
    2. Wyswietl ksiazki
    3. sortuj po nazwie
    4. po cenie
    5. po stronach
         */

    public static void helloMenu() {
        do {

            System.out.println("1. Dodaj książkę");
            System.out.println("2. Wyświetl książki");
            System.out.println("3. Sortuj po nazwie");
            System.out.println("4. Sortuj po cenie");
            System.out.println("5. Sortuj po ilości stron");
            System.out.println("6. Koniec");

            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    Menu.loadBook();
                    break;
                case 2:
                    BookRepository.getBookRepositoryInstance().printBooks();
                    break;
                case 3:
                    BookRepository.getBookRepositoryInstance().sortBooksByTitle();
                    break;
                case 4:
                    BookRepository.getBookRepositoryInstance().sortBooksByPrice();
                    break;
                case 5:
                    BookRepository.getBookRepositoryInstance().sortBooksByPages();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public static void loadBook() {
        System.out.println("Podaj tytuł:");

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("Podaj liczbę stron:");
        int pages = -1;
        boolean flag = true;
        while (flag) {
            try {
                pages = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException numberFormatEx) {
                numberFormatEx.printStackTrace();
                System.out.println("Podaj liczbę stron (nieprawiłowa ilość):");
            }
        }

        System.out.println("Podaj cenę:");

        double price = Double.parseDouble(scanner.nextLine());

        try {
            BookRepository.getBookRepositoryInstance()
                    .addBook(new Book(title, pages, price));
        } catch (IdiotBookNameException | NotEnoughPagesException e) {
            System.out.println(e.getMessage());
        }
    }
}
