package review;

public class VideoReviewUi {
	// member field
	private int videoNo;
	private VideoReviewDao videoReviewDao;
	
	// 기본 생성자
	private VideoReviewUi() {}
	// 변수 받는 생성자
	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
	}
	
	// singleton을 위한 instance 생성
	private static VideoReviewUi instance = new VideoReviewUi();
	// instance 접근
	public static VideoReviewUi getInstance() {return instance;}
	
	
	// methods
	// 서비스
	public void service() {
		
	}
	
	// review list 보여주기
	private void listReview() {
		
	}
	
	// review 작성화면 보여주기
	private void registerReview() {
		
	}
	
}
