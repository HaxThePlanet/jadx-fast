package app.dogo.com.dogo_android.d.f;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ e a;
    public /* synthetic */ d(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeShareDialog.d2(this.a, view);
    }
}
