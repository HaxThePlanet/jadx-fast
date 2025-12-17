package kotlin.i0.z.e;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.x;
import kotlin.i0.z.e.m0.d.b.i;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.a.c;
import kotlin.i0.z.e.m0.e.a0.a.d;
import kotlin.i0.z.e.m0.e.a0.b.e.a;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.f;
import kotlin.i0.z.e.m0.j.b.d0.d;
import kotlin.i0.z.e.m0.j.b.d0.j;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* loaded from: classes3.dex */
public abstract class e {

    public static final class a extends kotlin.i0.z.e.e {

        private final Field a;
        public a(Field field) {
            n.f(field, "field");
            super(0);
            this.a = field;
        }

        @Override // kotlin.i0.z.e.e
        public String a() {
            StringBuilder stringBuilder = new StringBuilder();
            String name = this.a.getName();
            n.e(name, "field.name");
            stringBuilder.append(x.a(name));
            stringBuilder.append("()");
            Class type = this.a.getType();
            n.e(type, "field.type");
            stringBuilder.append(b.c(type));
            return stringBuilder.toString();
        }

        @Override // kotlin.i0.z.e.e
        public final Field b() {
            return this.a;
        }
    }

    public static final class b extends kotlin.i0.z.e.e {

        private final Method a;
        private final Method b;
        public b(Method method, Method method2) {
            n.f(method, "getterMethod");
            super(0);
            this.a = method;
            this.b = method2;
        }

        @Override // kotlin.i0.z.e.e
        public String a() {
            return h0.a(this.a);
        }

        @Override // kotlin.i0.z.e.e
        public final Method b() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.e
        public final Method c() {
            return this.b;
        }
    }

    public static final class c extends kotlin.i0.z.e.e {

        private final String a;
        private final o0 b;
        private final n c;
        private final a.d d;
        private final c e;
        private final g f;
        public c(o0 o0, n n2, a.d a$d3, c c4, g g5) {
            boolean z;
            Object obj2;
            Object obj;
            Object obj3;
            int i2;
            int i;
            int i3;
            String obj8;
            String obj9;
            Object obj10;
            Object obj12;
            n.f(o0, "descriptor");
            n.f(n2, "proto");
            n.f(d3, "signature");
            n.f(c4, "nameResolver");
            n.f(g5, "typeTable");
            super(0);
            this.b = o0;
            this.c = n2;
            this.d = d3;
            this.e = c4;
            this.f = g5;
            if (d3.x()) {
                obj8 = new StringBuilder();
                obj9 = d3.t();
                obj12 = "signature.getter";
                n.e(obj9, obj12);
                obj8.append(c4.getString(obj9.r()));
                obj9 = d3.t();
                n.e(obj9, obj12);
                obj8.append(c4.getString(obj9.q()));
                obj8 = obj8.toString();
                this.a = obj8;
            } else {
                obj9 = h.d(h.a, n2, c4, g5, false, 8, 0);
                if (obj9 == null) {
                } else {
                    obj10 = new StringBuilder();
                    obj10.append(x.a(obj9.d()));
                    obj10.append(c());
                    obj10.append("()");
                    obj10.append(obj9.e());
                    obj8 = obj10.toString();
                }
            }
            obj10 = new StringBuilder();
            obj10.append("No field signature for property: ");
            obj10.append(o0);
            obj9 = new a0(obj10.toString());
            throw obj9;
        }

        private final String c() {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVar;
            String string;
            boolean z;
            boolean z2;
            Object fVar;
            mVar = this.b.b();
            n.e(mVar, "descriptor.containingDeclaration");
            String str6 = "$";
            if (n.b(this.b.getVisibility(), t.d) && mVar instanceof d) {
                if (mVar instanceof d) {
                    fVar = a.i;
                    n.e(fVar, "JvmProtoBuf.classModuleName");
                    string = e.a((d)mVar.W0(), fVar);
                    if (string != null && this.e.getString((Integer)string.intValue()) != null) {
                        if (this.e.getString(string.intValue()) != null) {
                        } else {
                            string = "main";
                        }
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str6);
                    stringBuilder2.append(f.a(string));
                    return stringBuilder2.toString();
                }
            }
            o0 o0Var2 = this.b;
            Objects.requireNonNull(o0Var2, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            mVar = (j)o0Var2.c0();
            if (n.b(this.b.getVisibility(), t.a) && mVar instanceof f0 && mVar instanceof i && (i)mVar.e() != null) {
                if (mVar instanceof f0) {
                    o0Var2 = this.b;
                    Objects.requireNonNull(o0Var2, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    mVar = (j)o0Var2.c0();
                    if (mVar instanceof i) {
                        if ((i)mVar.e() != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str6);
                            stringBuilder.append(mVar.g().c());
                            return stringBuilder.toString();
                        }
                    }
                }
            }
            return "";
        }

        @Override // kotlin.i0.z.e.e
        public String a() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.e
        public final o0 b() {
            return this.b;
        }

        @Override // kotlin.i0.z.e.e
        public final c d() {
            return this.e;
        }

        @Override // kotlin.i0.z.e.e
        public final n e() {
            return this.c;
        }

        @Override // kotlin.i0.z.e.e
        public final a.d f() {
            return this.d;
        }

        @Override // kotlin.i0.z.e.e
        public final g g() {
            return this.f;
        }
    }

    public static final class d extends kotlin.i0.z.e.e {

        private final kotlin.i0.z.e.d.e a;
        private final kotlin.i0.z.e.d.e b;
        public d(kotlin.i0.z.e.d.e d$e, kotlin.i0.z.e.d.e d$e2) {
            n.f(e, "getterSignature");
            super(0);
            this.a = e;
            this.b = e2;
        }

        @Override // kotlin.i0.z.e.e
        public String a() {
            return this.a.a();
        }

        @Override // kotlin.i0.z.e.e
        public final kotlin.i0.z.e.d.e b() {
            return this.a;
        }

        @Override // kotlin.i0.z.e.e
        public final kotlin.i0.z.e.d.e c() {
            return this.b;
        }
    }
    public e(g g) {
        super();
    }

    public abstract String a();
}
