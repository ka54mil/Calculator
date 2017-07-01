package com.example.panicz.calculator.Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class Constants{
    private static String fileName = "Constants.bin";
    private static BigDecimal e;

    public static String getFileName(){
        return fileName;
    }
    public static BigDecimal getE(){
        if(e==null){
            setE();
        }
        return e;
    }

    public static BigDecimal getE(int scale){
        if(getE().scale()<scale){
            setE(scale);
            return e;
        }
        return e.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static void setE(){
        setEWithFileVar();
    }

    public static void setE(int scale){
        try{
            int precised = scale;
            if(Integer.MAX_VALUE-5<precised){
                precised = Integer.MAX_VALUE;
            } else {
                precised +=5;
            }
            e = Factorial.sumInvertedFactorial(precised, BigDecimal.ROUND_HALF_UP).setScale(scale,BigDecimal.ROUND_HALF_UP);
            saveToFile(e, "e");
        }catch(Exception e){
            System.out.println(scale+" is not a valid input");
        }
    }

    public static void setFileName(String fileName){
        Constants.fileName = fileName;
    }

    public static void setEWithFileVar()throws NoSuchElementException{
        BigDecimal result = readFromFile("e");
        if(result != null){
            e = result;
        } else {
            setE(500);
        }
    }

    private static void saveToFile(BigDecimal constant, String name){
        BufferedWriter bw;
        BufferedReader br;
        String data;
        boolean saved = false;
        try{
            File f = new File(fileName);
            if(!f.exists()){
                f.createNewFile();
            }
            br = new BufferedReader(new FileReader(f));
            bw = new BufferedWriter(new FileWriter("Constants2.bin"));
            while((data = br.readLine())!= null ){
                bw.write(data);
                bw.newLine();
                if(data.equals(name)){
                    if(new BigDecimal(br.readLine()).scale()<constant.scale()){
                        bw.write(constant.toPlainString());
                        bw.newLine();
                    }
                    saved = true;
                }
            }
            if(!saved){
                bw.write(name);
                bw.newLine();
                bw.write(constant.toPlainString());
                bw.newLine();
            }
            br.close();
            bw.close();
            replaceFile(fileName,"Constants2.bin");
        }catch(Exception a){
            a.printStackTrace();
        }
    }

    private static void replaceFile(String toReplace, String replacement){
        new File(toReplace).delete();
        File f = new File(replacement);
        f.renameTo(new File(toReplace));
        f.setWritable(false);
    }

    private static BigDecimal readFromFile(String name){
        BufferedReader br;
        BigDecimal result = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while((data = br.readLine())!= null ){
                if(data.equals(name)){
                    result = new BigDecimal(br.readLine());
                }
            }
            br.close();
        }catch(Exception a){

        }
        return result;
    }
}
