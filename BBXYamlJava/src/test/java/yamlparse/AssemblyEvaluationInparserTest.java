/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yamlparse.datatypes.assemblyevaluation.AssemblyEvaluationTopType;

/**
 *
 * @author mugarov
 */
public class AssemblyEvaluationInparserTest {
    
    public AssemblyEvaluationInparserTest() {
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

    /**
     * Test of parse method, of class AssemblyEvaluationInparser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        AssemblyEvaluationInparser instance = new AssemblyEvaluationInparser();
        instance.updateFile();
        instance.readFile();
        instance.parse();
        boolean found = (instance.getAssemblyEvaluations() == null);
        assertEquals(true, !found);
    }


    /**
     * Test of getEvaluationString method, of class AssemblyEvaluationInparser.
     */
    @Test
    public void testGetEvaluationString() {
        System.out.println("getEvaluationString");
        AssemblyEvaluationTopType aett = null;
        AssemblyEvaluationInparser instance = new AssemblyEvaluationInparser();
        String expResult = "";
        String result = instance.getEvaluationString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


   
    
}
