package kotlin.i0.z.e.m0.e;

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
public final class r extends h.d<kotlin.i0.z.e.m0.e.r> implements p {

    private static final kotlin.i0.z.e.m0.e.r a;
    public static q<kotlin.i0.z.e.m0.e.r> b;
    private List<kotlin.i0.z.e.m0.e.b> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private kotlin.i0.z.e.m0.e.q expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<kotlin.i0.z.e.m0.e.s> typeParameter_;
    private int underlyingTypeId_;
    private kotlin.i0.z.e.m0.e.q underlyingType_;
    private final d unknownFields;
    private List<Integer> versionRequirement_;

    static class a extends b<kotlin.i0.z.e.m0.e.r> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.r m(e e, f f2) {
            r rVar = new r(e, f2, 0);
            return rVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.r, kotlin.i0.z.e.m0.e.r.b> implements p {

        private int A;
        private kotlin.i0.z.e.m0.e.q B;
        private int C;
        private List<kotlin.i0.z.e.m0.e.b> D;
        private List<Integer> E;
        private int v;
        private int w = 6;
        private int x;
        private List<kotlin.i0.z.e.m0.e.s> y;
        private kotlin.i0.z.e.m0.e.q z;
        private b() {
            super();
            int i = 6;
            this.y = Collections.emptyList();
            this.z = q.R();
            this.B = q.R();
            this.D = Collections.emptyList();
            this.E = Collections.emptyList();
            v();
        }

        static kotlin.i0.z.e.m0.e.r.b m() {
            return r.b.r();
        }

        private static kotlin.i0.z.e.m0.e.r.b r() {
            r.b bVar = new r.b();
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
            final int i4 = 4;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.y);
                this.y = arrayList;
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
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b A(int i) {
            this.v = i2 |= 64;
            this.C = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b B(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b C(int i) {
            this.v = i2 |= 2;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b D(int i) {
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
            x((r)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            y(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r n() {
            kotlin.i0.z.e.m0.e.r rVar = o();
            if (!rVar.isInitialized()) {
            } else {
                return rVar;
            }
            throw a.a.c(rVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r o() {
            int i2;
            int i;
            int i4;
            int i3;
            r rVar = new r(this, 0);
            int i6 = this.v;
            if (i6 & 1 == 1) {
            } else {
                i3 = 0;
            }
            r.u(rVar, this.w);
            if (i6 & 2 == 2) {
                i3 |= 2;
            }
            r.v(rVar, this.x);
            int i27 = 4;
            if (i17 &= i27 == i27) {
                this.y = Collections.unmodifiableList(this.y);
                this.v = i18 &= -5;
            }
            r.x(rVar, this.y);
            if (i6 & 8 == 8) {
                i3 |= 4;
            }
            r.y(rVar, this.z);
            if (i6 & 16 == 16) {
                i3 |= 8;
            }
            r.z(rVar, this.A);
            if (i6 & 32 == 32) {
                i3 |= 16;
            }
            r.A(rVar, this.B);
            int i23 = 64;
            if (i6 &= i23 == i23) {
                i3 |= 32;
            }
            r.B(rVar, this.C);
            int i24 = 128;
            if (i9 &= i24 == i24) {
                this.D = Collections.unmodifiableList(this.D);
                this.v = i12 &= -129;
            }
            r.D(rVar, this.D);
            int i25 = 256;
            if (i10 &= i25 == i25) {
                this.E = Collections.unmodifiableList(this.E);
                this.v = i11 &= -257;
            }
            r.F(rVar, this.E);
            r.G(rVar, i3);
            return rVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b p() {
            final kotlin.i0.z.e.m0.e.r.b bVar = r.b.r();
            bVar.x(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b w(kotlin.i0.z.e.m0.e.q q) {
            int i;
            kotlin.i0.z.e.m0.e.q qVar;
            kotlin.i0.z.e.m0.e.q obj4;
            final int i3 = 32;
            if (i2 &= i3 == i3 && this.B != q.R()) {
                if (this.B != q.R()) {
                    this.B = q.t0(this.B).w(q).o();
                } else {
                    this.B = q;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b x(kotlin.i0.z.e.m0.e.r r) {
            boolean z;
            boolean z2;
            boolean empty3;
            boolean z5;
            boolean z3;
            boolean z6;
            boolean z4;
            boolean empty2;
            boolean empty;
            List list;
            if (r == r.L()) {
                return this;
            }
            if (r.Z()) {
                B(r.P());
            }
            if (r.a0()) {
                C(r.Q());
            }
            if (!r.w(r).isEmpty()) {
                if (this.y.isEmpty()) {
                    this.y = r.w(r);
                    this.v = i &= -5;
                } else {
                    t();
                    this.y.addAll(r.w(r));
                }
            }
            if (r.b0()) {
                z(r.U());
            }
            if (r.c0()) {
                D(r.V());
            }
            if (r.X()) {
                w(r.N());
            }
            if (r.Y()) {
                A(r.O());
            }
            if (!r.C(r).isEmpty()) {
                if (this.D.isEmpty()) {
                    this.D = r.C(r);
                    this.v = i3 &= -129;
                } else {
                    s();
                    this.D.addAll(r.C(r));
                }
            }
            if (!r.E(r).isEmpty()) {
                if (this.E.isEmpty()) {
                    this.E = r.E(r);
                    this.v = i2 &= -257;
                } else {
                    u();
                    this.E.addAll(r.E(r));
                }
            }
            l(r);
            g(e().d(r.H(r)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.r.b y(e e, f f2) {
            final int i = 0;
            final Object obj3 = r.b.b(e, f2);
            if ((r)obj3 != null) {
                try {
                    x((r)obj3);
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
        public kotlin.i0.z.e.m0.e.r.b z(kotlin.i0.z.e.m0.e.q q) {
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
    }
    static {
        r.a aVar = new r.a();
        r.b = aVar;
        r rVar = new r(1);
        r.a = rVar;
        rVar.d0();
    }

    private r(e e, f f2) {
        void v2;
        int i2;
        int i;
        f fVar2;
        f fVar3;
        f fVar;
        int versionRequirement_2;
        int arrayList;
        int expandedType_;
        o oVar;
        int underlyingType_;
        o oVar2;
        int arrayList2;
        int arrayList3;
        int valueOf2;
        int versionRequirement_;
        int valueOf;
        int obj12;
        super();
        int i3 = -1;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        d0();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i = i2;
        fVar2 = 128;
        fVar3 = 256;
        fVar = 4;
        while (i2 == 0) {
            versionRequirement_2 = e.K();
            valueOf2 = 0;
            if (!j(e, outputStream, f2, versionRequirement_2)) {
            }
            fVar2 = 128;
            fVar3 = 256;
            fVar = 4;
            i2 = i4;
            if (i & 256 != fVar3 && e.e() > 0) {
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
            i |= 256;
            if (i & 256 != fVar3) {
            }
            this.versionRequirement_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            this.versionRequirement_ = arrayList2;
            i |= 256;
            if (i & 128 != fVar2) {
            }
            this.annotation_.add(e.u(b.b, f2));
            arrayList3 = new ArrayList();
            this.annotation_ = arrayList3;
            i |= 128;
            this.bitField0_ = bitField0_8 |= 32;
            this.expandedTypeId_ = e.s();
            valueOf = 16;
            if (bitField0_3 &= valueOf == valueOf) {
            }
            oVar = e.u(q.b, f2);
            this.expandedType_ = (q)oVar;
            if (valueOf2 != 0) {
            }
            this.bitField0_ = bitField0_4 |= valueOf;
            valueOf2.w(oVar);
            this.expandedType_ = valueOf2.o();
            valueOf2 = this.expandedType_.v0();
            this.bitField0_ = bitField0_ |= 8;
            this.underlyingTypeId_ = e.s();
            if (bitField0_5 &= fVar == fVar) {
            }
            oVar2 = e.u(q.b, f2);
            this.underlyingType_ = (q)oVar2;
            if (valueOf2 != 0) {
            }
            this.bitField0_ = bitField0_6 |= fVar;
            valueOf2.w(oVar2);
            this.underlyingType_ = valueOf2.o();
            valueOf2 = this.underlyingType_.v0();
            if (i & 4 != fVar) {
            }
            this.typeParameter_.add(e.u(s.b, f2));
            arrayList = new ArrayList();
            this.typeParameter_ = arrayList;
            i |= 4;
            this.bitField0_ = bitField0_2 |= 2;
            this.name_ = e.s();
            this.bitField0_ = bitField0_7 |= i4;
            this.flags_ = e.s();
        }
        if (i & 4 == fVar) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (i & 128 == fVar2) {
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        }
        if (i & 256 == fVar3) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    r(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private r(h.c<kotlin.i0.z.e.m0.e.r, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    r(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private r(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static kotlin.i0.z.e.m0.e.q A(kotlin.i0.z.e.m0.e.r r, kotlin.i0.z.e.m0.e.q q2) {
        r.expandedType_ = q2;
        return q2;
    }

    static int B(kotlin.i0.z.e.m0.e.r r, int i2) {
        r.expandedTypeId_ = i2;
        return i2;
    }

    static List C(kotlin.i0.z.e.m0.e.r r) {
        return r.annotation_;
    }

    static List D(kotlin.i0.z.e.m0.e.r r, List list2) {
        r.annotation_ = list2;
        return list2;
    }

    static List E(kotlin.i0.z.e.m0.e.r r) {
        return r.versionRequirement_;
    }

    static List F(kotlin.i0.z.e.m0.e.r r, List list2) {
        r.versionRequirement_ = list2;
        return list2;
    }

    static int G(kotlin.i0.z.e.m0.e.r r, int i2) {
        r.bitField0_ = i2;
        return i2;
    }

    static d H(kotlin.i0.z.e.m0.e.r r) {
        return r.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.r L() {
        return r.a;
    }

    private void d0() {
        this.flags_ = 6;
        int i2 = 0;
        this.name_ = i2;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = q.R();
        this.underlyingTypeId_ = i2;
        this.expandedType_ = q.R();
        this.expandedTypeId_ = i2;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.r.b e0() {
        return r.b.m();
    }

    public static kotlin.i0.z.e.m0.e.r.b f0(kotlin.i0.z.e.m0.e.r r) {
        final kotlin.i0.z.e.m0.e.r.b bVar = r.e0();
        bVar.x(r);
        return bVar;
    }

    public static kotlin.i0.z.e.m0.e.r h0(InputStream inputStream, f f2) {
        return (r)r.b.c(inputStream, f2);
    }

    static int u(kotlin.i0.z.e.m0.e.r r, int i2) {
        r.flags_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.r r, int i2) {
        r.name_ = i2;
        return i2;
    }

    static List w(kotlin.i0.z.e.m0.e.r r) {
        return r.typeParameter_;
    }

    static List x(kotlin.i0.z.e.m0.e.r r, List list2) {
        r.typeParameter_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.q y(kotlin.i0.z.e.m0.e.r r, kotlin.i0.z.e.m0.e.q q2) {
        r.underlyingType_ = q2;
        return q2;
    }

    static int z(kotlin.i0.z.e.m0.e.r r, int i2) {
        r.underlyingTypeId_ = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.b I(int i) {
        return (b)this.annotation_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int J() {
        return this.annotation_.size();
    }

    public List<kotlin.i0.z.e.m0.e.b> K() {
        return this.annotation_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.r M() {
        return r.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q N() {
        return this.expandedType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int O() {
        return this.expandedTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int P() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int Q() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.s R(int i) {
        return (s)this.typeParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int S() {
        return this.typeParameter_.size();
    }

    public List<kotlin.i0.z.e.m0.e.s> T() {
        return this.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.q U() {
        return this.underlyingType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int V() {
        return this.underlyingTypeId_;
    }

    public List<Integer> W() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean X() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean Y() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean Z() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int name_;
        int i4;
        int i5;
        int underlyingType_;
        int i3;
        int i7;
        int i2;
        int i;
        int i6;
        int intValue;
        Object underlyingTypeId_;
        int expandedType_;
        int expandedTypeId_;
        getSerializedSize();
        int i9 = 1;
        if (bitField0_ &= i9 == i9) {
            codedOutputStream.a0(i9, this.flags_);
        }
        int i10 = 2;
        if (bitField0_2 &= i10 == i10) {
            codedOutputStream.a0(i10, this.name_);
        }
        i4 = 0;
        i5 = i4;
        while (i5 < this.typeParameter_.size()) {
            codedOutputStream.d0(3, (o)this.typeParameter_.get(i5));
            i5++;
        }
        int i11 = 4;
        if (bitField0_3 &= i11 == i11) {
            codedOutputStream.d0(i11, this.underlyingType_);
        }
        intValue = 8;
        if (bitField0_4 &= intValue == intValue) {
            codedOutputStream.a0(5, this.underlyingTypeId_);
        }
        expandedType_ = 16;
        if (bitField0_5 &= expandedType_ == expandedType_) {
            codedOutputStream.d0(6, this.expandedType_);
        }
        expandedTypeId_ = 32;
        if (bitField0_6 &= expandedTypeId_ == expandedTypeId_) {
            codedOutputStream.a0(7, this.expandedTypeId_);
        }
        i = i4;
        while (i < this.annotation_.size()) {
            codedOutputStream.d0(intValue, (o)this.annotation_.get(i));
            i++;
        }
        while (i4 < this.versionRequirement_.size()) {
            codedOutputStream.a0(31, (Integer)this.versionRequirement_.get(i4).intValue());
            i4++;
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean a0() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean b0() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean c0() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.r.b g0() {
        return r.e0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return M();
    }

    public q<kotlin.i0.z.e.m0.e.r> getParserForType() {
        return r.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i12;
        int i8;
        int i5;
        int i7;
        int i10;
        int i11;
        int i6;
        int i4;
        int i9;
        int i2;
        int i;
        int i3;
        Object underlyingTypeId_;
        int expandedType_;
        int expandedTypeId_;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i20 = 1;
        i2 = 0;
        if (bitField0_ &= i20 == i20) {
            i14 += i2;
        } else {
            i12 = i2;
        }
        final int i26 = 2;
        if (bitField0_2 &= i26 == i26) {
            i12 += i8;
        }
        i5 = i2;
        while (i5 < this.typeParameter_.size()) {
            i12 += i;
            i5++;
        }
        int i28 = 4;
        if (bitField0_3 &= i28 == i28) {
            i12 += i7;
        }
        i3 = 8;
        if (bitField0_4 &= i3 == i3) {
            i12 += i10;
        }
        expandedType_ = 16;
        if (bitField0_5 &= expandedType_ == expandedType_) {
            i12 += i11;
        }
        expandedTypeId_ = 32;
        if (bitField0_6 &= expandedTypeId_ == expandedTypeId_) {
            i12 += i6;
        }
        i4 = i2;
        while (i4 < this.annotation_.size()) {
            i12 += expandedTypeId_;
            i4++;
        }
        i9 = i2;
        while (i2 < this.versionRequirement_.size()) {
            i9 += i3;
            i2++;
        }
        i17 += size2;
        this.memoizedSerializedSize = i18;
        return i18;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.r.b i0() {
        return r.f0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        int i2;
        boolean initialized;
        boolean initialized2;
        int i;
        boolean initialized4;
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
        if (!a0()) {
            this.memoizedIsInitialized = i4;
            return i4;
        }
        i2 = i4;
        while (i2 < S()) {
            i2++;
        }
        if (b0() && !U().isInitialized()) {
            if (!U().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        if (X() && !N().isInitialized()) {
            if (!N().isInitialized()) {
                this.memoizedIsInitialized = i4;
                return i4;
            }
        }
        i = i4;
        while (i < J()) {
            i++;
        }
        if (!m()) {
            this.memoizedIsInitialized = i4;
            return i4;
        }
        this.memoizedIsInitialized = i3;
        return i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return g0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return i0();
    }
}
