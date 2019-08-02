package org.tuctiki.doc.excel2word;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyConverterTest {

    MoneyConverter converter = new MoneyConverter();

    @Test
    public void test() {
        assertEquals("0", converter.execRead(""));
        assertEquals("0", converter.execRead(null));
        assertEquals("5054", converter.execRead("50,549,255"));
    }

}