package com.bumptech.glide.o;

import android.content.Context;

/* loaded from: classes.dex */
final class e implements com.bumptech.glide.o.c {

    private final Context a;
    final com.bumptech.glide.o.c.a b;
    e(Context context, com.bumptech.glide.o.c.a c$a2) {
        super();
        this.a = context.getApplicationContext();
        this.b = a2;
    }

    private void a() {
        s.a(this.a).d(this.b);
    }

    private void b() {
        s.a(this.a).e(this.b);
    }

    @Override // com.bumptech.glide.o.c
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.o.c
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.o.c
    public void onStop() {
        b();
    }
}
