import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ReceivablesReportMain {

    public static void main(String[] args) throws IOException {

        String filePath = "/home/user2/Downloads/SETEMBRO.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workbook.getSheet("SETEMBRO");

        // LISTAS ELO
        ArrayList<Transaction> eloDebit = new ArrayList<>();
        ArrayList<Transaction> eloCredit = new ArrayList<>();
        ArrayList<Transaction> eloCreditWithInstallments = new ArrayList<>();

        // LISTAS VISA
        ArrayList<Transaction> visaDebit = new ArrayList<>();
        ArrayList<Transaction> visaCredit = new ArrayList<>();
        ArrayList<Transaction> visaCreditWithInstallments = new ArrayList<>();

        // LISTAS MASTER
        ArrayList<Transaction> masterDebit = new ArrayList<>();
        ArrayList<Transaction> masterCredit = new ArrayList<>();
        ArrayList<Transaction> masterCreditWithInstallments = new ArrayList<>();

        // LISTAS AMEX
        ArrayList<Transaction> amexCredit = new ArrayList<>();
        ArrayList<Transaction> amexCreditWithInstallments = new ArrayList<>();

        // LISTAS HIPERCARD
        ArrayList<Transaction> hiperCredit = new ArrayList<>();
        ArrayList<Transaction> hiperCreditWithInstallments = new ArrayList<>();

        for (Row row : sheet) {

            switch (row.getCell(9).getStringCellValue().toUpperCase().strip()) {
                case "VISA":
                    if (row.getCell(10).getStringCellValue().strip().equals("DEBITO A VISTA")) {
                        visaDebit.add(Transaction.createTransaction(row));
                        break;
                    } else if (row.getCell(10).getStringCellValue().strip().equals("CREDITO A VISTA")) {
                        visaCredit.add(Transaction.createTransaction(row));
                        break;
                    } else {
                        visaCreditWithInstallments.add(Transaction.createTransaction(row));
                        break;
                    }

                case "ELO":
                    if (row.getCell(10).getStringCellValue().strip().equals("DEBITO A VISTA")) {
                        eloDebit.add(Transaction.createTransaction(row));
                        break;
                    } else if (row.getCell(10).getStringCellValue().strip().equals("CREDITO A VISTA")) {
                        eloCredit.add(Transaction.createTransaction(row));
                        break;
                    } else {
                        eloCreditWithInstallments.add(Transaction.createTransaction(row));
                        break;
                    }

                case "MASTERCARD":
                    if (row.getCell(10).getStringCellValue().strip().equals("DEBITO A VISTA")) {
                        masterDebit.add(Transaction.createTransaction(row));
                        break;
                    } else if (row.getCell(10).getStringCellValue().strip().equals("CREDITO A VISTA")) {
                        masterCredit.add(Transaction.createTransaction(row));
                        break;
                    } else {
                        masterCreditWithInstallments.add(Transaction.createTransaction(row));
                        break;
                    }

                case "AMEX":
                    if (row.getCell(10).getStringCellValue().strip().equals("CREDITO A VISTA")) {
                        amexCredit.add(Transaction.createTransaction(row));
                        break;
                    } else {
                        masterCreditWithInstallments.add(Transaction.createTransaction(row));
                        break;
                    }

                case "HIPERCARD":
                    if (row.getCell(10).getStringCellValue().strip().equals("CREDITO A VISTA")) {
                        hiperCredit.add(Transaction.createTransaction(row));
                        break;
                    } else {
                        hiperCreditWithInstallments.add(Transaction.createTransaction(row));
                        break;
                    }

                default:
                    System.out.println(row.getCell(9).getStringCellValue().toUpperCase().strip());
                    System.out.println("transação sem bandeira definida");
                    break;
            }
        }
        
        for (Transaction transaction : hiperCredit) {
            System.out.println(transaction.getPaymenteDate());
            System.out.println(transaction.getLiquidSaleAmount());
        }
    }
}
