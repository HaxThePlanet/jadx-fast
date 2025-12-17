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
public final class e extends h implements p {

    private static final kotlin.i0.z.e.m0.e.e a;
    public static q<kotlin.i0.z.e.m0.e.e> b;
    private List<kotlin.i0.z.e.m0.e.f> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final d unknownFields;

    static class a extends b<kotlin.i0.z.e.m0.e.e> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.e m(e e, f f2) {
            e eVar = new e(e, f2, 0);
            return eVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.e, kotlin.i0.z.e.m0.e.e.b> implements p {

        private int b;
        private List<kotlin.i0.z.e.m0.e.f> c;
        private b() {
            super();
            this.c = Collections.emptyList();
            o();
        }

        static kotlin.i0.z.e.m0.e.e.b h() {
            return e.b.m();
        }

        private static kotlin.i0.z.e.m0.e.e.b m() {
            e.b bVar = new e.b();
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
            p((e)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.e j() {
            kotlin.i0.z.e.m0.e.e eVar = k();
            if (!eVar.isInitialized()) {
            } else {
                return eVar;
            }
            throw a.a.c(eVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            r(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.e k() {
            int i;
            e eVar = new e(this, 0);
            final int i5 = 1;
            if (i3 &= i5 == i5) {
                this.c = Collections.unmodifiableList(this.c);
                this.b = i4 &= -2;
            }
            e.m(eVar, this.c);
            return eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.e.b l() {
            final kotlin.i0.z.e.m0.e.e.b bVar = e.b.m();
            bVar.p(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.e.b p(kotlin.i0.z.e.m0.e.e e) {
            boolean empty;
            List list;
            if (e == e.o()) {
                return this;
            }
            if (!e.l(e).isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = e.l(e);
                    this.b = i &= -2;
                } else {
                    n();
                    this.c.addAll(e.l(e));
                }
            }
            g(e().d(e.n(e)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.e.b r(e e, f f2) {
            final int i = 0;
            final Object obj3 = e.b.b(e, f2);
            if ((e)obj3 != null) {
                try {
                    p((e)obj3);
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
        e.a aVar = new e.a();
        e.b = aVar;
        e eVar = new e(1);
        e.a = eVar;
        eVar.r();
    }

    private e(e e, f f2) {
        int i;
        int i2;
        List effect_;
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
            effect_ = e.K();
            if (effect_ != 0) {
            } else {
            }
            i = i4;
            if (effect_ != 10) {
            } else {
            }
            if (i2 & 1 != i4) {
            }
            this.effect_.add(e.u(f.b, f2));
            arrayList = new ArrayList();
            this.effect_ = arrayList;
            i2 |= 1;
            if (!j(e, outputStream, f2, effect_)) {
            }
        }
        if (i2 & 1 == i4) {
            this.effect_ = Collections.unmodifiableList(this.effect_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    e(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private e(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    e(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private e(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    static List l(kotlin.i0.z.e.m0.e.e e) {
        return e.effect_;
    }

    static List m(kotlin.i0.z.e.m0.e.e e, List list2) {
        e.effect_ = list2;
        return list2;
    }

    static d n(kotlin.i0.z.e.m0.e.e e) {
        return e.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.e o() {
        return e.a;
    }

    private void r() {
        this.effect_ = Collections.emptyList();
    }

    public static kotlin.i0.z.e.m0.e.e.b s() {
        return e.b.h();
    }

    public static kotlin.i0.z.e.m0.e.e.b t(kotlin.i0.z.e.m0.e.e e) {
        final kotlin.i0.z.e.m0.e.e.b bVar = e.s();
        bVar.p(e);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int i2;
        Object obj;
        int i;
        getSerializedSize();
        i2 = 0;
        while (i2 < this.effect_.size()) {
            codedOutputStream.d0(1, (o)this.effect_.get(i2));
            i2++;
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.e> getParserForType() {
        return e.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i;
        int i3;
        int i4;
        int i2;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i3 = i;
        while (i < this.effect_.size()) {
            i3 += i4;
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
    public kotlin.i0.z.e.m0.e.f p(int i) {
        return (f)this.effect_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int q() {
        return this.effect_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.e.b u() {
        return e.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.e.b v() {
        return e.t(this);
    }
}
