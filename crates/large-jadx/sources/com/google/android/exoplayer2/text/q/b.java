package com.google.android.exoplayer2.text.q;

import android.text.TextUtils;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.b;

/* loaded from: classes2.dex */
final class b {

    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    private b(int i, int i2, int i3, int i4, int i5) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public static com.google.android.exoplayer2.text.q.b a(String string) {
        com.google.android.exoplayer2.text.q.b bVar;
        int i4;
        int i5;
        String equals;
        com.google.android.exoplayer2.text.q.b length2;
        int i3;
        int i2;
        int i6;
        int i;
        int length;
        g.a(string.startsWith("Format:"));
        String[] obj9 = TextUtils.split(string.substring(7), ",");
        int i8 = 0;
        final int i9 = -1;
        i4 = i8;
        i = i6;
        for (Object str3 : string) {
            equals = b.c(str3.trim());
            equals.hashCode();
            i5 = i9;
            i6 = i4;
            i3 = i4;
            i = i4;
            i2 = i4;
            if (equals.equals("style") == null) {
            } else {
            }
            i5 = 3;
            if (equals.equals("start") == null) {
            } else {
            }
            i5 = 2;
            if (equals.equals("text") == null) {
            } else {
            }
            i5 = 1;
            if (equals.equals("end") == null) {
            } else {
            }
            i5 = i8;
        }
        if (i3 != i9 && i2 != i9 && i != i9) {
            if (i2 != i9) {
                if (i != i9) {
                    super(i3, i2, i6, i, obj9.length);
                } else {
                    bVar = 0;
                }
            } else {
            }
        } else {
        }
        return bVar;
    }
}
