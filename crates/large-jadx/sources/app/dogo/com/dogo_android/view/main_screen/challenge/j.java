package app.dogo.com.dogo_android.view.main_screen.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    public final /* synthetic */ i0 a;
    public /* synthetic */ j(i0 i0Var) {
        super();
        this.a = i0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeEntryCreationDialog.e2(this.a, view);
    }
}
