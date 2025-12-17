package f.c.e.c;

import android.accounts.Account;
import com.google.protobuf.a;
import com.google.protobuf.a0;
import com.google.protobuf.a0.b;
import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class t extends z<f.c.e.c.t, f.c.e.c.t.b> implements u0 {

    private static final f.c.e.c.t DEFAULT_INSTANCE = null;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile d1<f.c.e.c.t> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private f.c.e.c.g endAt_;
    private c0.j<f.c.e.c.t.c> from_;
    private a0 limit_;
    private int offset_;
    private c0.j<f.c.e.c.t.i> orderBy_;
    private f.c.e.c.t.j select_;
    private f.c.e.c.g startAt_;
    private f.c.e.c.t.h where_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            t.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            t.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            t.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            t.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            t.a.a[z.f.GET_PARSER.ordinal()] = 5;
            t.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            t.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum e implements c0.c {

        DIRECTION_UNSPECIFIED(false),
        ASCENDING(true),
        DESCENDING(2),
        UNRECOGNIZED(-1);

        private final int value;
        public static f.c.e.c.t.e forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return t.e.DESCENDING;
                }
                return t.e.ASCENDING;
            }
            return t.e.DIRECTION_UNSPECIFIED;
        }

        public static c0.d<f.c.e.c.t.e> internalGetValueMap() {
            return t.e.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return t.e.b.a;
        }

        @Deprecated
        public static f.c.e.c.t.e valueOf(int i) {
            return t.e.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == t.e.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public static final class b extends z.a<f.c.e.c.t, f.c.e.c.t.b> implements u0 {
        private b() {
            super(t.b());
        }

        b(f.c.e.c.t.a t$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b b(f.c.e.c.t.c.a t$c$a) {
            copyOnWrite();
            t.c((t)this.instance, (t.c)a.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b c(f.c.e.c.t.i t$i) {
            copyOnWrite();
            t.e((t)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b d(f.c.e.c.g.b g$b) {
            copyOnWrite();
            t.g((t)this.instance, (g)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b e(a0.b a0$b) {
            copyOnWrite();
            t.h((t)this.instance, (a0)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b f(f.c.e.c.g.b g$b) {
            copyOnWrite();
            t.f((t)this.instance, (g)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.t.b g(f.c.e.c.t.h t$h) {
            copyOnWrite();
            t.d((t)this.instance, h);
            return this;
        }
    }

    public static final class c extends z<f.c.e.c.t.c, f.c.e.c.t.c.a> implements u0 {

        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final f.c.e.c.t.c DEFAULT_INSTANCE;
        private static volatile d1<f.c.e.c.t.c> PARSER;
        private boolean allDescendants_;
        private String collectionId_;
        static {
            t.c cVar = new t.c();
            t.c.DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(t.c.class, cVar);
        }

        private c() {
            super();
            this.collectionId_ = "";
        }

        static f.c.e.c.t.c b() {
            return t.c.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.c t$c, String string2) {
            c.i(string2);
        }

        static void d(f.c.e.c.t.c t$c, boolean z2) {
            c.h(z2);
        }

        public static f.c.e.c.t.c.a g() {
            return (t.c.a)t.c.DEFAULT_INSTANCE.createBuilder();
        }

        private void h(boolean z) {
            this.allDescendants_ = z;
        }

        private void i(String string) {
            string.getClass();
            this.collectionId_ = string;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.c();
                    return obj2;
                case 2:
                    obj2 = new t.c.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "allDescendants_";
                    return z.newMessageInfo(t.c.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", obj2);
                case 4:
                    return t.c.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.c.class;
            synchronized (obj3) {
                obj2 = new z.b(t.c.DEFAULT_INSTANCE);
                t.c.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public boolean e() {
            return this.allDescendants_;
        }

        @Override // com.google.protobuf.z
        public String f() {
            return this.collectionId_;
        }
    }

    public static final class d extends z<f.c.e.c.t.d, f.c.e.c.t.d.a> implements u0 {

        private static final f.c.e.c.t.d DEFAULT_INSTANCE = null;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile d1<f.c.e.c.t.d> PARSER;
        private c0.j<f.c.e.c.t.h> filters_;
        private int op_;
        static {
            t.d dVar = new t.d();
            t.d.DEFAULT_INSTANCE = dVar;
            z.registerDefaultInstance(t.d.class, dVar);
        }

        private d() {
            super();
            this.filters_ = z.emptyProtobufList();
        }

        static f.c.e.c.t.d b() {
            return t.d.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.d t$d, f.c.e.c.t.d.b t$d$b2) {
            d.k(b2);
        }

        static void d(f.c.e.c.t.d t$d, Iterable iterable2) {
            d.e(iterable2);
        }

        private void e(Iterable<? extends f.c.e.c.t.h> iterable) {
            f();
            a.addAll(iterable, this.filters_);
        }

        private void f() {
            c0.j mutableCopy;
            mutableCopy = this.filters_;
            if (!mutableCopy.c2()) {
                this.filters_ = z.mutableCopy(mutableCopy);
            }
        }

        public static f.c.e.c.t.d g() {
            return t.d.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.t.d.a j() {
            return (t.d.a)t.d.DEFAULT_INSTANCE.createBuilder();
        }

        private void k(f.c.e.c.t.d.b t$d$b) {
            this.op_ = b.getNumber();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.d();
                    return obj2;
                case 2:
                    obj2 = new t.d.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "filters_";
                    obj2[2] = t.h.class;
                    return z.newMessageInfo(t.d.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000c\u0002\u001b", obj2);
                case 4:
                    return t.d.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.d.class;
            synchronized (obj3) {
                obj2 = new z.b(t.d.DEFAULT_INSTANCE);
                t.d.PARSER = obj2;
            }
        }

        public List<f.c.e.c.t.h> h() {
            return this.filters_;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.d.b i() {
            f.c.e.c.t.d.b uNRECOGNIZED;
            if (t.d.b.forNumber(this.op_) == null) {
                uNRECOGNIZED = t.d.b.UNRECOGNIZED;
            }
            return uNRECOGNIZED;
        }
    }

    public static final class f extends z<f.c.e.c.t.f, f.c.e.c.t.f.a> implements u0 {

        private static final f.c.e.c.t.f DEFAULT_INSTANCE = null;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.c.t.f> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private f.c.e.c.t.g field_;
        private int op_;
        private f.c.e.c.x value_;
        static {
            t.f fVar = new t.f();
            t.f.DEFAULT_INSTANCE = fVar;
            z.registerDefaultInstance(t.f.class, fVar);
        }

        static f.c.e.c.t.f b() {
            return t.f.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.f t$f, f.c.e.c.t.g t$g2) {
            f.k(g2);
        }

        static void d(f.c.e.c.t.f t$f, f.c.e.c.t.f.b t$f$b2) {
            f.l(b2);
        }

        static void e(f.c.e.c.t.f t$f, f.c.e.c.x x2) {
            f.m(x2);
        }

        public static f.c.e.c.t.f f() {
            return t.f.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.t.f.a j() {
            return (t.f.a)t.f.DEFAULT_INSTANCE.createBuilder();
        }

        private void k(f.c.e.c.t.g t$g) {
            g.getClass();
            this.field_ = g;
        }

        private void l(f.c.e.c.t.f.b t$f$b) {
            this.op_ = b.getNumber();
        }

        private void m(f.c.e.c.x x) {
            x.getClass();
            this.value_ = x;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.f();
                    return obj2;
                case 2:
                    obj2 = new t.f.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "op_";
                    obj2[2] = "value_";
                    return z.newMessageInfo(t.f.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000c\u0003\t", obj2);
                case 4:
                    return t.f.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.f.class;
            synchronized (obj3) {
                obj2 = new z.b(t.f.DEFAULT_INSTANCE);
                t.f.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.g g() {
            f.c.e.c.t.g field_;
            if (this.field_ == null) {
                field_ = t.g.d();
            }
            return field_;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.f.b h() {
            f.c.e.c.t.f.b uNRECOGNIZED;
            if (t.f.b.forNumber(this.op_) == null) {
                uNRECOGNIZED = t.f.b.UNRECOGNIZED;
            }
            return uNRECOGNIZED;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.x i() {
            f.c.e.c.x value_;
            if (this.value_ == null) {
                value_ = x.q();
            }
            return value_;
        }
    }

    public static final class g extends z<f.c.e.c.t.g, f.c.e.c.t.g.a> implements u0 {

        private static final f.c.e.c.t.g DEFAULT_INSTANCE = null;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.c.t.g> PARSER;
        private String fieldPath_;
        static {
            t.g gVar = new t.g();
            t.g.DEFAULT_INSTANCE = gVar;
            z.registerDefaultInstance(t.g.class, gVar);
        }

        private g() {
            super();
            this.fieldPath_ = "";
        }

        static f.c.e.c.t.g b() {
            return t.g.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.g t$g, String string2) {
            g.g(string2);
        }

        public static f.c.e.c.t.g d() {
            return t.g.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.t.g.a f() {
            return (t.g.a)t.g.DEFAULT_INSTANCE.createBuilder();
        }

        private void g(String string) {
            string.getClass();
            this.fieldPath_ = string;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj1;
            int obj2;
            int obj3;
            obj2 = 1;
            obj3 = 0;
            switch (obj1) {
                case 1:
                    obj1 = new t.g();
                    return obj1;
                case 2:
                    obj1 = new t.g.a(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "fieldPath_";
                    return z.newMessageInfo(t.g.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", obj1);
                case 4:
                    return t.g.DEFAULT_INSTANCE;
                case 5:
                    return obj1;
                case 6:
                    return Byte.valueOf(obj2);
                case 7:
                    return obj3;
                default:
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
            }
            obj2 = t.g.class;
            synchronized (obj2) {
                obj1 = new z.b(t.g.DEFAULT_INSTANCE);
                t.g.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public String e() {
            return this.fieldPath_;
        }
    }

    public static final class h extends z<f.c.e.c.t.h, f.c.e.c.t.h.a> implements u0 {

        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final f.c.e.c.t.h DEFAULT_INSTANCE = null;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.c.t.h> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;
        static {
            t.h hVar = new t.h();
            t.h.DEFAULT_INSTANCE = hVar;
            z.registerDefaultInstance(t.h.class, hVar);
        }

        private h() {
            super();
            final int i = 0;
        }

        static void b(f.c.e.c.t.h t$h, f.c.e.c.t.f t$f2) {
            h.m(f2);
        }

        static void c(f.c.e.c.t.h t$h, f.c.e.c.t.k t$k2) {
            h.n(k2);
        }

        static f.c.e.c.t.h d() {
            return t.h.DEFAULT_INSTANCE;
        }

        static void e(f.c.e.c.t.h t$h, f.c.e.c.t.d t$d2) {
            h.l(d2);
        }

        public static f.c.e.c.t.h g() {
            return t.h.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.t.h.a k() {
            return (t.h.a)t.h.DEFAULT_INSTANCE.createBuilder();
        }

        private void l(f.c.e.c.t.d t$d) {
            d.getClass();
            this.filterType_ = d;
            this.filterTypeCase_ = 1;
        }

        private void m(f.c.e.c.t.f t$f) {
            f.getClass();
            this.filterType_ = f;
            this.filterTypeCase_ = 2;
        }

        private void n(f.c.e.c.t.k t$k) {
            k.getClass();
            this.filterType_ = k;
            this.filterTypeCase_ = 3;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.h();
                    return obj2;
                case 2:
                    obj2 = new t.h.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[5];
                    obj2[obj3] = "filterTypeCase_";
                    obj2[2] = t.d.class;
                    obj2[3] = t.f.class;
                    obj2[4] = t.k.class;
                    return z.newMessageInfo(t.h.DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", obj2);
                case 4:
                    return t.h.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.h.class;
            synchronized (obj3) {
                obj2 = new z.b(t.h.DEFAULT_INSTANCE);
                t.h.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.d f() {
            if (this.filterTypeCase_ == 1) {
                return (t.d)this.filterType_;
            }
            return t.d.g();
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.f h() {
            if (this.filterTypeCase_ == 2) {
                return (t.f)this.filterType_;
            }
            return t.f.f();
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.h.b i() {
            return t.h.b.forNumber(this.filterTypeCase_);
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.k j() {
            if (this.filterTypeCase_ == 3) {
                return (t.k)this.filterType_;
            }
            return t.k.e();
        }
    }

    public static final class i extends z<f.c.e.c.t.i, f.c.e.c.t.i.a> implements u0 {

        private static final f.c.e.c.t.i DEFAULT_INSTANCE = null;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile d1<f.c.e.c.t.i> PARSER;
        private int direction_;
        private f.c.e.c.t.g field_;
        static {
            t.i iVar = new t.i();
            t.i.DEFAULT_INSTANCE = iVar;
            z.registerDefaultInstance(t.i.class, iVar);
        }

        static f.c.e.c.t.i b() {
            return t.i.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.i t$i, f.c.e.c.t.g t$g2) {
            i.i(g2);
        }

        static void d(f.c.e.c.t.i t$i, f.c.e.c.t.e t$e2) {
            i.h(e2);
        }

        public static f.c.e.c.t.i.a g() {
            return (t.i.a)t.i.DEFAULT_INSTANCE.createBuilder();
        }

        private void h(f.c.e.c.t.e t$e) {
            this.direction_ = e.getNumber();
        }

        private void i(f.c.e.c.t.g t$g) {
            g.getClass();
            this.field_ = g;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.i();
                    return obj2;
                case 2:
                    obj2 = new t.i.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "direction_";
                    return z.newMessageInfo(t.i.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000c", obj2);
                case 4:
                    return t.i.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.i.class;
            synchronized (obj3) {
                obj2 = new z.b(t.i.DEFAULT_INSTANCE);
                t.i.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.e e() {
            f.c.e.c.t.e uNRECOGNIZED;
            if (t.e.forNumber(this.direction_) == null) {
                uNRECOGNIZED = t.e.UNRECOGNIZED;
            }
            return uNRECOGNIZED;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.g f() {
            f.c.e.c.t.g field_;
            if (this.field_ == null) {
                field_ = t.g.d();
            }
            return field_;
        }
    }

    public static final class j extends z<f.c.e.c.t.j, f.c.e.c.t.j.a> implements u0 {

        private static final f.c.e.c.t.j DEFAULT_INSTANCE = null;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.c.t.j> PARSER;
        private c0.j<f.c.e.c.t.g> fields_;
        static {
            t.j jVar = new t.j();
            t.j.DEFAULT_INSTANCE = jVar;
            z.registerDefaultInstance(t.j.class, jVar);
        }

        private j() {
            super();
            this.fields_ = z.emptyProtobufList();
        }

        static f.c.e.c.t.j b() {
            return t.j.DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.j();
                    return obj2;
                case 2:
                    obj2 = new t.j.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = t.g.class;
                    return z.newMessageInfo(t.j.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", obj2);
                case 4:
                    return t.j.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.j.class;
            synchronized (obj3) {
                obj2 = new z.b(t.j.DEFAULT_INSTANCE);
                t.j.PARSER = obj2;
            }
        }
    }

    public static final class k extends z<f.c.e.c.t.k, f.c.e.c.t.k.a> implements u0 {

        private static final f.c.e.c.t.k DEFAULT_INSTANCE = null;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile d1<f.c.e.c.t.k> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;
        static {
            t.k kVar = new t.k();
            t.k.DEFAULT_INSTANCE = kVar;
            z.registerDefaultInstance(t.k.class, kVar);
        }

        private k() {
            super();
            final int i = 0;
        }

        static f.c.e.c.t.k b() {
            return t.k.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.t.k t$k, f.c.e.c.t.k.b t$k$b2) {
            k.j(b2);
        }

        static void d(f.c.e.c.t.k t$k, f.c.e.c.t.g t$g2) {
            k.i(g2);
        }

        public static f.c.e.c.t.k e() {
            return t.k.DEFAULT_INSTANCE;
        }

        public static f.c.e.c.t.k.a h() {
            return (t.k.a)t.k.DEFAULT_INSTANCE.createBuilder();
        }

        private void i(f.c.e.c.t.g t$g) {
            g.getClass();
            this.operandType_ = g;
            this.operandTypeCase_ = 2;
        }

        private void j(f.c.e.c.t.k.b t$k$b) {
            this.op_ = b.getNumber();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new t.k();
                    return obj2;
                case 2:
                    obj2 = new t.k.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[4];
                    obj2[obj3] = "operandTypeCase_";
                    obj2[2] = "op_";
                    obj2[3] = t.g.class;
                    return z.newMessageInfo(t.k.DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000c\u0002<\u0000", obj2);
                case 4:
                    return t.k.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = t.k.class;
            synchronized (obj3) {
                obj2 = new z.b(t.k.DEFAULT_INSTANCE);
                t.k.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.g f() {
            if (this.operandTypeCase_ == 2) {
                return (t.g)this.operandType_;
            }
            return t.g.d();
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.t.k.b g() {
            f.c.e.c.t.k.b uNRECOGNIZED;
            if (t.k.b.forNumber(this.op_) == null) {
                uNRECOGNIZED = t.k.b.UNRECOGNIZED;
            }
            return uNRECOGNIZED;
        }
    }
    static {
        t tVar = new t();
        t.DEFAULT_INSTANCE = tVar;
        z.registerDefaultInstance(t.class, tVar);
    }

    private t() {
        super();
        this.from_ = z.emptyProtobufList();
        this.orderBy_ = z.emptyProtobufList();
    }

    private void A(f.c.e.c.g g) {
        g.getClass();
        this.endAt_ = g;
    }

    private void B(a0 a0) {
        a0.getClass();
        this.limit_ = a0;
    }

    private void C(f.c.e.c.g g) {
        g.getClass();
        this.startAt_ = g;
    }

    private void D(f.c.e.c.t.h t$h) {
        h.getClass();
        this.where_ = h;
    }

    static f.c.e.c.t b() {
        return t.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.t t, f.c.e.c.t.c t$c2) {
        t.i(c2);
    }

    static void d(f.c.e.c.t t, f.c.e.c.t.h t$h2) {
        t.D(h2);
    }

    static void e(f.c.e.c.t t, f.c.e.c.t.i t$i2) {
        t.j(i2);
    }

    static void f(f.c.e.c.t t, f.c.e.c.g g2) {
        t.C(g2);
    }

    static void g(f.c.e.c.t t, f.c.e.c.g g2) {
        t.A(g2);
    }

    static void h(f.c.e.c.t t, a0 a02) {
        t.B(a02);
    }

    private void i(f.c.e.c.t.c t$c) {
        c.getClass();
        k();
        this.from_.add(c);
    }

    private void j(f.c.e.c.t.i t$i) {
        i.getClass();
        l();
        this.orderBy_.add(i);
    }

    private void k() {
        c0.j mutableCopy;
        mutableCopy = this.from_;
        if (!mutableCopy.c2()) {
            this.from_ = z.mutableCopy(mutableCopy);
        }
    }

    private void l() {
        c0.j mutableCopy;
        mutableCopy = this.orderBy_;
        if (!mutableCopy.c2()) {
            this.orderBy_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.t m() {
        return t.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.t.b z() {
        return (t.b)t.DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new t();
                return obj2;
            case 2:
                obj2 = new t.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[10];
                obj2[obj3] = "from_";
                obj2[2] = t.c.class;
                obj2[3] = "where_";
                obj2[4] = "orderBy_";
                obj2[5] = t.i.class;
                obj2[6] = "limit_";
                obj2[7] = "offset_";
                obj2[8] = "startAt_";
                obj2[9] = "endAt_";
                return z.newMessageInfo(t.DEFAULT_INSTANCE, "\u0000\u0008\u0000\u0000\u0001\u0008\u0008\u0000\u0002\u0000\u0001\t\u0002\u001b\u0003\t\u0004\u001b\u0005\t\u0006\u0004\u0007\t\u0008\t", obj2);
            case 4:
                return t.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = t.class;
        synchronized (obj3) {
            obj2 = new z.b(t.DEFAULT_INSTANCE);
            t.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.g n() {
        f.c.e.c.g endAt_;
        if (this.endAt_ == null) {
            endAt_ = g.h();
        }
        return endAt_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.t.c o(int i) {
        return (t.c)this.from_.get(i);
    }

    @Override // com.google.protobuf.z
    public int p() {
        return this.from_.size();
    }

    @Override // com.google.protobuf.z
    public a0 q() {
        a0 limit_;
        if (this.limit_ == null) {
            limit_ = a0.d();
        }
        return limit_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.t.i r(int i) {
        return (t.i)this.orderBy_.get(i);
    }

    @Override // com.google.protobuf.z
    public int s() {
        return this.orderBy_.size();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.g t() {
        f.c.e.c.g startAt_;
        if (this.startAt_ == null) {
            startAt_ = g.h();
        }
        return startAt_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.t.h u() {
        f.c.e.c.t.h where_;
        if (this.where_ == null) {
            where_ = t.h.g();
        }
        return where_;
    }

    @Override // com.google.protobuf.z
    public boolean v() {
        int i;
        i = this.endAt_ != null ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean w() {
        int i;
        i = this.limit_ != null ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean x() {
        int i;
        i = this.startAt_ != null ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean y() {
        int i;
        i = this.where_ != null ? 1 : 0;
        return i;
    }
}
