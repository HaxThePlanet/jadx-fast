package com.yuyakaido.android.cardstackview;

/* loaded from: classes2.dex */
public enum c {

    Fast(100),
    Normal(200),
    Slow(500);

    public final int duration;
    public static com.yuyakaido.android.cardstackview.c fromVelocity(int i) {
        if (i < 1000) {
            return c.Slow;
        }
        if (i < 5000) {
            return c.Normal;
        }
        return c.Fast;
    }
}
