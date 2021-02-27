package demo;

import com.spire.xls.CellRange;
import com.spire.xls.CellStyle;
import com.spire.xls.FileFormat;
import com.spire.xls.HorizontalAlignType;
import com.spire.xls.VerticalAlignType;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.awt.*;

public class SpireXlsDemo {
    public static void main(String[] args) {
        //创建Workbook实例
        Workbook workbook = new Workbook();

        //获取第一张工作表（新建的Workbook默认包含3张工作表）
        Worksheet sheet = workbook.getWorksheets().get(0);
        //为第一张工作表设置名称
        sheet.setName("Data Sheet");

        //创建列头单元格样式
        CellStyle style1 = workbook.getStyles().addStyle("Header Style");
        style1.getFont().setSize(12f);
        style1.getFont().setColor(Color.BLACK);
        style1.getFont().isBold(true);
        style1.setHorizontalAlignment(HorizontalAlignType.Center);
        style1.setVerticalAlignment(VerticalAlignType.Center);

        //创建数据单元格样式
        CellStyle style2 = workbook.getStyles().addStyle("Data Style");
        style2.getFont().setSize(10f);
        style2.getFont().setColor(Color.BLACK);

        //为列头单元格添加数据并应用样式
        for (int column = 1; column < 5; column++) {
            CellRange header = sheet.getCellRange(1, column);
            header.setValue("Column " + column);
            header.setStyle(style1);
            header.setColumnWidth(15f);
        }

        //为数据单元格添加数据并应用样式
        for (int row = 2; row < 110000; row++) {
            for (int column = 1; column < 50; column++) {
                CellRange cell = sheet.getCellRange(row, column);
                cell.setValue("Data " + row + ", " + column);
                cell.setStyle(style2);
            }
        }

        //保存结果文件
        workbook.saveToFile("CreateExcel.xlsx", FileFormat.Version2013);
    }
}
