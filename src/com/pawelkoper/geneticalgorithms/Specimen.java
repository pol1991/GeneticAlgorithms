package com.pawelkoper.geneticalgorithms;

public class Specimen {
    private int[] chromosome;
    private double fitnessRate = -1;

    public Specimen(int[] chromosome)
    {
        this.chromosome=chromosome;
    }

    public Specimen(int lengthofchromosome)
    {
        this.chromosome = new int[lengthofchromosome];

        for (int gene = 0; gene <lengthofchromosome; gene++) {

            if (0.5<Math.random()){
                this.setGene(gene,1);
            }
            else {
                this.setGene(gene,0);
            }
        }
    }

    public int getLengthOfChromosome(){
        return this.chromosome.length;
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }
    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitnessRate() {
        return this.fitnessRate;
    }

    public void setFitnessRate(double fitnessRate) {
        this.fitnessRate = fitnessRate;
    }

    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene];
        }
        return output;
    }

    public int toInt() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene];
        }
        Integer foo = Integer.parseInt(output, 2);

        return foo;
    }

    public double toDouble(){
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene];
        }
        Integer foo = Integer.parseInt(output, 2);
        Double foo2 = Double.parseDouble(String.valueOf(foo));
        return foo2;
    }


    }

