package app.dogo.com.dogo_android.subscription;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class l implements Runnable {

    public final RecyclerView a;
    public l(RecyclerView recyclerView) {
        super();
        this.a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscriptionBindingAdapters.b(this.a);
    }
}
