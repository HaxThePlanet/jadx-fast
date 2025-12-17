package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.c;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class p implements View.OnClickListener {

    public final a a;
    public final c b;
    public p(a a, c c2) {
        super();
        this.a = a;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        f1.u(this.a, this.b, view);
    }
}
