package app.dogo.com.dogo_android.w;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/tracking/FBEvent;", "", "name", "", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "getName", "()Ljava/lang/String;", "getParameters", "()Landroid/os/Bundle;", "getValueToSum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)Lapp/dogo/com/dogo_android/tracking/FBEvent;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a3 {

    public static final app.dogo.com.dogo_android.w.a3.a Companion;
    private static final app.dogo.com.dogo_android.w.a3 d;
    private static final app.dogo.com.dogo_android.w.a3 e;
    private static final app.dogo.com.dogo_android.w.a3 f;
    private static final app.dogo.com.dogo_android.w.a3 g;
    private static final List<String> h;
    private final String a;
    private final Double b;
    private final Bundle c;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0006\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\u0008\u0010\u0013\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0006¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/tracking/FBEvent$Companion;", "", "()V", "completedTutorial", "Lapp/dogo/com/dogo_android/tracking/FBEvent;", "getCompletedTutorial", "()Lapp/dogo/com/dogo_android/tracking/FBEvent;", "contact", "getContact", "customizeProduct", "getCustomizeProduct", "screensToTrack", "", "", "submitApplication", "getSubmitApplication", "achievedLevel", "lessonId", "completedRegistration", "registrationMethod", "initiatedCheckout", "valueToSum", "", "currency", "viewSource", "rated", "id", "ratingValue", "", "shouldTrackContentView", "", "screen", "Lapp/dogo/com/dogo_android/tracking/Screen;", "viewedContent", "contentParameters", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.w.a3 a(String string) {
            n.f(string, "lessonId");
            Bundle bundle = new Bundle();
            bundle.putString("fb_description", string);
            w obj8 = w.a;
            super("fb_mobile_level_achieved", 0, bundle, 2, 0);
            return obj8;
        }

        public final app.dogo.com.dogo_android.w.a3 b(String string) {
            String obj7;
            Bundle bundle = new Bundle();
            if (string == null) {
                obj7 = "";
            }
            bundle.putString("fb_registration_method", obj7);
            obj7 = w.a;
            super("fb_mobile_complete_registration", 0, bundle, 2, 0);
            return obj7;
        }

        public final app.dogo.com.dogo_android.w.a3 c() {
            return a3.a();
        }

        public final app.dogo.com.dogo_android.w.a3 d() {
            return a3.b();
        }

        public final app.dogo.com.dogo_android.w.a3 e() {
            return a3.c();
        }

        public final app.dogo.com.dogo_android.w.a3 f() {
            return a3.e();
        }

        public final app.dogo.com.dogo_android.w.a3 g(double d, String string2, String string3) {
            n.f(string3, "currency");
            n.f(obj5, "viewSource");
            Bundle obj3 = new Bundle();
            obj3.putString("fb_currency", string3);
            obj3.putString("fb_content_id", obj5);
            w obj4 = w.a;
            obj4 = new a3("fb_mobile_initiated_checkout", Double.valueOf(d), obj3);
            return obj4;
        }

        public final app.dogo.com.dogo_android.w.a3 h(String string, int i2) {
            n.f(string, "id");
            Bundle bundle = new Bundle();
            bundle.putString("fb_content_id", string);
            bundle.putInt("fb_max_rating_value", i2);
            w obj8 = w.a;
            super("fb_mobile_level_achieved", 0, bundle, 2, 0);
            return obj8;
        }

        public final boolean i(app.dogo.com.dogo_android.w.k3 k3) {
            n.f(k3, "screen");
            return a3.d().contains(k3.a());
        }

        public final app.dogo.com.dogo_android.w.a3 j(String string) {
            n.f(string, "contentParameters");
            Bundle bundle = new Bundle();
            bundle.putString("fb_content_id", string);
            w obj8 = w.a;
            super("fb_mobile_content_view", 0, bundle, 2, 0);
            return obj8;
        }
    }
    static {
        a3.a aVar = new a3.a(0);
        a3.Companion = aVar;
        final int i6 = 0;
        super("SubmitApplication", i6, 0, 6, 0);
        a3.d = a3Var;
        final int i13 = 0;
        super("fb_mobile_tutorial_completion", i13, 0, 6, 0);
        a3.e = a3Var2;
        super("Contact", 0, i6, 6, 0);
        a3.f = a3Var3;
        super("CustomizeProduct", 0, i13, 6, 0);
        a3.g = a3Var4;
        String[] strArr = new String[2];
        a3.h = p.j(j3.T0.a(), j3.u.a());
    }

    public a3(String string, Double double2, Bundle bundle3) {
        n.f(string, "name");
        super();
        this.a = string;
        this.b = double2;
        this.c = bundle3;
    }

    public a3(String string, Double double2, Bundle bundle3, int i4, g g5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(string, obj3, obj4);
    }

    public static final app.dogo.com.dogo_android.w.a3 a() {
        return a3.e;
    }

    public static final app.dogo.com.dogo_android.w.a3 b() {
        return a3.f;
    }

    public static final app.dogo.com.dogo_android.w.a3 c() {
        return a3.g;
    }

    public static final List d() {
        return a3.h;
    }

    public static final app.dogo.com.dogo_android.w.a3 e() {
        return a3.d;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof a3) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        return i;
    }

    public final String f() {
        return this.a;
    }

    public final Bundle g() {
        return this.c;
    }

    public final Double h() {
        return this.b;
    }

    public int hashCode() {
        int i;
        int i2;
        Double num = this.b;
        if (num == null) {
            i = i2;
        } else {
            i = num.hashCode();
        }
        Bundle bundle = this.c;
        if (bundle == null) {
        } else {
            i2 = bundle.hashCode();
        }
        return i6 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FBEvent(name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", valueToSum=");
        stringBuilder.append(this.b);
        stringBuilder.append(", parameters=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
