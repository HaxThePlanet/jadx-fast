package com.google.android.datatransport.cct.f;

import android.util.SparseArray;

/* loaded from: classes.dex */
public enum p {

    DEFAULT(false),
    UNMETERED_ONLY(true),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);

    private final int value;
    public static com.google.android.datatransport.cct.f.p forNumber(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return p.NEVER;
                    }
                    return p.FAST_IF_RADIO_AWAKE;
                }
                return p.UNMETERED_OR_DAILY;
            }
            return p.UNMETERED_ONLY;
        }
        return p.DEFAULT;
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
