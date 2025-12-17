package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.c;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    public final a a;
    public final c b;
    public n(a a, c c2) {
        super();
        this.a = a;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        f1.s(this.a, this.b, view);
    }
}
