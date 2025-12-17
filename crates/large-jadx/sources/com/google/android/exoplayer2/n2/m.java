package com.google.android.exoplayer2.n2;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.w.a;

/* loaded from: classes2.dex */
public final class m {
    public static w.a a(com.google.android.exoplayer2.n2.g g) {
        int i;
        int i2;
        boolean z;
        final int length = g.length();
        final int i4 = 0;
        i2 = i;
        while (i < length) {
            if (g.d(i, SystemClock.elapsedRealtime())) {
            }
            i++;
            i2++;
        }
        w.a obj7 = new w.a(1, i4, length, i2);
        return obj7;
    }
}
