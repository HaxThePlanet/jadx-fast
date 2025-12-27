package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.util.e0.y.c;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ j a;
    public final /* synthetic */ y.c b;
    public /* synthetic */ e(j jVar, y.c cVar) {
        super();
        this.a = jVar;
        this.b = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ProgramBindingAdapters.N0(this.a, this.b, view);
    }
}
