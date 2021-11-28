import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

public class Transaction {

    private double terminal;
    private String saleDate;
    private String paymenteDate;
    private double numberOfInstallments;
    private double saleAmount;
    private double fee;
    private double liquidSaleAmount;

    public Transaction() {}

    public Transaction(double terminal, String saleDate, String paymenteDate, double numberOfInstallments, double saleAmount, double fee, double liquidSaleAmount) {
        this.terminal = terminal;
        this.saleDate = saleDate;
        this.paymenteDate = paymenteDate;
        this.numberOfInstallments = numberOfInstallments;
        this.saleAmount = saleAmount;
        this.fee = fee;
        this.liquidSaleAmount = liquidSaleAmount;
    }

    public static Transaction createTransaction(Row row) {

        Transaction transaction = new Transaction();

        transaction.terminal = row.getCell(3).getNumericCellValue();
        transaction.saleDate = row.getCell(4).getStringCellValue();
        transaction.paymenteDate = row.getCell(7).getStringCellValue();
        transaction.numberOfInstallments = row.getCell(11).getNumericCellValue();
        transaction.saleAmount = row.getCell(15).getNumericCellValue();
        transaction.fee = row.getCell(14).getNumericCellValue()/100;
        transaction.liquidSaleAmount = row.getCell(13).getNumericCellValue();

        return transaction;
    }

    public double getTerminal() {
        return terminal;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public String getPaymenteDate() {
        return paymenteDate;
    }

    public double getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public double getFee() {
        return fee;
    }

    public double getLiquidSaleAmount() {
        return liquidSaleAmount;
    }

    public void setTerminal(double terminal) {
        this.terminal = terminal;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setPaymenteDate(String paymenteDate) {
        this.paymenteDate = paymenteDate;
    }

    public void setNumberOfInstallments(double numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setLiquidSaleAmount(double liquidSaleAmount) {
        this.liquidSaleAmount = liquidSaleAmount;
    }
}
