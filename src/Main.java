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
        while(true){
            System.out.println("1. 添加图书");
            System.out.println("2. 删除图书");
            System.out.println("3. 查询图书");
            System.out.println("4. 借书");
            System.out.println("5. 还书");
            Library library = new Library();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1://添加图书
                    System.out.println("请按照 '001,挪威的森林,村上春树,1'这样的格式输入，分别对应isbn,书名,作者,库存");
                    String book1 = scanner.nextLine();
                    String []parts = book1.split(",");
                    Book book = new Book(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]) );
                    library.addBook(book);
                case 2://删除图书
                    System.out.println("请输入想删除的图书对应的isbn");
                    String del = scanner.next();
                    if(library.removeBook(del)){
                        System.out.println("删除成功！");
                    }else System.out.println("不存在这本书，删除失败");
                case 3://查询图书
                    System.out.println("");
            }
        }
    }
}

