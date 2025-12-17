package f.c.f.a.a.a.e;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class a extends z<f.c.f.a.a.a.e.a, f.c.f.a.a.a.e.a.b> implements u0 {

    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    private static final f.c.f.a.a.a.e.a DEFAULT_INSTANCE = null;
    public static final int IMPRESSION_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    private static volatile d1<f.c.f.a.a.a.e.a> PARSER;
    private String campaignId_;
    private long impressionTimestampMillis_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            a.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            a.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            a.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            a.a.a[z.f.GET_PARSER.ordinal()] = 5;
            a.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            a.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.f.a.a.a.e.a, f.c.f.a.a.a.e.a.b> implements u0 {
        private b() {
            super(a.b());
        }

        b(f.c.f.a.a.a.e.a.a a$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.a.b b(String string) {
            copyOnWrite();
            a.c((a)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.a.b c(long l) {
            copyOnWrite();
            a.d((a)this.instance, l);
            return this;
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
        super();
        this.campaignId_ = "";
    }

    static f.c.f.a.a.a.e.a b() {
        return a.DEFAULT_INSTANCE;
    }

    static void c(f.c.f.a.a.a.e.a a, String string2) {
        a.setCampaignId(string2);
    }

    static void d(f.c.f.a.a.a.e.a a, long l2) {
        a.f(l2);
    }

    public static f.c.f.a.a.a.e.a.b e() {
        return (a.b)a.DEFAULT_INSTANCE.createBuilder();
    }

    private void f(long l) {
        this.impressionTimestampMillis_ = l;
    }

    private void setCampaignId(String string) {
        string.getClass();
        this.campaignId_ = string;
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
                obj2 = new a();
                return obj2;
            case 2:
                obj2 = new a.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "impressionTimestampMillis_";
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", obj2);
            case 4:
                return a.DEFAULT_INSTANCE;
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
        obj3 = a.class;
        synchronized (obj3) {
            obj2 = new z.b(a.DEFAULT_INSTANCE);
            a.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getCampaignId() {
        return this.campaignId_;
    }
}
