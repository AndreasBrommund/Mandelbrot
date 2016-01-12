/**
 * Created by andreasbrommund on 2016-01-12.
 */
public class ComplexNumber {
    private double[] num;

    public ComplexNumber(double real, double imaginary){
        num = new double[2];
        num[0] = real;
        num[1] = imaginary;
    }

    public static ComplexNumber mul(ComplexNumber a,ComplexNumber b){
        double real = a.getReal()*b.getReal()-a.getImaginary()*b.getImaginary();
        double imag = a.getReal()*b.getImaginary()+a.getImaginary()*b.getReal();
        return new ComplexNumber(real,imag);
    }

    public static ComplexNumber add(ComplexNumber a,ComplexNumber b){
        return new ComplexNumber(a.getReal()+b.getReal(),a.getImaginary()+b.getImaginary());
    }

    public static double abs(ComplexNumber a){
        return Math.hypot(a.getReal(),a.getImaginary());
    }

    public double getReal(){
        return num[0];
    }

    public double getImaginary(){
        return num[1];
    }

    public double[] getComplexNumber(){
        return num;
    }

    @Override
    public String toString() {
        if (num[1] == 0){
            return ""+num[0];
        }else if(num[0] == 0){
            return num[1]+"i";
        }else if(num[1] < 0){
            return num[0]+""+num[1]+"i";
        }else{
            return num[0]+"+"+num[1]+"i";
        }
    }
}
