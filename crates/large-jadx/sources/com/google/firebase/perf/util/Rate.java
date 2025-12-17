package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Rate {

    static final boolean $assertionsDisabled;
    private long numTimeUnits;
    private long numTokensPerTotalTimeUnit;
    private TimeUnit timeUnit;
    static {
    }

    public Rate(long l, long l2, TimeUnit timeUnit3) {
        super();
        this.numTokensPerTotalTimeUnit = l;
        this.numTimeUnits = timeUnit3;
        this.timeUnit = obj5;
    }

    public double getTokensPerSeconds() {
        int i = Rate.1.$SwitchMap$java$util$concurrent$TimeUnit[this.timeUnit.ordinal()];
        int i12 = 1;
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return d2 /= d6;
                }
                return i5 *= d7;
            }
            return i2 *= d5;
        }
        return i7 *= d8;
    }
}
