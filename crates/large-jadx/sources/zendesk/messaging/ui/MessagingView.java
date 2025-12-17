package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.x;
import com.squareup.picasso.t;
import java.util.concurrent.TimeUnit;
import zendesk.commonui.AlmostRealProgressBar;
import zendesk.messaging.EventFactory;
import zendesk.messaging.EventListener;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class MessagingView extends CoordinatorLayout {

    public static final long DEFAULT_ANIMATION_DURATION;
    private final zendesk.messaging.ui.CellListAdapter cellListAdapter;
    private final zendesk.messaging.ui.LostConnectionBanner lostConnectionBanner;
    private final AlmostRealProgressBar progressBar;
    static {
        MessagingView.DEFAULT_ANIMATION_DURATION = TimeUnit.MILLISECONDS.toMillis(300);
    }

    public MessagingView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public MessagingView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(R.layout.zui_view_messaging, this, true);
        this.progressBar = (AlmostRealProgressBar)findViewById(R.id.zui_progressBar);
        CellListAdapter obj7 = new CellListAdapter();
        this.cellListAdapter = obj7;
        LinearLayoutManager obj8 = new LinearLayoutManager(context);
        View obj6 = findViewById(R.id.zui_recycler_view);
        (RecyclerView)obj6.setLayoutManager(obj8);
        obj6.setAdapter(obj7);
        final int i2 = 0;
        obj6.getRecycledViewPool().k(R.layout.zui_cell_response_options_stacked, i2);
        g gVar = new g();
        final long dEFAULT_ANIMATION_DURATION = MessagingView.DEFAULT_ANIMATION_DURATION;
        gVar.setAddDuration(dEFAULT_ANIMATION_DURATION);
        gVar.setChangeDuration(dEFAULT_ANIMATION_DURATION);
        gVar.setRemoveDuration(dEFAULT_ANIMATION_DURATION);
        gVar.setMoveDuration(dEFAULT_ANIMATION_DURATION);
        gVar.setSupportsChangeAnimations(i2);
        obj6.setItemAnimator(gVar);
        View viewById = findViewById(R.id.zui_input_box);
        this.lostConnectionBanner = LostConnectionBanner.create(this, obj6, (InputBox)viewById);
        RecyclerViewScroller recyclerViewScroller = new RecyclerViewScroller(obj6, obj8, obj7);
        recyclerViewScroller.install(viewById);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    public void renderState(zendesk.messaging.ui.MessagingState messagingState, zendesk.messaging.ui.MessagingCellFactory messagingCellFactory2, t t3, EventListener eventListener4, EventFactory eventFactory5) {
        zendesk.messaging.ui.CellListAdapter cellListAdapter;
        AlmostRealProgressBar obj6;
        Object obj7;
        if (messagingState == null) {
        }
        final java.util.List messagingItems = messagingState.messagingItems;
        this.cellListAdapter.submitList(messagingCellFactory2.createCells(messagingItems, messagingState.typingState, t3, messagingState.attachmentSettings));
        if (messagingState.progressBarVisible) {
            this.progressBar.n(AlmostRealProgressBar.y);
        } else {
            this.progressBar.p(300);
        }
        this.lostConnectionBanner.update(messagingState.connectionState);
        obj6 = new MessagingView.1(this, eventListener4, eventFactory5);
        this.lostConnectionBanner.setOnRetryConnectionClickListener(obj6);
    }
}
