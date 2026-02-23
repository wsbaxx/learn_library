//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book book = new Book("1","gentleman","wsb",2);
        Library library = new Library();
        library.addBook(book);
        Book b = library.findBook("1");
        System.out.println(book.borrow());
        System.out.println(book.borrow());
        System.out.println(book.borrow());
        book.returnBook();
        System.out.println(book.borrow());
    }
}

