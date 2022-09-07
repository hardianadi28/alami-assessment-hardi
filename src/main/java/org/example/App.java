package org.example;

import org.example.model.CustomerBalance;
import org.example.thread.*;
import org.example.util.CsvUtil;

import java.io.FileNotFoundException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        CsvUtil csvUtil = new CsvUtil();
        List<CustomerBalance> customerBalances = csvUtil.readCsv("Before Eod.csv");

        ThreadHelper averageBalance = new CalculateAverageBalanceThread(customerBalances);
        averageBalance.execute();

        ThreadHelper freeTransfer = new CalculateFreeTransferThread(customerBalances);
        freeTransfer.execute();

        ThreadHelper bonusBalance = new CalculateBonusBalanceThread(customerBalances);
        bonusBalance.execute();

        ThreadHelper extraBonusBalance = new CalculateBonus1000BalanceThread(customerBalances);
        extraBonusBalance.execute();


        csvUtil.writeCsv(customerBalances, "After Eod.csv");
    }
}
