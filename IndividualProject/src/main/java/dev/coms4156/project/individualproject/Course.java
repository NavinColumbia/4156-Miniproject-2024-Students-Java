package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a course. This class stores information about the location of course, name of the
 * instructor, time slot of course, enrollment capacity, and number of students enrolled.
 */
public class Course implements Serializable {

  /**
   * Constructs a new Course object with the given parameters. Initial count starts at 0.
   *
   * @param instructorName The name of the instructor teaching the course.
   * @param courseLocation The location where the course is held.
   * @param timeSlot The time slot of the course.
   * @param capacity The maximum number of students that can enroll in the course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    if (capacity <= 0 || courseLocation == null || timeSlot == null || instructorName == null) {
      throw new IllegalArgumentException(
          " Course not created, Arguments should not be null or <=0 ");
    }
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 0;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (this.enrolledStudentCount >= this.enrollmentCapacity) {
      return false;
    }
    this.enrolledStudentCount++;
    return true;
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    if (this.enrolledStudentCount <= 0) {
      return false;
    }
    this.enrolledStudentCount--;
    return true;
  }

  /**
   * Standard getter courseLocation.
   *
   * @return courseLocation.
   */
  public String getCourseLocation() {
    return this.courseLocation;
  }

  /**
   * Standard getter for instructorName.
   *
   * @return instructorName.
   */
  public String getInstructorName() {
    return this.instructorName;
  }

  /**
   * Standard getter for courseTimeSlot.
   *
   * @return courseTimeSlot.
   */
  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }

  /**
   * Returns String Representation of the object.
   *
   * @return provides course instructor name, course location and course time slot.
   */
  @Override
  public String toString() {
    return "\nInstructor: "
        + this.instructorName
        + "; Location: "
        + this.courseLocation
        + "; Time: "
        + this.courseTimeSlot;
  }

  /**
   * Standard Setter for instructorName.
   *
   * @param newInstructorName A {@code String} is the new instructor.
   */
  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }

  /**
   * Standard Setter for courseLocation.
   *
   * @param newLocation A {@code String} is the new Location.
   */
  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }

  /**
   * Standard Setter for courseTimeSlot.
   *
   * @param newTime A {@code String} is the new Time Slot.
   */
  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }

  /**
   * Standard Setter for enrolledStudentCount.
   *
   * @param count A {@code int} is the new count.
   */
  public void setEnrolledStudentCount(int count) {
    this.enrolledStudentCount = count;
  }

  /**
   * Checks if course is full.
   *
   * @return true if enrolledStudentCount is equal to or exceeds enrollmentCapacity.
   */
  public boolean isCourseFull() {
    return enrollmentCapacity <= this.enrolledStudentCount;
  }

  @Serial private static final long serialVersionUID = 123456L;

  /** Total number of students allowed to enroll in the course. */
  private final int enrollmentCapacity;

  /** Number of students enrolled in the course. */
  private int enrolledStudentCount;

  /** Location of the course. */
  private String courseLocation;

  /** Name of Course Instructor. */
  private String instructorName;

  /** Time Slot of the course . */
  private String courseTimeSlot;
}
