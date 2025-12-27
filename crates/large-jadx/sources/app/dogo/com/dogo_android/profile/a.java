package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.q.f.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ f.a a;
    public final /* synthetic */ boolean b;
    public /* synthetic */ a(f.a aVar, boolean z) {
        super();
        this.a = aVar;
        this.b = z;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.E(this.a, this.b, view);
    }
}
