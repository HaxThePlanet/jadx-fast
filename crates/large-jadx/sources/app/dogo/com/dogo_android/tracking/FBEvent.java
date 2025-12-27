package app.dogo.com.dogo_android.w;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* compiled from: FBEvent.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/tracking/FBEvent;", "", "name", "", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "getName", "()Ljava/lang/String;", "getParameters", "()Landroid/os/Bundle;", "getValueToSum", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)Lapp/dogo/com/dogo_android/tracking/FBEvent;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a3, reason: from kotlin metadata */
public final /* data */ class FBEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final a3.a INSTANCE = new a3$a(0);
    private static final a3 d;
    private static final a3 e;
    private static final a3 f;
    private static final a3 g;
    private static final List<String> h;
    /* renamed from: a, reason: from kotlin metadata */
    private final String name;
    private final Double b;
    private final Bundle c;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0006\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\u0008\u0010\u0013\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0006¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/tracking/FBEvent$Companion;", "", "()V", "completedTutorial", "Lapp/dogo/com/dogo_android/tracking/FBEvent;", "getCompletedTutorial", "()Lapp/dogo/com/dogo_android/tracking/FBEvent;", "contact", "getContact", "customizeProduct", "getCustomizeProduct", "screensToTrack", "", "", "submitApplication", "getSubmitApplication", "achievedLevel", "lessonId", "completedRegistration", "registrationMethod", "initiatedCheckout", "valueToSum", "", "currency", "viewSource", "rated", "id", "ratingValue", "", "shouldTrackContentView", "", "screen", "Lapp/dogo/com/dogo_android/tracking/Screen;", "viewedContent", "contentParameters", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final a3 achievedLevel(String lessonId) {
            n.f(lessonId, "lessonId");
            final Bundle bundle = new Bundle();
            bundle.putString("fb_description", lessonId);
            FBEvent lessonId2 = new FBEvent("fb_mobile_level_achieved", null, bundle, 2, null);
            return lessonId2;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final a3 completedRegistration(String registrationMethod) {
            String str;
            final Bundle bundle = new Bundle();
            if (registrationMethod == null) {
                str = "";
            }
            bundle.putString("fb_registration_method", str);
            FBEvent registrationMethod2 = new FBEvent("fb_mobile_complete_registration", null, bundle, 2, null);
            return registrationMethod2;
        }

        public final a3 c() {
            return FBEvent.e;
        }

        public final a3 d() {
            return FBEvent.f;
        }

        public final a3 e() {
            return FBEvent.g;
        }

        public final a3 f() {
            return FBEvent.d;
        }

        /* renamed from: g, reason: from kotlin metadata */
        public final a3 initiatedCheckout(double valueToSum, String currency, String viewSource) {
            n.f(currency, "currency");
            n.f(viewSource, "viewSource");
            final Bundle bundle = new Bundle();
            bundle.putString("fb_currency", currency);
            bundle.putString("fb_content_id", viewSource);
            return new FBEvent("fb_mobile_initiated_checkout", Double.valueOf(valueToSum), bundle);
        }

        /* renamed from: h, reason: from kotlin metadata */
        public final a3 rated(String id, int ratingValue) {
            n.f(id, "id");
            final Bundle bundle = new Bundle();
            bundle.putString("fb_content_id", id);
            bundle.putInt("fb_max_rating_value", ratingValue);
            FBEvent id2 = new FBEvent("fb_mobile_level_achieved", null, bundle, 2, null);
            return id2;
        }

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean shouldTrackContentView(k3 screen) {
            n.f(screen, "screen");
            return FBEvent.h.contains(screen.a());
        }

        /* renamed from: j, reason: from kotlin metadata */
        public final a3 viewedContent(String contentParameters) {
            n.f(contentParameters, "contentParameters");
            final Bundle bundle = new Bundle();
            bundle.putString("fb_content_id", contentParameters);
            FBEvent contentParameters2 = new FBEvent("fb_mobile_content_view", null, bundle, 2, null);
            return contentParameters2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    static {
        final Double d = null;
        FBEvent fBEvent = new FBEvent("SubmitApplication", d, null, 6, null);
        FBEvent.d = fBEvent;
        final Double d2 = null;
        FBEvent fBEvent2 = new FBEvent("fb_mobile_tutorial_completion", d2, null, 6, null);
        FBEvent.e = fBEvent2;
        FBEvent fBEvent3 = new FBEvent("Contact", null, d, 6, null);
        FBEvent.f = fBEvent3;
        FBEvent fBEvent4 = new FBEvent("CustomizeProduct", null, d2, 6, null);
        FBEvent.g = fBEvent4;
        String[] strArr = new String[2];
        FBEvent.h = p.j(new String[] { S.T0.a(), S.u.a() });
    }

    public a3(String str, Double double, Bundle bundle) {
        n.f(str, "name");
        super();
        this.name = str;
        this.b = double;
        this.c = bundle;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public static final /* synthetic */ a3 component1() {
        return FBEvent.e;
    }

    public static final /* synthetic */ a3 b() {
        return FBEvent.f;
    }

    public static final /* synthetic */ a3 c() {
        return FBEvent.g;
    }

    public static final /* synthetic */ List d() {
        return FBEvent.h;
    }

    public static final /* synthetic */ a3 e() {
        return FBEvent.d;
    }

    public final String f() {
        return this.name;
    }

    public final Bundle g() {
        return this.c;
    }

    public final Double h() {
        return this.b;
    }

    public /* synthetic */ a3(String str, Double double, Bundle bundle, int i, g gVar) {
        Double d;
        i = 0;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(str, d, bundle);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof FBEvent)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        return !n.b(this.c, other.c) ? z5 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.b == null) {
        } else {
            i = this.b.hashCode();
        }
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return (this.name.hashCode() * 31) + i * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "FBEvent(name=";
        String str3 = ", valueToSum=";
        String str4 = ", parameters=";
        str = str2 + this.name + str3 + this.b + str4 + this.c + 41;
        return str;
    }
}
