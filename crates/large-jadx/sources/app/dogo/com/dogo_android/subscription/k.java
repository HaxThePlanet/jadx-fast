package app.dogo.com.dogo_android.subscription;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2.k;

/* loaded from: classes.dex */
public final class k implements ViewPager2.k {

    public final int a;
    public final int b;
    public k(int i, int i2) {
        super();
        this.a = i;
        this.b = i2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$k
    public final void a(View view, float f2) {
        SubscriptionBindingAdapters.a(this.a, this.b, view, f2);
    }
}
