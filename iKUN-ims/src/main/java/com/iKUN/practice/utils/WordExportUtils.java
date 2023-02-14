package com.iKUN.practice.utils;

import com.iKUN.common.utils.poi.WordUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author iKUN
 * @Date 2022/12/24 17:07
 * @Description TODO
 * @Version 1.0
 */
public class WordExportUtils {

    private WordExportUtils(){

    }
    /**
     * 替换文档中段落文本
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     */
    public static void changeParagraphText(XWPFDocument document, Map<String, String> textMap) {
        //获取段落集合
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            //判断此段落时候需要进行替换
            String text = paragraph.getText();
            if (checkText(text)) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    //替换模板原来位置
                    run.setText(changeValue(run.toString(), textMap), 0);
                }
            }
        }
    }
    /**
     * 复制表头 插入行数据，这里样式和表头一样
     * @param document  docx解析对象
     * @param tableList   需要插入数据集合
     * @param headerIndex 表头的行索引，从0开始
     */
    public static void  copyHeaderInsertText(XWPFDocument document, List<String[]> tableList, int headerIndex){
        if(null == tableList){
            return;
        }
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        for (XWPFTable table : tables) {
            XWPFTableRow copyRow = table.getRow(headerIndex);
            List<XWPFTableCell> cellList = copyRow.getTableCells();
            if (null == cellList) {
                break;
            }
            //遍历要添加的数据的list
            for (int i = 0; i < tableList.size(); i++) {
                //插入一行
                XWPFTableRow targetRow = table.insertNewTableRow(headerIndex + 1 + i);
                //复制行属性
                targetRow.getCtRow().setTrPr(copyRow.getCtRow().getTrPr());
                String[] strings =  tableList.get(i);
                for (int j = 0; j < strings.length; j++) {
                    XWPFTableCell sourceCell = cellList.get(j);
                    //插入一个单元格
                    XWPFTableCell targetCell = targetRow.addNewTableCell();
                    //复制列属性
                    targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
                    targetCell.setText(strings[j]);
                }
            }
        }
    }
    /**
     * 替换表格对象方法
     *
     * @param document  docx解析对象
     * @param textMap   需要替换的信息集合
     */
    public static void changeTableText(XWPFDocument document, Map<String, String> textMap) {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        for (int i = 0; i < tables.size(); i++) {
            //只处理行数大于等于2的表格
            XWPFTable table = tables.get(i);
            if (table.getRows().size() > 1) {
                //判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
                if (checkText(table.getText())) {
                    List<XWPFTableRow> rows = table.getRows();
                    //遍历表格,并替换模板
                    eachTable(rows, textMap);
                }
            }
        }
    }

    /**
     * 遍历表格,并替换模板
     *
     * @param rows    表格行对象
     * @param textMap 需要替换的信息集合
     */
    public static void eachTable(List<XWPFTableRow> rows, Map<String, String> textMap) {
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                //判断单元格是否需要替换
                if (checkText(cell.getText())) {
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        List<XWPFRun> runs = paragraph.getRuns();
                        for (XWPFRun run : runs) {
                            run.setText(changeValue(run.toString(), textMap), 0);
                        }
                    }
                }
            }
        }
    }
    /**
     * 匹配传入信息集合与模板
     *
     * @param value   模板需要替换的区域
     * @param textMap 传入信息集合
     * @return 模板需要替换区域信息集合对应值
     */
    public static String changeValue(String value, Map<String, String> textMap) {
        Set<Map.Entry<String, String>> textSets = textMap.entrySet();
        for (Map.Entry<String, String> textSet : textSets) {
            //匹配模板与替换值 格式${key}
            String key = "${" + textSet.getKey() + "}";
            if (value.indexOf(key) != -1) {
                value = textSet.getValue();
            }
        }
        //模板未匹配到区域替换为空
        if (checkText(value)) {
            value = "";
        }
        return value;
    }

    /**
     * 判断文本中时候包含$
     *
     * @param text 文本
     * @return 包含返回true, 不包含返回false
     */
    public static boolean checkText(String text) {
        boolean check = false;
        if (text.indexOf("$") != -1) {
            check = true;
        }
        return check;
    }

/*    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name","鄢汉雄");
        map.put("username","17690137");
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        //String templatePath = WordExportUtils.class.getClassLoader().getResource("D:\\28611\\Desktop\\实习周记\\专业实习周记模板.docx").getPath();
        XWPFDocument document = null;
        try {
            //解析docx模板并获取document对象
            document = new XWPFDocument(new FileInputStream("D:\\28611\\Desktop\\实习周记\\专业实习周记模板.docx"));

            WordExportUtils.changeParagraphText(document, map);

            document.write(byteOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }*/
    public static void main(String[] args) throws IOException {
        //模板文件地址
        String inputUrl = "D:\\28611\\Desktop\\实习周记\\专业实习周记模板.docx";
        File file = new File(inputUrl);
        //新生产的模板文件
        String outputUrl = "D:\\28611\\Desktop\\实习周记\\专业实习周记模板-1.docx";
        File file1 = new File(outputUrl);

        FileUtils.copyFile(file,file1);
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("name", "小明");
        testMap.put("username", "男");
        testMap.put("class", "软件园");
        testMap.put("phone", "88888888");
        WordUtil.changWord(inputUrl, outputUrl, testMap, null);
    }
}
