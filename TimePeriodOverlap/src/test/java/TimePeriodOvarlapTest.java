import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

public class TimePeriodOvarlapTest {

	

	@Test
	public void testTimePeriodOverlap() {
		TimePeriod timePeriod1 = new TimePeriod(LocalTime.of(18, 30), LocalTime.of(22, 30));
		TimePeriod timePeriod2 = new TimePeriod(LocalTime.of(15, 20), LocalTime.of(19, 00));
		boolean isOverlaping = timePeriod1.overlapsWith(timePeriod2);
		
		assertTrue(isOverlaping);
		
	}
	
	@Test
	public void testWhenOneTimePeriodIsNull(){
		TimePeriod timePeriod1 = new TimePeriod(LocalTime.of(18, 30), LocalTime.of(22, 30));
		TimePeriod timePeriod2 = null;
		try{
		timePeriod1.overlapsWith(timePeriod2);
		fail();
		} catch(IllegalArgumentException e){
			assertEquals("The time period is null", e.getMessage());
			
		}
	
	}
	


}
