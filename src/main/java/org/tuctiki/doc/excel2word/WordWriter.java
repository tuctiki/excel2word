package org.tuctiki.doc.excel2word;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.DocxRenderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordWriter.class);

    public void write(File target, List<Page> pages, InputStream segmentStream, InputStream templateStream) throws IOException {
        LOGGER.info("Start to processing report for {}");

        Map<String, Object> datas = new HashMap<>();

        datas.put("segment", new DocxRenderData(segmentStream, pages));

        Configure.ConfigureBuilder builder = Configure.newBuilder();
        XWPFTemplate template = null;
        try (FileOutputStream out = new FileOutputStream(target);
             InputStream inputStream = templateStream) {
            template = XWPFTemplate.compile(inputStream, builder.build());
            template.render(datas);
            template.write(out);
        } finally {
            if (template != null) {
                template.close();
            }
        }
    }
}
