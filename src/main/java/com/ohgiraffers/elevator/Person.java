package com.ohgiraffers.elevator;

import java.util.Scanner;

public class Person {

    private static boolean isIn = false;        // 사용자의 탑승 상태
    private static int position = 1;            // 사용자의 현재 층수
    private int choose = 1;                     // 사용자가 선택한 층수

    Elevator ele = new Elevator();

    public boolean isIn() {

        return isIn;
    }

    public int getPosition() {

        return position;
    }

    /* 승강기 호출
    승강기와 사용자 위치가 같으면 같다고 출력
    승강기와 사용자 위치가 다르면 승강기 호출
     */
    public void call() {

        if (position == ele.getFloor()) {

            System.out.println("승강기가 이미 " + position + "층에 도착했습니다.");
        } else {

            System.out.println("승강기를 호출합니다.");
            ele.go(position);
        }

    }

    // 승강기 탑승
    public void boarding() {

        if (!isIn) {
            // 탑승자가 승강기 안에 있으면 승강기 안에 있다고 출력
            System.out.println("이미 승강기 안에 있습니다.");
            /* 승강기가 사용자와 같은 층에 도착한 경우
            문이 열려 있으면 승강기에 탑승 + 자동 문닫힘
            문이 닫혀 있으면 승강기 탑승 불가 + 문 열라는 문구 출력
             */

            if (ele.getFloor() == position) {

                System.out.println("승강기가 " + position + "층에 도착했습니다.");

                if (ele.isOpen()) {

                    this.isIn = true;
                    System.out.println("승강기에 탑승합니다.");
                    ele.setIsOpen(false);
                    System.out.println("승강기 문이 닫힙니다.");
                } else {

                    System.out.println("승강기 문이 열리지 않았습니다.");
                }
            } else {
                // 승강기가 사용자와 다른층이면 다른 층이라고 출력
                System.out.println("승강기가 아직 " + position + "층에 도착하지 않았습니다.");
            }
        } else {
            // 사용자가 승강기 안에 있으면 승강기 안에 있다고 출력
            System.out.println("이미 승강기 안에 있습니다.");
        }
    }

    public void order() {

        if (!ele.isOpen()) {
            /* 승강기 문이 닫혀있고, 사용자가 승강기에 탑승한 상태라면
            이동하고자 하는 층을 선택
            승강기가 원하는 층으로 이동하도록 명령
             */

            if (isIn) {

                System.out.print("가고싶은 층을 입력하세요 (1 - 20) : ");
                Scanner sc = new Scanner(System.in);
                choose = sc.nextInt();

                ele.go(choose);
                this.position = choose;
            } else {
                // 사용자가 승강기에 탑승하지 않았다면 탑승하라는 문구 출력
                System.out.println("먼저 승강기에 탑승해주세요.");
            }
        } else {
            // 승강기 문이 열려있으면 문이 열려있다고 출력
            System.out.println("승강기의 문이 열려있습니다.");
        }
    }

    public void quit() {


        if (isIn) {
            /* 사용자가 승강기 안에 있고, 목표한 층에 도착한 경우
            도착 + 내릴수 있음을 출력
            승강기 문 자동 닫힘
             */
            if (choose == ele.getFloor() && choose == position) {

                if (ele.isOpen()) {

                    System.out.println("승강기가 " + choose + "층에 도착했습니다.");
                    System.out.println("승강기에서 내릴 수 있습니다.");
                    isIn = false;
                    ele.setIsOpen(false);
                } else {
                    // 승강기 문이 닫혀있으면 내릴수 없다고 출력
                    System.out.println("문이 아직 닫혀있습니다.");
                }

            } else {
                // 승강기가 목표한 층에 도착하지 않았으면 도착하지 않았다고 출력
                System.out.println("승강기가 아직 " + choose + "층에 도착하지 않았습니다.");
            }

        } else {
            // 사용자가 승강기 밖에 있으면 탑승하라고 출력
            System.out.println("먼저 승강기에 탑승해 주세요");
        }
    }
}
