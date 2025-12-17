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
public final class b extends h implements p {

    private static final kotlin.i0.z.e.m0.e.b a;
    public static q<kotlin.i0.z.e.m0.e.b> b;
    private List<kotlin.i0.z.e.m0.e.b.b> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.b> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.b m(e e, f f2) {
            b bVar = new b(e, f2, 0);
            return bVar;
        }
    }

    public static final class b extends h implements p {

        private static final kotlin.i0.z.e.m0.e.b.b a;
        public static q<kotlin.i0.z.e.m0.e.b.b> b;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final d unknownFields;
        private kotlin.i0.z.e.m0.e.b.b.c value_;
        static {
            b.b.a aVar = new b.b.a();
            b.b.b = aVar;
            b.b bVar = new b.b(1);
            b.b.a = bVar;
            bVar.u();
        }

        private b(e e, f f2) {
            int i5;
            int i;
            int i2;
            int i3;
            int i4;
            super();
            int i6 = -1;
            this.memoizedIsInitialized = i6;
            this.memoizedSerializedSize = i6;
            u();
            d.b bVar = d.w();
            final int i7 = 1;
            final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i7);
            i5 = 0;
            while (i5 == 0) {
                i = e.K();
                if (i != 0) {
                } else {
                }
                i5 = i7;
                if (i != 8) {
                } else {
                }
                this.bitField0_ = bitField0_ |= i7;
                this.nameId_ = e.s();
                if (i != 18) {
                } else {
                }
                i2 = 0;
                i4 = 2;
                if (bitField0_3 &= i4 == i4) {
                }
                i3 = e.u(b.b.c.b, f2);
                this.value_ = (b.b.c)i3;
                if (i2 != 0) {
                }
                this.bitField0_ = bitField0_2 |= i4;
                i2.r(i3);
                this.value_ = i2.k();
                i2 = this.value_.b0();
                if (!j(e, outputStream, f2, i)) {
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

        static int l(kotlin.i0.z.e.m0.e.b.b b$b, int i2) {
            b.nameId_ = i2;
            return i2;
        }

        static kotlin.i0.z.e.m0.e.b.b.c m(kotlin.i0.z.e.m0.e.b.b b$b, kotlin.i0.z.e.m0.e.b.b.c b$b$c2) {
            b.value_ = c2;
            return c2;
        }

        static int n(kotlin.i0.z.e.m0.e.b.b b$b, int i2) {
            b.bitField0_ = i2;
            return i2;
        }

        static d o(kotlin.i0.z.e.m0.e.b.b b$b) {
            return b.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.b.b p() {
            return b.b.a;
        }

        private void u() {
            this.nameId_ = 0;
            this.value_ = b.b.c.F();
        }

        public static kotlin.i0.z.e.m0.e.b.b.b v() {
            return b.b.b.h();
        }

        public static kotlin.i0.z.e.m0.e.b.b.b w(kotlin.i0.z.e.m0.e.b.b b$b) {
            final kotlin.i0.z.e.m0.e.b.b.b bVar = b.b.v();
            bVar.o(b);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int nameId_;
            int value_;
            getSerializedSize();
            int i = 1;
            if (bitField0_ &= i == i) {
                codedOutputStream.a0(i, this.nameId_);
            }
            int i2 = 2;
            if (bitField0_2 &= i2 == i2) {
                codedOutputStream.d0(i2, this.value_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.b.b> getParserForType() {
            return b.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i2;
            int i;
            int i3;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i6 = 1;
            if (bitField0_ &= i6 == i6) {
                i2 += i;
            }
            int i7 = 2;
            if (bitField0_2 &= i7 == i7) {
                i2 += i3;
            }
            i2 += size;
            this.memoizedSerializedSize = i4;
            return i4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public final boolean isInitialized() {
            byte memoizedIsInitialized = this.memoizedIsInitialized;
            final int i = 1;
            if (memoizedIsInitialized == i) {
                return i;
            }
            final int i2 = 0;
            if (memoizedIsInitialized == 0) {
                return i2;
            }
            if (!s()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
            if (!t()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
            if (!r().isInitialized()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
            this.memoizedIsInitialized = i;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a newBuilderForType() {
            return x();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int q() {
            return this.nameId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.b.b.c r() {
            return this.value_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean s() {
            int i;
            i = 1;
            if (bitField0_ &= i == i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean t() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.b.b.b x() {
            return b.b.v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.b.b.b y() {
            return b.b.w(this);
        }
    }

    public static final class c extends h.b<kotlin.i0.z.e.m0.e.b, kotlin.i0.z.e.m0.e.b.c> implements p {

        private int b;
        private int c;
        private List<kotlin.i0.z.e.m0.e.b.b> v;
        private c() {
            super();
            this.v = Collections.emptyList();
            o();
        }

        static kotlin.i0.z.e.m0.e.b.c h() {
            return b.c.m();
        }

        private static kotlin.i0.z.e.m0.e.b.c m() {
            b.c cVar = new b.c();
            return cVar;
        }

        private void n() {
            int i;
            List list;
            final int i4 = 2;
            if (i2 &= i4 != i4) {
                ArrayList arrayList = new ArrayList(this.v);
                this.v = arrayList;
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
            p((b)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.b j() {
            kotlin.i0.z.e.m0.e.b bVar = k();
            if (!bVar.isInitialized()) {
            } else {
                return bVar;
            }
            throw a.a.c(bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.b k() {
            int i;
            int i2;
            b bVar = new b(this, 0);
            i2 = 1;
            if (i4 &= i2 == i2) {
            } else {
                i2 = 0;
            }
            b.l(bVar, this.c);
            final int i9 = 2;
            if (i7 &= i9 == i9) {
                this.v = Collections.unmodifiableList(this.v);
                this.b = i8 &= -3;
            }
            b.n(bVar, this.v);
            b.o(bVar, i2);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.b.c l() {
            final kotlin.i0.z.e.m0.e.b.c cVar = b.c.m();
            cVar.p(k());
            return cVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.b.c p(kotlin.i0.z.e.m0.e.b b) {
            boolean z;
            boolean empty;
            List list;
            if (b == b.t()) {
                return this;
            }
            if (b.v()) {
                s(b.u());
            }
            if (!b.m(b).isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = b.m(b);
                    this.b = i &= -3;
                } else {
                    n();
                    this.v.addAll(b.m(b));
                }
            }
            g(e().d(b.p(b)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.b.c r(e e, f f2) {
            final int i = 0;
            final Object obj3 = b.b.b(e, f2);
            if ((b)obj3 != null) {
                try {
                    p((b)obj3);
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
        public kotlin.i0.z.e.m0.e.b.c s(int i) {
            this.b = i2 |= 1;
            this.c = i;
            return this;
        }
    }
    static {
        b.a aVar = new b.a();
        b.b = aVar;
        b bVar = new b(1);
        b.a = bVar;
        bVar.w();
    }

    private b(e e, f f2) {
        int i2;
        int i;
        f fVar;
        List argument_;
        int arrayList;
        o oVar;
        int obj9;
        super();
        int i3 = -1;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        w();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i = i2;
        fVar = 2;
        while (i2 == 0) {
            argument_ = e.K();
            if (argument_ != 0) {
            } else {
            }
            i2 = i4;
            fVar = 2;
            if (argument_ != 8) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i4;
            this.id_ = e.s();
            if (argument_ != 18) {
            } else {
            }
            if (i & 2 != fVar) {
            }
            this.argument_.add(e.u(b.b.b, f2));
            arrayList = new ArrayList();
            this.argument_ = arrayList;
            i |= 2;
            if (!j(e, outputStream, f2, argument_)) {
            }
        }
        if (i & 2 == fVar) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
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

    static int l(kotlin.i0.z.e.m0.e.b b, int i2) {
        b.id_ = i2;
        return i2;
    }

    static List m(kotlin.i0.z.e.m0.e.b b) {
        return b.argument_;
    }

    static List n(kotlin.i0.z.e.m0.e.b b, List list2) {
        b.argument_ = list2;
        return list2;
    }

    static int o(kotlin.i0.z.e.m0.e.b b, int i2) {
        b.bitField0_ = i2;
        return i2;
    }

    static d p(kotlin.i0.z.e.m0.e.b b) {
        return b.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.b t() {
        return b.a;
    }

    private void w() {
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.b.c x() {
        return b.c.h();
    }

    public static kotlin.i0.z.e.m0.e.b.c y(kotlin.i0.z.e.m0.e.b b) {
        final kotlin.i0.z.e.m0.e.b.c cVar = b.x();
        cVar.p(b);
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.b.c A() {
        return b.y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int id_;
        int i2;
        int i;
        Object obj;
        getSerializedSize();
        i = 1;
        if (bitField0_ &= i == i) {
            codedOutputStream.a0(i, this.id_);
        }
        i2 = 0;
        while (i2 < this.argument_.size()) {
            codedOutputStream.d0(2, (o)this.argument_.get(i2));
            i2++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.b> getParserForType() {
        return b.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i;
        int i2;
        int i3;
        Object obj;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i2 = 1;
        i3 = 0;
        if (bitField0_ &= i2 == i2) {
            i5 += i3;
        } else {
            i = i3;
        }
        while (i3 < this.argument_.size()) {
            i += i2;
            i3++;
        }
        i += size2;
        this.memoizedSerializedSize = i6;
        return i6;
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
        if (!v()) {
            this.memoizedIsInitialized = i3;
            return i3;
        }
        i = i3;
        while (i < r()) {
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
    public kotlin.i0.z.e.m0.e.b.b q(int i) {
        return (b.b)this.argument_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int r() {
        return this.argument_.size();
    }

    public List<kotlin.i0.z.e.m0.e.b.b> s() {
        return this.argument_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int u() {
        return this.id_;
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
    public kotlin.i0.z.e.m0.e.b.c z() {
        return b.x();
    }
}
