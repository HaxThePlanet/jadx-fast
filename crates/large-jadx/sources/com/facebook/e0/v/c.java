package com.facebook.e0.v;

import android.content.Context;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.facebook.internal.a;
import com.facebook.internal.b0;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.v;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility;", "", "()V", "API_ACTIVITY_TYPE_TO_STRING", "", "Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "getJSONObjectForGraphAPICall", "Lorg/json/JSONObject;", "activityType", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "", "context", "Landroid/content/Context;", "GraphAPIActivityType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final Map<com.facebook.e0.v.c.a, String> a;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "(Ljava/lang/String;I)V", "MOBILE_INSTALL_EVENT", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;
    }
    static {
        kotlin.o[] arr = new o[2];
        c.a = j0.j(u.a(c.a.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), u.a(c.a.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));
    }

    public static final JSONObject a(com.facebook.e0.v.c.a c$a, a a2, String string3, boolean z4, Context context5) {
        String str;
        String obj2;
        a obj3;
        String obj4;
        boolean obj5;
        n.f(a, "activityType");
        n.f(context5, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", c.a.get(a));
        obj2 = g.b.d();
        if (obj2 != null) {
            jSONObject.put("app_user_id", obj2);
        }
        b0.v0(jSONObject, a2, string3, z4, context5);
        b0.w0(jSONObject, context5);
        obj2 = b0.z();
        if (obj2 != null) {
            obj3 = obj2.keys();
            for (String obj4 : obj3) {
                jSONObject.put(obj4, obj2.get(obj4));
            }
        }
        jSONObject.put("application_package_name", context5.getPackageName());
        return jSONObject;
    }
}
