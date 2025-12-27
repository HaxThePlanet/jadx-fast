package com.yuyakaido.android.cardstackview;

/* compiled from: SwipeableMethod.java */
/* loaded from: classes2.dex */
public enum h {

    Automatic,
    AutomaticAndManual,
    Manual,
    None;
    @Override // java.lang.Enum
    boolean canSwipe() {
        boolean z = false;
        if (canSwipeAutomatically() || this.canSwipeManually()) {
            int i2 = 1;
        }
        return z;
    }

    @Override // java.lang.Enum
    boolean canSwipeAutomatically() {
        boolean z = false;
        if (this == h.AutomaticAndManual || this == h.Automatic) {
            int i2 = 1;
        }
        return z;
    }

    @Override // java.lang.Enum
    boolean canSwipeManually() {
        boolean z = false;
        if (this == h.AutomaticAndManual || this == h.Manual) {
            int i2 = 1;
        }
        return z;
    }
}
