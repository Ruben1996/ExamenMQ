import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Operacion {
    int num1;
    int num2;
    char x;
    int resultado;


    public Operacion (){}
    public Operacion(int num1, int num2, char y)
    {
        this.num1=num1;
        this.x=y;
        this.num2=num2;
        this.resultado=0;

    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }
}
