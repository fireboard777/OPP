public class task3 {
    import java.util.ArrayList;

    class Book {
        private String title;
        private String author;
        private boolean available;
    
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public void setAuthor(String author) {
            this.author = author;
        }
    
        public boolean isAvailable() {
            return available;
        }
    
        public void setAvailable(boolean available) {
            this.available = available;
        }
    
        public void displayInfo() {
            System.out.println("Название: " + title);
            System.out.println("Автор: " + author);
            System.out.println("Доступность: " + (available ? "Доступна" : "Недоступна"));
        }
    }
    
    class Library {
        private ArrayList<Book> catalog;
    
        public Library() {
            catalog = new ArrayList<>();
        }
    
        public void addBook(Book book) {
            catalog.add(book);
        }
    
        public void removeBook(Book book) {
            catalog.remove(book);
        }
    
        public void displayAvailableBooks() {
            System.out.println("Доступные книги в библиотеке:");
            for (Book book : catalog) {
                if (book.isAvailable()) {
                    book.displayInfo();
                }
            }
        }
    
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
        
}
