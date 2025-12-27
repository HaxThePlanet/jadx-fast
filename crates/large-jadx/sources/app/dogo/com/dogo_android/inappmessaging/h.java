package app.dogo.com.dogo_android.inappmessaging;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final /* synthetic */ l a;
    public /* synthetic */ h(l lVar) {
        super();
        this.a = lVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        InAppOneTenFragmentDialog.E1(this.a, view);
    }
}
