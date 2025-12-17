package kotlin.i0.z.e.m0.e;

import android.app.ActivityManager.MemoryInfo;
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
public final class q extends h.d<kotlin.i0.z.e.m0.e.q> implements p {

    private static final kotlin.i0.z.e.m0.e.q a;
    public static q<kotlin.i0.z.e.m0.e.q> b;
    private int abbreviatedTypeId_;
    private kotlin.i0.z.e.m0.e.q abbreviatedType_;
    private List<kotlin.i0.z.e.m0.e.q.b> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private kotlin.i0.z.e.m0.e.q flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private kotlin.i0.z.e.m0.e.q outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.q> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.q m(e e, f f2) {
            q qVar = new q(e, f2, 0);
            return qVar;
        }
    }

    public static final class b extends h implements p {

        private static final kotlin.i0.z.e.m0.e.q.b a;
        public static q<kotlin.i0.z.e.m0.e.q.b> b;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private kotlin.i0.z.e.m0.e.q.b.c projection_;
        private int typeId_;
        private kotlin.i0.z.e.m0.e.q type_;
        private final d unknownFields;
        static {
            q.b.a aVar = new q.b.a();
            q.b.b = aVar;
            q.b bVar = new q.b(1);
            q.b.a = bVar;
            bVar.x();
        }

        private b(e e, f f2) {
            int i;
            int i2;
            int i3;
            int i4;
            kotlin.i0.z.e.m0.e.q.b.c valueOf;
            super();
            int i5 = -1;
            this.memoizedIsInitialized = i5;
            this.memoizedSerializedSize = i5;
            x();
            d.b bVar = d.w();
            final int i6 = 1;
            final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
            i = 0;
            while (i == 0) {
                i2 = e.K();
                if (i2 != 0) {
                } else {
                }
                i = i6;
                if (i2 != 8) {
                } else {
                }
                i4 = e.n();
                valueOf = q.b.c.valueOf(i4);
                if (valueOf == null) {
                } else {
                }
                this.bitField0_ = bitField0_ |= i6;
                this.projection_ = valueOf;
                outputStream.o0(i2);
                outputStream.o0(i4);
                if (i2 != 18) {
                } else {
                }
                i3 = 0;
                valueOf = 2;
                if (bitField0_4 &= valueOf == valueOf) {
                }
                i4 = e.u(q.b, f2);
                this.type_ = (q)i4;
                if (i3 != 0) {
                }
                this.bitField0_ = bitField0_2 |= valueOf;
                i3.w(i4);
                this.type_ = i3.o();
                i3 = this.type_.v0();
                if (i2 != 24) {
                } else {
                }
                this.bitField0_ = bitField0_3 |= 4;
                this.typeId_ = e.s();
                if (!j(e, outputStream, f2, i2)) {
                }
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        b(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
            super(e, f2);
        }

        private b(h.b h$b) {
            super(b);
            final int i = -1;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        b(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
            super(b);
        }

        private b(boolean z) {
            super();
            int obj1 = -1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        static kotlin.i0.z.e.m0.e.q.b.c l(kotlin.i0.z.e.m0.e.q.b q$b, kotlin.i0.z.e.m0.e.q.b.c q$b$c2) {
            b.projection_ = c2;
            return c2;
        }

        static kotlin.i0.z.e.m0.e.q m(kotlin.i0.z.e.m0.e.q.b q$b, kotlin.i0.z.e.m0.e.q q2) {
            b.type_ = q2;
            return q2;
        }

        static int n(kotlin.i0.z.e.m0.e.q.b q$b, int i2) {
            b.typeId_ = i2;
            return i2;
        }

        static int o(kotlin.i0.z.e.m0.e.q.b q$b, int i2) {
            b.bitField0_ = i2;
            return i2;
        }

        static d p(kotlin.i0.z.e.m0.e.q.b q$b) {
            return b.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.q.b q() {
            return q.b.a;
        }

        private void x() {
            this.projection_ = q.b.c.INV;
            this.type_ = q.R();
            this.typeId_ = 0;
        }

        public static kotlin.i0.z.e.m0.e.q.b.b y() {
            return q.b.b.h();
        }

        public static kotlin.i0.z.e.m0.e.q.b.b z(kotlin.i0.z.e.m0.e.q.b q$b) {
            final kotlin.i0.z.e.m0.e.q.b.b bVar = q.b.y();
            bVar.o(b);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.q.b.b A() {
            return q.b.y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.q.b.b B() {
            return q.b.z(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int number;
            int type_;
            int i;
            int typeId_;
            getSerializedSize();
            int i2 = 1;
            if (bitField0_ &= i2 == i2) {
                codedOutputStream.S(i2, this.projection_.getNumber());
            }
            int i3 = 2;
            if (bitField0_2 &= i3 == i3) {
                codedOutputStream.d0(i3, this.type_);
            }
            typeId_ = 4;
            if (bitField0_3 &= typeId_ == typeId_) {
                codedOutputStream.a0(3, this.typeId_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.q.b> getParserForType() {
            return q.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i2;
            int i3;
            int i;
            int i4;
            int typeId_;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i8 = 1;
            if (bitField0_ &= i8 == i8) {
                i2 += i3;
            }
            int i9 = 2;
            if (bitField0_2 &= i9 == i9) {
                i2 += i;
            }
            typeId_ = 4;
            if (bitField0_3 &= typeId_ == typeId_) {
                i2 += i4;
            }
            i2 += size;
            this.memoizedSerializedSize = i5;
            return i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public final boolean isInitialized() {
            boolean initialized;
            byte memoizedIsInitialized = this.memoizedIsInitialized;
            final int i = 1;
            if (memoizedIsInitialized == i) {
                return i;
            }
            final int i2 = 0;
            if (memoizedIsInitialized == 0) {
                return i2;
            }
            if (v() && !s().isInitialized()) {
                if (!s().isInitialized()) {
                    this.memoizedIsInitialized = i2;
                    return i2;
                }
            }
            this.memoizedIsInitialized = i;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a newBuilderForType() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.q.b.c r() {
            return this.projection_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.q s() {
            return this.type_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int t() {
            return this.typeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return B();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean u() {
            int i;
            i = 1;
            if (bitField0_ &= i == i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean v() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean w() {
            int i;
            final int i3 = 4;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }
    }

    public static final class c extends h.c<kotlin.i0.z.e.m0.e.q, kotlin.i0.z.e.m0.e.q.c> implements p {

        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private kotlin.i0.z.e.m0.e.q F;
        private int G;
        private kotlin.i0.z.e.m0.e.q H;
        private int I;
        private int J;
        private int v;
        private List<kotlin.i0.z.e.m0.e.q.b> w;
        private boolean x;
        private int y;
        private kotlin.i0.z.e.m0.e.q z;
        private c() {
            super();
            this.w = Collections.emptyList();
            this.z = q.R();
            this.F = q.R();
            this.H = q.R();
            t();
        }

        static kotlin.i0.z.e.m0.e.q.c m() {
            return q.c.r();
        }

        private static kotlin.i0.z.e.m0.e.q.c r() {
            q.c cVar = new q.c();
            return cVar;
        }

        private void s() {
            int i;
            List list;
            final int i4 = 1;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.w);
                this.w = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void t() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c A(int i) {
            this.v = i2 |= 32;
            this.B = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c B(int i) {
            this.v = i2 |= 8192;
            this.J = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c C(int i) {
            this.v = i2 |= 4;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c D(int i) {
            this.v = i2 |= 16;
            this.A = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c E(boolean z) {
            this.v = i |= 2;
            this.x = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c F(int i) {
            this.v = i2 |= 1024;
            this.G = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c G(int i) {
            this.v = i2 |= 256;
            this.E = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c H(int i) {
            this.v = i2 |= 64;
            this.C = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c I(int i) {
            this.v = i2 |= 128;
            this.D = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            x(e, f2);
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
            return w((q)h);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            x(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q n() {
            kotlin.i0.z.e.m0.e.q qVar = o();
            if (!qVar.isInitialized()) {
            } else {
                return qVar;
            }
            throw a.a.c(qVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q o() {
            int i;
            int i2;
            q qVar = new q(this, 0);
            int i4 = this.v;
            if (i4 & 1 == 1) {
                this.w = Collections.unmodifiableList(this.w);
                this.v = i28 &= -2;
            }
            q.v(qVar, this.w);
            if (i4 & 2 == 2) {
            } else {
                i2 = 0;
            }
            q.w(qVar, this.x);
            if (i4 & 4 == 4) {
                i2 |= 2;
            }
            q.x(qVar, this.y);
            if (i4 & 8 == 8) {
                i2 |= 4;
            }
            q.y(qVar, this.z);
            if (i4 & 16 == 16) {
                i2 |= 8;
            }
            q.z(qVar, this.A);
            if (i4 & 32 == 32) {
                i2 |= 16;
            }
            q.A(qVar, this.B);
            if (i4 & 64 == 64) {
                i2 |= 32;
            }
            q.B(qVar, this.C);
            if (i4 & 128 == 128) {
                i2 |= 64;
            }
            q.C(qVar, this.D);
            if (i4 & 256 == 256) {
                i2 |= 128;
            }
            q.D(qVar, this.E);
            if (i4 & 512 == 512) {
                i2 |= 256;
            }
            q.E(qVar, this.F);
            if (i4 & 1024 == 1024) {
                i2 |= 512;
            }
            q.F(qVar, this.G);
            if (i4 & 2048 == 2048) {
                i2 |= 1024;
            }
            q.G(qVar, this.H);
            if (i4 & 4096 == 4096) {
                i2 |= 2048;
            }
            q.H(qVar, this.I);
            int i27 = 8192;
            if (i4 &= i27 == i27) {
                i2 |= 4096;
            }
            q.I(qVar, this.J);
            q.J(qVar, i2);
            return qVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c p() {
            final kotlin.i0.z.e.m0.e.q.c cVar = q.c.r();
            cVar.w(o());
            return cVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c u(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 2048;
            if (i2 &= i3 == i3 && this.H != q.R()) {
                if (this.H != q.R()) {
                    this.H = q.t0(this.H).w(q).o();
                } else {
                    this.H = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c v(kotlin.i0.z.e.m0.e.q q) {
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
        public kotlin.i0.z.e.m0.e.q.c w(kotlin.i0.z.e.m0.e.q q) {
            boolean empty;
            boolean z2;
            boolean z10;
            boolean z13;
            boolean z4;
            boolean z9;
            boolean z7;
            boolean z8;
            boolean z;
            boolean z11;
            boolean z5;
            boolean z12;
            boolean z6;
            boolean z3;
            List list;
            if (q == q.R()) {
                return this;
            }
            if (!q.u(q).isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = q.u(q);
                    this.v = i &= -2;
                } else {
                    s();
                    this.w.addAll(q.u(q));
                }
            }
            if (q.l0()) {
                E(q.X());
            }
            if (q.h0()) {
                C(q.U());
            }
            if (q.i0()) {
                v(q.V());
            }
            if (q.k0()) {
                D(q.W());
            }
            if (q.f0()) {
                A(q.Q());
            }
            if (q.p0()) {
                H(q.b0());
            }
            if (q.q0()) {
                I(q.c0());
            }
            if (q.o0()) {
                G(q.a0());
            }
            if (q.m0()) {
                y(q.Y());
            }
            if (q.n0()) {
                F(q.Z());
            }
            if (q.d0()) {
                u(q.L());
            }
            if (q.e0()) {
                z(q.M());
            }
            if (q.g0()) {
                B(q.T());
            }
            l(q);
            g(e().d(q.K(q)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c x(e e, f f2) {
            final int i = 0;
            final Object obj3 = q.b.b(e, f2);
            if ((q)obj3 != null) {
                try {
                    w((q)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    w(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c y(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 512;
            if (i2 &= i3 == i3 && this.F != q.R()) {
                if (this.F != q.R()) {
                    this.F = q.t0(this.F).w(q).o();
                } else {
                    this.F = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.q.c z(int i) {
            this.v = i2 |= 4096;
            this.I = i;
            return this;
        }
    }
    static {
        q.a aVar = new q.a();
        q.b = aVar;
        q qVar = new q(1);
        q.a = qVar;
        qVar.r0();
    }

    private q(e e, f f2) {
        int i2;
        int i5;
        boolean argument_;
        int arrayList;
        int outerType_;
        o oVar;
        int flexibleUpperBound_;
        o oVar3;
        int abbreviatedType_;
        o oVar2;
        int i4;
        int i;
        int obj9;
        super();
        int i6 = -1;
        this.memoizedIsInitialized = i6;
        this.memoizedSerializedSize = i6;
        r0();
        d.b bVar = d.w();
        final int i7 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i7);
        i5 = i2;
        while (i2 == 0) {
            argument_ = e.K();
            i4 = 0;
            if (!j(e, outputStream, f2, argument_)) {
            }
            i2 = i7;
            this.bitField0_ = bitField0_13 |= 2048;
            this.abbreviatedTypeId_ = e.s();
            i = 1024;
            if (bitField0_7 &= i == i) {
            }
            oVar2 = e.u(q.b, f2);
            this.abbreviatedType_ = (q)oVar2;
            if (i4 != 0) {
            }
            this.bitField0_ = bitField0_8 |= i;
            i4.w(oVar2);
            this.abbreviatedType_ = i4.o();
            i4 = this.abbreviatedType_.v0();
            this.bitField0_ = bitField0_15 |= 128;
            this.typeAliasName_ = e.s();
            this.bitField0_ = bitField0_10 |= 512;
            this.outerTypeId_ = e.s();
            i = 256;
            if (bitField0_2 &= i == i) {
            }
            oVar = e.u(q.b, f2);
            this.outerType_ = (q)oVar;
            if (i4 != 0) {
            }
            this.bitField0_ = bitField0_3 |= i;
            i4.w(oVar);
            this.outerType_ = i4.o();
            i4 = this.outerType_.v0();
            this.bitField0_ = bitField0_11 |= 64;
            this.typeParameterName_ = e.s();
            this.bitField0_ = bitField0_4 |= 8;
            this.flexibleUpperBoundId_ = e.s();
            this.bitField0_ = bitField0_16 |= 32;
            this.typeParameter_ = e.s();
            this.bitField0_ = bitField0_12 |= 16;
            this.className_ = e.s();
            i = 4;
            if (bitField0_5 &= i == i) {
            }
            oVar3 = e.u(q.b, f2);
            this.flexibleUpperBound_ = (q)oVar3;
            if (i4 != 0) {
            }
            this.bitField0_ = bitField0_6 |= i;
            i4.w(oVar3);
            this.flexibleUpperBound_ = i4.o();
            i4 = this.flexibleUpperBound_.v0();
            this.bitField0_ = bitField0_14 |= 2;
            this.flexibleTypeCapabilitiesId_ = e.s();
            this.bitField0_ = bitField0_9 |= i7;
            this.nullable_ = e.k();
            if (i5 & 1 != i7) {
            }
            this.argument_.add(e.u(q.b.b, f2));
            arrayList = new ArrayList();
            this.argument_ = arrayList;
            i5 |= 1;
            this.bitField0_ = bitField0_ |= 4096;
            this.flags_ = e.s();
        }
        if (i5 & 1 == i7) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    q(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private q(h.c<kotlin.i0.z.e.m0.e.q, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    q(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private q(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static int A(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.className_ = i2;
        return i2;
    }

    static int B(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.typeParameter_ = i2;
        return i2;
    }

    static int C(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.typeParameterName_ = i2;
        return i2;
    }

    static int D(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.typeAliasName_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q E(kotlin.i0.z.e.m0.e.q q, kotlin.i0.z.e.m0.e.q q2) {
        q.outerType_ = q2;
        return q2;
    }

    static int F(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.outerTypeId_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q G(kotlin.i0.z.e.m0.e.q q, kotlin.i0.z.e.m0.e.q q2) {
        q.abbreviatedType_ = q2;
        return q2;
    }

    static int H(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.abbreviatedTypeId_ = i2;
        return i2;
    }

    static int I(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.flags_ = i2;
        return i2;
    }

    static int J(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.bitField0_ = i2;
        return i2;
    }

    static d K(kotlin.i0.z.e.m0.e.q q) {
        return q.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.q R() {
        return q.a;
    }

    private void r0() {
        this.argument_ = Collections.emptyList();
        int i = 0;
        this.nullable_ = i;
        this.flexibleTypeCapabilitiesId_ = i;
        this.flexibleUpperBound_ = q.R();
        this.flexibleUpperBoundId_ = i;
        this.className_ = i;
        this.typeParameter_ = i;
        this.typeParameterName_ = i;
        this.typeAliasName_ = i;
        this.outerType_ = q.R();
        this.outerTypeId_ = i;
        this.abbreviatedType_ = q.R();
        this.abbreviatedTypeId_ = i;
        this.flags_ = i;
    }

    public static kotlin.i0.z.e.m0.e.q.c s0() {
        return q.c.m();
    }

    public static kotlin.i0.z.e.m0.e.q.c t0(kotlin.i0.z.e.m0.e.q q) {
        final kotlin.i0.z.e.m0.e.q.c cVar = q.s0();
        cVar.w(q);
        return cVar;
    }

    static List u(kotlin.i0.z.e.m0.e.q q) {
        return q.argument_;
    }

    static List v(kotlin.i0.z.e.m0.e.q q, List list2) {
        q.argument_ = list2;
        return list2;
    }

    static boolean w(kotlin.i0.z.e.m0.e.q q, boolean z2) {
        q.nullable_ = z2;
        return z2;
    }

    static int x(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.flexibleTypeCapabilitiesId_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q y(kotlin.i0.z.e.m0.e.q q, kotlin.i0.z.e.m0.e.q q2) {
        q.flexibleUpperBound_ = q2;
        return q2;
    }

    static int z(kotlin.i0.z.e.m0.e.q q, int i2) {
        q.flexibleUpperBoundId_ = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q L() {
        return this.abbreviatedType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int M() {
        return this.abbreviatedTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q.b N(int i) {
        return (q.b)this.argument_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int O() {
        return this.argument_.size();
    }

    public List<kotlin.i0.z.e.m0.e.q.b> P() {
        return this.argument_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int Q() {
        return this.className_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q S() {
        return q.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int T() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int U() {
        return this.flexibleTypeCapabilitiesId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q V() {
        return this.flexibleUpperBound_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int W() {
        return this.flexibleUpperBoundId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean X() {
        return this.nullable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q Y() {
        return this.outerType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int Z() {
        return this.outerTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int i4;
        int i2;
        int flexibleTypeCapabilitiesId_;
        int i13;
        int i10;
        int i3;
        int flexibleUpperBoundId_;
        int i;
        int i5;
        int i7;
        int i8;
        int i6;
        int i11;
        int i9;
        int nullable_;
        int flexibleUpperBound_;
        int className_;
        int typeParameter_;
        int typeParameterName_;
        int outerType_;
        int outerTypeId_;
        int typeAliasName_;
        int abbreviatedType_;
        int abbreviatedTypeId_;
        int i12;
        getSerializedSize();
        i9 = 4096;
        final int i16 = 1;
        if (bitField0_ &= i9 == i9) {
            codedOutputStream.a0(i16, this.flags_);
        }
        i4 = 0;
        i12 = 2;
        while (i4 < this.argument_.size()) {
            codedOutputStream.d0(i12, (o)this.argument_.get(i4));
            i4++;
            i12 = 2;
        }
        if (bitField0_2 &= i16 == i16) {
            codedOutputStream.L(3, this.nullable_);
        }
        flexibleUpperBound_ = 4;
        if (bitField0_3 &= i12 == i12) {
            codedOutputStream.a0(flexibleUpperBound_, this.flexibleTypeCapabilitiesId_);
        }
        if (bitField0_4 &= flexibleUpperBound_ == flexibleUpperBound_) {
            codedOutputStream.d0(5, this.flexibleUpperBound_);
        }
        className_ = 16;
        if (bitField0_5 &= className_ == className_) {
            codedOutputStream.a0(6, this.className_);
        }
        typeParameter_ = 32;
        if (bitField0_6 &= typeParameter_ == typeParameter_) {
            codedOutputStream.a0(7, this.typeParameter_);
        }
        int i15 = 8;
        if (bitField0_7 &= i15 == i15) {
            codedOutputStream.a0(i15, this.flexibleUpperBoundId_);
        }
        typeParameterName_ = 64;
        if (bitField0_8 &= typeParameterName_ == typeParameterName_) {
            codedOutputStream.a0(9, this.typeParameterName_);
        }
        outerType_ = 256;
        if (bitField0_9 &= outerType_ == outerType_) {
            codedOutputStream.d0(10, this.outerType_);
        }
        outerTypeId_ = 512;
        if (bitField0_10 &= outerTypeId_ == outerTypeId_) {
            codedOutputStream.a0(11, this.outerTypeId_);
        }
        typeAliasName_ = 128;
        if (bitField0_11 &= typeAliasName_ == typeAliasName_) {
            codedOutputStream.a0(12, this.typeAliasName_);
        }
        abbreviatedType_ = 1024;
        if (bitField0_12 &= abbreviatedType_ == abbreviatedType_) {
            codedOutputStream.d0(13, this.abbreviatedType_);
        }
        abbreviatedTypeId_ = 2048;
        if (bitField0_13 &= abbreviatedTypeId_ == abbreviatedTypeId_) {
            codedOutputStream.a0(14, this.abbreviatedTypeId_);
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int a0() {
        return this.typeAliasName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int b0() {
        return this.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int c0() {
        return this.typeParameterName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean d0() {
        int i;
        final int i3 = 1024;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean e0() {
        int i;
        final int i3 = 2048;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean f0() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean g0() {
        int i;
        final int i3 = 4096;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return S();
    }

    public q<kotlin.i0.z.e.m0.e.q> getParserForType() {
        return q.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i14;
        int i10;
        int i6;
        int i7;
        int i11;
        int i4;
        int i;
        int i5;
        int i2;
        int i12;
        int i3;
        int i8;
        int i15;
        int i9;
        int nullable_;
        int flexibleUpperBound_;
        int className_;
        int typeParameter_;
        int typeParameterName_;
        int outerType_;
        int outerTypeId_;
        int typeAliasName_;
        int abbreviatedType_;
        int abbreviatedTypeId_;
        int i13;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i10 = 4096;
        nullable_ = 0;
        final int i33 = 1;
        if (bitField0_ &= i10 == i10) {
            i17 += nullable_;
        } else {
            i14 = nullable_;
        }
        i13 = 2;
        while (nullable_ < this.argument_.size()) {
            i14 += i10;
            nullable_++;
            i13 = 2;
        }
        if (bitField0_2 &= i33 == i33) {
            i14 += i6;
        }
        flexibleUpperBound_ = 4;
        if (bitField0_3 &= i13 == i13) {
            i14 += i7;
        }
        if (bitField0_4 &= flexibleUpperBound_ == flexibleUpperBound_) {
            i14 += i11;
        }
        className_ = 16;
        if (bitField0_5 &= className_ == className_) {
            i14 += i4;
        }
        typeParameter_ = 32;
        if (bitField0_6 &= typeParameter_ == typeParameter_) {
            i14 += i;
        }
        int i32 = 8;
        if (bitField0_7 &= i32 == i32) {
            i14 += i5;
        }
        typeParameterName_ = 64;
        if (bitField0_8 &= typeParameterName_ == typeParameterName_) {
            i14 += i2;
        }
        outerType_ = 256;
        if (bitField0_9 &= outerType_ == outerType_) {
            i14 += i12;
        }
        outerTypeId_ = 512;
        if (bitField0_10 &= outerTypeId_ == outerTypeId_) {
            i14 += i3;
        }
        typeAliasName_ = 128;
        if (bitField0_11 &= typeAliasName_ == typeAliasName_) {
            i14 += i8;
        }
        abbreviatedType_ = 1024;
        if (bitField0_12 &= abbreviatedType_ == abbreviatedType_) {
            i14 += i15;
        }
        abbreviatedTypeId_ = 2048;
        if (bitField0_13 &= abbreviatedTypeId_ == abbreviatedTypeId_) {
            i14 += i9;
        }
        i18 += size2;
        this.memoizedSerializedSize = i19;
        return i19;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean h0() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean i0() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        int i;
        boolean initialized;
        boolean initialized4;
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
        i = i3;
        while (i < O()) {
            i++;
        }
        if (i0() && !V().isInitialized()) {
            if (!V().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        if (m0() && !Y().isInitialized()) {
            if (!Y().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        if (d0() && !L().isInitialized()) {
            if (!L().isInitialized()) {
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
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean l0() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean m0() {
        int i;
        final int i3 = 256;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean n0() {
        int i;
        final int i3 = 512;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return u0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean o0() {
        int i;
        final int i3 = 128;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean p0() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean q0() {
        int i;
        final int i3 = 64;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return v0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q.c u0() {
        return q.s0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q.c v0() {
        return q.t0(this);
    }
}
