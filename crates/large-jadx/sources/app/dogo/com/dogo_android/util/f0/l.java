package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnLongClickListener;

/* loaded from: classes.dex */
public final class l implements View.OnLongClickListener {

    public static final app.dogo.com.dogo_android.util.f0.l a;
    static {
        l lVar = new l();
        l.a = lVar;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        return n.v(view);
    }
}
