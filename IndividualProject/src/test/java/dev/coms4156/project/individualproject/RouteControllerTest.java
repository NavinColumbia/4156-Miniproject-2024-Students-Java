package dev.coms4156.project.individualproject;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/** This class contains all the API routes for the system. */
@ExtendWith(SpringExtension.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {
  @Autowired private MockMvc mvc;

  @Test
  void retrieveCoursesTest() throws Exception {
    String expected =
        "Instructor: Szabolcs Marka; Location: 301 PUP; Time: 2:40-3:55\n"
            + "\n"
            + "Instructor: Patricia G Lindemann; Location: 501 SCH; Time: 1:10-2:25\n";

    mvc.perform(get("/retrieveCourses?courseCode=1001"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void retrieveDepartmentTest() throws Exception {
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
            + "Instructor: Josh Alman; Location: 417 IAB; Time: 2:40-3:55";

    mvc.perform(get("/retrieveDept?deptCode=COMS"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void retrieveCourseTest() throws Exception {
    String expected = "\n" + "Instructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55";

    mvc.perform(get("/retrieveCourse?deptCode=COMS&courseCode=1004"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void isCourseFullTest() throws Exception {
    String expected = "false";
    mvc.perform(get("/isCourseFull?deptCode=COMS&courseCode=1004"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void getMajorCountFromDeptTest() throws Exception {
    String expected = "There are: 2700 majors in the department";
    mvc.perform(get("/getMajorCountFromDept?deptCode=COMS"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void idDeptChairTest() throws Exception {
    String expected = "Luca Carloni is the department chair.";
    mvc.perform(get("/idDeptChair?deptCode=COMS"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void findCourseLocationTest() throws Exception {
    String expected = "428 PUP is where the course is located.";
    mvc.perform(get("/findCourseLocation?deptCode=PHYS&courseCode=1201"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void findCourseInstructorTest() throws Exception {
    String expected = "Eric Raymer is the instructor for the course.";
    mvc.perform(get("/findCourseInstructor?deptCode=PHYS&courseCode=1201"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void findCourseTimeTest() throws Exception {
    String expected = "The course meets at: 2:40-3:55";
    mvc.perform(get("/findCourseTime?deptCode=PHYS&courseCode=1201"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void addMajorToDeptTest() throws Exception {
    String expected = "Attribute was updated successfully";
    mvc.perform(patch("/addMajorToDept?deptCode=IEOR"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  // removeMajorFromDept
  @Test
  void removeMajorFromDeptTest() throws Exception {
    String expected = "Attribute was updated or is at minimum";
    mvc.perform(patch("/removeMajorFromDept?deptCode=IEOR"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  // dropStudentFromCourse
  @Test
  void dropStudentFromCourseTest() throws Exception {
    String expected = "Student has been dropped.";
    mvc.perform(patch("/dropStudentFromCourse?deptCode=IEOR&courseCode=2500"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void setEnrollmentCountTest() throws Exception {
    String expected = "Attributed was updated successfully.";
    mvc.perform(patch("/setEnrollmentCount?deptCode=IEOR&courseCode=2500&count=10"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void changeCourseTimeTest() throws Exception {
    String expected = "Attributed was updated successfully.";
    mvc.perform(patch("/changeCourseTime?deptCode=IEOR&courseCode=2500&time=4:10-5:25"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  // changeCourseTeacher
  @Test
  void changeCourseTeacherTest() throws Exception {
    String expected = "Attributed was updated successfully.";
    mvc.perform(patch("/changeCourseTeacher?deptCode=IEOR&courseCode=2500&teacher=Mark Dean"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void changeCourseLocationTest() throws Exception {
    String expected = "Attributed was updated successfully.";
    mvc.perform(patch("/changeCourseLocation?deptCode=IEOR&courseCode=2500&location=301 URIS"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void enrollStudentInCourseTestMaxReached() throws Exception {
    String expectedRes = "Unable to enroll. Course has already reached max capacity.";
    mvc.perform(patch("/enrollStudentInCourse?deptCode=IEOR&courseCode=2500"))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(content().string(containsString(expectedRes)));
  }

  @Test
  void enrollStudentInCourseTestMaxNotReached() throws Exception {
    String expected = "Successfully enrolled.";
    mvc.perform(patch("/enrollStudentInCourse?deptCode=PHYS&courseCode=1201"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void indexTest() throws Exception {
    String expected =
        "Welcome, in order to make an API call direct your browser or Postman to an endpoint "
            + "\n\n This can be done using the following format: \n\n http:127.0.0"
            + ".1:8080/endpoint?arg=value";
    mvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
    mvc.perform(get("/index"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
    mvc.perform(get("/home"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }

  @Test
  void testNotFound() throws Exception {

    mvc.perform(get("/retrieveCourses?courseCode=C")).andExpect(status().isNotFound());
    mvc.perform(get("/retrieveDept?deptCode=C")).andExpect(status().isNotFound());
    mvc.perform(get("/retrieveCourse?deptCode=COMS&courseCode=1")).andExpect(status().isNotFound());
    mvc.perform(get("/isCourseFull?deptCode=COMS&courseCode=1")).andExpect(status().isNotFound());
    mvc.perform(get("/getMajorCountFromDept?deptCode=C")).andExpect(status().isNotFound());
    mvc.perform(get("/idDeptChair?deptCode=C")).andExpect(status().isNotFound());
    mvc.perform(get("/findCourseLocation?deptCode=PHYS&courseCode=1"))
        .andExpect(status().isNotFound());
    mvc.perform(get("/findCourseInstructor?deptCode=PHYS&courseCode=1"))
        .andExpect(status().isNotFound());
    mvc.perform(get("/findCourseTime?deptCode=PHYS&courseCode=1")).andExpect(status().isNotFound());
    mvc.perform(patch("/addMajorToDept?deptCode=I")).andExpect(status().isNotFound());
    mvc.perform(patch("/removeMajorFromDept?deptCode=I")).andExpect(status().isNotFound());
    mvc.perform(patch("/dropStudentFromCourse?deptCode=IEOR&courseCode=2"))
        .andExpect(status().isNotFound());
    mvc.perform(patch("/setEnrollmentCount?deptCode=IEOR&courseCode=2&count=10"))
        .andExpect(status().isNotFound());
    mvc.perform(patch("/changeCourseTime?deptCode=IEOR&courseCode=2&time=4:10-5:25"))
        .andExpect(status().isNotFound());
    mvc.perform(patch("/changeCourseTeacher?deptCode=abc&courseCode=1&teacher=M"))
        .andExpect(status().isNotFound());
    mvc.perform(patch("/changeCourseLocation?deptCode=abc&courseCode=0&location=abc"))
        .andExpect(status().isNotFound());
    mvc.perform(patch("/enrollStudentInCourseTest?deptCode=abc&courseCode=0"))
        .andExpect(status().isNotFound());
  }
}
