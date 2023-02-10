package Semana01;
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
	
	private int daysInMonth(int month, int year) {
		//TODO 
	}
	
	public int month() {
		return month; 
	}
	
	public int day() {
		return day; 
	}
	
	public int year() {
		return year;
	}
	
	//por defeito esta classe jÃ¡ existe 
	@Override
	public String toString() {
		return month + "/" + day + "/" + year; 
	}
	
	public static void main(String[] args) {
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

	}

}
