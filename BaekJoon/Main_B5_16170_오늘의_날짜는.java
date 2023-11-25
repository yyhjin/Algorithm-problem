import java.time.LocalDate;

public class Main_B5_16170_오늘의_날짜는 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue());
		System.out.println(date.getDayOfMonth());
	}

}
