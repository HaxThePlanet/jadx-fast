package app.dogo.com.dogo_android.u.n.r;

import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.util.l0.b.a;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.tabs.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bH\u0007¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerBindingAdapters;", "", "()V", "setPottyTrackerOverviewTab", "", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "imageResources", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d {

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerBindingAdapters$setPottyTrackerOverviewTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends ViewPager2.i {

        final List<Integer> a;
        final b b;
        final ViewPager2 c;
        a(List<Integer> list, b b2, ViewPager2 viewPager23) {
            this.a = list;
            this.b = b2;
            this.c = viewPager23;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            int i2;
            int obj2;
            super.onPageScrollStateChanged(i);
            if (i == 0 && this.c.getCurrentItem() > p.i(this.a)) {
                if (this.c.getCurrentItem() > p.i(this.a)) {
                    this.b.p();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int size;
            int i2;
            int obj3;
            super.onPageSelected(i);
            if (i < this.a.size()) {
                i2 = 0;
                b.a.a(this.b, i2, 1, i2);
            }
        }
    }
    static {
    }

    public static void a(TabLayout.g tabLayout$g, int i2) {
        d.c(g, i2);
    }

    public static final void b(ViewPager2 viewPager2, TabLayout tabLayout2, b b3, List<Integer> list4) {
        Object dVar;
        app.dogo.com.dogo_android.u.n.r.a aVar;
        Object obj3;
        n.f(viewPager2, "<this>");
        n.f(tabLayout2, "tabLayout");
        if (b3 != null && list4 != null && viewPager2.getAdapter() == null) {
            if (list4 != null) {
                if (viewPager2.getAdapter() == null) {
                    e eVar = new e(list4, b3);
                    viewPager2.setAdapter(eVar);
                    dVar = new d(tabLayout2, viewPager2, a.a);
                    dVar.a();
                    obj3 = new d.a(list4, b3, viewPager2);
                    viewPager2.h(obj3);
                }
            }
        }
    }

    private static final void c(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }
}
