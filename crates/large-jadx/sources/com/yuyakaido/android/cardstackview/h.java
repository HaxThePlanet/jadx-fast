package com.yuyakaido.android.cardstackview;

/* loaded from: classes2.dex */
public enum h {

    AutomaticAndManual,
    Automatic,
    Manual,
    None;
    @Override // java.lang.Enum
    boolean canSwipe() {
        int i;
        boolean swipeAutomatically;
        if (!canSwipeAutomatically()) {
            if (canSwipeManually()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    boolean canSwipeAutomatically() {
        int i;
        com.yuyakaido.android.cardstackview.h automaticAndManual;
        if (this != h.AutomaticAndManual) {
            if (this == h.Automatic) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    boolean canSwipeManually() {
        int i;
        com.yuyakaido.android.cardstackview.h automaticAndManual;
        if (this != h.AutomaticAndManual) {
            if (this == h.Manual) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
