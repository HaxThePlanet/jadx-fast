package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.d.d.q;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ e.a a;
    public final /* synthetic */ q b;
    public /* synthetic */ d(e.a aVar, q qVar) {
        super();
        this.a = aVar;
        this.b = qVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeProfileItem_ViewHolder.l(this.a, this.b, view);
    }
}
