package f.c.f.a.a.a;

import android.accounts.Account;
import com.google.firebase.inappmessaging.CommonTypesProto.Priority;
import com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition;
import com.google.firebase.inappmessaging.MessagesProto.Content;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.u0;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c extends z<f.c.f.a.a.a.c, f.c.f.a.a.a.c.a> implements u0 {

    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
    private static final f.c.f.a.a.a.c DEFAULT_INSTANCE = null;
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    private static volatile d1<f.c.f.a.a.a.c> PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    private MessagesProto.Content content_;
    private n0<String, String> dataBundle_;
    private boolean isTestCampaign_;
    private int payloadCase_ = 0;
    private Object payload_;
    private CommonTypesProto.Priority priority_;
    private c0.j<CommonTypesProto.TriggeringCondition> triggeringConditions_;

    private static final class b {

        static final m0<String, String> a;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            c.b.a = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static enum c {

        VANILLA_PAYLOAD(true),
        EXPERIMENTAL_PAYLOAD(2),
        PAYLOAD_NOT_SET(false);

        private final int value;
        public static f.c.f.a.a.a.c.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return c.c.EXPERIMENTAL_PAYLOAD;
                }
                return c.c.VANILLA_PAYLOAD;
            }
            return c.c.PAYLOAD_NOT_SET;
        }

        @Deprecated
        public static f.c.f.a.a.a.c.c valueOf(int i) {
            return c.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class a extends z.a<f.c.f.a.a.a.c, f.c.f.a.a.a.c.a> implements u0 {
        private a() {
            super(c.b());
        }

        a(f.c.f.a.a.a.a a) {
            super();
        }
    }
    static {
        c cVar = new c();
        c.DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    private c() {
        super();
        int i = 0;
        this.dataBundle_ = n0.e();
        this.triggeringConditions_ = z.emptyProtobufList();
    }

    static f.c.f.a.a.a.c b() {
        return c.DEFAULT_INSTANCE;
    }

    private n0<String, String> j() {
        return this.dataBundle_;
    }

    public Map<String, String> c() {
        return Collections.unmodifiableMap(j());
    }

    @Override // com.google.protobuf.z
    public f.c.f.a.a.a.b d() {
        if (this.payloadCase_ == 2) {
            return (b)this.payload_;
        }
        return b.f();
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
                obj2 = new c();
                return obj2;
            case 2:
                obj2 = new c.a(obj4);
                return obj2;
            case 3:
                obj2 = new Object[11];
                obj2[obj3] = "payloadCase_";
                obj2[2] = d.class;
                obj2[3] = b.class;
                obj2[4] = "content_";
                obj2[5] = "priority_";
                obj2[6] = "triggeringConditions_";
                obj2[7] = CommonTypesProto.TriggeringCondition.class;
                obj2[8] = "isTestCampaign_";
                obj2[9] = "dataBundle_";
                obj2[10] = c.b.a;
                return z.newMessageInfo(c.DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0008\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003\t\u0004\t\u0005\u001b\u0007\u0007\u00082", obj2);
            case 4:
                return c.DEFAULT_INSTANCE;
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
        obj3 = c.class;
        synchronized (obj3) {
            obj2 = new z.b(c.DEFAULT_INSTANCE);
            c.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public boolean e() {
        return this.isTestCampaign_;
    }

    @Override // com.google.protobuf.z
    public f.c.f.a.a.a.c.c f() {
        return c.c.forNumber(this.payloadCase_);
    }

    @Override // com.google.protobuf.z
    public CommonTypesProto.Priority g() {
        CommonTypesProto.Priority defaultInstance;
        if (this.priority_ == null) {
            defaultInstance = CommonTypesProto.Priority.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public MessagesProto.Content getContent() {
        MessagesProto.Content defaultInstance;
        if (this.content_ == null) {
            defaultInstance = MessagesProto.Content.getDefaultInstance();
        }
        return defaultInstance;
    }

    public List<CommonTypesProto.TriggeringCondition> h() {
        return this.triggeringConditions_;
    }

    @Override // com.google.protobuf.z
    public f.c.f.a.a.a.d i() {
        if (this.payloadCase_ == 1) {
            return (d)this.payload_;
        }
        return d.f();
    }
}
