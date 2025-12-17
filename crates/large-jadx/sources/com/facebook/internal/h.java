package com.facebook.internal;

import com.facebook.n.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u007f\u0008\u0000\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000cJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0012R'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification;", "", "otherErrors", "", "", "", "transientErrors", "loginRecoverableErrors", "otherRecoveryMessage", "", "transientRecoveryMessage", "loginRecoverableRecoveryMessage", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginRecoverableErrors", "()Ljava/util/Map;", "getOtherErrors", "getTransientErrors", "classify", "Lcom/facebook/FacebookRequestError$Category;", "errorCode", "errorSubCode", "isTransient", "", "getRecoveryMessage", "category", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class h {

    private static com.facebook.internal.h g;
    public static final com.facebook.internal.h.a h;
    private final Map<Integer, Set<Integer>> a;
    private final Map<Integer, Set<Integer>> b;
    private final Map<Integer, Set<Integer>> c;
    private final String d;
    private final String e;
    private final String f;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J&\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!\u0018\u00010 2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification$Companion;", "", "()V", "EC_APP_NOT_INSTALLED", "", "EC_APP_TOO_MANY_CALLS", "EC_INVALID_SESSION", "EC_INVALID_TOKEN", "EC_RATE", "EC_SERVICE_UNAVAILABLE", "EC_TOO_MANY_USER_ACTION_CALLS", "EC_USER_TOO_MANY_CALLS", "ESC_APP_INACTIVE", "ESC_APP_NOT_INSTALLED", "KEY_LOGIN_RECOVERABLE", "", "KEY_NAME", "KEY_OTHER", "KEY_RECOVERY_MESSAGE", "KEY_TRANSIENT", "defaultErrorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getDefaultErrorClassification$annotations", "getDefaultErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "defaultErrorClassificationImpl", "getDefaultErrorClassificationImpl", "defaultInstance", "createFromJSON", "jsonArray", "Lorg/json/JSONArray;", "parseJSONDefinition", "", "", "definition", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final com.facebook.internal.h c() {
            kotlin.o[] arr = new o[5];
            final int i2 = 2;
            final int i7 = 0;
            final int i8 = 0;
            arr[i8] = u.a(Integer.valueOf(i2), i7);
            int i3 = 4;
            final int i12 = 1;
            arr[i12] = u.a(Integer.valueOf(i3), i7);
            arr[i2] = u.a(9, i7);
            final int i13 = 3;
            arr[i13] = u.a(17, i7);
            arr[i3] = u.a(341, i7);
            kotlin.o[] arr2 = new o[i13];
            arr2[i8] = u.a(102, i7);
            arr2[i12] = u.a(190, i7);
            arr2[i2] = u.a(412, i7);
            super(0, j0.j(arr), j0.j(arr2), 0, 0, 0);
            return hVar;
        }

        private final Map<Integer, Set<Integer>> d(JSONObject jSONObject) {
            int i2;
            JSONObject optJSONObject;
            int optInt;
            int hashSet;
            String length;
            int length2;
            int i;
            int valueOf;
            final JSONArray obj12 = jSONObject.optJSONArray("items");
            final int i3 = 0;
            if (obj12.length() == 0) {
                return i3;
            }
            HashMap hashMap = new HashMap();
            final int i4 = 0;
            i2 = i4;
            while (i2 < obj12.length()) {
                optJSONObject = obj12.optJSONObject(i2);
                if (optJSONObject != null) {
                }
                i2++;
                optInt = optJSONObject.optInt("code");
                if (optInt == 0) {
                } else {
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("subcodes");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                } else {
                }
                hashSet = i3;
                hashMap.put(Integer.valueOf(optInt), hashSet);
                if (optJSONArray.length() > 0) {
                } else {
                }
                hashSet = new HashSet();
                i = i4;
                while (i < optJSONArray.length()) {
                    valueOf = optJSONArray.optInt(i);
                    if (valueOf != 0) {
                    }
                    i++;
                    hashSet.add(Integer.valueOf(valueOf));
                }
                valueOf = optJSONArray.optInt(i);
                if (valueOf != 0) {
                }
                i++;
                hashSet.add(Integer.valueOf(valueOf));
            }
            return hashMap;
        }

        public final com.facebook.internal.h a(JSONArray jSONArray) {
            int i5;
            JSONObject optJSONObject;
            int i2;
            int i4;
            int i;
            int optString2;
            int optString3;
            int optString;
            String optString4;
            boolean str;
            int i3;
            String str2;
            final int i6 = 0;
            if (jSONArray == null) {
                return i6;
            }
            i5 = 0;
            optString = optString3;
            while (i5 < jSONArray.length()) {
                optJSONObject = jSONArray.optJSONObject(i5);
                optString4 = optJSONObject.optString("name");
                if (optJSONObject != null && optString4 != null) {
                }
                i5++;
                optString4 = optJSONObject.optString("name");
                if (optString4 != null) {
                }
                i3 = 1;
                str2 = "recovery_message";
                if (l.x(optString4, "other", i3)) {
                } else {
                }
                if (l.x(optString4, "transient", i3)) {
                } else {
                }
                if (l.x(optString4, "login_recoverable", i3)) {
                }
                optString = optJSONObject.optString(str2, i6);
                i = d(optJSONObject);
                optString3 = optJSONObject.optString(str2, i6);
                i4 = d(optJSONObject);
                optString2 = optJSONObject.optString(str2, i6);
                i2 = d(optJSONObject);
            }
            super(i2, i4, i, optString2, optString3, optString);
            return obj15;
        }

        public final com.facebook.internal.h b() {
            com.facebook.internal.h hVar;
            synchronized (this) {
                try {
                    h.b(h.h.c());
                    com.facebook.internal.h hVar2 = h.a();
                    if (hVar2 == null) {
                    } else {
                    }
                    return hVar2;
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
                    throw nullPointerException;
                    throw th;
                }
            }
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.h = aVar;
    }

    public h(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String string4, String string5, String string6) {
        super();
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = string4;
        this.e = string5;
        this.f = string6;
    }

    public static final com.facebook.internal.h a() {
        return h.g;
    }

    public static final void b(com.facebook.internal.h h) {
        h.g = h;
    }

    public final n.a c(int i, int i2, boolean z3) {
        Integer valueOf;
        int obj2;
        int obj3;
        Object obj4;
        if (z3) {
            return n.a.TRANSIENT;
        }
        obj4 = this.a;
        obj4 = this.a.get(Integer.valueOf(i));
        if (obj4 != null && obj4.containsKey(Integer.valueOf(i)) && obj4 != null && (Set)obj4.contains(Integer.valueOf(i2))) {
            if (obj4.containsKey(Integer.valueOf(i))) {
                obj4 = this.a.get(Integer.valueOf(i));
                if ((Set)obj4 != null) {
                    if ((Set)obj4.contains(Integer.valueOf(i2))) {
                    }
                }
                return n.a.OTHER;
            }
        }
        obj4 = this.c;
        obj4 = this.c.get(Integer.valueOf(i));
        if (obj4 != null && obj4.containsKey(Integer.valueOf(i)) && obj4 != null && (Set)obj4.contains(Integer.valueOf(i2))) {
            if (obj4.containsKey(Integer.valueOf(i))) {
                obj4 = this.c.get(Integer.valueOf(i));
                if ((Set)obj4 != null) {
                    if ((Set)obj4.contains(Integer.valueOf(i2))) {
                    }
                }
                return n.a.LOGIN_RECOVERABLE;
            }
        }
        obj4 = this.b;
        obj2 = this.b.get(Integer.valueOf(i));
        if (obj4 != null && obj4.containsKey(Integer.valueOf(i)) && obj2 != null && (Set)obj2.contains(Integer.valueOf(i2))) {
            if (obj4.containsKey(Integer.valueOf(i))) {
                obj2 = this.b.get(Integer.valueOf(i));
                if ((Set)obj2 != null) {
                    if ((Set)obj2.contains(Integer.valueOf(i2))) {
                    }
                }
                return n.a.TRANSIENT;
            }
        }
        return n.a.OTHER;
    }

    public final String d(n.a n$a) {
        int i;
        String obj2;
        if (a == 0) {
            obj2 = 0;
        } else {
            obj2 = i.a[a.ordinal()];
            if (obj2 != 1) {
                if (obj2 != 2) {
                    if (obj2 != 3) {
                    } else {
                        obj2 = this.e;
                    }
                } else {
                    obj2 = this.f;
                }
            } else {
                obj2 = this.d;
            }
        }
        return obj2;
    }
}
