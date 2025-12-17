package com.yuyakaido.android.cardstackview.i;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.y;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.c;
import com.yuyakaido.android.cardstackview.g;
import com.yuyakaido.android.cardstackview.g.b;
import java.util.List;

/* loaded from: classes2.dex */
public class e extends y {

    private int c = 0;
    private int d = 0;
    public e() {
        super();
        final int i = 0;
    }

    @Override // androidx.recyclerview.widget.y
    public int[] c(RecyclerView.p recyclerView$p, View view2) {
        boolean z;
        int cmp;
        int contains;
        com.yuyakaido.android.cardstackview.i.c cVar;
        com.yuyakaido.android.cardstackview.b fast;
        com.yuyakaido.android.cardstackview.i.d obj6;
        if (p instanceof CardStackLayoutManager != null && p.Z((CardStackLayoutManager)p.n2()) != null) {
            if (p.Z((CardStackLayoutManager)p.n2()) != null) {
                z = (int)translationX;
                contains = (int)translationY;
                if (z == 0) {
                    cVar = p.l2();
                    int i6 = this.c;
                    if (contains != 0 && this.d < i6) {
                        cVar = p.l2();
                        i6 = this.c;
                        if (this.d < i6) {
                            obj6 = i6;
                        }
                        obj6 = c.fromVelocity(obj6);
                        fast = cVar.e;
                        if (obj6 != c.Fast && Float.compare(fast, cmp) >= 0) {
                            fast = cVar.e;
                            if (Float.compare(fast, cmp) >= 0) {
                                if (Float.compare(fast, contains) < 0) {
                                    com.yuyakaido.android.cardstackview.i.f fVar = p.m2();
                                    if (cVar.g.contains(fVar.b())) {
                                        fVar.g = i4++;
                                        g.b bVar = new g.b();
                                        bVar.b(cVar.k.a());
                                        bVar.c(obj6.duration);
                                        bVar.d(cVar.k.b());
                                        p.w2(bVar.a());
                                        obj6 = 0;
                                        this.c = obj6;
                                        this.d = obj6;
                                        obj6 = new d(d.b.ManualSwipe, p);
                                        obj6.setTargetPosition(p.n2());
                                        p.f2(obj6);
                                    } else {
                                        obj6 = new d(d.b.ManualCancel, p);
                                        obj6.setTargetPosition(p.n2());
                                        p.f2(obj6);
                                    }
                                } else {
                                    obj6 = new d(d.b.ManualCancel, p);
                                    obj6.setTargetPosition(p.n2());
                                    p.f2(obj6);
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
        return new int[2];
    }

    @Override // androidx.recyclerview.widget.y
    public View g(RecyclerView.p recyclerView$p) {
        boolean i;
        Object obj4;
        final int i3 = 0;
        obj4 = p.Z((CardStackLayoutManager)p.n2());
        if (p instanceof CardStackLayoutManager != null && obj4 != null && (int)translationX == 0 && (int)translationY == 0) {
            obj4 = p.Z((CardStackLayoutManager)p.n2());
            if (obj4 != null) {
                if ((int)translationX == 0) {
                    if ((int)translationY == 0) {
                        return i3;
                    }
                }
                return obj4;
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.y
    public int h(RecyclerView.p recyclerView$p, int i2, int i3) {
        this.c = Math.abs(i2);
        this.d = Math.abs(i3);
        if (p instanceof CardStackLayoutManager != null) {
            return (CardStackLayoutManager)p.n2();
        }
        return -1;
    }
}
