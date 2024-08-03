# 1차 관통 PJT 회고록
## Team
### 시작 전 생각
팀원(Followship)으로서 어떻게 팀장(Leadership)에 따라가고, 어떻게 다른 팀원들과 소통해서 문제를 효과적으로 해결해 나갈 것인가에 대한 고민
-> 우선 팀원들에 대해 아는 것이 적으니 맞춰가는 방식으로 해보자!

### 회의 과정
- 약 1시간 30분의 회의를 통해 클래스 다이어그램의 예시를 참고해 필요한 클래스와 멤버들을 텍스트로 정리했다.
- 그 후 feature별로 나누어 개발하기로 결정.
    - 인애: MainUi와 SsafitProject(test)

    - 홍균: videoReview    

    - 혜원: video

    처음에는 인애님이 Ui를 전담하기로 했으나, 곰곰이 클래스 다이어그램을 검토한 결과, 대부분의 기능이 Ui에 몰려있다는 사실을 깨달아서 그 중에서 MainUi만 맡기로 역할 재분배를 했다.

- repository 생성 후 `git clone` 받았고, feature별로 branch를 새로 파서 merge해 나가는 방식으로 하기로 결정. 
    - 처음부터 자바 프로젝트가 열리지 않는 이슈가 생겼다! 그 원인은 처음 레포에 push할 때 워크스페이스를 더 상위에 있는 곳 안에 만들어 .classpath와 .project 파일이 같이 넘어와서 clone 받은 사람들과 충돌했기 때문.

    - 해결 방법으로 그 안에 폴더를 하나 더 만들어 쓰고 있었지만, 교수님의 조언으로 레포 비워서 다시 새로 시작!

    - 근데 또 거기서 나에게 새로운 이슈가 발생! review(feature) branch를 새로 파서 `git push origin review`를 했는데 auto merge가 안된다!
        - 원인: 레포를 비우기 전에 test한다고 review branch를 만들어서 push 했었는데 merge(pull request)를 하지는 않았던 상황. 여기서 레포 비우고(삭제가 아니라 내용물을 덮어 씌워서) 로컬에서 다시 review branch를 파서 push 하려니, gitHub엔 이미 review로 보낸 commit이 남아있던 것! 그래서 pull 먼저 받아오라고 경고가 뜬 것이다.

        - 이전 commit이 단순 test용이었기 때문에 merge한 다음 바로 지워서 삭제하고, 그래서 behind가 아닌 상태로 만들어 push가 가능해지게 했다.

        - 그리고 새로 push 하는 과정에서 master(dev)의 원래 version과 feature branch에서 수정한 version이 단순하게 공백이 겹치는 경우라도 다르다면, 그 차이를 수동으로 수정해서 merge 해줘야 한다는 것을 배웠다.

### 구현 과정
3인 팀으로 각자의 역할을 분배 받아 코딩하는 프로젝트는 이번이 처음이었는데, 실제 구현하는 과정에서 실시간으로 소통이 이루어지지 않으면 수정하는 것이 굉장히 어렵다는 사실을 배웠다.

- 실제로 어떤 클래스 다이어그램을 기준으로 할 지 각자 생각이 달랐어서(당연히 이걸로 하겠지라는 생각이 있었던 것 같다.) 클래스와 인터페이스 명이 다르다는 사실을 merge하면서 깨달아 수정했다.

- 또, feature 별로 나눠서 패키지를 만들어 각자 구현하는 방식으로 프로젝트를 진행했는데, 다른 사람의 패키지에서 메소드나 클래스를 호출해야 할 때에는 반드시 merge를 먼저 해서 다른 사람의 코드를 보고 호출하는 과정이 필요하다고 느꼈다. 호출이 필요한 메소드에서 모르는 부분이 있을 땐 반드시 어떤 식으로 동작하는지 물어보는 게 중요했다. 그 과정 속에서 각각의 객체가 어떤 부분을 맡고 있고, 어떤 메소드가 어떻게 동작하는 지를 더 명확하게 할 수 있었다.

- 그리고 명세서를 바탕으로 만든 클래스 다이어그램을 실제로 구현하는 데 있어서, 표기된 매개변수와 메소드가 존재하는 이유에 대해 깊이 고민하고 그 의도를 파악해야 한다는 점도 배웠다.
    - 예를 들어, `service()`가 어떤 부분을 나타내는 메소드인지, singleton pattern으로 작성된 클래스 객체에 어떻게 매개변수를 넣어줄 것인지에 대한 고민이 굉장히 많았다.
``` java
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
```

- 또, 어떻게 지정된 자료구조에 값을 넣고 조회하고 사용할 지 고민하면서 많이 친숙해진 것 같다.

- 그리고 마지막에 마지막까지 디버깅은 필수! 다 됐다고 생각했는데 `detailVideo()`에서 

## Personal



## GPT로 수정된 클래스 다이어그램


[Review]
### VideoReview 클래스
속성:
-videoNo: int
-reviewNo: int
-nickName: String
-content: String

메서드: 
+getVideoNo(): int
+setVideoNo(videoNo: int): void
+getNickName(): String
+setNickName(nickName: String): void
+getReviewNo(): int
+setReviewNo(reviewNo: int): void
+getContent(): String
+setContent(content: String): void 

### VideoReviewDaoInterface
메서드:
+selectReview(videoNo: int): List<VideoReview>

### VideoReviewDao implements VideoReviewDaoInterface
속성:
-reviewNo: int
-videoReviewDb: Map<Integer, List<VideoReview>>
-instance: VideoReviewDao

메서드:
- VideoReviewDao()
+getInstance(): VideoReviewDao
+selectReview(videoNo: int): List<VideoReview>

## GPT에게서 받은 클래스 다이어그램을 수정

[Review]
### VideoReview 클래스
속성:
-videoNo: int
-reviewNo: int
-nickName: String
-content: String

메서드: 
+VideoReview() // 기본 생성자
+VideoReview(videoNo: int, nickName: String, reviewNo: int, content: String) // 매개변수 받는 생성자
+getVideoNo(): int
+setVideoNo(videoNo: int): void
+getNickName(): String
+setNickName(nickName: String): void
+getReviewNo(): int
+setReviewNo(reviewNo: int): void
+getContent(): String
+setContent(content: String): void 

### VideoReviewDaoInterface
메서드:
+insertReview(videoReview: VideoReview): int
+selectReview(videoNo: int): List<VideoReview>

### VideoReviewDao implements VideoReviewDaoInterface
속성:
-reviewNo: int
-videoReviewList: List<VideoReview>
-videoReviewDb: Map<Integer, List<VideoReview>>
-instance: VideoReviewDaoImpl

메서드:
- VideoReviewDaoImpl() // 기본 생성자
+getInstance(): VideoReviewDaoImpl
+selectReview(videoNo: int): List<VideoReview>
+insertReview(videoReview: VideoReview): int

### VideoReviewUi 클래스
속성
-videoReviewDao: VideoReviewDaoInterface
-instance: VideoReviewUi
-videoNo: int

메서드
+getInstance(videoNo: int): VideoReviewUi
+service(): void
-listReview(): void
-registReview(): void