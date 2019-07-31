package org.tuctiki.doc.excel2word;


import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Excel2WordTest {

    @Autowired
    private Excel2Word excel2Word;

    @Test
    public void test() throws InvalidFormatException, Excel4JException, IOException {
        File input = new File("D:\\shared\\excel2word\\input.xlsx");
        File output = new File("D:\\shared\\excel2word\\output.docx");

        try (InputStream segmentStream = new FileInputStream("D:\\shared\\excel2word\\segment_template.docx");
             InputStream templateStream = new FileInputStream("D:\\shared\\excel2word\\base_template.docx")) {
            excel2Word.exec(input, output, segmentStream, templateStream);
        }

    }


}