package app.dogo.com.dogo_android.inappmessaging;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ i a;
    public /* synthetic */ c(i iVar) {
        super();
        this.a = iVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        InAppFeedbackFragmentDialog.K1(this.a, view);
    }
}
