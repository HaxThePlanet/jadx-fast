package com.bumptech.glide.load.m.y;

import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.g;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public class a implements n<g, InputStream> {

    public static final g<Integer> b;
    private final m<g, g> a;

    public static class a implements o<g, InputStream> {

        private final m<g, g> a;
        public a() {
            super();
            m mVar = new m(500, obj2);
            this.a = mVar;
        }

        public n<g, InputStream> b(r r) {
            a obj2 = new a(this.a);
            return obj2;
        }
    }
    static {
        a.b = g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }

    public a(m<g, g> m) {
        super();
        this.a = m;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((g)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public n.a b(Object object, int i2, int i3, h h4) {
        return c((g)object, i2, i3, h4);
    }

    public n.a<InputStream> c(g g, int i2, int i3, h h4) {
        Object obj1;
        Object obj2;
        int obj3;
        obj2 = this.a;
        if (obj2 != null) {
            obj3 = 0;
            obj2 = obj2.a(g, obj3, obj3);
            if ((g)obj2 == null) {
                this.a.b(g, obj3, obj3, g);
            } else {
                obj1 = obj2;
            }
        }
        j obj4 = new j(obj1, (Integer)h4.c(a.b).intValue());
        obj3 = new n.a(obj1, obj4);
        return obj3;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(g g) {
        return 1;
    }
}
