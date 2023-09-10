import java.util.ArrayList;

interface Displayable {
    void displayInfo();
}

interface Searchable {
    void searchByAuthor(String authorName);
}

interface Availability {
    boolean isAvailable();
}

interface TitleAuthor {
    String getTitle();
    String getAuthor();
}

interface LibraryOperations {
    void addBook(Book book);
    void removeBook(Book book);
    void displayAvailableBooks();
}

class Book implements Displayable, TitleAuthor, Availability {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void displayInfo() {
        System.out.println("Название: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Доступность: " + (isAvailable() ? "Доступна" : "Недоступна"));
    }
}

class Library implements LibraryOperations, Searchable {
    private ArrayList<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        catalog.add(book);
    }

    @Override
    public void removeBook(Book book) {
        catalog.remove(book);
    }

    @Override
    public void displayAvailableBooks() {
        System.out.println("Доступные книги в библиотеке:");
        for (Book book : catalog) {
            if (book.isAvailable()) {
                book.displayInfo();
            }
        }
    }

    @Override
    public void searchByAuthor(String authorName) {
        System.out.println("Книги автора " + authorName + " в каталоге библиотеки:");
        for (Book book : catalog) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                book.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Лев Толстой");
        Book book2 = new Book("Преступление и наказание", "Федор Достоевский");
        Book book3 = new Book("Гарри Поттер и философский камень", "Джоан Роулинг");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        book1.setAvailable(false);

        library.displayAvailableBooks();
        System.out.println();

        library.searchByAuthor("Лев Толстой");
    }
}
