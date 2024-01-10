package com.student.lecture;

public class LspMain {
    public static void main(String[] args) {
        Service service = new Service();
        ChildClass childClass = new ChildClass();
        ParentClass parentClass = new ParentClass();
        service.method(childClass);
    }
}



