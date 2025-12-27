package app.dogo.com.dogo_android.subscription;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements Runnable {

    public final /* synthetic */ RecyclerView a;
    public /* synthetic */ l(RecyclerView recyclerView) {
        super();
        this.a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscriptionBindingAdapters.setBenefitListAdapter$lambda_0(this.a);
    }
}
