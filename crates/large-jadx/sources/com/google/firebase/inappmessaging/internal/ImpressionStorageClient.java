package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.z;
import com.google.protobuf.z.a;
import f.c.f.a.a.a.b;
import f.c.f.a.a.a.c;
import f.c.f.a.a.a.c.c;
import f.c.f.a.a.a.d;
import f.c.f.a.a.a.e.a;
import f.c.f.a.a.a.e.b;
import f.c.f.a.a.a.e.b.b;
import f.c.f.a.a.a.e.e;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.l;
import i.b.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ImpressionStorageClient {

    private static final b EMPTY_IMPRESSIONS;
    private l<b> cachedImpressionsMaybe;
    private final com.google.firebase.inappmessaging.internal.ProtoStorageClient storageClient;
    static {
        ImpressionStorageClient.EMPTY_IMPRESSIONS = b.g();
    }

    ImpressionStorageClient(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient) {
        super();
        this.cachedImpressionsMaybe = l.i();
        this.storageClient = protoStorageClient;
    }

    public static void a(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, b b2) {
        impressionStorageClient.initInMemCache(b2);
    }

    private static b appendImpression(b b, a a2) {
        b.b obj0 = b.i(b);
        obj0.b(a2);
        return (b)obj0.build();
    }

    private void b(b b) {
        initInMemCache(b);
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = l.i();
    }

    private f d(HashSet hashSet, b b2) {
        String string;
        boolean contains;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Existing impressions: ");
        stringBuilder.append(b2.toString());
        Logging.logd(stringBuilder.toString());
        b.b bVar = b.h();
        Iterator obj5 = b2.f().iterator();
        while (obj5.hasNext()) {
            string = obj5.next();
            if (!hashSet.contains((a)string.getCampaignId())) {
            }
            bVar.b(string);
        }
        z obj4 = bVar.build();
        obj5 = new StringBuilder();
        obj5.append("New cleared impression list: ");
        obj5.append((b)obj4.toString());
        Logging.logd(obj5.toString());
        d0 d0Var = new d0(this, obj4);
        return this.storageClient.write(obj4).j(d0Var);
    }

    private void f(Throwable throwable) {
        clearInMemCache();
    }

    private void h(b b) {
        initInMemCache(b);
    }

    private void initInMemCache(b b) {
        this.cachedImpressionsMaybe = l.p(b);
    }

    private f j(a a, b b2) {
        b obj2 = ImpressionStorageClient.appendImpression(b2, a);
        c0 c0Var = new c0(this, obj2);
        return this.storageClient.write(obj2).j(c0Var);
    }

    public void c(b b) {
        b(b);
    }

    public b clearImpressions(e e) {
        String campaignId;
        boolean equals;
        c.c vANILLA_PAYLOAD;
        HashSet hashSet = new HashSet();
        Iterator obj5 = e.f().iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            if ((c)next2.f().equals(c.c.VANILLA_PAYLOAD)) {
            } else {
            }
            campaignId = next2.d().getCampaignId();
            hashSet.add(campaignId);
            campaignId = next2.i().getCampaignId();
        }
        obj5 = new StringBuilder();
        obj5.append("Potential impressions to clear: ");
        obj5.append(hashSet.toString());
        Logging.logd(obj5.toString());
        e0 e0Var = new e0(this, hashSet);
        return getAllImpressions().f(ImpressionStorageClient.EMPTY_IMPRESSIONS).l(e0Var);
    }

    public f e(HashSet hashSet, b b2) {
        return d(hashSet, b2);
    }

    public void g(Throwable throwable) {
        f(throwable);
    }

    public l<b> getAllImpressions() {
        b0 b0Var = new b0(this);
        a0 a0Var = new a0(this);
        return this.cachedImpressionsMaybe.z(this.storageClient.read(b.parser()).h(b0Var)).g(a0Var);
    }

    public void i(b b) {
        h(b);
    }

    public a0<Boolean> isImpressed(c c) {
        String obj3;
        if (c.f().equals(c.c.VANILLA_PAYLOAD)) {
            obj3 = c.i().getCampaignId();
        } else {
            obj3 = c.d().getCampaignId();
        }
        return getAllImpressions().q(f2.a).m(a.a).map(e2.a).contains(obj3);
    }

    public f k(a a, b b2) {
        return j(a, b2);
    }

    public b storeImpression(a a) {
        z zVar = new z(this, a);
        return getAllImpressions().f(ImpressionStorageClient.EMPTY_IMPRESSIONS).l(zVar);
    }
}
