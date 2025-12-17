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
public final class m extends h.d<kotlin.i0.z.e.m0.e.m> implements p {

    private static final kotlin.i0.z.e.m0.e.m a;
    public static q<kotlin.i0.z.e.m0.e.m> b;
    private int bitField0_;
    private List<kotlin.i0.z.e.m0.e.c> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private kotlin.i0.z.e.m0.e.l package_;
    private kotlin.i0.z.e.m0.e.o qualifiedNames_;
    private kotlin.i0.z.e.m0.e.p strings_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.m> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.m m(e e, f f2) {
            m mVar = new m(e, f2, 0);
            return mVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.m, kotlin.i0.z.e.m0.e.m.b> implements p {

        private int v;
        private kotlin.i0.z.e.m0.e.p w;
        private kotlin.i0.z.e.m0.e.o x;
        private kotlin.i0.z.e.m0.e.l y;
        private List<kotlin.i0.z.e.m0.e.c> z;
        private b() {
            super();
            this.w = p.o();
            this.x = o.o();
            this.y = l.E();
            this.z = Collections.emptyList();
            t();
        }

        static kotlin.i0.z.e.m0.e.m.b m() {
            return m.b.r();
        }

        private static kotlin.i0.z.e.m0.e.m.b r() {
            m.b bVar = new m.b();
            return bVar;
        }

        private void s() {
            int i;
            List list;
            final int i4 = 8;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.z);
                this.z = arrayList;
                this.v = i3 |= i4;
            }
        }

