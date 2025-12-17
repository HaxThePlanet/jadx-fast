package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.p;
import java.util.Locale;

/* loaded from: classes.dex */
final class d extends androidx.viewpager2.widget.ViewPager2.i {

    private final LinearLayoutManager a;
    private androidx.viewpager2.widget.ViewPager2.k b;
    d(LinearLayoutManager linearLayoutManager) {
        super();
        this.a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    androidx.viewpager2.widget.ViewPager2.k a() {
        return this.b;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    void b(androidx.viewpager2.widget.ViewPager2.k viewPager2$k) {
        this.b = k;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageScrolled(int i, float f2, int i3) {
        int i4;
        android.view.View view;
        int i2;
        androidx.viewpager2.widget.ViewPager2.k view2;
        if (this.b == null) {
        }
        int obj7 = 0;
        i4 = obj7;
        while (i4 < this.a.g0()) {
            view = this.a.f0(i4);
            this.b.a(view, f += obj6);
            i4++;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageSelected(int i) {
    }
}
