

public class Test{
	public static void main(String []args){
		System.out.println(args[0]);
		System.out.println(args[1]);

		System.out.println(args[0]+args[1]);

		System.out.println((Integer.parseInt(args[0]))+(Integer.parseInt(args[1])));
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("�� ���� ��(int)��"+(a+b) +"�Դϴ�.");
		double c = a;
		double d = b;
		System.out.println("�� ���� ���� "+(c+d) +"�Դϴ�.");
	}
}