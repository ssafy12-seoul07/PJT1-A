package video;

import java.util.List;

import review.VideoReviewDao;
import review.VideoReviewDaoInterface;
import review.VideoReviewUi;
import util.Util;

public class VideoUi {
	private VideoDaoInterface videoDao;
	private static VideoUi instance;
	private VideoUi() {
		videoDao = VideoDao.getInstance();
	}
	
	public static VideoUi getInstance() {
		if (instance == null) {
            instance = new VideoUi();
        }
        return instance;
	}
	
	public void service() {
        while (true) {
            Util.printLine();
            System.out.println("1. 영상 목록");
            System.out.println("0. 이전으로");
            Util.printLine();
            int menu = Util.inputInt("메뉴를 선택하세요: ");
            
            if (menu==1) {
            	listVideo();
            }
            
            else if (menu==0) {
            	return;
            }
            
            else {
            	System.out.println("1과 0 중에 선택해주세요.");
            	service();
            }
        }
    }
	
	
	public void listVideo() {
        List<Video> videoList = videoDao.selectVideo();
        Util.printLine();
        System.out.println("전체 " + videoList.size() + "개");
        Util.printLine();

        for (Video video : videoList) {
            System.out.println(video.getNo() + " " + video.getPart() + " " + video.getTitle());
        }

        Util.printLine();
        System.out.println("1. 영상 상세");
        System.out.println("0. 이전으로");
        Util.printLine();

        int menu = Util.inputInt("메뉴를 선택하세요: ");
        if (menu == 1) {
            detailVideo();
        }
        else if (menu==0) {
        	service();
        }
        else {
        	System.out.println("1과 0 중에 선택해주세요.");
        	listVideo();
        }
    }
	
	public void detailVideo() {
        int videoNo = Util.inputInt("영상 번호를 입력하세요: ");
        Video video = videoDao.selectVideoByNo(videoNo);
        VideoReviewUi reviewUi = VideoReviewUi.getInstance(videoNo);
       
        

        if (video != null) {
            Util.printLine();
            System.out.println("번호: " + video.getNo());
            System.out.println("제목: " + video.getTitle());
            System.out.println("운동: " + video.getPart());
            System.out.println("영상 URL: " + video.getUrl());
            Util.printLine();
            reviewUi.service();
            
            
        } else {
            System.out.println("해당 번호의 비디오를 찾을 수 없습니다.");
            
        }
    }
	

}
