package kotlin.i0.z.e.m0.e.a0;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.e.b;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.d;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.l;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.s;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.d.b;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.h.b;
import kotlin.reflect.jvm.internal.impl.protobuf.h.f;
import kotlin.reflect.jvm.internal.impl.protobuf.o.a;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.w.b;

/* loaded from: classes3.dex */
public final class a {

    public static final h.f<d, kotlin.i0.z.e.m0.e.a0.a.c> a;
    public static final h.f<i, kotlin.i0.z.e.m0.e.a0.a.c> b;
    public static final h.f<i, Integer> c;
    public static final h.f<n, kotlin.i0.z.e.m0.e.a0.a.d> d;
    public static final h.f<n, Integer> e;
    public static final h.f<q, List<b>> f;
    public static final h.f<q, Boolean> g;
    public static final h.f<s, List<b>> h;
    public static final h.f<c, Integer> i;
    public static final h.f<c, List<n>> j;
    public static final h.f<c, Integer> k;
    public static final h.f<c, Integer> l;
    public static final h.f<l, Integer> m;
    public static final h.f<l, List<n>> n;

    static class a {
    }

    public static final class b extends h implements p {

        private static final kotlin.i0.z.e.m0.e.a0.a.b a;
        public static q<kotlin.i0.z.e.m0.e.a0.a.b> b;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final d unknownFields;
        static {
            a.b.a aVar = new a.b.a();
            a.b.b = aVar;
            a.b bVar = new a.b(1);
            a.b.a = bVar;
            bVar.u();
        }

