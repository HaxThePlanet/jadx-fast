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

/* compiled from: CardStackSnapHelper.java */
/* loaded from: classes2.dex */
public class e extends y {

    private int c = 0;
    private int d = 0;
    public e() {
        super();
    }

    @Override // androidx.recyclerview.widget.y
    public int[] c(RecyclerView.p pVar, View view) {
        int i2;
        z = pVar instanceof CardStackLayoutManager;
        if (pVar instanceof CardStackLayoutManager) {
            if (pVar.Z(pVar.n2()) != null) {
                int i4 = (int)view.getTranslationX();
                i = (int)view.getTranslationY();
                if (i4 != 0 || i != 0) {
                    com.yuyakaido.android.cardstackview.i.c cVar = pVar.l2();
                    f = (float)Math.abs(i4) / (float)view.getWidth();
                    float f4 = (float)Math.abs(i) / (float)view.getHeight();
                    if (this.d < this.c) {
                    }
                    c velocity = c.fromVelocity(i2);
                    if (velocity != c.Fast) {
                        if (cVar.e >= f) {
                            if (cVar.e < f4) {
                                com.yuyakaido.android.cardstackview.i.f fVar = pVar.m2();
                                if (cVar.g.contains(fVar.b())) {
                                    fVar.g = fVar.f + 1;
                                    g.b bVar2 = new g.b();
                                    bVar2.b(cVar.k.a());
                                    bVar2.c(velocity.duration);
                                    bVar2.d(cVar.k.b());
                                    pVar.w2(bVar2.a());
                                    int i11 = 0;
                                    this.c = i11;
                                    this.d = i11;
                                    com.yuyakaido.android.cardstackview.i.d dVar = new d(d.b.ManualSwipe, pVar);
                                    dVar.setTargetPosition(pVar.n2());
                                    pVar.f2(dVar);
                                } else {
                                    dVar = new d(d.b.ManualCancel, pVar);
                                    dVar.setTargetPosition(pVar.n2());
                                    pVar.f2(dVar);
                                }
                            } else {
                                dVar = new d(d.b.ManualCancel, pVar);
                                dVar.setTargetPosition(pVar.n2());
                                pVar.f2(dVar);
                            }
                        }
                    }
                }
            }
        }
        return new int[2];
    }

    @Override // androidx.recyclerview.widget.y
    public View g(RecyclerView.p pVar) {
        z = pVar instanceof CardStackLayoutManager;
        final int i3 = 0;
        if (pVar instanceof CardStackLayoutManager) {
            View view = pVar.Z(pVar.n2());
            if (view != null) {
                return (int)view.getTranslationX() == 0 && (int)view.getTranslationY() == 0 ? i3 : view;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.y
    public int h(RecyclerView.p pVar, int i, int i2) {
        this.c = Math.abs(i);
        this.d = Math.abs(i2);
        if (pVar instanceof CardStackLayoutManager) {
            return pVar.n2();
        }
        return -1;
    }
}
