import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorService {
    public  static ArrayList<Author> getListAuthor(){
        ArrayList<Author> authorList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            Author author = new Author();
            System.out.print("Enter author's name: " + i);
            author.setUsername(scanner.nextLine());

            System.out.print("Enter author's password: " + i);
            author.setPassword(scanner.nextLine());

            System.out.print("Enter author's first_name: " + i);
            author.setFirst_name(scanner.nextLine());

            System.out.print("Enter author's last_name: " + i);
            author.setLast_name(scanner.nextLine());

            System.out.print("Enter author's email: " + i);
            author.setEmail(scanner.nextLine());

            System.out.print("Enter author's birthdate: " + i);
            author.setBirthdate(Instant.now());

            System.out.print("Enter author's added: " + i);
            author.setAdded(Instant.now());

            authorList.add(author);
        }
        return authorList;
    }

    public static List<Author> findAuthorByName(List<Author> authors){
      List<Author> filtered = new ArrayList<Author>();
      Scanner scanner = new Scanner(System.in);
      System.out.println("Searching name");
      String name = scanner.nextLine();
      for(int i = 0 ; i < authors.size() ; i++ ){
          Author authorAtPositionI = authors.get(i);
           if(authorAtPositionI.getUsername().equals(name) ){
              filtered.add(authorAtPositionI);
          }
      }
        return filtered;
    }

    public static List<Author> findAuthorByEmail(List<Author> authors){
        List<Author> filtered = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching email");
        String email = scanner.nextLine();
        for(int i = 0 ; i < authors.size() ; i++ ){
            Author authorAtPositionI = authors.get(i);
            if(authorAtPositionI.getEmail().equals(email) ){
                filtered.add(authorAtPositionI);
            }
        }
        return filtered;
    }

    public static List<Post> findAuthorName (List<Post> posts){
        List<Post> filtered = new ArrayList<>();
        for(Post post : posts){
            String author = post.getAuthor();
            if(!filtered.contains(author)){
                filtered.get(Integer.parseInt(author));
            }
        }
        return filtered;
    }
}
