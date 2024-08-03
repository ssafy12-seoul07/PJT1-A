package review;

import java.util.List;

public interface VideoReviewDao {
	int insertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
}
