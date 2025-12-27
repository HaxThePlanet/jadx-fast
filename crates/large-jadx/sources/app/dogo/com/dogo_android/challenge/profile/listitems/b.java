package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.e2;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ e.a a;
    public final /* synthetic */ e2 b;
    public /* synthetic */ b(e.a aVar, e2 e2Var) {
        super();
        this.a = aVar;
        this.b = e2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeProfileItem_ViewHolder.n(this.a, this.b, view);
    }
}
