package kotlin.i0.z.e.m0.e;

import android.app.ActivityManager.MemoryInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a.a;
import kotlin.reflect.jvm.internal.impl.protobuf.b;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.d.b;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.h.b;
import kotlin.reflect.jvm.internal.impl.protobuf.h.c;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.b;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes3.dex */
public final class c extends h.d<kotlin.i0.z.e.m0.e.c> implements p {

    private static final kotlin.i0.z.e.m0.e.c a;
    public static q<kotlin.i0.z.e.m0.e.c> b;
    private int bitField0_;
    private int companionObjectName_;
    private List<kotlin.i0.z.e.m0.e.d> constructor_;
    private List<kotlin.i0.z.e.m0.e.g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<kotlin.i0.z.e.m0.e.i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<kotlin.i0.z.e.m0.e.n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<kotlin.i0.z.e.m0.e.q> supertype_;
    private List<kotlin.i0.z.e.m0.e.r> typeAlias_;
    private List<kotlin.i0.z.e.m0.e.s> typeParameter_;
    private kotlin.i0.z.e.m0.e.t typeTable_;
    private final d unknownFields;
    private kotlin.i0.z.e.m0.e.w versionRequirementTable_;
    private List<Integer> versionRequirement_;

    public static enum c implements i.a {

        CLASS(false, false),
        INTERFACE(true, true),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);

