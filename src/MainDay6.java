public class MainDay6 {
    public static void main(String[] args){
        StudentRepository repository = new InMemoryStudentRepository();
        StudentServiceV2 serviceV2 = new StudentServiceV2(repository);

        serviceV2.addStudent(new Student("ST1","A",20,1));
        serviceV2.addStudent(new Student("ST2","b",20,2));
        serviceV2.addStudent(new Student("ST3","c",20,3));
        serviceV2.addStudent(new Student("ST4","d",20,4));

        System.out.println("Tổng học sinh "+ serviceV2.count());
        System.out.println("Học sinh giỏi nhất "+ serviceV2.findTopStudent());
        System.out.println("Xóa ST3 "+ serviceV2.deleteById("ST3"));
        System.out.println(serviceV2.count());
    }
}
