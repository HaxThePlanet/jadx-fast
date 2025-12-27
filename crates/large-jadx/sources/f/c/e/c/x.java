package f.c.e.c;

import android.accounts.Account;
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

/* compiled from: Value.java */
/* loaded from: classes2.dex */
public final class x extends z<x, x.b> implements u0 {

    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final x DEFAULT_INSTANCE = null;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile d1<x> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[z.f.values().length];
            x.a.a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                x.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum c {

        ARRAY_VALUE,
        BOOLEAN_VALUE,
        BYTES_VALUE,
        DOUBLE_VALUE,
        GEO_POINT_VALUE,
        INTEGER_VALUE,
        MAP_VALUE,
        NULL_VALUE,
        REFERENCE_VALUE,
        STRING_VALUE,
        TIMESTAMP_VALUE,
        VALUETYPE_NOT_SET;

        private final int value;
        public static x.c forNumber(int i) {
            if (i != 0 && i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 5 && i != 6) {
                        if (i != 17 && i != 18) {
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
                        return x.c.STRING_VALUE;
                    }
                    return x.c.REFERENCE_VALUE;
                }
                return x.c.INTEGER_VALUE;
            }
            return x.c.VALUETYPE_NOT_SET;
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static x.c valueOf(int i) {
            return x.c.forNumber(i);
        }
    }

    public static final class b extends z.a<x, x.b> implements u0 {
        /* synthetic */ b(x.a aVar) {
            this();
        }

        @Override // com.google.protobuf.z$a
        public r b() {
            return (x)this.instance.t();
        }

        @Override // com.google.protobuf.z$a
        public x.b c(a.b bVar) {
            copyOnWrite();
            (x)this.instance.y((a)bVar.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b d(a aVar) {
            copyOnWrite();
            (x)this.instance.y(aVar);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b e(boolean z) {
            copyOnWrite();
            (x)this.instance.z(z);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b f(j jVar) {
            copyOnWrite();
            (x)this.instance.A(jVar);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b g(double d) {
            copyOnWrite();
            (x)this.instance.setDoubleValue(d, r3);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b h(b.b bVar) {
            copyOnWrite();
            (x)this.instance.B((b)bVar.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b j(long j) {
            copyOnWrite();
            (x)this.instance.C(j, r3);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b k(r.b bVar) {
            copyOnWrite();
            (x)this.instance.D((r)bVar.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b l(r rVar) {
            copyOnWrite();
            (x)this.instance.D(rVar);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b m(c1 c1Var) {
            copyOnWrite();
            (x)this.instance.E(c1Var);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b n(String str) {
            copyOnWrite();
            (x)this.instance.F(str);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b o(String str) {
            copyOnWrite();
            (x)this.instance.setStringValue(str);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public x.b p(r1.b bVar) {
            copyOnWrite();
            (x)this.instance.G((r1)bVar.build());
            return this;
        }

        private b() {
            super(x.DEFAULT_INSTANCE);
        }
    }
    static {
        final f.c.e.c.x xVar = new x();
        x.DEFAULT_INSTANCE = xVar;
        z.registerDefaultInstance(x.class, xVar);
    }

    private x() {
        super();
    }

    private void A(j jVar) {
        jVar.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = jVar;
    }

    private void B(b bVar) {
        bVar.getClass();
        this.valueType_ = bVar;
        this.valueTypeCase_ = 8;
    }

    private void C(long j) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j);
    }

    private void D(r rVar) {
        rVar.getClass();
        this.valueType_ = rVar;
        this.valueTypeCase_ = 6;
    }

    private void E(c1 c1Var) {
        this.valueType_ = Integer.valueOf(c1Var.getNumber());
        this.valueTypeCase_ = 11;
    }

    private void F(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    private void G(r1 r1Var) {
        r1Var.getClass();
        this.valueType_ = r1Var;
        this.valueTypeCase_ = 10;
    }

    static /* synthetic */ x b() {
        return x.DEFAULT_INSTANCE;
    }

    static /* synthetic */ void c(x xVar, r1 r1Var) {
        xVar.G(r1Var);
    }

    static /* synthetic */ void d(x xVar, String str) {
        xVar.setStringValue(str);
    }

    static /* synthetic */ void e(x xVar, j jVar) {
        xVar.A(jVar);
    }

    static /* synthetic */ void f(x xVar, String str) {
        xVar.F(str);
    }

    static /* synthetic */ void g(x xVar, b bVar) {
        xVar.B(bVar);
    }

    static /* synthetic */ void h(x xVar, a aVar) {
        xVar.y(aVar);
    }

    static /* synthetic */ void i(x xVar, r rVar) {
        xVar.D(rVar);
    }

    static /* synthetic */ void j(x xVar, c1 c1Var) {
        xVar.E(c1Var);
    }

    static /* synthetic */ void k(x xVar, boolean z) {
        xVar.z(z);
    }

    static /* synthetic */ void l(x xVar, long j) {
        xVar.C(j);
    }

    static /* synthetic */ void m(x xVar, double d) {
        xVar.setDoubleValue(d);
    }

    public static x q() {
        return x.DEFAULT_INSTANCE;
    }

    private void setDoubleValue(double d) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d);
    }

    private void setStringValue(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    public static x.b x() {
        return (x.b)x.DEFAULT_INSTANCE.createBuilder();
    }

    private void y(a aVar) {
        aVar.getClass();
        this.valueType_ = aVar;
        this.valueTypeCase_ = 9;
    }

    private void z(boolean z) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z);
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f fVar, Object object, Object object2) {
        d1 pARSER2;
        int i = 0;
        byte b = (byte) 1;
        f.c.e.c.x.a aVar = null;
        switch (x.a.a[fVar.ordinal()]) {
            case 1: /* ordinal */
                return new x();
            case 2: /* ordinal */
                return new x.b(aVar);
            case 3: /* ordinal */
                Object[] arr = new Object[6];
                arr[b] = "valueTypeCase_";
                arr[2] = r.class;
                arr[3] = b.class;
                arr[4] = a.class;
                arr[5] = r1.class;
                return z.newMessageInfo(x.DEFAULT_INSTANCE, "     : 5 3 Ȼ < < 	< 
< ? Ȼ = ", arr);
            case 4: /* ordinal */
                return x.DEFAULT_INSTANCE;
            case 5: /* ordinal */
                return pARSER2;
            case 6: /* ordinal */
                return Byte.valueOf(b);
            case 7: /* ordinal */
                return aVar;
            default:
                throw new UnsupportedOperationException();
        }
        Class<f.c.e.c.x> obj = x.class;
        synchronized (obj) {
            try {
                if (x.PARSER == null) {
                    x.PARSER = new z.b(x.DEFAULT_INSTANCE);
                }
            } catch (Throwable th) {
            }
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
        Object valueType_2;
        valueType_2 = this.valueTypeCase_ == 17 ? (String)valueType_2 : "";
        return valueType_2;
    }

    @Override // com.google.protobuf.z
    public a n() {
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
        return false;
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
    public r t() {
        if (this.valueTypeCase_ == 6) {
            return (r)this.valueType_;
        }
        return r.d();
    }

    @Override // com.google.protobuf.z
    public String u() {
        Object valueType_2;
        valueType_2 = this.valueTypeCase_ == 5 ? (String)valueType_2 : "";
        return valueType_2;
    }

    @Override // com.google.protobuf.z
    public r1 v() {
        if (this.valueTypeCase_ == 10) {
            return (r1)this.valueType_;
        }
        return r1.e();
    }

    @Override // com.google.protobuf.z
    public x.c w() {
        return x.c.forNumber(this.valueTypeCase_);
    }
}
