import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperatorTest {
  
  @Test
  void appHasAGreeting() {
    Operator operatorTest = new Operator();
    assertEquals(operatorTest.smaller(10, 15), 10);
  }

}
