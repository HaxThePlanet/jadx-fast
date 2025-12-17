package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: classes2.dex */
public final class m implements com.squareup.picasso.d {

    final LruCache<String, com.squareup.picasso.m.b> a;

    class a extends LruCache<String, com.squareup.picasso.m.b> {
        a(com.squareup.picasso.m m, int i2) {
            super(i2);
        }

        @Override // android.util.LruCache
        protected int a(String string, com.squareup.picasso.m.b m$b2) {
            return b2.b;
        }

        @Override // android.util.LruCache
        protected int sizeOf(Object object, Object object2) {
            return a((String)object, (m.b)object2);
        }
    }

    static final class b {

        final Bitmap a;
        final int b;
        b(Bitmap bitmap, int i2) {
            super();
            this.a = bitmap;
            this.b = i2;
        }
    }
    public m(int i) {
        super();
        m.a aVar = new m.a(this, i);
        this.a = aVar;
    }

    public m(Context context) {
        super(f0.b(context));
    }

    @Override // com.squareup.picasso.d
    public int a() {
        return this.a.maxSize();
    }

    @Override // com.squareup.picasso.d
    public void b(String string, Bitmap bitmap2) {
        if (string == null) {
        } else {
            if (bitmap2 == null) {
            } else {
                final int i = f0.i(bitmap2);
                if (i > a()) {
                    this.a.remove(string);
                }
                m.b bVar = new m.b(bitmap2, i);
                this.a.put(string, bVar);
            }
        }
        NullPointerException obj4 = new NullPointerException("key == null || bitmap == null");
        throw obj4;
    }

    @Override // com.squareup.picasso.d
    public Bitmap get(String string) {
        Bitmap obj2;
        obj2 = this.a.get(string);
        obj2 = (m.b)obj2 != null ? obj2.a : 0;
        return obj2;
    }

    @Override // com.squareup.picasso.d
    public int size() {
        return this.a.size();
    }
}
