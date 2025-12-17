package kotlin.i0.z.e;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f0 {

    private static final c a;
    public static final kotlin.i0.z.e.f0 b;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/c1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/c1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements l<c1, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.f0.a a;
        static {
            f0.a aVar = new f0.a();
            f0.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(c1 c1) {
            n.e(c1, "it");
            b0 obj3 = c1.getType();
            n.e(obj3, "it.type");
            return f0.b.h(obj3);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c1)object);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/c1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/c1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements l<c1, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.f0.b a;
        static {
            f0.b bVar = new f0.b();
            f0.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(c1 c1) {
            n.e(c1, "it");
            b0 obj3 = c1.getType();
            n.e(obj3, "it.type");
            return f0.b.h(obj3);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c1)object);
        }
    }
    static {
        f0 f0Var = new f0();
        f0.b = f0Var;
        f0.a = c.b;
    }

    private final void a(StringBuilder stringBuilder, r0 r02) {
        String str;
        String obj3;
        if (r02 != null) {
            obj3 = r02.getType();
            n.e(obj3, "receiver.type");
            stringBuilder.append(h(obj3));
            stringBuilder.append(".");
        }
    }

    private final void b(StringBuilder stringBuilder, a a2) {
        int i;
        String str;
        Object obj4;
        r0 r0Var = j0.g(a2);
        obj4 = a2.m0();
        a(stringBuilder, r0Var);
        if (r0Var != null && obj4 != null) {
            i = obj4 != null ? 1 : 0;
        } else {
        }
        if (i != 0) {
            stringBuilder.append("(");
        }
        a(stringBuilder, obj4);
        if (i != 0) {
            stringBuilder.append(")");
        }
    }

    private final String c(a a) {
        boolean z;
        String obj3;
        if (a instanceof o0) {
            obj3 = g((o0)a);
            return obj3;
        } else {
            if (!a instanceof x) {
            } else {
                obj3 = d((x)a);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal callable: ");
        stringBuilder.append(a);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    public final String d(x x) {
        n.f(x, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fun ");
        final kotlin.i0.z.e.f0 f0Var = f0.b;
        f0Var.b(stringBuilder, x);
        kotlin.i0.z.e.m0.f.e name = x.getName();
        n.e(name, "descriptor.name");
        stringBuilder.append(f0.a.w(name, true));
        java.util.List list = x.h();
        n.e(list, "descriptor.valueParameters");
        p.f0(list, stringBuilder, ", ", "(", ")", 0, 0, f0.a.a, 48, 0);
        stringBuilder.append(": ");
        b0 obj13 = x.getReturnType();
        n.d(obj13);
        n.e(obj13, "descriptor.returnType!!");
        stringBuilder.append(f0Var.h(obj13));
        obj13 = stringBuilder.toString();
        n.e(obj13, "StringBuilder().apply(builderAction).toString()");
        return obj13;
    }

    public final String e(x x) {
        n.f(x, "invoke");
        StringBuilder stringBuilder = new StringBuilder();
        final kotlin.i0.z.e.f0 f0Var = f0.b;
        f0Var.b(stringBuilder, x);
        java.util.List list = x.h();
        n.e(list, "invoke.valueParameters");
        p.f0(list, stringBuilder, ", ", "(", ")", 0, 0, f0.b.a, 48, 0);
        stringBuilder.append(" -> ");
        b0 obj13 = x.getReturnType();
        n.d(obj13);
        n.e(obj13, "invoke.returnType!!");
        stringBuilder.append(f0Var.h(obj13));
        obj13 = stringBuilder.toString();
        n.e(obj13, "StringBuilder().apply(builderAction).toString()");
        return obj13;
    }

    public final String f(kotlin.i0.z.e.p p) {
        String string;
        int name;
        n.f(p, "parameter");
        StringBuilder stringBuilder = new StringBuilder();
        string = e0.a[p.f().ordinal()];
        if (string != 1) {
            if (string != 2) {
                if (string != 3) {
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("parameter #");
                    stringBuilder2.append(p.getIndex());
                    stringBuilder2.append(' ');
                    stringBuilder2.append(p.getName());
                    stringBuilder.append(stringBuilder2.toString());
                }
            } else {
                stringBuilder.append("instance parameter");
            }
        } else {
            stringBuilder.append("extension receiver parameter");
        }
        stringBuilder.append(" of ");
        stringBuilder.append(f0.b.c(p.j().y()));
        String obj4 = stringBuilder.toString();
        n.e(obj4, "StringBuilder().apply(builderAction).toString()");
        return obj4;
    }

    public final String g(o0 o0) {
        String str;
        n.f(o0, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        str = o0.j0() ? "var " : "val ";
        stringBuilder.append(str);
        kotlin.i0.z.e.f0 f0Var = f0.b;
        f0Var.b(stringBuilder, o0);
        final kotlin.i0.z.e.m0.f.e name = o0.getName();
        n.e(name, "descriptor.name");
        stringBuilder.append(f0.a.w(name, true));
        stringBuilder.append(": ");
        b0 obj6 = o0.getType();
        n.e(obj6, "descriptor.type");
        stringBuilder.append(f0Var.h(obj6));
        obj6 = stringBuilder.toString();
        n.e(obj6, "StringBuilder().apply(builderAction).toString()");
        return obj6;
    }

    public final String h(b0 b0) {
        n.f(b0, "type");
        return f0.a.x(b0);
    }
}
