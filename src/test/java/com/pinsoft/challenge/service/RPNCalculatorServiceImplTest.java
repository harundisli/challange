package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.ExpressionDTO;
import com.pinsoft.challenge.dto.RPNCalculatorDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RPNCalculatorServiceImplTest {

    @Autowired
    private RPNCalculatorServiceImpl rpnCalculatorService;


    @Test
    void shouldAdd() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 2 +");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(5);
    }

    @Test
    void shouldSubtract() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 2 -");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(1);
    }

    @Test
    void shouldMultiply() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 2 *");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(6);
    }

    @Test
    void shouldDivide() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 2 /");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(1.5);
    }

    @Test
    void shouldCalculateWhenComplex() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 5 8 * 7 + *");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(141);
    }

    @Test
    void shouldReturnSameValueWhenOneParameter() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(3);
    }

    @Test
    void shouldReturnValueWhenIntMax() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        String input = String.valueOf(Integer.MAX_VALUE) + " 100 +";
        expressionDTO.setExpression(input);

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo((double)Integer.MAX_VALUE + 100);
    }

    @Test
    void shouldReturnValueWhenIntMin() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        String input = String.valueOf(Integer.MIN_VALUE) + " 100 -";
        expressionDTO.setExpression(input);

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo((double)Integer.MIN_VALUE - 100);
    }

    @Test
    void shouldReturnPositiveInfiniteWhenDivideByZero() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 0 /");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(Double.POSITIVE_INFINITY);
    }

    @Test
    void shouldReturnNegativeInfiniteWhenDivideByZero() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("-3 0 /");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(Double.NEGATIVE_INFINITY);
    }
    @Test
    void shouldReturnNegativeWhenOneParameterNegative() {
        //given
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 -1 *");

        //when
        RPNCalculatorDTO rpnCalculatorDTO = rpnCalculatorService.calculateRPN(expressionDTO);

        //then
        assertThat(rpnCalculatorDTO.getResult()).isEqualTo(-3);
    }


}