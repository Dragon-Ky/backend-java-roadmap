import java.util.ArrayList;
import java.util.Comparator;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }
    public void printAll(){
        if (students.isEmpty()){
            System.out.println("No student");
        }
        for (Student s : students) {
            System.out.println(students);
        }
    }
    public Student findByID(String Id){
        for (Student s:students) {
            if (s.getId().equals(Id)) {
                return s;
            }
        }
        return null;
    }
    public boolean removeById(String Id){
        Student found =findByID(Id) ;
        if(found==null){
            return false;
        }
        students.remove(found);
        return true;
    }
    public void reversedByGpa(){
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
    }
    public Student findTopStudent(){
        if (students.isEmpty()){
            return null;
        }
        Student Top = students.getFirst();
        for (Student s:students){
            if  (s.getGpa()>Top.getGpa()) {
                Top = s;
            }
        }
        return Top;
    }
}
