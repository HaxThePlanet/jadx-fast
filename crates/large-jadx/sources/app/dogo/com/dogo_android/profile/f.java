package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final /* synthetic */ v a;
    public /* synthetic */ f(v vVar) {
        super();
        this.a = vVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.I(this.a, view);
    }
}
