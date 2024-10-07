import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostService {
    public static Stream<Post> getListPost(){
        List<Post> postList = new ArrayList<Post>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<3; i++){
            Post post = new Post();
            System.out.print("Enter post id: " + i);
            post.setId(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter author: " + i);
            post.setAuthor(sc.next());

            System.out.print("Enter title: " + i);
            post.setTitle(sc.next());

            System.out.print("Enter description: " + i);
            post.setDescription(sc.next());

            System.out.print("Enter content: " + i);
            post.setContent(sc.next());

            System.out.print("Enter date: " + i);
            post.setCreatedDate(Instant.now());

            postList.add(post);
        }
        return postList.stream();
    }

    public static Stream<Post> findPostByAuthor(Stream<Post> posts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching author");
        String authorInput = scanner.nextLine();
        return posts.filter(author -> author.getAuthor().equals(authorInput));
    }

    public static Stream<Post> findPostByTitle(Stream<Post> posts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching title");
        String titleInput = scanner.nextLine();
        return posts.filter(title -> title.getTitle().equals(titleInput));
    }

    public static Stream<Post> findPostByContent(Stream<Post> posts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching title");
        String contentInput = scanner.nextLine();
        return posts.filter(content -> content.getContent().equals(contentInput));
    }

    public static Stream<Post> findTop10NewestPostsByAuthor(Stream<Post> posts){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Searching author");
        String author = scanner.nextLine();

        System.out.println("Searching title");
        String title = scanner.nextLine();

        System.out.println("Searching content");
        String content = scanner.nextLine();

        return posts.filter(post -> post.getAuthor().equals(author)
                        && post.getTitle().contains(title)
                        || post.getContent().contains(content))
                .sorted(Comparator.comparing(Post::getCreatedDate).reversed())
                .limit(10);
    }

    public static Map<String, List<Post>> groupPostsByAuthor(Stream<Post> posts){
        return posts. collect(Collectors.groupingBy(Post::getAuthor));
    }

    public static Stream <Post> findAllPostsToday(Stream<Post> posts){
        LocalDate today = LocalDate.now();
        Instant startOfToday = today.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return posts.filter(post -> post.getCreatedDate().isAfter(startOfToday));
    }



    public static List<Post> readFileCSV(String filePath, LocalDate specificDate, Set<String> authors) {
        List<Post> posts = new ArrayList<>(); // Danh sách để lưu trữ bài viết

        // Định dạng ngày trong file CSV
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Bỏ qua dòng tiêu đề
            line = br.readLine();

            // Đọc từng dòng trong file CSV
            while ((line = br.readLine()) != null) {
                // Tách dữ liệu theo dấu |
                String[] data = line.split(";");
                String author = data[0];
                String title = data[1];
                String description = data[2];
                String content = data[3];
                LocalDate date = LocalDate.parse(data[4], formatter);

                // Kiểm tra xem ngày có sau ngày cụ thể và tác giả có trong danh sách không
                if (date.isAfter(specificDate) && authors.contains(author)) {
                    // Tạo một đối tượng Post và thêm vào danh sách
                    Post post = new Post();
                    post.setAuthor(author);
                    post.setTitle(title);
                    post.setDescription(description);
                    post.setContent(content);
                    // Chuyển đổi LocalDate thành Instant để lưu trữ
                    post.setCreatedDate(date.atStartOfDay(ZoneId.of("UTC")).toInstant());

                    posts.add(post); // Thêm bài đăng vào danh sách
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts; // Trả về danh sách các bài đăng đã lọc
    }


}
