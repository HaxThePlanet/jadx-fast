package com.facebook.e0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.e0.s.a;
import com.facebook.e0.v.c;
import com.facebook.e0.v.c.a;
import com.facebook.internal.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ&\u0010\u001c\u001a\u00020\u00082\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bJ0\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u001bH\u0002R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lcom/facebook/appevents/SessionEventsState;", "", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "accumulatedEventCount", "", "getAccumulatedEventCount", "()I", "accumulatedEvents", "", "Lcom/facebook/appevents/AppEvent;", "eventsToPersist", "", "getEventsToPersist", "()Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "accumulatePersistedEvents", "", "events", "addEvent", "event", "clearInFlightAndStats", "moveToAccumulated", "", "populateRequest", "request", "Lcom/facebook/GraphRequest;", "applicationContext", "Landroid/content/Context;", "includeImplicitEvents", "limitEventUsage", "numSkipped", "Lorg/json/JSONArray;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class o {

    private static final String f;
    private static final int g = 1000;
    private List<com.facebook.e0.c> a;
    private final List<com.facebook.e0.c> b;
    private int c;
    private final a d;
    private final String e;
    static {
        String simpleName = o.class.getSimpleName();
        n.e(simpleName, "SessionEventsState::class.java.simpleName");
        o.f = simpleName;
        int i = 1000;
    }

    public o(a a, String string2) {
        n.f(a, "attributionIdentifiers");
        n.f(string2, "anonymousAppDeviceGUID");
        super();
        this.d = a;
        this.e = string2;
        ArrayList obj2 = new ArrayList();
        this.a = obj2;
        obj2 = new ArrayList();
        this.b = obj2;
    }

    private final void f(p p, Context context2, int i3, JSONArray jSONArray4, boolean z5) {
        JSONObject obj5;
        int obj8;
        if (a.d(this)) {
        }
        if (this.c > 0) {
            c.a(c.a.CUSTOM_APP_EVENTS, this.d, this.e, z5, context2).put("num_skipped_events", i3);
        }
        p.D(obj5);
        obj5 = p.s();
        final String obj6 = jSONArray4.toString();
        n.e(obj6, "events.toString()");
        obj5.putString("custom_events", obj6);
        p.H(obj6);
        p.F(obj5);
    }

    public final void a(com.facebook.e0.c c) {
        int i;
        int obj3;
        synchronized (this) {
            try {
                n.f(c, "event");
                if (size += size2 >= o.g) {
                } else {
                }
                this.c = obj3++;
                this.a.add(c);
            } catch (Throwable th) {
            }
        }
    }

    public final void b(boolean z) {
        boolean z2;
        Object obj2;
        synchronized (this) {
            try {
                if (z != null) {
                }
                this.a.addAll(this.b);
                this.b.clear();
                this.c = 0;
            } catch (Throwable th) {
            }
        }
    }

    public final int c() {
        synchronized (this) {
            try {
                return 0;
                return this.a.size();
                a.b(th, this);
                return obj1;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public final List<com.facebook.e0.c> d() {
        synchronized (this) {
            try {
                return 0;
                ArrayList arrayList = new ArrayList();
                this.a = arrayList;
                return this.a;
                a.b(th, this);
                return obj1;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public final int e(p p, Context context2, boolean z3, boolean z4) {
        Object string;
        boolean z;
        StringBuilder stringBuilder;
        String str;
        final int i = 0;
        if (a.d(this)) {
            return i;
        }
        n.f(p, "request");
        n.f(context2, "applicationContext");
        a.d(this.a);
        this.b.addAll(this.a);
        this.a.clear();
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = this.b.iterator();
        synchronized (this) {
            while (iterator.hasNext()) {
                string = iterator.next();
                if ((c)string.g()) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Event with invalid checksum: ");
                stringBuilder.append(string);
                b0.d0(o.f, stringBuilder.toString());
                if (!z3) {
                } else {
                }
                jSONArray.put(string.e());
                if (!string.h()) {
                }
            }
            if (jSONArray.length() == 0) {
                return i;
            }
            w obj11 = w.a;
            this.f(p, context2, this.c, jSONArray, z4);
            return jSONArray.length();
        }
    }
}
