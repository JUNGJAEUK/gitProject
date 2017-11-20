package p348;

class PrimeNumber03 implements Runnable {
	int n;
	public PrimeNumber03(int n) {  // 최대숫자 인자로받는 생성자
		this.n = n;
	}
	public PrimeNumber03(int n,String name) {  // Thread생성자-이름포함
		this.n = n;
		Thread.currentThread().setName(name);
	}	
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"); // 이름부터출력

		int a[] = new int[n];
		int cnt=1;  // cnt는 a에 들어있는 원소 갯수임.
		boolean P;  // 소수인지아닌지 판별
		a[0] = 2;
		for(int i=2; i<=n; i++) {
			P = true;
			for(int j=0;j<cnt;j++) {
				if(i%a[j]==0) {
					P = false;  // 소수가아니면 P=false
				}
			}
			if(P == true) {  
				a[cnt]=i;
				cnt++;
			}
		}
		for(int value : a) {
			if(value != 0)
				System.out.print(value+" ");
		}
	}
}

public class ans6 {
	public static void main(String[] args) {
		new Thread(new PrimeNumber03(25), "소수 만드는 스래드").start();
	}
}
