/*
1.封装借书，需要先用findBooks方法得到该书对象。找到之后就调用books的borrow方法就行。
如果找不到书就返回布尔值表示错误。
2.返回类型应该是arraylist，一个arraylist里面都装books对象。
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private HashMap<String,Book> book_repository;

    public Library() {
        this.book_repository = new HashMap<>();
    }

    public void addBook(Book book){
        book_repository.put(book.getIsbn(), book);
        return;
    }

    public Book findBook(String isbn){
        return book_repository.get(isbn);
    }

    public boolean borrowBook(String isbn){
        Book fd =book_repository.get(isbn);
        if (fd ==null){
            System.out.println("图书馆暂未有过此书");
            return false;
        }
        return fd.borrow();
    }

    public boolean removeBook(String isbn){
        if(!book_repository.containsKey(isbn))
            return false;
        Book remBook = book_repository.remove(isbn);
        if(remBook==null)
            return false;
        return true;
    }

    public boolean returnBook(String isbn){
        Book fd =book_repository.get(isbn);
        if (fd == null)
            return false;
        fd.returnBook();
        return true;
    }
    public ArrayList<Book> findBook_byTitle(String keyword){
        ArrayList<Book> match_list = new ArrayList<Book>();
        for (String word : book_repository.keySet()){
             Book book = book_repository.get(word);
             String title = book.getTitle();
             if(title.contains(keyword)){
                match_list.add(book);
             }
        }
        return match_list;
    }
}
