package f.c.a.f.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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

/* loaded from: classes2.dex */
final class s {

    private static final h e;
    private static final Intent f;
    t<d2> a;
    private final String b;
    private final Context c;
    private final f.c.a.f.a.a.u d;
    static {
        h hVar = new h("AppUpdateService");
        s.e = hVar;
        Intent intent = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE");
        s.f = intent.setPackage("com.android.vending");
    }

    s(Context context, f.c.a.f.a.a.u u2) {
        Object packageName;
        Context context2;
        h hVar;
        String str;
        Intent intent;
        f.c.a.f.a.a.o oVar;
        int i;
        boolean obj9;
        super();
        this.b = context.getPackageName();
        this.c = context;
        this.d = u2;
        if (h1.b(context)) {
            super(e1.a(context), s.e, "AppUpdateService", s.f, o.a, 0);
            this.a = obj9;
        }
    }

    static int a(Bundle bundle) {
        return bundle.getInt("error.code", -2);
    }

    static Bundle b(f.c.a.f.a.a.s s, String string2) {
        String packageName;
        Integer obj2;
        int obj3;
        Bundle bundle = new Bundle();
        bundle.putAll(s.g());
        bundle.putString("package.name", string2);
        obj2 = Integer.valueOf(obj2.versionCode);
        if (obj2 != null) {
            bundle.putInt("app.version.code", obj2.intValue());
        }
        return bundle;
    }

    static f.c.a.f.a.a.a c(f.c.a.f.a.a.s s, Bundle bundle2, String string3) {
        int valueOf;
        Object obj = bundle2;
        final int i = -1;
        int i2 = 0;
        String str4 = "client.version.staleness";
        if (obj.getInt(str4, i) == i) {
            valueOf = 0;
        } else {
            valueOf = Integer.valueOf(obj.getInt(str4));
        }
        return a.e(string3, obj.getInt("version.code", i), obj.getInt("update.availability"), obj.getInt("install.status", i2), valueOf, obj.getInt("in.app.update.priority", i2), obj.getLong("bytes.downloaded"), obj10, obj.getLong("total.bytes.to.download"), obj12, obj.getLong("additional.size.required"), obj14, obj2.d.a(), obj16);
    }

    static h d() {
        return s.e;
    }

    static String f(f.c.a.f.a.a.s s) {
        return s.b;
    }

    private static Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putAll(b.a("app_update"));
        bundle.putInt("playcore.version.code", 11002);
        return bundle;
    }

    private static <T> d<T> h() {
        Object[] arr = new Object[1];
        final int i2 = -9;
        s.e.b("onError(%d)", Integer.valueOf(i2));
        InstallException installException = new InstallException(i2);
        return f.b(installException);
    }

    public final d<f.c.a.f.a.a.a> e(String string) {
        if (this.a == null) {
            return s.h();
        }
        Object[] arr = new Object[1];
        s.e.d("requestUpdateInfo(%s)", string);
        o oVar = new o();
        p pVar = new p(this, oVar, string, oVar);
        this.a.q(pVar, oVar);
        return oVar.a();
    }
}
