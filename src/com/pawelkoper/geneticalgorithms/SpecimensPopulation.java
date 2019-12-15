package com.pawelkoper.geneticalgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SpecimensPopulation {
    private Specimen population[];
    private double fitnessOfPopulation = -1;

    public SpecimensPopulation(int sizeOfPopulation) {
        this.population = new Specimen[sizeOfPopulation];
    }

    public SpecimensPopulation(int sizeOfPopulation, int lengthofChromosome){
        this.population = new Specimen[sizeOfPopulation];

        for (int specimenCount = 0; specimenCount< sizeOfPopulation; specimenCount++){
            Specimen specimen = new Specimen(lengthofChromosome);
            this.population[specimenCount] = specimen;
        }
    }

    public Specimen[] getSpecimens(){
        return this.population;
    }

    public Specimen getFittestSpecimens(int offset){
        Arrays.sort(this.population, new Comparator<Specimen>() {
            @Override
            public int compare(Specimen s1, Specimen s2) {
                if (s1.getFitnessRate() >s2.getFitnessRate()){
                    return  -1;
                }
                else if (s1.getFitnessRate() < s2.getFitnessRate()){
                    return 1;
                }
                return 0;
            }
        });
        return this.population[offset];
    }

    public void setFitnessOfPopulation(double fitnessOfPopulation){
        this.fitnessOfPopulation = fitnessOfPopulation;
    }

    public double getFitnessOfPopulation(){
        return this.fitnessOfPopulation;
    }

    public int size(){
        return this.population.length;
    }

    public Specimen setSpecimen(int offset, Specimen specimen){
        return population[offset] = specimen;
    }

    public Specimen getSpecimen(int offset){
        return population[offset];
    }

    public void shufflePopulation()
    {
        Random random = new Random();

            for (int i = population.length - 1;i >0;i--){
                int index = random.nextInt(i+1);
                Specimen specimen = population[index];
                population[index] = population[i];
                population[i]=specimen;
            }
    }

    public void displayGeneration(SpecimensPopulation specimensPopulation){

        //System.out.println("=======================================================================================================================");
        System.out.println("Osobniki w danej generacji: ");
        for (int popIndex=0;popIndex<specimensPopulation.size();popIndex++){
            System.out.println(specimensPopulation.getSpecimen(popIndex));
        }

        //System.out.println("=======================================================================================================================");
    }

}
