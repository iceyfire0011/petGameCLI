package com.company.service.presentation;

import com.company.constantManager.PropertyConstant;

public class PresentationService implements IPresentationService{
    @Override
    public void printAsTableRow(boolean isHeader, String[] values){
        int headerLength = 0;
        System.out.print("|");
        for(var s : values){
            for(int i = s.length(); i < PropertyConstant.MAX_PRESENTATION_COLUMN_LENGTH; i++){
                s += " ";
            }
            s += "|";
            headerLength += PropertyConstant.MAX_PRESENTATION_COLUMN_LENGTH + 1;
            System.out.print(s);
        }
        System.out.println();
        if(isHeader){
            printSeparator(headerLength);
        }
    }

    @Override
    public void printSeparator(int length){
        var totalString = "-";
        for(int i = 0; i < length; i++){
            totalString += "-";
        }
        System.out.println(totalString);
    }
}
