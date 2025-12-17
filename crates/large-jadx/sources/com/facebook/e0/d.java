package com.facebook.e0;

import com.facebook.internal.a;
import com.facebook.internal.a.a;
import com.facebook.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\"\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\tH\u0086\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0017R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lcom/facebook/appevents/AppEventCollection;", "", "()V", "eventCount", "", "getEventCount", "()I", "stateMap", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "Lcom/facebook/appevents/SessionEventsState;", "addEvent", "", "accessTokenAppIdPair", "appEvent", "Lcom/facebook/appevents/AppEvent;", "addPersistedEvents", "persistedEvents", "Lcom/facebook/appevents/PersistedEvents;", "get", "getSessionEventsState", "accessTokenAppId", "keySet", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private final HashMap<com.facebook.e0.a, com.facebook.e0.o> a;
    public d() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    private final com.facebook.e0.o e(com.facebook.e0.a a) {
        Object obj;
        a aVar2;
        com.facebook.e0.o oVar;
        com.facebook.e0.g.a aVar;
        int i = 0;
        synchronized (this) {
            try {
                android.content.Context context = o.f();
                aVar2 = a.h.e(context);
                if (aVar2 != null) {
                } else {
                }
                oVar = new o(aVar2, g.b.b(context));
                obj = oVar;
                obj = i;
                if (obj == null) {
                }
                return i;
                this.a.put(a, obj);
                return obj;
                throw a;
            }
        }
    }

    public final void a(com.facebook.e0.a a, com.facebook.e0.c c2) {
        n.f(a, "accessTokenAppIdPair");
        n.f(c2, "appEvent");
        final com.facebook.e0.o obj2 = e(a);
        synchronized (this) {
            try {
                obj2.a(c2);
                throw a;
            }
        }
    }

    public final void b(com.facebook.e0.n n) {
        Object iterator;
        com.facebook.e0.o oVar;
        boolean next;
        synchronized (this) {
        }
    }

    public final com.facebook.e0.o c(com.facebook.e0.a a) {
        n.f(a, "accessTokenAppIdPair");
        return (o)this.a.get(a);
        synchronized (this) {
            n.f(a, "accessTokenAppIdPair");
            return (o)this.a.get(a);
        }
    }

    public final int d() {
        int i;
        int i2;
        i = 0;
        Iterator iterator = this.a.values().iterator();
        synchronized (this) {
            for (o next2 : iterator) {
                i += i2;
            }
            return i;
        }
    }

    public final Set<com.facebook.e0.a> f() {
        Set keySet = this.a.keySet();
        n.e(keySet, "stateMap.keys");
        return keySet;
        synchronized (this) {
            keySet = this.a.keySet();
            n.e(keySet, "stateMap.keys");
            return keySet;
        }
    }
}
