package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class i implements com.google.android.gms.internal.measurement.q {

    private final Double a;
    public i(Double double) {
        super();
        if (double == null) {
            this.a = Double.valueOf(9221120237041090560L);
        }
        this.a = double;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        i iVar = new i(this.a);
        return iVar;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        boolean naN;
        int i;
        double doubleValue;
        int i2;
        i = 0;
        if (!Double.isNaN(this.a.doubleValue()) && Double.compare(doubleValue, i2) != 0) {
            if (Double.compare(doubleValue, i2) != 0) {
                i = 1;
            }
        }
        return Boolean.valueOf(i);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (!object instanceof i) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        if (!"toString".equals(string)) {
        } else {
            u obj3 = new u(zzi());
            return obj3;
        }
        Object[] obj5 = new Object[2];
        IllegalArgumentException obj4 = new IllegalArgumentException(String.format("%s.%s is not a function.", zzi(), string));
        throw obj4;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String toString() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        Object stripTrailingZeros;
        String plainString;
        int precision;
        int indexOf;
        int i;
        if (Double.isNaN(this.a.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.a.doubleValue()) && Double.compare(doubleValue3, i2) > 0) {
            if (Double.compare(doubleValue3, i2) > 0) {
                return "Infinity";
            }
            return "-Infinity";
        }
        stripTrailingZeros = BigDecimal.valueOf(this.a.doubleValue()).stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (stripTrailingZeros.scale() > 0) {
            precision = stripTrailingZeros.precision();
        } else {
            precision = stripTrailingZeros.scale();
        }
        decimalFormat.setMinimumFractionDigits(precision--);
        plainString = decimalFormat.format(stripTrailingZeros);
        String str7 = "E";
        indexOf = plainString.indexOf(str7);
        if (indexOf > 0) {
            indexOf = Integer.parseInt(plainString.substring(indexOf++));
            if (indexOf < 0) {
                if (indexOf <= -7) {
                    if (indexOf >= 0 && indexOf < 21) {
                        if (indexOf < 21) {
                            plainString = stripTrailingZeros.toPlainString();
                        } else {
                            plainString = plainString.replace("E-", "e-").replace(str7, "e+");
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return plainString;
    }
}
