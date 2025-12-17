package app.dogo.com.dogo_android.welcome_v2;

import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements Runnable {

    public final ViewPager2 a;
    public final List b;
    public g(ViewPager2 viewPager2, List list2) {
        super();
        this.a = viewPager2;
        this.b = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0.b(this.a, this.b);
    }
}
