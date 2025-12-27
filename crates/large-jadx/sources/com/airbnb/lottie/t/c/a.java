package com.airbnb.lottie.t.c;

import android.view.animation.Interpolator;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {

    final List<a.b> a = new ArrayList<>(1);
    private boolean b = false;
    private final a.d<K> c;
    protected float d = 0f;
    protected com.airbnb.lottie.z.c<A> e;
    private A f = 0;
    private float g = -1f;
    private float h = -1f;

    static class a {
    }

    public interface b {
        void a();
    }

    private interface d<T> {
        boolean a(float f);

        a<T> b();

        boolean c(float f);

        float d();

        float e();

        boolean isEmpty();
    }

    private static final class c<T> implements a.d<T> {
        private c() {
            super();
        }

        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        public a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        /* synthetic */ c(a.a aVar) {
            this();
        }

        public boolean c(float f) {
            return false;
        }

        public float d() {
            return 1065353216;
        }

        public float e() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    private static final class e<T> implements a.d<T> {

        private final List<? extends a<T>> a;
        private a<T> b;
        private a<T> c = null;
        private float d = -1f;
        e(List<? extends a<T>> list) {
            super();
            this.a = list;
            this.b = f(0.0f);
        }

        private a<T> f(float f) {
            int i;
            boolean z;
            final int i4 = 1;
            Object item = this.a.get(this.a.size() - i4);
            float f2 = item.e();
            if (f >= f2) {
                return item;
            }
            i = this.a.size() - 2;
            while (this.a >= i4) {
                Object item2 = this.a.get(i);
                if (this.b != item2) {
                }
            }
            return (a)this.a.get(0);
        }

        public boolean a(float f) {
            if (this.c == this.b) {
                if (this.d == f) {
                    return true;
                }
            }
            this.c = this.b;
            this.d = f;
            return false;
        }

        public a<T> b() {
            return this.b;
        }

        public boolean c(float f) {
            final boolean z2 = true;
            if (this.b.a(f)) {
                return this.b.h() ^ z2;
            }
            this.b = f(f);
            return true;
        }

        public float d() {
            return (a)this.a.get(this.a.size() - 1).b();
        }

        public float e() {
            return (a)this.a.get(0).e();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private static final class f<T> implements a.d<T> {

        private final a<T> a;
        private float b = -1f;
        f(List<? extends a<T>> list) {
            super();
            this.a = (a)list.get(0);
        }

        public boolean a(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        public a<T> b() {
            return this.a;
        }

        public boolean c(float f) {
            return !this.a.h();
        }

        public float d() {
            return this.a.b();
        }

        public float e() {
            return this.a.e();
        }

        public boolean isEmpty() {
            return false;
        }
    }
    a(List<? extends a<K>> list) {
        super();
        ArrayList arrayList = new ArrayList(1);
        this.c = a.o(list);
    }

    private float g() {
        if (this.g == -1082130432) {
            this.g = this.c.e();
        }
        return this.g;
    }

    private static <T> a.d<T> o(List<? extends a<T>> list) {
        if (list.isEmpty()) {
            return new a.c(null);
        }
        if (list.size() == 1) {
            return new a.f(list);
        }
        return new a.e(list);
    }

    public void a(a.b bVar) {
        this.a.add(bVar);
    }

    protected a<K> b() {
        final String str = "BaseKeyframeAnimation#getCurrentKeyframe";
        c.a(str);
        c.b(str);
        return this.c.b();
    }

    float c() {
        if (this.h == -1082130432) {
            this.h = this.c.d();
        }
        return this.h;
    }

    protected float d() {
        a aVar = b();
        if (aVar.h()) {
            return 0;
        }
        return aVar.d.getInterpolation(e());
    }

    float e() {
        float f2 = 0.0f;
        if (this.b) {
            return 0.0f;
        }
        a aVar = b();
        if (aVar.h()) {
            return 0.0f;
        }
        return (this.d - aVar.e()) / (aVar.b() - aVar.e());
    }

    public float f() {
        return this.d;
    }

    public A h() {
        Object obj;
        Interpolator interpolator2;
        float f = e();
        if (this.e == null && this.c.a(f)) {
            return this.f;
        }
        a aVar = b();
        if (aVar.e == null || aVar.f == null) {
            obj = i(aVar, d());
        } else {
            obj = j(aVar, f, aVar.e.getInterpolation(f), aVar.f.getInterpolation(f));
        }
        this.f = obj;
        return obj;
    }

    protected A j(a<K> aVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        int i = 0;
        i = 0;
        while (i < this.a.size()) {
            (a.b)this.a.get(i).a();
            i = i + 1;
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(float f) {
        float f2;
        if (this.c.isEmpty()) {
            return;
        }
        float f3 = g();
        if (f < f3) {
            f2 = g();
        } else {
            float f5 = c();
            if (f > f5) {
                f2 = c();
            }
        }
        if (f2 == this.d) {
            return;
        }
        this.d = f2;
        if (this.c.c(f2)) {
            k();
        }
    }

    public void n(com.airbnb.lottie.z.c<A> cVar) {
        if (this.e != null) {
            com.airbnb.lottie.t.c.a aVar = null;
            this.e.c(aVar);
        }
        this.e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    abstract A i(a<K> aVar, float f);
}
