package christmas_Eve;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {
	
	public static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		int count = 0,sum = 0;
		double avg;
		
		//생성
		try {
			fr = new FileReader("d:/naver1210/score.txt");
			System.out.println("파일을 찾았습니다.");
			br = new BufferedReader(fr);
			while(true) {
				//파일에서 한 줄 씩 읽기 
				String s = br.readLine();
				//null일 경우 갯수에도 포함 안되고 while 문을 빠져나갈거임
				if(s == null)
					break;
				try {
				int score=Integer.parseInt(s);
				count++;
				sum+=score;
				System.out.println(count+"=> "+score+"점");
				}catch(NumberFormatException e) {
					System.out.println("\t 문자가 포함됨.");
				}
			}
			avg = (double)sum/count;
			System.out.println("점수 갯수:"+count);
			System.out.println("총점:"+sum);
			System.out.printf("평균:%.2f\n",avg);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
			System.out.println("에러가 발생했습니다:"+e.getMessage());
			}
			
		}
		
	
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
		
		System.out.println("** 정상 종료 **");
		
	}

}
