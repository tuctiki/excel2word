package org.tuctiki.doc.excel2word;

import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

@Data
public class Page {

    @ExcelField(title = "科室", order = 1)
    private String department;

    @ExcelField(title = "设备数", order = 2)
    private String deviceCount;

}
