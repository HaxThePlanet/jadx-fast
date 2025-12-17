package com.facebook.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0008\u001a\u00020\u0005H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0006H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lcom/facebook/internal/ProfileInformationCache;", "", "()V", "infoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lorg/json/JSONObject;", "getProfileInformation", "accessToken", "putProfileInformation", "", "key", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class y {

    private static final ConcurrentHashMap<String, JSONObject> a;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        y.a = concurrentHashMap;
    }

    public static final JSONObject a(String string) {
        n.f(string, "accessToken");
        return (JSONObject)y.a.get(string);
    }

    public static final void b(String string, JSONObject jSONObject2) {
        n.f(string, "key");
        n.f(jSONObject2, "value");
        y.a.put(string, jSONObject2);
    }
}
