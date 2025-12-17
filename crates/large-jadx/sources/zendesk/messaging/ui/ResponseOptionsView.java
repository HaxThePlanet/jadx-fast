package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import d.h.l.u;
import java.util.Collections;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class ResponseOptionsView extends FrameLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.ResponseOptionsViewState> {

    private zendesk.messaging.ui.ResponseOptionsAdapter adapter;

    private static class ItemOffsetDecoration extends RecyclerView.o {

        private int itemOffset;
        ItemOffsetDecoration(Context context, int i2) {
            super();
            this.itemOffset = context.getResources().getDimensionPixelSize(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$o
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
            int obj3;
            int obj5;
            super.getItemOffsets(rect, view2, recyclerView3, b04);
            obj3 = recyclerView3.g0(view2);
            if (obj3 == -1) {
            }
            final int i = 0;
            obj3 = obj3 == null ? obj5 : i;
            if (u.B(recyclerView3) == 0) {
            } else {
                obj5 = i;
            }
            if (obj5 != null) {
                if (obj3 == null) {
                    rect.set(i, i, this.itemOffset, i);
                }
            } else {
                if (obj3 == null) {
                    rect.set(this.itemOffset, i, i, i);
                }
            }
        }
    }
    public ResponseOptionsView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    static zendesk.messaging.ui.ResponseOptionsAdapter access$000(zendesk.messaging.ui.ResponseOptionsView responseOptionsView) {
        return responseOptionsView.adapter;
    }

    private void init() {
        FrameLayout.inflate(getContext(), R.layout.zui_view_response_options_content, this);
    }

    @Override // android.widget.FrameLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        View viewById = findViewById(R.id.zui_response_options_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, 1);
        (RecyclerView)viewById.setLayoutManager(linearLayoutManager);
        ResponseOptionsAdapter responseOptionsAdapter = new ResponseOptionsAdapter();
        this.adapter = responseOptionsAdapter;
        viewById.setAdapter(responseOptionsAdapter);
        ResponseOptionsView.ItemOffsetDecoration itemOffsetDecoration = new ResponseOptionsView.ItemOffsetDecoration(getContext(), R.dimen.zui_cell_response_options_horizontal_spacing);
        viewById.h(itemOffsetDecoration);
    }

    @Override // android.widget.FrameLayout
    public void update(Object object) {
        update((ResponseOptionsViewState)object);
    }

    @Override // android.widget.FrameLayout
    public void update(zendesk.messaging.ui.ResponseOptionsViewState responseOptionsViewState) {
        responseOptionsViewState.getProps().apply(this);
        ResponseOptionsView.1 anon = new ResponseOptionsView.1(this, responseOptionsViewState);
        this.adapter.setResponseOptionHandler(anon);
        this.adapter.submitList(responseOptionsViewState.getOptions());
    }
}
