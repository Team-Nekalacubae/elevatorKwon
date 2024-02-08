package com.ohgiraffers.elevator;

public class Elevator {

    private static boolean isOpen = false;                          // 승강기 문열림/닫힘 상태
    private static int floor = (int) (Math.random() * 20 + 1);      // 승강기의 현재 위치 (프로그램 시작시 랜덤 위치)

//    Person per = new Person();

    public boolean isOpen() {

        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {

        this.isOpen = isOpen;
    }

    public int getFloor() {

        return floor;
    }

    public void go(int num) {
        // 승강기가 'num' 층으로 이동
        System.out.println("승강기가 " + num + "층으로 이동합니다.");
        this.floor = 0;
        this.floor = num;
    }

    public void open() {

        Person per = new Person();
        // 승강기와 사용자의 위치가 같으면 문열림 작동 가능
        if (floor == per.getPosition()) {

            System.out.println("승강기 문이 열립니다.");
            this.isOpen = true;
        } else {
            // 승강기와 사용자의 위치가 다르면 문열림 작동 불가능
            System.out.println("승강기가 " + per.getPosition() + "층에 도착하지 않았습니다.");
        }
    }
}