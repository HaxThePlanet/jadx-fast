package app.dogo.com.dogo_android.inappmessaging;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    public final app.dogo.com.dogo_android.inappmessaging.l a;
    public g(app.dogo.com.dogo_android.inappmessaging.l l) {
        super();
        this.a = l;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.C1(this.a, view);
    }
}
