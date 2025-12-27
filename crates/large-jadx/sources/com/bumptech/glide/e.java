package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class e extends ContextWrapper {

    static final l<?, ?> k = new b<>();
    private final b a;
    private final Registry b;
    private final com.bumptech.glide.r.k.f c;
    private final c.a d;
    private final List<com.bumptech.glide.r.f<Object>> e;
    private final Map<Class<?>, l<?, ?>> f;
    private final k g;
    private final f h;
    private final int i;
    private g j;

    public e(Context context, b bVar, Registry registry, com.bumptech.glide.r.k.f fVar, c.a aVar, Map<Class<?>, l<?, ?>> map, List<com.bumptech.glide.r.f<Object>> list, k kVar, f fVar2, int i) {
        super(context.getApplicationContext());
        this.a = bVar;
        this.b = registry;
        this.c = fVar;
        this.d = aVar;
        this.e = list;
        this.f = map;
        this.g = kVar;
        this.h = fVar2;
        this.i = i;
    }

    @Override // android.content.ContextWrapper
    public <X> i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    @Override // android.content.ContextWrapper
    public b b() {
        return this.a;
    }

    @Override // android.content.ContextWrapper
    public List<com.bumptech.glide.r.f<Object>> c() {
        return this.e;
    }

    @Override // android.content.ContextWrapper
    public synchronized g d() {
        if (this.j == null) {
            this.j = (g)this.d.build().S();
        }
        return this.j;
    }

    @Override // android.content.ContextWrapper
    public <T> l<?, T> e(Class<T> cls) {
        Object value;
        boolean assignableFrom;
        if ((l)this.f.get(cls) == null) {
            Iterator it = this.f.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
        if (this.f == null) {
            com.bumptech.glide.l lVar = e.k;
        }
        return value;
    }

    @Override // android.content.ContextWrapper
    public k f() {
        return this.g;
    }

    @Override // android.content.ContextWrapper
    public f g() {
        return this.h;
    }

    @Override // android.content.ContextWrapper
    public int h() {
        return this.i;
    }

    @Override // android.content.ContextWrapper
    public Registry i() {
        return this.b;
    }
}
