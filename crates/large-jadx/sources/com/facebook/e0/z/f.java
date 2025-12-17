package com.facebook.e0.z;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.e0.m;
import com.facebook.e0.r.g.f;
import com.facebook.e0.w.d;
import com.facebook.e0.w.d.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener;", "Landroid/view/View$OnClickListener;", "hostView", "Landroid/view/View;", "rootView", "activityName", "", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "baseListener", "hostViewWeakReference", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "onClick", "", "view", "predictAndProcess", "pathID", "buttonText", "viewData", "Lorg/json/JSONObject;", "process", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f implements View.OnClickListener {

    private static final Set<Integer> w;
    public static final com.facebook.e0.z.f.a x;
    private final View.OnClickListener a;
    private final WeakReference<View> b;
    private final WeakReference<View> c;
    private final String v;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener$Companion;", "", "()V", "API_ENDPOINT", "", "OTHER_EVENT", "viewsAttachedListener", "", "", "attachListener", "", "hostView", "Landroid/view/View;", "rootView", "activityName", "attachListener$facebook_core_release", "processPredictedResult", "predictedEvent", "buttonText", "dense", "", "queryHistoryAndProcess", "", "pathID", "sendPredictedResult", "eventToPost", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final void a(com.facebook.e0.z.f.a f$a, String string2, String string3, float[] f4Arr4) {
            a.d(string2, string3, f4Arr4);
        }

        public static final boolean b(com.facebook.e0.z.f.a f$a, String string2, String string3) {
            return a.e(string2, string3);
        }

        private final void d(String string, String string2, float[] f3Arr3) {
            android.content.Context context;
            m obj4;
            if (d.f(string)) {
                obj4 = new m(o.f());
                obj4.e(string, string2);
            } else {
                if (d.e(string)) {
                    f(string, string2, f3Arr3);
                }
            }
        }

        private final boolean e(String string, String string2) {
            int aVar;
            String obj3 = b.d(string);
            final int i = 1;
            if (obj3 != null && z ^= i != 0) {
                i = 1;
                if (z ^= i != 0) {
                    aVar = new f.a.a(obj3, string2);
                    b0.u0(aVar);
                }
                return i;
            }
            return 0;
        }

        private final void f(String string, String string2, float[] f3Arr3) {
            int i;
            String str;
            Bundle bundle = new Bundle();
            bundle.putString("event_name", string);
            JSONObject obj7 = new JSONObject();
            StringBuilder stringBuilder = new StringBuilder();
            final int i3 = 0;
            i = i3;
            while (i < f3Arr3.length) {
                stringBuilder.append(f3Arr3[i]);
                stringBuilder.append(",");
                i++;
            }
            obj7.put("dense", stringBuilder.toString());
            obj7.put("button_text", string2);
            bundle.putString("metadata", obj7.toString());
            f0 obj8 = f0.a;
            int i2 = 1;
            Object[] arr = new Object[i2];
            arr[i3] = o.g();
            obj8 = String.format(Locale.US, "%s/suggested_events", Arrays.copyOf(arr, i2));
            n.e(obj8, "java.lang.String.format(locale, format, *args)");
            int obj9 = 0;
            obj7 = p.t.x(obj9, obj8, obj9, obj9);
            obj7.F(bundle);
            obj7.i();
        }

        public final void c(View view, View view2, String string3) {
            boolean fVar;
            Integer valueOf;
            Object obj4;
            Object obj5;
            n.f(view, "hostView");
            n.f(view2, "rootView");
            n.f(string3, "activityName");
            int i = view.hashCode();
            if (!f.b().contains(Integer.valueOf(i))) {
                fVar = new f(view, view2, string3, 0);
                f.r(view, fVar);
                f.b().add(Integer.valueOf(i));
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final com.facebook.e0.z.f a;
        final JSONObject b;
        final String c;
        final String v;
        b(com.facebook.e0.z.f f, JSONObject jSONObject2, String string3, String string4) {
            this.a = f;
            this.b = jSONObject2;
            this.c = string3;
            this.v = string4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            int i2;
            int i;
            if (a.d(this)) {
            }
            String str2 = b0.t(o.f());
            if (str2 == null) {
            } else {
                String lowerCase = str2.toLowerCase();
                n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                float[] fArr = a.a(this.b, lowerCase);
                if (fArr == null) {
                }
                i = 1;
                final float[][] fArr2 = new float[i];
                final int i3 = 0;
                fArr2[i3] = fArr;
                final String[] strArr2 = new String[i];
                strArr2[i3] = a.c(this.c, f.a(this.a), lowerCase);
                String[] strArr = d.o(d.a.MTML_APP_EVENT_PREDICTION, fArr2, strArr2);
                str = strArr[i3];
                b.a(this.v, str);
                if (strArr != null && z2 ^= i != 0) {
                    str = strArr[i3];
                    b.a(this.v, str);
                    if (z2 ^= i != 0) {
                        try {
                            f.a.a(f.x, str, this.c, fArr);
                            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            throw nullPointerException;
                            a.b(th, this);
                        }
                    }
                }
            }
        }
    }
    static {
        f.a aVar = new f.a(0);
        f.x = aVar;
        HashSet hashSet = new HashSet();
        f.w = hashSet;
    }

    private f(View view, View view2, String string3) {
        super();
        this.a = f.g(view);
        WeakReference weakReference = new WeakReference(view2);
        this.b = weakReference;
        WeakReference obj8 = new WeakReference(view);
        this.c = obj8;
        Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = string3.toLowerCase();
        n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.v = l.G(lowerCase, "activity", "", false, 4, 0);
    }

    public f(View view, View view2, String string3, g g4) {
        super(view, view2, string3);
    }

    public static final String a(com.facebook.e0.z.f f) {
        if (a.d(f.class)) {
            return null;
        }
        return f.v;
    }

    public static final Set b() {
        if (a.d(f.class)) {
            return null;
        }
        return f.w;
    }

    private final void c(String string, String string2, JSONObject jSONObject3) {
        if (a.d(this)) {
        }
        f.b bVar = new f.b(this, jSONObject3, string2, string);
        b0.u0(bVar);
    }

    private final void d() {
        Object str2;
        Object obj;
        String str3;
        String str;
        JSONObject jSONObject;
        String str4;
        if (a.d(this)) {
        }
        str2 = this.b.get();
        obj = this.c.get();
        if ((View)str2 != null) {
            if ((View)obj == null) {
            } else {
                str3 = c.d((View)obj);
                str = b.b(obj, str3);
                if (str != null && f.a.b(f.x, str, str3)) {
                    if (f.a.b(f.x, str, str3)) {
                        try {
                            jSONObject = new JSONObject();
                            jSONObject.put("view", c.b((View)str2, obj));
                            jSONObject.put("screenname", this.v);
                            c(str, str3, jSONObject);
                            a.b(th, this);
                        } catch (Exception e) {
                        } catch (Throwable th1) {
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        if (a.d(this)) {
        }
        n.f(view, "view");
        View.OnClickListener list = this.a;
        if (list != null) {
            list.onClick(view);
        }
        d();
    }
}
