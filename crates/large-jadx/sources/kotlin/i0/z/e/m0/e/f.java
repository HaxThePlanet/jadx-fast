package kotlin.i0.z.e.m0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public final class f extends h implements p {

    private static final kotlin.i0.z.e.m0.e.f a;
    public static q<kotlin.i0.z.e.m0.e.f> b;
    private int bitField0_;
    private kotlin.i0.z.e.m0.e.h conclusionOfConditionalEffect_;
    private List<kotlin.i0.z.e.m0.e.h> effectConstructorArgument_;
    private kotlin.i0.z.e.m0.e.f.c effectType_;
    private kotlin.i0.z.e.m0.e.f.d kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final d unknownFields;

    public static enum c implements i.a {

        RETURNS_CONSTANT(false, false),
        CALLS(true, true),
        RETURNS_NOT_NULL(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.f.c valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return f.c.RETURNS_NOT_NULL;
                }
                return f.c.CALLS;
            }
            return f.c.RETURNS_CONSTANT;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static enum d implements i.a {

        AT_MOST_ONCE(false, false),
        EXACTLY_ONCE(true, true),
        AT_LEAST_ONCE(2, 2);

        private final int value;
        public static kotlin.i0.z.e.m0.e.f.d valueOf(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return f.d.AT_LEAST_ONCE;
                }
                return f.d.EXACTLY_ONCE;
            }
            return f.d.AT_MOST_ONCE;
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    static class a extends b<kotlin.i0.z.e.m0.e.f> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public Object b(e e, f f2) {
            return m(e, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.b
        public kotlin.i0.z.e.m0.e.f m(e e, f f2) {
            f fVar = new f(e, f2, 0);
            return fVar;
        }
    }

    public static final class b extends h.b<kotlin.i0.z.e.m0.e.f, kotlin.i0.z.e.m0.e.f.b> implements p {

        private int b;
        private kotlin.i0.z.e.m0.e.f.c c;
        private List<kotlin.i0.z.e.m0.e.h> v;
        private kotlin.i0.z.e.m0.e.h w;
        private kotlin.i0.z.e.m0.e.f.d x;
        private b() {
            super();
            this.c = f.c.RETURNS_CONSTANT;
            this.v = Collections.emptyList();
            this.w = h.z();
            this.x = f.d.AT_MOST_ONCE;
            o();
        }

        static kotlin.i0.z.e.m0.e.f.b h() {
            return f.b.m();
        }

        private static kotlin.i0.z.e.m0.e.f.b m() {
            f.b bVar = new f.b();
            return bVar;
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
            s(e, f2);
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
            r((f)h);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f j() {
            kotlin.i0.z.e.m0.e.f fVar = k();
            if (!fVar.isInitialized()) {
            } else {
                return fVar;
            }
            throw a.a.c(fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public o.a j0(e e, f f2) {
            s(e, f2);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f k() {
            int i;
            int i2;
            f fVar = new f(this, 0);
            int i4 = this.b;
            if (i4 & 1 == 1) {
            } else {
                i2 = 0;
            }
            f.l(fVar, this.c);
            int i11 = 2;
            if (i7 &= i11 == i11) {
                this.v = Collections.unmodifiableList(this.v);
                this.b = i10 &= -3;
            }
            f.n(fVar, this.v);
            if (i4 & 4 == 4) {
                i2 |= 2;
            }
            f.o(fVar, this.w);
            int i9 = 8;
            if (i4 &= i9 == i9) {
                i2 |= 4;
            }
            f.p(fVar, this.x);
            f.q(fVar, i2);
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b l() {
            final kotlin.i0.z.e.m0.e.f.b bVar = f.b.m();
            bVar.r(k());
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b p(kotlin.i0.z.e.m0.e.h h) {
            int i;
            kotlin.i0.z.e.m0.e.h hVar;
            kotlin.i0.z.e.m0.e.h obj4;
            final int i3 = 4;
            if (i2 &= i3 == i3 && this.w != h.z()) {
                if (this.w != h.z()) {
                    i = h.N(this.w);
                    i.r(h);
                    this.w = i.k();
                } else {
                    this.w = h;
                }
            } else {
            }
            this.b = obj4 |= i3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b r(kotlin.i0.z.e.m0.e.f f) {
            boolean z3;
            boolean empty;
            boolean z2;
            boolean z;
            List list;
            if (f == f.t()) {
                return this;
            }
            if (f.z()) {
                t(f.w());
            }
            if (!f.m(f).isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = f.m(f);
                    this.b = i &= -3;
                } else {
                    n();
                    this.v.addAll(f.m(f));
                }
            }
            if (f.y()) {
                p(f.s());
            }
            if (f.A()) {
                u(f.x());
            }
            g(e().d(f.r(f)));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b s(e e, f f2) {
            final int i = 0;
            final Object obj3 = f.b.b(e, f2);
            if ((f)obj3 != null) {
                try {
                    r((f)obj3);
                    return this;
                    f2 = e.a();
                    throw e;
                    f fVar = f2;
                    if (fVar == null) {
                    } else {
                    }
                    r(fVar);
                    throw e;
                } catch (Throwable th) {
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b t(kotlin.i0.z.e.m0.e.f.c f$c) {
            Objects.requireNonNull(c);
            this.b = i |= 1;
            this.c = c;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h$b
        public kotlin.i0.z.e.m0.e.f.b u(kotlin.i0.z.e.m0.e.f.d f$d) {
            Objects.requireNonNull(d);
            this.b = i |= 8;
            this.x = d;
            return this;
        }
    }
    static {
        f.a aVar = new f.a();
        f.b = aVar;
        f fVar = new f(1);
        f.a = fVar;
        fVar.B();
    }

    private f(e e, f f2) {
        int i2;
        int i3;
        f fVar;
        int effectConstructorArgument_;
        int arrayList;
        int i4;
        int i;
        Enum valueOf;
        int obj10;
        super();
        int i5 = -1;
        this.memoizedIsInitialized = i5;
        this.memoizedSerializedSize = i5;
        B();
        d.b bVar = d.w();
        final int i6 = 1;
        final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
        i3 = i2;
        fVar = 2;
        while (i2 == 0) {
            effectConstructorArgument_ = e.K();
            if (effectConstructorArgument_ != 0) {
            } else {
            }
            i2 = i6;
            fVar = 2;
            if (effectConstructorArgument_ != 8) {
            } else {
            }
            i = e.n();
            valueOf = f.c.valueOf(i);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_ |= i6;
            this.effectType_ = valueOf;
            outputStream.o0(effectConstructorArgument_);
            outputStream.o0(i);
            if (effectConstructorArgument_ != 18) {
            } else {
            }
            if (i3 & 2 != fVar) {
            }
            this.effectConstructorArgument_.add(e.u(h.b, f2));
            arrayList = new ArrayList();
            this.effectConstructorArgument_ = arrayList;
            i3 |= 2;
            if (effectConstructorArgument_ != 26) {
            } else {
            }
            i4 = 0;
            if (bitField0_4 &= fVar == fVar) {
            }
            i = e.u(h.b, f2);
            this.conclusionOfConditionalEffect_ = (h)i;
            if (i4 != 0) {
            }
            this.bitField0_ = bitField0_3 |= fVar;
            i4.r(i);
            this.conclusionOfConditionalEffect_ = i4.k();
            i4 = this.conclusionOfConditionalEffect_.P();
            if (effectConstructorArgument_ != 32) {
            } else {
            }
            i = e.n();
            valueOf = f.d.valueOf(i);
            if (valueOf == null) {
            } else {
            }
            this.bitField0_ = bitField0_2 |= 4;
            this.kind_ = valueOf;
            outputStream.o0(effectConstructorArgument_);
            outputStream.o0(i);
            if (!j(e, outputStream, f2, effectConstructorArgument_)) {
            }
        }
        if (i3 & 2 == fVar) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        }
        outputStream.I();
        this.unknownFields = bVar.i();
        g();
    }

    f(e e, f f2, kotlin.i0.z.e.m0.e.a a3) {
        super(e, f2);
    }

    private f(h.b h$b) {
        super(b);
        final int i = -1;
        this.memoizedIsInitialized = i;
        this.memoizedSerializedSize = i;
        this.unknownFields = b.e();
    }

    f(h.b h$b, kotlin.i0.z.e.m0.e.a a2) {
        super(b);
    }

    private f(boolean z) {
        super();
        int obj1 = -1;
        this.memoizedIsInitialized = obj1;
        this.memoizedSerializedSize = obj1;
        this.unknownFields = d.a;
    }

    private void B() {
        this.effectType_ = f.c.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = h.z();
        this.kind_ = f.d.AT_MOST_ONCE;
    }

    public static kotlin.i0.z.e.m0.e.f.b C() {
        return f.b.h();
    }

    public static kotlin.i0.z.e.m0.e.f.b D(kotlin.i0.z.e.m0.e.f f) {
        final kotlin.i0.z.e.m0.e.f.b bVar = f.C();
        bVar.r(f);
        return bVar;
    }

    static kotlin.i0.z.e.m0.e.f.c l(kotlin.i0.z.e.m0.e.f f, kotlin.i0.z.e.m0.e.f.c f$c2) {
        f.effectType_ = c2;
        return c2;
    }

    static List m(kotlin.i0.z.e.m0.e.f f) {
        return f.effectConstructorArgument_;
    }

    static List n(kotlin.i0.z.e.m0.e.f f, List list2) {
        f.effectConstructorArgument_ = list2;
        return list2;
    }

    static kotlin.i0.z.e.m0.e.h o(kotlin.i0.z.e.m0.e.f f, kotlin.i0.z.e.m0.e.h h2) {
        f.conclusionOfConditionalEffect_ = h2;
        return h2;
    }

    static kotlin.i0.z.e.m0.e.f.d p(kotlin.i0.z.e.m0.e.f f, kotlin.i0.z.e.m0.e.f.d f$d2) {
        f.kind_ = d2;
        return d2;
    }

    static int q(kotlin.i0.z.e.m0.e.f f, int i2) {
        f.bitField0_ = i2;
        return i2;
    }

    static d r(kotlin.i0.z.e.m0.e.f f) {
        return f.unknownFields;
    }

    public static kotlin.i0.z.e.m0.e.f t() {
        return f.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean A() {
        int i;
        final int i3 = 4;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.f.b E() {
        return f.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.f.b F() {
        return f.D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public void a(CodedOutputStream codedOutputStream) {
        int number;
        int i2;
        int i3;
        int number2;
        int i4;
        int conclusionOfConditionalEffect_;
        int i;
        getSerializedSize();
        i4 = 1;
        if (bitField0_ &= i4 == i4) {
            codedOutputStream.S(i4, this.effectType_.getNumber());
        }
        i2 = 0;
        i = 2;
        while (i2 < this.effectConstructorArgument_.size()) {
            codedOutputStream.d0(i, (o)this.effectConstructorArgument_.get(i2));
            i2++;
            i = 2;
        }
        if (bitField0_2 &= i == i) {
            codedOutputStream.d0(3, this.conclusionOfConditionalEffect_);
        }
        int i5 = 4;
        if (bitField0_3 &= i5 == i5) {
            codedOutputStream.S(i5, this.kind_.getNumber());
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public q<kotlin.i0.z.e.m0.e.f> getParserForType() {
        return f.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int getSerializedSize() {
        int i5;
        int i;
        int i2;
        int i3;
        int conclusionOfConditionalEffect_;
        int i4;
        int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        i = 1;
        conclusionOfConditionalEffect_ = 0;
        if (bitField0_ &= i == i) {
            i7 += conclusionOfConditionalEffect_;
        } else {
            i5 = conclusionOfConditionalEffect_;
        }
        i4 = 2;
        while (conclusionOfConditionalEffect_ < this.effectConstructorArgument_.size()) {
            i5 += i;
            conclusionOfConditionalEffect_++;
            i4 = 2;
        }
        if (bitField0_2 &= i4 == i4) {
            i5 += i2;
        }
        int i11 = 4;
        if (bitField0_3 &= i11 == i11) {
            i5 += i3;
        }
        i5 += size2;
        this.memoizedSerializedSize = i8;
        return i8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public final boolean isInitialized() {
        int i;
        boolean initialized2;
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
        while (i < v()) {
            i++;
        }
        if (y() && !s().isInitialized()) {
            if (!s().isInitialized()) {
                this.memoizedIsInitialized = i3;
                return i3;
            }
        }
        this.memoizedIsInitialized = i2;
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a newBuilderForType() {
        return E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h s() {
        return this.conclusionOfConditionalEffect_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public o.a toBuilder() {
        return F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.h u(int i) {
        return (h)this.effectConstructorArgument_.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public int v() {
        return this.effectConstructorArgument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.f.c w() {
        return this.effectType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public kotlin.i0.z.e.m0.e.f.d x() {
        return this.kind_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean y() {
        int i;
        final int i3 = 2;
        i = bitField0_ &= i3 == i3 ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
    public boolean z() {
        int i;
        i = 1;
        if (bitField0_ &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }
}
