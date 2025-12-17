package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class u extends androidx.recyclerview.widget.y {

    private androidx.recyclerview.widget.t c;
    private androidx.recyclerview.widget.t d;

    class a extends androidx.recyclerview.widget.p {

        final androidx.recyclerview.widget.u a;
        a(androidx.recyclerview.widget.u u, Context context2) {
            this.a = u;
            super(context2);
        }

        @Override // androidx.recyclerview.widget.p
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return i /= obj2;
        }

        @Override // androidx.recyclerview.widget.p
        protected int calculateTimeForScrolling(int i) {
            return Math.min(100, super.calculateTimeForScrolling(i));
        }

        @Override // androidx.recyclerview.widget.p
        protected void onTargetFound(View view, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a3) {
            int mDecelerateInterpolator;
            androidx.recyclerview.widget.u obj4 = this.a;
            int[] obj3 = obj4.c(obj4.a.getLayoutManager(), view);
            obj4 = obj3[0];
            obj3 = obj3[1];
            int timeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(obj4), Math.abs(obj3)));
            if (timeForDeceleration > 0) {
                a3.d(obj4, obj3, timeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }
    private int l(View view, androidx.recyclerview.widget.t t2) {
        return i2 -= obj2;
    }

    private View m(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, androidx.recyclerview.widget.t t2) {
        int i2;
        int i4;
        int i3;
        View view;
        int i5;
        int i;
        final int i6 = p.g0();
        if (i6 == 0) {
            return null;
        }
        i4 = Integer.MAX_VALUE;
        i3 = 0;
        while (i3 < i6) {
            view = p.f0(i3);
            i5 = Math.abs(i12 -= i8);
            if (i5 < i4) {
            }
            i3++;
            i2 = view;
            i4 = i5;
        }
        return i2;
    }

    private androidx.recyclerview.widget.t n(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        Object tVar;
        Object obj2;
        tVar = this.d;
        if (tVar != null) {
            if (tVar.a != p) {
                this.d = t.a(p);
            }
        } else {
        }
        return this.d;
    }

    private androidx.recyclerview.widget.t o(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        if (p.I()) {
            return p(p);
        }
        if (p.H()) {
            return n(p);
        }
        return null;
    }

    private androidx.recyclerview.widget.t p(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        Object tVar;
        Object obj2;
        tVar = this.c;
        if (tVar != null) {
            if (tVar.a != p) {
                this.c = t.c(p);
            }
        } else {
        }
        return this.c;
    }

    private boolean q(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, int i2, int i3) {
        int i;
        i = 1;
        final int i4 = 0;
        if (p.H()) {
            if (i2 > 0) {
            } else {
                i = i4;
            }
            return i;
        }
        if (i3 > 0) {
        } else {
            i = i4;
        }
        return i;
    }

    private boolean r(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        int cmp;
        boolean i;
        int i2;
        int i3;
        android.graphics.PointF obj5;
        i2 = 0;
        i = 1;
        obj5 = (RecyclerView.a0.b)p.d(cmp -= i);
        if (p instanceof RecyclerView.a0.b && obj5 != null) {
            i = 1;
            obj5 = (RecyclerView.a0.b)p.d(cmp -= i);
            if (obj5 != null) {
                i3 = 0;
                if (Float.compare(f, i3) >= 0) {
                    if (Float.compare(obj5, i3) < 0) {
                        i2 = i;
                    }
                } else {
                }
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.y
    public int[] c(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, View view2) {
        int z;
        androidx.recyclerview.widget.RecyclerView.p obj5;
        int[] iArr = new int[2];
        final int i2 = 0;
        if (p.H()) {
            iArr[i2] = l(view2, n(p));
        } else {
            iArr[i2] = i2;
        }
        final int i3 = 1;
        if (p.I()) {
            iArr[i3] = l(view2, p(p));
        } else {
            iArr[i3] = i2;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.y
    protected androidx.recyclerview.widget.RecyclerView.a0 d(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        if (!p instanceof RecyclerView.a0.b) {
            return null;
        }
        u.a obj2 = new u.a(this, this.a.getContext());
        return obj2;
    }

    @Override // androidx.recyclerview.widget.y
    public View g(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        if (p.I()) {
            return m(p, p(p));
        }
        if (p.H()) {
            return m(p, n(p));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.y
    public int h(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, int i2, int i3) {
        int i7;
        int i;
        int i4;
        int i8;
        int i5;
        View view;
        int i6;
        int obj12;
        final int i9 = p.v0();
        final int i10 = -1;
        if (i9 == 0) {
            return i10;
        }
        final androidx.recyclerview.widget.t tVar = o(p);
        if (tVar == null) {
            return i10;
        }
        i7 = Integer.MIN_VALUE;
        i = Integer.MAX_VALUE;
        i4 = 0;
        i5 = i8;
        while (i4 < p.g0()) {
            view = p.f0(i4);
            if (view == null) {
            } else {
            }
            i6 = l(view, tVar);
            if (i6 <= 0 && i6 > i7) {
            }
            if (i6 >= 0 && i6 < i) {
            }
            i4++;
            if (i6 < i) {
            }
            i8 = view;
            i = i6;
            if (i6 > i7) {
            }
            i5 = view;
            i7 = i6;
        }
        final boolean obj13 = q(p, i2, i3);
        if (obj13 != null && i8 != 0) {
            if (i8 != 0) {
                return p.A0(i8);
            }
        }
        if (obj13 == null && i5 != 0) {
            if (i5 != 0) {
                return p.A0(i5);
            }
        }
        if (obj13 != null) {
            i8 = i5;
        }
        if (i8 == 0) {
            return i10;
        }
        obj12 = r(p) == obj13 ? i10 : 1;
        obj14 += obj12;
        if (obj14 >= 0 && obj14 >= i9) {
            if (obj14 >= i9) {
            }
            return obj14;
        }
        return i10;
    }
}
