package com.appsflyer.internal;

/* loaded from: classes.dex */
public class bj {

    public final long values;
    public bj(long l) {
        super();
        this.values = l;
    }

    public boolean equals(Object object) {
        long values;
        Class class;
        long values2;
        Object obj7;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (Long.compare(values, values2) == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int hashCode() {
        long values = this.values;
        return (int)i;
    }
}
