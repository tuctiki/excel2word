package org.tuctiki.doc.excel2word;

import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Excel2Word {

    ExcelReader reader = new ExcelReader();

    WordWriter writer = new WordWriter();

    public void exec(File inputExcel, File target, Map<String, InputStream> templates, Class clazz) throws InvalidFormatException, Excel4JException, IOException {
        List pages = reader.read(inputExcel, clazz);
        writer.write(target, pages, templates);
    }

}
