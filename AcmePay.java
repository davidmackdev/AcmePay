/*
	Author: David
	Date: 	08/02/19
	File: 	AcmePay.java

	This application will take in the hours worked and the shift, that an employee worked, and then output:

	1.	The hourse worked
	2.	The shift they work
	3.	Their hourly pay rate
	4.	Their regular pay for the week
	5.	Their overtime pay for the week
	6.	The total of the regular and the overtime pay
	7.	The amount of money taken for a retirement fund
	8.	Their net pay

*/

import java.util.Scanner;

public class AcmePay
{
	public static void main(String[] args) 
	{
		// Variables and constants
		double hours;
		double overtimeHours = 0;
		String shift;
		double firstShift = 17.0;
		double secondShift = 18.50;
		double thirdShift = 22.0;
		double overtimeRate;
		double retirementRate = 0.03;
		double currentRate;
		double regularPay;
		double overtimePay = 0;
		double retirement = 0;
		double totalPay;
		double netPay;	

		// Scanner Object
		Scanner input = new Scanner(System.in);

		// Gathering input from the user
		System.out.println("");
		System.out.print("Please enter the number of hours work >> ");
		hours = input.nextDouble();	
		input.nextLine();
		System.out.print("Please enter the shift you work (FIRST or SECOND or THIRD) >> ");
		shift = input.nextLine().toUpperCase();

		// If the hours worked was more than 40 then save the extra hours as overtime
		if (hours > 40) {
			overtimeHours = hours - 40;
			hours = 40;
		}
		// Figuring out which shift the employee works in
		if (shift.equals("FIRST")) 
		{
			currentRate = firstShift;	
		}
		else
		{
			if (shift.equals("SECOND")) 
			{
				currentRate = secondShift;
			}
			else
			{
				if (shift.equals("THIRD")) 
				{
					currentRate = thirdShift;
				}
				else
				{
					System.out.println("");
					System.out.println("You have not entered a vaild shift.\nPlease restart application.");
					return;
				}
			}
		}
		

		// Calculation phase
		// Calculating overtime pay
		if (overtimeHours > 0) 
		{
			overtimeRate = currentRate * 1.5;
			overtimePay = overtimeRate * overtimeHours;
		}
		regularPay = hours * currentRate;
		totalPay = regularPay + overtimePay;

		// Calculating retirement plan
		if (shift.equals("SECOND") || shift.equals("THIRD")) 
		{
			retirement = totalPay * retirementRate;
		}
		netPay = totalPay - retirement;


		// Output information to the user
		System.out.println("");
		System.out.println("Hours: " + hours);
		System.out.println("Shift: " + shift);
		System.out.println("Rate: $" + currentRate);
		System.out.println("Regular Pay: $" + regularPay);
		System.out.println("Overtime Pay: $" + overtimePay);
		System.out.println("Retirement Saved: $" + retirement);
		System.out.println("Net Pay: $" + netPay);
	}
}