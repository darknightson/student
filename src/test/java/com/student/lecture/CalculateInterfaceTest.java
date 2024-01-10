package com.student.lecture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateInterfaceTest {


    @DisplayName("")
    @Test
    void Test() {

        // given
        CalculateInterface calculateInterface = new Plus();
        int plus = calculateInterface.calculate(1, 1);
        System.out.println("plus = " + plus);
        CalculateInterface calculateInterface1 = new Minus();
        calculateInterface1.calculate(1, 1);
        System.out.println("calculateInterface1 = " + calculateInterface1);


        // when


        // then
    }


}