package kotlin.i0.z.e;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.l0.d;
import kotlin.i0.z.e.l0.e;
import kotlin.i0.z.e.l0.e.f.a;
import kotlin.i0.z.e.l0.e.f.b;
import kotlin.i0.z.e.l0.e.f.c;
import kotlin.i0.z.e.l0.e.f.d;
import kotlin.i0.z.e.l0.e.f.e;
import kotlin.i0.z.e.l0.e.g.a;
import kotlin.i0.z.e.l0.e.g.b;
import kotlin.i0.z.e.l0.e.g.c;
import kotlin.i0.z.e.l0.e.g.d;
import kotlin.i0.z.e.l0.e.g.e;
import kotlin.i0.z.e.l0.e.h.a;
import kotlin.i0.z.e.l0.e.h.b;
import kotlin.i0.z.e.l0.e.h.c;
import kotlin.i0.z.e.l0.e.h.d;
import kotlin.i0.z.e.l0.e.h.e;
import kotlin.i0.z.e.l0.e.h.f;
import kotlin.i0.z.e.l0.h;
import kotlin.i0.z.e.l0.i.a;
import kotlin.i0.z.e.l0.i.b;
import kotlin.i0.z.e.l0.j;
import kotlin.i0.z.e.m0.e.a0.a.c;
import kotlin.i0.z.e.m0.e.a0.a.d;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.j.b.d0.j;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.k0.h;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* loaded from: classes3.dex */
public final class u {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"", "invoke", "()Z", "isJvmStaticProperty"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<Boolean> {

        final kotlin.i0.z.e.t.a $this_computeCallerForAccessor;
        a(kotlin.i0.z.e.t.a t$a) {
            this.$this_computeCallerForAccessor = a;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            return this.$this_computeCallerForAccessor.C().E().getAnnotations().u1(j0.h());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"", "invoke", "()Z", "isNotNullProperty"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<Boolean> {

        final kotlin.i0.z.e.t.a $this_computeCallerForAccessor;
        b(kotlin.i0.z.e.t.a t$a) {
            this.$this_computeCallerForAccessor = a;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            return z ^= 1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"Ljava/lang/reflect/Field;", "field", "Lkotlin/i0/z/e/l0/e;", "a", "(Ljava/lang/reflect/Field;)Lkotlin/i0/z/e/l0/e;"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements l<Field, e<? extends Field>> {

        final boolean $isGetter;
        final kotlin.i0.z.e.u.a $isJvmStaticProperty$1;
        final kotlin.i0.z.e.u.b $isNotNullProperty$2;
        final kotlin.i0.z.e.t.a $this_computeCallerForAccessor;
        c(kotlin.i0.z.e.t.a t$a, boolean z2, kotlin.i0.z.e.u.b u$b3, kotlin.i0.z.e.u.a u$a4) {
            this.$this_computeCallerForAccessor = a;
            this.$isGetter = z2;
            this.$isNotNullProperty$2 = b3;
            this.$isJvmStaticProperty$1 = a4;
            super(1);
        }

        public final e<Field> a(Field field) {
            boolean static;
            e cVar;
            Object invoke;
            Object obj;
            n.f(field, "field");
            if (!u.b(this.$this_computeCallerForAccessor.C().E())) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (this.$isGetter) {
                        if (this.$this_computeCallerForAccessor.A()) {
                            cVar = new e.f.a(field, u.d(this.$this_computeCallerForAccessor));
                        } else {
                            cVar = new e.f.c(field);
                        }
                    } else {
                        if (this.$this_computeCallerForAccessor.A()) {
                            cVar = new e.g.a(field, this.$isNotNullProperty$2.invoke(), u.d(this.$this_computeCallerForAccessor));
                        } else {
                            cVar = new e.g.c(field, this.$isNotNullProperty$2.invoke());
                        }
                    }
                } else {
                    if (this.$isJvmStaticProperty$1.invoke()) {
                        if (this.$isGetter) {
                            if (this.$this_computeCallerForAccessor.A()) {
                                cVar = new e.f.b(field);
                            } else {
                                cVar = new e.f.d(field);
                            }
                        } else {
                            if (this.$this_computeCallerForAccessor.A()) {
                                cVar = new e.g.b(field, this.$isNotNullProperty$2.invoke());
                            } else {
                                cVar = new e.g.d(field, this.$isNotNullProperty$2.invoke());
                            }
                        }
                    } else {
                        if (this.$isGetter) {
                            cVar = new e.f.e(field);
                        } else {
                            cVar = new e.g.e(field, this.$isNotNullProperty$2.invoke());
                        }
                    }
                }
            } else {
            }
            return cVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Field)object);
        }
    }
    public static final d a(kotlin.i0.z.e.t.a t$a, boolean z2) {
        return u.c(a, z2);
    }

    public static final boolean b(o0 o0) {
        return u.e(o0);
    }

