package f.c.a.f.a.a;

import android.os.Bundle;
import com.google.android.play.core.internal.e2;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
class q<T>  extends e2 {

    final h a;
    final o<T> b;
    final f.c.a.f.a.a.s c;
    q(f.c.a.f.a.a.s s, h h2, o o3) {
        this.c = s;
        super();
        this.a = h2;
        this.b = o3;
    }

    @Override // com.google.android.play.core.internal.e2
    public void h(Bundle bundle) {
        obj3.a.s(this.b);
        this.a.d("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.e2
    public void k(Bundle bundle) {
        obj3.a.s(this.b);
        this.a.d("onCompleteUpdate", new Object[0]);
    }
}
