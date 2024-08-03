package video;

import java.util.List;
public interface VideoDaoInterface {
	List<Video> selectVideo();
    Video selectVideoByNo(int no);

}
