import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceMap {
    private Map<String,Student> Studentmap = new HashMap<>();

    //thêm học sinh
    public boolean addStudent(Student s){
        if (Studentmap.containsKey(s.getId())) return false; //kiểm tra id tồn tại chưa
        Studentmap.put(s.getId(),s); // chưa có thì tạo
        return true;
    }
    // search id
    public Student findId(String id){
        return Studentmap.get(id);
    }
    // xóa id
    public boolean deleteId(String id){
        return Studentmap.remove(id) != null;
    }
    //chỉnh sữa điểm
    public boolean updateGpa(String id,Double newGpa){
        Student found = Studentmap.get(id); //kiểm tra id có tồn tại không
        if(found == null) return false;

        found.setGpa(newGpa);
        return true;
    }
    //in tất cả
    public void PrintAll(){
        if (Studentmap.isEmpty()){
            System.out.println("Ko có học sinh");
            return ;
        }
        for (Student student : Studentmap.values()){
            System.out.println(student);
        }
    }
    // xắp xếp học sinh có điểm từ cao đến thấp
    public List<Student> getSortBestStudent(){
        List<Student> list =new ArrayList<>(Studentmap.values());
        list.sort(Comparator.comparingDouble(Student::getGpa).reversed()); // xắp sếp vào lish rồi so sánh với nhau
        return list;
    }
    // tìm học sinh giỏi nhất
    public Student findTopStudent(){
        return Studentmap.values() // lấy tất cả giá trị
                .stream()   //để thực hiện sử lý dữ liệu
                .max(Comparator.comparingDouble(Student::getGpa)) // tìm gpa cao nhất
                .orElse(null); //ko có thì trả null
    }
    // đếm số lượng học sinh đang tồn tại
    public int size(){
        return Studentmap.size();
    }
    //bonus
    public List<Student> findGpaAllStudent(double targetGpa){
        return Studentmap.values()
                .stream()
                .filter(student -> student.getGpa() >= targetGpa)
                .collect(Collectors.toList());
    }
    public double getAverageGpa(){
        return Studentmap.values()
                .stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public List<Student> sortAgeStudent(){
        List<Student> agelist = new ArrayList<>(Studentmap.values());
        agelist.sort(Comparator.comparingInt(Student::getAge));
        return agelist;
    }
}
