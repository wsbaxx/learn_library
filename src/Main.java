import java.util.ArrayList;
import java.util.Scanner;

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
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("0. 退出程序");
            System.out.println("1. 添加图书");
            System.out.println("2. 删除图书");
            System.out.println("3. 查询图书");
            System.out.println("4. 还书");
            System.out.println("5. 借书");
            System.out.println("6. 保存图书信息至文件中");
            System.out.println("7. 输入文件并保存信息");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    return;
                case 1://添加图书
                    System.out.println("请按照 '001,挪威的森林,村上春树,1'这样的格式输入，分别对应isbn,书名,作者,库存");
                    String book1 = scanner.nextLine();
                    String []parts = book1.split(",");
                    Book book = new Book(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]) );
                    library.addBook(book);
                    break;
                case 2://删除图书
                    System.out.println("请输入想删除的图书对应的isbn");
                    String del = scanner.next();
                    if(library.removeBook(del)){
                        System.out.println("删除成功！");
                    }else System.out.println("不存在这本书，删除失败");
                    break;
                case 3://按照作者查询图书
                    System.out.println("请输入作者名来查询书籍");
                    String fwriter = scanner.next();
                    ArrayList<Book> bookByAuthor = library.findBook_byAuthor(fwriter);
                    if(!bookByAuthor.isEmpty()){
                        System.out.println("符合要求的有以下几本书：");
                        for(Book book2 : bookByAuthor){
                            System.out.println(book2.getTitle());
                            if(book2.getStock()==0){
                                System.out.println("此书存于本馆，但是目前已全部借出。");
                            }
                        }
                    }
                    if(bookByAuthor.isEmpty()) {
                        System.out.println("暂未查询到匹配结果");
                    }
                    break;
                case 4://还书
                    System.out.println("请输入你要还的书的isbn");
                    String fisbn = scanner.next();
                    library.returnBook(fisbn);
                    break;
                case 5://借书
                    System.out.println("请输入你要借的书的isbn");
                    String hisbn = scanner.next();
                    library.borrowBook(hisbn);
                    break;
                case 6://保存信息文件
                    System.out.println("请输入保存文件的名字");
                    String fname = scanner.next();
                    library.saveToFile(fname);
                    break;
                case 7://输入文件信息
                    System.out.println("请输入文件名字");
                    String ifname = scanner.next();
                    library.loadFromFile(ifname);
                    break;
            }
        }
    }
}

