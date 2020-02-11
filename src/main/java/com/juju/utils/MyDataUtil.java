package com.juju.utils;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;

public class MyDataUtil extends PropertyEditorSupport {

    private final DateFormat[] dateFormat;
    private final boolean allowEmpty;
    private final int exactDateLength;

    public MyDataUtil(DateFormat[] dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public MyDataUtil(DateFormat[] dateFormat, boolean allowEmpty, int exactDateLength) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        //传过来的值如果是空值的时候的处理方式
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            this.setValue((Object)null);
        } else{
            if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
                throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
            }
            else{
                boolean b = false;
//                解析日期格式
                for (DateFormat d1: dateFormat) {
                    try {
                        this.setValue(d1.parse(text));
                    } catch (ParseException var3) {
                        throw new IllegalArgumentException("Could not parse date: " + var3.getMessage(), var3);
                    }
                }
            }
        }

    }

//    public String getAsText() {
//        Date value = (Date)this.getValue();
//        return value != null ? this.dateFormat.format(value) : "";
//    }

}
