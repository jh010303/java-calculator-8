package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNumber {
    private List<String> numbers = new ArrayList<String>();
    private Double answer;
    private String delimiter = ",|:";
    private boolean isInteger = false;
    private boolean isCustom = false;

    public List<String> getNumbers() {
        return numbers;
    }

    public Double getAnswer() {
        return answer;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean getIsInteger() {
        return isInteger;
    }

    public boolean getCustom() {
        return isCustom;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void setIsInteger(boolean isInteger) {
        this.isInteger = isInteger;
    }

    public void setIsCustom(boolean isCustom) {
        this.isCustom = isCustom;
    }
}