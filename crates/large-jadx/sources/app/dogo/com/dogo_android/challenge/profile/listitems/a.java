package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.d.d.q;
import app.dogo.com.dogo_android.h.e2;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ e.a a;
    public final /* synthetic */ q b;
    public final /* synthetic */ e2 c;
    public /* synthetic */ a(e.a aVar, q qVar, e2 e2Var) {
        super();
        this.a = aVar;
        this.b = qVar;
        this.c = e2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeProfileItem_ViewHolder.k(this.a, this.b, this.c, view);
    }
}
