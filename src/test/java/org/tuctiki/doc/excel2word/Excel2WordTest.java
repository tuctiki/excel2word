package org.tuctiki.doc.excel2word;


import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tuctiki.doc.excel2word.example.Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class Excel2WordTest {

    public static final String WORKSPACE = "D:\\shared\\excel2word\\";

    private Excel2Word excel2Word = new Excel2Word();

    @Test
    public void south() throws InvalidFormatException, Excel4JException, IOException {
        File input = new File(WORKSPACE + "jiu_asset_report_s.xls");
        File output = new File(WORKSPACE + "南部院区.docx");
        produce(input, output);
    }

    @Test
    public void north() throws InvalidFormatException, Excel4JException, IOException {
        File input = new File(WORKSPACE + "jiu_asset_report_n.xls");
        File output = new File(WORKSPACE + "北部院区.docx");
        produce(input, output);
    }

    private void produce(File input, File output) throws IOException, InvalidFormatException, Excel4JException {
        try (InputStream segmentStream = new FileInputStream(WORKSPACE + "segment_template.docx");
             InputStream templateStream = new FileInputStream(WORKSPACE + "base_template.docx")) {
            Map<String, InputStream> templates = new HashMap<>();
            templates.put(WordWriter.BASE_TEMPLATE, templateStream);
            templates.put(WordWriter.SEGMENT_TEMPLATES, segmentStream);
            excel2Word.exec(input, output, templates, Page.class);
        }
    }
}