package app.dogo.com.dogo_android.d.a.n;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ g a;
    public final /* synthetic */ int b;
    public /* synthetic */ c(g gVar, int i) {
        super();
        this.a = gVar;
        this.b = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        EntryFanImagePagerAdapter.x(this.a, this.b, view);
    }
}
