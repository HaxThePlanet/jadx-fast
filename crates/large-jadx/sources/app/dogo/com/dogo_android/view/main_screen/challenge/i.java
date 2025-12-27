package app.dogo.com.dogo_android.view.main_screen.j;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements f {

    public final /* synthetic */ a0 a;
    public /* synthetic */ i(a0 a0Var) {
        super();
        this.a = a0Var;
    }

    public final void onFailure(Exception exc) {
        ChallengeEntryCreationDialog.g2(this.a, exc);
    }
}
