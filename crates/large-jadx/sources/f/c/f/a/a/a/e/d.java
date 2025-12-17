package f.c.f.a.a.a.e;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.d.a.a.a.b;

/* loaded from: classes2.dex */
public final class d extends z<f.c.f.a.a.a.e.d, f.c.f.a.a.a.e.d.b> implements u0 {

    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    private static final f.c.f.a.a.a.e.d DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.f.a.a.a.e.d> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private c0.j<f.c.f.a.a.a.e.a> alreadySeenCampaigns_;
    private b clientSignals_;
    private String projectNumber_;
    private f.c.f.a.a.a.e.c requestingClientApp_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            d.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            d.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            d.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            d.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            d.a.a[z.f.GET_PARSER.ordinal()] = 5;
            d.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            d.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.f.a.a.a.e.d, f.c.f.a.a.a.e.d.b> implements u0 {
        private b() {
            super(d.b());
        }

        b(f.c.f.a.a.a.e.d.a d$a) {
            super();
        }

        public f.c.f.a.a.a.e.d.b b(Iterable<? extends f.c.f.a.a.a.e.a> iterable) {
            copyOnWrite();
            d.d((d)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.d.b c(b b) {
            copyOnWrite();
            d.e((d)this.instance, b);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.d.b d(String string) {
            copyOnWrite();
            d.c((d)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.d.b e(f.c.f.a.a.a.e.c c) {
            copyOnWrite();
            d.f((d)this.instance, c);
            return this;
        }
    }
    static {
        d dVar = new d();
        d.DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    private d() {
        super();
        this.projectNumber_ = "";
        this.alreadySeenCampaigns_ = z.emptyProtobufList();
    }

    static f.c.f.a.a.a.e.d b() {
        return d.DEFAULT_INSTANCE;
    }

    static void c(f.c.f.a.a.a.e.d d, String string2) {
        d.setProjectNumber(string2);
    }

    static void d(f.c.f.a.a.a.e.d d, Iterable iterable2) {
        d.g(iterable2);
    }

    static void e(f.c.f.a.a.a.e.d d, b b2) {
        d.k(b2);
    }

    static void f(f.c.f.a.a.a.e.d d, f.c.f.a.a.a.e.c c2) {
        d.l(c2);
    }

    private void g(Iterable<? extends f.c.f.a.a.a.e.a> iterable) {
        h();
        a.addAll(iterable, this.alreadySeenCampaigns_);
    }

    private void h() {
        c0.j alreadySeenCampaigns_;
        alreadySeenCampaigns_ = this.alreadySeenCampaigns_;
        if (!alreadySeenCampaigns_.c2()) {
            this.alreadySeenCampaigns_ = z.mutableCopy(alreadySeenCampaigns_);
        }
    }

    public static f.c.f.a.a.a.e.d i() {
        return d.DEFAULT_INSTANCE;
    }

    public static f.c.f.a.a.a.e.d.b j() {
        return (d.b)d.DEFAULT_INSTANCE.createBuilder();
    }

    private void k(b b) {
        b.getClass();
        this.clientSignals_ = b;
    }

    private void l(f.c.f.a.a.a.e.c c) {
        c.getClass();
        this.requestingClientApp_ = c;
    }

    private void setProjectNumber(String string) {
        string.getClass();
        this.projectNumber_ = string;
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
                obj2 = new d();
                return obj2;
            case 2:
                obj2 = new d.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "requestingClientApp_";
                obj2[2] = "alreadySeenCampaigns_";
                obj2[3] = a.class;
                obj2[4] = "clientSignals_";
                return z.newMessageInfo(d.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\t\u0003\u001b\u0004\t", obj2);
            case 4:
                return d.DEFAULT_INSTANCE;
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
        obj3 = d.class;
        synchronized (obj3) {
            obj2 = new z.b(d.DEFAULT_INSTANCE);
            d.PARSER = obj2;
        }
    }
}
