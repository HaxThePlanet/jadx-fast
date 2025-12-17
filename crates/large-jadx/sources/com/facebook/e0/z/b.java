package com.facebook.e0.z;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.facebook.e0.r.g.f;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.j0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0008\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/suggestedevents/PredictionHistoryManager;", "", "()V", "CLICKED_PATH_STORE", "", "SUGGESTED_EVENTS_HISTORY", "clickedViewPaths", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shardPreferences", "Landroid/content/SharedPreferences;", "addPrediction", "", "pathID", "predictedEvent", "getPathID", "view", "Landroid/view/View;", "text", "initAndWait", "queryEvent", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final Map<String, String> a;
    private static SharedPreferences b;
    private static final AtomicBoolean c;
    public static final com.facebook.e0.z.b d;
    static {
        b bVar = new b();
        b.d = bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        b.a = linkedHashMap;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        b.c = atomicBoolean;
    }

    public static final void a(String string, String string2) {
        boolean z;
        if (a.d(b.class)) {
        }
        n.f(string, "pathID");
        n.f(string2, "predictedEvent");
        if (!b.c.get()) {
            b.d.c();
        }
        Map map = b.a;
        map.put(string, string2);
        SharedPreferences obj2 = b.b;
        if (obj2 == null) {
        } else {
            obj2.edit().putString("SUGGESTED_EVENTS_HISTORY", b0.f0(j0.u(map))).apply();
        }
        n.w("shardPreferences");
        throw 0;
    }

    public static final String b(View view, String string2) {
        String simpleName;
        Object obj4;
        simpleName = "text";
        if (a.d(b.class)) {
            return null;
        }
        n.f(view, "view");
        n.f(string2, simpleName);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(simpleName, string2);
        JSONArray obj5 = new JSONArray();
        while (obj4 != null) {
            obj5.put(obj4.getClass().getSimpleName());
            obj4 = f.j(obj4);
        }
        jSONObject.put("classname", obj5);
        return b0.y0(jSONObject.toString());
    }

    private final void c() {
        String str;
        if (a.d(this)) {
        }
        AtomicBoolean bool = b.c;
        if (bool.get()) {
        }
        SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
        n.e(sharedPreferences, "FacebookSdk.getApplicati…RE, Context.MODE_PRIVATE)");
        b.b = sharedPreferences;
        if (sharedPreferences == null) {
        } else {
            String string = sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", "");
            if (string != null) {
                str = string;
            }
            n.e(str, "shardPreferences.getStri…EVENTS_HISTORY, \"\") ?: \"\"");
            b.a.putAll(b0.b0(str));
            bool.set(true);
        }
        n.w("shardPreferences");
        throw 0;
    }

    public static final String d(String string) {
        int i;
        Object obj4;
        if (a.d(b.class)) {
            return null;
        }
        n.f(string, "pathID");
        Map map = b.a;
        if (map.containsKey(string)) {
            i = obj4;
        }
        return i;
    }
}
