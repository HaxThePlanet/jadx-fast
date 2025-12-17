package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class y0 implements Runnable {

    final com.google.android.play.core.splitinstall.c a;
    final com.google.android.play.core.splitinstall.i b;
    y0(com.google.android.play.core.splitinstall.i i, com.google.android.play.core.splitinstall.c c2) {
        this.b = i;
        this.a = c2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object str;
        boolean arrayList;
        Object str2;
        boolean arrayList2;
        str = this.a.b();
        str2 = i.h(this.a.a());
        Bundle bundle = new Bundle();
        final int i2 = 0;
        bundle.putInt("session_id", i2);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", i2);
        if (!str.isEmpty()) {
            arrayList2 = new ArrayList(str);
            bundle.putStringArrayList("module_names", arrayList2);
        }
        if (!str2.isEmpty()) {
            arrayList = new ArrayList(str2);
            bundle.putStringArrayList("languages", arrayList);
        }
        int i = 0;
        bundle.putLong("total_bytes_to_download", i);
        bundle.putLong("bytes_downloaded", i);
        i.g(this.b).k(d.n(bundle));
    }
}
