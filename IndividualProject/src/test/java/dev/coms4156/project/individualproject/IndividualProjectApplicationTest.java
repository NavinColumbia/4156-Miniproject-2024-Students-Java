package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/** This class. */
@SpringBootTest
@ContextConfiguration
public class IndividualProjectApplicationTest {

  public static IndividualProjectApplication testob;

  @BeforeAll
  public static void setupForTesting() {
    testob = new IndividualProjectApplication();
  }

  @Test
  public void setup() {
    assertAll(
        () -> {
          testob.run(new String[] {"setup"});
        });
  }

  @Test
  public void start() {
    assertAll(
        () -> {
          testob.run(new String[] {"start"});
        });
  }

  @Test
  public void reset() {
    assertAll(
        () -> {
          testob.resetDataFile();
        });
  }

  @Test
  public void terminate() {
    assertAll(
        () -> {
          testob.onTermination();
        });
  }

  @Test
  public void overridetest() {
    assertAll(
        () -> {
          testob.overrideDatabase(new MyFileDatabase(0, "./src/test/resources/data.txt"));
        });
  }

  @Test
  public void runtest() {
    assertAll(
        () -> {
          testob.main(new String[] {"setup"});
        });
  }

  // onTermination()

}
