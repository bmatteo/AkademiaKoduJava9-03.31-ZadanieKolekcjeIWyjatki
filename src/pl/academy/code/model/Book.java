package pl.academy.code.model;

import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;

public class Book {
    private String title;
    private int pages;
    private double price;

    public Book(String title, int pages, double price) throws IdiotBookNameException,
            NotEnoughPagesException {
        if(title.equals("")) {
            throw new IdiotBookNameException();
        }

        if(pages < 4) {
            throw new NotEnoughPagesException();
        }

        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
