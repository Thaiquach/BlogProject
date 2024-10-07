import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {
//        //Given a list of authors
//        Stream<Author> authorList =  AuthorService.getListAuthor();
//        authorList.forEach(System.out::println);
//
//        // find author by name
//        Stream <Author> resultByName = AuthorService.findAuthorByName(authorList);
//        resultByName.forEach(System.out::println);
//
//        //find author by email
//        Stream<Author> resultByEmail = AuthorService.findAuthorByEmail(authorList);
//        resultByEmail.forEach(System.out::println);

        //Given a list of posts
//        List<Post> postList = PostService.getListPost().collect(Collectors.toList());
//        postList.forEach(System.out::println);
//        Stream<Post> postStream = postList.stream();


//        //find all posts of the specific author
//        Stream<Post> resultForPost = PostService.findPostByAuthor(postList);
//        resultForPost.forEach(System.out::println);
//
//        //find all posts that their title or content contains the specific string
//        Stream<Post> resultForPost_Title = PostService.findPostByTitle(postList);
//        resultForPost_Title.forEach(System.out::println);
//        Stream<Post> resultForPost_Content = PostService.findPostByContent(postList);
//        resultForPost_Content.forEach(System.out::println);
//
//        //find the top 10 newest posts of one specific author
//        //find the top 10 newest posts of one specific author and their title or content contains the specific string
//        Stream<Post> top10NewestPosts = PostService. findTop10NewestPostsByAuthor(postList);
//        top10NewestPosts.forEach(System.out::println);

        //find all posts of all users (group by user)
        //Given a list of authors (A) and a list of posts, find all posts which are created by authors in the list (A)
//        Map<String, List<Post>> postsByAuthor = PostService.groupPostsByAuthor(postStream);
//        for (String author : postsByAuthor.keySet()) {
//            System.out.println("Posts by " + author + ":");
//            List<Post> authorPosts = postsByAuthor.get(author);
//            for (Post post : authorPosts) {
//                System.out.println("Title: " + post.getTitle());
//                System.out.println("Description: " + post.getDescription());
//                System.out.println("Date: " + post.getCreatedDate());
//                System.out.println("---");
//            }
//        }
//        //find all author's names
//        Stream<String> resultForAuthorName = AuthorService.findAuthorName(postList);
//        resultForAuthorName.forEach(System.out::println);
//
//        Stream<Authority> authorityList = AuthorityService.getListAuthority();
//        authorityList.forEach(System.out::println);
//
//        //find all authorities of the specific user
//        Stream<Authority> resultForAuthoritOfUser = AuthorityService.findAuthorityOfUser(authorityList);
//        resultForAuthoritOfUser.forEach(System.out::println);
//        // find all postToDay
//        Stream<Post> resultOfAllPostToDay = PostService.findAllPostsToday(postList);
//        resultOfAllPostToDay.forEach(System.out::println);


//


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        LocalDate currentDateTime = null;
        while (true) {
            System.out.print("Enter time such as (yyyy-MM-dd): ");
            String currentTime = sc.nextLine();
            try{
                currentDateTime = LocalDate.parse(currentTime, formatter);
                // LocalDate.parse phương thức này yêu cầu một biến đầu vào và một đối tượng dạng DateTimeFormatter
                break;
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Invalid time format");
            }
        }
        String formatted = DatetimeUtils.formatDate(currentDateTime, "yyyy-MM-dd");
        System.out.println(formatted);

        System.out.print("Enter date such as (yyyy-MM-dd): ");
        String date = sc.nextLine();
        LocalDate createDated = DatetimeUtils.createDate(date, "yyyy-MM-dd");
        System.out.println(createDated);

        System.out.print("Enter date such as (yyyy-MM-dd): ");
        String dateToConver = sc.nextLine();
        String convertedDate  = DatetimeUtils.convertDate(dateToConver, "yyyy-MM-dd", "dd-MM-yyyy");
        System.out.println(convertedDate);








    }
}

