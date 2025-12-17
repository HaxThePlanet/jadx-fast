package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import java.util.Locale;

/* loaded from: classes.dex */
final class e extends RecyclerView.u {

    private androidx.viewpager2.widget.ViewPager2.i a;
    private final androidx.viewpager2.widget.ViewPager2 b;
    private final RecyclerView c;
    private final LinearLayoutManager d;
    private int e;
    private int f;
    private androidx.viewpager2.widget.e.a g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    private static final class a {

        int a;
        float b;
        int c;
        void a() {
            this.a = -1;
            this.b = 0;
            this.c = 0;
        }
    }
    e(androidx.viewpager2.widget.ViewPager2 viewPager2) {
        super();
        this.b = viewPager2;
        RecyclerView obj1 = viewPager2.B;
        this.c = obj1;
        this.d = (LinearLayoutManager)obj1.getLayoutManager();
        obj1 = new e.a();
        this.g = obj1;
        l();
    }

    private void a(int i, float f2, int i3) {
        final androidx.viewpager2.widget.ViewPager2.i view = this.a;
        if (view != null) {
            view.onPageScrolled(i, f2, i3);
        }
    }

    private void b(int i) {
        final androidx.viewpager2.widget.ViewPager2.i view = this.a;
        if (view != null) {
            view.onPageSelected(i);
        }
    }

    private void c(int i) {
        int i2;
        if (this.e == 3 && this.f == 0) {
            if (this.f == 0) {
            }
        }
        if (this.f == i) {
        }
        this.f = i;
        androidx.viewpager2.widget.ViewPager2.i view = this.a;
        if (view != null) {
            view.onPageScrollStateChanged(i);
        }
    }

    private int d() {
        return this.d.v2();
    }

