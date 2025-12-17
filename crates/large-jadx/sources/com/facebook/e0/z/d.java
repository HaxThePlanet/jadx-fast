package com.facebook.e0.z;

import android.app.Activity;
import com.facebook.e0.v.a;
import com.facebook.e0.w.d;
import com.facebook.e0.w.d.a;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0007J\u0008\u0010\r\u001a\u00020\u000cH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008\u0011J\u0008\u0010\u0012\u001a\u00020\u000fH\u0007J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008\u0014J\u0017\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\u0008\u0017J\u0010\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "()V", "ELIGIBLE_EVENTS_KEY", "", "PRODUCTION_EVENTS_KEY", "eligibleEvents", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "productionEvents", "enable", "", "initialize", "isEligibleEvents", "", "event", "isEligibleEvents$facebook_core_release", "isEnabled", "isProductionEvents", "isProductionEvents$facebook_core_release", "populateEventsFromRawJsonString", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "trackActivity", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private static final AtomicBoolean a;
    private static final Set<String> b;
    private static final Set<String> c;
    public static final com.facebook.e0.z.d d;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.e0.z.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            com.facebook.e0.z.d dVar = d.d;
            if (d.a(dVar).get()) {
            }
            d.a(dVar).set(true);
            d.b(dVar);
        }
    }
    static {
        d dVar = new d();
        d.d = dVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        d.a = atomicBoolean;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d.b = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        d.c = linkedHashSet2;
    }

    public static final AtomicBoolean a(com.facebook.e0.z.d d) {
        if (a.d(d.class)) {
            return null;
        }
        return d.a;
    }

    public static final void b(com.facebook.e0.z.d d) {
        if (a.d(d.class)) {
        }
        d.d();
    }

    public static final void c() {
        final Class<com.facebook.e0.z.d> obj = d.class;
        synchronized (obj) {
        }
    }

    private final void d() {
        Activity i;
        Object pVar;
        if (a.d(this)) {
        }
        pVar = q.o(o.g(), false);
        pVar = pVar.k();
        if (pVar != null && pVar != null) {
            pVar = pVar.k();
            if (pVar != null) {
                g(pVar);
                if (empty ^= 1 == 0) {
                    pVar = d.j(d.a.MTML_APP_EVENT_PREDICTION);
                    a.d(pVar);
                    i = a.p();
                    if (empty2 ^= 1 != 0 && pVar != null && i != null) {
                        pVar = d.j(d.a.MTML_APP_EVENT_PREDICTION);
                        if (pVar != null) {
                            try {
                                a.d(pVar);
                                i = a.p();
                                if (i != null) {
                                }
                                d.h(i);
                                a.b(th, this);
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    public static final boolean e(String string) {
        if (a.d(d.class)) {
            return 0;
        }
        n.f(string, "event");
        return d.c.contains(string);
    }

    public static final boolean f(String string) {
        if (a.d(d.class)) {
            return 0;
        }
        n.f(string, "event");
        return d.b.contains(string);
    }

    public static final void h(Activity activity) {
        boolean empty;
        com.facebook.e0.z.e.a aVar;
        if (a.d(d.class)) {
        }
        n.f(activity, "activity");
        if (d.a.get() && a.f()) {
            if (a.f()) {
                if (d.b.isEmpty()) {
                    if (!d.c.isEmpty()) {
                        e.w.a(activity);
                    } else {
                        e.w.b(activity);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    public final void g(String string) {
        String length;
        String length2;
        JSONObject jSONObject;
        int i2;
        int i;
        Set set;
        String string2;
        boolean obj9;
        length = "eligible_for_prediction_events";
        length2 = "production_events";
        if (a.d(this)) {
        }
        jSONObject = new JSONObject(string);
        final String str = "jsonArray.getString(i)";
        if (jSONObject.has(length2)) {
            obj9 = jSONObject.getJSONArray(length2);
            i = i2;
            while (i < obj9.length()) {
                string2 = obj9.getString(i);
                n.e(string2, str);
                d.b.add(string2);
                i++;
            }
        }
        if (jSONObject.has(length)) {
            obj9 = jSONObject.getJSONArray(length);
            while (i2 < obj9.length()) {
                jSONObject = obj9.getString(i2);
                n.e(jSONObject, str);
                d.c.add(jSONObject);
                i2++;
            }
        }
        try {
        }
    }
}
