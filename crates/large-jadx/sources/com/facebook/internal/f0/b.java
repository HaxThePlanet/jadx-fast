package com.facebook.internal.f0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u000c\u001a\u00020\u0005J$\u0010\r\u001a\u00020\u000e2\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u00020\u00112\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006J\u001c\u0010\u0012\u001a\u00020\u00112\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0013\u001a\u00020\u0007J$\u0010\u0014\u001a\u00020\u00112\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eJ\"\u0010\u0016\u001a\u00020\u00112\u000c\u0008\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00070\tR*\u0010\u0003\u001a\u001e\u0012\u0008\u0012\u00060\u0005j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "", "()V", "gateKeepers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/internal/gatekeeper/AppID;", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "dumpGateKeepers", "", "appId", "getGateKeeper", "name", "getGateKeeperValue", "", "defaultValue", "resetCache", "", "setGateKeeper", "gateKeeper", "setGateKeeperValue", "value", "setGateKeepers", "gateKeeperList", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private final ConcurrentHashMap<String, ConcurrentHashMap<String, com.facebook.internal.f0.a>> a;
    public b() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
    }

    public final List<com.facebook.internal.f0.a> a(String string) {
        ArrayList arrayList;
        boolean next;
        int value;
        Object obj3;
        n.f(string, "appId");
        obj3 = this.a.get(string);
        if ((ConcurrentHashMap)obj3 != null) {
            arrayList = new ArrayList((ConcurrentHashMap)obj3.size());
            obj3 = obj3.entrySet().iterator();
            for (Map.Entry next2 : obj3) {
                arrayList.add((a)next2.getValue());
            }
        } else {
            arrayList = 0;
        }
        return arrayList;
    }

    public final void b(String string, List<com.facebook.internal.f0.a> list2) {
        Object next;
        String str;
        n.f(string, "appId");
        n.f(list2, "gateKeeperList");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator obj5 = list2.iterator();
        for (a next : obj5) {
            concurrentHashMap.put(next.a(), next);
        }
        this.a.put(string, concurrentHashMap);
    }
}
