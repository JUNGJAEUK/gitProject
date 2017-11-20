package p348;

//InvalidWithdraw 예외 구현.
class InvalidWithdraw extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidWithdraw(String msg) {
		super(msg);
	}
}
class BankAccount {
	public int minMoney;         // 최저잔금
	public int money;            
	public int myMoney = 0;
	
	public BankAccount(int minMoney) {  // 최저잔금 저장 생성자
		this.minMoney = minMoney;
	}
	
	public int deposit(int money) {    // 입금 메소드
		myMoney += money;
		System.out.println("정상 입금처리: 입금 금액 :"+money+", 잔금: "+ myMoney);
		return myMoney;
	}
	
	public int withdraw(int money) throws InvalidWithdraw{	//출금메소드.
		myMoney -= money;
		if(money < 0) {     // 인출요청금액이 음수일경우 에러 발생.
			throw new InvalidWithdraw("인출요청금액이 음수값입니다.");	
		}
		else if(myMoney < minMoney) {   // 최저잔금 이하로 인출요청시 에러발생.
			throw new InvalidWithdraw("설정한 최저잔금 이하로 인출요청하셨습니다.");	
		}
		else {
			System.out.println("정상 출금처리: 인출금액 : "+ money+ ", 잔금 : "+ myMoney);
		}
		return myMoney;
	}
}
public class ans3 {
	public static void main(String[] args) throws InvalidWithdraw {
		BankAccount ba = new BankAccount(-100000);
		ba.deposit(100000);
		ba.withdraw(100000);
		ba.withdraw(200000);
	}
}
