//Apple.java�� ������ �ϱ����� �⺻ �ڹ�Ŭ������ �����غ����� 

public class Apple{
	public static void main(String []args){
		System.out.println(args[0]); //args�� 0�� �迭���� ��� 
		System.out.println(args[1]); //args�� 1�� �迭���� ��� 
		System.out.println("�� ���� ���غ���");
		System.out.println((args[0])+(args[1]));

		//���ڿ��� ��� �ϱ� ���� ���ڷ� ��ȯ �Ϸ��� integer.parseint
		System.out.println((Integer.parseInt(args[0]))+(Integer.parseInt(args[1])));
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		System.out.println("�� ���� ����"+(su1+su2)+"�Դϴ�.");
	}
}


