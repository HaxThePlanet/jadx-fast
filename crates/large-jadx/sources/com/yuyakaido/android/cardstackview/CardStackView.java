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

/* compiled from: CardStackView.java */
/* loaded from: classes2.dex */
public class CardStackView extends RecyclerView {

    private final b d1;
    public CardStackView(Context context, AttributeSet set) {
        this(context, set, 0);
    }

    private void G1() {
        new e().b(this);
        setOverScrollMode(2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void H1() {
        z = getLayoutManager() instanceof CardStackLayoutManager;
        if (this.getLayoutManager() instanceof CardStackLayoutManager) {
            y1((CardStackLayoutManager)getLayoutManager().n2() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void I1() {
        z = getLayoutManager() instanceof CardStackLayoutManager;
        if (this.getLayoutManager() instanceof CardStackLayoutManager) {
            y1((CardStackLayoutManager)getLayoutManager().n2() + 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            RecyclerView.p layoutManager = getLayoutManager();
            if (layoutManager != null) {
                layoutManager.G2(motionEvent.getX(), motionEvent.getY());
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.h hVar) {
        Context context;
        if (getLayoutManager() == null) {
            setLayoutManager(new CardStackLayoutManager(getContext()));
        }
        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(this.d1);
            getAdapter().onDetachedFromRecyclerView(this);
        }
        hVar.registerAdapterDataObserver(this.d1);
        super.setAdapter(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.p pVar) {
        if (!(pVar instanceof CardStackLayoutManager)) {
            throw new IllegalArgumentException("CardStackView must be set CardStackLayoutManager.");
        } else {
            super.setLayoutManager(pVar);
            return;
        }
    }

    public CardStackView(Context context, AttributeSet set, int i) {
        super(context, set, i);
        this.d1 = new b(this);
        G1();
    }
}
