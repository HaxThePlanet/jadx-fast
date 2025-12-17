package kotlin.i0.z.e.m0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import kotlin.reflect.jvm.internal.impl.protobuf.i.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.b;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes3.dex */
public final class h extends h implements p {

    private static final kotlin.i0.z.e.m0.e.h a;
    public static q<kotlin.i0.z.e.m0.e.h> b;
    private List<kotlin.i0.z.e.m0.e.h> andArgument_;
    private int bitField0_;
    private kotlin.i0.z.e.m0.e.h.c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private kotlin.i0.z.e.m0.e.q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<kotlin.i0.z.e.m0.e.h> orArgument_;
    private final d unknownFields;
    private int valueParameterReference_;

    public static enum c implements i.a {

        TRUE(false, false),
        FALSE(true, true),
        NULL(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.h.c valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return h.c.NULL;
                }
                return h.c.FALSE;
            }
            return h.c.TRUE;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    static class a extends b<kotlin.i0.z.e.m0.e.h> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.h m(e e, f f2) {
            h hVar = new h(e, f2, 0);
            return hVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.h, kotlin.i0.z.e.m0.e.h.b> implements p {

        private List<kotlin.i0.z.e.m0.e.h> A;
        private int b;
        private int c;
        private int v;
        private kotlin.i0.z.e.m0.e.h.c w;
        private kotlin.i0.z.e.m0.e.q x;
        private int y;
        private List<kotlin.i0.z.e.m0.e.h> z;
        private b() {
            super();
            this.w = h.c.TRUE;
            this.x = q.R();
            this.z = Collections.emptyList();
            this.A = Collections.emptyList();
            p();
        }

        static kotlin.i0.z.e.m0.e.h.b h() {
            return h.b.m();
        }

        private static kotlin.i0.z.e.m0.e.h.b m() {
            h.b bVar = new h.b();
            return bVar;
        }

        private void n() {
            int i;
            List list;
            final int i4 = 32;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.z);
                this.z = arrayList;
                this.b = i3 |= i4;
            }
        }

