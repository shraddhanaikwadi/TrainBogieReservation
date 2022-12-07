package org.example;


import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Train {
   static ArrayList<String> trainA=new ArrayList<String>();
   static ArrayList<String> trainB=new ArrayList<String>();
   static final ArrayList<String> stationTrainA=new ArrayList<>
           (Arrays.asList("CHN","SLM","BLR","KRN","HYB","NGP","ITJ","BPL","AGA","NDL"));
   static final ArrayList<String> stationTrainB=new ArrayList<>
           (Arrays.asList("TVC","SRR","MAQ","MAO","PNE","HYB","NGP","ITJ","BPL","PTA","NJP","GHY"));

   static final ArrayList<String> stationsTillHYB=new ArrayList<>
           (Arrays.asList("CHN","SLM","BLR","KRN","TVC","SRR","MAQ","MAO","PNE"));

   static final ArrayList<String> stationsFromHYBToBPL=new ArrayList<>
           (Arrays.asList("NGP","ITJ","BPL"));

    static final ArrayList<String> stationsFromBPLToEnd=new ArrayList<>
            (Arrays.asList("AGA","NDL","PTA","NJP","GHY"));
    public static void readinput() {


            try {
                FileInputStream file = new FileInputStream(new File("C:/Users/002S6G744/Documents/POC/TrainSystem.xlsx"));
                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet)
                //iteration over row using for each loop
                {
                    for (Cell cell : row) //iteration over cell using for each loop
                    {
                        if(row.getRowNum()==0) {
                            trainA.add(cell.getStringCellValue());
                        }
                        else{
                            trainB.add(cell.getStringCellValue());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    public static List<String> sortList(ArrayList<String> expectedTrainlist,ArrayList<String> inputlist){
        List<String> stationList=new ArrayList<>();
        stationList.add("ENGINE");
        for (String station:expectedTrainlist) {
            if(inputlist.contains(station)) {
                List<Integer> indices=findIndices(inputlist, station);
                //int index = inputlist.indexOf(station);
                if(indices.size()!=0) {
                    for (int i = 0; i < indices.size(); i++) {
                        stationList.add(inputlist.get(indices.get(i)));
                    }
                }
            }
        }
        return stationList;
    }

    static List<Integer> findIndices(ArrayList<String> list, String key) {
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).equals(key))
                .boxed().collect(Collectors.toList());
    }

    public static List<String> removeBogiesTillHYBStationAndMergeBothTrains(List<String> stationListA, List<String> stationListB){
        List<String> AList=stationListA.stream().collect(Collectors.toList());
        List<String> BList=stationListB.stream().collect(Collectors.toList());
        for(String station:AList){
            if(stationsTillHYB.contains(station)){
                stationListA.remove(station);
            }
            stationListA.remove("ENGINE");
        }
        for(String station:BList){
            if(stationsTillHYB.contains(station)){
                stationListB.remove(station);
            }
            stationListB.remove("ENGINE");
        }
        System.out.println("train A");
        stationListA.forEach(System.out::println);
        System.out.println("train B");
        Collections.reverse(stationListB);
        stationListB.forEach(System.out::println);

        List<String> trainAB= new ArrayList<>();
        trainAB.add("TRAIN_AB");
        trainAB.add("ENGINE");
        trainAB.add("ENGINE");
        trainAB.addAll(stationListB);
        Collections.reverse(stationListA);
        trainAB.addAll(stationListA);
        //departure from HYB so removed HYB bogie
        trainAB.remove("HYB");
        return trainAB;
    }

    public static void main(String args[]) {
        readinput();
        trainA.remove(0);
        trainB.remove(0);
        //trainA.forEach(System.out::println);
        //trainB.forEach(System.out::println);
        List<String> stationListA=sortList(stationTrainA,trainA);
       // stationListA.forEach(System.out::println);
        List<String> stationListB=sortList(stationTrainB,trainB);
       // stationListB.forEach(System.out::println);
        //merge trainA and trainB at HYB station
        List<String> departure=removeBogiesTillHYBStationAndMergeBothTrains(stationListA,stationListB);
        System.out.println("Merged Train A & B At HYB");
        departure.forEach(System.out::print);


    }


}

