import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class PostService {
    public static List<Post> getListPost(){
        List<Post> postList = new ArrayList<Post>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<10; i++){
            Post post = new Post();
            System.out.print("Enter post id: " + i);
            post.setId(sc.nextInt());

            System.out.print("Enter author: " + i);
            post.setAuthor(sc.next());

            System.out.print("Enter title: " + i);
            post.setTitle(sc.next());

            System.out.print("Enter description: " + i);
            post.setDescription(sc.next());

            System.out.print("Enter content: " + i);
            post.setContent(sc.next());

            System.out.print("Enter date: " + i);
            post.setDate(Instant.now());

        }
        return postList;
    }

    public static List<Post> findPostByAuthor(List<Post> posts){
        List<Post> filtered = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Searching author");
        String author = scanner.nextLine();

        for(int i = 0 ; i < posts.size() ; i++ ){
            Post postAtPositionA = posts.get(i);
            if(postAtPositionA.getAuthor().equals(author) ){
                filtered.add(postAtPositionA);
            }
        }
        return filtered;
    }

    public static List<Post> findPostByTitle(List<Post> posts){
        List<Post> filtered = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching title");
        String title = scanner.nextLine();
        for(int i = 0 ; i < posts.size() ; i++ ){
            Post postAtPositionT = posts.get(i);
            if(postAtPositionT.getTitle().equals(title) ){
                filtered.add(postAtPositionT);
            }
        }
        return filtered;
    }

    public static List<Post> findPostByContent(List<Post> posts){
        List<Post> filtered = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching title");
        String content = scanner.nextLine();
        for(int i = 0 ; i < posts.size() ; i++ ){
            Post postAtPositionT = posts.get(i);
            if(postAtPositionT.getTitle().equals(content) ){
                filtered.add(postAtPositionT);
            }
        }
        return filtered;
    }

    public static List<Post> findTop10NewestPostsByAuthor(List<Post> posts){
        List<Post> filtered = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Searching author");
        String author = scanner.nextLine();

        System.out.println("Searching title");
        String title = scanner.nextLine();

        System.out.println("Searching content");
        String content = scanner.nextLine();

        for(Post postAtPositionA : posts){
            if (postAtPositionA.getAuthor().equals(author)){
                filtered.add(postAtPositionA);
            }if (postAtPositionA.getAuthor().equals(title)){
                filtered.add(postAtPositionA);
            }if (postAtPositionA.getAuthor().equals(content)){
                filtered.add(postAtPositionA);
            }
        }
        filtered.sort(Comparator.comparing(Post::getDate).reversed());
        return filtered.stream().limit(10).collect(Collectors.toList());
    }

    public static Map<String, List<Post>> groupPostsByAuthor(List<Post> posts){
        Map<String, List<Post>> postsByAuthor = new HashMap<>();
        for(Post post : posts){
            String author = post.getAuthor();// lấy tên tác giả từ mỗi bài viết
            if(!postsByAuthor.containsKey(author)){
                postsByAuthor.put(author, new ArrayList<>());
            }
            postsByAuthor.get(author).add(post); // lấy danh sách với key là tên tác giả và thêm bài viết của tác giả đó vào
        }
        return postsByAuthor;
    }

}
