# JAVA PJT 느낀점

- Git
    - 팀끼리 레포를 파고, 첫 틀인 프로젝트를 생성할 땐 기존에 git이 연결되지 않았던 새로운 워크스페이스 위에 만들어야 하는 것을 알았습니다. 깃이 이미 연결되었던 곳(기존 워크스페이스 1)에 워크스페이스(2)를 만들고 프로젝트를 생성하고, 2번 워크스페이스를 레포지토리에 올리니 프로젝트에 접근이 불가했습니다.
    - 일반적으로 master 브랜치 외에 dev 브랜치를 생성하고 그 밑에 기능별로 임시 브랜치를 생성합니다. 기능 구현이 완료되면 git push를 한 뒤 dev브랜치에 merge합니다. 그 후 바로 그 페이지에서 임시 feat 브랜치를 지워줍니다(단, 보라색으로 떴을 경우에만. 충돌이 나면, 이를 해결해야 한다.).
    - dev 브랜치 밑에 feat 브랜치 생성 과정에서의 어려움. master와 같은 계층으로 feat 브랜치가 생성되지 않도록 주의해야 합니다. 이를 위해서 브랜치 생성 전에 현재 위치해있는 브랜치가 어디인지 체크를 하고, git branch 명령어를 통해 branch 목록을 확인 해야 합니다. 이후 git branch 새로운 브랜치명을 통해 브랜치를 생성해야 합니다.
    - git pull을 해 올 때 내 파일에서 줄바꿈을 한 정도의 변경이 있었다면 git stash를 통해 임시저장을 먼저 하고, git pull을 해옵니다. (commit도 가능)
- Java
    - MVC 패턴의 관점으로 프로젝트 구성을 생각해 볼 수 있었습니다.
        - 기존에는 Video와 Review와 같이 각 개념에 따라서만 구분을 했다면 그 밑에 데이터를 담는 부분과, 이를 활용하고 처리하는 부분, 입출력하는 부분으로 나누어서 생각해 보게 되었습니다. 저희 조는 각자 기능을 Video / Review / Main으로 나누어서 진행했기 때문에 프로젝트의 패키지 또한 Video / Review / Main으로 나누고 진행했는데 다음엔 패키지를 Ui 파트와 Dao 파트 그리고 Model로 나누어서 진행해도 좋을 것 같다는 생각이 들었습니다.
    - 싱글톤
        - 혼자 프로젝트를 만들 땐 싱글톤을 적용하는 게 간단했는데 다른 사람과 협업을 하고 클래스 구분이 다양해지면서 다른 파트에 있는 싱글톤 기능을 방해하지 않는 선에서 상호 간의 연결을 시키는 데 시간이 많이 걸렸습니다. 처음엔 예시 화면과 클래스 다이어그램을 보며 각자의 파트를 만들고, 서로가 대략적으로 완성한 이후, MainUi 부분과 VideoUi 부분을 연결했습니다.
        
        ```java
        
        public class VideoUi{
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
        ```
        
        - 특히 이 부분에서 0을 누를 시 다시 MainUi의 service() 메서드가 실행되어야 한다고 생각을 하니 어려웠습니다. VideoUi의 service 내에서 MainUi의 인스턴스를 갖고 오도록 getter를 생성해야 하는지도 고민을 해보았는데 간단하게 return 처리만 해도 된다는 것을 알았습니다.
        - 또한 VideoUi에서 VideoReviewUi를 호출하는 것에서도 고민이 있었습니다. VideoReviewUi에 특정 영화 no를 전달해서 넘겨주고, VideoReviewUi에서 이것을 활용해야 하는데 이 방법에 대해 고민해 보았습니다. VideoUi에서 활용할 VideoReviewUi 메서드(service메서드 / reviewlist메서드)에 파라미터 값으로 movieNo를 전달해 주는 것을 고려해 보았으나 최종적으로
            
            ```java
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
                        reviewUi.listReview();
                        reviewUi.service();
                        
                        
                    } else {
                        System.out.println("해당 번호의 비디오를 찾을 수 없습니다.");
                        
                    }
                }
            ```
            
            이 방식으로 수정했습니다. reviewUi 클래스 내의 메서드에 직접 파라미터를 주입하지 않고, 인스턴스 객체를 호출해 와서 활용하는 방식을 선택하여 클래스 간 결합도를 낮출 수 있었습니다.
