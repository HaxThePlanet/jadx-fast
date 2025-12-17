package com.yuyakaido.android.cardstackview.i;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

/* loaded from: classes2.dex */
public class b extends RecyclerView.j {

    private final RecyclerView a;
    public b(RecyclerView recyclerView) {
        super();
        this.a = recyclerView;
    }

    private CardStackLayoutManager a() {
        RecyclerView.p layoutManager = this.a.getLayoutManager();
        if (layoutManager instanceof CardStackLayoutManager == null) {
        } else {
            return (CardStackLayoutManager)layoutManager;
        }
        IllegalStateException illegalStateException = new IllegalStateException("CardStackView must be set CardStackLayoutManager.");
        throw illegalStateException;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onChanged() {
        a().y2(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeChanged(int i, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeChanged(int i, int i2, Object object3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeInserted(int i, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeMoved(int i, int i2, int i3) {
        a().E1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$j
    public void onItemRangeRemoved(int i, int i2) {
        int i3;
        int obj3;
        final CardStackLayoutManager obj4 = a();
        i3 = obj4.n2();
        if (obj4.v0() == 0) {
            obj4.y2(0);
        } else {
            if (i < i3) {
                obj4.y2(Math.min(i3 -= obj3, obj3--));
            }
        }
    }
}
