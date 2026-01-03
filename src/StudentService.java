import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();


    public void printAll(){
        if (students.isEmpty()){
            System.out.println("No student");
        }
        for (Student s : students) {
            System.out.println(s);
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
    public Student findTopStudent() {
        if (students.isEmpty()) return null;
        return Collections.max(students, Comparator.comparingDouble(Student::getGpa));
    }

    //ngày 2

    public boolean exitsById(String Id){
        return findByID(Id) != null;
    }

    public boolean addStudent(Student s){
        if (exitsById(s.getId())){
            return false;
        }
        students.add(s);
        return true;
    }
    public boolean updateGpa(String Id,double newGpa){
        Student  found = findByID(Id);
        if (found == null){
            return false;
        }
        found.setGpa(newGpa);
        return true;
    }
}
