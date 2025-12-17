package com.facebook.e0.x;

import android.os.Bundle;
import com.facebook.e0.c;
import com.facebook.e0.s.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONArray;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0007J\u001e\u0010\r\u001a\u00020\u000e2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceParametersHelper;", "", "()V", "TAG", "", "buildEventsBundle", "Landroid/os/Bundle;", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "buildEventsJson", "Lorg/json/JSONArray;", "includeImplicitEvents", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final String a;
    public static final com.facebook.e0.x.b b;
    static {
        b bVar = new b();
        b.b = bVar;
        String simpleName = c.class.getSimpleName();
        n.e(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        b.a = simpleName;
    }

    public static final Bundle a(com.facebook.e0.x.c.a c$a, String string2, List<c> list3) {
        Object obj5;
        Object obj6;
        final int i = 0;
        if (a.d(b.class)) {
            return i;
        }
        n.f(a, "eventType");
        n.f(string2, "applicationId");
        n.f(list3, "appEvents");
        Bundle bundle = new Bundle();
        bundle.putString("event", a.toString());
        bundle.putString("app_id", string2);
        obj5 = b.b.b(list3, string2);
        if (c.a.CUSTOM_APP_EVENTS == a && obj5.length() == 0) {
            obj5 = b.b.b(list3, string2);
            if (obj5.length() == 0) {
                return i;
            }
            bundle.putString("custom_events", obj5.toString());
        }
        return bundle;
    }

    private final JSONArray b(List<c> list, String string2) {
        Object string;
        String str;
        StringBuilder stringBuilder;
        String str2;
        if (a.d(this)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        List obj7 = p.N0(list);
        a.d(obj7);
        obj7 = obj7.iterator();
        while (obj7.hasNext()) {
            string = obj7.next();
            if ((c)string.g()) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Event with invalid checksum: ");
            stringBuilder.append(string);
            b0.d0(b.a, stringBuilder.toString());
            if (z3 ^= 1 == 0) {
            } else {
            }
            jSONArray.put(string.e());
            if (string.h() && c(string2)) {
            }
            if (c(string2)) {
            }
        }
        return jSONArray;
    }

    private final boolean c(String string) {
        int i;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        final p obj3 = q.o(string, i);
        if (obj3 != null) {
            i = obj3.l();
        }
        return i;
    }
}
