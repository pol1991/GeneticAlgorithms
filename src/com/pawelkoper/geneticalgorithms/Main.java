package com.pawelkoper.geneticalgorithms;

import java.util.Scanner;

//import static com.pawelkoper.geneticalgorithms.Function.maximumRound;
import static com.pawelkoper.geneticalgorithms.Function.maximumStrFixedLength;

public class Main {


    public static void main(String[] args) {
	// write your code here


        /*
        System.out.println("Podaj Koniec przedziału: ");
        Integer interval = scanner.nextInt();
        String intervalBinary = Integer.toBinaryString(interval);
        Integer intervalBinaryLength = intervalBinary.length();
        System.out.println(intervalBinary);
        System.out.println(intervalBinaryLength);*/
       Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================================================================================================");
        System.out.println("||      Szukanie Maksimum funkcji y=ax^3+bx^2+cx+d w przedziale <0,31> z wykorzystaniem algorytmu genetycznego.      ||");
        System.out.println("=======================================================================================================================");
        System.out.println("Podaj współczynnik a funkcji: ");
        Integer a = scanner.nextInt();
        System.out.println("Podaj współczynnik b funkcji: ");
        Integer b = scanner.nextInt();
        System.out.println("Podaj współczynnik c funkcji: ");
        Integer c = scanner.nextInt();
        System.out.println("Podaj współczynnik d funkcji: ");
        Integer d = scanner.nextInt();
        Function function = new Function(a,b,c,d);
        System.out.println("Maksimum: "+function.getMaximum()+", Minimum: "+function.getMinimum());
        System.out.println("Wartość maksimum: "+function.maximum);
        System.out.println("Zapis binarny: "+function.maximumConversion());
        function.maximumConversion();
        function.maximumArrayConversion();
        function.setFuncionValue(function.getMaximum());
        System.out.println("y= "+function.getFuncionValue());
        Integer maximumRound = null;
        if(Math.abs(function.getMaximum()-Math.floor(function.getMaximum()))>0.5){
            maximumRound= (int)Math.round(function.getMaximum());
        }
        else if(Math.abs(function.getMaximum()-Math.floor(function.getMaximum()))<0.5){
            maximumRound= (int)Math.floor(function.getMaximum());
        }



        GeneticAlgorithmImplementation start = new GeneticAlgorithmImplementation(6,0.8,0.2,5);
        SpecimensPopulation specimensPopulation = start.startPopulation(5);
        start.evaluatePopulation(specimensPopulation);
        specimensPopulation.displayGeneration(specimensPopulation);
        int generationCounter = 1;
        boolean condition = start.terminationCondition(specimensPopulation);


        while (!condition){

            System.out.println("=======================================================================================================================");
            //specimensPopulation.displayGeneration(specimensPopulation);
            System.out.println("najlesze rozwiązanie w "+generationCounter+" generacji: " +specimensPopulation.getFittestSpecimens(0).toString());
            //specimensPopulation.displayGeneration(specimensPopulation);
            System.out.println("Wartość liczbowa rozwiazania: " +specimensPopulation.getFittestSpecimens(0).toInt());
            //Double outcome = a*Math.pow(specimensPopulation.getFittestSpecimens(0).toDouble(),3.0)+b*Math.pow(specimensPopulation.getFittestSpecimens(0).toDouble(),2.0)+c*specimensPopulation.getFittestSpecimens(0).toDouble()+d;
            function.setFuncionValue(specimensPopulation.getFittestSpecimens(0).toDouble());
            System.out.println("Maksimum dla funkcji y = "+a+"x^3 + "+b+"x^2 + "+c+"x + "+d+" w podanym przedziale, w danej generacji = "+function.getFuncionValue());
            System.out.println("=======================================================================================================================");
            //start.evaluatePopulation(specimensPopulation);
            specimensPopulation= start.Crossover(specimensPopulation);
            specimensPopulation = start.Mutation(specimensPopulation);
            start.evaluatePopulation(specimensPopulation);
            generationCounter++;

            /*for (int index=0;index<specimensPopulation.size();index++){
                if (maximumStrFixedLength == specimensPopulation.getSpecimen(index).toString()){
                    condition=true;
                }
            }*/
            if (specimensPopulation.getFittestSpecimens(0).toInt()==maximumRound){
                condition=true;
            }
        }

        System.out.println("=======================================================================================================================");
        System.out.println("Finalne rozwiązanie znaleziono w: "+generationCounter+" generacji");
        specimensPopulation.displayGeneration(specimensPopulation);
        System.out.println("Najlepszy Osobnik: " + specimensPopulation.getFittestSpecimens(0).toString());
        System.out.println("Wartość liczbowa chromosomu osobnika: " + specimensPopulation.getFittestSpecimens(0).toInt());
        //System.out.println("Najlepszy Osobnik: "+function.getMaximum());
        //Double outcome = a*Math.pow(specimensPopulation.getFittestSpecimens(0).toDouble(),3.0)+b*Math.pow(specimensPopulation.getFittestSpecimens(0).toDouble(),2.0)+c*specimensPopulation.getFittestSpecimens(0).toDouble()+d;
        //function.setFuncionValue(specimensPopulation.getFittestSpecimens(0).toDouble());
        function.setFuncionValue(specimensPopulation.getFittestSpecimens(0).toInt());
        System.out.println("Maksimum dla funkcji y = "+a+"x^3 + "+b+"x^2 + "+c+"x + "+d+" w podanym przedziale, w danej generacji = "+function.getFuncionValue());
        System.out.println("=======================================================================================================================");
    }
}
