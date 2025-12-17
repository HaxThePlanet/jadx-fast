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
public final class l extends h.d<kotlin.i0.z.e.m0.e.l> implements p {

    private static final kotlin.i0.z.e.m0.e.l a;
    public static q<kotlin.i0.z.e.m0.e.l> b;
    private int bitField0_;
    private List<kotlin.i0.z.e.m0.e.i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<kotlin.i0.z.e.m0.e.n> property_;
    private List<kotlin.i0.z.e.m0.e.r> typeAlias_;
    private kotlin.i0.z.e.m0.e.t typeTable_;
    private final d unknownFields;
    private kotlin.i0.z.e.m0.e.w versionRequirementTable_;

    static class a extends b<kotlin.i0.z.e.m0.e.l> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.l m(e e, f f2) {
            l lVar = new l(e, f2, 0);
            return lVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.l, kotlin.i0.z.e.m0.e.l.b> implements p {

        private kotlin.i0.z.e.m0.e.w A;
        private int v;
        private List<kotlin.i0.z.e.m0.e.i> w;
        private List<kotlin.i0.z.e.m0.e.n> x;
        private List<kotlin.i0.z.e.m0.e.r> y;
        private kotlin.i0.z.e.m0.e.t z;
        private b() {
            super();
            this.w = Collections.emptyList();
            this.x = Collections.emptyList();
            this.y = Collections.emptyList();
            this.z = t.q();
            this.A = w.o();
            v();
        }

        static kotlin.i0.z.e.m0.e.l.b m() {
            return l.b.r();
        }

        private static kotlin.i0.z.e.m0.e.l.b r() {
            l.b bVar = new l.b();
            return bVar;
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
            int i;
            List list;
            final int i4 = 2;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.x);
                this.x = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void u() {
            int i;
            List list;
            final int i4 = 4;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.y);
                this.y = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void v() {
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
            w((l)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            x(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l n() {
            kotlin.i0.z.e.m0.e.l lVar = o();
            if (!lVar.isInitialized()) {
            } else {
                return lVar;
            }
            throw a.a.c(lVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l o() {
            int i2;
            int i3;
            int i;
            int i4;
            l lVar = new l(this, 0);
            int i6 = this.v;
            if (i6 & 1 == 1) {
                this.w = Collections.unmodifiableList(this.w);
                this.v = i14 &= -2;
            }
            l.v(lVar, this.w);
            int i15 = 2;
            if (i8 &= i15 == i15) {
                this.x = Collections.unmodifiableList(this.x);
                this.v = i9 &= -3;
            }
            l.x(lVar, this.x);
            int i16 = 4;
            if (i10 &= i16 == i16) {
                this.y = Collections.unmodifiableList(this.y);
                this.v = i13 &= -5;
            }
            l.z(lVar, this.y);
            if (i6 & 8 == 8) {
            } else {
                i4 = 0;
            }
            l.A(lVar, this.z);
            int i12 = 16;
            if (i6 &= i12 == i12) {
                i4 |= 2;
            }
            l.B(lVar, this.A);
            l.C(lVar, i4);
            return lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l.b p() {
            final kotlin.i0.z.e.m0.e.l.b bVar = l.b.r();
            bVar.w(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l.b w(kotlin.i0.z.e.m0.e.l l) {
            boolean empty;
            boolean empty3;
            boolean empty2;
            boolean z;
            boolean z2;
            List list;
            if (l == l.E()) {
                return this;
            }
            if (!l.u(l).isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = l.u(l);
                    this.v = i &= -2;
                } else {
                    s();
                    this.w.addAll(l.u(l));
                }
            }
            if (!l.w(l).isEmpty()) {
                if (this.x.isEmpty()) {
                    this.x = l.w(l);
                    this.v = i2 &= -3;
                } else {
                    t();
                    this.x.addAll(l.w(l));
                }
            }
            if (!l.y(l).isEmpty()) {
                if (this.y.isEmpty()) {
                    this.y = l.y(l);
                    this.v = i3 &= -5;
                } else {
                    u();
                    this.y.addAll(l.y(l));
                }
            }
            if (l.R()) {
                y(l.P());
            }
            if (l.S()) {
                z(l.Q());
            }
            l(l);
            g(e().d(l.D(l)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l.b x(e e, f f2) {
            final int i = 0;
            final Object obj3 = l.b.b(e, f2);
            if ((l)obj3 != null) {
                try {
                    w((l)obj3);
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
        public kotlin.i0.z.e.m0.e.l.b y(kotlin.i0.z.e.m0.e.t t) {
            int i;
            kotlin.i0.z.e.m0.e.t tVar;
            kotlin.i0.z.e.m0.e.t obj4;
            final int i3 = 8;
            if (i2 &= i3 == i3 && this.z != t.q()) {
                if (this.z != t.q()) {
                    i = t.y(this.z);
                    i.p(t);
                    this.z = i.k();
                } else {
                    this.z = t;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.l.b z(kotlin.i0.z.e.m0.e.w w) {
            int i;
            kotlin.i0.z.e.m0.e.w wVar;
            kotlin.i0.z.e.m0.e.w obj4;
            final int i3 = 16;
            if (i2 &= i3 == i3 && this.A != w.o()) {
                if (this.A != w.o()) {
                    i = w.t(this.A);
                    i.p(w);
                    this.A = i.k();
                } else {
                    this.A = w;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }
    }
    static {
        l.a aVar = new l.a();
        l.b = aVar;
        l lVar = new l(1);
        l.a = lVar;
        lVar.T();
    }

    private l(e e, f f2) {
        int i3;
        int i2;
        f fVar2;
        f fVar;
        int typeAlias_;
        int typeTable_;
        o oVar2;
        int versionRequirementTable_;
        o oVar;
        int arrayList2;
        int arrayList;
        int arrayList3;
        int i4;
        int i;
        int obj11;
        super();
        int i5 = -1;
        this.memoizedIsInitialized = i5;
        this.memoizedSerializedSize = i5;
        T();
        d.b bVar = d.w();
        final int i6 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
        i2 = i3;
        fVar2 = 4;
        fVar = 2;
        while (i3 == 0) {
            typeAlias_ = e.K();
            if (typeAlias_ != 0) {
            } else {
            }
            i3 = i6;
            fVar2 = 4;
            fVar = 2;
            if (typeAlias_ != 26) {
            } else {
            }
            if (i2 & 1 != i6) {
            }
            this.function_.add(e.u(i.b, f2));
            arrayList3 = new ArrayList();
            this.function_ = arrayList3;
            i2 |= 1;
            if (typeAlias_ != 34) {
            } else {
            }
            if (i2 & 2 != fVar) {
            }
            this.property_.add(e.u(n.b, f2));
            arrayList = new ArrayList();
            this.property_ = arrayList;
            i2 |= 2;
            if (typeAlias_ != 42) {
            } else {
            }
            if (i2 & 4 != fVar2) {
            }
            this.typeAlias_.add(e.u(r.b, f2));
            arrayList2 = new ArrayList();
            this.typeAlias_ = arrayList2;
            i2 |= 4;
            i = 0;
            if (typeAlias_ != 242) {
            } else {
            }
            if (bitField0_ &= i6 == i6) {
            }
            oVar2 = e.u(t.b, f2);
            this.typeTable_ = (t)oVar2;
            if (i != 0) {
            }
            this.bitField0_ = bitField0_2 |= i6;
            i.p(oVar2);
            this.typeTable_ = i.k();
            i = this.typeTable_.A();
            if (typeAlias_ != 258) {
            } else {
            }
            if (bitField0_3 &= fVar == fVar) {
            }
            oVar = e.u(w.b, f2);
            this.versionRequirementTable_ = (w)oVar;
            if (i != 0) {
            }
            this.bitField0_ = bitField0_4 |= fVar;
            i.p(oVar);
            this.versionRequirementTable_ = i.k();
            i = this.versionRequirementTable_.v();
            if (!j(e, outputStream, f2, typeAlias_)) {
            }
        }
        if (i2 & 1 == i6) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if (i2 & 2 == fVar) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if (i2 & 4 == fVar2) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    l(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private l(h.c<kotlin.i0.z.e.m0.e.l, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    l(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private l(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static kotlin.i0.z.e.m0.e.t A(kotlin.i0.z.e.m0.e.l l, kotlin.i0.z.e.m0.e.t t2) {
        l.typeTable_ = t2;
        return t2;
    }

    static kotlin.i0.z.e.m0.e.w B(kotlin.i0.z.e.m0.e.l l, kotlin.i0.z.e.m0.e.w w2) {
        l.versionRequirementTable_ = w2;
        return w2;
    }

    static int C(kotlin.i0.z.e.m0.e.l l, int i2) {
        l.bitField0_ = i2;
        return i2;
    }

    static d D(kotlin.i0.z.e.m0.e.l l) {
        return l.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.l E() {
        return l.a;
    }

    private void T() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = t.q();
        this.versionRequirementTable_ = w.o();
    }

    public static kotlin.i0.z.e.m0.e.l.b U() {
        return l.b.m();
    }

    public static kotlin.i0.z.e.m0.e.l.b V(kotlin.i0.z.e.m0.e.l l) {
        final kotlin.i0.z.e.m0.e.l.b bVar = l.U();
        bVar.w(l);
        return bVar;
    }

    public static kotlin.i0.z.e.m0.e.l X(InputStream inputStream, f f2) {
        return (l)l.b.a(inputStream, f2);
    }

    static List u(kotlin.i0.z.e.m0.e.l l) {
        return l.function_;
    }

    static List v(kotlin.i0.z.e.m0.e.l l, List list2) {
        l.function_ = list2;
        return list2;
    }

    static List w(kotlin.i0.z.e.m0.e.l l) {
        return l.property_;
    }

    static List x(kotlin.i0.z.e.m0.e.l l, List list2) {
        l.property_ = list2;
        return list2;
    }

    static List y(kotlin.i0.z.e.m0.e.l l) {
        return l.typeAlias_;
    }

    static List z(kotlin.i0.z.e.m0.e.l l, List list2) {
        l.typeAlias_ = list2;
        return list2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.l F() {
        return l.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.i G(int i) {
        return (i)this.function_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int H() {
        return this.function_.size();
    }

    public List<kotlin.i0.z.e.m0.e.i> I() {
        return this.function_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.n J(int i) {
        return (n)this.property_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int K() {
        return this.property_.size();
    }

    public List<kotlin.i0.z.e.m0.e.n> L() {
        return this.property_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.r M(int i) {
        return (r)this.typeAlias_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int N() {
        return this.typeAlias_.size();
    }

    public List<kotlin.i0.z.e.m0.e.r> O() {
        return this.typeAlias_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.t P() {
        return this.typeTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.w Q() {
        return this.versionRequirementTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean R() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean S() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.l.b W() {
        return l.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.l.b Y() {
        return l.V(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int i6;
        int i4;
        int i2;
        int i5;
        int i;
        int typeTable_;
        int versionRequirementTable_;
        int i3;
        int size;
        int size2;
        Object obj;
        getSerializedSize();
        i6 = 0;
        i5 = i6;
        while (i5 < this.function_.size()) {
            codedOutputStream.d0(3, (o)this.function_.get(i5));
            i5++;
        }
        i = i6;
        while (i < this.property_.size()) {
            codedOutputStream.d0(4, (o)this.property_.get(i));
            i++;
        }
        while (i6 < this.typeAlias_.size()) {
            codedOutputStream.d0(5, (o)this.typeAlias_.get(i6));
            i6++;
        }
        typeTable_ = 1;
        if (bitField0_ &= typeTable_ == typeTable_) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        versionRequirementTable_ = 2;
        if (bitField0_2 &= versionRequirementTable_ == versionRequirementTable_) {
            codedOutputStream.d0(32, this.versionRequirementTable_);
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return F();
    }

    public q<kotlin.i0.z.e.m0.e.l> getParserForType() {
        return l.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i4;
        int i2;
        int i5;
        int i7;
        int i;
        int typeTable_;
        int versionRequirementTable_;
        int i3;
        int i6;
        int size;
        int size2;
        Object obj;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i4 = 0;
        i3 = i7;
        while (i7 < this.function_.size()) {
            i3 += i6;
            i7++;
        }
        i = i4;
        while (i < this.property_.size()) {
            i3 += size;
            i++;
        }
        while (i4 < this.typeAlias_.size()) {
            i3 += i;
            i4++;
        }
        typeTable_ = 1;
        if (bitField0_ &= typeTable_ == typeTable_) {
            i3 += i2;
        }
        versionRequirementTable_ = 2;
        if (bitField0_2 &= versionRequirementTable_ == versionRequirementTable_) {
            i3 += i5;
        }
        i13 += size3;
        this.memoizedSerializedSize = i14;
        return i14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        int i;
        int i3;
        int i2;
        boolean initialized;
        boolean initialized2;
        int initialized3;
        int initialized4;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i4 = 1;
        if (memoizedIsInitialized == i4) {
            return i4;
        }
        final int i5 = 0;
        if (memoizedIsInitialized == 0) {
            return i5;
        }
        i = i5;
        while (i < H()) {
            i++;
        }
        i3 = i5;
        while (i3 < K()) {
            i3++;
        }
        i2 = i5;
        while (i2 < N()) {
            i2++;
        }
        if (R() && !P().isInitialized()) {
            if (!P().isInitialized()) {
                this.memoizedIsInitialized = i5;
                return i5;
            }
        }
        if (!m()) {
            this.memoizedIsInitialized = i5;
            return i5;
        }
        this.memoizedIsInitialized = i4;
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return Y();
    }
}
