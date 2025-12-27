package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.k0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ e a;
    public /* synthetic */ d(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.N(this.a, view);
    }
}
