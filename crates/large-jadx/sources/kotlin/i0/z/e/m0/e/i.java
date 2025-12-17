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
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes3.dex */
public final class i extends h.d<kotlin.i0.z.e.m0.e.i> implements p {

    private static final kotlin.i0.z.e.m0.e.i a;
    public static q<kotlin.i0.z.e.m0.e.i> b;
    private int bitField0_;
    private kotlin.i0.z.e.m0.e.e contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private kotlin.i0.z.e.m0.e.q receiverType_;
    private int returnTypeId_;
    private kotlin.i0.z.e.m0.e.q returnType_;
    private List<kotlin.i0.z.e.m0.e.s> typeParameter_;
    private kotlin.i0.z.e.m0.e.t typeTable_;
    private final d unknownFields;
    private List<kotlin.i0.z.e.m0.e.u> valueParameter_;
    private List<Integer> versionRequirement_;

    static class a extends b<kotlin.i0.z.e.m0.e.i> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.i m(e e, f f2) {
            i iVar = new i(e, f2, 0);
            return iVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.i, kotlin.i0.z.e.m0.e.i.b> implements p {

        private int A;
        private List<kotlin.i0.z.e.m0.e.s> B;
        private kotlin.i0.z.e.m0.e.q C;
        private int D;
        private List<kotlin.i0.z.e.m0.e.u> E;
        private kotlin.i0.z.e.m0.e.t F;
        private List<Integer> G;
        private kotlin.i0.z.e.m0.e.e H;
        private int v;
        private int w = 6;
        private int x = 6;
        private int y;
        private kotlin.i0.z.e.m0.e.q z;
        private b() {
            super();
            int i = 6;
            this.z = q.R();
            this.B = Collections.emptyList();
            this.C = q.R();
            this.E = Collections.emptyList();
            this.F = t.q();
            this.G = Collections.emptyList();
            this.H = e.o();
            v();
        }

        static kotlin.i0.z.e.m0.e.i.b m() {
            return i.b.r();
        }

        private static kotlin.i0.z.e.m0.e.i.b r() {
            i.b bVar = new i.b();
            return bVar;
        }

        private void s() {
            int i;
            List list;
            final int i4 = 32;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.B);
                this.B = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void t() {
            int i;
            List list;
            final int i4 = 256;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.E);
                this.E = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void u() {
            int i;
            List list;
            final int i4 = 1024;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.G);
                this.G = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void v() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b A(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 8;
            if (i2 &= i3 == i3 && this.z != q.R()) {
                if (this.z != q.R()) {
                    this.z = q.t0(this.z).w(q).o();
                } else {
                    this.z = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b B(kotlin.i0.z.e.m0.e.t t) {
            int i;
            kotlin.i0.z.e.m0.e.t tVar;
            kotlin.i0.z.e.m0.e.t obj4;
            final int i3 = 512;
            if (i2 &= i3 == i3 && this.F != t.q()) {
                if (this.F != t.q()) {
                    i = t.y(this.F);
                    i.p(t);
                    this.F = i.k();
                } else {
                    this.F = t;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b C(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b D(int i) {
            this.v = i2 |= 4;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b E(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b F(int i) {
            this.v = i2 |= 128;
            this.D = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b G(int i) {
            this.v = i2 |= 16;
            this.A = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            y(e, f2);
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
            x((i)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            y(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i n() {
            kotlin.i0.z.e.m0.e.i iVar = o();
            if (!iVar.isInitialized()) {
            } else {
                return iVar;
            }
            throw a.a.c(iVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i o() {
            int i3;
            int i4;
            int i2;
            int i;
            i iVar = new i(this, 0);
            int i6 = this.v;
            if (i6 & 1 == 1) {
            } else {
                i = 0;
            }
            i.u(iVar, this.w);
            if (i6 & 2 == 2) {
                i |= 2;
            }
            i.v(iVar, this.x);
            if (i6 & 4 == 4) {
                i |= 4;
            }
            i.w(iVar, this.y);
            if (i6 & 8 == 8) {
                i |= 8;
            }
            i.x(iVar, this.z);
            if (i6 & 16 == 16) {
                i |= 16;
            }
            i.y(iVar, this.A);
            int i32 = 32;
            if (i17 &= i32 == i32) {
                this.B = Collections.unmodifiableList(this.B);
                this.v = i18 &= -33;
            }
            i.A(iVar, this.B);
            if (i6 & 64 == 64) {
                i |= 32;
            }
            i.B(iVar, this.C);
            if (i6 & 128 == 128) {
                i |= 64;
            }
            i.C(iVar, this.D);
            int i35 = 256;
            if (i22 &= i35 == i35) {
                this.E = Collections.unmodifiableList(this.E);
                this.v = i23 &= -257;
            }
            i.E(iVar, this.E);
            if (i6 & 512 == 512) {
                i |= 128;
            }
            i.F(iVar, this.F);
            int i37 = 1024;
            if (i25 &= i37 == i37) {
                this.G = Collections.unmodifiableList(this.G);
                this.v = i26 &= -1025;
            }
            i.H(iVar, this.G);
            int i27 = 2048;
            if (i6 &= i27 == i27) {
                i |= 256;
            }
            i.I(iVar, this.H);
            i.J(iVar, i);
            return iVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b p() {
            final kotlin.i0.z.e.m0.e.i.b bVar = i.b.r();
            bVar.x(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b w(kotlin.i0.z.e.m0.e.e e) {
            int i;
            kotlin.i0.z.e.m0.e.e eVar;
            kotlin.i0.z.e.m0.e.e obj4;
            final int i3 = 2048;
            if (i2 &= i3 == i3 && this.H != e.o()) {
                if (this.H != e.o()) {
                    i = e.t(this.H);
                    i.p(e);
                    this.H = i.k();
                } else {
                    this.H = e;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b x(kotlin.i0.z.e.m0.e.i i) {
            boolean z9;
            boolean z;
            boolean z2;
            boolean z6;
            boolean z3;
            boolean empty2;
            boolean z4;
            boolean z7;
            boolean empty;
            boolean z8;
            boolean empty3;
            boolean z5;
            List list;
            if (i == i.M()) {
                return this;
            }
            if (i.e0()) {
                C(i.O());
            }
            if (i.g0()) {
                E(i.Q());
            }
            if (i.f0()) {
                D(i.P());
            }
            if (i.k0()) {
                A(i.T());
            }
            if (i.l0()) {
                G(i.U());
            }
            if (!i.z(i).isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = i.z(i);
                    this.v = i2 &= -33;
                } else {
                    s();
                    this.B.addAll(i.z(i));
                }
            }
            if (i.h0()) {
                z(i.R());
            }
            if (i.i0()) {
                F(i.S());
            }
            if (!i.D(i).isEmpty()) {
                if (this.E.isEmpty()) {
                    this.E = i.D(i);
                    this.v = i3 &= -257;
                } else {
                    t();
                    this.E.addAll(i.D(i));
                }
            }
            if (i.m0()) {
                B(i.Y());
            }
            if (!i.G(i).isEmpty()) {
                if (this.G.isEmpty()) {
                    this.G = i.G(i);
                    this.v = i4 &= -1025;
                } else {
                    u();
                    this.G.addAll(i.G(i));
                }
            }
            if (i.d0()) {
                w(i.L());
            }
            l(i);
            g(e().d(i.K(i)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b y(e e, f f2) {
            final int i = 0;
            final Object obj3 = i.b.b(e, f2);
            if ((i)obj3 != null) {
                try {
                    x((i)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    x(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.i.b z(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 64;
            if (i2 &= i3 == i3 && this.C != q.R()) {
                if (this.C != q.R()) {
                    this.C = q.t0(this.C).w(q).o();
                } else {
                    this.C = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }
    }
    static {
        i.a aVar = new i.a();
        i.b = aVar;
        i iVar = new i(1);
        i.a = iVar;
        iVar.n0();
    }

    private i(e e, f f2) {
        int i2;
        int i;
        f fVar;
        f fVar2;
        f fVar3;
        int versionRequirement_2;
        int arrayList;
        int arrayList2;
        int returnType_;
        o oVar3;
        int typeTable_;
        o oVar4;
        int contract_;
        o oVar2;
        int arrayList3;
        int receiverType_;
        o oVar;
        int valueOf;
        int versionRequirement_;
        int valueOf2;
        int obj12;
        super();
        int i3 = -1;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        n0();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i = i2;
        fVar = 1024;
        fVar2 = 256;
        fVar3 = 32;
        while (i2 == 0) {
            versionRequirement_2 = e.K();
            valueOf = 0;
            if (!j(e, outputStream, f2, versionRequirement_2)) {
            }
            fVar = 1024;
            fVar2 = 256;
            fVar3 = 32;
            i2 = i4;
            if (bitField0_8 &= fVar2 == fVar2) {
            }
            oVar2 = e.u(e.b, f2);
            this.contract_ = (e)oVar2;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_9 |= fVar2;
            valueOf.p(oVar2);
            this.contract_ = valueOf.k();
            valueOf = this.contract_.v();
            if (i & 1024 != fVar && e.e() > 0) {
            }
            while (e.e() > 0) {
                this.versionRequirement_.add(Integer.valueOf(e.s()));
            }
            e.i(e.j(e.A()));
            this.versionRequirement_.add(Integer.valueOf(e.s()));
            if (e.e() > 0) {
            }
            versionRequirement_ = new ArrayList();
            this.versionRequirement_ = versionRequirement_;
            i |= 1024;
            if (i & 1024 != fVar) {
            }
            this.versionRequirement_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            this.versionRequirement_ = arrayList2;
            i |= 1024;
            valueOf2 = 128;
            if (bitField0_4 &= valueOf2 == valueOf2) {
            }
            oVar4 = e.u(t.b, f2);
            this.typeTable_ = (t)oVar4;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_5 |= valueOf2;
            valueOf.p(oVar4);
            this.typeTable_ = valueOf.k();
            valueOf = this.typeTable_.A();
            this.bitField0_ = bitField0_10 |= i4;
            this.flags_ = e.s();
            this.bitField0_ = bitField0_7 |= 64;
            this.receiverTypeId_ = e.s();
            this.bitField0_ = bitField0_ |= 16;
            this.returnTypeId_ = e.s();
            if (i & 256 != fVar2) {
            }
            this.valueParameter_.add(e.u(u.b, f2));
            arrayList3 = new ArrayList();
            this.valueParameter_ = arrayList3;
            i |= 256;
            if (bitField0_11 &= fVar3 == fVar3) {
            }
            oVar = e.u(q.b, f2);
            this.receiverType_ = (q)oVar;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_12 |= fVar3;
            valueOf.w(oVar);
            this.receiverType_ = valueOf.o();
            valueOf = this.receiverType_.v0();
            if (i & 32 != fVar3) {
            }
            this.typeParameter_.add(e.u(s.b, f2));
            arrayList = new ArrayList();
            this.typeParameter_ = arrayList;
            i |= 32;
            valueOf2 = 8;
            if (bitField0_2 &= valueOf2 == valueOf2) {
            }
            oVar3 = e.u(q.b, f2);
            this.returnType_ = (q)oVar3;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_3 |= valueOf2;
            valueOf.w(oVar3);
            this.returnType_ = valueOf.o();
            valueOf = this.returnType_.v0();
            this.bitField0_ = bitField0_13 |= 4;
            this.name_ = e.s();
            this.bitField0_ = bitField0_6 |= 2;
            this.oldFlags_ = e.s();
        }
        if (i & 32 == fVar3) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (i & 256 == fVar2) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if (i & 1024 == fVar) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    i(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private i(h.c<kotlin.i0.z.e.m0.e.i, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    i(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private i(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List A(kotlin.i0.z.e.m0.e.i i, List list2) {
        i.typeParameter_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.q B(kotlin.i0.z.e.m0.e.i i, kotlin.i0.z.e.m0.e.q q2) {
        i.receiverType_ = q2;
        return q2;
    }

    static int C(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.receiverTypeId_ = i2;
        return i2;
    }

    static List D(kotlin.i0.z.e.m0.e.i i) {
        return i.valueParameter_;
    }

    static List E(kotlin.i0.z.e.m0.e.i i, List list2) {
        i.valueParameter_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.t F(kotlin.i0.z.e.m0.e.i i, kotlin.i0.z.e.m0.e.t t2) {
        i.typeTable_ = t2;
        return t2;
    }

    static List G(kotlin.i0.z.e.m0.e.i i) {
        return i.versionRequirement_;
    }

    static List H(kotlin.i0.z.e.m0.e.i i, List list2) {
        i.versionRequirement_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.e I(kotlin.i0.z.e.m0.e.i i, kotlin.i0.z.e.m0.e.e e2) {
        i.contract_ = e2;
        return e2;
    }

    static int J(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.bitField0_ = i2;
        return i2;
    }

    static d K(kotlin.i0.z.e.m0.e.i i) {
        return i.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.i M() {
        return i.a;
    }

    private void n0() {
        int i = 6;
        this.flags_ = i;
        this.oldFlags_ = i;
        int i2 = 0;
        this.name_ = i2;
        this.returnType_ = q.R();
        this.returnTypeId_ = i2;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = q.R();
        this.receiverTypeId_ = i2;
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = t.q();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = e.o();
    }

    public static kotlin.i0.z.e.m0.e.i.b o0() {
        return i.b.m();
    }

    public static kotlin.i0.z.e.m0.e.i.b p0(kotlin.i0.z.e.m0.e.i i) {
        final kotlin.i0.z.e.m0.e.i.b bVar = i.o0();
        bVar.x(i);
        return bVar;
    }

    public static kotlin.i0.z.e.m0.e.i r0(InputStream inputStream, f f2) {
        return (i)i.b.a(inputStream, f2);
    }

    static int u(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.flags_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.oldFlags_ = i2;
        return i2;
    }

    static int w(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.name_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q x(kotlin.i0.z.e.m0.e.i i, kotlin.i0.z.e.m0.e.q q2) {
        i.returnType_ = q2;
        return q2;
    }

    static int y(kotlin.i0.z.e.m0.e.i i, int i2) {
        i.returnTypeId_ = i2;
        return i2;
    }

    static List z(kotlin.i0.z.e.m0.e.i i) {
        return i.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.e L() {
        return this.contract_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.i N() {
        return i.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int O() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int P() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int Q() {
        return this.oldFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q R() {
        return this.receiverType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int S() {
        return this.receiverTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q T() {
        return this.returnType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int U() {
        return this.returnTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s V(int i) {
        return (s)this.typeParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int W() {
        return this.typeParameter_.size();
    }

    public List<kotlin.i0.z.e.m0.e.s> X() {
        return this.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.t Y() {
        return this.typeTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u Z(int i) {
        return (u)this.valueParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int oldFlags_;
        int name_;
        int i6;
        int i2;
        int contract_;
        int i3;
        int i5;
        int flags_;
        int typeTable_;
        int i7;
        int i4;
        int i;
        int receiverTypeId_;
        kotlin.i0.z.e.m0.e.q returnType_;
        int i8;
        Object obj2;
        int receiverType_;
        int returnTypeId_;
        Object obj;
        getSerializedSize();
        int i10 = 2;
        flags_ = 1;
        if (bitField0_ &= i10 == i10) {
            codedOutputStream.a0(flags_, this.oldFlags_);
        }
        int i13 = 4;
        if (bitField0_2 &= i13 == i13) {
            codedOutputStream.a0(i10, this.name_);
        }
        int i11 = 8;
        if (bitField0_3 &= i11 == i11) {
            codedOutputStream.d0(3, this.returnType_);
        }
        i2 = 0;
        i8 = i2;
        while (i8 < this.typeParameter_.size()) {
            codedOutputStream.d0(i13, (o)this.typeParameter_.get(i8));
            i8++;
        }
        int i14 = 32;
        if (bitField0_7 &= i14 == i14) {
            codedOutputStream.d0(5, this.receiverType_);
        }
        i4 = i2;
        while (i4 < this.valueParameter_.size()) {
            codedOutputStream.d0(6, (o)this.valueParameter_.get(i4));
            i4++;
        }
        returnTypeId_ = 16;
        if (bitField0_8 &= returnTypeId_ == returnTypeId_) {
            codedOutputStream.a0(7, this.returnTypeId_);
        }
        int i15 = 64;
        if (bitField0_9 &= i15 == i15) {
            codedOutputStream.a0(i11, this.receiverTypeId_);
        }
        if (bitField0_5 &= flags_ == flags_) {
            codedOutputStream.a0(9, this.flags_);
        }
        typeTable_ = 128;
        if (bitField0_6 &= typeTable_ == typeTable_) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        while (i2 < this.versionRequirement_.size()) {
            codedOutputStream.a0(31, (Integer)this.versionRequirement_.get(i2).intValue());
            i2++;
        }
        int i12 = 256;
        if (bitField0_4 &= i12 == i12) {
            codedOutputStream.d0(i14, this.contract_);
        }
        s().a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int a0() {
        return this.valueParameter_.size();
    }

    public List<kotlin.i0.z.e.m0.e.u> b0() {
        return this.valueParameter_;
    }

    public List<Integer> c0() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean d0() {
        int i;
        final int i3 = 256;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean e0() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean f0() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean g0() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return N();
    }

    public q<kotlin.i0.z.e.m0.e.i> getParserForType() {
        return i.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i9;
        int i10;
        int i6;
        int i14;
        int i3;
        int i12;
        int i13;
        int i2;
        int i7;
        int i11;
        int i4;
        int i;
        int i5;
        int i8;
        int flags_;
        int typeTable_;
        kotlin.i0.z.e.m0.e.q returnType_;
        int receiverType_;
        int returnTypeId_;
        Object obj;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i21 = 2;
        i14 = 0;
        i3 = 1;
        if (bitField0_ &= i21 == i21) {
            i16 += i14;
        } else {
            i9 = i14;
        }
        int i30 = 4;
        if (bitField0_4 &= i30 == i30) {
            i9 += i2;
        }
        final int i32 = 8;
        if (bitField0_5 &= i32 == i32) {
            i9 += i7;
        }
        i11 = i14;
        while (i11 < this.typeParameter_.size()) {
            i9 += returnType_;
            i11++;
        }
        int i31 = 32;
        if (bitField0_6 &= i31 == i31) {
            i9 += i4;
        }
        i = i14;
        while (i < this.valueParameter_.size()) {
            i9 += receiverType_;
            i++;
        }
        returnTypeId_ = 16;
        if (bitField0_7 &= returnTypeId_ == returnTypeId_) {
            i9 += i5;
        }
        int i33 = 64;
        if (bitField0_8 &= i33 == i33) {
            i9 += i8;
        }
        if (bitField0_9 &= i3 == i3) {
            i9 += i3;
        }
        typeTable_ = 128;
        if (bitField0_3 &= typeTable_ == typeTable_) {
            i9 += i12;
        }
        i13 = i14;
        while (i14 < this.versionRequirement_.size()) {
            i13 += typeTable_;
            i14++;
        }
        int i24 = 256;
        if (bitField0_2 &= i24 == i24) {
            i10 += i6;
        }
        i18 += size;
        this.memoizedSerializedSize = i19;
        return i19;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean h0() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean i0() {
        int i;
        final int i3 = 64;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        boolean initialized4;
        int i;
        boolean initialized5;
        int i2;
        boolean initialized;
        boolean initialized6;
        boolean initialized2;
        int initialized3;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i3 = 1;
        if (memoizedIsInitialized == i3) {
            return i3;
        }
        final int i4 = 0;
        if (memoizedIsInitialized == 0) {
            return i4;
        }
        if (!f0()) {
            this.memoizedIsInitialized = i4;
            return i4;
        }
        if (k0() && !T().isInitialized()) {
            if (!T().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        i = i4;
        while (i < W()) {
            i++;
        }
        if (h0() && !R().isInitialized()) {
            if (!R().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        i2 = i4;
        while (i2 < a0()) {
            i2++;
        }
        if (m0() && !Y().isInitialized()) {
            if (!Y().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        if (d0() && !L().isInitialized()) {
            if (!L().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        if (!m()) {
            this.memoizedIsInitialized = i4;
            return i4;
        }
        this.memoizedIsInitialized = i3;
        return i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean k0() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean l0() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean m0() {
        int i;
        final int i3 = 128;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.i.b q0() {
        return i.o0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.i.b s0() {
        return i.p0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return s0();
    }
}
