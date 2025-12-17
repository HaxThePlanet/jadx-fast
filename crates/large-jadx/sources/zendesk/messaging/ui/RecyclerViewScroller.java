package zendesk.messaging.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.p;

/* loaded from: classes3.dex */
class RecyclerViewScroller {

    private final RecyclerView.h<RecyclerView.e0> adapter;
    private int lastCompletelyVisiblePosition = 0;
    private final LinearLayoutManager linearLayoutManager;
    private final RecyclerView recyclerView;
    private int secondCompletelyVisiblePosition = 0;
    RecyclerViewScroller(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager2, RecyclerView.h<RecyclerView.e0> recyclerView$h3) {
        super();
        int i = 0;
        this.recyclerView = recyclerView;
        this.linearLayoutManager = linearLayoutManager2;
        this.adapter = h3;
        RecyclerViewScroller.1 anon = new RecyclerViewScroller.1(this, linearLayoutManager2);
        recyclerView.l(anon);
        RecyclerViewScroller.2 obj3 = new RecyclerViewScroller.2(this, h3);
        recyclerView.addOnLayoutChangeListener(obj3);
        obj3 = new RecyclerViewScroller.3(this, recyclerView);
        h3.registerAdapterDataObserver(obj3);
    }

    static int access$000(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller) {
        return recyclerViewScroller.secondCompletelyVisiblePosition;
    }

    static int access$002(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller, int i2) {
        recyclerViewScroller.secondCompletelyVisiblePosition = i2;
        return i2;
    }

    static int access$100(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller) {
        return recyclerViewScroller.lastCompletelyVisiblePosition;
    }

    static int access$102(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller, int i2) {
        recyclerViewScroller.lastCompletelyVisiblePosition = i2;
        return i2;
    }

    static void access$200(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller, int i2) {
        recyclerViewScroller.postScrollToBottom(i2);
    }

    static RecyclerView access$300(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller) {
        return recyclerViewScroller.recyclerView;
    }

    static void access$400(zendesk.messaging.ui.RecyclerViewScroller recyclerViewScroller, int i2) {
        recyclerViewScroller.scrollToBottom(i2);
    }

    private void postScrollToBottom(int i) {
        RecyclerViewScroller.7 anon = new RecyclerViewScroller.7(this, i);
        this.recyclerView.post(anon);
    }

    private void scrollToBottom(int i) {
        int linearLayoutManager;
        int context;
        int obj3;
        context = 1;
        itemCount -= context;
        if (linearLayoutManager >= 0) {
            if (i == context) {
                obj3 = this.recyclerView.a0(linearLayoutManager);
                if (obj3 != null) {
                    obj3 = obj3.itemView.getHeight();
                } else {
                    obj3 = 0;
                }
                this.linearLayoutManager.W2(linearLayoutManager, i3 *= -1);
            } else {
                if (i == 3) {
                    obj3 = new RecyclerViewScroller.6(this, this.recyclerView.getContext());
                    obj3.setTargetPosition(linearLayoutManager);
                    this.linearLayoutManager.f2(obj3);
                } else {
                    if (i == 2) {
                        obj3 = new p(this.recyclerView.getContext());
                        obj3.setTargetPosition(linearLayoutManager);
                        this.linearLayoutManager.f2(obj3);
                    }
                }
            }
        }
    }

    void install(zendesk.messaging.ui.InputBox inputBox) {
        RecyclerViewScroller.4 anon = new RecyclerViewScroller.4(this, inputBox);
        inputBox.addOnLayoutChangeListener(anon);
        RecyclerViewScroller.5 anon2 = new RecyclerViewScroller.5(this);
        inputBox.addSendButtonClickListener(anon2);
    }
}
