package org.tuctiki.doc.excel2word;

import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class Excel2Word {

    @Autowired
    ExcelReader reader;

    @Autowired
    WordWriter writer;

    public void exec(File inputExcel, File target, InputStream segmentStream, InputStream templateStream, Class clazz) throws InvalidFormatException, Excel4JException, IOException {
        List pages = reader.read(inputExcel, clazz);
        writer.write(target, pages, segmentStream, templateStream);
    }

}
