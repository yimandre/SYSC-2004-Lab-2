import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeaterTest.
 *
 * @author  D.L. Bailey, SCE, Carleton U
 * @version 1.01 November 24, 2010
 * @version 1.02 March 23, 2011
 * @version 1.03 January 11, 2012 (JUnit 3)
 * @version 1.04 February 9, 2012 (converted to JUnit 4)
 */
public class HeaterTest
{
    private Heater heater1;
    private Heater heater2;

    /**
     * Default constructor for test class HeaterTest
     */
    public HeaterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        heater1 = new Heater(10, 30);
	    heater2 = new Heater(0, 30);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
	
	@Test
	public void testWarmer()
	{
	    heater1.warmer();
	    /* By default, raising the Heater object's temperature 
	     * should increase the temperature setting by 5 degrees; 
	     * i.e., from 15 degrees to 20 degrees.
	     */
	    assertEquals(20, heater1.getTemperature());
	}
	
	@Test
	public void testCooler()
	{
	    heater1.cooler();
	    /* By default, lowering the Heater object's temperature 
	     * should decrease the temperature setting by 5 degrees; 
	     * i.e., from 15 degrees to 10 degrees.
	     */	    
	    assertEquals(10, heater1.getTemperature());
	}
	
	@Test
	public void testMax()
	{
	    /* Test a Heater object whose temperature ranges from
	     * 0 degrees to 30 degrees, inclusive, in 5 degree increments.
	     */
	    assertEquals(15, heater2.getTemperature());	    
	    heater2.warmer();
	    assertEquals(20, heater2.getTemperature());
	    heater2.warmer();
	    assertEquals(25, heater2.getTemperature());
	    heater2.warmer();
	    assertEquals(30, heater2.getTemperature());
	    
	    /* The heater is now set to its maximum temperature.
	     * Additional calls to warmer() should not change the temperature.
	     */
	    heater2.warmer();
	    assertEquals(30, heater2.getTemperature());

	    /* Create a Heater object whose temperature ranges from
	     * 0 degrees to 27 degrees, inclusive, in 5 degree increments.
	     */	    
	    Heater heater = new Heater(0, 27);
	    assertEquals(15, heater.getTemperature());	    	    
	    heater.warmer();
	    assertEquals(20, heater.getTemperature());
	    heater.warmer();
	    assertEquals(25, heater.getTemperature());
	    
	    /* The heaster is now 2 degrees below its maximum temperature.
	     * Additional calls to warmer() should not change the temperature.
	     */
	    heater.warmer();
	    assertEquals(25, heater.getTemperature());   	    
	}
	
    @Test
    public void testMin()
	{
	    /* Use a Heater object whose temperature ranges from
	     * 0 degrees to 30 degrees, inclusive, in 5 degree increments.
	     */	    
	    assertEquals(15, heater2.getTemperature());	    	    
	    heater2.cooler();
	    assertEquals(10, heater2.getTemperature());
	    heater2.cooler();
	    assertEquals(5, heater2.getTemperature());
	    heater2.cooler();
	    assertEquals(0, heater2.getTemperature());
	    
	    /* The heater is now set to its minimum temperature.
	     * Additional calls to cooler() should not change the temperature.
	     */
	    heater2.cooler();
	    assertEquals(0, heater2.getTemperature());	 

	    /* Create a Heater object whose temperature ranges from
	     * 3 degrees to 30 degrees, inclusive, in 5 degree increments.
	     */	    
	    Heater heater = new Heater(3, 30);
	    heater.cooler();
	    assertEquals(10, heater.getTemperature());
	    heater.cooler();
	    assertEquals(5, heater.getTemperature());
	    
	    /* The heater is now 3 degrees above its minimum temperature.
	     * Additional calls to cooler() should not change the temperature.
	     */	    
	    heater.cooler();
	    assertEquals(5, heater.getTemperature());    	    
	}		
	
	@Test
	public void testSetIncrement()
	{
 	    heater2.setIncrement(3);
	    heater2.warmer();
	    assertEquals(18, heater2.getTemperature());
	    heater2.cooler();
	    assertEquals(15, heater2.getTemperature());
	}
	
	@Test
	public void testZeroAndNegativeIncrement()
	{
	    heater2.setIncrement(0);
	    /* Increment should remain at 5. */
	    heater2.warmer();
	    assertEquals(20, heater2.getTemperature());
	    
	    heater2.setIncrement(-4);
	    /* Increment should remain at 5. */
	    heater2.warmer();
	    assertEquals(25, heater2.getTemperature());
	}		
}
