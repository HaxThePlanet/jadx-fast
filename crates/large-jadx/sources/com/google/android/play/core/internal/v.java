package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.f0;
import java.util.List;

/* loaded from: classes2.dex */
final class v implements Runnable {

    final List a;
    final f0 b;
    final com.google.android.play.core.internal.w c;
    v(com.google.android.play.core.internal.w w, List list2, f0 f03) {
        this.c = w;
        this.a = list2;
        this.b = f03;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (w.b(this.c).b(this.a)) {
            }
            w.d(this.c, this.b);
            w.c(this.c, this.a, this.b);
            String str = "SplitCompat";
            Log.e(str, "Error checking verified files.", th);
            Throwable th = this.b;
            str = -11;
            th.a(str);
        }
    }
}
