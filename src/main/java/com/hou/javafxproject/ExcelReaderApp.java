package com.hou.javafxproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author krystal
 * @create 2023-08-29 10:35
 */
public class ExcelReaderApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建按钮
        Button partAttributesButton = new Button("读取零件属性");
        Button constraintInfoButton = new Button("读取约束信息");
        Button interferenceInfoButton = new Button("读取干涉信息");

        // 为按钮添加点击事件处理程序
        partAttributesButton.setOnAction(event -> readExcel("PartAttributes.xlsx"));
        constraintInfoButton.setOnAction(event -> readExcel("ConstraintInfo.xlsx"));
        interferenceInfoButton.setOnAction(event -> readExcel("InterferenceInfo.xlsx"));

        // 创建垂直布局并添加按钮
        VBox layout = new VBox(10);
        layout.getChildren().addAll(partAttributesButton, constraintInfoButton, interferenceInfoButton);

        // 创建场景并设置布局
        Scene scene = new Scene(layout, 300, 200);

        // 设置舞台的标题和场景
        primaryStage.setTitle("Excel Reader App");
        primaryStage.setScene(scene);

        // 显示舞台
        primaryStage.show();
    }

    // 读取 Excel 表格
    private void readExcel(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    // 处理单元格数据，可以根据需要进行具体的操作
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}