        private void o() {
            int i;
            List list;
            final int i4 = 64;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.A);
                this.A = arrayList;
                this.b = i3 |= i4;
            }
        }

        private void p() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public a.a b(e e, f f2) {
            s(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o build() {
            return j();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public Object clone() {
            return l();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public h.b d() {
            return l();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public h.b f(h h) {
            r((h)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h j() {
            kotlin.i0.z.e.m0.e.h hVar = k();
            if (!hVar.isInitialized()) {
            } else {
                return hVar;
            }
            throw a.a.c(hVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            s(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h k() {
            int i3;
            int i;
            int i2;
            h hVar = new h(this, 0);
            int i5 = this.b;
            if (i5 & 1 == 1) {
            } else {
                i2 = 0;
            }
            h.l(hVar, this.c);
            if (i5 & 2 == 2) {
                i2 |= 2;
            }
            h.m(hVar, this.v);
            if (i5 & 4 == 4) {
                i2 |= 4;
            }
            h.n(hVar, this.w);
            if (i5 & 8 == 8) {
                i2 |= 8;
            }
            h.o(hVar, this.x);
            int i18 = 16;
            if (i5 &= i18 == i18) {
                i2 |= 16;
            }
            h.p(hVar, this.y);
            int i19 = 32;
            if (i8 &= i19 == i19) {
                this.z = Collections.unmodifiableList(this.z);
                this.b = i9 &= -33;
            }
            h.r(hVar, this.z);
            int i20 = 64;
            if (i10 &= i20 == i20) {
                this.A = Collections.unmodifiableList(this.A);
                this.b = i11 &= -65;
            }
            h.t(hVar, this.A);
            h.u(hVar, i2);
            return hVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b l() {
            final kotlin.i0.z.e.m0.e.h.b bVar = h.b.m();
            bVar.r(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b r(kotlin.i0.z.e.m0.e.h h) {
            boolean z4;
            boolean z3;
            boolean z;
            boolean z2;
            boolean z5;
            boolean empty;
            boolean empty2;
            List list;
            if (h == h.z()) {
                return this;
            }
            if (h.H()) {
                v(h.A());
            }
            if (h.K()) {
                x(h.F());
            }
            if (h.G()) {
                u(h.y());
            }
            if (h.I()) {
                t(h.B());
            }
            if (h.J()) {
                w(h.C());
            }
            if (!h.q(h).isEmpty()) {
                if (this.z.isEmpty()) {
                    this.z = h.q(h);
                    this.b = i &= -33;
                } else {
                    n();
                    this.z.addAll(h.q(h));
                }
            }
            if (!h.s(h).isEmpty()) {
                if (this.A.isEmpty()) {
                    this.A = h.s(h);
                    this.b = i2 &= -65;
                } else {
                    o();
                    this.A.addAll(h.s(h));
                }
            }
            g(e().d(h.v(h)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b s(e e, f f2) {
            final int i = 0;
            final Object obj3 = h.b.b(e, f2);
            if ((h)obj3 != null) {
                try {
                    r((h)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    r(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b t(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 8;
            if (i2 &= i3 == i3 && this.x != q.R()) {
                if (this.x != q.R()) {
                    this.x = q.t0(this.x).w(q).o();
                } else {
                    this.x = q;
                }
            } else {
            }
            this.b = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b u(kotlin.i0.z.e.m0.e.h.c h$c) {
            Objects.requireNonNull(c);
            this.b = i |= 4;
            this.w = c;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b v(int i) {
            this.b = i2 |= 1;
            this.c = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b w(int i) {
            this.b = i2 |= 16;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.h.b x(int i) {
            this.b = i2 |= 2;
            this.v = i;
            return this;
        }
    }
    static {
        h.a aVar = new h.a();
        h.b = aVar;
        h hVar = new h(1);
        h.a = hVar;
        hVar.L();
    }

    private h(e e, f f2) {
        int i;
        int i3;
        f fVar;
        f fVar2;
        int andArgument_;
        int arrayList;
        int arrayList2;
        int i2;
        int i4;
        int valueOf;
        int i5;
        int obj12;
        super();
        int i6 = -1;
        this.memoizedIsInitialized = i6;
        this.memoizedSerializedSize = i6;
        L();
        d.b bVar = d.w();
        final int i7 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i7);
        i3 = i;
        fVar = 64;
        fVar2 = 32;
        while (i == 0) {
            andArgument_ = e.K();
            if (andArgument_ != 0) {
            } else {
            }
            i = i7;
            fVar = 64;
            fVar2 = 32;
            i4 = 8;
            if (andArgument_ != i4) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i7;
            this.flags_ = e.s();
            valueOf = 16;
            if (andArgument_ != valueOf) {
            } else {
            }
            this.bitField0_ = bitField0_2 |= 2;
            this.valueParameterReference_ = e.s();
            if (andArgument_ != 24) {
            } else {
            }
            i4 = e.n();
            valueOf = h.c.valueOf(i4);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_5 |= 4;
            this.constantValue_ = valueOf;
            outputStream.o0(andArgument_);
            outputStream.o0(i4);
            if (andArgument_ != 34) {
            } else {
            }
            i2 = 0;
            if (bitField0_6 &= i4 == i4) {
            }
            valueOf = e.u(q.b, f2);
            this.isInstanceType_ = (q)valueOf;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_4 |= i4;
            i2.w(valueOf);
            this.isInstanceType_ = i2.o();
            i2 = this.isInstanceType_.v0();
            if (andArgument_ != 40) {
            } else {
            }
            this.bitField0_ = bitField0_3 |= valueOf;
            this.isInstanceTypeId_ = e.s();
            if (andArgument_ != 50) {
            } else {
            }
            if (i3 & 32 != fVar2) {
            }
            this.andArgument_.add(e.u(h.b, f2));
            arrayList2 = new ArrayList();
            this.andArgument_ = arrayList2;
            i3 |= 32;
            if (andArgument_ != 58) {
            } else {
            }
            if (i3 & 64 != fVar) {
            }
            this.orArgument_.add(e.u(h.b, f2));
            arrayList = new ArrayList();
            this.orArgument_ = arrayList;
            i3 |= 64;
            if (!j(e, outputStream, f2, andArgument_)) {
            }
        }
        if (i3 & 32 == fVar2) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if (i3 & 64 == fVar) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    h(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private h(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    h(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private h(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    private void L() {
        int i = 0;
        this.flags_ = i;
        this.valueParameterReference_ = i;
        this.constantValue_ = h.c.TRUE;
        this.isInstanceType_ = q.R();
        this.isInstanceTypeId_ = i;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.h.b M() {
        return h.b.h();
    }

    public static kotlin.i0.z.e.m0.e.h.b N(kotlin.i0.z.e.m0.e.h h) {
        final kotlin.i0.z.e.m0.e.h.b bVar = h.M();
        bVar.r(h);
        return bVar;
    }

    static int l(kotlin.i0.z.e.m0.e.h h, int i2) {
        h.flags_ = i2;
        return i2;
    }

    static int m(kotlin.i0.z.e.m0.e.h h, int i2) {
        h.valueParameterReference_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.h.c n(kotlin.i0.z.e.m0.e.h h, kotlin.i0.z.e.m0.e.h.c h$c2) {
        h.constantValue_ = c2;
        return c2;
    }

    static kotlin.i0.z.e.m0.e.q o(kotlin.i0.z.e.m0.e.h h, kotlin.i0.z.e.m0.e.q q2) {
        h.isInstanceType_ = q2;
        return q2;
    }

    static int p(kotlin.i0.z.e.m0.e.h h, int i2) {
        h.isInstanceTypeId_ = i2;
        return i2;
    }

    static List q(kotlin.i0.z.e.m0.e.h h) {
        return h.andArgument_;
    }

    static List r(kotlin.i0.z.e.m0.e.h h, List list2) {
        h.andArgument_ = list2;
        return list2;
    }

    static List s(kotlin.i0.z.e.m0.e.h h) {
        return h.orArgument_;
    }

    static List t(kotlin.i0.z.e.m0.e.h h, List list2) {
        h.orArgument_ = list2;
        return list2;
    }

    static int u(kotlin.i0.z.e.m0.e.h h, int i2) {
        h.bitField0_ = i2;
        return i2;
    }

    static d v(kotlin.i0.z.e.m0.e.h h) {
        return h.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.h z() {
        return h.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int A() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.q B() {
        return this.isInstanceType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int C() {
        return this.isInstanceTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h D(int i) {
        return (h)this.orArgument_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int E() {
        return this.orArgument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int F() {
        return this.valueParameterReference_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean G() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean H() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean I() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean J() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean K() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h.b O() {
        return h.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h.b P() {
        return h.N(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int valueParameterReference_;
        int i4;
        int isInstanceType_;
        int i2;
        int i3;
        int isInstanceTypeId_;
        int i5;
        int number;
        int i;
        int size;
        Object obj;
        getSerializedSize();
        int i6 = 1;
        if (bitField0_ &= i6 == i6) {
            codedOutputStream.a0(i6, this.flags_);
        }
        int i7 = 2;
        if (bitField0_2 &= i7 == i7) {
            codedOutputStream.a0(i7, this.valueParameterReference_);
        }
        int i8 = 4;
        if (bitField0_3 &= i8 == i8) {
            codedOutputStream.S(3, this.constantValue_.getNumber());
        }
        i = 8;
        if (bitField0_4 &= i == i) {
            codedOutputStream.d0(i8, this.isInstanceType_);
        }
        isInstanceTypeId_ = 16;
        if (bitField0_5 &= isInstanceTypeId_ == isInstanceTypeId_) {
            codedOutputStream.a0(5, this.isInstanceTypeId_);
        }
        i5 = i3;
        while (i5 < this.andArgument_.size()) {
            codedOutputStream.d0(6, (o)this.andArgument_.get(i5));
            i5++;
        }
        while (i3 < this.orArgument_.size()) {
            codedOutputStream.d0(7, (o)this.orArgument_.get(i3));
            i3++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.h> getParserForType() {
        return h.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i6;
        int i;
        int i5;
        int i7;
        int i4;
        int i2;
        int i3;
        int isInstanceTypeId_;
        int size;
        int number;
        int i8;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i13 = 1;
        i3 = 0;
        if (bitField0_ &= i13 == i13) {
            i10 += i3;
        } else {
            i6 = i3;
        }
        int i17 = 2;
        if (bitField0_2 &= i17 == i17) {
            i6 += i;
        }
        int i18 = 4;
        if (bitField0_3 &= i18 == i18) {
            i6 += i5;
        }
        i8 = 8;
        if (bitField0_4 &= i8 == i8) {
            i6 += i7;
        }
        isInstanceTypeId_ = 16;
        if (bitField0_5 &= isInstanceTypeId_ == isInstanceTypeId_) {
            i6 += i4;
        }
        i2 = i3;
        while (i2 < this.andArgument_.size()) {
            i6 += isInstanceTypeId_;
            i2++;
        }
        while (i3 < this.orArgument_.size()) {
            i6 += i2;
            i3++;
        }
        i6 += size3;
        this.memoizedSerializedSize = i11;
        return i11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public final boolean isInitialized() {
        boolean initialized;
        int i;
        int i2;
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
        if (I() && !B().isInitialized()) {
            if (!B().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        i = i4;
        while (i < x()) {
            i++;
        }
        i2 = i4;
        while (i2 < E()) {
            i2++;
        }
        this.memoizedIsInitialized = i3;
        return i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a newBuilderForType() {
        return O();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h w(int i) {
        return (h)this.andArgument_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int x() {
        return this.andArgument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h.c y() {
        return this.constantValue_;
    }
}
