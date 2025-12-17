package com.facebook.e0;

import com.facebook.internal.g0.i.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B7\u0008\u0016\u0012.\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006`\u0008¢\u0006\u0002\u0010\tJ\u001c\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00052\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0005J\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0086\u0002J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002R6\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lcom/facebook/appevents/PersistedEvents;", "Ljava/io/Serializable;", "()V", "appEventMap", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "events", "addEvents", "", "accessTokenAppIdPair", "appEvents", "", "containsKey", "", "get", "keySet", "", "writeReplace", "", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class n implements Serializable {

    private static final long serialVersionUID = 20160629001L;
    private final HashMap<com.facebook.e0.a, List<com.facebook.e0.c>> events;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB5\u0012.\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005`\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0002R6\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/appevents/PersistedEvents$SerializationProxyV1;", "Ljava/io/Serializable;", "proxyEvents", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Serializable {

        private static final long serialVersionUID = 20160629001L;
        private final HashMap<com.facebook.e0.a, List<com.facebook.e0.c>> proxyEvents;
        static {
        }

        public a(HashMap<com.facebook.e0.a, List<com.facebook.e0.c>> hashMap) {
            n.f(hashMap, "proxyEvents");
            super();
            this.proxyEvents = hashMap;
        }

        private final Object readResolve() {
            n nVar = new n(this.proxyEvents);
            return nVar;
        }
    }
    static {
    }

    public n() {
        super();
        HashMap hashMap = new HashMap();
        this.events = hashMap;
    }

    public n(HashMap<com.facebook.e0.a, List<com.facebook.e0.c>> hashMap) {
        n.f(hashMap, "appEventMap");
        super();
        HashMap hashMap2 = new HashMap();
        this.events = hashMap2;
        hashMap2.putAll(hashMap);
    }

    private final Object writeReplace() {
        if (a.d(this)) {
            return null;
        }
        n.a aVar = new n.a(this.events);
        return aVar;
    }

    public final void a(com.facebook.e0.a a, List<com.facebook.e0.c> list2) {
        if (a.d(this)) {
        }
        n.f(a, "accessTokenAppIdPair");
        n.f(list2, "appEvents");
        if (!this.events.containsKey(a)) {
            this.events.put(a, p.N0(list2));
        }
        final Object obj2 = this.events.get(a);
        if ((List)obj2 != null) {
            (List)obj2.addAll(list2);
        }
    }

    public final List<com.facebook.e0.c> b(com.facebook.e0.a a) {
        if (a.d(this)) {
            return 0;
        }
        n.f(a, "accessTokenAppIdPair");
        return (List)this.events.get(a);
    }

    public final Set<com.facebook.e0.a> c() {
        if (a.d(this)) {
            return 0;
        }
        Set keySet = this.events.keySet();
        n.e(keySet, "events.keys");
        return keySet;
    }
}
