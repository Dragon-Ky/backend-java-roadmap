import java.util.*;
public class InMemoryStudentRepository implements StudentRepository{
    private final Map<String,Student> map = new HashMap<>();
    @Override
    public boolean save(Student student){
        String id =student.getId().trim();
        if (map.containsKey(id)) return false;
        map.put(id,student);
        return true;
    }
    @Override
    public Student findById(String id){
        if (id== null) return null;
        return map.get(id.trim());
    }
    @Override
    public boolean deleteById(String id){
        if (id==null)return false;
        return map.remove(id.trim()) !=null;
    }

    @Override
    public boolean updateGpa(String id,double newGpa){
        Student found = findById(id);
        if (found == null) return false;
        found.setGpa(newGpa);
        return true;
    }
    @Override
    public List<Student> findAll(){
        return new ArrayList<>(map.values());
    }
    @Override
    public int count(){
        return map.size();
    }
}