    private boolean i() {
        int i;
        int i2;
        final int i3 = this.e;
        if (i3 != 1) {
            if (i3 == 4) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    private void l() {
        final int i = 0;
        this.e = i;
        this.f = i;
        this.g.a();
        int i2 = -1;
        this.h = i2;
        this.i = i2;
        this.j = i;
        this.k = i;
        this.m = i;
        this.l = i;
    }

    private void n(boolean z) {
        int obj3;
        this.m = z;
        final int i = 1;
        obj3 = z ? 4 : i;
        this.e = obj3;
        obj3 = this.i;
        final int i2 = -1;
        if (obj3 != i2) {
            this.h = obj3;
            this.i = i2;
        } else {
            if (this.h == i2) {
                this.h = d();
            }
        }
        c(i);
    }

    private void o() {
        int i6;
        int i5;
        int i;
        boolean paddingTop;
        int i2;
        int i4;
        int i7;
        int i8;
        android.view.ViewGroup.LayoutParams layoutParams;
        int i3;
        boolean topMargin;
        androidx.viewpager2.widget.e.a aVar = this.g;
        int i10 = this.d.v2();
        aVar.a = i10;
        if (i10 == -1) {
            aVar.a();
        }
        View view = this.d.Z(i10);
        if (view == null) {
            aVar.a();
        }
        layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            i += leftMargin;
            i2 += rightMargin;
            i7 += topMargin;
            i8 += layoutParams;
        }
        i18 += i8;
        int i19 = 1;
        final int i20 = 0;
        i4 = this.d.J2() == 0 ? i19 : i20;
        if (i4 != 0) {
            if (this.b.e()) {
                i6 = -i6;
            }
            i3 = i17;
        } else {
            i13 -= paddingTop;
        }
        int i11 = -i6;
        aVar.c = i11;
        a aVar2 = new a(this.d);
        if (i11 < 0 && aVar2.d()) {
            aVar2 = new a(this.d);
            if (aVar2.d()) {
                IllegalStateException illegalStateException = new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                throw illegalStateException;
            }
            Object[] arr = new Object[i19];
            arr[i20] = Integer.valueOf(aVar.c);
            IllegalStateException illegalStateException2 = new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", arr));
            throw illegalStateException2;
        }
        if (i3 == 0) {
            i5 = 0;
        } else {
            f /= paddingTop;
        }
        aVar.b = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    double e() {
        o();
        androidx.viewpager2.widget.e.a aVar = this.g;
        return d += d2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    int f() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    boolean g() {
        return this.m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    boolean h() {
        int i;
        i = this.f == 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    void j() {
        this.l = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    void k(int i, boolean z2) {
        int obj4;
        final int i2 = 2;
        obj4 = z2 ? i2 : 3;
        this.e = obj4;
        this.m = false;
        if (this.i != i) {
            obj4 = 1;
        }
        this.i = i;
        c(i2);
        if (obj4 != null) {
            b(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    void m(androidx.viewpager2.widget.ViewPager2.i viewPager2$i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        int i3;
        int i;
        int obj6;
        int obj7;
        final int i4 = 0;
        i3 = 1;
        if (this.e == i3) {
            if (this.f != i3 && i2 == i3) {
                if (i2 == i3) {
                    n(i4);
                }
            }
        } else {
        }
        final int i5 = 2;
        if (i() && i2 == i5 && this.k) {
            if (i2 == i5) {
                if (this.k) {
                    c(i5);
                    this.j = i3;
                }
            }
        }
        final int i6 = -1;
        if (i() && i2 == 0) {
            if (i2 == 0) {
                o();
                if (!this.k) {
                    obj6 = obj6.a;
                    if (obj6 != i6) {
                        a(obj6, 0, i4);
                    }
                } else {
                    obj6 = this.g;
                    if (obj6.c == 0) {
                        obj6 = obj6.a;
                        if (this.h != obj6) {
                            b(obj6);
                        }
                    } else {
                        i3 = i4;
                    }
                }
                if (i3 != 0) {
                    c(i4);
                    l();
                }
            }
        }
        o();
        obj6 = this.g;
        obj6 = obj6.a;
        if (this.e == i5 && i2 == 0 && this.l && obj6.c == 0 && this.i != obj6 && obj6 == i6) {
            if (i2 == 0) {
                if (this.l) {
                    o();
                    obj6 = this.g;
                    if (obj6.c == 0) {
                        obj6 = obj6.a;
                        if (this.i != obj6) {
                            if (obj6 == i6) {
                                obj6 = i4;
                            }
                            b(obj6);
                        }
                        c(i4);
                        l();
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int obj5;
        int obj6;
        final int obj4 = 1;
        this.k = obj4;
        o();
        final int i4 = -1;
        final int i5 = 0;
        if (this.j) {
            this.j = i5;
            if (i3 <= 0) {
                if (i3 == 0) {
                    obj5 = i2 < 0 ? obj4 : i5;
                    if (obj5 == this.b.e()) {
                        obj5 = obj4;
                    } else {
                        obj5 = i5;
                    }
                } else {
                }
            } else {
            }
            obj5 = this.g;
            if (obj5 != null && obj5.c != 0) {
                obj5 = this.g;
                obj5 = obj5.c != 0 ? obj5 + obj4 : obj5.a;
            } else {
            }
            this.i = obj5;
            if (this.h != obj5) {
                b(obj5);
            }
        } else {
            if (this.e == 0 && obj5.a == i4) {
                if (obj5.a == i4) {
                    obj5 = i5;
                }
                b(obj5);
            }
        }
        obj5 = this.g;
        if (obj5.a == i4) {
            obj6 = i5;
        }
        a(obj6, obj5.b, obj5.c);
        obj5 = this.g;
        int i = this.i;
        if (obj5.a != i) {
            if (i == i4 && obj5.c == 0 && this.f != obj4) {
                if (obj5.c == 0) {
                    if (this.f != obj4) {
                        c(i5);
                        l();
                    }
                }
            }
        } else {
        }
    }
}
