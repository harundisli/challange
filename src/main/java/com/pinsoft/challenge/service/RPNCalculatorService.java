package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.ExpressionDTO;
import com.pinsoft.challenge.dto.RPNCalculatorDTO;

public interface RPNCalculatorService {
    public RPNCalculatorDTO calculateRPN(ExpressionDTO expression);
}
