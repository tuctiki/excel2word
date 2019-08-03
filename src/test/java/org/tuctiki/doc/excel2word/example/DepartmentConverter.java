package org.tuctiki.doc.excel2word.example;

import com.github.crab2died.converter.ReadConvertible;
import org.apache.commons.lang3.StringUtils;

public class DepartmentConverter implements ReadConvertible {
    @Override
    public Object execRead(String name) {
        if (StringUtils.contains(name, "-")) {
            return StringUtils.substringAfter(name, "-");
        }
        return name;
    }
}
