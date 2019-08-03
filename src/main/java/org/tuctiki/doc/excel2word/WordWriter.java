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

    public static final String BASE_TEMPLATE = "base";
    public static final String SEGMENT_TEMPLATES = "segment";

    public void write(File target, List pages, Map<String, InputStream> templates) throws IOException {
        LOGGER.info("Start to processing report");

        Map<String, Object> datas = new HashMap<>();

        datas.put("segment", new DocxRenderData(templates.get(SEGMENT_TEMPLATES), pages));

        Configure.ConfigureBuilder builder = Configure.newBuilder();
        XWPFTemplate template = null;
        try (FileOutputStream out = new FileOutputStream(target)) {
            template = XWPFTemplate.compile(templates.get(BASE_TEMPLATE), builder.build());
            template.render(datas);
            template.write(out);
        } finally {
            if (template != null) {
                template.close();
            }
        }
    }
}
