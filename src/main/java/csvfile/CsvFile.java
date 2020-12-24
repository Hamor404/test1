package csvfile;
import static context.NUM.NUM;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import equation.AdditionEquations;
import equation.Equation;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class CsvFile {
    String equationsfilePath ="d:/CSV/equations.csv";
    String exercisesfilePath ="d:/CSV/exercises.csv";
    String inansfilePath="d:/CSV/inans.csv";
    String exercisefilePath="d:/CSV/exercise.csv";
    ArrayList<String[]> lstFile = new ArrayList<String[]>();




    public  void writeEquationsfile(Equation[] equations) {
        CsvWriter csvWriter=new CsvWriter(equationsfilePath,',', Charset.forName("gb2312"));
        try{
            String[] csvHeader={"参数1","运算符","参数2","答案"};
            csvWriter.writeRecord(csvHeader);
            for (Equation equation : equations) {
                String[] csvContent = {String.valueOf(equation.getFirst()), String.valueOf(equation.getOperator()), String.valueOf(equation.getSecond()), String.valueOf(equation.getAnswer())};
                csvWriter.writeRecord(csvContent);
            }
            System.out.println("--------------------已完成写入操作--------------");
            csvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public Equation[] readEquationsfile() throws IOException{
        CsvReader reader=new CsvReader(equationsfilePath,',',Charset.forName("gb2312"));
        Equation[] equations=new AdditionEquations[500];
        for (int i = 0; i < 500; i++) {
            equations[i]=new AdditionEquations();
        }
        try{
            reader.readHeaders();
            while (reader.readRecord()){
                lstFile.add(reader.getValues());
            }
            reader.close();
            for (int i = 0; i < 500; i++) {
                String first=lstFile.get(i)[0];
                equations[i].setFirst(Short.parseShort(first));
                String operator=lstFile.get(i)[1];
                equations[i].setOperator(Short.parseShort(operator));
                String second=lstFile.get(i)[2];
                equations[i].setSecond(Short.parseShort(second));
                String answer=lstFile.get(i)[3];
                equations[i].setAnswer(Short.parseShort(answer));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return equations;
    }

    public Equation[] readExercisesfile() throws IOException{
        CsvReader reader=new CsvReader(exercisesfilePath,',',Charset.forName("gb2312"));
        Equation[] exercises=new AdditionEquations[150];
        for (int i = 0; i < 150; i++) {
            exercises[i]=new AdditionEquations();
        }
        try{
            reader.readHeaders();
            while (reader.readRecord()){
                lstFile.add(reader.getValues());
            }
            reader.close();
            for (int i = 0; i < 150; i++) {
                String first=lstFile.get(i)[0];
                exercises[i].setFirst(Short.parseShort(first));
                String operator=lstFile.get(i)[1];
                exercises[i].setOperator(Short.parseShort(operator));
                String second=lstFile.get(i)[2];
                exercises[i].setSecond(Short.parseShort(second));
                String answer=lstFile.get(i)[3];
                exercises[i].setAnswer(Short.parseShort(answer));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return exercises;
    }

    public  void writeExercisesfile(Equation[] equations) {
        Equation[] exercises=new Equation[150];
        Random random = new Random();
        for (int i = 0; i < 150; i++) {
            int y=random.nextInt(500);
            exercises[i]=equations[y];
        }
        CsvWriter csvWriter=new CsvWriter(exercisesfilePath,',', Charset.forName("gb2312"));
        try{
            String[] csvHeader={"参数1","运算符","参数2","答案"};
            csvWriter.writeRecord(csvHeader);
            for (Equation equation : exercises) {
                String[] csvContent = {String.valueOf(equation.getFirst()), String.valueOf(equation.getOperator()), String.valueOf(equation.getSecond()), String.valueOf(equation.getAnswer())};
                csvWriter.writeRecord(csvContent);
            }
            System.out.println("--------------------已完成写入操作--------------");
            csvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void writeinansfile(int[] inans) {
        CsvWriter csvWriter=new CsvWriter(inansfilePath,',', Charset.forName("gb2312"));
        try{
            String[] csvHeader={"答案"};
            csvWriter.writeRecord(csvHeader);
            for (int inan : inans) {
                String[] csvContent = {String.valueOf(inan)};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("--------------------已完成写入操作--------------");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int[] readinansfile() throws IOException{
        CsvReader reader=new CsvReader(inansfilePath,',',Charset.forName("gb2312"));
        int[] inans=new int[150];
        try{
            reader.readHeaders();
            int i=0;
            while(reader.readRecord()){
                inans[i]=Integer.parseInt(reader.getValues()[0]);
                i++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return inans;
    }

    public  void writeExercisefile(Equation[] equations) {
        Equation[] exercise=new Equation[NUM];
        for (int i = 0; i < NUM; i++) {
            exercise[i]=new AdditionEquations();
        }
        Random random = new Random();
        for (int i = 0; i < NUM; i++) {
            int y=random.nextInt(150);
            exercise[i]=equations[y];
        }

        CsvWriter csvWriter=new CsvWriter(exercisefilePath,',', Charset.forName("gb2312"));
        try{
            String[] csvHeader={"参数1","运算符","参数2","答案"};
            csvWriter.writeRecord(csvHeader);
            for (Equation equation : exercise) {
                String[] csvContent = {String.valueOf(equation.getFirst()), String.valueOf(equation.getOperator()), String.valueOf(equation.getSecond()), String.valueOf(equation.getAnswer())};
                csvWriter.writeRecord(csvContent);
            }
            System.out.println("--------------------已完成写入操作--------------");
            csvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Equation[] readExercisefile() throws IOException{
        CsvReader reader=new CsvReader(exercisefilePath,',',Charset.forName("gb2312"));
        Equation[] exercise=new AdditionEquations[NUM];
        for (int i = 0; i < NUM; i++) {
            exercise[i]=new AdditionEquations();
        }
        try{
            reader.readHeaders();
            while (reader.readRecord()){
                lstFile.add(reader.getValues());
            }
            reader.close();
            for (int i = 0; i <NUM; i++) {
                String first=lstFile.get(i)[0];
                exercise[i].setFirst(Short.parseShort(first));
                String operator=lstFile.get(i)[1];
                exercise[i].setOperator(Short.parseShort(operator));
                String second=lstFile.get(i)[2];
                exercise[i].setSecond(Short.parseShort(second));
                String answer=lstFile.get(i)[3];
                exercise[i].setAnswer(Short.parseShort(answer));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return exercise;
    }


}
