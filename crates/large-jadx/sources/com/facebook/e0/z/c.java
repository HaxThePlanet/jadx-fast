package com.facebook.e0.z;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.facebook.e0.r.g.f;
import com.facebook.internal.g0.i.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0008\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042\u0006\u0010\u0008\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventViewHierarchy;", "", "()V", "blacklistedViews", "", "Ljava/lang/Class;", "Landroid/view/View;", "getAllClickableViews", "view", "getDictionaryOfView", "Lorg/json/JSONObject;", "clickedView", "getTextOfChildren", "", "getTextOfViewRecursively", "hostView", "updateBasicInfo", "", "json", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final List<Class<? extends View>> a;
    public static final com.facebook.e0.z.c b;
    static {
        c cVar = new c();
        c.b = cVar;
        Class[] arr = new Class[8];
        c.a = p.j(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class);
    }

    public static final List<View> a(View view) {
        boolean clickable;
        boolean instance;
        if (a.d(c.class)) {
            return 0;
        }
        n.f(view, "view");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = c.a.iterator();
        for (Class next4 : iterator) {
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        Iterator obj5 = f.b(view).iterator();
        for (View next2 : obj5) {
            arrayList.addAll(c.a(next2));
        }
        return arrayList;
    }

    public static final JSONObject b(View view, View view2) {
        String str;
        int i;
        if (a.d(c.class)) {
            return null;
        }
        n.f(view, "view");
        n.f(view2, "clickedView");
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            jSONObject.put("is_interacted", true);
        }
        c.e(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        Iterator obj5 = f.b(view).iterator();
        for (View next2 : obj5) {
            jSONArray.put(c.b(next2, view2));
        }
        jSONObject.put("childviews", jSONArray);
        return jSONObject;
    }

    private final List<String> c(View view) {
        List list;
        String str;
        int i;
        if (a.d(this)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = f.b(view).iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            str = f.k((View)next2);
            if (str.length() > 0) {
            } else {
            }
            i = 0;
            if (i != 0) {
            }
            arrayList.addAll(c(next2));
            arrayList.add(str);
            i = 1;
        }
        return arrayList;
    }

    public static final String d(View view) {
        int i;
        if (a.d(c.class)) {
            return null;
        }
        n.f(view, "hostView");
        String str2 = f.k(view);
        i = str2.length() > 0 ? 1 : 0;
        if (i != 0) {
            return str2;
        }
        String obj4 = TextUtils.join(" ", c.b.c(view));
        n.e(obj4, "TextUtils.join(\" \", childrenText)");
        return obj4;
    }

    public static final void e(View view, JSONObject jSONObject2) {
        int length;
        boolean str2;
        int str;
        int i;
        Object obj6;
        if (a.d(c.class)) {
        }
        n.f(view, "view");
        n.f(jSONObject2, "json");
        String str5 = f.k(view);
        final String str6 = f.i(view);
        jSONObject2.put("classname", view.getClass().getSimpleName());
        jSONObject2.put("classtypebitmask", f.c(view));
        final int i3 = 0;
        str = str5.length() > 0 ? i : i3;
        if (str != null) {
            jSONObject2.put("text", str5);
        }
        if (str6.length() > 0) {
        } else {
            try {
                i = i3;
                if (i != 0) {
                }
                jSONObject2.put("hint", str6);
                if (view instanceof EditText) {
                }
                jSONObject2.put("inputtype", (EditText)view.getInputType());
                a.b(view, obj0);
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        }
    }
}
