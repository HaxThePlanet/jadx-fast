package kotlin.i0.z.e.m0.e;

import java.io.IOException;
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
import kotlin.reflect.jvm.internal.impl.protobuf.l;
import kotlin.reflect.jvm.internal.impl.protobuf.m;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.r;

/* loaded from: classes3.dex */
public final class p extends h implements p {

    private static final kotlin.i0.z.e.m0.e.p a;
    public static q<kotlin.i0.z.e.m0.e.p> b;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private m string_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.p> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.p m(e e, f f2) {
            p pVar = new p(e, f2, 0);
            return pVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.p, kotlin.i0.z.e.m0.e.p.b> implements p {

        private int b;
        private m c;
        private b() {
            super();
            this.c = l.b;
            o();
        }

        static kotlin.i0.z.e.m0.e.p.b h() {
            return p.b.m();
        }

        private static kotlin.i0.z.e.m0.e.p.b m() {
            p.b bVar = new p.b();
            return bVar;
        }

        private void n() {
            int i;
            m mVar;
            final int i4 = 1;
            if (i2 &= i4 != i4) {
                l lVar = new l(this.c);
                this.c = lVar;
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
            p((p)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.p j() {
            kotlin.i0.z.e.m0.e.p pVar = k();
            if (!pVar.isInitialized()) {
            } else {
                return pVar;
            }
            throw a.a.c(pVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.p k() {
            int i;
            p pVar = new p(this, 0);
            final int i5 = 1;
            if (i3 &= i5 == i5) {
                this.c = this.c.n();
                this.b = i4 &= -2;
            }
            p.m(pVar, this.c);
            return pVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.p.b l() {
            final kotlin.i0.z.e.m0.e.p.b bVar = p.b.m();
            bVar.p(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.p.b p(kotlin.i0.z.e.m0.e.p p) {
            boolean empty;
            m mVar;
            if (p == p.o()) {
                return this;
            }
            if (!p.l(p).isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = p.l(p);
                    this.b = i &= -2;
                } else {
                    n();
                    this.c.addAll(p.l(p));
                }
            }
            g(e().d(p.n(p)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.p.b r(e e, f f2) {
            final int i = 0;
            final Object obj3 = p.b.b(e, f2);
            if ((p)obj3 != null) {
                try {
                    p((p)obj3);
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
    static {
        p.a aVar = new p.a();
        p.b = aVar;
        p pVar = new p(1);
        p.a = pVar;
        pVar.r();
    }

    private p(e e, f f2) {
        int i;
        int i2;
        d dVar;
        m string_;
        int lVar;
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
            dVar = e.K();
            if (dVar != 0) {
            } else {
            }
            i = i4;
            if (dVar != 10) {
            } else {
            }
            if (i2 & 1 != i4) {
            }
            this.string_.X1(e.l());
            lVar = new l();
            this.string_ = lVar;
            i2 |= 1;
            if (!j(e, outputStream, f2, dVar)) {
            }
        }
        if (i2 & 1 == i4) {
            this.string_ = this.string_.n();
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    p(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private p(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    p(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private p(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static m l(kotlin.i0.z.e.m0.e.p p) {
        return p.string_;
    }

    static m m(kotlin.i0.z.e.m0.e.p p, m m2) {
        p.string_ = m2;
        return m2;
    }

    static d n(kotlin.i0.z.e.m0.e.p p) {
        return p.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.p o() {
        return p.a;
    }

    private void r() {
        this.string_ = l.b;
    }

    public static kotlin.i0.z.e.m0.e.p.b s() {
        return p.b.h();
    }

    public static kotlin.i0.z.e.m0.e.p.b t(kotlin.i0.z.e.m0.e.p p) {
        final kotlin.i0.z.e.m0.e.p.b bVar = p.s();
        bVar.p(p);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int i2;
        d dVar;
        int i;
        getSerializedSize();
        i2 = 0;
        while (i2 < this.string_.size()) {
            codedOutputStream.O(1, this.string_.o1(i2));
            i2++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.p> getParserForType() {
        return p.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i;
        int i3;
        int i2;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int i4 = 0;
        i3 = i;
        while (i < this.string_.size()) {
            i3 += i2;
            i++;
        }
        i6 += size2;
        this.memoizedSerializedSize = i7;
        return i7;
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
        return u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public String p(int i) {
        return (String)this.string_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public r q() {
        return this.string_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.p.b u() {
        return p.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.p.b v() {
        return p.t(this);
    }
}
