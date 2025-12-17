package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.o;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Auth;", "", "()V", "CancelLogin", "Lapp/dogo/com/dogo_android/tracking/Event0;", "Login", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$CurrentScreen;", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "LoginFailed", "LoginTimeoutError", "Logout", "LogoutClicked", "NameIsTooLongError", "NameIsTooShortError", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p {

    public static final app.dogo.com.dogo_android.w.v2<app.dogo.com.dogo_android.w.f1, app.dogo.com.dogo_android.w.o2> a;
    public static final app.dogo.com.dogo_android.w.t2 b;
    public static final app.dogo.com.dogo_android.w.t2 c;
    public static final app.dogo.com.dogo_android.w.t2 d;
    public static final app.dogo.com.dogo_android.w.t2 e;
    public static final app.dogo.com.dogo_android.w.t2 f;
    public static final app.dogo.com.dogo_android.w.t2 g;
    public static final app.dogo.com.dogo_android.w.t2 h;
    static {
        app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        f1 f1Var = new f1();
        o2 o2Var = new o2();
        p.a = companion.a("auth_login_success").c(f1Var, o2Var).b(a.a);
        p.b = companion.a("auth_login_cancel");
        p.c = companion.a("logout_completed");
        p.d = companion.a("logout_tapped");
        p.e = companion.a("login_timeout_error");
        p.f = companion.a("name_too_short_error");
        p.g = companion.a("name_too_long_error");
        p.h = companion.a("login_failed_error");
    }

    private static final app.dogo.com.dogo_android.w.a3 a(o o, o o2) {
        String str;
        Object obj2;
        obj2 = o2.d();
        str = "";
        if (obj2 == null) {
        } else {
            obj2 = obj2.toString();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        return a3.Companion.b(str);
    }

    public static app.dogo.com.dogo_android.w.a3 b(o o, o o2) {
        return p.a(o, o2);
    }
}
