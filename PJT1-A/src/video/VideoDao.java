package video;

import java.util.List;
public interface VideoDao {
	List<Video> selectVideo();
    Video selectVideoByNo(int no);

}
