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
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes3.dex */
public final class t extends h implements p {

    private static final kotlin.i0.z.e.m0.e.t a;
    public static q<kotlin.i0.z.e.m0.e.t> b;
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<kotlin.i0.z.e.m0.e.q> type_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.t> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.t m(e e, f f2) {
            t tVar = new t(e, f2, 0);
            return tVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.t, kotlin.i0.z.e.m0.e.t.b> implements p {

        private int b;
        private List<kotlin.i0.z.e.m0.e.q> c;
        private int v = -1;
        private b() {
            super();
            this.c = Collections.emptyList();
            int i = -1;
            o();
        }

        static kotlin.i0.z.e.m0.e.t.b h() {
            return t.b.m();
        }

        private static kotlin.i0.z.e.m0.e.t.b m() {
            t.b bVar = new t.b();
            return bVar;
        }

        private void n() {
            int i;
            List list;
            final int i4 = 1;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.c);
                this.c = arrayList;
                this.b = i3 |= i4;
            }
        }

        private void o() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public a.a b(e e, f f2) {
            r(e, f2);
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
            p((t)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t j() {
            kotlin.i0.z.e.m0.e.t tVar = k();
            if (!tVar.isInitialized()) {
            } else {
                return tVar;
            }
            throw a.a.c(tVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t k() {
            int i2;
            int i;
            t tVar = new t(this, 0);
            int i4 = this.b;
            if (i4 & 1 == 1) {
                this.c = Collections.unmodifiableList(this.c);
                this.b = i7 &= -2;
            }
            t.m(tVar, this.c);
            int i8 = 2;
            if (i4 &= i8 == i8) {
            } else {
                i = 0;
            }
            t.n(tVar, this.v);
            t.o(tVar, i);
            return tVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t.b l() {
            final kotlin.i0.z.e.m0.e.t.b bVar = t.b.m();
            bVar.p(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t.b p(kotlin.i0.z.e.m0.e.t t) {
            boolean empty;
            boolean z;
            List list;
            if (t == t.q()) {
                return this;
            }
            if (!t.l(t).isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = t.l(t);
                    this.b = i &= -2;
                } else {
                    n();
                    this.c.addAll(t.l(t));
                }
            }
            if (t.v()) {
                s(t.r());
            }
            g(e().d(t.p(t)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t.b r(e e, f f2) {
            final int i = 0;
            final Object obj3 = t.b.b(e, f2);
            if ((t)obj3 != null) {
                try {
                    p((t)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    p(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.t.b s(int i) {
            this.b = i2 |= 2;
            this.v = i;
            return this;
        }
    }
    static {
        t.a aVar = new t.a();
        t.b = aVar;
        t tVar = new t(1);
        t.a = tVar;
        tVar.w();
    }

    private t(e e, f f2) {
        int i3;
        int i;
        int type_;
        int arrayList;
        int i2;
        int obj8;
        super();
        int i4 = -1;
        this.memoizedIsInitialized = i4;
        this.memoizedSerializedSize = i4;
        w();
        d.b bVar = d.w();
        final int i5 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i5);
        i = i3;
        while (i3 == 0) {
            type_ = e.K();
            if (type_ != 0) {
            } else {
            }
            i3 = i5;
            if (type_ != 10) {
            } else {
            }
            if (i & 1 != i5) {
            }
            this.type_.add(e.u(q.b, f2));
            arrayList = new ArrayList();
            this.type_ = arrayList;
            i |= 1;
            if (type_ != 16) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i5;
            this.firstNullable_ = e.s();
            if (!j(e, outputStream, f2, type_)) {
            }
        }
        if (i & 1 == i5) {
            this.type_ = Collections.unmodifiableList(this.type_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        try {
            g();
        } catch (Throwable th) {
        }
    }

    t(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private t(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    t(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private t(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List l(kotlin.i0.z.e.m0.e.t t) {
        return t.type_;
    }

    static List m(kotlin.i0.z.e.m0.e.t t, List list2) {
        t.type_ = list2;
        return list2;
    }

    static int n(kotlin.i0.z.e.m0.e.t t, int i2) {
        t.firstNullable_ = i2;
        return i2;
    }

    static int o(kotlin.i0.z.e.m0.e.t t, int i2) {
        t.bitField0_ = i2;
        return i2;
    }

    static d p(kotlin.i0.z.e.m0.e.t t) {
        return t.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.t q() {
        return t.a;
    }

    private void w() {
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
    }

    public static kotlin.i0.z.e.m0.e.t.b x() {
        return t.b.h();
    }

    public static kotlin.i0.z.e.m0.e.t.b y(kotlin.i0.z.e.m0.e.t t) {
        final kotlin.i0.z.e.m0.e.t.b bVar = t.x();
        bVar.p(t);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.t.b A() {
        return t.y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int i3;
        int i2;
        Object obj;
        int firstNullable_;
        int i;
        getSerializedSize();
        i3 = 0;
        i = 1;
        while (i3 < this.type_.size()) {
            codedOutputStream.d0(i, (o)this.type_.get(i3));
            i3++;
            i = 1;
        }
        if (bitField0_ &= i == i) {
            codedOutputStream.a0(2, this.firstNullable_);
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.t> getParserForType() {
        return t.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i2;
        int i3;
        int i4;
        int i5;
        int firstNullable_;
        int i;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i4 = i2;
        i = 1;
        while (i2 < this.type_.size()) {
            i4 += i5;
            i2++;
            i = 1;
        }
        if (bitField0_ &= i == i) {
            i4 += i3;
        }
        i4 += size;
        this.memoizedSerializedSize = i8;
        return i8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
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
        while (i < t()) {
            i++;
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a newBuilderForType() {
        return z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int r() {
        return this.firstNullable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.q s(int i) {
        return (q)this.type_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int t() {
        return this.type_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return A();
    }

    public List<kotlin.i0.z.e.m0.e.q> u() {
        return this.type_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean v() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.t.b z() {
        return t.x();
    }
}
