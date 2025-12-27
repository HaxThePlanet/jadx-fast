package com.yuyakaido.android.cardstackview.i;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.a0.a;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.a;
import com.yuyakaido.android.cardstackview.b;
import com.yuyakaido.android.cardstackview.e;

/* compiled from: CardStackSmoothScroller.java */
/* loaded from: classes2.dex */
public class d extends RecyclerView.a0 {

    private d.b a;
    private CardStackLayoutManager b;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[b.values().length];
            d.a.b = iArr;
            int i2 = 1;
            try {
                iArr[b.Left.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i4 = 4;
                int[] iArr8 = new int[d.b.values().length];
                d.a.a = iArr8;
                return;
            }
            int i = 2;
            try {
                d.a.b[b.Right.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        AutomaticRewind,
        AutomaticSwipe,
        ManualCancel,
        ManualSwipe;
    }
    public d(d.b bVar, CardStackLayoutManager cardStackLayoutManager) {
        super();
        this.a = bVar;
        this.b = cardStackLayoutManager;
    }

    private int a(a aVar) {
        int i = 0;
        int i2;
        com.yuyakaido.android.cardstackview.i.f fVar = this.b.m2();
        i2 = d.a.b[aVar.a().ordinal()];
        i = 0;
        if (i2 == 1) {
            i2 = -fVar.b;
        } else {
            if (i2 == 2) {
                i = i2 * 2;
            } else {
                if (fVar.b != 3) {
                    int i4 = 4;
                }
            }
        }
        return i;
    }

    private int b(a aVar) {
        int i = 1;
        int i3 = 0;
        int i4;
        com.yuyakaido.android.cardstackview.i.f fVar = this.b.m2();
        int i6 = d.a.b[aVar.a().ordinal()];
        i = 1;
        final int i5 = 4;
        if (i6 == 1 || i6 == i) {
            i3 = fVar.c / i5;
        } else {
            int i2 = 3;
            if (i6 != 3) {
                aVar = i6 != i5 ? 0 : fVar.c;
            } else {
                i4 = -fVar.c;
                i3 = i4 * i;
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onSeekTargetStep(int i, int i2, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        if (this.a == d.b.AutomaticRewind) {
            i4 = -b(eVar);
            aVar.d(-a(eVar), i4, eVar.d(), eVar.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStart() {
        a aVar = this.b.k2();
        com.yuyakaido.android.cardstackview.i.f fVar = this.b.m2();
        int i = d.a.a[this.a.ordinal()];
        int i2 = 1;
        if (d.a.a == 1) {
            fVar.e(f.b.AutomaticSwipeAnimating);
            aVar.e(this.b.o2(), this.b.n2());
        } else {
            i2 = 2;
            if (d.a.a == 2) {
                fVar.e(f.b.RewindAnimating);
            } else {
                i2 = 3;
                if (d.a.a == 3) {
                    fVar.e(f.b.ManualSwipeAnimating);
                    aVar.e(this.b.o2(), this.b.n2());
                } else {
                    if (this.b == 4) {
                        fVar.e(f.b.RewindAnimating);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStop() {
        a aVar = this.b.k2();
        int i = d.a.a[this.a.ordinal()];
        if (d.a.a == 2) {
            aVar.f();
            aVar.a(this.b.o2(), this.b.n2());
        } else {
            int i2 = 4;
            if (this.b == 4) {
                aVar.b();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onTargetFound(View view, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        i3 = (int)view.getTranslationX();
        i2 = (int)view.getTranslationY();
        int i4 = d.a.a[this.a.ordinal()];
        if (d.a.a == 1) {
            i3 = -a(gVar2);
            aVar.d(i3, -b(gVar2), gVar2.d(), gVar2.b());
        } else {
            if (d.a.a == 2) {
                aVar.d(i3, i2, eVar.d(), eVar.b());
            } else {
                if (this.b == 3) {
                    i3 = -i3 * 10;
                    i2 = -i2 * 10;
                    aVar.d(i3, i2, gVar.d(), gVar.b());
                } else {
                    int i = 4;
                    if (this.b == 4) {
                        aVar.d(i3, i2, eVar2.d(), eVar2.b());
                    }
                }
            }
        }
    }
}
