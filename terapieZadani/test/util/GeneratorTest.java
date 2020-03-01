
package util;

import sprava.Generator;
import terapie.PracovniDoba;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import terapie.Termin;

/**
 *
 * @author karel@simerda.cz
 */
public class GeneratorTest {
    
    public GeneratorTest() {
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
     * Test of run method, of class Generator.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Obdobi obdobi = new Obdobi("2020.02.01", "2020.02.28");
        PracovniDoba pracovniDoba = new PracovniDoba(8,16);
        int pocetTerapii = 10;
        Termin[] expResult = null;
        Termin[] result = Generator.run(obdobi, pracovniDoba, pocetTerapii);
        int citac = 1;
        for (Termin termin : result) {
            System.out.println(""+(citac++)+" " +termin);
        }
        
    }
    
}
