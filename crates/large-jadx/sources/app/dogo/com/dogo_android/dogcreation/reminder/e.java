package app.dogo.com.dogo_android.dogcreation.n;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ h a;
    public /* synthetic */ e(h hVar) {
        super();
        this.a = hVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationReminderFragment.O1(this.a, view);
    }
}
