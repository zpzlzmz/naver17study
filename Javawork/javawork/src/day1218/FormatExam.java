package day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatExam {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		//내가 원하는 포멧 양식으로 출력해보자		
		//M:월, m:분 , H:24시간, h: 12시간
		SimpleDateFormat sin1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sin2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		SimpleDateFormat sin3 = new SimpleDateFormat("yyyy년MM월dd일 HH:mm EEE");
		SimpleDateFormat sin4 = new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
		
		System.out.println(sin1.format(date));
		System.out.println(sin2.format(date));
		System.out.println(sin3.format(date));
		System.out.println(sin4.format(date));
		
		
		int num1=45678900;
		int num2 = 34567;
		
		NumberFormat nf1 = NumberFormat.getInstance();//number format -> 45,678,900 이런식으로 나눌때 씀
//		System.out.println("num1="+nf1.format(num1));
//		System.out.println("num2="+nf1.format(num2));
		
		NumberFormat nf2=NumberFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println("num1="+nf2.format(num1));
		System.out.println("num2="+nf2.format(num2));
		
	}

}


