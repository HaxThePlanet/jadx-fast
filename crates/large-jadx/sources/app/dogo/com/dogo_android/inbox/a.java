package app.dogo.com.dogo_android.inbox;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ CustomIterableInboxActivity a;
    public /* synthetic */ a(CustomIterableInboxActivity list) {
        super();
        this.a = list;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CustomIterableInboxActivity.j(this.a, view);
    }
}
