package com.airbnb.lottie.t.c;

import android.view.animation.Interpolator;
import com.airbnb.lottie.c;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a<K, A>  {

    final List<com.airbnb.lottie.t.c.a.b> a;
    private boolean b = false;
    private final com.airbnb.lottie.t.c.a.d<K> c;
    protected float d = 0f;
    protected c<A> e;
    private A f = 0;
    private float g = -1f;
    private float h = -1f;

    static class a {
    }

    public interface b {
        public abstract void a();
    }

    private interface d {
        public abstract boolean a(float f);

        public abstract a<T> b();

        public abstract boolean c(float f);

        public abstract float d();

        public abstract float e();

        public abstract boolean isEmpty();
    }

    private static final class c implements com.airbnb.lottie.t.c.a.d<T> {
        c(com.airbnb.lottie.t.c.a.a a$a) {
            super();
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean a(float f) {
            IllegalStateException obj2 = new IllegalStateException("not implemented");
            throw obj2;
        }

        public a<T> b() {
            IllegalStateException illegalStateException = new IllegalStateException("not implemented");
            throw illegalStateException;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean c(float f) {
            return 0;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float d() {
            return 1065353216;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float e() {
            return 0;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean isEmpty() {
            return 1;
        }
    }

    private static final class e implements com.airbnb.lottie.t.c.a.d<T> {

        private final List<? extends a<T>> a;
        private a<T> b;
        private a<T> c = null;
        private float d = -1f;
        e(List<? extends a<T>> list) {
            super();
            int i = 0;
            int i2 = -1082130432;
            this.a = list;
            this.b = f(0);
        }

        private a<T> f(float f) {
            int i;
            int cmp;
            boolean z;
            List list = this.a;
            final int i4 = 1;
            Object obj = list.get(size2 -= i4);
            if (Float.compare(f, f2) >= 0) {
                return obj;
            }
            size += -2;
            while (i >= i4) {
                cmp = this.a.get(i);
                i--;
            }
            return (a)this.a.get(0);
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean a(float f) {
            a cmp;
            final a aVar = this.b;
            if (this.c == aVar && Float.compare(f2, f) == 0) {
                if (Float.compare(f2, f) == 0) {
                    return 1;
                }
            }
            this.c = aVar;
            this.d = f;
            return 0;
        }

        public a<T> b() {
            return this.b;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean c(float f) {
            final int i = 1;
            if (this.b.a(f)) {
                return obj3 ^= i;
            }
            this.b = f(f);
            return i;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float d() {
            List list = this.a;
            return (a)list.get(size--).b();
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float e() {
            return (a)this.a.get(0).e();
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean isEmpty() {
            return 0;
        }
    }

    private static final class f implements com.airbnb.lottie.t.c.a.d<T> {

        private final a<T> a;
        private float b = -1f;
        f(List<? extends a<T>> list) {
            super();
            int i = -1082130432;
            this.a = (a)list.get(0);
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean a(float f) {
            if (Float.compare(f2, f) == 0) {
                return 1;
            }
            this.b = f;
            return 0;
        }

        public a<T> b() {
            return this.a;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean c(float f) {
            return obj1 ^= 1;
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float d() {
            return this.a.b();
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public float e() {
            return this.a.e();
        }

        @Override // com.airbnb.lottie.t.c.a$d
        public boolean isEmpty() {
            return 0;
        }
    }
    a(List<? extends a<K>> list) {
        super();
        ArrayList arrayList = new ArrayList(1);
        this.a = arrayList;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1082130432;
        this.c = a.o(list);
    }

    private float g() {
        int cmp;
        if (Float.compare(f, i) == 0) {
            this.g = this.c.e();
        }
        return this.g;
    }

    private static <T> com.airbnb.lottie.t.c.a.d<T> o(List<? extends a<T>> list) {
        if (list.isEmpty()) {
            a.c obj2 = new a.c(0);
            return obj2;
        }
        if (list.size() == 1) {
            a.f fVar = new a.f(list);
            return fVar;
        }
        a.e eVar = new a.e(list);
        return eVar;
    }

    public void a(com.airbnb.lottie.t.c.a.b a$b) {
        this.a.add(b);
    }

    protected a<K> b() {
        final String str = "BaseKeyframeAnimation#getCurrentKeyframe";
        c.a(str);
        c.b(str);
        return this.c.b();
    }

    float c() {
        int cmp;
        if (Float.compare(f, i) == 0) {
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
        int i = 0;
        if (this.b) {
            return i;
        }
        a aVar = b();
        if (aVar.h()) {
            return i;
        }
        return i2 /= i4;
    }

    public float f() {
        return this.d;
    }

    public A h() {
        Object obj;
        c cVar;
        Interpolator interpolation2;
        Interpolator interpolation;
        float f = e();
        if (this.e == null && this.c.a(f)) {
            if (this.c.a(f)) {
                return this.f;
            }
        }
        a aVar = b();
        interpolation2 = aVar.e;
        if (interpolation2 != null && aVar.f != null) {
            if (aVar.f != null) {
                obj = j(aVar, f, interpolation2.getInterpolation(f), aVar.f.getInterpolation(f));
            } else {
                obj = i(aVar, d());
            }
        } else {
        }
        this.f = obj;
        return obj;
    }

    abstract A i(a<K> a, float f2);

    protected A j(a<K> a, float f2, float f3, float f4) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("This animation does not support split dimensions!");
        throw obj1;
    }

    public void k() {
        int i;
        Object obj;
        i = 0;
        while (i < this.a.size()) {
            (a.b)this.a.get(i).a();
            i++;
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(float f) {
        int cmp;
        float obj2;
        if (this.c.isEmpty()) {
        }
        if (Float.compare(f, f2) < 0) {
            obj2 = g();
        } else {
            if (Float.compare(f, f4) > 0) {
                obj2 = c();
            }
        }
        if (Float.compare(obj2, f3) == 0) {
        }
        this.d = obj2;
        if (this.c.c(obj2)) {
            k();
        }
    }

    public void n(c<A> c) {
        int i;
        final c cVar = this.e;
        if (cVar != null) {
            cVar.c(0);
        }
        this.e = c;
        if (c != null) {
            c.c(this);
        }
    }
}
