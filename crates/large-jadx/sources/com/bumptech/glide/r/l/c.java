package com.bumptech.glide.r.l;

import com.bumptech.glide.load.a;

/* loaded from: classes.dex */
public class c<R>  implements com.bumptech.glide.r.l.d<R> {

    static final com.bumptech.glide.r.l.c<?> a;
    private static final com.bumptech.glide.r.l.e<?> b;

    public static class a implements com.bumptech.glide.r.l.e<R> {
        public com.bumptech.glide.r.l.d<R> a(a a, boolean z2) {
            return c.a;
        }
    }
    static {
        c cVar = new c();
        c.a = cVar;
        c.a aVar = new c.a();
        c.b = aVar;
    }

    public static <R> com.bumptech.glide.r.l.d<R> b() {
        return c.a;
    }

    public static <R> com.bumptech.glide.r.l.e<R> c() {
        return c.b;
    }

    @Override // com.bumptech.glide.r.l.d
    public boolean a(Object object, com.bumptech.glide.r.l.d.a d$a2) {
        return 0;
    }
}
