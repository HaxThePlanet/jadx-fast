package app.dogo.com.dogo_android.view.main_screen.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ h0 a;
    public /* synthetic */ c(h0 h0Var) {
        super();
        this.a = h0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeDetailsDialog.f2(this.a, view);
    }
}
