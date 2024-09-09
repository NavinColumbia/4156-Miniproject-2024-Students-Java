package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/** This class is for testing purposes. */
@SpringBootTest
@ContextConfiguration
public class DepartmentTest {
  public static HashMap<String, Department> departmentMapping;
  public static Department testDept;
  public static Department testDept2;

  @BeforeAll
  public static void setupDeptForTesting() {

    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String[] locations = {"417 IAB", "309 HAV", "301 URIS"};

    String filePath = "./data.txt";
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
      Object obj = in.readObject();
      if (obj instanceof HashMap) {
        departmentMapping = (HashMap<String, Department>) obj;
        String testDeptCode = "COMS";
        testDept = departmentMapping.get(testDeptCode);

      } else {
        throw new IllegalArgumentException("Invalid object type in file.");
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
     testDept2 = new Department("RAND", new HashMap<>(), "randchair", 0);
    testDept2.createCourse("id", "instructor", "location", "time", 5);
  }

  @Test
  public void toStringDept() {
    String expected =
        "COMS 3827: \n"
            + "Instructor: Daniel Rubenstein; Location: 207 Math; Time: 10:10-11:25\n"
            + "COMS 1004: \n"
            + "Instructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55\n"
            + "COMS 3203: \n"
            + "Instructor: Ansaf Salleb-Aouissi; Location: 301 URIS; Time: 10:10-11:25\n"
            + "COMS 4156: \n"
            + "Instructor: Gail Kaiser; Location: 501 NWC; Time: 10:10-11:25\n"
            + "COMS 3157: \n"
            + "Instructor: Jae Lee; Location: 417 IAB; Time: 4:10-5:25\n"
            + "COMS 3134: \n"
            + "Instructor: Brian Borowski; Location: 301 URIS; Time: 4:10-5:25\n"
            + "COMS 3251: \n"
            + "Instructor: Tony Dear; Location: 402 CHANDLER; Time: 1:10-3:40\n"
            + "COMS 3261: \n"
            + "Instructor: Josh Alman; Location: 417 IAB; Time: 2:40-3:55\n";
    assertEquals(expected, testDept.toString());
  }

  @Test
  public void test2Dept() {
    testDept2.dropPersonFromMajor();
    testDept2.addPersonToMajor();
    testDept2.addPersonToMajor();
    testDept2.dropPersonFromMajor();
    assertEquals(1, testDept2.getNumberOfMajors());
  }
}