        private b(e e, f f2) {
            int i2;
            int i3;
            int i;
            super();
            int i4 = -1;
            this.memoizedIsInitialized = i4;
            this.memoizedSerializedSize = i4;
            u();
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
                if (i3 != 16) {
                } else {
                }
                this.bitField0_ = bitField0_2 |= 2;
                this.desc_ = e.s();
                if (!j(e, outputStream, f2, i3)) {
                }
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        b(e e, f f2, kotlin.i0.z.e.m0.e.a0.a.a a$a3) {
            super(e, f2);
        }

        private b(h.b h$b) {
            super(b);
            final int i = -1;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        b(h.b h$b, kotlin.i0.z.e.m0.e.a0.a.a a$a2) {
            super(b);
        }

        private b(boolean z) {
            super();
            int obj1 = -1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        static int l(kotlin.i0.z.e.m0.e.a0.a.b a$b, int i2) {
            b.name_ = i2;
            return i2;
        }

        static int m(kotlin.i0.z.e.m0.e.a0.a.b a$b, int i2) {
            b.desc_ = i2;
            return i2;
        }

        static int n(kotlin.i0.z.e.m0.e.a0.a.b a$b, int i2) {
            b.bitField0_ = i2;
            return i2;
        }

        static d o(kotlin.i0.z.e.m0.e.a0.a.b a$b) {
            return b.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.b p() {
            return a.b.a;
        }

        private void u() {
            final int i = 0;
            this.name_ = i;
            this.desc_ = i;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.b.b v() {
            return a.b.b.h();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.b.b w(kotlin.i0.z.e.m0.e.a0.a.b a$b) {
            final kotlin.i0.z.e.m0.e.a0.a.b.b bVar = a.b.v();
            bVar.o(b);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int name_;
            int desc_;
            getSerializedSize();
            int i = 1;
            if (bitField0_ &= i == i) {
                codedOutputStream.a0(i, this.name_);
            }
            int i2 = 2;
            if (bitField0_2 &= i2 == i2) {
                codedOutputStream.a0(i2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.a0.a.b> getParserForType() {
            return a.b.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i;
            int i2;
            int i3;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i6 = 1;
            if (bitField0_ &= i6 == i6) {
                i += i2;
            }
            int i7 = 2;
            if (bitField0_2 &= i7 == i7) {
                i += i3;
            }
            i += size;
            this.memoizedSerializedSize = i4;
            return i4;
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
            return x();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int q() {
            return this.desc_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int r() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean s() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean t() {
            int i;
            i = 1;
            if (bitField0_ &= i == i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.b.b x() {
            return a.b.v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.b.b y() {
            return a.b.w(this);
        }
    }

    public static final class c extends h implements p {

        private static final kotlin.i0.z.e.m0.e.a0.a.c a;
        public static q<kotlin.i0.z.e.m0.e.a0.a.c> b;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final d unknownFields;
        static {
            a.c.a aVar = new a.c.a();
            a.c.b = aVar;
            a.c cVar = new a.c(1);
            a.c.a = cVar;
            cVar.u();
        }

        private c(e e, f f2) {
            int i;
            int i3;
            int i2;
            super();
            int i4 = -1;
            this.memoizedIsInitialized = i4;
            this.memoizedSerializedSize = i4;
            u();
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
                this.name_ = e.s();
                if (i3 != 16) {
                } else {
                }
                this.bitField0_ = bitField0_2 |= 2;
                this.desc_ = e.s();
                if (!j(e, outputStream, f2, i3)) {
                }
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        c(e e, f f2, kotlin.i0.z.e.m0.e.a0.a.a a$a3) {
            super(e, f2);
        }

        private c(h.b h$b) {
            super(b);
            final int i = -1;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        c(h.b h$b, kotlin.i0.z.e.m0.e.a0.a.a a$a2) {
            super(b);
        }

        private c(boolean z) {
            super();
            int obj1 = -1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        static int l(kotlin.i0.z.e.m0.e.a0.a.c a$c, int i2) {
            c.name_ = i2;
            return i2;
        }

        static int m(kotlin.i0.z.e.m0.e.a0.a.c a$c, int i2) {
            c.desc_ = i2;
            return i2;
        }

        static int n(kotlin.i0.z.e.m0.e.a0.a.c a$c, int i2) {
            c.bitField0_ = i2;
            return i2;
        }

        static d o(kotlin.i0.z.e.m0.e.a0.a.c a$c) {
            return c.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.c p() {
            return a.c.a;
        }

        private void u() {
            final int i = 0;
            this.name_ = i;
            this.desc_ = i;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.c.b v() {
            return a.c.b.h();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.c.b w(kotlin.i0.z.e.m0.e.a0.a.c a$c) {
            final kotlin.i0.z.e.m0.e.a0.a.c.b bVar = a.c.v();
            bVar.o(c);
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int name_;
            int desc_;
            getSerializedSize();
            int i = 1;
            if (bitField0_ &= i == i) {
                codedOutputStream.a0(i, this.name_);
            }
            int i2 = 2;
            if (bitField0_2 &= i2 == i2) {
                codedOutputStream.a0(i2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.a0.a.c> getParserForType() {
            return a.c.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i3;
            int i;
            int i2;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i6 = 1;
            if (bitField0_ &= i6 == i6) {
                i3 += i;
            }
            int i7 = 2;
            if (bitField0_2 &= i7 == i7) {
                i3 += i2;
            }
            i3 += size;
            this.memoizedSerializedSize = i4;
            return i4;
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
            return x();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int q() {
            return this.desc_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int r() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean s() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean t() {
            int i;
            i = 1;
            if (bitField0_ &= i == i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.c.b x() {
            return a.c.v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.c.b y() {
            return a.c.w(this);
        }
    }

    public static final class d extends h implements p {

        private static final kotlin.i0.z.e.m0.e.a0.a.d a;
        public static q<kotlin.i0.z.e.m0.e.a0.a.d> b;
        private int bitField0_;
        private kotlin.i0.z.e.m0.e.a0.a.b field_;
        private kotlin.i0.z.e.m0.e.a0.a.c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private kotlin.i0.z.e.m0.e.a0.a.c setter_;
        private kotlin.i0.z.e.m0.e.a0.a.c syntheticMethod_;
        private final d unknownFields;
        static {
            a.d.a aVar = new a.d.a();
            a.d.b = aVar;
            a.d dVar = new a.d(1);
            a.d.a = dVar;
            dVar.A();
        }

        private d(e e, f f2) {
            int i;
            int i2;
            int field_;
            kotlin.reflect.jvm.internal.impl.protobuf.o oVar2;
            int setter_;
            kotlin.reflect.jvm.internal.impl.protobuf.o oVar3;
            int getter_;
            kotlin.reflect.jvm.internal.impl.protobuf.o oVar4;
            int syntheticMethod_;
            kotlin.reflect.jvm.internal.impl.protobuf.o oVar;
            int i4;
            int i3;
            super();
            int i5 = -1;
            this.memoizedIsInitialized = i5;
            this.memoizedSerializedSize = i5;
            A();
            d.b bVar = d.w();
            final int i6 = 1;
            final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i6);
            i = 0;
            while (i == 0) {
                i2 = e.K();
                if (i2 != 0) {
                } else {
                }
                i = i6;
                i3 = 0;
                if (i2 != 10) {
                } else {
                }
                if (bitField0_ &= i6 == i6) {
                }
                oVar2 = e.u(a.b.b, f2);
                this.field_ = (a.b)oVar2;
                if (i3 != 0) {
                }
                this.bitField0_ = bitField0_2 |= i6;
                i3.o(oVar2);
                this.field_ = i3.k();
                i3 = this.field_.y();
                if (i2 != 18) {
                } else {
                }
                i4 = 2;
                if (bitField0_7 &= i4 == i4) {
                }
                oVar = e.u(a.c.b, f2);
                this.syntheticMethod_ = (a.c)oVar;
                if (i3 != 0) {
                }
                this.bitField0_ = bitField0_8 |= i4;
                i3.o(oVar);
                this.syntheticMethod_ = i3.k();
                i3 = this.syntheticMethod_.y();
                if (i2 != 26) {
                } else {
                }
                i4 = 4;
                if (bitField0_5 &= i4 == i4) {
                }
                oVar4 = e.u(a.c.b, f2);
                this.getter_ = (a.c)oVar4;
                if (i3 != 0) {
                }
                this.bitField0_ = bitField0_6 |= i4;
                i3.o(oVar4);
                this.getter_ = i3.k();
                i3 = this.getter_.y();
                if (i2 != 34) {
                } else {
                }
                i4 = 8;
                if (bitField0_3 &= i4 == i4) {
                }
                oVar3 = e.u(a.c.b, f2);
                this.setter_ = (a.c)oVar3;
                if (i3 != 0) {
                }
                this.bitField0_ = bitField0_4 |= i4;
                i3.o(oVar3);
                this.setter_ = i3.k();
                i3 = this.setter_.y();
                if (!j(e, outputStream, f2, i2)) {
                }
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        d(e e, f f2, kotlin.i0.z.e.m0.e.a0.a.a a$a3) {
            super(e, f2);
        }

        private d(h.b h$b) {
            super(b);
            final int i = -1;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        d(h.b h$b, kotlin.i0.z.e.m0.e.a0.a.a a$a2) {
            super(b);
        }

        private d(boolean z) {
            super();
            int obj1 = -1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        private void A() {
            this.field_ = a.b.p();
            this.syntheticMethod_ = a.c.p();
            this.getter_ = a.c.p();
            this.setter_ = a.c.p();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.d.b B() {
            return a.d.b.h();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.d.b C(kotlin.i0.z.e.m0.e.a0.a.d a$d) {
            final kotlin.i0.z.e.m0.e.a0.a.d.b bVar = a.d.B();
            bVar.p(d);
            return bVar;
        }

        static kotlin.i0.z.e.m0.e.a0.a.b l(kotlin.i0.z.e.m0.e.a0.a.d a$d, kotlin.i0.z.e.m0.e.a0.a.b a$b2) {
            d.field_ = b2;
            return b2;
        }

        static kotlin.i0.z.e.m0.e.a0.a.c m(kotlin.i0.z.e.m0.e.a0.a.d a$d, kotlin.i0.z.e.m0.e.a0.a.c a$c2) {
            d.syntheticMethod_ = c2;
            return c2;
        }

        static kotlin.i0.z.e.m0.e.a0.a.c n(kotlin.i0.z.e.m0.e.a0.a.d a$d, kotlin.i0.z.e.m0.e.a0.a.c a$c2) {
            d.getter_ = c2;
            return c2;
        }

        static kotlin.i0.z.e.m0.e.a0.a.c o(kotlin.i0.z.e.m0.e.a0.a.d a$d, kotlin.i0.z.e.m0.e.a0.a.c a$c2) {
            d.setter_ = c2;
            return c2;
        }

        static int p(kotlin.i0.z.e.m0.e.a0.a.d a$d, int i2) {
            d.bitField0_ = i2;
            return i2;
        }

        static d q(kotlin.i0.z.e.m0.e.a0.a.d a$d) {
            return d.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.d r() {
            return a.d.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.d.b D() {
            return a.d.B();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.d.b E() {
            return a.d.C(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int field_;
            int syntheticMethod_;
            int i;
            int setter_;
            kotlin.i0.z.e.m0.e.a0.a.c getter_;
            getSerializedSize();
            int i2 = 1;
            if (bitField0_ &= i2 == i2) {
                codedOutputStream.d0(i2, this.field_);
            }
            int i3 = 2;
            if (bitField0_2 &= i3 == i3) {
                codedOutputStream.d0(i3, this.syntheticMethod_);
            }
            int i4 = 4;
            if (bitField0_3 &= i4 == i4) {
                codedOutputStream.d0(3, this.getter_);
            }
            int i5 = 8;
            if (bitField0_4 &= i5 == i5) {
                codedOutputStream.d0(i4, this.setter_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.a0.a.d> getParserForType() {
            return a.d.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i5;
            int i3;
            int i;
            int i2;
            int i4;
            kotlin.i0.z.e.m0.e.a0.a.c getter_;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            int i9 = 1;
            if (bitField0_ &= i9 == i9) {
                i5 += i3;
            }
            int i10 = 2;
            if (bitField0_2 &= i10 == i10) {
                i5 += i;
            }
            int i11 = 4;
            if (bitField0_3 &= i11 == i11) {
                i5 += i2;
            }
            int i12 = 8;
            if (bitField0_4 &= i12 == i12) {
                i5 += i4;
            }
            i5 += size;
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
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.b s() {
            return this.field_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.c t() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.c u() {
            return this.setter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.c v() {
            return this.syntheticMethod_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean w() {
            int i;
            i = 1;
            if (bitField0_ &= i == i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean x() {
            int i;
            final int i3 = 4;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean y() {
            int i;
            final int i3 = 8;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean z() {
            int i;
            final int i3 = 2;
            i = bitField0_ &= i3 == i3 ? 1 : 0;
            return i;
        }
    }

    public static final class e extends h implements p {

        private static final kotlin.i0.z.e.m0.e.a0.a.e a;
        public static q<kotlin.i0.z.e.m0.e.a0.a.e> b;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<kotlin.i0.z.e.m0.e.a0.a.e.c> record_;
        private final d unknownFields;
        static {
            a.e.a aVar = new a.e.a();
            a.e.b = aVar;
            a.e eVar = new a.e(1);
            a.e.a = eVar;
            eVar.t();
        }

        private e(e e, f f2) {
            int i;
            int i2;
            f fVar;
            List localName_;
            int arrayList;
            int arrayList2;
            kotlin.reflect.jvm.internal.impl.protobuf.o valueOf2;
            int localName_2;
            Integer valueOf;
            int obj10;
            super();
            int i3 = -1;
            this.localNameMemoizedSerializedSize = i3;
            this.memoizedIsInitialized = i3;
            this.memoizedSerializedSize = i3;
            t();
            d.b bVar = d.w();
            final int i4 = 1;
            final CodedOutputStream outputStream = CodedOutputStream.J(bVar, i4);
            i2 = i;
            fVar = 2;
            while (i == 0) {
                localName_ = e.K();
                if (localName_ != 0) {
                } else {
                }
                i = i4;
                fVar = 2;
                if (localName_ != 10) {
                } else {
                }
                if (i2 & 1 != i4) {
                }
                this.record_.add(e.u(a.e.c.b, f2));
                arrayList = new ArrayList();
                this.record_ = arrayList;
                i2 |= 1;
                if (localName_ != 40) {
                } else {
                }
                if (i2 & 2 != fVar) {
                }
                this.localName_.add(Integer.valueOf(e.s()));
                arrayList2 = new ArrayList();
                this.localName_ = arrayList2;
                i2 |= 2;
                if (localName_ != 42) {
                } else {
                }
                if (i2 & 2 != fVar && e.e() > 0) {
                }
                while (e.e() > 0) {
                    this.localName_.add(Integer.valueOf(e.s()));
                }
                e.i(e.j(e.A()));
                this.localName_.add(Integer.valueOf(e.s()));
                if (e.e() > 0) {
                }
                localName_2 = new ArrayList();
                this.localName_ = localName_2;
                i2 |= 2;
                if (!j(e, outputStream, f2, localName_)) {
                }
            }
            if (i2 & 1 == i4) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (i2 & 2 == fVar) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            outputStream.I();
            this.unknownFields = bVar.i();
            g();
        }

        e(e e, f f2, kotlin.i0.z.e.m0.e.a0.a.a a$a3) {
            super(e, f2);
        }

        private e(h.b h$b) {
            super(b);
            final int i = -1;
            this.localNameMemoizedSerializedSize = i;
            this.memoizedIsInitialized = i;
            this.memoizedSerializedSize = i;
            this.unknownFields = b.e();
        }

        e(h.b h$b, kotlin.i0.z.e.m0.e.a0.a.a a$a2) {
            super(b);
        }

        private e(boolean z) {
            super();
            int obj1 = -1;
            this.localNameMemoizedSerializedSize = obj1;
            this.memoizedIsInitialized = obj1;
            this.memoizedSerializedSize = obj1;
            this.unknownFields = d.a;
        }

        static List l(kotlin.i0.z.e.m0.e.a0.a.e a$e) {
            return e.record_;
        }

        static List m(kotlin.i0.z.e.m0.e.a0.a.e a$e, List list2) {
            e.record_ = list2;
            return list2;
        }

        static List n(kotlin.i0.z.e.m0.e.a0.a.e a$e) {
            return e.localName_;
        }

        static List o(kotlin.i0.z.e.m0.e.a0.a.e a$e, List list2) {
            e.localName_ = list2;
            return list2;
        }

        static d p(kotlin.i0.z.e.m0.e.a0.a.e a$e) {
            return e.unknownFields;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.e q() {
            return a.e.a;
        }

        private void t() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.e.b u() {
            return a.e.b.h();
        }

        public static kotlin.i0.z.e.m0.e.a0.a.e.b v(kotlin.i0.z.e.m0.e.a0.a.e a$e) {
            final kotlin.i0.z.e.m0.e.a0.a.e.b bVar = a.e.u();
            bVar.r(e);
            return bVar;
        }

        public static kotlin.i0.z.e.m0.e.a0.a.e x(InputStream inputStream, f f2) {
            return (a.e)a.e.b.c(inputStream, f2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void a(CodedOutputStream codedOutputStream) {
            int i;
            int i2;
            int localNameMemoizedSerializedSize;
            Object obj;
            int i3;
            getSerializedSize();
            i2 = i;
            while (i2 < this.record_.size()) {
                codedOutputStream.d0(1, (o)this.record_.get(i2));
                i2++;
            }
            if (r().size() > 0) {
                codedOutputStream.o0(42);
                codedOutputStream.o0(this.localNameMemoizedSerializedSize);
            }
            while (i < this.localName_.size()) {
                codedOutputStream.b0((Integer)this.localName_.get(i).intValue());
                i++;
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public q<kotlin.i0.z.e.m0.e.a0.a.e> getParserForType() {
            return a.e.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public int getSerializedSize() {
            int i6;
            boolean empty;
            int i5;
            int i3;
            int i;
            int i7;
            int i2;
            int size;
            int i4;
            int memoizedSerializedSize = this.memoizedSerializedSize;
            if (memoizedSerializedSize != -1) {
                return memoizedSerializedSize;
            }
            i6 = 0;
            i = i5;
            while (i5 < this.record_.size()) {
                i += i2;
                i5++;
            }
            i3 = i6;
            while (i6 < this.localName_.size()) {
                i3 += size;
                i6++;
            }
            if (!r().isEmpty()) {
                i10 += empty;
            }
            this.localNameMemoizedSerializedSize = i3;
            i7 += size2;
            this.memoizedSerializedSize = i9;
            return i9;
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
            return w();
        }

        public List<Integer> r() {
            return this.localName_;
        }

        public List<kotlin.i0.z.e.m0.e.a0.a.e.c> s() {
            return this.record_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public o.a toBuilder() {
            return y();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.e.b w() {
            return a.e.u();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public kotlin.i0.z.e.m0.e.a0.a.e.b y() {
            return a.e.v(this);
        }
    }
    static {
        final w.b mESSAGE = w.b.MESSAGE;
        a.a = h.i(d.B(), a.c.p(), a.c.p(), 0, 100, mESSAGE, a.c.class);
        w.b bVar12 = mESSAGE;
        a.b = h.i(i.M(), a.c.p(), a.c.p(), 0, 100, bVar12, a.c.class);
        Integer valueOf = 0;
        final w.b iNT32 = w.b.INT32;
        a.c = h.i(i.M(), valueOf, 0, 0, 101, iNT32, Integer.class);
        a.d = h.i(n.K(), a.d.r(), a.d.r(), 0, 100, bVar12, a.d.class);
        int i11 = 0;
        a.e = h.i(n.K(), valueOf, 0, i11, 101, iNT32, Integer.class);
        a.f = h.h(q.R(), b.t(), i11, 100, mESSAGE, false, b.class);
        a.g = h.i(q.R(), Boolean.FALSE, 0, i11, 101, w.b.BOOL, Boolean.class);
        a.h = h.h(s.E(), b.t(), i11, 100, mESSAGE, false, b.class);
        a.i = h.i(c.b0(), valueOf, 0, i11, 101, iNT32, Integer.class);
        a.j = h.h(c.b0(), n.K(), i11, 102, mESSAGE, false, n.class);
        int i9 = 0;
        Integer num4 = valueOf;
        w.b bVar10 = iNT32;
        a.k = h.i(c.b0(), num4, i9, i11, 103, bVar10, Integer.class);
        a.l = h.i(c.b0(), num4, i9, i11, 104, bVar10, Integer.class);
        a.m = h.i(l.E(), num4, i9, i11, 101, bVar10, Integer.class);
        a.n = h.h(l.E(), n.K(), i11, 102, mESSAGE, false, n.class);
    }

    public static void a(f f) {
        f.a(a.a);
        f.a(a.b);
        f.a(a.c);
        f.a(a.d);
        f.a(a.e);
        f.a(a.f);
        f.a(a.g);
        f.a(a.h);
        f.a(a.i);
        f.a(a.j);
        f.a(a.k);
        f.a(a.l);
        f.a(a.m);
        f.a(a.n);
    }
}
