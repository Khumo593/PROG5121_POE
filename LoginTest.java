package com.mycompany.prog5121_poe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testCheckUserNameCorrect() {
        assertTrue(login.checkUserName("kyl_1"));
    }
    @Test
    public void testCheckUserNameWrong() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }
    @Test
    public void testCheckPasswordComplexityCorrect() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    @Test
    public void testCheckPasswordComplexityWrong() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    @Test
    public void testCheckCellPhoneCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    @Test
    public void testCheckCellPhoneWrong() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    @Test
    public void testRegisterSuccess() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("User registered successfully.", result);
    }
    @Test
    public void testLoginSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    @Test
    public void testLoginFail() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "wrong"));
    }
    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String msg = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertTrue(msg.contains("Welcome"));
    }
}