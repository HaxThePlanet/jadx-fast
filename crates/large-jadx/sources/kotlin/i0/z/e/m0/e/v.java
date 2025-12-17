package kotlin.i0.z.e.m0.e;

import java.io.IOException;
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
public final class v extends h implements p {

    private static final kotlin.i0.z.e.m0.e.v a;
    public static q<kotlin.i0.z.e.m0.e.v> b;
    private int bitField0_;
    private int errorCode_;
    private kotlin.i0.z.e.m0.e.v.c level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final d unknownFields;
    private int versionFull_;
    private kotlin.i0.z.e.m0.e.v.d versionKind_;
    private int version_;

    public static enum c implements i.a {

        WARNING(false, false),
        ERROR(true, true),
        HIDDEN(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.v.c valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return v.c.HIDDEN;
                }
                return v.c.ERROR;
            }
            return v.c.WARNING;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static enum d implements i.a {

        LANGUAGE_VERSION(false, false),
        COMPILER_VERSION(true, true),
        API_VERSION(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.v.d valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return v.d.API_VERSION;
                }
                return v.d.COMPILER_VERSION;
            }
            return v.d.LANGUAGE_VERSION;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    static class a extends b<kotlin.i0.z.e.m0.e.v> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.v m(e e, f f2) {
            v vVar = new v(e, f2, 0);
            return vVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.v, kotlin.i0.z.e.m0.e.v.b> implements p {

        private int b;
        private int c;
        private int v;
        private kotlin.i0.z.e.m0.e.v.c w;
        private int x;
        private int y;
        private kotlin.i0.z.e.m0.e.v.d z;
        private b() {
            super();
            this.w = v.c.ERROR;
            this.z = v.d.LANGUAGE_VERSION;
            n();
        }

        static kotlin.i0.z.e.m0.e.v.b h() {
            return v.b.m();
        }

        private static kotlin.i0.z.e.m0.e.v.b m() {
            v.b bVar = new v.b();
            return bVar;
        }

        private void n() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public a.a b(e e, f f2) {
            p(e, f2);
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
            o((v)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v j() {
            kotlin.i0.z.e.m0.e.v vVar = k();
            if (!vVar.isInitialized()) {
            } else {
                return vVar;
            }
            throw a.a.c(vVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            p(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v k() {
            int i;
            v vVar = new v(this, 0);
            int i3 = this.b;
            if (i3 & 1 == 1) {
            } else {
                i = 0;
            }
            v.l(vVar, this.c);
            if (i3 & 2 == 2) {
                i |= 2;
            }
            v.m(vVar, this.v);
            if (i3 & 4 == 4) {
                i |= 4;
            }
            v.n(vVar, this.w);
            if (i3 & 8 == 8) {
                i |= 8;
            }
            v.o(vVar, this.x);
            if (i3 & 16 == 16) {
                i |= 16;
            }
            v.p(vVar, this.y);
            int i14 = 32;
            if (i3 &= i14 == i14) {
                i |= 32;
            }
            v.q(vVar, this.z);
            v.r(vVar, i);
            return vVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b l() {
            final kotlin.i0.z.e.m0.e.v.b bVar = v.b.m();
            bVar.o(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b o(kotlin.i0.z.e.m0.e.v v) {
            boolean z3;
            boolean z;
            boolean z5;
            boolean z4;
            boolean z2;
            boolean z6;
            if (v == v.t()) {
                return this;
            }
            if (v.D()) {
                u(v.x());
            }
            if (v.E()) {
                v(v.y());
            }
            if (v.B()) {
                s(v.v());
            }
            if (v.A()) {
                r(v.u());
            }
            if (v.C()) {
                t(v.w());
            }
            if (v.F()) {
                w(v.z());
            }
            g(e().d(v.s(v)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b p(e e, f f2) {
            final int i = 0;
            final Object obj3 = v.b.b(e, f2);
            if ((v)obj3 != null) {
                try {
                    o((v)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    o(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b r(int i) {
            this.b = i2 |= 8;
            this.x = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b s(kotlin.i0.z.e.m0.e.v.c v$c) {
            Objects.requireNonNull(c);
            this.b = i |= 4;
            this.w = c;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b t(int i) {
            this.b = i2 |= 16;
            this.y = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b u(int i) {
            this.b = i2 |= 1;
            this.c = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b v(int i) {
            this.b = i2 |= 2;
            this.v = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.v.b w(kotlin.i0.z.e.m0.e.v.d v$d) {
            Objects.requireNonNull(d);
            this.b = i |= 32;
            this.z = d;
            return this;
        }
    }
    static {
        v.a aVar = new v.a();
        v.b = aVar;
        v vVar = new v(1);
        v.a = vVar;
        vVar.G();
    }

    private v(e e, f f2) {
        int i3;
        int i2;
        int i4;
        int valueOf;
        int i;
        super();
        int i5 = -1;
        this.memoizedIsInitialized = i5;
        this.memoizedSerializedSize = i5;
        G();
        d.b bVar = d.w();
        final int i6 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
        i3 = 0;
        while (i3 == 0) {
            i2 = e.K();
            if (i2 != 0) {
            } else {
            }
            i3 = i6;
            i4 = 8;
            if (i2 != i4) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i6;
            this.version_ = e.s();
            valueOf = 16;
            if (i2 != valueOf) {
            } else {
            }
            this.bitField0_ = bitField0_6 |= 2;
            this.versionFull_ = e.s();
            if (i2 != 24) {
            } else {
            }
            i4 = e.n();
            valueOf = v.c.valueOf(i4);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_5 |= 4;
            this.level_ = valueOf;
            outputStream.o0(i2);
            outputStream.o0(i4);
            i = 32;
            if (i2 != i) {
            } else {
            }
            this.bitField0_ = bitField0_2 |= i4;
            this.errorCode_ = e.s();
            if (i2 != 40) {
            } else {
            }
            this.bitField0_ = bitField0_3 |= valueOf;
            this.message_ = e.s();
            if (i2 != 48) {
            } else {
            }
            i4 = e.n();
            valueOf = v.d.valueOf(i4);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_4 |= i;
            this.versionKind_ = valueOf;
            outputStream.o0(i2);
            outputStream.o0(i4);
            if (!j(e, outputStream, f2, i2)) {
            }
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    v(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private v(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    v(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private v(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    private void G() {
        int i = 0;
        this.version_ = i;
        this.versionFull_ = i;
        this.level_ = v.c.ERROR;
        this.errorCode_ = i;
        this.message_ = i;
        this.versionKind_ = v.d.LANGUAGE_VERSION;
    }

    public static kotlin.i0.z.e.m0.e.v.b H() {
        return v.b.h();
    }

    public static kotlin.i0.z.e.m0.e.v.b I(kotlin.i0.z.e.m0.e.v v) {
        final kotlin.i0.z.e.m0.e.v.b bVar = v.H();
        bVar.o(v);
        return bVar;
    }

    static int l(kotlin.i0.z.e.m0.e.v v, int i2) {
        v.version_ = i2;
        return i2;
    }

    static int m(kotlin.i0.z.e.m0.e.v v, int i2) {
        v.versionFull_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.v.c n(kotlin.i0.z.e.m0.e.v v, kotlin.i0.z.e.m0.e.v.c v$c2) {
        v.level_ = c2;
        return c2;
    }

    static int o(kotlin.i0.z.e.m0.e.v v, int i2) {
        v.errorCode_ = i2;
        return i2;
    }

    static int p(kotlin.i0.z.e.m0.e.v v, int i2) {
        v.message_ = i2;
        return i2;
    }

    static kotlin.i0.z.e.m0.e.v.d q(kotlin.i0.z.e.m0.e.v v, kotlin.i0.z.e.m0.e.v.d v$d2) {
        v.versionKind_ = d2;
        return d2;
    }

    static int r(kotlin.i0.z.e.m0.e.v v, int i2) {
        v.bitField0_ = i2;
        return i2;
    }

    static d s(kotlin.i0.z.e.m0.e.v v) {
        return v.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.v t() {
        return v.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean A() {
        int i;
        final int i3 = 8;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean B() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean C() {
        int i;
        final int i3 = 16;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean D() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean E() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean F() {
        int i;
        final int i3 = 32;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.v.b J() {
        return v.H();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.v.b K() {
        return v.I(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int version_;
        int versionFull_;
        int i;
        int errorCode_;
        int i3;
        int i2;
        int message_;
        int number;
        int number2;
        getSerializedSize();
        int i4 = 1;
        if (bitField0_ &= i4 == i4) {
            codedOutputStream.a0(i4, this.version_);
        }
        int i5 = 2;
        if (bitField0_2 &= i5 == i5) {
            codedOutputStream.a0(i5, this.versionFull_);
        }
        int i6 = 4;
        if (bitField0_3 &= i6 == i6) {
            codedOutputStream.S(3, this.level_.getNumber());
        }
        int i7 = 8;
        if (bitField0_4 &= i7 == i7) {
            codedOutputStream.a0(i6, this.errorCode_);
        }
        message_ = 16;
        if (bitField0_5 &= message_ == message_) {
            codedOutputStream.a0(5, this.message_);
        }
        number = 32;
        if (bitField0_6 &= number == number) {
            codedOutputStream.S(6, this.versionKind_.getNumber());
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.v> getParserForType() {
        return v.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i6;
        int i2;
        int i3;
        int i;
        int i4;
        int i7;
        int i5;
        int message_;
        int number;
        int number2;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i13 = 1;
        if (bitField0_ &= i13 == i13) {
            i6 += i2;
        }
        int i14 = 2;
        if (bitField0_2 &= i14 == i14) {
            i6 += i3;
        }
        int i15 = 4;
        if (bitField0_3 &= i15 == i15) {
            i6 += i;
        }
        int i16 = 8;
        if (bitField0_4 &= i16 == i16) {
            i6 += i4;
        }
        message_ = 16;
        if (bitField0_5 &= message_ == message_) {
            i6 += i7;
        }
        number = 32;
        if (bitField0_6 &= number == number) {
            i6 += i5;
        }
        i6 += size;
        this.memoizedSerializedSize = i8;
        return i8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public final boolean isInitialized() {
        byte memoizedIsInitialized = this.memoizedIsInitialized;
        final int i2 = 1;
        if (memoizedIsInitialized == i2) {
            return i2;
        }
        if (memoizedIsInitialized == 0) {
            return 0;
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a newBuilderForType() {
        return J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int u() {
        return this.errorCode_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.v.c v() {
        return this.level_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int w() {
        return this.message_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int x() {
        return this.version_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int y() {
        return this.versionFull_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.v.d z() {
        return this.versionKind_;
    }
}
