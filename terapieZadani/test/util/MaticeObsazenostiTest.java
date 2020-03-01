package util;

import terapie.PracovniDoba;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TestName;
import static terapie.Terapie.*;
import terapie.Termin;
import static terapie.TrvaniTerapie.*;

/**
 *
 * @author karel@simerda.cz
 */
public class MaticeObsazenostiTest {

    static int counter = 1;
    @Rule
    public TestName testName = new TestName();

    static void print(String methodName) {
        System.out.println(String.format("%03d ", counter++) + "MaticeObsazenosti." + methodName);
    }

    public MaticeObsazenostiTest() {
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
    public void test_01_01_PocetRadkuSeDny() {
        print(testName.getMethodName());
        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 20)),
                        new PracovniDoba(8, 16));
        int expResult = 20;
        int result = instance.getPocetDnu();
        assertEquals(expResult, result);
    }

    @Test
    public void test_01_02_PocetSloupcuShodinami() {
        print(testName.getMethodName());
        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 20)),
                        new PracovniDoba(8, 16));
        int expResult = 8;
        int result = instance.getPocetHodin();
        assertEquals(expResult, result);

    }

    @Test
    public void test_02_01_GetMaticeChar() {
        print(testName.getMethodName());
        char znakVolno = '+';
        char znakObsazeno = '-';
        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 10));
        char[][] expResult = {{'+', '+'}, {'+', '+'}, {'+', '+'}};
        char[][] result = instance.getMaticeChar(znakVolno, znakObsazeno);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void test_02_02_GetMaticeChar() {
        print(testName.getMethodName());
        char znakVolno = '+';
        char znakObsazeno = '-';
        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));
        instance.setObsazeni(DateTimeUtil.convert("2021.2.01 8h"), 2);
        instance.setObsazeni(DateTimeUtil.convert("2021.2.02 8h"), 2);
        instance.setObsazeni(DateTimeUtil.convert("2021.2.03 10h"), 2);
        char[][] expResult = {{'-', '-', '+', '+'}, {'-', '-', '+', '+'}, {'+', '+', '-', '-'}};
        char[][] result = instance.getMaticeChar(znakVolno, znakObsazeno);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void test_03_01_getDatumACas() {
        print(testName.getMethodName());

        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));
        LocalDateTime expResult = LocalDateTime.of(2021, 2, 1, 8, 0, 0);
        LocalDateTime result = instance.getDatumACas(0, 0);
        assertEquals(expResult, result);

    }

    @Test
    public void test_03_02_getDatumACas() {
        print(testName.getMethodName());

        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));
        LocalDateTime expResult = LocalDateTime.of(2021, 2, 1, 10, 0, 0);
        LocalDateTime result = instance.getDatumACas(0, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void test_03_03_getDatumACas() {
        print(testName.getMethodName());

        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));
        LocalDateTime expResult = LocalDateTime.of(2021, 2, 3, 11, 0, 0);
        LocalDateTime result = instance.getDatumACas(2, 3);
        assertEquals(expResult, result);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_03_04_getDatumACas() {
        print(testName.getMethodName());

        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));

        instance.getDatumACas(2, 4);
        fail();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_03_05_getDatumACas() {
        print(testName.getMethodName());

        MaticeObsazenosti instance
                = new MaticeObsazenosti(new Obdobi(
                        LocalDate.of(2021, 2, 1),
                        LocalDate.of(2021, 2, 3)),
                        new PracovniDoba(8, 12));

        instance.getDatumACas(3, 3);
        fail();
    }

}
