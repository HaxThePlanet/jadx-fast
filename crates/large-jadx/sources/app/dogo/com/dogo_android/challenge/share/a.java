package app.dogo.com.dogo_android.d.f;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ e a;
    public /* synthetic */ a(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeShareDialog.e2(this.a, view);
    }
}
