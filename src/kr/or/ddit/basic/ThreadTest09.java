package kr.or.ddit.basic;

// 데몬 쓰레드 연습 ==> 자동 저장 하는 쓰레드
public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSaveTherad autoSave = new AutoSaveTherad();
		
		// 데몬 쓰레드로 설정하기 ==> 반드시 start()메서드 호줄 전에  설정한다.
		autoSave.setDaemon(true);
		
		autoSave.start();

		try {
			for (int i = 0; i <= 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {

		}
		System.out.println("main 쓰레드 종료...");
	}

}

// 자동 저장하는 쓰레드 ==> 3초에 한번씩 자종 저장하는 쓰레드
class AutoSaveTherad extends Thread {
	// 작업 내용을 저장하는 메서드
	public void save() {
		System.out.println("작업 내용을 저장합니다...");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				save();
			} catch (InterruptedException e) {
			}

		}
	}
}
