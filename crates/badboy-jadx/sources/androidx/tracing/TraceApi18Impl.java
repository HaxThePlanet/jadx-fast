package androidx.tracing;

import android.os.Trace;

/* loaded from: classes5.dex */
final class TraceApi18Impl {
    public static void beginSection(String label) {
        Trace.beginSection(label);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