    private static final d<?> c(kotlin.i0.z.e.t.a<?, ?> t$a, boolean z2) {
        Object dVar2;
        kotlin.i0.z.e.l0.e.h dVar;
        Object aVar;
        kotlin.i0.z.e.e static;
        boolean z;
        String string;
        int i;
        Object obj7;
        Method obj8;
        if (j.c.a().d(a.C().H())) {
            return j.a;
        }
        aVar = new u.a(a);
        u.b bVar = new u.b(a);
        u.c cVar = new u.c(a, z2, bVar, aVar);
        static = g0.b.f(a.C().E());
        final int i3 = 0;
        if (static instanceof e.c) {
            z = (e.c)static.f();
            if (z2 && z.x()) {
                if (z.x()) {
                    obj8 = z.t();
                } else {
                    obj8 = i3;
                }
            } else {
            }
            if (obj8 != null) {
                obj8 = a.C().w().w(static.d().getString(obj8.r()), static.d().getString(obj8.q()));
            } else {
                obj8 = i3;
            }
            if (obj8 == null && f.d(a.C().E()) && n.b(a.C().E().getVisibility(), t.d)) {
                if (f.d(a.C().E())) {
                    if (n.b(a.C().E().getVisibility(), t.d)) {
                        obj8 = h.h(a.C().E().b());
                        if (obj8 == null) {
                        } else {
                            obj8 = h.f(obj8, a.C().E());
                            if (obj8 == null) {
                            } else {
                                if (a.A()) {
                                    dVar2 = new i.a(obj8, u.d(a));
                                } else {
                                    dVar2 = new i.b(obj8);
                                }
                                return h.c(dVar2, a.B(), false, 2, i3);
                            }
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Underlying property of inline class ");
                        stringBuilder4.append(a.C());
                        stringBuilder4.append(" should have a field");
                        obj8 = new a0(stringBuilder4.toString());
                        throw obj8;
                    }
                }
                obj8 = a.C().G();
                if (obj8 == null) {
                } else {
                    dVar2 = cVar.a(obj8);
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("No accessors or field is found for property ");
                stringBuilder3.append(a.C());
                obj8 = new a0(stringBuilder3.toString());
                throw obj8;
            }
            if (!Modifier.isStatic(obj8.getModifiers())) {
                if (a.A()) {
                    dVar2 = new e.h.a(obj8, u.d(a));
                } else {
                    dVar2 = new e.h.d(obj8);
                }
            } else {
                if (aVar.invoke()) {
                    if (a.A()) {
                        dVar2 = new e.h.b(obj8);
                    } else {
                        dVar2 = new e.h.e(obj8);
                    }
                } else {
                    if (a.A()) {
                        dVar2 = new e.h.c(obj8, u.d(a));
                    } else {
                        dVar2 = new e.h.f(obj8);
                    }
                }
            }
        } else {
            if (static instanceof e.a) {
                dVar2 = cVar.a((e.a)static.b());
            } else {
                if (static instanceof e.b) {
                    if (z2) {
                        obj8 = (e.b)static.b();
                        if (a.A()) {
                            dVar2 = new e.h.a(obj8, u.d(a));
                        } else {
                            dVar2 = new e.h.d(obj8);
                        }
                    } else {
                        if ((e.b)static.c() == null) {
                        } else {
                        }
                    }
                    obj8 = new StringBuilder();
                    obj8.append("No source found for setter of Java method property: ");
                    obj8.append(static.b());
                    obj7 = new a0(obj8.toString());
                    throw obj7;
                }
            }
        }
        if (!static instanceof e.d) {
        } else {
            if (z2) {
                obj8 = (e.d)static.b();
                obj8 = a.C().w().w(obj8.c(), obj8.b());
                if (obj8 == null) {
                } else {
                    Modifier.isStatic(obj8.getModifiers());
                    if (a.A()) {
                        dVar = new e.h.a(obj8, u.d(a));
                    } else {
                        dVar = new e.h.d(obj8);
                    }
                    return dVar;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No accessor found for property ");
                stringBuilder.append(a.C());
                obj8 = new a0(stringBuilder.toString());
                throw obj8;
            } else {
                if ((e.d)static.c() == null) {
                } else {
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("No setter found for property ");
            stringBuilder2.append(a.C());
            obj8 = new a0(stringBuilder2.toString());
            throw obj8;
        }
        obj7 = new NoWhenBranchMatchedException();
        throw obj7;
    }

    public static final Object d(kotlin.i0.z.e.t.a<?, ?> t$a) {
        n.f(a, "$this$boundReceiver");
        return a.C().C();
    }

    private static final boolean e(o0 o0) {
        m mVar;
        int i;
        Object obj4;
        m mVar2 = o0.b();
        n.e(mVar2, "containingDeclaration");
        if (!d.x(mVar2)) {
            return 0;
        }
        mVar = mVar2.b();
        if (!d.C(mVar) && d.t(mVar)) {
            if (d.t(mVar)) {
                if (o0 instanceof j) {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
