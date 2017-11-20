package p347;
import java.util.Scanner;
public class ans1 {

	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		try {                     // 이걸 하려고함.
			Scanner input = new Scanner(System.in);
			x = input.nextInt();
			y = input.nextInt();
		} catch (Exception e) {    // 예외발생시 출력 (숫자가아니라거나)
			System.out.println("예외발생: " + e);
		} finally {                // 무조건 실행됨
			System.out.println("");
			z = x * y;
			System.out.printf("%d * %d = %d %n", x,y,z);
		}	
	}
}
