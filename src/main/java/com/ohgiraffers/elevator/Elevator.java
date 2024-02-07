package com.ohgiraffers.elevator;

public class Elevator {

    private static boolean isOpen = false;
    private static int floor = (int) (Math.random() * 20 + 1);

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

        System.out.println("elevator moves floor " + num);
        this.floor = 0;
        this.floor = num;
    }

    public void open() {

        Person per = new Person();

        if (floor == per.getPosition()) {

            System.out.println("elevator has opened");
            this.isOpen = true;
        } else {

            System.out.println("elevator has not arrive in floor " + per.getPosition());
        }
    }
}