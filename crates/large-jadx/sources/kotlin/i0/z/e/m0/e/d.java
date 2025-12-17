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
public final class d extends h.d<kotlin.i0.z.e.m0.e.d> implements p {

    private static final kotlin.i0.z.e.m0.e.d a;
    public static q<kotlin.i0.z.e.m0.e.d> b;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final d unknownFields;
    private List<kotlin.i0.z.e.m0.e.u> valueParameter_;
    private List<Integer> versionRequirement_;

    static class a extends b<kotlin.i0.z.e.m0.e.d> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.d m(e e, f f2) {
            d dVar = new d(e, f2, 0);
            return dVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.d, kotlin.i0.z.e.m0.e.d.b> implements p {

        private int v;
        private int w = 6;
        private List<kotlin.i0.z.e.m0.e.u> x;
        private List<Integer> y;
        private b() {
            super();
            int i = 6;
            this.x = Collections.emptyList();
            this.y = Collections.emptyList();
            u();
        }

        static kotlin.i0.z.e.m0.e.d.b m() {
            return d.b.r();
        }

        private static kotlin.i0.z.e.m0.e.d.b r() {
            d.b bVar = new d.b();
            return bVar;
        }

        private void s() {
            int i;
            List list;
            final int i4 = 2;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.x);
                this.x = arrayList;
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
            v((d)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            w(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.d n() {
            kotlin.i0.z.e.m0.e.d dVar = o();
            if (!dVar.isInitialized()) {
            } else {
                return dVar;
            }
            throw a.a.c(dVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.d o() {
            int i2;
            int i3;
            int i;
            d dVar = new d(this, 0);
            i = 1;
            if (i5 &= i == i) {
            } else {
                i = 0;
            }
            d.u(dVar, this.w);
            int i12 = 2;
            if (i8 &= i12 == i12) {
                this.x = Collections.unmodifiableList(this.x);
                this.v = i11 &= -3;
            }
            d.w(dVar, this.x);
            int i13 = 4;
            if (i9 &= i13 == i13) {
                this.y = Collections.unmodifiableList(this.y);
                this.v = i10 &= -5;
            }
            d.y(dVar, this.y);
            d.z(dVar, i);
            return dVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.d.b p() {
            final kotlin.i0.z.e.m0.e.d.b bVar = d.b.r();
            bVar.v(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.d.b v(kotlin.i0.z.e.m0.e.d d) {
            boolean z;
            boolean empty2;
            boolean empty;
            List list;
            if (d == d.B()) {
                return this;
            }
            if (d.I()) {
                x(d.D());
            }
            if (!d.v(d).isEmpty()) {
                if (this.x.isEmpty()) {
                    this.x = d.v(d);
                    this.v = i &= -3;
                } else {
                    s();
                    this.x.addAll(d.v(d));
                }
            }
            if (!d.x(d).isEmpty()) {
                if (this.y.isEmpty()) {
                    this.y = d.x(d);
                    this.v = i2 &= -5;
                } else {
                    t();
                    this.y.addAll(d.x(d));
                }
            }
            l(d);
            g(e().d(d.A(d)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.d.b w(e e, f f2) {
            final int i = 0;
            final Object obj3 = d.b.b(e, f2);
            if ((d)obj3 != null) {
                try {
                    v((d)obj3);
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
        public kotlin.i0.z.e.m0.e.d.b x(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }
    }
    static {
        d.a aVar = new d.a();
        d.b = aVar;
        d dVar = new d(1);
        d.a = dVar;
        dVar.J();
    }

    private d(e e, f f2) {
        int i2;
        int i;
        f fVar2;
        f fVar;
        int versionRequirement_2;
        int arrayList;
        int arrayList2;
        int valueOf2;
        int versionRequirement_;
        Integer valueOf;
        int obj11;
        super();
        int i3 = -1;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        J();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i = i2;
        fVar2 = 2;
        fVar = 4;
        while (i2 == 0) {
            versionRequirement_2 = e.K();
            if (versionRequirement_2 != 0) {
            } else {
            }
            i2 = i4;
            fVar2 = 2;
            fVar = 4;
            if (versionRequirement_2 != 8) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i4;
            this.flags_ = e.s();
            if (versionRequirement_2 != 18) {
            } else {
            }
            if (i & 2 != fVar2) {
            }
            this.valueParameter_.add(e.u(u.b, f2));
            arrayList = new ArrayList();
            this.valueParameter_ = arrayList;
            i |= 2;
            if (versionRequirement_2 != 248) {
            } else {
            }
            if (i & 4 != fVar) {
            }
            this.versionRequirement_.add(Integer.valueOf(e.s()));
            arrayList2 = new ArrayList();
            this.versionRequirement_ = arrayList2;
            i |= 4;
            if (versionRequirement_2 != 250) {
            } else {
            }
            if (i & 4 != fVar && e.e() > 0) {
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
            i |= 4;
            if (!j(e, outputStream, f2, versionRequirement_2)) {
            }
        }
        if (i & 2 == fVar2) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if (i & 4 == fVar) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    d(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private d(h.c<kotlin.i0.z.e.m0.e.d, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    d(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private d(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static d A(kotlin.i0.z.e.m0.e.d d) {
        return d.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.d B() {
        return d.a;
    }

    private void J() {
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.d.b K() {
        return d.b.m();
    }

    public static kotlin.i0.z.e.m0.e.d.b L(kotlin.i0.z.e.m0.e.d d) {
        final kotlin.i0.z.e.m0.e.d.b bVar = d.K();
        bVar.v(d);
        return bVar;
    }

    static int u(kotlin.i0.z.e.m0.e.d d, int i2) {
        d.flags_ = i2;
        return i2;
    }

    static List v(kotlin.i0.z.e.m0.e.d d) {
        return d.valueParameter_;
    }

    static List w(kotlin.i0.z.e.m0.e.d d, List list2) {
        d.valueParameter_ = list2;
        return list2;
    }

    static List x(kotlin.i0.z.e.m0.e.d d) {
        return d.versionRequirement_;
    }

    static List y(kotlin.i0.z.e.m0.e.d d, List list2) {
        d.versionRequirement_ = list2;
        return list2;
    }

    static int z(kotlin.i0.z.e.m0.e.d d, int i2) {
        d.bitField0_ = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.d C() {
        return d.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int D() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.u E(int i) {
        return (u)this.valueParameter_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int F() {
        return this.valueParameter_.size();
    }

    public List<kotlin.i0.z.e.m0.e.u> G() {
        return this.valueParameter_;
    }

    public List<Integer> H() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean I() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.d.b M() {
        return d.K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.d.b N() {
        return d.L(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int flags_;
        int i;
        int i3;
        int i2;
        int intValue;
        Object obj;
        getSerializedSize();
        int i5 = 1;
        if (bitField0_ &= i5 == i5) {
            codedOutputStream.a0(i5, this.flags_);
        }
        i3 = i;
        while (i3 < this.valueParameter_.size()) {
            codedOutputStream.d0(2, (o)this.valueParameter_.get(i3));
            i3++;
        }
        while (i < this.versionRequirement_.size()) {
            codedOutputStream.a0(31, (Integer)this.versionRequirement_.get(i).intValue());
            i++;
        }
        s().a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return C();
    }

    public q<kotlin.i0.z.e.m0.e.d> getParserForType() {
        return d.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i;
        int i3;
        int i2;
        int i4;
        int i5;
        int size;
        int i6;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i14 = 1;
        i4 = 0;
        if (bitField0_ &= i14 == i14) {
            i8 += i4;
        } else {
            i = i4;
        }
        i3 = i4;
        i6 = 2;
        while (i3 < this.valueParameter_.size()) {
            i += i5;
            i3++;
            i6 = 2;
        }
        i2 = i4;
        while (i4 < this.versionRequirement_.size()) {
            i2 += size;
            i4++;
        }
        i11 += size3;
        this.memoizedSerializedSize = i12;
        return i12;
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
        i = i3;
        while (i < F()) {
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
        return M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return N();
    }
}
