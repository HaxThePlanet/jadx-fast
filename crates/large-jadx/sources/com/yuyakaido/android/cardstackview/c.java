package com.yuyakaido.android.cardstackview;

/* compiled from: Duration.java */
/* loaded from: classes2.dex */
public enum c {

    Fast,
    Normal,
    Slow;

    public final int duration;
    public static c fromVelocity(int i) {
        if (i < 1000) {
            return c.Slow;
        }
        if (c.Slow < 5000) {
            return c.Normal;
        }
        return c.Fast;
    }
}
