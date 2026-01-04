import java.util.Scanner;

public class Mainday2 {
        public static void main(String[] args){
            Scanner sc =new Scanner(System.in);
            StudentService service = new StudentService();

            while (true){
                System.out.println("\n Quản Lý Học Sinh");
                System.out.println("1. Thêm học Sinh");
                System.out.println("2. Xem tất cả học sinh");
                System.out.println("3. Tìm học sinh bằng Id");
                System.out.println("4. Xóa học sinh bằng Id");
                System.out.println("5. Xắp xếp học sinh giỏi đến trung bình");
                System.out.println("6. Tìm học sinh giỏi nhất");
                System.out.println("7. Chỉnh sữa Gpa học sinh");
                System.out.println("0. Exit");
                System.out.print("Chọn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice){
                    case 1 ->{
                        System.out.println("Nhập Id");
                        String Id = sc.nextLine();

                        System.out.println("Nhập Tên");
                        String Name = sc.nextLine();

                        System.out.println("Nhập Tuổi");
                        int Age = Integer.parseInt(sc.nextLine());

                        System.out.println("Nhập điểm Gpa");
                        double Gpa = Double.parseDouble(sc.nextLine());

                        if (Age <0 ){
                            System.out.println("Tuổi phải lớn hơn 0");
                            break;
                        }
                        if (Gpa < 0 || Gpa > 4){
                            System.out.println("Gpa phải lớn hơn 0 và bé hơn 4");
                            break;
                        }

                        Student s =new Student(Id,Name,Age,Gpa);
                        boolean ok= service.addStudent(s);
                        if (ok) System.out.println("Đã thêm thành công");
                        else System.out.println("Id đã tồn tại");
                    }
                    case 2 ->{ service.printAll();}
                    case 3 ->{
                        System.out.print("Nhap Id can tim");
                        String findId = sc.nextLine();
                        Student found = service.findByID(findId);
                        if (found == null)System.out.println("không tìm thấy");
                        else System.out.println(found);
                    }
                    case 4 ->{
                        System.out.print("Nhập Id cần xóa");
                        String deleteId = sc.nextLine();
                        boolean delete  = service.removeById(deleteId);
                        System.out.println("đã xóa"+ delete);
                    }
                    case 5 ->{
                        service.reversedByGpa();
                        System.out.println("Đã sắp xếp");
                    }
                    case 6 ->{
                        Student top = service.findTopStudent();
                        if (top == null) System.out.println("không tìm thấy");
                        else System.out.println("Top : "+ top);
                    }
                    case 7 ->{
                        System.out.print("Nhập id cần chỉnh: ");
                        String findid = sc.nextLine();

                            System.out.print("Nhập điểm Gpa mới");
                            double newgpa = Double.parseDouble(sc.nextLine());
                            if (newgpa < 0 || newgpa > 4) {
                                System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 4");
                                break;
                            }
                            boolean update = service.updateGpa(findid, newgpa);
                            if (update) System.out.println("Update " + findid + ":" + newgpa);
                            else System.out.println("ID not found!");

                    }
                    case 0 ->{
                        System.out.println("Bye :3");
                        return;
                    }
                    default -> System.out.println("Ko hợp lệ!");
                }
            }


        }

}
