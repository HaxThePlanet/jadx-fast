package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.y;
import com.yuyakaido.android.cardstackview.i.b;
import com.yuyakaido.android.cardstackview.i.e;

/* loaded from: classes2.dex */
public class CardStackView extends RecyclerView {

    private final b d1;
    public CardStackView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public CardStackView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        b obj1 = new b(this);
        this.d1 = obj1;
        G1();
    }

    private void G1() {
        e eVar = new e();
        eVar.b(this);
        setOverScrollMode(2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void H1() {
        boolean z;
        if (layoutManager instanceof CardStackLayoutManager != null) {
            y1(i--);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void I1() {
        boolean z;
        if (layoutManager instanceof CardStackLayoutManager != null) {
            y1(i++);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int layoutManager;
        float f2;
        float f;
        layoutManager = getLayoutManager();
        if (motionEvent.getAction() == 0 && (CardStackLayoutManager)layoutManager != null) {
            layoutManager = getLayoutManager();
            if ((CardStackLayoutManager)(CardStackLayoutManager)layoutManager != null) {
                (CardStackLayoutManager)(CardStackLayoutManager)layoutManager.G2(motionEvent.getX(), motionEvent.getY());
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.h recyclerView$h) {
        RecyclerView.p cardStackLayoutManager;
        RecyclerView.h adapter;
        Context context;
        if (getLayoutManager() == null) {
            cardStackLayoutManager = new CardStackLayoutManager(getContext());
            setLayoutManager(cardStackLayoutManager);
        }
        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(this.d1);
            getAdapter().onDetachedFromRecyclerView(this);
        }
        h.registerAdapterDataObserver(this.d1);
        super.setAdapter(h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.p recyclerView$p) {
        if (p instanceof CardStackLayoutManager == null) {
        } else {
            super.setLayoutManager(p);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("CardStackView must be set CardStackLayoutManager.");
        throw obj2;
    }
}
