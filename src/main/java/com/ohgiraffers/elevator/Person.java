package com.ohgiraffers.elevator;

import java.util.Scanner;

public class Person {

    private static boolean isIn = false;
    private static int position = 1;
    private int choose = 1;

    Elevator ele = new Elevator();

    public boolean isIn() {

        return isIn;
    }

    public int getPosition() {

        return position;
    }

    public void call() {

        if (position == ele.getFloor()) {

            System.out.println("elevator already arrived in floor " + position);
        } else {

            System.out.println("call elevator");
            ele.go(position);
        }

    }

    public void boarding() {

        if (!isIn) {

            System.out.println("U R already in elevator");

            if (ele.getFloor() == position) {

                System.out.println("elevator arrives floor " + position);

                if (ele.isOpen()) {

                    this.isIn = true;
                    System.out.println("enter the elevator");
                    ele.setIsOpen(false);
                } else {

                    System.out.println("elevator is not open");
                }
            } else {

                System.out.println("elevator has not arrive in floor " + position);
            }
        } else {

            System.out.println("U R already in elevator");
        }
    }

    public void order() {

        if (isIn) {

            System.out.print("choose the floor (1 - 20) : ");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();

            ele.go(choose);
            this.position = choose;
        } else {

            System.out.println("U R not in elevator");
        }
    }

    public void quit() {


        if (isIn) {

            if (choose == ele.getFloor() && choose == position) {

                if (ele.isOpen()) {

                    System.out.println("elevator has arrived in floor " + choose);
                    System.out.println("U can go out");
                    isIn = false;
                    ele.setIsOpen(false);
                } else {

                    System.out.println("door is not open yet");
                }

            } else {

                System.out.println("elevator has not arrived floor " + choose + " yet");
            }

        } else {

            System.out.println("U R not in elevator");
        }
    }
}
