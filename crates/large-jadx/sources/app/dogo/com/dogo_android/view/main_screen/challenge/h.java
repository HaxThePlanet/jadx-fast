package app.dogo.com.dogo_android.view.main_screen.j;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements e {

    public final /* synthetic */ a0 a;
    public final /* synthetic */ i0 b;
    public /* synthetic */ h(a0 a0Var, i0 i0Var) {
        super();
        this.a = a0Var;
        this.b = i0Var;
    }

    public final void onComplete(j jVar) {
        ChallengeEntryCreationDialog.h2(this.a, this.b, jVar);
    }
}
