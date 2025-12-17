package com.google.gson.internal;

import java.math.BigDecimal;

/* loaded from: classes2.dex */
public final class LazilyParsedNumber extends Number {

    private final String value;
    public LazilyParsedNumber(String string) {
        super();
        this.value = string;
    }

    private Object writeReplace() {
        BigDecimal bigDecimal = new BigDecimal(this.value);
        return bigDecimal;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override // java.lang.Number
    public boolean equals(Object object) {
        int i;
        String obj4;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        String value = this.value;
        obj4 = object.value;
        if (object instanceof LazilyParsedNumber && value != obj4) {
            value = this.value;
            obj4 = object.value;
            if (value != obj4) {
                if (value.equals(obj4)) {
                } else {
                    i = i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
            String intValue = this.value;
            intValue = Long.parseLong(intValue);
            intValue = (int)intValue;
            return intValue;
            intValue = new BigDecimal(this.value);
            intValue = intValue.intValue();
            return intValue;
        } catch (java.lang.NumberFormatException numberFormat) {
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.value);
            BigDecimal longValue = new BigDecimal(this.value);
            longValue = longValue.longValue();
            return longValue;
        }
    }

    @Override // java.lang.Number
    public String toString() {
        return this.value;
    }
}
