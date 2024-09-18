import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorityService {
    public static List<Authority> findAuthoritOfUser (List<Authority> authority){
        List<Authority> filtered = new ArrayList<Authority>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user: ");
        String user = sc.nextLine();
        for (int i = 0; i < authority.size(); i++) {
            Authority authorityAtPositionU = authority.get(i);
            if(authorityAtPositionU.getUsername().equals(user)){
                filtered.add(authorityAtPositionU);
            }
        }
        return filtered;
    }
}
