package com.google.android.exoplayer2.util;

import android.os.Trace;

/* loaded from: classes2.dex */
public final class n0 {
    public static void a(String string) {
        if (p0.a >= 18) {
            n0.b(string);
        }
    }

    private static void b(String string) {
        Trace.beginSection(string);
    }

    public static void c() {
        if (p0.a >= 18) {
            n0.d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
