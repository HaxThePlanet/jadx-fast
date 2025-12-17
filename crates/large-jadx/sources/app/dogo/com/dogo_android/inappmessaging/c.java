package app.dogo.com.dogo_android.inappmessaging;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.inappmessaging.i a;
    public c(app.dogo.com.dogo_android.inappmessaging.i i) {
        super();
        this.a = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.H1(this.a, view);
    }
}
