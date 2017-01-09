package com.javabycode.view;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.javabycode.model.Fruit;

import org.apache.poi.ss.usermodel.Workbook;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class XlsView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"fruits.xls\"");

        @SuppressWarnings("unchecked")
        List<Fruit> fruits = (List<Fruit>) model.get("fruits");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Fruits Xls");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("No");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Produce by");

        // Create data cells
        int rowCount = 1;
        for (Fruit fruit : fruits){
            Row fruitRow = sheet.createRow(rowCount++);
            fruitRow.createCell(0).setCellValue(fruit.getId());
            fruitRow.createCell(1).setCellValue(fruit.getName());
            fruitRow.createCell(2).setCellValue(fruit.getProduceBy());
        }
    }
}