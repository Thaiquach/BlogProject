import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Given a list of authors
        ArrayList<Author> authorList =  AuthorService.getListAuthor();
        for (Author author : authorList) {
            System.out.println("Username: " + author.getUsername());
            System.out.println("Password: " + author.getPassword());
            System.out.println("First Name: " + author.getFirst_name());
            System.out.println("Last Name: " + author.getLast_name());
            System.out.println("Email: " + author.getEmail());
            System.out.println("Birthdate: " + author.getBirthdate());
            System.out.println("Added: " + author.getAdded());
            System.out.println("-----------------------------");
        }
        // find author by name
        List<Author> resultByName = AuthorService.findAuthorByName(authorList);
        for (Author author : resultByName) {
            System.out.println("Username: " + author.getUsername());
            //System.out.println("Password: " + author.getPassword());
            System.out.println("First Name: " + author.getFirst_name());
            System.out.println("Last Name: " + author.getLast_name());
            System.out.println("Email: " + author.getEmail());
            System.out.println("Birthdate: " + author.getBirthdate());
            //System.out.println("Added: " + author.getAdded());
            System.out.println("-----------------------------");
        }
        //find author by email
        List<Author> resultByEmail = AuthorService.findAuthorByEmail(authorList);
        for (Author author : resultByEmail) {
            System.out.println("Username: " + author.getUsername());
            //System.out.println("Password: " + author.getPassword());
            System.out.println("First Name: " + author.getFirst_name());
            System.out.println("Last Name: " + author.getLast_name());
            System.out.println("Email: " + author.getEmail());
            System.out.println("Birthdate: " + author.getBirthdate());
            //System.out.println("Added: " + author.getAdded());
            System.out.println("-----------------------------");
        }
        //Given a list of posts
        List<Post> postList = PostService.getListPost();
        for (Post post : postList) {
            System.out.println("Username: " + post.getId());
            System.out.println("First Name: " + post.getAuthor());
            System.out.println("Last Name: " + post.getTitle());
            System.out.println("Email: " + post.getDescription());
            System.out.println("Birthdate: " + post.getContent());
            System.out.println("-----------------------------");
        }
        //find all posts of the specific author
        List<Post> resultForPost = PostService.findPostByAuthor(postList);
        for (Post post : resultForPost) {
            System.out.println("Username: " + post.getId());
            System.out.println("First Name: " + post.getAuthor());
            System.out.println("Last Name: " + post.getTitle());
            System.out.println("Email: " + post.getDescription());
            System.out.println("Birthdate: " + post.getContent());
            System.out.println("-----------------------------");
        }
        //find all posts that their title or content contains the specific string
        List<Post> resultForPost_Title = PostService.findPostByTitle(postList);
        for (Post post : resultForPost_Title) {
            System.out.println("Username: " + post.getId());
            System.out.println("First Name: " + post.getAuthor());
            System.out.println("Last Name: " + post.getTitle());
            System.out.println("Email: " + post.getDescription());
            System.out.println("Birthdate: " + post.getContent());
            System.out.println("-----------------------------");
        }
        List<Post> resultForPost_Content = PostService.findPostByContent(postList);
        for (Post post : resultForPost_Content) {
            System.out.println("Username: " + post.getId());
            System.out.println("First Name: " + post.getAuthor());
            System.out.println("Last Name: " + post.getTitle());
            System.out.println("Email: " + post.getDescription());
            System.out.println("Birthdate: " + post.getContent());
            System.out.println("-----------------------------");
        }

        //find the top 10 newest posts of one specific author
        //find the top 10 newest posts of one specific author and their title or content contains the specific string
        List<Post> top10NewestPosts = PostService. findTop10NewestPostsByAuthor(postList);
        for (Post post : top10NewestPosts) {
            System.out.println("Username: " + post.getId());
            System.out.println("First Name: " + post.getAuthor());
            System.out.println("Last Name: " + post.getTitle());
            System.out.println("Email: " + post.getDescription());
            System.out.println("Birthdate: " + post.getContent());
            System.out.println("-----------------------------");
        }
        //find all posts of all users (group by user)
        Map<String, List<Post>> postsByAuthor = PostService.groupPostsByAuthor(postList);
        for (String author : postsByAuthor.keySet()) {
            System.out.println("Posts by " + author + ":");
            List<Post> authorPosts = postsByAuthor.get(author);
            for (Post post : authorPosts) {
                System.out.println("Title: " + post.getTitle());
                System.out.println("Description: " + post.getDescription());
                System.out.println("Date: " + post.getDate());
                System.out.println("---");
            }
        }
        //find all author's names
        List<Post> resultForAuthorName = AuthorService.findAuthorName(postList);
        for (Post post : resultForAuthorName) {
            System.out.println("First Name: " + post.getAuthor());
        }
        //find all authorities of the specific user


    }
}
