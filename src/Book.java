/*
1.借书成功,stock减一，如果stock大于等于一就成功，否则返回不能借书，库存为0
2.借书返回布尔值。
3.还书不会失败，返回空值即可
4.
*/

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int stock;

    public Book(String isbn, String title, String author, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public boolean borrow(){
        if(this.stock>=1){
            this.stock-=1;
            return true;
        }
        System.out.println("书本已经被借完了");
        return false;
    }

    public void returnBook(){
        this.stock++;
    }
    @Override
    public String toString() {
        return "《"+ title +"》"+ " - " + author +"，"+"库存"+":"+ stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }
}
