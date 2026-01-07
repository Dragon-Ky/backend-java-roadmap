import java.util.List;
import java.util.Comparator;
public class StudentServiceV2 {
    private final StudentRepository repository;

    public StudentServiceV2(StudentRepository repository){
        this.repository =repository;
    }
    public boolean addStudent(Student student){
        if (student == null) return false;
        if (student.getId() == null || student.getId().trim().isEmpty())return false;
        if (student.getName() == null || student.getName().trim().isEmpty()) return false;
        if (student.getAge() <= 0 || student.getAge() > 120 ) return false;
        if (student.getGpa() < 0|| student.getGpa()>4.0) return false;

        return repository.save(student);
    }

    public Student findById(String id){
        return repository.findById(id);
    }

    public boolean deleteById(String id){
        return repository.deleteById(id);
    }

    public boolean updateGpa(String id,double newGpa){
        if (newGpa <0 || newGpa >4.0) return false;
        return repository.updateGpa(id,newGpa);
    }
    public List<Student> getSordByGpa(){
        List<Student> list = repository.findAll();
        list.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        return list;
    }
    public  Student findTopStudent(){
        return  repository.findAll()
                .stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
    }

    public  int count(){
        return repository.count();
    }
}
