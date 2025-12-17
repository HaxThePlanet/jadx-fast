package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.c.q;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes3.dex */
public final class d {

    private static final l<Object, Boolean> a;
    private static final q<Object, Object, Object, w> b;

    static final class a extends p implements l {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(Object object) {
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a(object);
        }
    }

    static final class b extends p implements l<Object, Boolean> {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.b a;
        static {
            d.b bVar = new d.b();
            d.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(Object object) {
            return 1;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a(object));
        }
    }

    static final class c extends p implements l<Object, w> {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.c a;
        static {
            d.c cVar = new d.c();
            d.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(Object object) {
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a(object);
            return w.a;
        }
    }

    static final class d extends p implements p<Object, Object, w> {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.d a;
        static {
            d.d dVar = new d.d();
            d.d.a = dVar;
        }

        d() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(Object object, Object object2) {
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a(object, object2);
            return w.a;
        }
    }

    static final class e extends p implements q<Object, Object, Object, w> {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.e a;
        static {
            d.e eVar = new d.e();
            d.e.a = eVar;
        }

        e() {
            super(3);
        }

        @Override // kotlin.d0.d.p
        public final void a(Object object, Object object2, Object object3) {
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2, Object object3) {
            a(object, object2, object3);
            return w.a;
        }
    }

    static final class f extends p implements l<Object, Object> {

        public static final kotlin.reflect.jvm.internal.impl.utils.d.f a;
        static {
            d.f fVar = new d.f();
            d.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Object invoke(Object object) {
            return object;
        }
    }
    static {
        kotlin.reflect.jvm.internal.impl.utils.d.f fVar = d.f.a;
        d.a = d.b.a;
        kotlin.reflect.jvm.internal.impl.utils.d.a aVar = d.a.a;
        kotlin.reflect.jvm.internal.impl.utils.d.c cVar = d.c.a;
        kotlin.reflect.jvm.internal.impl.utils.d.d dVar = d.d.a;
        d.b = d.e.a;
    }

    public static final <T> l<T, Boolean> a() {
        return d.a;
    }

    public static final q<Object, Object, Object, w> b() {
        return d.b;
    }
}
