package f.c.a.f.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.play.core.common.b;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.d2;
import com.google.android.play.core.internal.e1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class s {

    private static final h e = new h("AppUpdateService");
    private static final Intent f;
    t<d2> a;
    private final String b;
    private final Context c;
    private final u d;
    static {
        s.f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    }

    s(Context context, u uVar) {
        super();
        this.b = context.getPackageName();
        this.c = context;
        this.d = uVar;
        if (h1.b(context)) {
            com.google.android.play.core.internal.n nVar = null;
            str = "AppUpdateService";
            super(e1.a(context), s.e, str, s.f, o.a, nVar);
            this.a = uVar22;
        }
    }

    private static Bundle g() {
        final Bundle bundle = new Bundle();
        bundle.putAll(b.a("app_update"));
        bundle.putInt("playcore.version.code", 11002);
        return bundle;
    }

    private static <T> d<T> h() {
        Object[] arr = new Object[1];
        final int i2 = -9;
        s.e.b("onError(%d)", Integer.valueOf(i2));
        return f.b(new InstallException(i2));
    }

    public final d<a> e(String str) {
        if (this.a == null) {
            return s.h();
        }
        Object[] arr = new Object[1];
        s.e.d("requestUpdateInfo(%s)", str);
        o oVar = new o();
        this.a.q(new p(this, oVar, str, oVar), oVar);
        return oVar.a();
    }
}
