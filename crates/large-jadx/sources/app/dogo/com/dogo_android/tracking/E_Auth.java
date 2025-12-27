package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.o;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Auth;", "", "()V", "CancelLogin", "Lapp/dogo/com/dogo_android/tracking/Event0;", "Login", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$CurrentScreen;", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "LoginFailed", "LoginTimeoutError", "Logout", "LogoutClicked", "NameIsTooLongError", "NameIsTooShortError", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class E_Auth {

    public static final v2<f1, o2> a;
    public static final t2 b;
    public static final t2 c;
    public static final t2 d;
    public static final t2 e;
    public static final t2 f;
    public static final t2 g;
    public static final t2 h;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Auth.a = companion2.a("auth_login_success").c(new EP_CurrentScreen(), new EP_Type()).withFacebookEvent(app.dogo.com.dogo_android.tracking.a.a);
        E_Auth.b = companion2.a("auth_login_cancel");
        E_Auth.c = companion2.a("logout_completed");
        E_Auth.d = companion2.a("logout_tapped");
        E_Auth.e = companion2.a("login_timeout_error");
        E_Auth.f = companion2.a("name_too_short_error");
        E_Auth.g = companion2.a("name_too_long_error");
        E_Auth.h = companion2.a("login_failed_error");
    }

    private static final a3 a(o oVar, o oVar2) {
        String oVar22;
        Object obj = oVar2.d();
        oVar22 = "";
        if (obj != null) {
            oVar22 = obj.toString();
            if (oVar22 != null) {
            }
        }
        return FBEvent.INSTANCE.completedRegistration(oVar22);
    }

    public static /* synthetic */ a3 b(o oVar, o oVar2) {
        return E_Auth.a(oVar, oVar2);
    }
}
