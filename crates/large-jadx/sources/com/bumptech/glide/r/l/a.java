package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.a;

/* loaded from: classes.dex */
public class a implements com.bumptech.glide.r.l.e<Drawable> {

    private final int a;
    private final boolean b;
    private com.bumptech.glide.r.l.b c;

    public static class a {

        private final int a;
        private boolean b;
        public a() {
            super(300);
        }

        public a(int i) {
            super();
            this.a = i;
        }

        public com.bumptech.glide.r.l.a a() {
            a aVar = new a(this.a, this.b);
            return aVar;
        }
    }
    protected a(int i, boolean z2) {
        super();
        this.a = i;
        this.b = z2;
    }

    private com.bumptech.glide.r.l.d<Drawable> b() {
        com.bumptech.glide.r.l.b bVar;
        int i;
        boolean z;
        if (this.c == null) {
            bVar = new b(this.a, this.b);
            this.c = bVar;
        }
        return this.c;
    }

    public com.bumptech.glide.r.l.d<Drawable> a(a a, boolean z2) {
        com.bumptech.glide.r.l.d obj1;
        if (a == a.MEMORY_CACHE) {
            obj1 = c.b();
        } else {
            obj1 = b();
        }
        return obj1;
    }
}
