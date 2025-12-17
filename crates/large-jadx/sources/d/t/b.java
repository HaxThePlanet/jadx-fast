package d.t;

import android.os.Trace;

/* loaded from: classes.dex */
final class b {
    public static void a(String string) {
        Trace.beginSection(string);
    }

    public static void b() {
        Trace.endSection();
    }
}
