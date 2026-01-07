import java.util.List;

public interface StudentRepository {
    boolean save(Student student);
    Student findById(String id);
    boolean deleteById(String id);
    boolean updateGpa(String id, double newGpa);
    List<Student> findAll();
    int count();
}
