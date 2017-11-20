package p348;
import java.util.Calendar;

class PrimeTime implements Runnable {
	int n;
	
	public PrimeTime(int n) {       // 횟수를 인자로 받는 생성자
		this.n = n;
	}
	public PrimeTime(int n,String s) {  // Thread 생성자
		this.n = n;
		Thread.currentThread().setName(s); // 이름받고
	}	
	public void run() {  
		Calendar now = Calendar.getInstance();  // 날짜받고
		for(int i=0;i<n;i++) {
			System.out.println("순위: "+Thread.currentThread().getPriority() +" "+now.getTime()+" "+Thread.currentThread().getName());
		}
	}
}

public class ans7 {
	public static void main(String[] args) {
		PrimeTime p1 = new PrimeTime(3);  // 횟수3번
		Thread th1 = new Thread(p1, "안녕하세요!"); // 이름에 안녕하세요!
		th1.setPriority(Thread.MAX_PRIORITY-1);  
		th1.start();
		
		PrimeTime p2 = new PrimeTime(6);  // 횟수 6번
		Thread th2 = new Thread(p2, "반갑습니다!"); // 이름에 반갑습니다!
		th2.setPriority(Thread.NORM_PRIORITY-1); 
		th2.start();
	}
}
