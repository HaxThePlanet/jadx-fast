package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* compiled from: LruCache.java */
/* loaded from: classes2.dex */
public final class m implements d {

    final LruCache<String, m.b> a;

    class a extends LruCache<String, m.b> {
        a(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        protected int a(String str, m.b bVar) {
            return bVar.b;
        }
    }

    static final class b {

        final Bitmap a;
        final int b;
        b(Bitmap bitmap, int i) {
            super();
            this.a = bitmap;
            this.b = i;
        }
    }
    public m(Context context) {
        this(f0.b(context));
    }

    public int a() {
        return this.a.maxSize();
    }

    public void b(String str, Bitmap bitmap) {
        if (str == null) {
            throw new NullPointerException("key == null || bitmap == null");
        } else {
            if (bitmap != null) {
                final int i = f0.i(bitmap);
                if (i > a()) {
                    this.a.remove(str);
                    return;
                }
                this.a.put(str, new m.b(bitmap, i));
                return;
            }
        }
    }

    public Bitmap get(String str) {
        Bitmap bitmap = null;
        Object obj = this.a.get(str);
        str = obj != null ? obj.a : 0;
        return (obj != null ? obj.a : 0);
    }

    public int size() {
        return this.a.size();
    }

    public m(int i) {
        super();
        this.a = new m.a(this, i);
    }
}
