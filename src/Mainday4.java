import java.util.List;
import java.util.Scanner;
public class Mainday4 {
    public static void main(String[] args) {

        String filePath = "students.csv";
        StudentServiceMap serviceMapStudent = new StudentServiceMap();
        Scanner scanner = new Scanner(System.in);

        serviceMapStudent.loadFormFile(filePath);

        while (true) {
            System.out.println("\nDanh Sách Học Sinh (Ngày 4)");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Xóa học sinh");
            System.out.println("3. Xem tất cả học sinh");
            System.out.println("4. Xắp xếp điểm từ cao đến thấp");
            System.out.println("5. Lưu file");
            System.out.println("6. Load file");
            System.out.println("0. Exit");
            System.out.print("Chọn : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 ->{
                    System.out.print("Nhập Id học sinh : ");
                    String id = scanner.nextLine().trim();

                    System.out.print("Nhập tên học sinh : ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Nhập tuổi học sinh : ");
                    int age = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Nhập điểm GPA học sinh : ");
                    double Gpa = Double.parseDouble(scanner.nextLine().trim());

                    if (age < 0){
                        System.out.println("Tuổi phải lớn hơn 0");
                        break;
                    }
                    if (Gpa < 0 || Gpa >4){
                        System.out.println("Điểm GPA phải lớn hơn 0 và nhỏ hơn 4");
                        break;
                    }
                    boolean oke = serviceMapStudent.addStudent(new Student(id,name,age,Gpa));
                    if (oke) System.out.println("Thêm học sinh thành công");
                    else System.out.println("ID đã tồn tại");
                }

                case 2 ->{
                    System.out.print("Nhập Id cần xóa : ");
                    String id = scanner.nextLine().trim();
                    System.out.println("Đã xóa "+ serviceMapStudent.deleteId(id));
                }

                case 3 ->{serviceMapStudent.PrintAll();}

                case 4 ->{
                    List<Student> sorted = serviceMapStudent.getSortBestStudent();
                    for (Student s : sorted) System.out.println(s);
                }

                case 5 ->{serviceMapStudent.saveToFile(filePath);}

                case 6 ->{serviceMapStudent.loadFormFile(filePath);}

                case 0 ->{
                    serviceMapStudent.saveToFile(filePath);
                    System.out.println("Bye :3");
                    return;
                }
                default -> System.out.println("Lựa Chọn không tồn tại");
            }
        }

    }
}
