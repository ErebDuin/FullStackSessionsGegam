package Session10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String book) {
        if (book != null && !book.isEmpty()) {
            this.books.add(book);
            System.out.println("Book " + book + " added to the Library");
        }
        else {
            System.out.println("Book name is invalid");
        }
    }

    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void displayBooks() {
        for (String book : books) {
            System.out.println("List of books: " + book);
        }
    }
}
