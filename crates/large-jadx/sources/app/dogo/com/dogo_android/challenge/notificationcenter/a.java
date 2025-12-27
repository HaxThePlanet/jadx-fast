package app.dogo.com.dogo_android.d.c;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.e0.b0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ g a;
    public final /* synthetic */ b0 b;
    public /* synthetic */ a(g gVar, b0 b0Var) {
        super();
        this.a = gVar;
        this.b = b0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeNotificationCenterFragmentLegacy.l2(this.a, this.b, view);
    }
}
