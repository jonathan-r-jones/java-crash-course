import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

  @Test
  void appHasAGreeting() {
    App classUnderTest = new App();
    assertEquals(classUnderTest.getGreeting(), "Hello world.");
  }

  @Test
  void appHasAGreeting2() {
    App classUnderTest = new App();
    assertEquals(classUnderTest.getGreeting(), "Hello world.");
  }

}
