package com.pawelkoper.geneticalgorithms;

public class Function {


    Integer a;
    Integer b;
    Integer c;
    Integer d;
    double x1;
    double x2;
    double y1;
    double y2;
    public static double maximum;
    public double minimum;
    double funcionValue;
    public static String maximumStrFixedLength;
    public static char[] maximumArray;
    public int[] maximumArrayInt;


    Function(Integer a, Integer b, Integer c, Integer d){
        setA(a);
        setB(b);
        setC(c);
        setD(d);
       setX1((-b+Math.sqrt(Math.pow(b,2)-3*a*c))/(3*a));
       setX2((-b-Math.sqrt(Math.pow(b,2)-3*a*c))/(3*a));
        setY1(((6.0*a*x1)+(2.0*b)));
        setY2(((6.0*a*x2)+(2.0*b)));


        if (y1>0 && y2<0){
            setMaximum(x2);
            setMinimum(x1);
        }
        if (y2>0 && y1<0){
            setMaximum(x1);
            setMinimum(x2);
        }
        if(y1==0 || y2==0){
            setMaximum(0);
            setMinimum(0);
        }
    }

    public String maximumConversion(){
        Double maximumDouble=null;
        if(Math.abs(maximum-Math.floor(maximum))>0.5){
            maximumDouble= Double.valueOf(Math.round(maximum));
        }
        else if(Math.abs(maximum-Math.floor(maximum))<0.5){
            maximumDouble= Double.valueOf(Math.floor(maximum));
        }
        //Double maximumDouble= maximum;
        double maximumDoubleTwo=maximumDouble.doubleValue();
        int maximumIntValue = (int)maximumDoubleTwo;
        String maximumStr = Integer.toBinaryString(maximumIntValue);
        maximumStrFixedLength = extendString(maximumStr,"0",5);
        StringBuilder sb = new StringBuilder();
        sb.append(maximumStrFixedLength);
        sb.reverse();
        String str = sb.toString();
        return maximumStrFixedLength;
    }

    public static String extendString(String text, String symbol, Integer len) {
        while (text.length() < len) { text = symbol+text; }
        return text;
    }

    public int[] maximumArrayConversion(){
        maximumArray=maximumStrFixedLength.toCharArray();
       /* for (int index=0;index<maximumArray.length;index++){
            int maximumArrayTemp = Integer.parseInt(String.valueOf(maximumArray[index]));
            maximumArrayTemp = maximumArrayInt[index];
            index++;
        }*/

        return maximumArrayInt;
    }

    public void displayMaximumArrayInt(){
        for (int index=0;index<maximumArrayInt.length;index++){
            System.out.println(maximumArrayInt[index]);
            index++;
        }
    }

    public double getFuncionValue() {
        return funcionValue;
    }

    public void setFuncionValue(double funcionValue) {
        this.funcionValue = (a*Math.pow(funcionValue,3.0)+b*Math.pow(funcionValue,2.0)+c*funcionValue+d);
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }


}







