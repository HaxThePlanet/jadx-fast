package com.bumptech.glide.o;

import android.content.Context;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
final class e implements c {

    private final Context a;
    final c.a b;
    e(Context context, c.a aVar) {
        super();
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void a() {
        s.a(this.a).d(this.b);
    }

    private void b() {
        s.a(this.a).e(this.b);
    }

    public void onStart() {
        a();
    }

    public void onStop() {
        b();
    }

    public void onDestroy() {
    }
}
