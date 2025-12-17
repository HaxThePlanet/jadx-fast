package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.e;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class StackedResponseOptionsView extends FrameLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.ResponseOptionsViewState> {

    private zendesk.messaging.ui.ResponseOptionsAdapter adapter;
    public StackedResponseOptionsView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    static zendesk.messaging.ui.ResponseOptionsAdapter access$000(zendesk.messaging.ui.StackedResponseOptionsView stackedResponseOptionsView) {
        return stackedResponseOptionsView.adapter;
    }

    private void init() {
        FrameLayout.inflate(getContext(), R.layout.zui_view_response_options_content, this);
    }

    @Override // android.widget.FrameLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        android.view.View viewById = findViewById(R.id.zui_response_options_recycler);
        (RecyclerView)viewById.setItemAnimator(0);
        e eVar = new e(getContext());
        eVar.n(3);
        android.graphics.drawable.Drawable drawable = a.f(getContext(), R.drawable.zui_view_stacked_response_options_divider);
        if (drawable != null) {
            eVar.k(drawable);
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext(), 1);
        viewById.setLayoutManager(flexboxLayoutManager);
        viewById.h(eVar);
        ResponseOptionsAdapter responseOptionsAdapter = new ResponseOptionsAdapter();
        this.adapter = responseOptionsAdapter;
        viewById.setAdapter(responseOptionsAdapter);
    }

    @Override // android.widget.FrameLayout
    public void update(Object object) {
        update((ResponseOptionsViewState)object);
    }

    @Override // android.widget.FrameLayout
    public void update(zendesk.messaging.ui.ResponseOptionsViewState responseOptionsViewState) {
        responseOptionsViewState.getProps().apply(this);
        StackedResponseOptionsView.1 anon = new StackedResponseOptionsView.1(this, responseOptionsViewState);
        this.adapter.setResponseOptionHandler(anon);
        this.adapter.submitList(responseOptionsViewState.getOptions());
    }
}
