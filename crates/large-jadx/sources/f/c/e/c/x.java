package f.c.e.c;

import com.google.protobuf.c1;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.h.b;
import f.c.h.b.b;

/* loaded from: classes2.dex */
public final class x extends z<f.c.e.c.x, f.c.e.c.x.b> implements u0 {

    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final f.c.e.c.x DEFAULT_INSTANCE = null;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile d1<f.c.e.c.x> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            x.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            x.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            x.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            x.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            x.a.a[z.f.GET_PARSER.ordinal()] = 5;
            x.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            x.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c {

        NULL_VALUE(11),
        BOOLEAN_VALUE(true),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(3),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(5),
        ARRAY_VALUE(true),
        MAP_VALUE(4),
        VALUETYPE_NOT_SET(false);

        private final int value;
        public static f.c.e.c.x.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 5 && i != 6 && i != 17 && i != 18) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 5) {
                                if (i != 6) {
                                    if (i != 17) {
                                        if (i != 18) {
                                            switch (i) {
                                                case 8:
                                                    return x.c.GEO_POINT_VALUE;
                                                case 9:
                                                    return x.c.ARRAY_VALUE;
                                                case 10:
                                                    return x.c.TIMESTAMP_VALUE;
                                                case 11:
                                                    return x.c.NULL_VALUE;
                                                default:
                                                    return null;
                                            }
                                        }
                                        return x.c.BYTES_VALUE;
                                    }
                                    return x.c.STRING_VALUE;
                                }
                                return x.c.MAP_VALUE;
                            }
                            return x.c.REFERENCE_VALUE;
                        }
                        return x.c.DOUBLE_VALUE;
                    }
                    return x.c.INTEGER_VALUE;
                }
                return x.c.BOOLEAN_VALUE;
            }
            return x.c.VALUETYPE_NOT_SET;
        }

        @Deprecated
        public static f.c.e.c.x.c valueOf(int i) {
            return x.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class b extends z.a<f.c.e.c.x, f.c.e.c.x.b> implements u0 {
        private b() {
            super(x.b());
        }

        b(f.c.e.c.x.a x$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.r b() {
            return (x)this.instance.t();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b c(f.c.e.c.a.b a$b) {
            copyOnWrite();
            x.h((x)this.instance, (a)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b d(f.c.e.c.a a) {
            copyOnWrite();
            x.h((x)this.instance, a);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b e(boolean z) {
            copyOnWrite();
            x.k((x)this.instance, z);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b f(j j) {
            copyOnWrite();
            x.e((x)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b g(double d) {
            copyOnWrite();
            x.m((x)this.instance, d);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b h(b.b b$b) {
            copyOnWrite();
            x.g((x)this.instance, (b)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b j(long l) {
            copyOnWrite();
            x.l((x)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b k(f.c.e.c.r.b r$b) {
            copyOnWrite();
            x.i((x)this.instance, (r)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b l(f.c.e.c.r r) {
            copyOnWrite();
            x.i((x)this.instance, r);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b m(c1 c1) {
            copyOnWrite();
            x.j((x)this.instance, c1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b n(String string) {
            copyOnWrite();
            x.f((x)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b o(String string) {
            copyOnWrite();
            x.d((x)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x.b p(r1.b r1$b) {
            copyOnWrite();
            x.c((x)this.instance, (r1)b.build());
            return this;
        }
    }
    static {
        x xVar = new x();
        x.DEFAULT_INSTANCE = xVar;
        z.registerDefaultInstance(x.class, xVar);
    }

    private x() {
        super();
        final int i = 0;
    }

    private void A(j j) {
        j.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = j;
    }

    private void B(b b) {
        b.getClass();
        this.valueType_ = b;
        this.valueTypeCase_ = 8;
    }

    private void C(long l) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(l);
    }

    private void D(f.c.e.c.r r) {
        r.getClass();
        this.valueType_ = r;
        this.valueTypeCase_ = 6;
    }

    private void E(c1 c1) {
        this.valueType_ = Integer.valueOf(c1.getNumber());
        this.valueTypeCase_ = 11;
    }

    private void F(String string) {
        string.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = string;
    }

    private void G(r1 r1) {
        r1.getClass();
        this.valueType_ = r1;
        this.valueTypeCase_ = 10;
    }

    static f.c.e.c.x b() {
        return x.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.x x, r1 r12) {
        x.G(r12);
    }

    static void d(f.c.e.c.x x, String string2) {
        x.setStringValue(string2);
    }

    static void e(f.c.e.c.x x, j j2) {
        x.A(j2);
    }

    static void f(f.c.e.c.x x, String string2) {
        x.F(string2);
    }

    static void g(f.c.e.c.x x, b b2) {
        x.B(b2);
    }

    static void h(f.c.e.c.x x, f.c.e.c.a a2) {
        x.y(a2);
    }

    static void i(f.c.e.c.x x, f.c.e.c.r r2) {
        x.D(r2);
    }

    static void j(f.c.e.c.x x, c1 c12) {
        x.E(c12);
    }

    static void k(f.c.e.c.x x, boolean z2) {
        x.z(z2);
    }

    static void l(f.c.e.c.x x, long l2) {
        x.C(l2);
    }

    static void m(f.c.e.c.x x, double d2) {
        x.setDoubleValue(d2);
    }

    public static f.c.e.c.x q() {
        return x.DEFAULT_INSTANCE;
    }

    private void setDoubleValue(double d) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d);
    }

    private void setStringValue(String string) {
        string.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = string;
    }

    public static f.c.e.c.x.b x() {
        return (x.b)x.DEFAULT_INSTANCE.createBuilder();
    }

    private void y(f.c.e.c.a a) {
        a.getClass();
        this.valueType_ = a;
        this.valueTypeCase_ = 9;
    }

    private void z(boolean z) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z);
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
                obj2 = new x();
                return obj2;
            case 2:
                obj2 = new x.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[6];
                obj2[obj3] = "valueTypeCase_";
                obj2[2] = r.class;
                obj2[3] = b.class;
                obj2[4] = a.class;
                obj2[5] = r1.class;
                return z.newMessageInfo(x.DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\u0008<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", obj2);
            case 4:
                return x.DEFAULT_INSTANCE;
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
        obj3 = x.class;
        synchronized (obj3) {
            obj2 = new z.b(x.DEFAULT_INSTANCE);
            x.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public double getDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return (Double)this.valueType_.doubleValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.z
    public String getStringValue() {
        Object valueType_;
        if (this.valueTypeCase_ == 17) {
            valueType_ = this.valueType_;
        } else {
            valueType_ = "";
        }
        return valueType_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.a n() {
        if (this.valueTypeCase_ == 9) {
            return (a)this.valueType_;
        }
        return a.i();
    }

    @Override // com.google.protobuf.z
    public boolean o() {
        if (this.valueTypeCase_ == 1) {
            return (Boolean)this.valueType_.booleanValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.z
    public j p() {
        if (this.valueTypeCase_ == 18) {
            return (j)this.valueType_;
        }
        return j.a;
    }

    @Override // com.google.protobuf.z
    public b r() {
        if (this.valueTypeCase_ == 8) {
            return (b)this.valueType_;
        }
        return b.e();
    }

    @Override // com.google.protobuf.z
    public long s() {
        if (this.valueTypeCase_ == 2) {
            return (Long)this.valueType_.longValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.r t() {
        if (this.valueTypeCase_ == 6) {
            return (r)this.valueType_;
        }
        return r.d();
    }

    @Override // com.google.protobuf.z
    public String u() {
        Object valueType_;
        if (this.valueTypeCase_ == 5) {
            valueType_ = this.valueType_;
        } else {
            valueType_ = "";
        }
        return valueType_;
    }

    @Override // com.google.protobuf.z
    public r1 v() {
        if (this.valueTypeCase_ == 10) {
            return (r1)this.valueType_;
        }
        return r1.e();
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.x.c w() {
        return x.c.forNumber(this.valueTypeCase_);
    }
}
