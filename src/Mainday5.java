import java.util.Scanner;
import java.util.List;
public class Mainday5 {
    public static void main(String[] args){
        String filePath = "students.csv";
        StudentServiceMap studentServiceMap = new StudentServiceMap();
        Scanner scanner = new Scanner(System.in);

        studentServiceMap.loadFormFile(filePath);

        while (true){
            System.out.println("\nDanh Sách Học Sinh (Ngày 5)");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Tìm học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Xem tất cả học sinh");
            System.out.println("5. Sữa điểm GPA");
            System.out.println("6. Xắp xếp điểm từ cao đến thấp");
            System.out.println("7. Save file");
            System.out.println("8. Load file");

            System.out.println("0. Exit");
            System.out.print("Chọn : ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());

            }catch (Exception exception){
                System.out.println("Hãy chọn số ");
                continue;
            }

            switch (choice){
                case 1 ->{
                    String id = InputHelper.readNonEmptyString(scanner,"Nhập Id : ").trim();
                    String name = InputHelper.readNonEmptyString(scanner,"Nhập tên : ").trim();
                    int age = InputHelper.readInt(scanner,"Nhập tuổi : ");
                    double gpa =InputHelper.readGpa(scanner,"Nhập GPA : ");

                    boolean oke = studentServiceMap.addStudent(new Student(id,name,age,gpa));
                    System.out.println(oke ? "Thêm thành công" : "ID đã tồn tại");
                }
                case 2 ->{
                    String id =InputHelper.readNonEmptyString(scanner,"Nhập ID : ").trim();
                    Student found = studentServiceMap.findId(id);
                    System.out.println(found == null ? "Không tìm lấy id" : found);
                }

                case 3 ->{
                    String id =InputHelper.readNonEmptyString(scanner,"Nhập ID : ").trim();
                    boolean delete =studentServiceMap.deleteId(id);
                    System.out.println(delete ? "Đã xóa" : "Không tìm thấy!");
                }
                case 4 ->{studentServiceMap.PrintAll();}
                case 5 ->{
                    String id = InputHelper.readNonEmptyString(scanner,"Nhập ID : ").trim();
                    double newGpa = InputHelper.readGpa(scanner,"Nhập điểm GPA mới");
                    boolean updated = studentServiceMap.updateGpa(id,newGpa);
                    System.out.println(updated ? "Cập nhật thành công" : "ID không tồn tại");
                }
                case 6 ->{
                    List<Student> sorted = studentServiceMap.getSortBestStudent();
                    if (sorted.isEmpty()){
                        System.out.println("Không có học sinh");
                    }else {
                        for (Student s : sorted) System.out.println(s);
                    }
                }
                case 7 -> studentServiceMap.saveToFile(filePath);

                case 8 -> studentServiceMap.loadFormFile(filePath);

                case 0 -> {
                    studentServiceMap.saveToFile(filePath);
                    System.out.println("Bye!");
                    return;
                }

                default -> System.out.println("Lỗi chọn!");

            }
        }
    }
}
