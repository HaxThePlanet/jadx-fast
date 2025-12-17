package app.dogo.com.dogo_android.view.main_screen.j;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.f;

/* loaded from: classes.dex */
public final class i implements f {

    public final a0 a;
    public i(a0 a0) {
        super();
        this.a = a0;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        i0.c2(this.a, exception);
    }
}
