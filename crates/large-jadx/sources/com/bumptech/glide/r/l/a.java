package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.a;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class a implements e<Drawable> {

    private final int a;
    private final boolean b;
    private b c;

    public static class a {

        private final int a;
        private boolean b;
        public a() {
            this(300);
        }

        public a a() {
            return new a(this.a, this.b);
        }

        public a(int i) {
            super();
            this.a = i;
        }
    }
    protected a(int i, boolean z) {
        super();
        this.a = i;
        this.b = z;
    }

    private d<Drawable> b() {
        if (this.c == null) {
            this.c = new b(this.a, this.b);
        }
        return this.c;
    }

    public d<Drawable> a(a aVar, boolean z) {
        com.bumptech.glide.r.l.d dVar;
        if (aVar == a.MEMORY_CACHE) {
            dVar = c.b();
        } else {
            dVar = b();
        }
        return dVar;
    }
}
