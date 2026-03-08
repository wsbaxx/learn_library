/*
写个控制台程序，实现这些功能：
添加图书（书名、作者、ISBN、库存）
删除图书
查询图书（按书名或作者）
借书和还书
把数据保存到文件，下次启动能读出来
能练到啥？类怎么设计、ArrayList和HashMap怎么用、文件怎么读写、异常怎么处理。
*/
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

