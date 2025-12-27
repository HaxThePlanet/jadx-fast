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

/* compiled from: PottyTrackerBindingAdapters.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bH\u0007¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerBindingAdapters;", "", "()V", "setPottyTrackerOverviewTab", "", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "imageResources", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class PottyTrackerBindingAdapters {

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerBindingAdapters$setPottyTrackerOverviewTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends ViewPager2.i {

        final /* synthetic */ List<Integer> a;
        final /* synthetic */ b b;
        final /* synthetic */ ViewPager2 c;
        a(List<Integer> list, b bVar, ViewPager2 viewPager2) {
            this.a = list;
            this.b = bVar;
            this.c = viewPager2;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                if (this.c.getCurrentItem() > p.i(this.a)) {
                    this.b.p();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position < this.a.size()) {
                int size = 1;
                app.dogo.com.dogo_android.w.i3 i3Var = null;
                app.dogo.com.dogo_android.util.listeners.b.a.a(this.b, i3Var, size, i3Var);
            }
        }
    }
    public static final void b(ViewPager2 viewPager2, TabLayout tabLayout, b bVar, List<Integer> list) {
        n.f(viewPager2, "<this>");
        str = "tabLayout";
        n.f(tabLayout, str);
        if (bVar != null && list != null && viewPager2.getAdapter() == null) {
            viewPager2.setAdapter(new PottyTrackerOverviewAdapter(list, bVar));
            new d(tabLayout, viewPager2, app.dogo.com.dogo_android.specialprograms.potty.tracker.a.a).a();
            viewPager2.h(new PottyTrackerBindingAdapters_setPottyTrackerOverviewTab_1(list, bVar, viewPager2));
        }
    }


    public static /* synthetic */ void a(TabLayout.g gVar, int i) {
        PottyTrackerBindingAdapters.c(gVar, i);
    }

    private static final void c(TabLayout.g gVar, int i) {
        n.f(gVar, "$noName_0");
    }
}
