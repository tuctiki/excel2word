package org.tuctiki.doc.excel2word;

import com.github.crab2died.converter.ReadConvertible;
import org.apache.commons.lang3.StringUtils;

public class MoneyConverter implements ReadConvertible {
    @Override
    public Object execRead(String money) {
        if (StringUtils.isNotEmpty(money)) {
            try {
                Integer iMoney = Integer.valueOf(StringUtils.substringBefore(StringUtils.remove(money, ","), "."));
                return String.valueOf(iMoney / 10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "0";
    }
}
