package com.company.service.presentation;

public interface IPresentationService{
    void printAsTableRow(boolean isHeader,String[] values);
    void printSeparator(int length);
}
