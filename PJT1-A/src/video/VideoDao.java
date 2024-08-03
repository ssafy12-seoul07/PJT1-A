package video;

import java.util.List;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;

public class VideoDao implements VideoDaoInterface {
	private static VideoDao instance;
	private List<Video> videoList;
	private static final int MAX_SIZE = 100;
	private int size;
	private static Gson gson;
	
	private VideoDao() {
		gson = new Gson();
		try (FileReader reader = new FileReader("video.json")) {
            Type listType = new TypeToken<List<Video>>() {}.getType();
            videoList = gson.fromJson(reader, listType);
            size = videoList.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static VideoDao getInstance() {
		if (instance == null) {
            instance = new VideoDao();
        }
        return instance;
	}
	
	@Override
    public List<Video> selectVideo() {
        return videoList;
    }
    
	@Override
    public Video selectVideoByNo(int no) {
    	for (Video video: videoList) {
    		if (video.getNo()==no) {
    			return video;
    		}
    	}
    	return null;
    }
	
	public void loadFromJsonFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<List<Video>>() {}.getType();
            videoList = gson.fromJson(reader, listType);
            size = videoList.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
	

}
