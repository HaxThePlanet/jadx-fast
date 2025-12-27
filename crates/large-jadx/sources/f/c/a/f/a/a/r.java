package f.c.a.f.a.a;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.o;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class r extends q<a> {

    private final String d;
    final /* synthetic */ s e;
    r(s sVar, o oVar, String str) {
        this.e = sVar;
        super(sVar, new h("OnRequestInstallCallback"), oVar);
        this.d = str;
    }

    @Override // f.c.a.f.a.a.q
    public final void h(Bundle bundle) {
        super.h(bundle);
        if (s.a(bundle) != 0) {
            this.b.d(new InstallException(s.a(bundle)));
            return;
        }
        this.b.e(s.c(this.e, bundle, this.d));
    }
}
