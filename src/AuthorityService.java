import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuthorityService {
    public  static Stream<Authority> getListAuthority(){
        List<Authority> authorityList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            Authority authority = new Authority();
            System.out.print("Enter author's name: " + i);
            authority.setUsername(scanner.nextLine());

            System.out.print("Enter author's password: " + i);
            authority.setAuthority(scanner.nextLine());

            authorityList.add(authority);
        }
        return authorityList.stream();
    }
    public static Stream<Authority> findAuthorityOfUser (Stream<Authority> authorities){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user: ");
        String user = sc.nextLine();
        return authorities.filter(authority -> authority.getUsername()
                .equals(user));
    }
}
