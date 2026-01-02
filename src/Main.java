public class Main {
        public static void main(String[] args){

            StudentService service = new StudentService();

            service.addStudent(new Student("ST1","Ky",22,3.2));
            service.addStudent(new Student("ST2","Ky1",22,4.2));
            service.addStudent(new Student("ST3","Ky2",22,5.2));
            service.addStudent(new Student("ST4","Ky3",22,6.2));
            service.addStudent(new Student("ST5","Ky4",22,7.2));

            System.out.println("ALl Student");
            service.printAll();

            System.out.println("\n Find best student ");
            System.out.println(service.findTopStudent());

            System.out.println("\n Find S03 ");
            System.out.println(service.findByID("ST3"));

            System.out.println("\n Best student has GPA ");
            service.reversedByGpa();

            System.out.println("ALl Student");
            service.printAll();
        }
}
