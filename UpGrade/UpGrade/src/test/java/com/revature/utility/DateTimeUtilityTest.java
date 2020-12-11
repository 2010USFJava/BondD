package com.revature.utility;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateTimeUtilityTest {

	
	

	

	@Test
	public void testFormatSQLDate() {
		LocalDate LD = LocalDate.of(2020, 12, 2);
		Date date = Date.valueOf(LD);
		String expected = "12/02/2020";
		String actual = DateTimeUtility.formatSQLDate(date);
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testFormatSQLTime() {
		LocalTime LT = LocalTime.of(15, 30, 10);
		Time time = Time.valueOf(LT);
		String expected= "3:30 PM";
		String actual = DateTimeUtility.formatSQLTime(time);
		Assert.assertEquals(expected, actual);
	}

/*	@Test
	public void testStringDateFormat() throws ParseException {
		String testdate = "2020-10-35 11:32:56";
		Calendar calDate = Calendar.getInstance();
		Calendar actual= DateTimeUtility.stringDateFormat(testdate);
		calDate.set(2020, 10, 35, 11, 32, 56);
		Calendar expected = calDate;
		Assert.assertEquals(expected,actual);
		
	}
*/
}
