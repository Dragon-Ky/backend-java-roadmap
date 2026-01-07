import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceV2Test {

    private StudentServiceV2 service;

    @BeforeEach
    void setup() {
        StudentRepository repo = new InMemoryStudentRepository();
        service = new StudentServiceV2(repo);
    }

    @Test
    void addStudent_shouldReturnTrue_whenValid() {
        boolean ok = service.addStudent(new Student("S01", "An", 20, 3.5));
        assertTrue(ok);
        assertEquals(1, service.count());
    }

    @Test
    void addStudent_shouldReturnFalse_whenDuplicateId() {
        service.addStudent(new Student("S01", "An", 20, 3.5));
        boolean ok2 = service.addStudent(new Student("S01", "Binh", 21, 3.2));
        assertFalse(ok2);
        assertEquals(1, service.count());
    }

    @Test
    void updateGpa_shouldFail_whenIdNotFound() {
        boolean updated = service.updateGpa("S99", 3.0);
        assertFalse(updated);
    }

    @Test
    void updateGpa_shouldFail_whenGpaInvalid() {
        service.addStudent(new Student("S01", "An", 20, 3.5));
        boolean updated = service.updateGpa("S01", 5.0);
        assertFalse(updated);
    }

    @Test
    void removeById_shouldWork() {
        service.addStudent(new Student("S01", "An", 20, 3.5));
        assertTrue(service.deleteById("S01"));
        assertEquals(0, service.count());
    }
}