        private final int value;
        public static kotlin.i0.z.e.m0.e.c.c valueOf(int i) {
            switch (i) {
                case 0:
                    return c.c.CLASS;
                case 1:
                    return c.c.INTERFACE;
                case 2:
                    return c.c.ENUM_CLASS;
                case 3:
                    return c.c.ENUM_ENTRY;
                case 4:
                    return c.c.ANNOTATION_CLASS;
                case 5:
                    return c.c.OBJECT;
                case 6:
                    return c.c.COMPANION_OBJECT;
                default:
                    return null;
            }
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    static class a extends b<kotlin.i0.z.e.m0.e.c> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.c m(e e, f f2) {
            c cVar = new c(e, f2, 0);
            return cVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.c, kotlin.i0.z.e.m0.e.c.b> implements p {

        private List<kotlin.i0.z.e.m0.e.q> A;
        private List<Integer> B;
        private List<Integer> C;
        private List<kotlin.i0.z.e.m0.e.d> D;
        private List<kotlin.i0.z.e.m0.e.i> E;
        private List<kotlin.i0.z.e.m0.e.n> F;
        private List<kotlin.i0.z.e.m0.e.r> G;
        private List<kotlin.i0.z.e.m0.e.g> H;
        private List<Integer> I;
        private kotlin.i0.z.e.m0.e.t J;
        private List<Integer> K;
        private kotlin.i0.z.e.m0.e.w L;
        private int v;
        private int w = 6;
        private int x;
        private int y;
        private List<kotlin.i0.z.e.m0.e.s> z;
        private b() {
            super();
            int i = 6;
            this.z = Collections.emptyList();
            this.A = Collections.emptyList();
            this.B = Collections.emptyList();
            this.C = Collections.emptyList();
            this.D = Collections.emptyList();
            this.E = Collections.emptyList();
            this.F = Collections.emptyList();
            this.G = Collections.emptyList();
            this.H = Collections.emptyList();
            this.I = Collections.emptyList();
            this.J = t.q();
            this.K = Collections.emptyList();
            this.L = w.o();
            D();
        }

        private void A() {
            int i;
            List list;
            final int i4 = 1024;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.G);
                this.G = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void B() {
            int i;
            List list;
            final int i4 = 8;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.z);
                this.z = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void C() {
            int i;
            List list;
            final int i4 = 16384;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.K);
                this.K = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void D() {
        }

        static kotlin.i0.z.e.m0.e.c.b m() {
            return c.b.r();
        }

        private static kotlin.i0.z.e.m0.e.c.b r() {
            c.b bVar = new c.b();
            return bVar;
        }

        private void s() {
            int i;
            List list;
            final int i4 = 128;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.D);
                this.D = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void t() {
            int i;
            List list;
            final int i4 = 2048;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.H);
                this.H = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void u() {
            int i;
            List list;
            final int i4 = 256;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.E);
                this.E = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void v() {
            int i;
            List list;
            final int i4 = 64;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.C);
                this.C = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void w() {
            int i;
            List list;
            final int i4 = 512;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.F);
                this.F = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void x() {
            int i;
            List list;
            final int i4 = 4096;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.I);
                this.I = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void y() {
            int i;
            List list;
            final int i4 = 32;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.B);
                this.B = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void z() {
            int i;
            List list;
            final int i4 = 16;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.A);
                this.A = arrayList;
                this.v = i3 |= i4;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b E(kotlin.i0.z.e.m0.e.c c) {
            boolean z5;
            boolean z4;
            boolean z;
            boolean empty10;
            boolean empty2;
            boolean empty9;
            boolean empty8;
            boolean empty7;
            boolean empty4;
            boolean empty5;
            boolean empty3;
            boolean empty;
            boolean empty11;
            boolean z2;
            boolean empty6;
            boolean z3;
            List list;
            if (c == c.b0()) {
                return this;
            }
            if (c.F0()) {
                J(c.g0());
            }
            if (c.G0()) {
                K(c.h0());
            }
            if (c.E0()) {
                I(c.X());
            }
            if (!c.H(c).isEmpty()) {
                if (this.z.isEmpty()) {
                    this.z = c.H(c);
                    this.v = i11 &= -9;
                } else {
                    B();
                    this.z.addAll(c.H(c));
                }
            }
            if (!c.J(c).isEmpty()) {
                if (this.A.isEmpty()) {
                    this.A = c.J(c);
                    this.v = i10 &= -17;
                } else {
                    z();
                    this.A.addAll(c.J(c));
                }
            }
            if (!c.L(c).isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = c.L(c);
                    this.v = i &= -33;
                } else {
                    y();
                    this.B.addAll(c.L(c));
                }
            }
            if (!c.N(c).isEmpty()) {
                if (this.C.isEmpty()) {
                    this.C = c.N(c);
                    this.v = i9 &= -65;
                } else {
                    v();
                    this.C.addAll(c.N(c));
                }
            }
            if (!c.P(c).isEmpty()) {
                if (this.D.isEmpty()) {
                    this.D = c.P(c);
                    this.v = i2 &= -129;
                } else {
                    s();
                    this.D.addAll(c.P(c));
                }
            }
            if (!c.R(c).isEmpty()) {
                if (this.E.isEmpty()) {
                    this.E = c.R(c);
                    this.v = i3 &= -257;
                } else {
                    u();
                    this.E.addAll(c.R(c));
                }
            }
            if (!c.T(c).isEmpty()) {
                if (this.F.isEmpty()) {
                    this.F = c.T(c);
                    this.v = i8 &= -513;
                } else {
                    w();
                    this.F.addAll(c.T(c));
                }
            }
            if (!c.V(c).isEmpty()) {
                if (this.G.isEmpty()) {
                    this.G = c.V(c);
                    this.v = i4 &= -1025;
                } else {
                    A();
                    this.G.addAll(c.V(c));
                }
            }
            if (!c.u(c).isEmpty()) {
                if (this.H.isEmpty()) {
                    this.H = c.u(c);
                    this.v = i7 &= -2049;
                } else {
                    t();
                    this.H.addAll(c.u(c));
                }
            }
            if (!c.w(c).isEmpty()) {
                if (this.I.isEmpty()) {
                    this.I = c.w(c);
                    this.v = i6 &= -4097;
                } else {
                    x();
                    this.I.addAll(c.w(c));
                }
            }
            if (c.H0()) {
                G(c.B0());
            }
            if (!c.z(c).isEmpty()) {
                if (this.K.isEmpty()) {
                    this.K = c.z(c);
                    this.v = i5 &= -16385;
                } else {
                    C();
                    this.K.addAll(c.z(c));
                }
            }
            if (c.I0()) {
                H(c.D0());
            }
            l(c);
            g(e().d(c.D(c)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b F(e e, f f2) {
            final int i = 0;
            final Object obj3 = c.b.b(e, f2);
            if ((c)obj3 != null) {
                try {
                    E((c)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    E(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b G(kotlin.i0.z.e.m0.e.t t) {
            int i;
            kotlin.i0.z.e.m0.e.t tVar;
            kotlin.i0.z.e.m0.e.t obj4;
            final int i3 = 8192;
            if (i2 &= i3 == i3 && this.J != t.q()) {
                if (this.J != t.q()) {
                    i = t.y(this.J);
                    i.p(t);
                    this.J = i.k();
                } else {
                    this.J = t;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b H(kotlin.i0.z.e.m0.e.w w) {
            int i;
            kotlin.i0.z.e.m0.e.w wVar;
            kotlin.i0.z.e.m0.e.w obj4;
            final int i3 = 32768;
            if (i2 &= i3 == i3 && this.L != w.o()) {
                if (this.L != w.o()) {
                    i = w.t(this.L);
                    i.p(w);
                    this.L = i.k();
                } else {
                    this.L = w;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b I(int i) {
            this.v = i2 |= 4;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b J(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b K(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            F(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o build() {
            return n();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public Object clone() {
            return p();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public h.b d() {
            return p();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public h.b f(h h) {
            E((c)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            F(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c n() {
            kotlin.i0.z.e.m0.e.c cVar = o();
            if (!cVar.isInitialized()) {
            } else {
                return cVar;
            }
            throw a.a.c(cVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c o() {
            int i5;
            int i9;
            int i2;
            int i4;
            int i11;
            int i10;
            int i;
            int i12;
            int i3;
            int i7;
            int i6;
            int i8;
            c cVar = new c(this, 0);
            int i14 = this.v;
            if (i14 & 1 == 1) {
            } else {
                i8 = 0;
            }
            c.E(cVar, this.w);
            if (i14 & 2 == 2) {
                i8 |= 2;
            }
            c.F(cVar, this.x);
            if (i14 & 4 == 4) {
                i8 |= 4;
            }
            c.G(cVar, this.y);
            int i48 = 8;
            if (i22 &= i48 == i48) {
                this.z = Collections.unmodifiableList(this.z);
                this.v = i45 &= -9;
            }
            c.I(cVar, this.z);
            int i49 = 16;
            if (i23 &= i49 == i49) {
                this.A = Collections.unmodifiableList(this.A);
                this.v = i44 &= -17;
            }
            c.K(cVar, this.A);
            int i50 = 32;
            if (i24 &= i50 == i50) {
                this.B = Collections.unmodifiableList(this.B);
                this.v = i25 &= -33;
            }
            c.M(cVar, this.B);
            int i51 = 64;
            if (i26 &= i51 == i51) {
                this.C = Collections.unmodifiableList(this.C);
                this.v = i43 &= -65;
            }
            c.O(cVar, this.C);
            int i52 = 128;
            if (i27 &= i52 == i52) {
                this.D = Collections.unmodifiableList(this.D);
                this.v = i42 &= -129;
            }
            c.Q(cVar, this.D);
            int i53 = 256;
            if (i28 &= i53 == i53) {
                this.E = Collections.unmodifiableList(this.E);
                this.v = i29 &= -257;
            }
            c.S(cVar, this.E);
            int i54 = 512;
            if (i30 &= i54 == i54) {
                this.F = Collections.unmodifiableList(this.F);
                this.v = i41 &= -513;
            }
            c.U(cVar, this.F);
            int i55 = 1024;
            if (i31 &= i55 == i55) {
                this.G = Collections.unmodifiableList(this.G);
                this.v = i32 &= -1025;
            }
            c.W(cVar, this.G);
            int i56 = 2048;
            if (i33 &= i56 == i56) {
                this.H = Collections.unmodifiableList(this.H);
                this.v = i40 &= -2049;
            }
            c.v(cVar, this.H);
            int i57 = 4096;
            if (i34 &= i57 == i57) {
                this.I = Collections.unmodifiableList(this.I);
                this.v = i39 &= -4097;
            }
            c.x(cVar, this.I);
            if (i14 & 8192 == 8192) {
                i8 |= 8;
            }
            c.y(cVar, this.J);
            int i59 = 16384;
            if (i36 &= i59 == i59) {
                this.K = Collections.unmodifiableList(this.K);
                this.v = i38 &= -16385;
            }
            c.A(cVar, this.K);
            int i37 = 32768;
            if (i14 &= i37 == i37) {
                i8 |= 16;
            }
            c.B(cVar, this.L);
            c.C(cVar, i8);
            return cVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.c.b p() {
            final kotlin.i0.z.e.m0.e.c.b bVar = c.b.r();
            bVar.E(o());
            return bVar;
        }
    }
    static {
        c.a aVar = new c.a();
        c.b = aVar;
        c cVar = new c(1);
        c.a = cVar;
        cVar.J0();
    }

    private c(e e, f f2) {
        int unmodifiableList9;
        int unmodifiableList3;
        int unmodifiableList2;
        int unmodifiableList11;
        int unmodifiableList5;
        int unmodifiableList8;
        int unmodifiableList6;
        int unmodifiableList10;
        int unmodifiableList;
        int unmodifiableList4;
        int unmodifiableList7;
        o oVar;
        InvalidProtocolBufferException exc;
        int i4;
        int i6;
        int arrayList3;
        int arrayList9;
        int typeTable_;
        int i3;
        int arrayList10;
        List sealedSubclassFqName_2;
        int arrayList7;
        int arrayList5;
        int arrayList11;
        int arrayList2;
        int arrayList8;
        int arrayList6;
        int arrayList;
        int arrayList4;
        int i2;
        int i5;
        InvalidProtocolBufferException exc2;
        InvalidProtocolBufferException exc3;
        InvalidProtocolBufferException exc4;
        o valueOf2;
        int sealedSubclassFqName_;
        o oVar2;
        int nestedClassName_;
        int supertypeId_;
        int valueOf;
        int versionRequirementTable_;
        int versionRequirement_;
        InvalidProtocolBufferException exc7;
        InvalidProtocolBufferException exc5;
        InvalidProtocolBufferException exc6;
        int i;
        final Object obj = this;
        e eVar = e;
        f fVar = f2;
        super();
        int i12 = -1;
        obj.supertypeIdMemoizedSerializedSize = i12;
        obj.nestedClassNameMemoizedSerializedSize = i12;
        obj.sealedSubclassFqNameMemoizedSerializedSize = i12;
        obj.memoizedIsInitialized = i12;
        obj.memoizedSerializedSize = i12;
        J0();
        d.b bVar = d.w();
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, 1);
        i5 = i2;
        exc2 = 2048;
        exc3 = 1024;
        exc4 = 512;
        exc7 = 16384;
        exc5 = 4096;
        sealedSubclassFqName_2 = 16;
        exc6 = 8;
        while (i2 == 0) {
            valueOf = e.K();
            i = 0;
            valueOf2 = 1;
            if (!obj.j(eVar, outputStream, fVar, valueOf)) {
            }
            i6 = valueOf2;
            exc2 = 2048;
            exc3 = 1024;
            exc4 = 512;
            exc7 = 16384;
            exc5 = 4096;
            sealedSubclassFqName_2 = 16;
            exc6 = 8;
            i2 = valueOf2;
            if (bitField0_7 &= sealedSubclassFqName_2 == sealedSubclassFqName_2) {
            }
            valueOf = i;
            oVar2 = eVar.u(w.b, fVar);
            obj.versionRequirementTable_ = (w)oVar2;
            if (valueOf != 0) {
            }
            obj.bitField0_ = bitField0_6 |= sealedSubclassFqName_2;
            valueOf2 = 1;
            valueOf.p(oVar2);
            obj.versionRequirementTable_ = valueOf.k();
            i = obj.versionRequirementTable_.v();
            if (i5 & 16384 != exc7 && e.e() > 0) {
            }
            while (e.e() > 0) {
                obj.versionRequirement_.add(Integer.valueOf(e.s()));
                sealedSubclassFqName_2 = 16;
            }
            eVar.i(eVar.j(e.A()));
            obj.versionRequirement_.add(Integer.valueOf(e.s()));
            sealedSubclassFqName_2 = 16;
            if (e.e() > 0) {
            }
            versionRequirement_ = new ArrayList();
            obj.versionRequirement_ = versionRequirement_;
            i5 |= 16384;
            if (i5 & 16384 != exc7) {
            }
            obj.versionRequirement_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            obj.versionRequirement_ = arrayList2;
            i5 |= 16384;
            if (bitField0_ &= exc6 == exc6) {
            }
            i3 = i;
            valueOf2 = eVar.u(t.b, fVar);
            obj.typeTable_ = (t)valueOf2;
            if (i3 != 0) {
            }
            obj.bitField0_ = bitField0_2 |= exc6;
            i3.p(valueOf2);
            obj.typeTable_ = i3.k();
            i = obj.typeTable_.A();
            if (i5 & 4096 != exc5 && e.e() > 0) {
            }
            while (e.e() > 0) {
                obj.sealedSubclassFqName_.add(Integer.valueOf(e.s()));
            }
            eVar.i(eVar.j(e.A()));
            obj.sealedSubclassFqName_.add(Integer.valueOf(e.s()));
            if (e.e() > 0) {
            }
            sealedSubclassFqName_ = new ArrayList();
            obj.sealedSubclassFqName_ = sealedSubclassFqName_;
            i5 |= 4096;
            if (i5 & 4096 != exc5) {
            }
            obj.sealedSubclassFqName_.add(Integer.valueOf(e.s()));
            arrayList10 = new ArrayList();
            obj.sealedSubclassFqName_ = arrayList10;
            i5 |= 4096;
            if (i5 & 2048 != exc2) {
            }
            obj.enumEntry_.add(eVar.u(g.b, fVar));
            arrayList = new ArrayList();
            obj.enumEntry_ = arrayList;
            i5 |= 2048;
            if (i5 & 1024 != exc3) {
            }
            obj.typeAlias_.add(eVar.u(r.b, fVar));
            arrayList7 = new ArrayList();
            obj.typeAlias_ = arrayList7;
            i5 |= 1024;
            if (i5 & 512 != exc4) {
            }
            obj.property_.add(eVar.u(n.b, fVar));
            arrayList4 = new ArrayList();
            obj.property_ = arrayList4;
            i5 |= 512;
            if (i5 & 256 != 256) {
            }
            obj.function_.add(eVar.u(i.b, fVar));
            arrayList5 = new ArrayList();
            obj.function_ = arrayList5;
            i5 |= 256;
            if (i5 & 128 != 128) {
            }
            obj.constructor_.add(eVar.u(d.b, fVar));
            arrayList3 = new ArrayList();
            obj.constructor_ = arrayList3;
            i5 |= 128;
            if (i5 & 64 != 64 && e.e() > 0) {
            }
            while (e.e() > 0) {
                obj.nestedClassName_.add(Integer.valueOf(e.s()));
            }
            eVar.i(eVar.j(e.A()));
            obj.nestedClassName_.add(Integer.valueOf(e.s()));
            if (e.e() > 0) {
            }
            nestedClassName_ = new ArrayList();
            obj.nestedClassName_ = nestedClassName_;
            i5 |= 64;
            if (i5 & 64 != 64) {
            }
            obj.nestedClassName_.add(Integer.valueOf(e.s()));
            arrayList11 = new ArrayList();
            obj.nestedClassName_ = arrayList11;
            i5 |= 64;
            if (i5 & 16 != 16) {
            }
            obj.supertype_.add(eVar.u(q.b, fVar));
            arrayList9 = new ArrayList();
            obj.supertype_ = arrayList9;
            i5 |= 16;
            if (i5 & 8 != exc6) {
            }
            obj.typeParameter_.add(eVar.u(s.b, fVar));
            arrayList8 = new ArrayList();
            obj.typeParameter_ = arrayList8;
            i5 |= 8;
            obj.bitField0_ = bitField0_3 |= 4;
            obj.companionObjectName_ = e.s();
            obj.bitField0_ = bitField0_5 |= 2;
            obj.fqName_ = e.s();
            if (i5 & 32 != 32 && e.e() > 0) {
            }
            while (e.e() > 0) {
                obj.supertypeId_.add(Integer.valueOf(e.s()));
            }
            eVar.i(eVar.j(e.A()));
            obj.supertypeId_.add(Integer.valueOf(e.s()));
            if (e.e() > 0) {
            }
            supertypeId_ = new ArrayList();
            obj.supertypeId_ = supertypeId_;
            i5 |= 32;
            if (i5 & 32 != 32) {
            }
            obj.supertypeId_.add(Integer.valueOf(e.s()));
            arrayList6 = new ArrayList();
            obj.supertypeId_ = arrayList6;
            i5 |= 32;
            obj.bitField0_ = bitField0_4 |= valueOf2;
            obj.flags_ = e.s();
            valueOf2 = 1;
        }
        if (i5 & 32 == 32) {
            obj.supertypeId_ = Collections.unmodifiableList(obj.supertypeId_);
        }
        if (i5 & 8 == exc6) {
            obj.typeParameter_ = Collections.unmodifiableList(obj.typeParameter_);
        }
        if (i5 & 16 == 16) {
            obj.supertype_ = Collections.unmodifiableList(obj.supertype_);
        }
        if (i5 & 64 == 64) {
            obj.nestedClassName_ = Collections.unmodifiableList(obj.nestedClassName_);
        }
        if (i5 & 128 == 128) {
            obj.constructor_ = Collections.unmodifiableList(obj.constructor_);
        }
        if (i5 & 256 == 256) {
            obj.function_ = Collections.unmodifiableList(obj.function_);
        }
        if (i5 & 512 == exc4) {
            obj.property_ = Collections.unmodifiableList(obj.property_);
        }
        if (i5 & 1024 == exc3) {
            obj.typeAlias_ = Collections.unmodifiableList(obj.typeAlias_);
        }
        if (i5 & 2048 == exc2) {
            obj.enumEntry_ = Collections.unmodifiableList(obj.enumEntry_);
        }
        if (i5 & 4096 == exc5) {
            obj.sealedSubclassFqName_ = Collections.unmodifiableList(obj.sealedSubclassFqName_);
        }
        if (i5 & 16384 == exc7) {
            obj.versionRequirement_ = Collections.unmodifiableList(obj.versionRequirement_);
        }
        outputStream.I();
        obj.unknownFields = bVar.i();
        g();
    }

    c(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private c(h.c<kotlin.i0.z.e.m0.e.c, ?> h$c) {
        super(c);
        final int i = -1;
        this.supertypeIdMemoizedSerializedSize = i;
        this.nestedClassNameMemoizedSerializedSize = i;
        this.sealedSubclassFqNameMemoizedSerializedSize = i;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    c(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private c(boolean z) {
        super();
        int obj1 = -1;
        this.supertypeIdMemoizedSerializedSize = obj1;
        this.nestedClassNameMemoizedSerializedSize = obj1;
        this.sealedSubclassFqNameMemoizedSerializedSize = obj1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List A(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.versionRequirement_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.w B(kotlin.i0.z.e.m0.e.c c, kotlin.i0.z.e.m0.e.w w2) {
        c.versionRequirementTable_ = w2;
        return w2;
    }

    static int C(kotlin.i0.z.e.m0.e.c c, int i2) {
        c.bitField0_ = i2;
        return i2;
    }

    static d D(kotlin.i0.z.e.m0.e.c c) {
        return c.unknownFields;
    }

    static int E(kotlin.i0.z.e.m0.e.c c, int i2) {
        c.flags_ = i2;
        return i2;
    }

    static int F(kotlin.i0.z.e.m0.e.c c, int i2) {
        c.fqName_ = i2;
        return i2;
    }

    static int G(kotlin.i0.z.e.m0.e.c c, int i2) {
        c.companionObjectName_ = i2;
        return i2;
    }

    static List H(kotlin.i0.z.e.m0.e.c c) {
        return c.typeParameter_;
    }

    static List I(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.typeParameter_ = list2;
        return list2;
    }

    static List J(kotlin.i0.z.e.m0.e.c c) {
        return c.supertype_;
    }

    private void J0() {
        this.flags_ = 6;
        int i2 = 0;
        this.fqName_ = i2;
        this.companionObjectName_ = i2;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = t.q();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = w.o();
    }

    static List K(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.supertype_ = list2;
        return list2;
    }

    public static kotlin.i0.z.e.m0.e.c.b K0() {
        return c.b.m();
    }

    static List L(kotlin.i0.z.e.m0.e.c c) {
        return c.supertypeId_;
    }

    public static kotlin.i0.z.e.m0.e.c.b L0(kotlin.i0.z.e.m0.e.c c) {
        final kotlin.i0.z.e.m0.e.c.b bVar = c.K0();
        bVar.E(c);
        return bVar;
    }

    static List M(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.supertypeId_ = list2;
        return list2;
    }

    static List N(kotlin.i0.z.e.m0.e.c c) {
        return c.nestedClassName_;
    }

    public static kotlin.i0.z.e.m0.e.c N0(InputStream inputStream, f f2) {
        return (c)c.b.a(inputStream, f2);
    }

    static List O(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.nestedClassName_ = list2;
        return list2;
    }

    static List P(kotlin.i0.z.e.m0.e.c c) {
        return c.constructor_;
    }

    static List Q(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.constructor_ = list2;
        return list2;
    }

    static List R(kotlin.i0.z.e.m0.e.c c) {
        return c.function_;
    }

    static List S(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.function_ = list2;
        return list2;
    }

    static List T(kotlin.i0.z.e.m0.e.c c) {
        return c.property_;
    }

    static List U(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.property_ = list2;
        return list2;
    }

    static List V(kotlin.i0.z.e.m0.e.c c) {
        return c.typeAlias_;
    }

    static List W(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.typeAlias_ = list2;
        return list2;
    }

    public static kotlin.i0.z.e.m0.e.c b0() {
        return c.a;
    }

    static List u(kotlin.i0.z.e.m0.e.c c) {
        return c.enumEntry_;
    }

    static List v(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.enumEntry_ = list2;
        return list2;
    }

    static List w(kotlin.i0.z.e.m0.e.c c) {
        return c.sealedSubclassFqName_;
    }

    static List x(kotlin.i0.z.e.m0.e.c c, List list2) {
        c.sealedSubclassFqName_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.t y(kotlin.i0.z.e.m0.e.c c, kotlin.i0.z.e.m0.e.t t2) {
        c.typeTable_ = t2;
        return t2;
    }

    static List z(kotlin.i0.z.e.m0.e.c c) {
        return c.versionRequirement_;
    }

    public List<kotlin.i0.z.e.m0.e.s> A0() {
        return this.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.t B0() {
        return this.typeTable_;
    }

    public List<Integer> C0() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.w D0() {
        return this.versionRequirementTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean E0() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean F0() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean G0() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean H0() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean I0() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.c.b M0() {
        return c.K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.c.b O0() {
        return c.L0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int X() {
        return this.companionObjectName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.d Y(int i) {
        return (d)this.constructor_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int Z() {
        return this.constructor_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int supertypeIdMemoizedSerializedSize;
        int i4;
        int i8;
        int i11;
        int i2;
        int companionObjectName_;
        int i3;
        int i15;
        int nestedClassNameMemoizedSerializedSize;
        int i12;
        int i10;
        int i7;
        int i5;
        int i9;
        int i14;
        int sealedSubclassFqNameMemoizedSerializedSize;
        int i13;
        int i;
        int versionRequirementTable_;
        int intValue;
        int fqName_;
        int i6;
        int size;
        int intValue3;
        int size6;
        int size5;
        int size2;
        int size3;
        int size4;
        int intValue2;
        int typeTable_;
        Object obj;
        Object obj2;
        getSerializedSize();
        int i18 = 1;
        if (bitField0_ &= i18 == i18) {
            codedOutputStream.a0(i18, this.flags_);
        }
        if (t0().size() > 0) {
            codedOutputStream.o0(18);
            codedOutputStream.o0(this.supertypeIdMemoizedSerializedSize);
        }
        i4 = 0;
        i11 = i4;
        while (i11 < this.supertypeId_.size()) {
            codedOutputStream.b0((Integer)this.supertypeId_.get(i11).intValue());
            i11++;
        }
        fqName_ = 2;
        if (bitField0_3 &= fqName_ == fqName_) {
            codedOutputStream.a0(3, this.fqName_);
        }
        i6 = 4;
        if (bitField0_4 &= i6 == i6) {
            codedOutputStream.a0(i6, this.companionObjectName_);
        }
        i3 = i4;
        while (i3 < this.typeParameter_.size()) {
            codedOutputStream.d0(5, (o)this.typeParameter_.get(i3));
            i3++;
        }
        i15 = i4;
        while (i15 < this.supertype_.size()) {
            codedOutputStream.d0(6, (o)this.supertype_.get(i15));
            i15++;
        }
        if (m0().size() > 0) {
            codedOutputStream.o0(58);
            codedOutputStream.o0(this.nestedClassNameMemoizedSerializedSize);
        }
        i12 = i4;
        while (i12 < this.nestedClassName_.size()) {
            codedOutputStream.b0((Integer)this.nestedClassName_.get(i12).intValue());
            i12++;
        }
        i10 = i4;
        obj = 8;
        while (i10 < this.constructor_.size()) {
            codedOutputStream.d0(obj, (o)this.constructor_.get(i10));
            i10++;
            obj = 8;
        }
        i7 = i4;
        while (i7 < this.function_.size()) {
            codedOutputStream.d0(9, (o)this.function_.get(i7));
            i7++;
        }
        i5 = i4;
        while (i5 < this.property_.size()) {
            codedOutputStream.d0(10, (o)this.property_.get(i5));
            i5++;
        }
        i9 = i4;
        while (i9 < this.typeAlias_.size()) {
            codedOutputStream.d0(11, (o)this.typeAlias_.get(i9));
            i9++;
        }
        i14 = i4;
        while (i14 < this.enumEntry_.size()) {
            codedOutputStream.d0(13, (o)this.enumEntry_.get(i14));
            i14++;
        }
        if (q0().size() > 0) {
            codedOutputStream.o0(130);
            codedOutputStream.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        i13 = i4;
        while (i13 < this.sealedSubclassFqName_.size()) {
            codedOutputStream.b0((Integer)this.sealedSubclassFqName_.get(i13).intValue());
            i13++;
        }
        if (bitField0_5 &= obj == obj) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        while (i4 < this.versionRequirement_.size()) {
            codedOutputStream.a0(31, (Integer)this.versionRequirement_.get(i4).intValue());
            i4++;
        }
        versionRequirementTable_ = 16;
        if (bitField0_2 &= versionRequirementTable_ == versionRequirementTable_) {
            codedOutputStream.d0(32, this.versionRequirementTable_);
        }
        s().a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public List<kotlin.i0.z.e.m0.e.d> a0() {
        return this.constructor_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.c c0() {
        return c.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.g d0(int i) {
        return (g)this.enumEntry_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int e0() {
        return this.enumEntry_.size();
    }

    public List<kotlin.i0.z.e.m0.e.g> f0() {
        return this.enumEntry_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int g0() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return c0();
    }

    public q<kotlin.i0.z.e.m0.e.c> getParserForType() {
        return c.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i4;
        int i18;
        int i23;
        int i13;
        int i25;
        int i14;
        boolean empty;
        int i11;
        int i5;
        int i16;
        int i9;
        int i22;
        boolean empty3;
        int i15;
        int i7;
        int i;
        int i12;
        int i24;
        int i3;
        boolean empty2;
        int i17;
        int i20;
        int i6;
        int i21;
        int versionRequirementTable_;
        int i8;
        int i19;
        int fqName_;
        int i2;
        int size6;
        int i10;
        int size;
        int size4;
        int size2;
        int size3;
        int typeTable_;
        Object obj;
        int size5;
        Object obj2;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i35 = 1;
        i21 = 0;
        if (bitField0_ &= i35 == i35) {
            i27 += i21;
        } else {
            i4 = i21;
        }
        i8 = i14;
        while (i14 < this.supertypeId_.size()) {
            i8 += i19;
            i14++;
        }
        if (!t0().isEmpty()) {
            i28 += empty;
        }
        this.supertypeIdMemoizedSerializedSize = i8;
        int i41 = 2;
        if (bitField0_2 &= i41 == i41) {
            i18 += i11;
        }
        i2 = 4;
        if (bitField0_3 &= i2 == i2) {
            i18 += i5;
        }
        i16 = i21;
        while (i16 < this.typeParameter_.size()) {
            i18 += i2;
            i16++;
        }
        i9 = i21;
        while (i9 < this.supertype_.size()) {
            i18 += size6;
            i9++;
        }
        i10 = i22;
        while (i22 < this.nestedClassName_.size()) {
            i10 += obj;
            i22++;
        }
        if (!m0().isEmpty()) {
            i33 += empty3;
        }
        this.nestedClassNameMemoizedSerializedSize = i10;
        i15 = i21;
        size5 = 8;
        while (i15 < this.constructor_.size()) {
            i23 += i10;
            i15++;
            size5 = 8;
        }
        i7 = i21;
        while (i7 < this.function_.size()) {
            i23 += size;
            i7++;
        }
        i = i21;
        while (i < this.property_.size()) {
            i23 += size4;
            i++;
        }
        i12 = i21;
        while (i12 < this.typeAlias_.size()) {
            i23 += size2;
            i12++;
        }
        i24 = i21;
        while (i24 < this.enumEntry_.size()) {
            i23 += size3;
            i24++;
        }
        typeTable_ = i3;
        while (i3 < this.sealedSubclassFqName_.size()) {
            typeTable_ += obj2;
            i3++;
        }
        if (!q0().isEmpty()) {
            i29 += empty2;
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = typeTable_;
        if (bitField0_4 &= size5 == size5) {
            i13 += i17;
        }
        i20 = i21;
        while (i21 < this.versionRequirement_.size()) {
            i20 += typeTable_;
            i21++;
        }
        versionRequirementTable_ = 16;
        if (bitField0_5 &= versionRequirementTable_ == versionRequirementTable_) {
            i25 += i6;
        }
        i31 += size8;
        this.memoizedSerializedSize = i32;
        return i32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int h0() {
        return this.fqName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.i i0(int i) {
        return (i)this.function_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        int i5;
        int i7;
        int i2;
        int i3;
        int i6;
        int i4;
        int i;
        boolean initialized;
        boolean initialized8;
        int initialized6;
        int initialized3;
        int initialized2;
        int initialized4;
        int initialized7;
        int initialized5;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i8 = 1;
        if (memoizedIsInitialized == i8) {
            return i8;
        }
        final int i9 = 0;
        if (memoizedIsInitialized == 0) {
            return i9;
        }
        if (!G0()) {
            this.memoizedIsInitialized = i9;
            return i9;
        }
        i5 = i9;
        while (i5 < z0()) {
            i5++;
        }
        i7 = i9;
        while (i7 < s0()) {
            i7++;
        }
        i2 = i9;
        while (i2 < Z()) {
            i2++;
        }
        i3 = i9;
        while (i3 < k0()) {
            i3++;
        }
        i6 = i9;
        while (i6 < o0()) {
            i6++;
        }
        i4 = i9;
        while (i4 < w0()) {
            i4++;
        }
        i = i9;
        while (i < e0()) {
            i++;
        }
        if (H0() && !B0().isInitialized()) {
            if (!B0().isInitialized()) {
                this.memoizedIsInitialized = i9;
                return i9;
            }
        }
        if (!m()) {
            this.memoizedIsInitialized = i9;
            return i9;
        }
        this.memoizedIsInitialized = i8;
        return i8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int k0() {
        return this.function_.size();
    }

    public List<kotlin.i0.z.e.m0.e.i> l0() {
        return this.function_;
    }

    public List<Integer> m0() {
        return this.nestedClassName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.n n0(int i) {
        return (n)this.property_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int o0() {
        return this.property_.size();
    }

    public List<kotlin.i0.z.e.m0.e.n> p0() {
        return this.property_;
    }

    public List<Integer> q0() {
        return this.sealedSubclassFqName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q r0(int i) {
        return (q)this.supertype_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int s0() {
        return this.supertype_.size();
    }

    public List<Integer> t0() {
        return this.supertypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return O0();
    }

    public List<kotlin.i0.z.e.m0.e.q> u0() {
        return this.supertype_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.r v0(int i) {
        return (r)this.typeAlias_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int w0() {
        return this.typeAlias_.size();
    }

    public List<kotlin.i0.z.e.m0.e.r> x0() {
        return this.typeAlias_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s y0(int i) {
        return (s)this.typeParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int z0() {
        return this.typeParameter_.size();
    }
}
