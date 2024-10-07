import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuthorService {
    public  static Stream<Author> getListAuthor(){
        List<Author> authorList = new ArrayList<>();
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
        return authorList.stream();
    }

    public static Stream <Author> findAuthorByName(Stream<Author> authors){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Searching name");
      String name = scanner.nextLine();
      return authors.filter(author -> author.getUsername().equals(name));
    }

    public static Stream<Author> findAuthorByEmail(Stream<Author> authors){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching email");
        String emailInput = scanner.nextLine();
        return authors.filter(email -> email.getEmail().equals(emailInput));
    }

    public static Stream<String> findAuthorName (Stream<Post> posts){
        return posts.map(Post :: getAuthor)
                .distinct();
    }
}
