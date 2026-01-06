import java.util.Scanner;
public class InputHelper {
    public static int readInt(Scanner scanner,String message){
        while (true){
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            }catch (Exception e){
                System.out.println("Lỗi số , vui lòng nhập lại");
            }
        }
    }

    public static double readDouble(Scanner scanner,String message){
        while (true){
            try {
                System.out.print(message);
                String input =scanner.nextLine().trim();
                return Double.parseDouble(input);
            }catch (Exception e){
                System.out.println("Lỗi số , vui lòng nhập lại");
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner,String message){
        while (true){
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return  input;
            System.out.println("Không được để trống , vui lòng nhập lại");
        }
    }
    public static double readGpa(Scanner scanner,String message){
        while (true){
            double gpa =readDouble(scanner,message);
            if (gpa > 0 && gpa <4.0) return gpa;
            System.out.println("GPA lớn hơn 0 và nhỏ hơn 4");
        }
    }
    public static int readAge(Scanner scanner,String message){
        while (true){
            int age = readInt(scanner,message);
            if (age > 0 && age <120) return age;
            System.out.println("Tuổi không hợp lệ");
        }
    }
}
