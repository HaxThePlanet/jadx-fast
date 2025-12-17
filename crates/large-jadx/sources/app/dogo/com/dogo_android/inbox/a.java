package app.dogo.com.dogo_android.inbox;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.inbox.CustomIterableInboxActivity a;
    public a(app.dogo.com.dogo_android.inbox.CustomIterableInboxActivity customIterableInboxActivity) {
        super();
        this.a = customIterableInboxActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CustomIterableInboxActivity.i(this.a, view);
    }
}
