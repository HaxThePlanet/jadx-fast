package app.dogo.com.dogo_android.view.main_screen.j;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class h implements e {

    public final a0 a;
    public final app.dogo.com.dogo_android.view.main_screen.j.i0 b;
    public h(a0 a0, app.dogo.com.dogo_android.view.main_screen.j.i0 i02) {
        super();
        this.a = a0;
        this.b = i02;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        i0.b2(this.a, this.b, j);
    }
}
