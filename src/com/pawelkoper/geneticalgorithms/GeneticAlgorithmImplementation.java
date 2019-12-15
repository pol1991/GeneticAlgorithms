package com.pawelkoper.geneticalgorithms;

import java.util.Scanner;

import static com.pawelkoper.geneticalgorithms.Function.maximumArray;
import static com.pawelkoper.geneticalgorithms.Function.maximumStrFixedLength;

public class GeneticAlgorithmImplementation {

    private int initialPopulationSize;
    private double rateOfCrossover;
    private double rateOfMutation;
    private int ElitismCounter;

    public GeneticAlgorithmImplementation(int initialPopulationSize, double rateOfCrossover, double rateOfMutation, int elitismCounter) {
        this.initialPopulationSize = initialPopulationSize;
        this.rateOfCrossover = rateOfCrossover;
        this.rateOfMutation = rateOfMutation;
        this.ElitismCounter = ElitismCounter;
    }

    public SpecimensPopulation startPopulation(int lengthOfChromosome) {
        SpecimensPopulation specimensPopulation = new SpecimensPopulation(this.initialPopulationSize, lengthOfChromosome);
        return specimensPopulation;
    }

    public double claculateFitnessOfSpecimens(Specimen specimen) {
        int goodGenesCounter = 0;

        for (int geneIndex = 0; geneIndex < specimen.getLengthOfChromosome(); geneIndex++) {
            if (specimen.getGene(geneIndex) == maximumArray[geneIndex]) {
                goodGenesCounter++;
            }
            else {
                goodGenesCounter--;
            }

        }


        double fitnessrate = goodGenesCounter; /// specimen.getLengthOfChromosome();

        specimen.setFitnessRate(fitnessrate);

        return fitnessrate;
    }

    public void evaluatePopulation(SpecimensPopulation specimensPopulation) {

        double fitnessOfPopulation = 0;

        for (Specimen specimen : specimensPopulation.getSpecimens()) {

            fitnessOfPopulation += claculateFitnessOfSpecimens(specimen);
        }
        specimensPopulation.setFitnessOfPopulation(fitnessOfPopulation);
    }

    public boolean terminationCondition(SpecimensPopulation specimensPopulation) {

        for (Specimen specimen : specimensPopulation.getSpecimens()) {
            if (specimen.getFitnessRate() == 1) {
                return true;
            }

        }
        return false;
    }

    public Specimen selectParentSpecimens(SpecimensPopulation specimensPopulation) {
        Specimen specimens[] = specimensPopulation.getSpecimens();

        double fitnessRateOfPopulation = specimensPopulation.getFitnessOfPopulation();
        double rouletteWheelCurrentPosition = Math.random() * fitnessRateOfPopulation;
        double spinTheRoulette = 0;

        for (Specimen specimen : specimens) {
            spinTheRoulette += specimen.getFitnessRate();
            if (spinTheRoulette >= rouletteWheelCurrentPosition) {
                return specimen;
            }
        }
        return specimens[specimensPopulation.size() - 1];
    }

    public SpecimensPopulation Crossover(SpecimensPopulation specimensPopulation) {
        SpecimensPopulation newSpecimensPopulation = new SpecimensPopulation(specimensPopulation.size());

        for (int popIndex = 0; popIndex < specimensPopulation.size(); popIndex++) {
            Specimen specimenParent = specimensPopulation.getFittestSpecimens(popIndex);

            if (this.rateOfCrossover > Math.random() && popIndex > this.ElitismCounter) {
                Specimen specimenOffspring = new Specimen(specimenParent.getLengthOfChromosome());

                Specimen specimenSecondParent = selectParentSpecimens(specimensPopulation);

                for (int geneIndex = 0; geneIndex < specimenParent.getLengthOfChromosome(); geneIndex++) {
                    if (0.5 > Math.random()) {
                        specimenOffspring.setGene(geneIndex, specimenParent.getGene(geneIndex));
                    } else {
                        specimenOffspring.setGene(geneIndex, specimenSecondParent.getGene(geneIndex));
                    }
                }
                newSpecimensPopulation.setSpecimen(popIndex, specimenOffspring);
            } else {
                newSpecimensPopulation.setSpecimen(popIndex, specimenParent);
            }
        }
        return newSpecimensPopulation;
    }

    public SpecimensPopulation Mutation(SpecimensPopulation specimensPopulation) {

        SpecimensPopulation newSpecimensPopulation = new SpecimensPopulation(this.initialPopulationSize);

        for (int popIndex = 0; popIndex < specimensPopulation.size(); popIndex++) {
            Specimen specimen = specimensPopulation.getFittestSpecimens(popIndex);

            for (int geneIndex = 0; geneIndex < specimen.getLengthOfChromosome(); geneIndex++) {

                if (popIndex >= this.ElitismCounter) {

                   // Integer newGene;
                   // newGene = null;
                    if (this.rateOfMutation > Math.random()) {
                        int newGene = 1;
                        if (specimen.getGene(geneIndex) == 1) {
                            newGene = 0;
                        }
                        specimen.setGene(geneIndex, newGene);
                    }

                }
            }
            newSpecimensPopulation.setSpecimen(popIndex,specimen);
        }
        return newSpecimensPopulation;
    }




}

