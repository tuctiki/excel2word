package org.tuctiki.doc.excel2word;


import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExcelReader {

    public List read(File input, Class clazz) throws InvalidFormatException, Excel4JException, IOException {
        return ExcelUtils.getInstance().readExcel2Objects(input.getAbsolutePath(), clazz, 0, 0);
    }
}
