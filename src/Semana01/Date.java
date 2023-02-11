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

	//Para testar daysInMonth
	/*public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		System.out.print("introduza o ano:");
		int year = sc.nextInt(); 
		System.out.print("introduza o mês:");
		int month = sc.nextInt(); 
		System.out.println("" + daysInMonth(month,year));
	}*/

	private boolean isBissexto (int year){
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
	
	//Ex:1
	//usando o scanner 
	/*public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		System.out.print("introduza o mês:");
		int month = sc.nextInt(); 
		System.out.print("introduza o dia:");
		int day = sc.nextInt(); 
		System.out.print("introduza o ano:");
		int year = sc.nextInt(); 
		Date date = new Date(month, day, year);
		System.out.println("Data: " + date.toString());
	}*/

	//Sem usar o scanner
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
		//ou : System.out.println(date); porque por defeito o metodo toString já existe 
	}*/
	
	//Ex: 2
	//Metodos
	private boolean before(Date d){
		Date date = new Date (month, day, year);
		if(d.getYear() > date.getYear()){
			return false; 
		}else if(d.getMonth() > date.getMonth()){
			return false;
		}else if(d.getDay() > date.getDay()){
			return false;
		}else{
			return true;
		}
	}

	private int daysBetween(Date d){
		Date date = new Date (month, day, year);
		int daysBetween = 0; 
		if(d == date){
			daysBetween = 0; 
		}

		return daysBetween;
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
		System.out.print("Before:" + date.before(d));
		//
	}
}
