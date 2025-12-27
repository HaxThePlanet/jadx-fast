package app.dogo.com.dogo_android.t.h0;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ i a;
    public final /* synthetic */ i.b b;
    public /* synthetic */ a(i iVar, i.b bVar) {
        super();
        this.a = iVar;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LanguageSelectAdapter_Holder.a(this.a, this.b, view);
    }
}
