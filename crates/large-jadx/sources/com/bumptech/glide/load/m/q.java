package com.bumptech.glide.load.m;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class q<Model, Data>  implements com.bumptech.glide.load.m.n<Model, Data> {

    private final List<com.bumptech.glide.load.m.n<Model, Data>> a;
    private final f<List<Throwable>> b;

    static class a implements d<Data>, d.a<Data> {

        private final List<d<Data>> a;
        private final f<List<Throwable>> b;
        private int c = 0;
        private h v;
        private d.a<? super Data> w;
        private List<Throwable> x;
        private boolean y;
        a(List<d<Data>> list, f<List<Throwable>> f2) {
            super();
            this.b = f2;
            k.c(list);
            this.a = list;
            final int obj1 = 0;
        }

        private void g() {
            Object hVar;
            Object glideException;
            ArrayList arrayList;
            String str;
            if (this.y) {
            }
            if (this.c < size--) {
                this.c = i2++;
                e(this.v, this.w);
            } else {
                k.d(this.x);
                arrayList = new ArrayList(this.x);
                glideException = new GlideException("Fetch failed", arrayList);
                this.w.c(glideException);
            }
        }

        public Class<Data> a() {
            return (d)this.a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            f next;
            List list = this.x;
            if (list != null) {
                this.b.a(list);
            }
            this.x = 0;
            Iterator iterator = this.a.iterator();
            for (d next : iterator) {
                next.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(Exception exception) {
            final List list = this.x;
            k.d(list);
            (List)list.add(exception);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            Object next;
            this.y = true;
            Iterator iterator = this.a.iterator();
            for (d next : iterator) {
                next.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return (d)this.a.get(0).d();
        }

        public void e(h h, d.a<? super Data> d$a2) {
            this.v = h;
            this.w = a2;
            this.x = (List)this.b.b();
            (d)this.a.get(this.c).e(h, this);
            if (this.y) {
                cancel();
            }
        }

        public void f(Data data) {
            d.a aVar;
            if (data != null) {
                this.w.f(data);
            } else {
                g();
            }
        }
    }
    q(List<com.bumptech.glide.load.m.n<Model, Data>> list, f<List<Throwable>> f2) {
        super();
        this.a = list;
        this.b = f2;
    }

    public boolean a(Model model) {
        boolean z;
        Iterator iterator = this.a.iterator();
        for (n next2 : iterator) {
        }
        return 0;
    }

    public com.bumptech.glide.load.m.n.a<Data> b(Model model, int i2, int i3, h h4) {
        int aVar;
        int i4;
        int i;
        Object obj;
        boolean z;
        boolean obj8;
        int obj9;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        i4 = 0;
        i = aVar;
        while (i4 < size) {
            obj = this.a.get(i4);
            obj = obj.b(model, i2, i3, h4);
            if ((n)obj.a(model) && obj != null) {
            }
            i4++;
            obj = obj.b(model, i2, i3, h4);
            if (obj != null) {
            }
            i = obj.a;
            arrayList.add(obj.c);
        }
        if (!arrayList.isEmpty() && i != 0) {
            if (i != 0) {
                obj8 = new q.a(arrayList, this.b);
                aVar = new n.a(i, obj8);
            }
        }
        return aVar;
    }

    @Override // com.bumptech.glide.load.m.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiModelLoader{modelLoaders=");
        stringBuilder.append(Arrays.toString(this.a.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
