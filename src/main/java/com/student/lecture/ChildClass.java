package com.student.lecture;

public class ChildClass extends ParentClass {
    @Override
    public void method(int number) {
        if ( number <= 0 ) {
            throw new RuntimeException("Number must be greater than 0");
        }
        System.out.println("ChildClass.method(int value)");
    }
}

