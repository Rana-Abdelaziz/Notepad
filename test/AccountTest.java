/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import notebad.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2y
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void withdrawTest(){
       Account c= new Account(100.0);
      c.setBalance(20);
      c.deposit(5000);
      c.withdraw(100);
      double expResult= c.getBalance();
        assertEquals(4920,expResult,0);
        
   
   }
}
