package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.l;

/* loaded from: classes.dex */
public final class b0 implements j<Bitmap, Bitmap> {

    private static final class a implements u<Bitmap> {

        private final Bitmap a;
        a(Bitmap bitmap) {
            super();
            this.a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.u
        public void a() {
        }

        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.u
        public Bitmap c() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.engine.u
        public Object get() {
            return c();
        }

        @Override // com.bumptech.glide.load.engine.u
        public int getSize() {
            return l.g(this.a);
        }
    }
    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((Bitmap)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((Bitmap)object, i2, i3, h4);
    }

    public u<Bitmap> c(Bitmap bitmap, int i2, int i3, h h4) {
        b0.a obj2 = new b0.a(bitmap);
        return obj2;
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(Bitmap bitmap, h h2) {
        return 1;
    }
}
