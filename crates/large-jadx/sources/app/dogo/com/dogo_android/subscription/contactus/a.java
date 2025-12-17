package app.dogo.com.dogo_android.subscription.contactus;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment a;
    public a(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment) {
        super();
        this.a = unlockHelplineFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UnlockHelplineFragment.B1(this.a, view);
    }
}
