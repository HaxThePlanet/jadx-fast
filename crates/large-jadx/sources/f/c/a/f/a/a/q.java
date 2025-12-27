package f.c.a.f.a.a;

import android.os.Bundle;
import com.google.android.play.core.internal.e2;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
class q<T> extends e2 {

    final h a;
    final o<T> b;
    final /* synthetic */ s c;
    q(s sVar, h hVar, o oVar) {
        this.c = sVar;
        super();
        this.a = hVar;
        this.b = oVar;
    }

    @Override // com.google.android.play.core.internal.e2
    public void h(Bundle bundle) {
        this.c.a.s(this.b);
        this.a.d("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.e2
    public void k(Bundle bundle) {
        this.c.a.s(this.b);
        this.a.d("onCompleteUpdate", new Object[0]);
    }
}
