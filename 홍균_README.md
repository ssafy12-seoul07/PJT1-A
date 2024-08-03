# 1차 관통 PJT 회고록

## Team



## Personal



## GPT로 수정된 클래스 다이어그램

```plaintext
[UI]
SsafitProject 클래스
메서드:
+main(args[]: String): void

MainUi 클래스
메서드
+service(): void
-exit(): void

VideoUi 클래스
속성
-videoDao: VideoDaoInterface
-instance: VideoUi 

메서드
+getInstance(): VideoUi 
+service(): void
-listVideo(): void
-detailVideo(): void

VideoReviewUi 클래스
속성
-videoReviewDao: VideoReviewDaoInterface
-instance: VideoReviewUi
-videoNo: int
메서드
+getInstance(videoNo: int): VideoReviewUi
+service(): void
-listReview(): void
-registReview(): void

[Util]
Util 클래스
속성:
sc: Scanner
메서드:
+inputString(msg: String): String // String을 입력받기
+inputInt(msg: String): int // Int를 입력받기
+printLine(): void // 디폴트 가로줄 출력
+printLine(ch: char): void // char을 출력
+printLine(ch: char, len: int): void // char을 len개수만큼 출력
+screenClear(): void // 터미널을 깨끗하게 만들기

[Video]
Video
속성:
-no: int
-title: String
-part: String
-url: String
메서드:
Video()
+getNo(): int
+setNo(no: int):void
+getTitle():String
+setTitle(title: String):void
+getPart():String
+setPart(part: String): void
+getUrl(): String
+setUrl(url: String): void
+toString(): String

VideoDaoInterface
메서드:
+selectVideo(): List<Video>
+selectVideoByNo(no: int): Video

VideoDao implements VideoDaoInterface
속성:
-list: List<Video>
-instance : VideoDao
-MAX_SIZE:int{readonly}
- size: int
메서드:
- VideoDao()
+getInstance(): VideoDao
+selectVideo(): List<Video> //전체 비디오 반환.
+selectVideoByNo(no: int) : Video

[Review]
VideoReview 클래스
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

VideoReviewDaoInterface
메서드:
+selectReview(videoNo: int): List<VideoReview>

VideoReviewDao implements VideoReviewDaoInterface
속성:
-reviewNo: int
-videoReviewDb: Map<Integer, List<VideoReview>>
-instance: VideoReviewDao
메서드:
- VideoReviewDao()
+getInstance(): VideoReviewDao
+selectReview(videoNo: int): List<VideoReview>
```





## GPT에게서 받은 클래스 다이어그램을 수정
### 
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

### VideoReviewDao
메서드:
+insertReview(videoReview: VideoReview): int
+selectReview(videoNo: int): List<VideoReview>

### VideoReviewDaoImpl implements VideoReviewDaoInterface
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