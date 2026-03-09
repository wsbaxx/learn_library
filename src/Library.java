/*
1.封装借书，需要先用findBooks方法得到该书对象。找到之后就调用books的borrow方法就行。
如果找不到书就返回布尔值表示错误。
2.返回类型应该是arraylist，一个arraylist里面都装books对象。
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;      // 写入文件
import java.io.IOException;      // 异常类
import java.io.Writer;
import java.io.BufferedReader;   // 读取文件（缓冲）
import java.io.FileReader;      // 读取文件
import javax.print.DocFlavor.STRING;

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

    public ArrayList<Book> findBook_byAuthor(String keyString){
        ArrayList<Book> match_list = new ArrayList<Book>();
        for(String word:book_repository.keySet()){
            Book book = book_repository.get(word);
            String author = book.getAuthor();
            if(author.contains(keyString)){
                match_list.add(book);
            }
        }
        return match_list;
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

    public boolean saveToFile(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for(Book book2: book_repository.values()){
                String isbn = book2.getIsbn();
                String title = book2.getTitle();
                String author = book2.getAuthor();
                String stock = Integer.toString(book2.getStock());
                StringBuilder sb = new StringBuilder();
                sb.append(isbn).append(",").append(title).append(",").append(author).append(",").append(stock);
                String csvString =  sb.toString();
                fileWriter.write(csvString+"\n");
            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("文件保存失败");
            return false;
        }
    }

    public boolean loadFromFile(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){

            String line;
            while( (line = reader.readLine())!= null){
                String [] parts = line.split(",");
                Book book = new Book(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]) );
                book_repository.put(parts[0],book );
            }
            return  true;
        } catch (Exception e) {
            System.out.println("文件读取失败");
            return false;
        }
    }
}
