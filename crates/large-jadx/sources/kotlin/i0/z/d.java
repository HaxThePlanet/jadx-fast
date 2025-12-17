package kotlin.i0.z;

import kotlin.Metadata;
import kotlin.d;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.i0.f;
import kotlin.i0.g;
import kotlin.i0.z.e.b;
import kotlin.i0.z.e.j0;
import kotlin.i0.z.e.k;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.j.b.u;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;

/* loaded from: classes3.dex */
public final class d {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\u0008\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007", d2 = {"R", "Lkotlin/i0/z/e/m0/j/b/u;", "p1", "Lkotlin/i0/z/e/m0/e/i;", "p2", "Lkotlin/reflect/jvm/internal/impl/descriptors/t0;", "l", "(Lkotlin/i0/z/e/m0/j/b/u;Lkotlin/i0/z/e/m0/e/i;)Lkotlin/reflect/jvm/internal/impl/descriptors/t0;"}, k = 3, mv = {1, 4, 1})
    static final class a extends j implements p<u, i, t0> {

        public static final kotlin.i0.z.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        a() {
            super(2);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(u.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object, Object object2) {
            return l((u)object, (i)object2);
        }

        @Override // kotlin.d0.d.j
        public final t0 l(u u, i i2) {
            n.f(u, "p1");
            n.f(i2, "p2");
            return u.n(i2);
        }
    }
    public static final <R> g<R> a(d<? extends R> d) {
        Object annotation;
        int i;
        int i4;
        int i2;
        int i3;
        Class class;
        Object obj;
        Object obj2;
        g gVar;
        f fVar;
        kotlin.i0.z.d.a aVar;
        Object obj12;
        n.f(d, "$this$reflect");
        annotation = d.getClass().getAnnotation(Metadata.class);
        int i7 = 0;
        if ((Metadata)annotation != null) {
            i3 = 0;
            i4 = i.length == 0 ? i2 : i3;
            if (i4 == 0) {
            } else {
                i = i7;
            }
            if (i != 0) {
                o oVar = h.j(i, annotation.d2());
                obj = obj4;
                if (i5 &= 8 != 0) {
                } else {
                    i2 = i3;
                }
                fVar = new f(annotation.mv(), i2);
                obj12 = (i)obj.Y();
                n.e(obj12, "proto.typeTable");
                gVar = new g(obj12);
                obj12 = j0.f(d.getClass(), obj, (g)oVar.a(), gVar, fVar, d.a.a);
                if ((t0)obj12 != null) {
                    k kVar = new k(b.v, (t0)obj12);
                    return kVar;
                }
            }
        }
        return i7;
    }
}
