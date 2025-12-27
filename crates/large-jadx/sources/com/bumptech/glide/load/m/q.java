package com.bumptech.glide.load.m;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.t.k;
import d.h.k.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    private final List<n<Model, Data>> a;
    private final f<List<Throwable>> b;

    static class a<Data> implements d<Data>, d.a<Data> {

        private final List<d<Data>> a;
        private final f<List<Throwable>> b;
        private int c = 0;
        private com.bumptech.glide.h v;
        private d.a<? super Data> w;
        private List<Throwable> x;
        private boolean y;
        a(List<d<Data>> list, f<List<Throwable>> fVar) {
            super();
            this.b = fVar;
            k.c(list);
            this.a = list;
        }

        private void g() {
            if (this.y) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                this.c++;
                e(this.v, this.w);
            } else {
                k.d(this.x);
                str = "Fetch failed";
                this.w.c(new GlideException(str, new ArrayList(this.x)));
            }
        }

        public Class<Data> a() {
            return (d)this.a.get(0).a();
        }

        public void b() {
            f item;
            if (this.x != null) {
                this.b.a(this.x);
            }
            this.x = null;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                (d)it.next().b();
            }
        }

        public void c(Exception exc) {
            k.d(this.x);
            list.add(exc);
            g();
        }

        public void cancel() {
            this.y = true;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                (d)it.next().cancel();
            }
        }

        public a d() {
            return (d)this.a.get(0).d();
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super Data> aVar) {
            this.v = hVar;
            this.w = aVar;
            this.x = (List)this.b.b();
            (d)this.a.get(this.c).e(hVar, this);
            if (this.y) {
                cancel();
            }
        }

        public void f(Data data) {
            if (data != null) {
                this.w.f(data);
            } else {
                g();
            }
        }
    }
    q(List<n<Model, Data>> list, f<List<Throwable>> fVar) {
        super();
        this.a = list;
        this.b = fVar;
    }

    public boolean a(Model model) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if ((n)it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    public n.a<Data> b(Model model, int i, int i2, com.bumptech.glide.load.h hVar) {
        int i4 = 0;
        com.bumptech.glide.load.f fVar;
        Object item;
        int size = this.a.size();
        final ArrayList arrayList = new ArrayList(size);
        i = 0;
        i4 = 0;
        while (i4 < this.a) {
            item = this.a.get(i4);
            i4 = i4 + 1;
        }
        if (!arrayList.isEmpty() && fVar != null) {
            com.bumptech.glide.load.m.n.a aVar = new n.a(fVar, new q.a(arrayList, this.b));
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "MultiModelLoader{modelLoaders=";
        String str3 = Arrays.toString(this.a.toArray());
        str = str2 + str3 + 125;
        return str;
    }
}
