package org.tuctiki.doc.excel2word;


import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class InputExcelReader<T> {

    public List<T> read(File input) throws InvalidFormatException, Excel4JException, IOException {

        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return ExcelUtils.getInstance().readExcel2Objects(input.getAbsolutePath(), clazz, 0, 0);

    }
}
