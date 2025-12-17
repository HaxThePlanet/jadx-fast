package f.c.f.a.a.a;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class d extends z<f.c.f.a.a.a.d, f.c.f.a.a.a.d.a> implements u0 {

    public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
    public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
    private static final f.c.f.a.a.a.d DEFAULT_INSTANCE = null;
    public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
    private static volatile d1<f.c.f.a.a.a.d> PARSER;
    private long campaignEndTimeMillis_;
    private String campaignId_;
    private String campaignName_;
    private long campaignStartTimeMillis_;
    private String experimentalCampaignId_;

    public static final class a extends z.a<f.c.f.a.a.a.d, f.c.f.a.a.a.d.a> implements u0 {
        private a() {
            super(d.b());
        }

        a(f.c.f.a.a.a.a a) {
            super();
        }
    }
    static {
        d dVar = new d();
        d.DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    private d() {
        super();
        final String str = "";
        this.campaignId_ = str;
        this.experimentalCampaignId_ = str;
        this.campaignName_ = str;
    }

    static f.c.f.a.a.a.d b() {
        return d.DEFAULT_INSTANCE;
    }

    public static f.c.f.a.a.a.d f() {
        return d.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public long c() {
        return this.campaignEndTimeMillis_;
    }

    @Override // com.google.protobuf.z
    public String d() {
        return this.campaignName_;
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
                obj2 = new d.a(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "experimentalCampaignId_";
                obj2[2] = "campaignStartTimeMillis_";
                obj2[3] = "campaignEndTimeMillis_";
                obj2[4] = "campaignName_";
                return z.newMessageInfo(d.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0002\u0005Ȉ", obj2);
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

    @Override // com.google.protobuf.z
    public long e() {
        return this.campaignStartTimeMillis_;
    }

    @Override // com.google.protobuf.z
    public String getCampaignId() {
        return this.campaignId_;
    }
}
