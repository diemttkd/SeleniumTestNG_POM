package KieuDiem.testcase;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
    @Test
    @Parameters({"number1", "number2"})
    public void cong2so(int num1, @Optional("10") int num2){
        System.out.println(num1 + num2);
    }
    @Test
    @Parameters({"message"})
    public void notifications(String mess){
        System.out.println(mess);
    }
}
