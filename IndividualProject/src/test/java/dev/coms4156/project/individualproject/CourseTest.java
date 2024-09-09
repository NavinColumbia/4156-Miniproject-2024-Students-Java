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
public class CourseTest {

  @BeforeAll
  public static void setupCourseForTesting() {
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String[] locations = {"417 IAB", "309 HAV", "301 URIS"};

    // data for coms dept
    testCourse1 = new Course("Adam Cannon", locations[0], times[0], 400);

    String filePath = "./data.txt";
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
      Object obj = in.readObject();
      if (obj instanceof HashMap) {
        departmentMapping = (HashMap<String, Department>) obj;
        String testDeptCode = "COMS";
        HashMap<String, Course> coursesMapping =
            departmentMapping.get(testDeptCode).getCourseSelection();
        testCourse2 = coursesMapping.get("1004");
      } else {
        throw new IllegalArgumentException("Invalid object type in file.");
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    // coursesMapping = departmentMapping.get(deptCode).getCourseSelection();

    // testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }

  @Test
  public void toStringTest1() {

    String expectedResult1 = testCourse2.toString();
    assertEquals(expectedResult1, testCourse1.toString());
  }

  @Test
  public void toStringTest2() {
    String expectedResult2 = "\nInstructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult2, testCourse1.toString());
  }

  @Test
  public void enrollTest() {


      testCourse1.setEnrolledStudentCount(500);

    assertEquals(false, testCourse1.enrollStudent());
  }


  @Test
  public void enrollTest2() {

    testCourse2.setEnrolledStudentCount(0);

    assertEquals(true, testCourse2.enrollStudent());
  }
  @Test
  public void isFullTest() {


    testCourse1.setEnrolledStudentCount(500);

    assertEquals(true, testCourse1.isCourseFull());
  }

  @Test
  public void isFullTest2() {


    testCourse2.setEnrolledStudentCount(100);

    assertEquals(false, testCourse2.isCourseFull());
  }




  @Test
  public void dropTest() {
   // testCourse1.setEnrolledStudentCount(500);
    for(int i=0;i<500;i++)
    {
      testCourse1.enrollStudent();

    }
    assertEquals(true, testCourse1.dropStudent());
  }

  @Test
  public void dropTest2() {
    testCourse2.setEnrolledStudentCount(0);
    testCourse2.dropStudent();

    assertEquals(false, testCourse2.dropStudent());
  }



  /** The test course instance used for testing. */
  public static Course testCourse1;

  public static Course testCourse2;

  public static HashMap<String, Department> departmentMapping;
}
