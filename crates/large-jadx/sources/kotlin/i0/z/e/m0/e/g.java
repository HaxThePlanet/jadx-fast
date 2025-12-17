package kotlin.i0.z.e.m0.e;

import java.io.IOException;
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
public final class g extends h.d<kotlin.i0.z.e.m0.e.g> implements p {

    private static final kotlin.i0.z.e.m0.e.g a;
    public static q<kotlin.i0.z.e.m0.e.g> b;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.g> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.g m(e e, f f2) {
            g gVar = new g(e, f2, 0);
            return gVar;
        }
    }

    public static final class b extends h.c<kotlin.i0.z.e.m0.e.g, kotlin.i0.z.e.m0.e.g.b> implements p {

        private int v;
        private int w;
        static kotlin.i0.z.e.m0.e.g.b m() {
            return g.b.r();
        }

        private static kotlin.i0.z.e.m0.e.g.b r() {
            g.b bVar = new g.b();
            return bVar;
        }

        private void s() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public a.a b(e e, f f2) {
            u(e, f2);
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
            t((g)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public o.a j0(e e, f f2) {
            u(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g n() {
            kotlin.i0.z.e.m0.e.g gVar = o();
            if (!gVar.isInitialized()) {
            } else {
                return gVar;
            }
            throw a.a.c(gVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g o() {
            int i;
            g gVar = new g(this, 0);
            i = 1;
            if (i3 &= i == i) {
            } else {
                i = 0;
            }
            g.u(gVar, this.w);
            g.v(gVar, i);
            return gVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g.b p() {
            final kotlin.i0.z.e.m0.e.g.b bVar = g.b.r();
            bVar.t(o());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g.b t(kotlin.i0.z.e.m0.e.g g) {
            boolean z;
            if (g == g.x()) {
                return this;
            }
            if (g.A()) {
                v(g.z());
            }
            l(g);
            g(e().d(g.w(g)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g.b u(e e, f f2) {
            final int i = 0;
            final Object obj3 = g.b.b(e, f2);
            if ((g)obj3 != null) {
                try {
                    t((g)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    t(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$c
        public kotlin.i0.z.e.m0.e.g.b v(int i) {
            this.v = i2 |= 1;
            this.w = i;
            return this;
        }
    }
    static {
        g.a aVar = new g.a();
        g.b = aVar;
        g gVar = new g(1);
        g.a = gVar;
        gVar.B();
    }

    private g(e e, f f2) {
        int i2;
        int i3;
        int i;
        super();
        int i4 = -1;
        this.memoizedIsInitialized = i4;
        this.memoizedSerializedSize = i4;
        B();
        d.b bVar = d.w();
        final int i5 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i5);
        i2 = 0;
        while (i2 == 0) {
            i3 = e.K();
            if (i3 != 0) {
            } else {
            }
            i2 = i5;
            if (i3 != 8) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i5;
            this.name_ = e.s();
            if (!j(e, outputStream, f2, i3)) {
            }
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    g(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private g(h.c<kotlin.i0.z.e.m0.e.g, ?> h$c) {
        super(c);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = c.e();
    }

    g(h.c h$c, kotlin.i0.z.e.m0.e.a a2) {
        super(c);
    }

    private g(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    private void B() {
        this.name_ = 0;
    }

    public static kotlin.i0.z.e.m0.e.g.b C() {
        return g.b.m();
    }

    public static kotlin.i0.z.e.m0.e.g.b D(kotlin.i0.z.e.m0.e.g g) {
        final kotlin.i0.z.e.m0.e.g.b bVar = g.C();
        bVar.t(g);
        return bVar;
    }

    static int u(kotlin.i0.z.e.m0.e.g g, int i2) {
        g.name_ = i2;
        return i2;
    }

    static int v(kotlin.i0.z.e.m0.e.g g, int i2) {
        g.bitField0_ = i2;
        return i2;
    }

    static d w(kotlin.i0.z.e.m0.e.g g) {
        return g.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.g x() {
        return g.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public boolean A() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.g.b E() {
        return g.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.g.b F() {
        return g.D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public void a(CodedOutputStream codedOutputStream) {
        int name_;
        getSerializedSize();
        final int i2 = 1;
        if (bitField0_ &= i2 == i2) {
            codedOutputStream.a0(i2, this.name_);
        }
        s().a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o getDefaultInstanceForType() {
        return y();
    }

    public q<kotlin.i0.z.e.m0.e.g> getParserForType() {
        return g.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int getSerializedSize() {
        int i;
        int i2;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        final int i7 = 1;
        if (bitField0_ &= i7 == i7) {
            i += i2;
        }
        i3 += size;
        this.memoizedSerializedSize = i4;
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
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
        if (!m()) {
            this.memoizedIsInitialized = i2;
            return i2;
        }
        this.memoizedIsInitialized = i;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a newBuilderForType() {
        return E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public o.a toBuilder() {
        return F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public kotlin.i0.z.e.m0.e.g y() {
        return g.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$d
    public int z() {
        return this.name_;
    }
}
