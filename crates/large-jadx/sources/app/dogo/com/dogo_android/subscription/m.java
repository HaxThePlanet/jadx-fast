package app.dogo.com.dogo_android.subscription;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import app.dogo.com.dogo_android.h.ei;

/* loaded from: classes.dex */
public final class m implements View.OnScrollChangeListener {

    public final ei a;
    public final View b;
    public m(ei ei, View view2) {
        super();
        this.a = ei;
        this.b = view2;
    }

    @Override // android.view.View$OnScrollChangeListener
    public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
        SubscriptionBindingAdapters.c(this.a, this.b, view, i2, i3, i4, i5);
    }
}
