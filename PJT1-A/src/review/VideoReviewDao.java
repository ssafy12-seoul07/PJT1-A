package review;

import java.util.List;
import java.util.Map;

// Like VideoReviewManager
public class VideoReviewDao {
	// video review data access object
	// member field
	private int reviewNo;
	private Map<Integer, List<VideoReview>> videoReviewDb;
	
	// 기본 생성자
	private VideoReviewDao() {}
	
	// 생성자 singleton을 위해 인스턴스 생성
	private static VideoReviewDao instance = new VideoReviewDao();
	
	// instance 접근
	public static VideoReviewDao getInstance() {return instance;}
	
	// videoNo에 해당하는 비디오의 리뷰 리스트 반환
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.get(videoNo);
	}
	
	
	
}
