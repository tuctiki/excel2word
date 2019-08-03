package org.tuctiki.doc.excel2word.example;

import com.deepoove.poi.config.Name;
import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

@Data
public class Page {

    @ExcelField(title = "科室名称", order = 1, readConverter = DepartmentConverter.class)
    @Name("科室名称")
    private String department;

    @ExcelField(title = "总设备数", order = 2)
    @Name("总设备数")
    private String deviceCount;

    @ExcelField(title = "总设备数金额", order = 3, readConverter = MoneyConverter.class)
    @Name("总设备数金额")
    private String number;

    @ExcelField(title = "六年设备数", order = 4)
    @Name("六年设备数")
    private String deviceCount1;

    @ExcelField(title = "六年设备数金额", order = 5, readConverter = MoneyConverter.class)
    @Name("六年设备数金额")
    private String number1;

    @ExcelField(title = "区间设备数", order = 6)
    @Name("区间设备数")
    private String deviceCount2;

    @ExcelField(title = "区间设备数金额", order = 7, readConverter = MoneyConverter.class)
    @Name("区间设备数金额")
    private String number2;

}
