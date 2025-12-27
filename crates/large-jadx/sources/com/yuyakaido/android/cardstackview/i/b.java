package com.yuyakaido.android.cardstackview.i;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

/* compiled from: CardStackDataObserver.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.j {

    private final RecyclerView a;
    public b(RecyclerView recyclerView) {
        super();
        this.a = recyclerView;
    }

    private CardStackLayoutManager a() {
        RecyclerView.p layoutManager = this.a.getLayoutManager();
        if (!(layoutManager instanceof CardStackLayoutManager)) {
            throw new IllegalStateException("CardStackView must be set CardStackLayoutManager.");
        } else {
            return layoutManager;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onChanged() {
        a().y2(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeMoved(int i, int i2, int i3) {
        a().E1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeRemoved(int i, int i2) {
        final CardStackLayoutManager cardStackLayoutManager = a();
        int i3 = cardStackLayoutManager.n2();
        if (cardStackLayoutManager.v0() == 0) {
            int min = 0;
            cardStackLayoutManager.y2(min);
        } else {
            if (i < i3) {
                i3 = i3 - (i3 - i);
                cardStackLayoutManager.y2(Math.min(i3, cardStackLayoutManager.v0() - 1));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeChanged(int i, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeChanged(int i, int i2, Object object) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeInserted(int i, int i2) {
    }
}
