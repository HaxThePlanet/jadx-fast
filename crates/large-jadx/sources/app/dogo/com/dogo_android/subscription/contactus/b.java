package app.dogo.com.dogo_android.subscription.contactus;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment a;
    public b(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment) {
        super();
        this.a = unlockHelplineFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UnlockHelplineFragment.C1(this.a, view);
    }
}
