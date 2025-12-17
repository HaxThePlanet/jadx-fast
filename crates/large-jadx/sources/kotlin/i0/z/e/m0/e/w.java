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
public final class w extends h implements p {

    private static final kotlin.i0.z.e.m0.e.w a;
    public static q<kotlin.i0.z.e.m0.e.w> b;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<kotlin.i0.z.e.m0.e.v> requirement_;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.w> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.w m(e e, f f2) {
            w wVar = new w(e, f2, 0);
            return wVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.w, kotlin.i0.z.e.m0.e.w.b> implements p {

        private int b;
        private List<kotlin.i0.z.e.m0.e.v> c;
        private b() {
            super();
            this.c = Collections.emptyList();
            o();
        }

        static kotlin.i0.z.e.m0.e.w.b h() {
            return w.b.m();
        }

        private static kotlin.i0.z.e.m0.e.w.b m() {
            w.b bVar = new w.b();
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
            p((w)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.w j() {
            kotlin.i0.z.e.m0.e.w wVar = k();
            if (!wVar.isInitialized()) {
            } else {
                return wVar;
            }
            throw a.a.c(wVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.w k() {
            int i;
            w wVar = new w(this, 0);
            final int i5 = 1;
            if (i3 &= i5 == i5) {
                this.c = Collections.unmodifiableList(this.c);
                this.b = i4 &= -2;
            }
            w.m(wVar, this.c);
            return wVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.w.b l() {
            final kotlin.i0.z.e.m0.e.w.b bVar = w.b.m();
            bVar.p(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.w.b p(kotlin.i0.z.e.m0.e.w w) {
            boolean empty;
            List list;
            if (w == w.o()) {
                return this;
            }
            if (!w.l(w).isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = w.l(w);
                    this.b = i &= -2;
                } else {
                    n();
                    this.c.addAll(w.l(w));
                }
            }
            g(e().d(w.n(w)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.w.b r(e e, f f2) {
            final int i = 0;
            final Object obj3 = w.b.b(e, f2);
            if ((w)obj3 != null) {
                try {
                    p((w)obj3);
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
        w.a aVar = new w.a();
        w.b = aVar;
        w wVar = new w(1);
        w.a = wVar;
        wVar.r();
    }

    private w(e e, f f2) {
        int i;
        int i2;
        List requirement_;
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
            requirement_ = e.K();
            if (requirement_ != 0) {
            } else {
            }
            i = i4;
            if (requirement_ != 10) {
            } else {
            }
            if (i2 & 1 != i4) {
            }
            this.requirement_.add(e.u(v.b, f2));
            arrayList = new ArrayList();
            this.requirement_ = arrayList;
            i2 |= 1;
            if (!j(e, outputStream, f2, requirement_)) {
            }
        }
        if (i2 & 1 == i4) {
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    w(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private w(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    w(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private w(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List l(kotlin.i0.z.e.m0.e.w w) {
        return w.requirement_;
    }

    static List m(kotlin.i0.z.e.m0.e.w w, List list2) {
        w.requirement_ = list2;
        return list2;
    }

    static d n(kotlin.i0.z.e.m0.e.w w) {
        return w.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.w o() {
        return w.a;
    }

    private void r() {
        this.requirement_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.w.b s() {
        return w.b.h();
    }

    public static kotlin.i0.z.e.m0.e.w.b t(kotlin.i0.z.e.m0.e.w w) {
        final kotlin.i0.z.e.m0.e.w.b bVar = w.s();
        bVar.p(w);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int i2;
        Object obj;
        int i;
        getSerializedSize();
        i2 = 0;
        while (i2 < this.requirement_.size()) {
            codedOutputStream.d0(1, (o)this.requirement_.get(i2));
            i2++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.w> getParserForType() {
        return w.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i2;
        int i4;
        int i3;
        int i;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i4 = i2;
        while (i2 < this.requirement_.size()) {
            i4 += i3;
            i2++;
        }
        i4 += size;
        this.memoizedSerializedSize = i6;
        return i6;
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
    public int p() {
        return this.requirement_.size();
    }

    public List<kotlin.i0.z.e.m0.e.v> q() {
        return this.requirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.w.b u() {
        return w.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.w.b v() {
        return w.t(this);
    }
}
