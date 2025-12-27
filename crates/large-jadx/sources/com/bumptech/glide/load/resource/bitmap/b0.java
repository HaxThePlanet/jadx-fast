package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.l;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class b0 implements j<Bitmap, Bitmap> {

    private static final class a implements u<Bitmap> {

        private final Bitmap a;
        a(Bitmap bitmap) {
            super();
            this.a = bitmap;
        }

        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        public Bitmap c() {
            return this.a;
        }

        public int getSize() {
            return l.g(this.a);
        }

        public void a() {
        }
    }
    public u<Bitmap> c(Bitmap bitmap, int i, int i2, h hVar) {
        return new b0.a(bitmap);
    }

    public boolean d(Bitmap bitmap, h hVar) {
        return true;
    }
}
