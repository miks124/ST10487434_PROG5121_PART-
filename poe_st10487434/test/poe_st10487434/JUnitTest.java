/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe_st10487434;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 
import poe_st10487434.Login;

/**
 *
 * @author mikhy
 */

class JUnitTest { 
public Login login; 

@BeforeEach 
void setUp() { 
login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976"); 
} 
@Test 
void checkUserName_valid() { 
assertTrue(login.checkUserName("kyl_1")); 
} 
@Test 
void checkUserName_invalid() { 
assertFalse(login.checkUserName("kyle!!!!!!!")); 
} 
@Test 
void checkPasswordComplexity_valid() { 
assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!")); 
    } 
 
    @Test 
    void checkPasswordComplexity_invalid() { 
        assertFalse(login.checkPasswordComplexity("password")); 
    } 
 
    @Test 
    void checkCellPhoneNumber_valid() { 
        assertTrue(login.checkCellPhoneNumber("+27838968976")); 
    } 
 
    @Test 
    void checkCellPhoneNumber_invalid() { 
        assertFalse(login.checkCellPhoneNumber("08966553")); 
    } 
 
    @Test 
    void registerUser_invalidUsername_message() { 
        String actual = login.registerUser("invalidUser", "Ch&&sec@ke99!"); 
        String expected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length"; 
        assertEquals(expected, actual); 
    } 
 
    @Test 
    void registerUser_invalidPassword_message() { 
        String actual = login.registerUser("kyl_1", "password"); 
        String expected = "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."; 
        assertEquals(expected, actual); 
    } 
 
    @Test 
    void registerUser_invalidCell_message() { 
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!"); 

        String expected = "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again."; 
        assertEquals(expected, actual); 
    } 
 
    @Test 
    void registerUser_allValid_containsSuccessParts() { 
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!");
 
        assertTrue(actual.contains("Welcome Kyle Smith it is great to see you.")); 

        assertTrue(actual.contains("Password successfully captured.")); 
        assertTrue(actual.contains("Cell number succesfully captured.")); 
    } 
 
    @Test 
    void loginUser_success_and_statusMessage() { 
        login.loginUser("kyl_1", "Ch&&sec@ke99!"); 
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!")); 
        String expected = "Welcome Kyle Smith it is great to see you."; 
        assertEquals(expected, login.returnLoginStatus(true)); 
    } 
 
    @Test 
    void loginUser_failure_and_statusMessage() { 
        login.loginUser("kyl_1", "password"); 
        assertFalse(login.loginUser("kyl_1", "wrongPass")); 
        String expected = "Unfortunately the login has failed."; 
        assertEquals(expected, login.returnLoginStatus(false)); 
    } 
}
