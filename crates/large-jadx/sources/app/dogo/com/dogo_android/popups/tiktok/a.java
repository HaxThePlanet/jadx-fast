package app.dogo.com.dogo_android.p.b;

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
        TiktokInviteDialog.b2(this.a, view);
    }
}
