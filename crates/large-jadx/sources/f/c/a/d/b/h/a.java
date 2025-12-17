package f.c.a.d.b.h;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEvent;

/* loaded from: classes2.dex */
final class a implements ObjectEncoder<MessagingClientEvent> {

    static final f.c.a.d.b.h.a a;
    private static final FieldDescriptor b;
    private static final FieldDescriptor c;
    private static final FieldDescriptor d;
    private static final FieldDescriptor e;
    private static final FieldDescriptor f;
    private static final FieldDescriptor g;
    private static final FieldDescriptor h;
    private static final FieldDescriptor i;
    private static final FieldDescriptor j;
    private static final FieldDescriptor k;
    private static final FieldDescriptor l;
    private static final FieldDescriptor m;
    private static final FieldDescriptor n;
    private static final FieldDescriptor o;
    private static final FieldDescriptor p;
    static {
        a aVar = new a();
        a.a = aVar;
        o oVar = new o();
        oVar.a(1);
        a.b = FieldDescriptor.builder("projectNumber").withProperty(oVar.b()).build();
        o oVar2 = new o();
        oVar2.a(2);
        a.c = FieldDescriptor.builder("messageId").withProperty(oVar2.b()).build();
        o oVar3 = new o();
        oVar3.a(3);
        a.d = FieldDescriptor.builder("instanceId").withProperty(oVar3.b()).build();
        o oVar4 = new o();
        oVar4.a(4);
        a.e = FieldDescriptor.builder("messageType").withProperty(oVar4.b()).build();
        o oVar5 = new o();
        oVar5.a(5);
        a.f = FieldDescriptor.builder("sdkPlatform").withProperty(oVar5.b()).build();
        o oVar6 = new o();
        oVar6.a(6);
        a.g = FieldDescriptor.builder("packageName").withProperty(oVar6.b()).build();
        o oVar7 = new o();
        oVar7.a(7);
        a.h = FieldDescriptor.builder("collapseKey").withProperty(oVar7.b()).build();
        o oVar8 = new o();
        oVar8.a(8);
        a.i = FieldDescriptor.builder("priority").withProperty(oVar8.b()).build();
        o oVar9 = new o();
        oVar9.a(9);
        a.j = FieldDescriptor.builder("ttl").withProperty(oVar9.b()).build();
        o oVar10 = new o();
        oVar10.a(10);
        a.k = FieldDescriptor.builder("topic").withProperty(oVar10.b()).build();
        o oVar11 = new o();
        oVar11.a(11);
        a.l = FieldDescriptor.builder("bulkId").withProperty(oVar11.b()).build();
        o oVar12 = new o();
        oVar12.a(12);
        a.m = FieldDescriptor.builder("event").withProperty(oVar12.b()).build();
        o oVar13 = new o();
        oVar13.a(13);
        a.n = FieldDescriptor.builder("analyticsLabel").withProperty(oVar13.b()).build();
        o oVar14 = new o();
        oVar14.a(14);
        a.o = FieldDescriptor.builder("campaignId").withProperty(oVar14.b()).build();
        o oVar15 = new o();
        oVar15.a(15);
        a.p = FieldDescriptor.builder("composerLabel").withProperty(oVar15.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        (ObjectEncoderContext)object2.add(a.b, (MessagingClientEvent)object.getProjectNumber());
        object2.add(a.c, object.getMessageId());
        object2.add(a.d, object.getInstanceId());
        object2.add(a.e, object.getMessageType());
        object2.add(a.f, object.getSdkPlatform());
        object2.add(a.g, object.getPackageName());
        object2.add(a.h, object.getCollapseKey());
        object2.add(a.i, object.getPriority());
        object2.add(a.j, object.getTtl());
        object2.add(a.k, object.getTopic());
        object2.add(a.l, object.getBulkId());
        object2.add(a.m, object.getEvent());
        object2.add(a.n, object.getAnalyticsLabel());
        object2.add(a.o, object.getCampaignId());
        object2.add(a.p, object.getComposerLabel());
    }
}
