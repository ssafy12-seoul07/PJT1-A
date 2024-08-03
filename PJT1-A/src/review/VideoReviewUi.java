package review;

import java.util.List;

import util.Util;

public class VideoReviewUi {
	// member field
	private int videoNo;
	private VideoReviewDaoInterface videoReviewDao;
	
	// 기본 생성자
	private VideoReviewUi() {}
	// 변수 받는 생성자
	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
		this.videoReviewDao = VideoReviewDao.getInstance();
	}
		
	// singleton을 위한 instance 생성
	private static VideoReviewUi instance;
	// instance 접근
	public static VideoReviewUi getInstance(int videoNo) {		
		instance = new VideoReviewUi(videoNo);
		return instance;
	}
	
	
	// methods
	// 리뷰 서비스 화면
	public void service() {
		listReview();
		Util.printLine();
		System.out.println("1. 리뷰등록");
		System.out.println("0. 이전으로");
		Util.printLine();
        int menu = Util.inputInt("메뉴를 선택하세요: ");
        
        if(menu == 1) {
        	registerReview();
        	
        } else if(menu == 0) {
        	return;
        	
        } else {
        	System.out.println("1과 0 중에 선택해주세요.");
        	service();
        }
        
	}
	
	// review list 보여주기
	private void listReview() {
		List<VideoReview> videoReviewList = videoReviewDao.selectReview(videoNo);
		
		// 리뷰 없을 시 예외 처리
		if(videoReviewList == null) {
			Util.printLine();
			System.out.println("영상리뷰 : " + 0 + "개");
			Util.printLine();
			return;
		}
		
		// 영상 리뷰 개수 출력
		Util.printLine();
		System.out.println("영상리뷰 : " + videoReviewList.size() + "개");
		Util.printLine();
		
		// 영상 리뷰 리스트 출력
		for(VideoReview videoReview : videoReviewList) {
			System.out.printf("%d %s %s\n", videoReview.getReviewNo(), videoReview.getNickName(), videoReview.getContent());
		}
		Util.printLine();		
			
	}
	
	// review 작성화면 보여주기
	private void registerReview() {
		Util.inputString("닉네임을 입력하세요 : ");
		Util.inputString("내용을 입력하세요 : ");
	}
	
}
