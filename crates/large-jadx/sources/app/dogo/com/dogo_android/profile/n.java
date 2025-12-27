package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.k0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    public final /* synthetic */ e a;
    public /* synthetic */ n(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.M(this.a, view);
    }
}
