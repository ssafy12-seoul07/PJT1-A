package review;

import java.util.List;

public interface VideoReviewDaoInterface {
	int insertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
}
