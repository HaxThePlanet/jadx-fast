package kotlin.i0.z.e.m0.e;

import java.io.IOException;
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
public final class n extends h.d<kotlin.i0.z.e.m0.e.n> implements p {

    private static final kotlin.i0.z.e.m0.e.n a;
    public static q<kotlin.i0.z.e.m0.e.n> b;
    private int bitField0_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private kotlin.i0.z.e.m0.e.q receiverType_;
    private int returnTypeId_;
    private kotlin.i0.z.e.m0.e.q returnType_;
    private int setterFlags_;
    private kotlin.i0.z.e.m0.e.u setterValueParameter_;
    private List<kotlin.i0.z.e.m0.e.s> typeParameter_;
    private final d unknownFields;
    private List<Integer> versionRequirement_;

    static class a extends b<kotlin.i0.z.e.m0.e.n> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.n m(e e, f f2) {
            n nVar = new n(e, f2, 0);
            return nVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.n, kotlin.i0.z.e.m0.e.n.b> implements p {

        private int A;
        private List<kotlin.i0.z.e.m0.e.s> B;
        private kotlin.i0.z.e.m0.e.q C;
        private int D;
        private kotlin.i0.z.e.m0.e.u E;
        private int F;
        private int G;
        private List<Integer> H;
        private int v;
        private int w = 518;
        private int x = 2054;
        private int y;
        private kotlin.i0.z.e.m0.e.q z;
        private b() {
            super();
            int i = 518;
            int i2 = 2054;
            this.z = q.R();
            this.B = Collections.emptyList();
            this.C = q.R();
            this.E = u.C();
            this.H = Collections.emptyList();
            u();
        }

        static kotlin.i0.z.e.m0.e.n.b m() {
            return n.b.r();
        }

        private static kotlin.i0.z.e.m0.e.n.b r() {
            n.b bVar = new n.b();
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
            final int i4 = 2048;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.H);
                this.H = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b A(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b B(int i) {
            this.v = i2 |= 512;
            this.F = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b C(int i) {
            this.v = i2 |= 4;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b D(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b E(int i) {
            this.v = i2 |= 128;
            this.D = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b F(int i) {
            this.v = i2 |= 16;
            this.A = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b G(int i) {
            this.v = i2 |= 1024;
            this.G = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            w(e, f2);
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
            v((n)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            w(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n n() {
            kotlin.i0.z.e.m0.e.n nVar = o();
            if (!nVar.isInitialized()) {
            } else {
                return nVar;
            }
            throw a.a.c(nVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n o() {
            int i;
            int i3;
            int i2;
            n nVar = new n(this, 0);
            int i5 = this.v;
            if (i5 & 1 == 1) {
            } else {
                i2 = 0;
            }
            n.u(nVar, this.w);
            if (i5 & 2 == 2) {
                i2 |= 2;
            }
            n.v(nVar, this.x);
            if (i5 & 4 == 4) {
                i2 |= 4;
            }
            n.w(nVar, this.y);
            if (i5 & 8 == 8) {
                i2 |= 8;
            }
            n.x(nVar, this.z);
            if (i5 & 16 == 16) {
                i2 |= 16;
            }
            n.y(nVar, this.A);
            int i33 = 32;
            if (i19 &= i33 == i33) {
                this.B = Collections.unmodifiableList(this.B);
                this.v = i20 &= -33;
            }
            n.A(nVar, this.B);
            if (i5 & 64 == 64) {
                i2 |= 32;
            }
            n.B(nVar, this.C);
            if (i5 & 128 == 128) {
                i2 |= 64;
            }
            n.C(nVar, this.D);
            if (i5 & 256 == 256) {
                i2 |= 128;
            }
            n.D(nVar, this.E);
            if (i5 & 512 == 512) {
                i2 |= 256;
            }
            n.E(nVar, this.F);
            int i27 = 1024;
            if (i5 &= i27 == i27) {
                i2 |= 512;
            }
            n.F(nVar, this.G);
            int i28 = 2048;
            if (i8 &= i28 == i28) {
                this.H = Collections.unmodifiableList(this.H);
                this.v = i9 &= -2049;
            }
            n.H(nVar, this.H);
            n.I(nVar, i2);
            return nVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b p() {
            final kotlin.i0.z.e.m0.e.n.b bVar = n.b.r();
            bVar.v(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b v(kotlin.i0.z.e.m0.e.n n) {
            boolean z4;
            boolean z9;
            boolean z8;
            boolean z10;
            boolean z5;
            boolean empty;
            boolean z3;
            boolean z2;
            boolean z6;
            boolean z;
            boolean z7;
            boolean empty2;
            List list;
            if (n == n.K()) {
                return this;
            }
            if (n.a0()) {
                A(n.M());
            }
            if (n.d0()) {
                D(n.P());
            }
            if (n.c0()) {
                C(n.O());
            }
            if (n.g0()) {
                y(n.S());
            }
            if (n.h0()) {
                F(n.T());
            }
            if (!n.z(n).isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = n.z(n);
                    this.v = i &= -33;
                } else {
                    s();
                    this.B.addAll(n.z(n));
                }
            }
            if (n.e0()) {
                x(n.Q());
            }
            if (n.f0()) {
                E(n.R());
            }
            if (n.k0()) {
                z(n.V());
            }
            if (n.b0()) {
                B(n.N());
            }
            if (n.i0()) {
                G(n.U());
            }
            if (!n.G(n).isEmpty()) {
                if (this.H.isEmpty()) {
                    this.H = n.G(n);
                    this.v = i2 &= -2049;
                } else {
                    t();
                    this.H.addAll(n.G(n));
                }
            }
            l(n);
            g(e().d(n.J(n)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b w(e e, f f2) {
            final int i = 0;
            final Object obj3 = n.b.b(e, f2);
            if ((n)obj3 != null) {
                try {
                    v((n)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    v(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b x(kotlin.i0.z.e.m0.e.q q) {
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.n.b y(kotlin.i0.z.e.m0.e.q q) {
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
        public kotlin.i0.z.e.m0.e.n.b z(kotlin.i0.z.e.m0.e.u u) {
            int i;
            kotlin.i0.z.e.m0.e.u uVar;
            kotlin.i0.z.e.m0.e.u obj4;
            final int i3 = 256;
            if (i2 &= i3 == i3 && this.E != u.C()) {
                if (this.E != u.C()) {
                    i = u.S(this.E);
                    i.t(u);
                    this.E = i.o();
                } else {
                    this.E = u;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }
    }
    static {
        n.a aVar = new n.a();
        n.b = aVar;
        n nVar = new n(1);
        n.a = nVar;
        nVar.l0();
    }

    private n(e e, f f2) {
        int i3;
        int i;
        int i2;
        f fVar;
        f fVar2;
        int versionRequirement_2;
        int arrayList;
        int returnType_;
        o oVar;
        int setterValueParameter_;
        o oVar3;
        int receiverType_;
        o oVar2;
        int arrayList2;
        int valueOf;
        int versionRequirement_;
        int valueOf2;
        int obj11;
        super();
        int i4 = -1;
        this.memoizedIsInitialized = i4;
        this.memoizedSerializedSize = i4;
        l0();
        d.b bVar = d.w();
        final int i5 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i5);
        i2 = i;
        fVar = 2048;
        fVar2 = 32;
        while (i == 0) {
            versionRequirement_2 = e.K();
            valueOf = 0;
            if (!j(e, outputStream, f2, versionRequirement_2)) {
            }
            fVar = 2048;
            fVar2 = 32;
            i = i5;
            if (i2 & 2048 != fVar && e.e() > 0) {
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
            i2 |= 2048;
            if (i2 & 2048 != fVar) {
            }
            this.versionRequirement_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            this.versionRequirement_ = arrayList2;
            i2 |= 2048;
            this.bitField0_ = bitField0_12 |= i5;
            this.flags_ = e.s();
            this.bitField0_ = bitField0_7 |= 64;
            this.receiverTypeId_ = e.s();
            this.bitField0_ = bitField0_3 |= 16;
            this.returnTypeId_ = e.s();
            this.bitField0_ = bitField0_13 |= 512;
            this.setterFlags_ = e.s();
            this.bitField0_ = bitField0_9 |= 256;
            this.getterFlags_ = e.s();
            valueOf2 = 128;
            if (bitField0_5 &= valueOf2 == valueOf2) {
            }
            oVar3 = e.u(u.b, f2);
            this.setterValueParameter_ = (u)oVar3;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_6 |= valueOf2;
            valueOf.t(oVar3);
            this.setterValueParameter_ = valueOf.o();
            valueOf = this.setterValueParameter_.U();
            if (bitField0_10 &= fVar2 == fVar2) {
            }
            oVar2 = e.u(q.b, f2);
            this.receiverType_ = (q)oVar2;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_11 |= fVar2;
            valueOf.w(oVar2);
            this.receiverType_ = valueOf.o();
            valueOf = this.receiverType_.v0();
            if (i2 & 32 != fVar2) {
            }
            this.typeParameter_.add(e.u(s.b, f2));
            arrayList = new ArrayList();
            this.typeParameter_ = arrayList;
            i2 |= 32;
            valueOf2 = 8;
            if (bitField0_ &= valueOf2 == valueOf2) {
            }
            oVar = e.u(q.b, f2);
            this.returnType_ = (q)oVar;
            if (valueOf != 0) {
            }
            this.bitField0_ = bitField0_2 |= valueOf2;
            valueOf.w(oVar);
            this.returnType_ = valueOf.o();
            valueOf = this.returnType_.v0();
            this.bitField0_ = bitField0_8 |= 4;
            this.name_ = e.s();
            this.bitField0_ = bitField0_4 |= 2;
            this.oldFlags_ = e.s();
        }
        if (i2 & 32 == fVar2) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (i2 & 2048 == fVar) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    n(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private n(h.c<kotlin.i0.z.e.m0.e.n, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    n(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private n(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List A(kotlin.i0.z.e.m0.e.n n, List list2) {
        n.typeParameter_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.q B(kotlin.i0.z.e.m0.e.n n, kotlin.i0.z.e.m0.e.q q2) {
        n.receiverType_ = q2;
        return q2;
    }

    static int C(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.receiverTypeId_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.u D(kotlin.i0.z.e.m0.e.n n, kotlin.i0.z.e.m0.e.u u2) {
        n.setterValueParameter_ = u2;
        return u2;
    }

    static int E(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.getterFlags_ = i2;
        return i2;
    }

    static int F(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.setterFlags_ = i2;
        return i2;
    }

    static List G(kotlin.i0.z.e.m0.e.n n) {
        return n.versionRequirement_;
    }

    static List H(kotlin.i0.z.e.m0.e.n n, List list2) {
        n.versionRequirement_ = list2;
        return list2;
    }

    static int I(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.bitField0_ = i2;
        return i2;
    }

    static d J(kotlin.i0.z.e.m0.e.n n) {
        return n.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.n K() {
        return n.a;
    }

    private void l0() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        int i3 = 0;
        this.name_ = i3;
        this.returnType_ = q.R();
        this.returnTypeId_ = i3;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = q.R();
        this.receiverTypeId_ = i3;
        this.setterValueParameter_ = u.C();
        this.getterFlags_ = i3;
        this.setterFlags_ = i3;
        this.versionRequirement_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.n.b m0() {
        return n.b.m();
    }

    public static kotlin.i0.z.e.m0.e.n.b n0(kotlin.i0.z.e.m0.e.n n) {
        final kotlin.i0.z.e.m0.e.n.b bVar = n.m0();
        bVar.v(n);
        return bVar;
    }

    static int u(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.flags_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.oldFlags_ = i2;
        return i2;
    }

    static int w(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.name_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q x(kotlin.i0.z.e.m0.e.n n, kotlin.i0.z.e.m0.e.q q2) {
        n.returnType_ = q2;
        return q2;
    }

    static int y(kotlin.i0.z.e.m0.e.n n, int i2) {
        n.returnTypeId_ = i2;
        return i2;
    }

    static List z(kotlin.i0.z.e.m0.e.n n) {
        return n.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.n L() {
        return n.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int M() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int N() {
        return this.getterFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int O() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int P() {
        return this.oldFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q Q() {
        return this.receiverType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int R() {
        return this.receiverTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q S() {
        return this.returnType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int T() {
        return this.returnTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int U() {
        return this.setterFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u V() {
        return this.setterValueParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s W(int i) {
        return (s)this.typeParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int X() {
        return this.typeParameter_.size();
    }

    public List<kotlin.i0.z.e.m0.e.s> Y() {
        return this.typeParameter_;
    }

    public List<Integer> Z() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int oldFlags_;
        int name_;
        int i6;
        int i8;
        int i2;
        int i9;
        int i5;
        int intValue;
        int i3;
        int i;
        int i4;
        int setterFlags_;
        int returnTypeId_;
        int receiverTypeId_;
        kotlin.i0.z.e.m0.e.q returnType_;
        int i7;
        int receiverType_;
        int setterValueParameter_;
        int getterFlags_;
        Object obj;
        getSerializedSize();
        int i11 = 2;
        intValue = 1;
        if (bitField0_ &= i11 == i11) {
            codedOutputStream.a0(intValue, this.oldFlags_);
        }
        int i13 = 4;
        if (bitField0_2 &= i13 == i13) {
            codedOutputStream.a0(i11, this.name_);
        }
        int i12 = 8;
        if (bitField0_3 &= i12 == i12) {
            codedOutputStream.d0(3, this.returnType_);
        }
        i7 = i8;
        while (i7 < this.typeParameter_.size()) {
            codedOutputStream.d0(i13, (o)this.typeParameter_.get(i7));
            i7++;
        }
        receiverType_ = 32;
        if (bitField0_7 &= receiverType_ == receiverType_) {
            codedOutputStream.d0(5, this.receiverType_);
        }
        setterValueParameter_ = 128;
        if (bitField0_8 &= setterValueParameter_ == setterValueParameter_) {
            codedOutputStream.d0(6, this.setterValueParameter_);
        }
        getterFlags_ = 256;
        if (bitField0_9 &= getterFlags_ == getterFlags_) {
            codedOutputStream.a0(7, this.getterFlags_);
        }
        int i14 = 512;
        if (bitField0_10 &= i14 == i14) {
            codedOutputStream.a0(i12, this.setterFlags_);
        }
        returnTypeId_ = 16;
        if (bitField0_4 &= returnTypeId_ == returnTypeId_) {
            codedOutputStream.a0(9, this.returnTypeId_);
        }
        receiverTypeId_ = 64;
        if (bitField0_5 &= receiverTypeId_ == receiverTypeId_) {
            codedOutputStream.a0(10, this.receiverTypeId_);
        }
        if (bitField0_6 &= intValue == intValue) {
            codedOutputStream.a0(11, this.flags_);
        }
        while (i8 < this.versionRequirement_.size()) {
            codedOutputStream.a0(31, (Integer)this.versionRequirement_.get(i8).intValue());
            i8++;
        }
        s().a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean a0() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean b0() {
        int i;
        final int i3 = 256;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean c0() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean d0() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean e0() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean f0() {
        int i;
        final int i3 = 64;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean g0() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return L();
    }

    public q<kotlin.i0.z.e.m0.e.n> getParserForType() {
        return n.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i3;
        int i5;
        int i12;
        int i11;
        int i9;
        int i10;
        int i6;
        int i13;
        int i2;
        int i7;
        int i;
        int i8;
        int i4;
        int flags_;
        int receiverType_;
        int setterValueParameter_;
        int getterFlags_;
        int returnTypeId_;
        int receiverTypeId_;
        kotlin.i0.z.e.m0.e.q returnType_;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i21 = 2;
        i5 = 0;
        i12 = 1;
        if (bitField0_ &= i21 == i21) {
            i15 += i5;
        } else {
            i3 = i5;
        }
        int i31 = 4;
        if (bitField0_2 &= i31 == i31) {
            i3 += i9;
        }
        final int i33 = 8;
        if (bitField0_3 &= i33 == i33) {
            i3 += i10;
        }
        i6 = i5;
        while (i6 < this.typeParameter_.size()) {
            i3 += returnType_;
            i6++;
        }
        receiverType_ = 32;
        if (bitField0_4 &= receiverType_ == receiverType_) {
            i3 += i13;
        }
        setterValueParameter_ = 128;
        if (bitField0_5 &= setterValueParameter_ == setterValueParameter_) {
            i3 += i2;
        }
        getterFlags_ = 256;
        if (bitField0_6 &= getterFlags_ == getterFlags_) {
            i3 += i7;
        }
        int i32 = 512;
        if (bitField0_7 &= i32 == i32) {
            i3 += i;
        }
        returnTypeId_ = 16;
        if (bitField0_8 &= returnTypeId_ == returnTypeId_) {
            i3 += i8;
        }
        receiverTypeId_ = 64;
        if (bitField0_9 &= receiverTypeId_ == receiverTypeId_) {
            i3 += i4;
        }
        if (bitField0_10 &= i12 == i12) {
            i3 += i12;
        }
        i11 = i5;
        while (i5 < this.versionRequirement_.size()) {
            i11 += flags_;
            i5++;
        }
        i18 += size;
        this.memoizedSerializedSize = i19;
        return i19;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean h0() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean i0() {
        int i;
        final int i3 = 512;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        boolean initialized4;
        int i;
        boolean initialized;
        boolean initialized3;
        boolean initialized2;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i2 = 1;
        if (memoizedIsInitialized == i2) {
            return i2;
        }
        final int i3 = 0;
        if (memoizedIsInitialized == 0) {
            return i3;
        }
        if (!c0()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        if (g0() && !S().isInitialized()) {
            if (!S().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        i = i3;
        while (i < X()) {
            i++;
        }
        if (e0() && !Q().isInitialized()) {
            if (!Q().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        if (k0() && !V().isInitialized()) {
            if (!V().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        if (!m()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean k0() {
        int i;
        final int i3 = 128;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return o0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.n.b o0() {
        return n.m0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.n.b p0() {
        return n.n0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return p0();
    }
}
