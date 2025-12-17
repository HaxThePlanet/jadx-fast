package f.c.f.a.a.a.e;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends z<f.c.f.a.a.a.e.b, f.c.f.a.a.a.e.b.b> implements u0 {

    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 1;
    private static final f.c.f.a.a.a.e.b DEFAULT_INSTANCE;
    private static volatile d1<f.c.f.a.a.a.e.b> PARSER;
    private c0.j<f.c.f.a.a.a.e.a> alreadySeenCampaigns_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            b.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            b.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            b.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            b.a.a[z.f.GET_PARSER.ordinal()] = 5;
            b.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            b.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.f.a.a.a.e.b, f.c.f.a.a.a.e.b.b> implements u0 {
        private b() {
            super(b.b());
        }

        b(f.c.f.a.a.a.e.b.a b$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.b.b b(f.c.f.a.a.a.e.a a) {
            copyOnWrite();
            b.c((b)this.instance, a);
            return this;
        }
    }
    static {
        b bVar = new b();
        b.DEFAULT_INSTANCE = bVar;
        z.registerDefaultInstance(b.class, bVar);
    }

    private b() {
        super();
        this.alreadySeenCampaigns_ = z.emptyProtobufList();
    }

    static f.c.f.a.a.a.e.b b() {
        return b.DEFAULT_INSTANCE;
    }

    static void c(f.c.f.a.a.a.e.b b, f.c.f.a.a.a.e.a a2) {
        b.d(a2);
    }

    private void d(f.c.f.a.a.a.e.a a) {
        a.getClass();
        e();
        this.alreadySeenCampaigns_.add(a);
    }

    private void e() {
        c0.j alreadySeenCampaigns_;
        alreadySeenCampaigns_ = this.alreadySeenCampaigns_;
        if (!alreadySeenCampaigns_.c2()) {
            this.alreadySeenCampaigns_ = z.mutableCopy(alreadySeenCampaigns_);
        }
    }

    public static f.c.f.a.a.a.e.b g() {
        return b.DEFAULT_INSTANCE;
    }

    public static f.c.f.a.a.a.e.b.b h() {
        return (b.b)b.DEFAULT_INSTANCE.createBuilder();
    }

    public static f.c.f.a.a.a.e.b.b i(f.c.f.a.a.a.e.b b) {
        return (b.b)b.DEFAULT_INSTANCE.createBuilder(b);
    }

    public static d1<f.c.f.a.a.a.e.b> parser() {
        return b.DEFAULT_INSTANCE.getParserForType();
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
                obj2 = new b();
                return obj2;
            case 2:
                obj2 = new b.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = a.class;
                return z.newMessageInfo(b.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", obj2);
            case 4:
                return b.DEFAULT_INSTANCE;
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
        obj3 = b.class;
        synchronized (obj3) {
            obj2 = new z.b(b.DEFAULT_INSTANCE);
            b.PARSER = obj2;
        }
    }

    public List<f.c.f.a.a.a.e.a> f() {
        return this.alreadySeenCampaigns_;
    }
}
