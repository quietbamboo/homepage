//Created on Nov 4, 2008 5:31:17 PM
//Author : Junxian Huang
//Email : junxian.huang@gmail.com
package iperf;

public class HjxTimeConverter {
	
	public static void main(String[] argv){
		System.out.println("Time converter works");
		//long milli = HjxTimeConverter.getMilliseconds(1986, 6, 11, 16, 20, 0, 0, -5);
		long milli = HjxTimeConverter.getMilliseconds(2008, 11, 4, 18, 22, 0, 0, -5);
		//long milli = HjxTimeConverter.getMilliseconds(1970, 2, 2, 2, 15, 1, 1, -5);
		System.out.println(milli);
		System.out.println(System.currentTimeMillis());
	}
	
	public static final int BASE_YEAR = 1970;
	public static final int BASE_MONTH = 1;
	public static final int BASE_DAY = 1;
	public static final int BASE_HOUR = 0;
	public static final int BASE_MINUTE = 0;
	public static final int BASE_SECOND = 0;
	
	public static final long MILLI_IN_A_SECOND = 1000;
	public static final long MILLI_IN_A_MINUTE = 60 * MILLI_IN_A_SECOND;
	public static final long MILLI_IN_A_HOUR = 60 * MILLI_IN_A_MINUTE;
	public static final long MILLI_IN_A_DAY = 24 * MILLI_IN_A_HOUR;
	public static final long MILLI_IN_MONTH[] = {
		0, //A pad
		31 * MILLI_IN_A_DAY,
		28 * MILLI_IN_A_DAY,//For leap year, we add one day
		31 * MILLI_IN_A_DAY,
		30 * MILLI_IN_A_DAY,
		31 * MILLI_IN_A_DAY,
		30 * MILLI_IN_A_DAY,
		31 * MILLI_IN_A_DAY,
		31 * MILLI_IN_A_DAY,
		30 * MILLI_IN_A_DAY,
		31 * MILLI_IN_A_DAY,
		30 * MILLI_IN_A_DAY,
		31 * MILLI_IN_A_DAY
	};
	
	
/**
 * @author Junxian Huang
 * @Time Created on Nov 4, 2008 5:31:17 PM<br>
 * Given time is local time based on the supplied time zone<br>
 * @param year
 * @param month
 * @param day
 * @param hour : hour should in 24 hour format, e.g. 8pm should be 20, 12am (midnight) is 0, 12pm (noon) is 12
 * @param minute
 * @param second
 * @param millisecond 
 * @param time_zone : Number follows GMT for your time zone. <br>
 * 					For Ann Arbor (EST which is GMT -5, time_zone = -5)
 * @return Java Milliseconds
 * You can check this using the online converter here (http://www.munc.com/jseffects/timeConverter.html)
 */
	public static long getMilliseconds(int year, int month, int day, int hour, int minute, int second, int millisecond, int time_zone){

		long milli = 0;
		int i;
		for(i = BASE_YEAR ; i < year ; i++){
			if(i % 4 == 0){
			//For leap year
				milli += 366  * MILLI_IN_A_DAY;
			}else{
				milli += 365  * MILLI_IN_A_DAY;
			}
		}
		for(i = BASE_MONTH ; i < month ; i++){
			if(year % 4 == 0 && i == 2){
				//For leap year, February
				milli += MILLI_IN_MONTH[i] + MILLI_IN_A_DAY;
			}else{
				milli += MILLI_IN_MONTH[i];
			}
		}
		for(i = BASE_DAY ; i < day ; i++){
			milli += MILLI_IN_A_DAY;
		}
		for(i = BASE_HOUR ; i < hour ; i++){
			milli += MILLI_IN_A_HOUR;
		}
		for(i = BASE_MINUTE ; i < minute ; i++){
			milli += MILLI_IN_A_MINUTE;
		}
		for(i = BASE_SECOND ; i < second ; i++){
			milli += MILLI_IN_A_SECOND;
		}
		
		milli += millisecond;
		
		milli -= time_zone * MILLI_IN_A_HOUR; //We should subtract here!
		
		return milli;
	}
}
