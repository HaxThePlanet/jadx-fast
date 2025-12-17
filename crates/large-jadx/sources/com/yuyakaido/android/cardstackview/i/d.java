package com.yuyakaido.android.cardstackview.i;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.a0.a;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.a;
import com.yuyakaido.android.cardstackview.b;
import com.yuyakaido.android.cardstackview.e;

/* loaded from: classes2.dex */
public class d extends RecyclerView.a0 {

    private com.yuyakaido.android.cardstackview.i.d.b a;
    private CardStackLayoutManager b;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            d.a.b = iArr;
            int i2 = 1;
            iArr[b.Left.ordinal()] = i2;
            int i = 2;
            d.a.b[b.Right.ordinal()] = i;
            int i3 = 3;
            d.a.b[b.Top.ordinal()] = i3;
            int i4 = 4;
            d.a.b[b.Bottom.ordinal()] = i4;
            int[] iArr8 = new int[values2.length];
            d.a.a = iArr8;
            iArr8[d.b.AutomaticSwipe.ordinal()] = i2;
            d.a.a[d.b.AutomaticRewind.ordinal()] = i;
            d.a.a[d.b.ManualSwipe.ordinal()] = i3;
            d.a.a[d.b.ManualCancel.ordinal()] = i4;
        }
    }

    public static enum b {

        AutomaticSwipe,
        AutomaticRewind,
        ManualSwipe,
        ManualCancel;
    }
    public d(com.yuyakaido.android.cardstackview.i.d.b d$b, CardStackLayoutManager cardStackLayoutManager2) {
        super();
        this.a = b;
        this.b = cardStackLayoutManager2;
    }

    private int a(com.yuyakaido.android.cardstackview.i.a a) {
        com.yuyakaido.android.cardstackview.i.f fVar;
        int i;
        int obj5;
        fVar = this.b.m2();
        obj5 = d.a.b[a.a().ordinal()];
        i = 0;
        if (obj5 != 1) {
            if (obj5 != 2) {
                if (obj5 != 3) {
                    fVar = 4;
                }
            } else {
                obj5 = fVar.b;
                i = obj5 * 2;
            }
        } else {
            obj5 = -obj5;
        }
        return i;
    }

    private int b(com.yuyakaido.android.cardstackview.i.a a) {
        int i2;
        int i;
        int obj5;
        com.yuyakaido.android.cardstackview.i.f fVar = this.b.m2();
        obj5 = d.a.b[a.a().ordinal()];
        final int i3 = 4;
        i2 = 2;
        if (obj5 != 1 && obj5 != i2) {
            i2 = 2;
            if (obj5 != i2) {
                if (obj5 != 3) {
                    if (obj5 != i3) {
                        obj5 = 0;
                    } else {
                        obj5 = fVar.c;
                        obj5 *= i2;
                    }
                } else {
                    obj5 = -obj5;
                }
            } else {
                obj5 /= i3;
            }
        } else {
        }
        return obj5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onSeekTargetStep(int i, int i2, RecyclerView.b0 recyclerView$b03, RecyclerView.a0.a recyclerView$a0$a4) {
        int i3;
        Object obj2;
        com.yuyakaido.android.cardstackview.i.d.b obj3;
        int obj4;
        if (this.a == d.b.AutomaticRewind) {
            obj2 = obj2.l;
            a4.d(-obj3, -obj4, obj2.d(), obj2.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStart() {
        com.yuyakaido.android.cardstackview.i.f.b rewindAnimating;
        Object fVar;
        int i;
        int i2;
        rewindAnimating = this.b.k2();
        fVar = this.b.m2();
        i = d.a.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        fVar.e(f.b.RewindAnimating);
                    }
                } else {
                    fVar.e(f.b.ManualSwipeAnimating);
                    rewindAnimating.e(this.b.o2(), this.b.n2());
                }
            } else {
                fVar.e(f.b.RewindAnimating);
            }
        } else {
            fVar.e(f.b.AutomaticSwipeAnimating);
            rewindAnimating.e(this.b.o2(), this.b.n2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStop() {
        int i2;
        int i;
        a aVar = this.b.k2();
        i2 = d.a.a[this.a.ordinal()];
        if (i2 != 2) {
            if (i2 != 4) {
            } else {
                aVar.b();
            }
        } else {
            aVar.f();
            aVar.a(this.b.o2(), this.b.n2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onTargetFound(View view, RecyclerView.b0 recyclerView$b02, RecyclerView.a0.a recyclerView$a0$a3) {
        android.view.animation.Interpolator i2;
        int i;
        int obj3;
        int obj4;
        obj4 = (int)obj4;
        obj3 = (int)obj3;
        i2 = d.a.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        e eVar2 = cVar2.l;
                        a3.d(obj4, obj3, eVar2.d(), eVar2.b());
                    }
                } else {
                    com.yuyakaido.android.cardstackview.g gVar = cVar3.k;
                    a3.d(obj4 *= 10, obj3 *= 10, gVar.d(), gVar.b());
                }
            } else {
                e eVar = cVar.l;
                a3.d(obj4, obj3, eVar.d(), eVar.b());
            }
        } else {
            obj3 = obj3.k;
            a3.d(-obj4, -i3, obj3.d(), obj3.b());
        }
    }
}
