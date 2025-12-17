package com.facebook.e0.q;

import com.facebook.internal.g0.i.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\t\u0008\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/facebook/appevents/aam/MetadataRule;", "", "name", "", "keyRules", "", "valRule", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKeyRules", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getValRule", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final Set<com.facebook.e0.q.c> d;
    public static final com.facebook.e0.q.c.a e;
    private final List<String> a;
    private final String b;
    private final String c;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000fH\u0007J\u000e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/aam/MetadataRule$Companion;", "", "()V", "FIELD_K", "", "FIELD_K_DELIMITER", "FIELD_V", "rules", "", "Lcom/facebook/appevents/aam/MetadataRule;", "constructRules", "", "jsonObject", "Lorg/json/JSONObject;", "getEnabledRuleNames", "", "getRules", "updateRules", "rulesFromServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final void a(JSONObject jSONObject) {
            Object next;
            Object optJSONObject;
            int i2;
            Object optString;
            int i3;
            int i5;
            int i6;
            int i;
            int i4;
            String str;
            com.facebook.e0.q.c cVar;
            final Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                next = keys.next();
                optJSONObject = jSONObject.optJSONObject((String)next);
                if (optJSONObject != null) {
                }
                String str2 = "k";
                optString = optJSONObject.optString(str2);
                str = "v";
                optJSONObject = optJSONObject.optString(str);
                n.e(optString, str2);
                if (optString.length() == 0) {
                } else {
                }
                i2 = 0;
                if (i2 != 0) {
                } else {
                }
                n.e(next, "key");
                n.e(optJSONObject, str);
                cVar = new c(next, l.E0(optString, /* result */, false, 0, 6, 0), optJSONObject, 0);
                c.a().add(cVar);
                i2 = 1;
            }
        }

        public final Set<String> b() {
            String str;
            HashSet hashSet = new HashSet();
            Iterator iterator = c.a().iterator();
            for (c next2 : iterator) {
                hashSet.add(next2.c());
            }
            return hashSet;
        }

        public final Set<com.facebook.e0.q.c> c() {
            HashSet hashSet = new HashSet(c.a());
            return hashSet;
        }

        public final void d(String string) {
            n.f(string, "rulesFromServer");
            c.a().clear();
            JSONObject jSONObject = new JSONObject(string);
            a(jSONObject);
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.e = aVar;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        c.d = copyOnWriteArraySet;
    }

    private c(String string, List<String> list2, String string3) {
        super();
        this.b = string;
        this.c = string3;
        this.a = list2;
    }

    public c(String string, List list2, String string3, g g4) {
        super(string, list2, string3);
    }

    public static final Set a() {
        if (a.d(c.class)) {
            return null;
        }
        return c.d;
    }

    public final List<String> b() {
        if (a.d(this)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(this.a);
        return arrayList;
    }

    public final String c() {
        if (a.d(this)) {
            return null;
        }
        return this.b;
    }

    public final String d() {
        if (a.d(this)) {
            return null;
        }
        return this.c;
    }
}
