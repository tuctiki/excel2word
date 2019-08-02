package org.tuctiki.doc.excel2word;


import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class Excel2WordTest {

    public static final String WORKSPACE = "D:\\shared\\excel2word\\";

    @InjectMocks
    private Excel2Word excel2Word;

    @Spy
    private ExcelReader reader;

    @Spy
    private WordWriter writer;

    @Test
    public void test() throws InvalidFormatException, Excel4JException, IOException {
//        File input = new File(WORKSPACE + "input.xlsx");
        File input = new File(WORKSPACE + "jiu_asset_report.xls");
        File output = new File(WORKSPACE + "output.docx");

        try (InputStream segmentStream = new FileInputStream(WORKSPACE + "segment_template.docx");
             InputStream templateStream = new FileInputStream(WORKSPACE + "base_template.docx")) {
            excel2Word.exec(input, output, segmentStream, templateStream);
        }
    }
}