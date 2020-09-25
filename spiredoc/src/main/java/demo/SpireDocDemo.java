package demo;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableRow;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TableRowHeightType;
import com.spire.doc.documents.VerticalAlignment;
import com.spire.doc.fields.TextRange;

import java.awt.*;

public class SpireDocDemo {
    public static void main(String[] args) {
        //创建Word文档
        Document document = new Document();
        //添加一个section
        Section section = document.addSection();

        //数据
        String[] header = {"姓名", "性别", "部门", "工号"};
        String[][] data =
                {
                        new String[]{"Winny", "女", "综合", "0109"},
                        new String[]{"Lois", "女", "综合", "0111"},
                        new String[]{"Jois", "男", "技术", "0110"},
                        new String[]{"Moon", "女", "销售", "0112"},
                        new String[]{"Vinit", "女", "后勤", "0113"},
                };

        //添加表格
        Table table = section.addTable(true);
        //设置表格的行数和列数
        table.resetCells(data.length + 1, header.length);

        //设置第一行作为表格的表头并添加数据
        TableRow row = table.getRows().get(0);
        row.isHeader(true);
        row.setHeight(20);
        row.setHeightType(TableRowHeightType.Exactly);
        row.getRowFormat().setBackColor(Color.gray);
        for (int i = 0; i < header.length; i++) {
            row.getCells().get(i).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
            Paragraph p = row.getCells().get(i).addParagraph();
            p.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            TextRange range1 = p.appendText(header[i]);
            range1.getCharacterFormat().setFontName("Arial");
            range1.getCharacterFormat().setFontSize(12f);
            range1.getCharacterFormat().setBold(true);
        }

        //添加数据到剩余行
        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r + 1);
            dataRow.setHeight(25);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(Color.white);
            for (int c = 0; c < data[r].length; c++) {
                dataRow.getCells().get(c).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                TextRange range2 = dataRow.getCells().get(c).addParagraph().appendText(data[r][c]);
                range2.getCharacterFormat().setFontName("Arial");
                range2.getCharacterFormat().setFontSize(10f);
            }
        }

        //设置单元格背景颜色
        for (int j = 1; j < table.getRows().getCount(); j++) {
            if (j % 2 == 0) {
                TableRow row2 = table.getRows().get(j);
                for (int f = 0; f < row2.getCells().getCount(); f++) {
                    row2.getCells().get(f).getCellFormat().setBackColor(new Color(173, 216, 230));
                }
            }
        }

        //保存文档
        document.saveToFile("/Users/xuziwen/Desktop/demo/MavenDemo/spiredoc/src/main/resources/wordFile/CreateTable.docx", FileFormat.Docx_2013);

    }
}

