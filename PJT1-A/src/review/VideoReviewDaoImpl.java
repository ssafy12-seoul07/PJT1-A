package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Like VideoReviewManager
public class VideoReviewDaoImpl implements VideoReviewDao {
	// video review data access object
	// member field
	private static int reviewNo = 0; // 가장 먼저 쓴 리뷰는 1번
	private List<VideoReview> videoReviewList = new ArrayList<>();
	private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();
	
	// 기본 생성자
	private VideoReviewDaoImpl() {}
	
	// 생성자 singleton을 위해 인스턴스 생성
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
	
	// instance 접근
	public static VideoReviewDaoImpl getInstance() {return instance;}
	
	
	// method
	// videoNo에 해당하는 비디오의 리뷰 리스트 반환
	@Override
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.get(videoNo);
	}
	
	// review 삽입
	@Override
	public int insertReview(VideoReview videoReview) {
		reviewNo++; // 리뷰 쓰면 번호 1씩 증가
		videoReviewList.add(videoReview); // 리뷰 리스트에 등록
		videoReviewDb.put(reviewNo, videoReviewList); // 리뷰 db에 등록
		return reviewNo; // 리뷰 번호 반환 (쓴 걸 바로 띄우기 위해서)
	}
	
	
}
