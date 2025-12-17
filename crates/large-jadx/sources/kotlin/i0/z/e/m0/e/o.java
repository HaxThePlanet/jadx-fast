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
public final class o extends h implements p {

    private static final kotlin.i0.z.e.m0.e.o a;
    public static q<kotlin.i0.z.e.m0.e.o> b;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<kotlin.i0.z.e.m0.e.o.c> qualifiedName_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.o> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.o m(e e, f f2) {
            o oVar = new o(e, f2, 0);
            return oVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.o, kotlin.i0.z.e.m0.e.o.b> implements p {

        private int b;
        private List<kotlin.i0.z.e.m0.e.o.c> c;
        private b() {
            super();
            this.c = Collections.emptyList();
            o();
        }

        static kotlin.i0.z.e.m0.e.o.b h() {
            return o.b.m();
        }

        private static kotlin.i0.z.e.m0.e.o.b m() {
            o.b bVar = new o.b();
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
            p((o)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.o j() {
            kotlin.i0.z.e.m0.e.o oVar = k();
            if (!oVar.isInitialized()) {
            } else {
                return oVar;
            }
            throw a.a.c(oVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.o k() {
            int i;
            o oVar = new o(this, 0);
            final int i5 = 1;
            if (i3 &= i5 == i5) {
                this.c = Collections.unmodifiableList(this.c);
                this.b = i4 &= -2;
            }
            o.m(oVar, this.c);
            return oVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.o.b l() {
            final kotlin.i0.z.e.m0.e.o.b bVar = o.b.m();
            bVar.p(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.o.b p(kotlin.i0.z.e.m0.e.o o) {
            boolean empty;
            List list;
            if (o == o.o()) {
                return this;
            }
            if (!o.l(o).isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = o.l(o);
                    this.b = i &= -2;
                } else {
                    n();
                    this.c.addAll(o.l(o));
                }
            }
            g(e().d(o.n(o)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.o.b r(e e, f f2) {
            final int i = 0;
            final Object obj3 = o.b.b(e, f2);
            if ((o)obj3 != null) {
                try {
                    p((o)obj3);
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
    }

    public static final class c extends h implements p {

        private static final kotlin.i0.z.e.m0.e.o.c a;
        public static q<kotlin.i0.z.e.m0.e.o.c> b;
        private int bitField0_;
        private kotlin.i0.z.e.m0.e.o.c.c kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final d unknownFields;
        static {
            o.c.a aVar = new o.c.a();
            o.c.b = aVar;
            o.c cVar = new o.c(1);
            o.c.a = cVar;
            cVar.x();
        }

        private c(e e, f f2) {
            int i;
            int i3;
            int i2;
            kotlin.i0.z.e.m0.e.o.c.c valueOf;
            super();
            int i4 = -1;
            this.memoizedIsInitialized = i4;
            this.memoizedSerializedSize = i4;
            x();
            d.b bVar = d.w();
            final int i5 = 1;
            final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i5);
            i = 0;
            while (i == 0) {
                i3 = e.K();
                if (i3 != 0) {
                } else {
                }
                i = i5;
                if (i3 != 8) {
                } else {
                }
                this.bitField0_ = bitField0_ |= i5;
                this.parentQualifiedName_ = e.s();
                if (i3 != 16) {
                } else {
                }
                this.bitField0_ = bitField0_2 |= 2;
                this.shortName_ = e.s();
                if (i3 != 24) {
                } else {
                }
                i2 = e.n();
                valueOf = o.c.c.valueOf(i2);
                if (valueOf == null) {
                } else {
                }
                this.bitField0_ = bitField0_3 |= 4;
                this.kind_ = valueOf;
                outputStream.o0(i3);
                outputStream.o0(i2);
                if (!j(e, outputStream, f2, i3)) {
                }
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        c(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
            super(e, f2);
        }

        private c(h.b h$b) {
            super(b);
            final int i = -1;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        c(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
            super(b);
        }

        private c(boolean z) {
            super();
            int obj1 = -1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        static int l(kotlin.i0.z.e.m0.e.o.c o$c, int i2) {
            c.shortName_ = i2;
            return i2;
        }

        static kotlin.i0.z.e.m0.e.o.c.c m(kotlin.i0.z.e.m0.e.o.c o$c, kotlin.i0.z.e.m0.e.o.c.c o$c$c2) {
            c.kind_ = c2;
            return c2;
        }

        static int n(kotlin.i0.z.e.m0.e.o.c o$c, int i2) {
            c.bitField0_ = i2;
            return i2;
        }

        static d o(kotlin.i0.z.e.m0.e.o.c o$c) {
            return c.unknownFields;
        }

        static int p(kotlin.i0.z.e.m0.e.o.c o$c, int i2) {
            c.parentQualifiedName_ = i2;
            return i2;
        }

        public static kotlin.i0.z.e.m0.e.o.c q() {
            return o.c.a;
        }

        private void x() {
            this.parentQualifiedName_ = -1;
            this.shortName_ = 0;
            this.kind_ = o.c.c.PACKAGE;
        }

        public static kotlin.i0.z.e.m0.e.o.c.b y() {
            return o.c.b.h();
        }

        public static kotlin.i0.z.e.m0.e.o.c.b z(kotlin.i0.z.e.m0.e.o.c o$c) {
            final kotlin.i0.z.e.m0.e.o.c.b bVar = o.c.y();
            bVar.o(c);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.o.c.b A() {
            return o.c.y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.o.c.b B() {
            return o.c.z(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int parentQualifiedName_;
            int shortName_;
            int i;
            int number;
            getSerializedSize();
            int i2 = 1;
            if (bitField0_ &= i2 == i2) {
                codedOutputStream.a0(i2, this.parentQualifiedName_);
            }
            int i3 = 2;
            if (bitField0_2 &= i3 == i3) {
                codedOutputStream.a0(i3, this.shortName_);
            }
            number = 4;
            if (bitField0_3 &= number == number) {
                codedOutputStream.S(3, this.kind_.getNumber());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.o.c> getParserForType() {
            return o.c.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i4;
            int i;
            int i3;
            int i2;
            int number;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i8 = 1;
            if (bitField0_ &= i8 == i8) {
                i4 += i;
            }
            int i9 = 2;
            if (bitField0_2 &= i9 == i9) {
                i4 += i3;
            }
            number = 4;
            if (bitField0_3 &= number == number) {
                i4 += i2;
            }
            i4 += size;
            this.memoizedSerializedSize = i5;
            return i5;
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
            if (!w()) {
                this.memoizedIsInitialized = i2;
                return i2;
            }
            this.memoizedIsInitialized = i;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a newBuilderForType() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.o.c.c r() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int s() {
            return this.parentQualifiedName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int t() {
            return this.shortName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return B();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean u() {
            int i;
            final int i3 = 4;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
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
        public boolean w() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }
    }
    static {
        o.a aVar = new o.a();
        o.b = aVar;
        o oVar = new o(1);
        o.a = oVar;
        oVar.r();
    }

    private o(e e, f f2) {
        int i;
        int i2;
        List qualifiedName_;
        int arrayList;
        o oVar;
        int obj8;
        super();
        int i3 = -1;
        this.memoizedIsInitialized = i3;
        this.memoizedSerializedSize = i3;
        r();
        d.b bVar = d.w();
        final int i4 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
        i2 = i;
        while (i == 0) {
            qualifiedName_ = e.K();
            if (qualifiedName_ != 0) {
            } else {
            }
            i = i4;
            if (qualifiedName_ != 10) {
            } else {
            }
            if (i2 & 1 != i4) {
            }
            this.qualifiedName_.add(e.u(o.c.b, f2));
            arrayList = new ArrayList();
            this.qualifiedName_ = arrayList;
            i2 |= 1;
            if (!j(e, outputStream, f2, qualifiedName_)) {
            }
        }
        if (i2 & 1 == i4) {
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    o(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private o(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    o(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private o(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List l(kotlin.i0.z.e.m0.e.o o) {
        return o.qualifiedName_;
    }

    static List m(kotlin.i0.z.e.m0.e.o o, List list2) {
        o.qualifiedName_ = list2;
        return list2;
    }

    static d n(kotlin.i0.z.e.m0.e.o o) {
        return o.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.o o() {
        return o.a;
    }

    private void r() {
        this.qualifiedName_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.o.b s() {
        return o.b.h();
    }

    public static kotlin.i0.z.e.m0.e.o.b t(kotlin.i0.z.e.m0.e.o o) {
        final kotlin.i0.z.e.m0.e.o.b bVar = o.s();
        bVar.p(o);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int i;
        Object obj;
        int i2;
        getSerializedSize();
        i = 0;
        while (i < this.qualifiedName_.size()) {
            codedOutputStream.d0(1, (o)this.qualifiedName_.get(i));
            i++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.o> getParserForType() {
        return o.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i;
        int i3;
        int i2;
        int i4;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i3 = i;
        while (i < this.qualifiedName_.size()) {
            i3 += i2;
            i++;
        }
        i3 += size;
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
        i = i3;
        while (i < q()) {
            i++;
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a newBuilderForType() {
        return u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.o.c p(int i) {
        return (o.c)this.qualifiedName_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int q() {
        return this.qualifiedName_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.o.b u() {
        return o.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.o.b v() {
        return o.t(this);
    }
}
