package com.pinsoft.challenge.controller;

import com.pinsoft.challenge.dto.ExpressionDTO;
import com.pinsoft.challenge.dto.RPNCalculatorDTO;
import com.pinsoft.challenge.service.RPNCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPNCalculatorController {

    private final RPNCalculatorService rpnCalculatorService;
    @Autowired
    public RPNCalculatorController(RPNCalculatorService rpnCalculatorService) {
        this.rpnCalculatorService = rpnCalculatorService;
    }
    @PostMapping("/calculate")
    public ResponseEntity<RPNCalculatorDTO>calculateRPN(@RequestBody ExpressionDTO expression){
        return  ResponseEntity.ok(rpnCalculatorService.calculateRPN(expression));

    }
}
