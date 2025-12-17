package kotlin.i0.z.e.m0.e;

import java.io.IOException;
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
public final class u extends h.d<kotlin.i0.z.e.m0.e.u> implements p {

    private static final kotlin.i0.z.e.m0.e.u a;
    public static q<kotlin.i0.z.e.m0.e.u> b;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private kotlin.i0.z.e.m0.e.q type_;
    private final d unknownFields;
    private int varargElementTypeId_;
    private kotlin.i0.z.e.m0.e.q varargElementType_;

    static class a extends b<kotlin.i0.z.e.m0.e.u> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.u m(e e, f f2) {
            u uVar = new u(e, f2, 0);
            return uVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.u, kotlin.i0.z.e.m0.e.u.b> implements p {

        private kotlin.i0.z.e.m0.e.q A;
        private int B;
        private int v;
        private int w;
        private int x;
        private kotlin.i0.z.e.m0.e.q y;
        private int z;
        private b() {
            super();
            this.y = q.R();
            this.A = q.R();
            s();
        }

        static kotlin.i0.z.e.m0.e.u.b m() {
            return u.b.r();
        }

        private static kotlin.i0.z.e.m0.e.u.b r() {
            u.b bVar = new u.b();
            return bVar;
        }

        private void s() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b A(int i) {
            this.v = i2 |= 32;
            this.B = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            u(e, f2);
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
            t((u)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            u(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u n() {
            kotlin.i0.z.e.m0.e.u uVar = o();
            if (!uVar.isInitialized()) {
            } else {
                return uVar;
            }
            throw a.a.c(uVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u o() {
            int i;
            u uVar = new u(this, 0);
            int i3 = this.v;
            if (i3 & 1 == 1) {
            } else {
                i = 0;
            }
            u.u(uVar, this.w);
            if (i3 & 2 == 2) {
                i |= 2;
            }
            u.v(uVar, this.x);
            if (i3 & 4 == 4) {
                i |= 4;
            }
            u.w(uVar, this.y);
            if (i3 & 8 == 8) {
                i |= 8;
            }
            u.x(uVar, this.z);
            if (i3 & 16 == 16) {
                i |= 16;
            }
            u.y(uVar, this.A);
            int i14 = 32;
            if (i3 &= i14 == i14) {
                i |= 32;
            }
            u.z(uVar, this.B);
            u.A(uVar, i);
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b p() {
            final kotlin.i0.z.e.m0.e.u.b bVar = u.b.r();
            bVar.t(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b t(kotlin.i0.z.e.m0.e.u u) {
            boolean z3;
            boolean z;
            boolean z4;
            boolean z6;
            boolean z2;
            boolean z5;
            if (u == u.C()) {
                return this;
            }
            if (u.K()) {
                x(u.E());
            }
            if (u.L()) {
                y(u.F());
            }
            if (u.M()) {
                v(u.G());
            }
            if (u.N()) {
                z(u.H());
            }
            if (u.O()) {
                w(u.I());
            }
            if (u.P()) {
                A(u.J());
            }
            l(u);
            g(e().d(u.B(u)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b u(e e, f f2) {
            final int i = 0;
            final Object obj3 = u.b.b(e, f2);
            if ((u)obj3 != null) {
                try {
                    t((u)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    t(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b v(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 4;
            if (i2 &= i3 == i3 && this.y != q.R()) {
                if (this.y != q.R()) {
                    this.y = q.t0(this.y).w(q).o();
                } else {
                    this.y = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b w(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 16;
            if (i2 &= i3 == i3 && this.A != q.R()) {
                if (this.A != q.R()) {
                    this.A = q.t0(this.A).w(q).o();
                } else {
                    this.A = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b x(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b y(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.u.b z(int i) {
            this.v = i2 |= 8;
            this.z = i;
            return this;
        }
    }
    static {
        u.a aVar = new u.a();
        u.b = aVar;
        u uVar = new u(1);
        u.a = uVar;
        uVar.Q();
    }

    private u(e e, f f2) {
        int i3;
        int i4;
        int varargElementType_;
        o oVar2;
        int type_;
        o oVar;
        int i;
        int i5;
        int i6;
        int i2;
        super();
        int i7 = -1;
        this.memoizedIsInitialized = i7;
        this.memoizedSerializedSize = i7;
        Q();
        d.b bVar = d.w();
        final int i8 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i8);
        i3 = 0;
        while (i3 == 0) {
            i4 = e.K();
            if (i4 != 0) {
            } else {
            }
            i3 = i8;
            i = 8;
            if (i4 != i) {
            } else {
            }
            this.bitField0_ = bitField0_8 |= i8;
            this.flags_ = e.s();
            i5 = 16;
            if (i4 != i5) {
            } else {
            }
            this.bitField0_ = bitField0_ |= 2;
            this.name_ = e.s();
            i2 = 0;
            if (i4 != 26) {
            } else {
            }
            i = 4;
            if (bitField0_6 &= i == i) {
            }
            oVar = e.u(q.b, f2);
            this.type_ = (q)oVar;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_7 |= i;
            i2.w(oVar);
            this.type_ = i2.o();
            i2 = this.type_.v0();
            if (i4 != 34) {
            } else {
            }
            if (bitField0_4 &= i5 == i5) {
            }
            oVar2 = e.u(q.b, f2);
            this.varargElementType_ = (q)oVar2;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_5 |= i5;
            i2.w(oVar2);
            this.varargElementType_ = i2.o();
            i2 = this.varargElementType_.v0();
            if (i4 != 40) {
            } else {
            }
            this.bitField0_ = bitField0_2 |= i;
            this.typeId_ = e.s();
            if (i4 != 48) {
            } else {
            }
            this.bitField0_ = bitField0_3 |= 32;
            this.varargElementTypeId_ = e.s();
            if (!j(e, outputStream, f2, i4)) {
            }
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    u(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private u(h.c<kotlin.i0.z.e.m0.e.u, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    u(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private u(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static int A(kotlin.i0.z.e.m0.e.u u, int i2) {
        u.bitField0_ = i2;
        return i2;
    }

    static d B(kotlin.i0.z.e.m0.e.u u) {
        return u.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.u C() {
        return u.a;
    }

    private void Q() {
        final int i = 0;
        this.flags_ = i;
        this.name_ = i;
        this.type_ = q.R();
        this.typeId_ = i;
        this.varargElementType_ = q.R();
        this.varargElementTypeId_ = i;
    }

    public static kotlin.i0.z.e.m0.e.u.b R() {
        return u.b.m();
    }

    public static kotlin.i0.z.e.m0.e.u.b S(kotlin.i0.z.e.m0.e.u u) {
        final kotlin.i0.z.e.m0.e.u.b bVar = u.R();
        bVar.t(u);
        return bVar;
    }

    static int u(kotlin.i0.z.e.m0.e.u u, int i2) {
        u.flags_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.u u, int i2) {
        u.name_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q w(kotlin.i0.z.e.m0.e.u u, kotlin.i0.z.e.m0.e.q q2) {
        u.type_ = q2;
        return q2;
    }

    static int x(kotlin.i0.z.e.m0.e.u u, int i2) {
        u.typeId_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.q y(kotlin.i0.z.e.m0.e.u u, kotlin.i0.z.e.m0.e.q q2) {
        u.varargElementType_ = q2;
        return q2;
    }

    static int z(kotlin.i0.z.e.m0.e.u u, int i2) {
        u.varargElementTypeId_ = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u D() {
        return u.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int E() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int F() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q G() {
        return this.type_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int H() {
        return this.typeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q I() {
        return this.varargElementType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int J() {
        return this.varargElementTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean K() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean L() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean M() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean N() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean O() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean P() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u.b T() {
        return u.R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u.b U() {
        return u.S(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int name_;
        int i3;
        int varargElementType_;
        int i;
        int i2;
        int typeId_;
        int varargElementTypeId_;
        kotlin.i0.z.e.m0.e.q type_;
        getSerializedSize();
        int i5 = 1;
        if (bitField0_ &= i5 == i5) {
            codedOutputStream.a0(i5, this.flags_);
        }
        int i6 = 2;
        if (bitField0_2 &= i6 == i6) {
            codedOutputStream.a0(i6, this.name_);
        }
        int i7 = 4;
        if (bitField0_3 &= i7 == i7) {
            codedOutputStream.d0(3, this.type_);
        }
        int i8 = 16;
        if (bitField0_4 &= i8 == i8) {
            codedOutputStream.d0(i7, this.varargElementType_);
        }
        typeId_ = 8;
        if (bitField0_5 &= typeId_ == typeId_) {
            codedOutputStream.a0(5, this.typeId_);
        }
        varargElementTypeId_ = 32;
        if (bitField0_6 &= varargElementTypeId_ == varargElementTypeId_) {
            codedOutputStream.a0(6, this.varargElementTypeId_);
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return D();
    }

    public q<kotlin.i0.z.e.m0.e.u> getParserForType() {
        return u.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i3;
        int i6;
        int i2;
        int i7;
        int i4;
        int i5;
        int i;
        int typeId_;
        int varargElementTypeId_;
        kotlin.i0.z.e.m0.e.q type_;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i15 = 1;
        if (bitField0_ &= i15 == i15) {
            i3 += i6;
        }
        int i16 = 2;
        if (bitField0_2 &= i16 == i16) {
            i3 += i2;
        }
        int i17 = 4;
        if (bitField0_3 &= i17 == i17) {
            i3 += i7;
        }
        int i18 = 16;
        if (bitField0_4 &= i18 == i18) {
            i3 += i4;
        }
        typeId_ = 8;
        if (bitField0_5 &= typeId_ == typeId_) {
            i3 += i5;
        }
        varargElementTypeId_ = 32;
        if (bitField0_6 &= varargElementTypeId_ == varargElementTypeId_) {
            i3 += i;
        }
        i8 += size;
        this.memoizedSerializedSize = i9;
        return i9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        boolean initialized2;
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
        if (!L()) {
            this.memoizedIsInitialized = i2;
            return i2;
        }
        if (M() && !G().isInitialized()) {
            if (!G().isInitialized()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
        }
        if (O() && !I().isInitialized()) {
            if (!I().isInitialized()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
        }
        if (!m()) {
            this.memoizedIsInitialized = i2;
            return i2;
        }
        this.memoizedIsInitialized = i;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return U();
    }
}
