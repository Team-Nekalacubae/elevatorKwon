package com.ohgiraffers.elevator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /*
        ----------------------------------------------------------------------------------------------------------
        * 엘리베이터 사용자가 수신할 수 있는 메세지( 사용자가 해야 할 일)
        1) 엘리베이터를 현재 층수으로 불러라
        2) 엘리베이터에 타거나 내려라
        3) 이동하고 싶은 층수를 입력하라
        (4) 원하면 엘리베이터문의 열림 닫힘 버튼을 이용하라)

        * 엘리베이터가 수신할 수 있는 메세지(엘리베이터가 해야 할 일)
        1) 탑승자로부터 호출을 받아라
        2) 호출된 층수로 이동하라
        3) 멈춰라 ( 호출받은 층수 도착 시)
        4) 문을 열라
        5) 문을 닫아라
        (6) 열림 닫힘 지시이행)

        ---------------------------------------------------------------------------------------------
        * 요구사항
        1. 사용자는 엘리베이터 호출, 층수 입력, 탑승 및 하차를 할 수 있다.
        2. 엘리베이터는 멈춰있기, 층수 이동, 문 열림 및 닫힘을 할 수 있다.
        3. 엘리베이터는 임의의 층에 멈춰있다.
        4. 사용자는 엘리베이터를 현재 층으로 호출할 수 있다.
        5. 사용자는 엘리베이터가 현재 층에 도착하면 엘리베이터에게 문열림 명령을 할 수 있다.
        6. 사용자 엘리베이터의 문이 열려야 탑승할 수 있다.
        6. 사용자는 엘리베이터에 층수이동명령을 내릴 수 있다.
        7. 엘리베이터는 사용자의 명령을 받아 층을 이동할 수 있다.
        8. 사용자는 엘리베이터 이동하는 층으로 도착하면 내릴 수 있다.
        9. 엘리베이터는 사용자가 내리면 문을 닫을 수 있다.
         */

        Scanner sc = new Scanner(System.in);
        Person per = new Person();
        Elevator ele = new Elevator();


        while (true) {

            System.out.println("===== 승강기 사용 =====");

            String io1;
            if (ele.isOpen()) {

                io1 = "문 열림";
            } else {

                io1 = "문 닫힘";
            }

            System.out.println("승강기의 상태 : " + ele.getFloor() + "층 / " + io1);

            String io2;
            if (per.isIn()) {

                io2 = "승강기 탑승중";
            } else {

                io2 = "승강기 외부";
            }

            System.out.println("사용자의 상태 : " + per.getPosition() + "층 / " + io2);
            System.out.println("1. 승강기 호출");
            System.out.println("2. 승강기 문열림");
            System.out.println("3. 승강기 탑승");
            System.out.println("4. 층 선택");
            System.out.println("5. 승강기 내림");
            System.out.println("9. 종료");
            System.out.print("행동을 결정해 주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    per.call();
                    break;
                case 2:
                    ele.open();
                    break;
                case 3:
                    per.boarding();
                    break;
                case 4:
                    per.order();
                    break;
                case 5:
                    per.quit();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("잘못된 행동을 입력했습니다.");
                    break;


            }
            if (no == 9 && !per.isIn()) {

                System.out.println("승강기 사용을 종료합니다.");
                break;
            } else if (no == 9 && per.isIn()){

                System.out.println("먼저 승강기에서 나가주세요");
            }
        }

    }
}