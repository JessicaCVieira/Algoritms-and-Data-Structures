package Semana01;

import java.util.Scanner;

public class Date {

	private int day; 
	private int month; 
	private int year; 
	
	//construtor
	public Date (int month, int day, int year) {

		if(!validDate(month, day, year))
			throw new IllegalArgumentException("Invalid date!"); 
		this.month = month; 
		this.day = day; 
		this.year = year; 
	} 
	
	//funções auxiliares ao construtor
	private boolean validDate(int month, int day, int year) {

		if(year < 0)
			return false; 
		if (month > 12 || month < 1)
			return false; 
		if(day < 1 || day > daysInMonth(month, year))
			return false;	
		return true; 
	}
	
	private int daysInMonth(int month, int year) {

		int daysInMonth= 0; 
		if (month == 2){
			if (isBissexto(year)){
				daysInMonth = 29; 
			}else{
				daysInMonth = 28;
			}

		}else{
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
				daysInMonth = 31; 
			}else{
				daysInMonth = 30; 
			}
		}
		return daysInMonth;
	} 

	private boolean isBissexto (int year){

		if(div(year, 400)){
			return true; 
		}else if(div(year,4) && !div(year,100)){
			return true; 
		}else{
			return false; 
		}
	}

	private boolean div (int year, int n){

		if((year % n) == 0){
			return true; 
		}else{
			return false; 
		}
	}

	//Getters
	public int getMonth() {
		return month; 
	}
	
	public int getDay() {
		return day; 
	}
	
	public int getYear() {
		return year;
	}
	
	//usa-se o override porque por defeito esta classe já existe
	@Override
	public String toString() {
		return month + "/" + day + "/" + year; 
	}

	//Ex: 2
	//Metodos
	private boolean before(Date d){

		Date date = new Date (month, day, year);
		if(d.getYear() < date.getYear()){
			return false; 
		}else if(d.getYear() > date.getYear()){
			return true; 
		}else{
			if(d.getMonth() < date.getMonth()){
				return false;
			}else if (d.getMonth() > date.getMonth()){
				return true; 
			}else{
				if(d.getDay() < date.getDay()){
					return false;
				}else if(d.getDay() > date.getDay()){
					return true;
				}else{
					System.out.print("They are the same date");
					return true;
				}
			}
		}
	}

	private int daystoEndYear(){
	
		Date date = new Date(month, day, year);
		Date d = new Date (12,31,year);
		int days = 0; 
		if(date.getMonth() < 12){
			for(int i = date.getMonth(); i < d.getMonth(); i++){
				days += daysInMonth(i, year);
			}
			days += d.getDay() - date.getDay();
		}else{
			days += d.getDay() - date.getDay(); 
		}
		return days; 
	}

	private int dayssinceBeginYear(){
		
		Date date = new Date(month, day, year);
		Date d = new Date (1,1,year);
		int dayssinceBeginYear = 0;  
		if(date.getMonth() > 1){
			for(int i = date.getMonth(); i > d.getMonth(); i--){
				dayssinceBeginYear += daysInMonth(i, year);
			}
			dayssinceBeginYear += date.getDay() - d.getDay();
		}else{
			dayssinceBeginYear += date.getDay() - d.getDay(); 
		}
		return dayssinceBeginYear; 
	}


	private int daysBetween(Date d){

		Date date = new Date (month, day, year);
		int daysBetween = 0; 
		if(d.getDay() == date.getDay() && d.getMonth() == date.getMonth() && d.getYear() == date.getYear()){
			daysBetween = 0;
		}else if(d.getYear() == date.getYear()){
			if(d.getMonth() == date.getMonth()){
				daysBetween = daysSameMonth(date,d);
			}else{
				daysBetween = daysDifMonth(date, d); 
			}
		}else{
			daysBetween = daysDifYear(date, d); 
		}
		if(!before(d)){
			daysBetween = daysBetween * -1; 
		}
		return daysBetween;
	}

	//Aux
	private int daysSameMonth (Date date, Date d){
		int countDay = 0; 
		if(d.getDay() > date.getDay()){
			countDay = d.getDay() - date.getDay();
		}else{
			countDay = date.getDay() - d.getDay();
		}
		return countDay; 
	}

	private int daysDifMonth (Date date, Date d){

		int daysMonth = 0; 
		if(date.getMonth() < d.getMonth()){
			for(int i = date.getMonth(); i < d.getMonth(); i++){
				daysMonth += daysInMonth(i, year);
			}
			if(date.getDay() < d.getDay()){
				daysMonth += daysSameMonth(date, d);
			}else{
				daysMonth -= daysSameMonth(date, d);
			}
		}else{
			for(int i = d.getMonth(); i < date.getMonth(); i++){
				daysMonth += daysInMonth(i, year);
			}
			if(date.getDay() < d.getDay()){
				daysMonth -= daysSameMonth(date, d);
			}else{
				daysMonth += daysSameMonth(date, d);
			}
		}
		return daysMonth; 
	}

	private int daysDifYear (Date date, Date d){

		int daysBetweenYear1 = 0; 
		if(date.getYear() > d.getYear()){
			for(int i = date.getYear(); i > d.getYear(); i--){
				daysBetweenYear1 += daysInYear(i);
			}
		}else{
			for(int i = d.getYear(); i > date.getYear(); i--){
				daysBetweenYear1 += daysInYear(i);
			}
		}
		if(date.getMonth() > d.getMonth()){
			daysBetweenYear1 += daysDifMonth(date, d);
		}else{
			daysBetweenYear1 -= daysDifMonth(date, d);
		}
		return daysBetweenYear1; 
	}

	private int daysInYear(int year){

		int daysInYear = 0; 
		if(isBissexto(year)){
			daysInYear = 366; 
		}else{
			daysInYear = 365;
		}
		return daysInYear;
	}

	//main
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in); 
		//date
		System.out.print("introduza o mês:");
		int month = sc.nextInt(); 
		System.out.print("introduza o dia:");
		int day = sc.nextInt(); 
		System.out.print("introduza o ano:");
		int year = sc.nextInt(); 
		Date date = new Date(month, day, year);
		System.out.println("Date: " + date.toString());

		//d
		System.out.print("introduza o mês:");
		int monthd = sc.nextInt(); 
		System.out.print("introduza o dia:");
		int dayd = sc.nextInt(); 
		System.out.print("introduza o ano:");
		int yeard = sc.nextInt(); 
		Date d = new Date(monthd, dayd, yeard);
		System.out.println("d: " + d.toString());

		sc.close();

		//before
		System.out.println("Before:" + date.before(d));
		//daystoEndYear
		System.out.println("Days to the end of the year: " + date.daystoEndYear());
		//dayssinceBeginYear
		System.out.println("Days since the beginning of the year: " + date.dayssinceBeginYear());
		//daysBetween
		System.out.print("The  days between the date: " + date.toString());
		System.out.print(" and the date: " + d.toString());
		System.out.print(" are "+ date.daysDifYear(date,d));
	}
	//TODO -> its wrong bitchhhh
}
