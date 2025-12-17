package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends androidx.viewpager2.widget.ViewPager2.i {

    private final List<androidx.viewpager2.widget.ViewPager2.i> a;
    b(int i) {
        super();
        ArrayList arrayList = new ArrayList(i);
        this.a = arrayList;
    }

    private void b(ConcurrentModificationException concurrentModificationException) {
        IllegalStateException illegalStateException = new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
        throw illegalStateException;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    void a(androidx.viewpager2.widget.ViewPager2.i viewPager2$i) {
        this.a.add(i);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageScrollStateChanged(int i) {
        Object next;
        try {
            Iterator iterator = this.a.iterator();
            for (ViewPager2.i next : iterator) {
                next.onPageScrollStateChanged(i);
            }
            (ViewPager2.i)iterator.next().onPageScrollStateChanged(i);
            b(i);
            i = 0;
            throw i;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageScrolled(int i, float f2, int i3) {
        Object next;
        try {
            Iterator iterator = this.a.iterator();
            for (ViewPager2.i next : iterator) {
                next.onPageScrolled(i, f2, i3);
            }
            (ViewPager2.i)iterator.next().onPageScrolled(i, f2, i3);
            b(i);
            i = 0;
            throw i;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageSelected(int i) {
        Object next;
        try {
            Iterator iterator = this.a.iterator();
            for (ViewPager2.i next : iterator) {
                next.onPageSelected(i);
            }
            (ViewPager2.i)iterator.next().onPageSelected(i);
            b(i);
            i = 0;
            throw i;
        }
    }
}
