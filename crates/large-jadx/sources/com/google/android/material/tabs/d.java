package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class d {

    private final com.google.android.material.tabs.TabLayout a;
    private final ViewPager2 b;
    private final boolean c;
    private final boolean d;
    private final com.google.android.material.tabs.d.b e;
    private RecyclerView.h<?> f;
    private boolean g;
    private com.google.android.material.tabs.d.c h;
    private com.google.android.material.tabs.TabLayout.d i;
    private RecyclerView.j j;

    public interface b {
        public abstract void a(com.google.android.material.tabs.TabLayout.g tabLayout$g, int i2);
    }

    private class a extends RecyclerView.j {

        final com.google.android.material.tabs.d a;
        a(com.google.android.material.tabs.d d) {
            this.a = d;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onChanged() {
            this.a.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeChanged(int i, int i2) {
            this.a.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeChanged(int i, int i2, Object object3) {
            this.a.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeInserted(int i, int i2) {
            this.a.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeMoved(int i, int i2, int i3) {
            this.a.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeRemoved(int i, int i2) {
            this.a.b();
        }
    }

    private static class c extends ViewPager2.i {

        private final WeakReference<com.google.android.material.tabs.TabLayout> a;
        private int b;
        private int c;
        c(com.google.android.material.tabs.TabLayout tabLayout) {
            super();
            WeakReference weakReference = new WeakReference(tabLayout);
            this.a = weakReference;
            a();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        void a() {
            final int i = 0;
            this.c = i;
            this.b = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrolled(int i, float f2, int i3) {
            int i6;
            int i5;
            int i2;
            int i4;
            int i7;
            Object obj8 = this.a.get();
            if ((TabLayout)obj8 != null) {
                i6 = this.c;
                i2 = 2;
                i4 = 1;
                if (i6 == i2) {
                    if (this.b == i4) {
                        i7 = i4;
                    } else {
                        i7 = i5;
                    }
                } else {
                }
                if (i6 == i2) {
                    if (this.b != 0) {
                        i5 = i4;
                    }
                } else {
                }
                (TabLayout)obj8.J(i, f2, i7, i5);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int selectedTabPosition;
            int i2;
            int i3;
            int obj4;
            Object obj = this.a.get();
            if (obj != null && (TabLayout)obj.getSelectedTabPosition() != i && i < obj.getTabCount()) {
                if (obj.getSelectedTabPosition() != i) {
                    if (i < obj.getTabCount()) {
                        i2 = this.c;
                        if (i2 != 0) {
                            if (i2 == 2 && this.b == 0) {
                                if (this.b == 0) {
                                    selectedTabPosition = 1;
                                } else {
                                    selectedTabPosition = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                        obj.G(obj.x(i), selectedTabPosition);
                    }
                }
            }
        }
    }

    private static class d implements com.google.android.material.tabs.TabLayout.d {

        private final ViewPager2 a;
        private final boolean b;
        d(ViewPager2 viewPager2, boolean z2) {
            super();
            this.a = viewPager2;
            this.b = z2;
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void a(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void b(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            this.a.k(g.g(), this.b);
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void c(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        }
    }
    public d(com.google.android.material.tabs.TabLayout tabLayout, ViewPager2 viewPager22, com.google.android.material.tabs.d.b d$b3) {
        super(tabLayout, viewPager22, 1, b3);
    }

    public d(com.google.android.material.tabs.TabLayout tabLayout, ViewPager2 viewPager22, boolean z3, com.google.android.material.tabs.d.b d$b4) {
        super(tabLayout, viewPager22, z3, 1, b4);
    }

    public d(com.google.android.material.tabs.TabLayout tabLayout, ViewPager2 viewPager22, boolean z3, boolean z4, com.google.android.material.tabs.d.b d$b5) {
        super();
        this.a = tabLayout;
        this.b = viewPager22;
        this.c = z3;
        this.d = z4;
        this.e = b5;
    }

    public void a() {
        boolean aVar;
        Object tabLayout;
        if (this.g) {
        } else {
            RecyclerView.h adapter = this.b.getAdapter();
            this.f = adapter;
            if (adapter == null) {
            } else {
                int i = 1;
                this.g = i;
                d.c cVar = new d.c(this.a);
                this.h = cVar;
                this.b.h(cVar);
                d.d dVar = new d.d(this.b, this.d);
                this.i = dVar;
                this.a.d(dVar);
                if (this.c) {
                    aVar = new d.a(this);
                    this.j = aVar;
                    this.f.registerAdapterDataObserver(aVar);
                }
                b();
                this.a.I(this.b.getCurrentItem(), 0, i);
            }
            IllegalStateException illegalStateException = new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("TabLayoutMediator is already attached");
        throw illegalStateException2;
    }

    void b() {
        RecyclerView.h itemCount;
        int selectedTabPosition;
        int i;
        com.google.android.material.tabs.TabLayout.g gVar;
        com.google.android.material.tabs.TabLayout tabLayout;
        this.a.C();
        itemCount = this.f;
        if (itemCount != null) {
            itemCount = itemCount.getItemCount();
            selectedTabPosition = 0;
            i = selectedTabPosition;
            while (i < itemCount) {
                gVar = this.a.z();
                this.e.a(gVar, i);
                this.a.g(gVar, selectedTabPosition);
                i++;
            }
            itemCount = Math.min(this.b.getCurrentItem(), tabCount--);
            if (itemCount > 0 && itemCount != this.a.getSelectedTabPosition()) {
                itemCount = Math.min(this.b.getCurrentItem(), tabCount--);
                if (itemCount != this.a.getSelectedTabPosition()) {
                    selectedTabPosition = this.a;
                    selectedTabPosition.F(selectedTabPosition.x(itemCount));
                }
            }
        }
    }
}
