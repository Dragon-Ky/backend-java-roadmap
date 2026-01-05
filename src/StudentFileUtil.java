import java.io.*; // thư viện xử lý nhập xuất file
import java.util.ArrayList; // thư viện danh sách động vằng arraylist
import java.util.List;
public class StudentFileUtil {
    // hàm biến đối tượng thành chuỗi vào file
    public static String toCsv (Student student){
        return student.getId()+","+student.getName()+","+student.getAge()+","+student.getGpa();
    }
    // hàm biến chuỗi thành từng đối tượng
    public static Student fromCsv(String line) {
        String[] parts = line.split(",");
        if (parts.length !=4) return null;

        String id =parts[0].trim();
        String name=parts[1].trim();
        int age=Integer.parseInt(parts[2].trim());
        double gpa = Double.parseDouble(parts[3].trim());

        return new Student(id,name,age,gpa);
    }
    //Lưu danh sách vào file
    public static void save(String filePath,List<Student> students) throws IOException{
        // Sử dụng try-with-resources để tự động đóng file sau khi ghi xong.
        // FileWriter: mở file để ghi. BufferedWriter: bộ đệm giúp ghi nhanh hơn.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
                writer.write("id,name,age,gpa");
                writer.newLine(); // xuống dòng

                for (Student s : students){
                    writer.write(toCsv(s));
                    writer.newLine();
                }
        }
    }
    //Đọc file rồi hiển thị danh sách
    public static List<Student> load (String filePath) throws IOException{
        List<Student> list =new ArrayList<>(); // tạo danh sách rổng chứa học sinh
        File file   =new File(filePath); //tạo đối tượng đường dẫn file

        if (!file.exists()) return list;

        try (BufferedReader reader  = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine())!=null){
                if (line.trim().isEmpty()) continue;

                if (firstLine && line.startsWith("id")){
                    firstLine = false;
                    continue;
                }
                firstLine=false;

                Student s =fromCsv(line);
                if(s != null )list.add(s);
            }
        }
        return list;
    }
}
