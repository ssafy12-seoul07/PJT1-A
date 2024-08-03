import util.Util;
import video.VideoUi;

public class MainUi {
    public void service() {
        while (true) {
            Util.printLine();
            System.out.println("자바로 구현하는 SSAFIT");
            Util.printLine();
            System.out.println("1. 영상 정보");
            System.out.println("0. 종료");
            Util.printLine();
            
            int menu = Util.inputInt("메뉴를 선택하세요 : ");
            
            switch (menu) {
                case 1:
                	VideoUi.getInstance().service();
                    break;
                case 0:
                    exit();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }

    private void exit() {
        System.out.println("프로그램을 종료합니다.");
        Util.closeScanner(); // Scanner 리소스 해제
    }
}