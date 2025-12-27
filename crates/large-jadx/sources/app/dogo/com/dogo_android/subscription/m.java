package app.dogo.com.dogo_android.subscription;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import app.dogo.com.dogo_android.h.ei;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m implements View.OnScrollChangeListener {

    public final /* synthetic */ ei a;
    public final /* synthetic */ View b;
    public /* synthetic */ m(ei eiVar, View view) {
        super();
        this.a = eiVar;
        this.b = view;
    }

    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        SubscriptionBindingAdapters.setupTimerDashboard$lambda_8(this.a, this.b, view, i, i2, i3, i4);
    }
}