        private void t() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            v(e, f2);
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
            u((m)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            v(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m n() {
            kotlin.i0.z.e.m0.e.m mVar = o();
            if (!mVar.isInitialized()) {
            } else {
                return mVar;
            }
            throw a.a.c(mVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m o() {
            int i2;
            int i;
            m mVar = new m(this, 0);
            int i4 = this.v;
            if (i4 & 1 == 1) {
            } else {
                i = 0;
            }
            m.u(mVar, this.w);
            if (i4 & 2 == 2) {
                i |= 2;
            }
            m.v(mVar, this.x);
            int i10 = 4;
            if (i4 &= i10 == i10) {
                i |= 4;
            }
            m.w(mVar, this.y);
            int i11 = 8;
            if (i6 &= i11 == i11) {
                this.z = Collections.unmodifiableList(this.z);
                this.v = i7 &= -9;
            }
            m.y(mVar, this.z);
            m.z(mVar, i);
            return mVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b p() {
            final kotlin.i0.z.e.m0.e.m.b bVar = m.b.r();
            bVar.u(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b u(kotlin.i0.z.e.m0.e.m m) {
            boolean z;
            boolean z3;
            boolean z2;
            boolean empty;
            List list;
            if (m == m.E()) {
                return this;
            }
            if (m.L()) {
                y(m.I());
            }
            if (m.K()) {
                x(m.H());
            }
            if (m.J()) {
                w(m.G());
            }
            if (!m.x(m).isEmpty()) {
                if (this.z.isEmpty()) {
                    this.z = m.x(m);
                    this.v = i &= -9;
                } else {
                    s();
                    this.z.addAll(m.x(m));
                }
            }
            l(m);
            g(e().d(m.A(m)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b v(e e, f f2) {
            final int i = 0;
            final Object obj3 = m.b.b(e, f2);
            if ((m)obj3 != null) {
                try {
                    u((m)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    u(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b w(kotlin.i0.z.e.m0.e.l l) {
            int i;
            kotlin.i0.z.e.m0.e.l lVar;
            kotlin.i0.z.e.m0.e.l obj4;
            final int i3 = 4;
            if (i2 &= i3 == i3 && this.y != l.E()) {
                if (this.y != l.E()) {
                    i = l.V(this.y);
                    i.w(l);
                    this.y = i.o();
                } else {
                    this.y = l;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b x(kotlin.i0.z.e.m0.e.o o) {
            int i;
            kotlin.i0.z.e.m0.e.o oVar;
            kotlin.i0.z.e.m0.e.o obj4;
            final int i3 = 2;
            if (i2 &= i3 == i3 && this.x != o.o()) {
                if (this.x != o.o()) {
                    i = o.t(this.x);
                    i.p(o);
                    this.x = i.k();
                } else {
                    this.x = o;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.m.b y(kotlin.i0.z.e.m0.e.p p) {
            int i;
            kotlin.i0.z.e.m0.e.p pVar;
            kotlin.i0.z.e.m0.e.p obj4;
            final int i3 = 1;
            if (i2 &= i3 == i3 && this.w != p.o()) {
                if (this.w != p.o()) {
                    i = p.t(this.w);
                    i.p(p);
                    this.w = i.k();
                } else {
                    this.w = p;
                }
            } else {
            }
            this.v = obj4 |= i3;
            return this;
        }
    }
    static {
        m.a aVar = new m.a();
        m.b = aVar;
        m mVar = new m(1);
        m.a = mVar;
        mVar.M();
    }

    private m(e e, f f2) {
        int i;
        int i4;
        f fVar;
        int class__;
        int strings_;
        o oVar3;
        int arrayList;
        int package_;
        o oVar;
        int qualifiedNames_;
        o oVar2;
        int i3;
        int i2;
        int obj10;
        super();
        int i5 = -1;
        this.memoizedIsInitialized = i5;
        this.memoizedSerializedSize = i5;
        M();
        d.b bVar = d.w();
        final int i6 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
        i4 = i;
        fVar = 8;
        while (i == 0) {
            class__ = e.K();
            if (class__ != 0) {
            } else {
            }
            i = i6;
            fVar = 8;
            i2 = 0;
            if (class__ != 10) {
            } else {
            }
            if (bitField0_ &= i6 == i6) {
            }
            oVar3 = e.u(p.b, f2);
            this.strings_ = (p)oVar3;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_2 |= i6;
            i2.p(oVar3);
            this.strings_ = i2.k();
            i2 = this.strings_.v();
            if (class__ != 18) {
            } else {
            }
            i3 = 2;
            if (bitField0_5 &= i3 == i3) {
            }
            oVar2 = e.u(o.b, f2);
            this.qualifiedNames_ = (o)oVar2;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_6 |= i3;
            i2.p(oVar2);
            this.qualifiedNames_ = i2.k();
            i2 = this.qualifiedNames_.v();
            if (class__ != 26) {
            } else {
            }
            i3 = 4;
            if (bitField0_3 &= i3 == i3) {
            }
            oVar = e.u(l.b, f2);
            this.package_ = (l)oVar;
            if (i2 != 0) {
            }
            this.bitField0_ = bitField0_4 |= i3;
            i2.w(oVar);
            this.package_ = i2.o();
            i2 = this.package_.Y();
            if (class__ != 34) {
            } else {
            }
            if (i4 & 8 != fVar) {
            }
            this.class__.add(e.u(c.b, f2));
            arrayList = new ArrayList();
            this.class__ = arrayList;
            i4 |= 8;
            if (!j(e, outputStream, f2, class__)) {
            }
        }
        if (i4 & 8 == fVar) {
            this.class__ = Collections.unmodifiableList(this.class__);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    m(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private m(h.c<kotlin.i0.z.e.m0.e.m, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    m(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private m(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static d A(kotlin.i0.z.e.m0.e.m m) {
        return m.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.m E() {
        return m.a;
    }

    private void M() {
        this.strings_ = p.o();
        this.qualifiedNames_ = o.o();
        this.package_ = l.E();
        this.class__ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.m.b N() {
        return m.b.m();
    }

    public static kotlin.i0.z.e.m0.e.m.b O(kotlin.i0.z.e.m0.e.m m) {
        final kotlin.i0.z.e.m0.e.m.b bVar = m.N();
        bVar.u(m);
        return bVar;
    }

    public static kotlin.i0.z.e.m0.e.m Q(InputStream inputStream, f f2) {
        return (m)m.b.a(inputStream, f2);
    }

    static kotlin.i0.z.e.m0.e.p u(kotlin.i0.z.e.m0.e.m m, kotlin.i0.z.e.m0.e.p p2) {
        m.strings_ = p2;
        return p2;
    }

    static kotlin.i0.z.e.m0.e.o v(kotlin.i0.z.e.m0.e.m m, kotlin.i0.z.e.m0.e.o o2) {
        m.qualifiedNames_ = o2;
        return o2;
    }

    static kotlin.i0.z.e.m0.e.l w(kotlin.i0.z.e.m0.e.m m, kotlin.i0.z.e.m0.e.l l2) {
        m.package_ = l2;
        return l2;
    }

    static List x(kotlin.i0.z.e.m0.e.m m) {
        return m.class__;
    }

    static List y(kotlin.i0.z.e.m0.e.m m, List list2) {
        m.class__ = list2;
        return list2;
    }

    static int z(kotlin.i0.z.e.m0.e.m m, int i2) {
        m.bitField0_ = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.c B(int i) {
        return (c)this.class__.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int C() {
        return this.class__.size();
    }

    public List<kotlin.i0.z.e.m0.e.c> D() {
        return this.class__;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.m F() {
        return m.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.l G() {
        return this.package_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.o H() {
        return this.qualifiedNames_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.p I() {
        return this.strings_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean J() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean K() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean L() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.m.b P() {
        return m.N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.m.b R() {
        return m.O(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int strings_;
        int qualifiedNames_;
        int i2;
        int i;
        kotlin.i0.z.e.m0.e.l package_;
        getSerializedSize();
        int i4 = 1;
        if (bitField0_ &= i4 == i4) {
            codedOutputStream.d0(i4, this.strings_);
        }
        int i5 = 2;
        if (bitField0_2 &= i5 == i5) {
            codedOutputStream.d0(i5, this.qualifiedNames_);
        }
        int i6 = 4;
        if (bitField0_3 &= i6 == i6) {
            codedOutputStream.d0(3, this.package_);
        }
        i = 0;
        while (i < this.class__.size()) {
            codedOutputStream.d0(i6, (o)this.class__.get(i));
            i++;
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return F();
    }

    public q<kotlin.i0.z.e.m0.e.m> getParserForType() {
        return m.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i2;
        int i4;
        int i;
        int i3;
        kotlin.i0.z.e.m0.e.l package_;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i10 = 1;
        i3 = 0;
        if (bitField0_ &= i10 == i10) {
            i6 += i3;
        } else {
            i2 = i3;
        }
        int i13 = 2;
        if (bitField0_2 &= i13 == i13) {
            i2 += i4;
        }
        int i14 = 4;
        if (bitField0_3 &= i14 == i14) {
            i2 += i;
        }
        while (i3 < this.class__.size()) {
            i2 += i;
            i3++;
        }
        i7 += size2;
        this.memoizedSerializedSize = i8;
        return i8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public final boolean isInitialized() {
        boolean initialized;
        boolean initialized2;
        int i;
        boolean initialized3;
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i2 = 1;
        if (memoizedIsInitialized == i2) {
            return i2;
        }
        final int i3 = 0;
        if (memoizedIsInitialized == 0) {
            return i3;
        }
        if (K() && !H().isInitialized()) {
            if (!H().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        if (J() && !G().isInitialized()) {
            if (!G().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        i = i3;
        while (i < C()) {
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
        return P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return R();
    }
}
