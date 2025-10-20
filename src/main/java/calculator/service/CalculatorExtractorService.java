package calculator.service;

import calculator.domain.CalculatorNumber;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorExtractorService {
    public void setDelimiter(String request, CalculatorNumber calculatorNumber) {
        if (request == null || request.length() == 0) {
            throw new IllegalArgumentException("입력되지 않은 문자열");
        }
        if (request.startsWith("//")) {
            int newline = request.indexOf("\\n");
            if (newline == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
            String customDelimiter = request.substring(2, newline);
            calculatorNumber.setDelimiter(Pattern.quote(customDelimiter));
            calculatorNumber.setIsCustom(true);
        }
    }

    public void setNumbers(String request, CalculatorNumber calculatorNumber) {
        List<String> numbers = extractNumbers(request,calculatorNumber);
        numberValidator(numbers);
        calculatorNumber.setNumbers(numbers);
        calculatorNumber.setIsInteger(IntegerChecker(numbers));
    }

    private List<String> extractNumbers(String request, CalculatorNumber calculatorNumber) {
        String delimiter = calculatorNumber.getDelimiter();
        if (calculatorNumber.getCustom()) {
            int newline = request.indexOf("\\n");
            if(newline != -1) {
                request = request.substring(newline + 2);
            }
        }
        return Arrays.stream(request.split(delimiter)).filter(s -> !s.isEmpty()).map(String::trim).toList();

    }

    private void numberValidator(List<String> numbers) {
        for (String n : numbers) {
            double num;
            try{
                num = Double.parseDouble(n);
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있음");
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수가 포함되어 있음");
            }
        }
    }

    private boolean IntegerChecker(List<String> numbers) {
        for (String n : numbers) {
            double num;
            num = Double.parseDouble(n);
            if (num != Math.floor(num)) return false;
        }
        return true;
    }
}