package app.dogo.com.dogo_android.e;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ k a;
    public final /* synthetic */ k.c b;
    public /* synthetic */ d(k kVar, k.c cVar) {
        super();
        this.a = kVar;
        this.b = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ClickerSelectAdapter_Holder.a(this.a, this.b, view);
    }
}
