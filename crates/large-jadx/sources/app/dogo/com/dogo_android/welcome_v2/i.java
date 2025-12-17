package app.dogo.com.dogo_android.welcome_v2;

import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements Runnable {

    public final Integer a;
    public final ViewPager2 b;
    public final List c;
    public final ImageView v;
    public final int w;
    public final ImageView x;
    public i(Integer integer, ViewPager2 viewPager22, List list3, ImageView imageView4, int i5, ImageView imageView6) {
        super();
        this.a = integer;
        this.b = viewPager22;
        this.c = list3;
        this.v = imageView4;
        this.w = i5;
        this.x = imageView6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0.b.a(this.a, this.b, this.c, this.v, this.w, this.x);
    }
}
