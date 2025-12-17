package app.dogo.com.dogo_android.view.main_screen.j;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class z implements e {

    public final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
    public z(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        super();
        this.a = k0;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        k0.D2(this.a, j);
    }
}
