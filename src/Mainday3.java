import java.util.List;

public class Mainday3 {
        public static void main(String[] args){
            StudentServiceMap serviceMap = new StudentServiceMap();

            serviceMap.addStudent(new Student("ST1","A",20,3));
            serviceMap.addStudent(new Student("ST2","B",21,2));
            serviceMap.addStudent(new Student("ST3","C",22,1));
            serviceMap.addStudent(new Student("ST4","D",23,4));
            serviceMap.addStudent(new Student("ST5","F",24,3.5));

            System.out.println("\nTất cả học sinh hiện có");
            serviceMap.PrintAll();

            System.out.println("\n Tìm học sinh ST3");
            System.out.println(serviceMap.findId("ST3"));

            System.out.println("\n Cập nhật điểm cho ST3 từ 1 thành 3.2");
            System.out.println("Cập nhật " +(serviceMap.updateGpa("ST3",3.2)));

            System.out.println("\n Xóa ST4");
            System.out.println("Xóa "+serviceMap.deleteId("ST4"));

            System.out.println("\n Sắp xếp GPA từ cao đến thấp");
            List<Student> sortStudent = serviceMap.getSortBestStudent();
            for (Student s : sortStudent){
                System.out.println(s);
            }

            System.out.println("\nHọc sinh giỏi nhất");
            System.out.println(serviceMap.findTopStudent());


            System.out.println("\nHọc sinh có điểm lớn hơn hoặc bằng 3.2");
            List<Student> targetStudent = serviceMap.findGpaAllStudent(3.2);
            for (Student s : targetStudent){
                System.out.println(s);
            }

            System.out.println("\n Tuổi từ thấp đến cao");
            List<Student> sortage = serviceMap.sortAgeStudent();
            for (Student s : sortage){
                System.out.println(s);
            }

            System.out.println("\n Tổng trung bình GPA tất cả học sinh");
            System.out.println("Tổng Trung bình Gpa : "+ serviceMap.getAverageGpa());
        }
}
