import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DatetimeUtils {
    public static String formatDate (LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
    public static LocalDate createDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }
    public static String convertDate(String date, String fromPattern, String toPattern) {
        try {
            // Tạo đối tượng DateTimeFormatter từ chuỗi định dạng ban đầu
            DateTimeFormatter fromFormatter = DateTimeFormatter.ofPattern(fromPattern);

            // Parse chuỗi ngày tháng sang đối tượng LocalDateTime theo mẫu định dạng ban đầu
            LocalDateTime dateTime = LocalDateTime.parse(date, fromFormatter);

            // Tạo đối tượng DateTimeFormatter từ chuỗi định dạng đích
            DateTimeFormatter toFormatter = DateTimeFormatter.ofPattern(toPattern);

            // Định dạng lại ngày tháng theo mẫu định dạng mới và trả về dưới dạng chuỗi
            return dateTime.format(toFormatter);
        } catch (DateTimeParseException e) {
            // Xử lý lỗi nếu định dạng đầu vào không đúng
            System.out.println("Invalid date format: " + e.getMessage());
            return null;
        }
    }
}
