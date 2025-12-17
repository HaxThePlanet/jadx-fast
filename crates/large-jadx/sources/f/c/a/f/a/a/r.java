package f.c.a.f.a.a;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class r extends f.c.a.f.a.a.q<f.c.a.f.a.a.a> {

    private final String d;
    final f.c.a.f.a.a.s e;
    r(f.c.a.f.a.a.s s, o o2, String string3) {
        this.e = s;
        h hVar = new h("OnRequestInstallCallback");
        super(s, hVar, o2);
        this.d = string3;
    }

    @Override // f.c.a.f.a.a.q
    public final void h(Bundle bundle) {
        super.h(bundle);
        if (s.a(bundle) != 0) {
            InstallException installException = new InstallException(s.a(bundle));
            this.b.d(installException);
        }
        this.b.e(s.c(this.e, bundle, this.d));
    }
}
