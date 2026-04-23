/**
 * @author: Kabelo Tlhape
 **/
public class MyCalculator {
    private int number1, number2;

    public MyCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }


    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public double sum(){
        return number1 + number2;
    }
    public double difference(){
        return number1 - number2;
    }
    public double product(){
        return number1 * number2;
    }
    public double quotient(){
        return number1 / number2;
    }
}
