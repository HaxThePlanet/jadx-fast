package app.dogo.com.dogo_android.d.e;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ c a;
    public /* synthetic */ a(c cVar) {
        super();
        this.a = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeReportDialog.I1(this.a, view);
    }
}
