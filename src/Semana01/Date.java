package Semana01;

import java.util.Scanner;

//TODO: apagar os statics que não estejam na main

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
	
	private boolean validDate(int month, int day, int year) {
		if(year < 0)
			return false; 
		if (month > 12 || month < 1)
			return false; 
		if(day < 1 || day > daysInMonth(month, year))
			return false;	
		return true; 
	}
	
	private static boolean div (int year, int n){
		if((year % n) == 0){
			return true; 
		}else{
			return false; 
		}
	}

	private static boolean isBissexto (int year){
		if(div(year, 400)){
			return true; 
		}else if(div(year,4) && !div(year,100)){
			return true; 
		}else{
			return false; 
		}
	}

	//para testar isBissexto
	//tive que por a função isBissexto e a div como static
	/*public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		System.out.print("introduza o ano:");
		int year = sc.nextInt(); 
		System.out.println("" + isBissexto(year));
	}*/


	private static int daysInMonth(int month, int year) {
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

	/*public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		System.out.print("introduza o ano:");
		int year = sc.nextInt(); 
		System.out.print("introduza o mês:");
		int month = sc.nextInt(); 
		System.out.println("" + daysInMonth(month,year));
	}*/

	public int month() {
		return month; 
	}
	
	public int day() {
		return day; 
	}
	
	public int year() {
		return year;
	}
	
	//por defeito esta classe já existe
	@Override
	public String toString() {
		return month + "/" + day + "/" + year; 
	}
	
	
	//TODO - usar scanners no main 
	/*public static void main(String[] args) {
		if(args.length != 3) {
			System.err.println("Missing data... exiting now!"); 
			System.exit(-1); //se for System.exit(0) significa que nÃ£o houve erro nenhum 
		}
		int month = Integer.parseInt(args[0]); 
		int day = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		
		Date date = new Date (month, day, year); 
		System.out.println(date.toString());
		//ou sÃ³ : System.out.println(date); porque por defeito o toString jÃ¡ existe 

	}*/
	


}
