package com.facebook.e0.s;

import com.facebook.e0.c;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0007J\u0008\u0010\r\u001a\u00020\u000cH\u0002J&\u0010\u000e\u001a\u00020\u000c2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0016\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0007H\u0007R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager;", "", "()V", "deprecatedEvents", "", "", "deprecatedParamFilters", "", "Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "enabled", "", "enable", "", "initialize", "processDeprecatedParameters", "parameters", "", "eventName", "processEvents", "events", "Lcom/facebook/appevents/AppEvent;", "DeprecatedParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static boolean a;
    private static final List<com.facebook.e0.s.a.a> b;
    private static final Set<String> c;
    public static final com.facebook.e0.s.a d;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u000f", d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "", "eventName", "", "deprecateParams", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDeprecateParams", "()Ljava/util/List;", "setDeprecateParams", "(Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        private String a;
        private List<String> b;
        public a(String string, List<String> list2) {
            n.f(string, "eventName");
            n.f(list2, "deprecateParams");
            super();
            this.a = string;
            this.b = list2;
        }

        public final List<String> a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public final void c(List<String> list) {
            n.f(list, "<set-?>");
            this.b = list;
        }
    }
    static {
        a aVar = new a();
        a.d = aVar;
        ArrayList arrayList = new ArrayList();
        a.b = arrayList;
        HashSet hashSet = new HashSet();
        a.c = hashSet;
    }

    public static final void a() {
        if (a.d(a.class)) {
        }
        a.a = true;
        a.d.b();
    }

    private final void b() {
        Object keys;
        int jSONObject;
        int length;
        Object optJSONArray;
        Object aVar;
        ArrayList arrayList;
        synchronized (this) {
            try {
                p pVar = q.o(o.g(), false);
                keys = pVar.g();
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }
    }

    public static final void c(Map<String, String> map, String string2) {
        List next;
        int iterator;
        boolean next2;
        boolean contains;
        if (a.d(a.class)) {
        }
        n.f(map, "parameters");
        n.f(string2, "eventName");
        if (!a.a) {
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        ArrayList arrayList2 = new ArrayList(a.b);
        Iterator iterator2 = arrayList2.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if (z3 ^= 1 != 0) {
            } else {
            }
            iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if (next.a().contains((String)next2)) {
                }
                map.remove(next2);
            }
            next2 = iterator.next();
            if (next.a().contains((String)next2)) {
            }
            map.remove(next2);
        }
    }

    public static final void d(List<c> list) {
        boolean contains;
        Set set;
        if (a.d(a.class)) {
        }
        n.f(list, "events");
        if (!a.a) {
        }
        final Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            if (a.c.contains((c)obj3.next().f())) {
            }
            obj3.remove();
        }
    }
}
