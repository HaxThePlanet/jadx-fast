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
public final class s extends h.d<kotlin.i0.z.e.m0.e.s> implements p {

    private static final kotlin.i0.z.e.m0.e.s a;
    public static q<kotlin.i0.z.e.m0.e.s> b;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final d unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<kotlin.i0.z.e.m0.e.q> upperBound_;
    private kotlin.i0.z.e.m0.e.s.c variance_;

    public static enum c implements i.a {

        IN(false, false),
        OUT(true, true),
        INV(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.s.c valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return s.c.INV;
                }
                return s.c.OUT;
            }
            return s.c.IN;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    static class a extends b<kotlin.i0.z.e.m0.e.s> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.s m(e e, f f2) {
            s sVar = new s(e, f2, 0);
            return sVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.s, kotlin.i0.z.e.m0.e.s.b> implements p {

        private List<kotlin.i0.z.e.m0.e.q> A;
        private List<Integer> B;
        private int v;
        private int w;
        private int x;
        private boolean y;
        private kotlin.i0.z.e.m0.e.s.c z;
        private b() {
            super();
            this.z = s.c.INV;
            this.A = Collections.emptyList();
            this.B = Collections.emptyList();
            u();
        }

        static kotlin.i0.z.e.m0.e.s.b m() {
            return s.b.r();
        }

        private static kotlin.i0.z.e.m0.e.s.b r() {
            s.b bVar = new s.b();
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
            final int i4 = 16;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.A);
                this.A = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b A(kotlin.i0.z.e.m0.e.s.c s$c) {
            Objects.requireNonNull(c);
            this.v = i |= 8;
            this.z = c;
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
            v((s)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            w(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s n() {
            kotlin.i0.z.e.m0.e.s sVar = o();
            if (!sVar.isInitialized()) {
            } else {
                return sVar;
            }
            throw a.a.c(sVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s o() {
            int i;
            int i3;
            int i2;
            s sVar = new s(this, 0);
            int i5 = this.v;
            if (i5 & 1 == 1) {
            } else {
                i2 = 0;
            }
            s.u(sVar, this.w);
            if (i5 & 2 == 2) {
                i2 |= 2;
            }
            s.v(sVar, this.x);
            if (i5 & 4 == 4) {
                i2 |= 4;
            }
            s.w(sVar, this.y);
            int i16 = 8;
            if (i5 &= i16 == i16) {
                i2 |= 8;
            }
            s.x(sVar, this.z);
            int i17 = 16;
            if (i7 &= i17 == i17) {
                this.A = Collections.unmodifiableList(this.A);
                this.v = i10 &= -17;
            }
            s.z(sVar, this.A);
            int i18 = 32;
            if (i8 &= i18 == i18) {
                this.B = Collections.unmodifiableList(this.B);
                this.v = i9 &= -33;
            }
            s.B(sVar, this.B);
            s.C(sVar, i2);
            return sVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b p() {
            final kotlin.i0.z.e.m0.e.s.b bVar = s.b.r();
            bVar.v(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b v(kotlin.i0.z.e.m0.e.s s) {
            boolean z2;
            boolean z4;
            boolean z3;
            boolean z;
            boolean empty;
            boolean empty2;
            List list;
            if (s == s.E()) {
                return this;
            }
            if (s.O()) {
                x(s.G());
            }
            if (s.P()) {
                y(s.H());
            }
            if (s.Q()) {
                z(s.I());
            }
            if (s.R()) {
                A(s.N());
            }
            if (!s.y(s).isEmpty()) {
                if (this.A.isEmpty()) {
                    this.A = s.y(s);
                    this.v = i &= -17;
                } else {
                    t();
                    this.A.addAll(s.y(s));
                }
            }
            if (!s.A(s).isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = s.A(s);
                    this.v = i2 &= -33;
                } else {
                    s();
                    this.B.addAll(s.A(s));
                }
            }
            l(s);
            g(e().d(s.D(s)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b w(e e, f f2) {
            final int i = 0;
            final Object obj3 = s.b.b(e, f2);
            if ((s)obj3 != null) {
                try {
                    v((s)obj3);
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
        public kotlin.i0.z.e.m0.e.s.b x(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b y(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.s.b z(boolean z) {
            this.v = i |= 4;
            this.y = z;
            return this;
        }
    }
    static {
        s.a aVar = new s.a();
        s.b = aVar;
        s sVar = new s(1);
        s.a = sVar;
        sVar.S();
    }

    private s(e e, f f2) {
        int i2;
        int i;
        f fVar;
        f fVar2;
        int upperBoundId_2;
        int arrayList;
        int arrayList2;
        int valueOf3;
        int upperBoundId_;
        int valueOf2;
        kotlin.i0.z.e.m0.e.s.c valueOf;
        int obj12;
        super();
        int i3 = -1;
        this.upperBoundIdMemoizedSerializedSize = i3;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        S();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i = i2;
        fVar = 16;
        fVar2 = 32;
        while (i2 == 0) {
            upperBoundId_2 = e.K();
            if (upperBoundId_2 != 0) {
            } else {
            }
            i2 = i4;
            fVar = 16;
            fVar2 = 32;
            valueOf3 = 8;
            if (upperBoundId_2 != valueOf3) {
            } else {
            }
            this.bitField0_ = bitField0_4 |= i4;
            this.id_ = e.s();
            if (upperBoundId_2 != fVar) {
            } else {
            }
            this.bitField0_ = bitField0_ |= 2;
            this.name_ = e.s();
            if (upperBoundId_2 != 24) {
            } else {
            }
            this.bitField0_ = bitField0_3 |= 4;
            this.reified_ = e.k();
            if (upperBoundId_2 != fVar2) {
            } else {
            }
            valueOf2 = e.n();
            valueOf = s.c.valueOf(valueOf2);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_2 |= valueOf3;
            this.variance_ = valueOf;
            outputStream.o0(upperBoundId_2);
            outputStream.o0(valueOf2);
            if (upperBoundId_2 != 42) {
            } else {
            }
            if (i & 16 != fVar) {
            }
            this.upperBound_.add(e.u(q.b, f2));
            arrayList = new ArrayList();
            this.upperBound_ = arrayList;
            i |= 16;
            if (upperBoundId_2 != 48) {
            } else {
            }
            if (i & 32 != fVar2) {
            }
            this.upperBoundId_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            this.upperBoundId_ = arrayList2;
            i |= 32;
            if (upperBoundId_2 != 50) {
            } else {
            }
            if (i & 32 != fVar2 && e.e() > 0) {
            }
            while (e.e() > 0) {
                this.upperBoundId_.add(Integer.valueOf(e.s()));
            }
            e.i(e.j(e.A()));
            this.upperBoundId_.add(Integer.valueOf(e.s()));
            if (e.e() > 0) {
            }
            upperBoundId_ = new ArrayList();
            this.upperBoundId_ = upperBoundId_;
            i |= 32;
            if (!j(e, outputStream, f2, upperBoundId_2)) {
            }
        }
        if (i & 16 == fVar) {
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if (i & 32 == fVar2) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    s(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private s(h.c<kotlin.i0.z.e.m0.e.s, ?> h$c) {
        super(c);
        final int i = -1;
        this.upperBoundIdMemoizedSerializedSize = i;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    s(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private s(boolean z) {
        super();
        int obj1 = -1;
        this.upperBoundIdMemoizedSerializedSize = obj1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List A(kotlin.i0.z.e.m0.e.s s) {
        return s.upperBoundId_;
    }

    static List B(kotlin.i0.z.e.m0.e.s s, List list2) {
        s.upperBoundId_ = list2;
        return list2;
    }

    static int C(kotlin.i0.z.e.m0.e.s s, int i2) {
        s.bitField0_ = i2;
        return i2;
    }

    static d D(kotlin.i0.z.e.m0.e.s s) {
        return s.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.s E() {
        return s.a;
    }

    private void S() {
        int i = 0;
        this.id_ = i;
        this.name_ = i;
        this.reified_ = i;
        this.variance_ = s.c.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.s.b T() {
        return s.b.m();
    }

    public static kotlin.i0.z.e.m0.e.s.b U(kotlin.i0.z.e.m0.e.s s) {
        final kotlin.i0.z.e.m0.e.s.b bVar = s.T();
        bVar.v(s);
        return bVar;
    }

    static int u(kotlin.i0.z.e.m0.e.s s, int i2) {
        s.id_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.s s, int i2) {
        s.name_ = i2;
        return i2;
    }

    static boolean w(kotlin.i0.z.e.m0.e.s s, boolean z2) {
        s.reified_ = z2;
        return z2;
    }

    static kotlin.i0.z.e.m0.e.s.c x(kotlin.i0.z.e.m0.e.s s, kotlin.i0.z.e.m0.e.s.c s$c2) {
        s.variance_ = c2;
        return c2;
    }

    static List y(kotlin.i0.z.e.m0.e.s s) {
        return s.upperBound_;
    }

    static List z(kotlin.i0.z.e.m0.e.s s, List list2) {
        s.upperBound_ = list2;
        return list2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s F() {
        return s.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int G() {
        return this.id_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int H() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean I() {
        return this.reified_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q J(int i) {
        return (q)this.upperBound_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int K() {
        return this.upperBound_.size();
    }

    public List<Integer> L() {
        return this.upperBoundId_;
    }

    public List<kotlin.i0.z.e.m0.e.q> M() {
        return this.upperBound_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s.c N() {
        return this.variance_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean O() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean P() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean Q() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean R() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s.b V() {
        return s.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s.b W() {
        return s.U(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int id_;
        int name_;
        int i4;
        int number;
        int i;
        int i2;
        int upperBoundIdMemoizedSerializedSize;
        boolean reified_;
        int i3;
        Object obj;
        getSerializedSize();
        int i6 = 1;
        if (bitField0_ &= i6 == i6) {
            codedOutputStream.a0(i6, this.id_);
        }
        int i7 = 2;
        if (bitField0_2 &= i7 == i7) {
            codedOutputStream.a0(i7, this.name_);
        }
        int i8 = 4;
        if (bitField0_3 &= i8 == i8) {
            codedOutputStream.L(3, this.reified_);
        }
        i3 = 8;
        if (bitField0_4 &= i3 == i3) {
            codedOutputStream.S(i8, this.variance_.getNumber());
        }
        i2 = i;
        while (i2 < this.upperBound_.size()) {
            codedOutputStream.d0(5, (o)this.upperBound_.get(i2));
            i2++;
        }
        if (L().size() > 0) {
            codedOutputStream.o0(50);
            codedOutputStream.o0(this.upperBoundIdMemoizedSerializedSize);
        }
        while (i < this.upperBoundId_.size()) {
            codedOutputStream.b0((Integer)this.upperBoundId_.get(i).intValue());
            i++;
        }
        s().a(1000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return F();
    }

    public q<kotlin.i0.z.e.m0.e.s> getParserForType() {
        return s.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i8;
        int i4;
        int i;
        int i7;
        int i9;
        int i6;
        int i10;
        int i5;
        boolean empty;
        int i2;
        int size;
        boolean reified_;
        int i3;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i17 = 1;
        i5 = 0;
        if (bitField0_ &= i17 == i17) {
            i12 += i5;
        } else {
            i8 = i5;
        }
        int i20 = 2;
        if (bitField0_2 &= i20 == i20) {
            i8 += i;
        }
        i2 = 4;
        if (bitField0_3 &= i2 == i2) {
            i8 += i7;
        }
        i3 = 8;
        if (bitField0_4 &= i3 == i3) {
            i8 += i9;
        }
        i6 = i5;
        while (i6 < this.upperBound_.size()) {
            i8 += i2;
            i6++;
        }
        i10 = i5;
        while (i5 < this.upperBoundId_.size()) {
            i10 += size;
            i5++;
        }
        if (!L().isEmpty()) {
            i13 += empty;
        }
        this.upperBoundIdMemoizedSerializedSize = i10;
        i14 += size2;
        this.memoizedSerializedSize = i15;
        return i15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        int i;
        boolean initialized;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i2 = 1;
        if (memoizedIsInitialized == i2) {
            return i2;
        }
        final int i3 = 0;
        if (memoizedIsInitialized == 0) {
            return i3;
        }
        if (!O()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        if (!P()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        i = i3;
        while (i < K()) {
            i++;
        }
        if (!m()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return W();
    }
}
