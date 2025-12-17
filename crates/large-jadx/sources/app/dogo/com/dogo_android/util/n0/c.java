package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final ViewGroup a;
    public c(ViewGroup viewGroup) {
        super();
        this.a = viewGroup;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.w(this.a, view);
    }
}
