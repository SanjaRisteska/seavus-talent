import java.time.LocalTime;

public class TimePeriod {
	LocalTime startTime;
	LocalTime endTime;
	public TimePeriod(LocalTime startTime, LocalTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public boolean overlapsWith(TimePeriod timePeriod){
		try{
		if(startTime.isBefore( timePeriod.getEndTime()) && endTime.isAfter(timePeriod.getStartTime())){
			return true;
		}
		} catch(Exception e){
			throw new IllegalArgumentException("The time period is null");
		}
		return false;
	}
	

}
