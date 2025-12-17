package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.f;
import com.bumptech.glide.r.k.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public class e extends ContextWrapper {

    static final com.bumptech.glide.l<?, ?> k;
    private final b a;
    private final com.bumptech.glide.Registry b;
    private final f c;
    private final com.bumptech.glide.c.a d;
    private final List<f<Object>> e;
    private final Map<Class<?>, com.bumptech.glide.l<?, ?>> f;
    private final k g;
    private final com.bumptech.glide.f h;
    private final int i;
    private g j;
    static {
        b bVar = new b();
        e.k = bVar;
    }

    public e(Context context, b b2, com.bumptech.glide.Registry registry3, f f4, com.bumptech.glide.c.a c$a5, Map<Class<?>, com.bumptech.glide.l<?, ?>> map6, List<f<Object>> list7, k k8, com.bumptech.glide.f f9, int i10) {
        super(context.getApplicationContext());
        this.a = b2;
        this.b = registry3;
        this.c = f4;
        this.d = a5;
        this.e = list7;
        this.f = map6;
        this.g = k8;
        this.h = f9;
        this.i = i10;
    }

    public <X> i<ImageView, X> a(ImageView imageView, Class<X> class2) {
        return this.c.a(imageView, class2);
    }

    @Override // android.content.ContextWrapper
    public b b() {
        return this.a;
    }

    public List<f<Object>> c() {
        return this.e;
    }

    @Override // android.content.ContextWrapper
    public g d() {
        a gVar;
        synchronized (this) {
            try {
                this.j = (g)this.d.build().S();
                return this.j;
                throw th;
            }
        }
    }

    public <T> com.bumptech.glide.l<?, T> e(Class<T> class) {
        Object value;
        Iterator iterator;
        boolean next;
        boolean assignableFrom;
        if ((l)this.f.get(class) == null) {
            iterator = this.f.entrySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((Class)(Map.Entry)next.getKey().isAssignableFrom(class)) {
                }
                value = next.getValue();
            }
        }
        if (value == null) {
            value = e.k;
        }
        return value;
    }

    @Override // android.content.ContextWrapper
    public k f() {
        return this.g;
    }

    @Override // android.content.ContextWrapper
    public com.bumptech.glide.f g() {
        return this.h;
    }

    @Override // android.content.ContextWrapper
    public int h() {
        return this.i;
    }

    @Override // android.content.ContextWrapper
    public com.bumptech.glide.Registry i() {
        return this.b;
    }
}
