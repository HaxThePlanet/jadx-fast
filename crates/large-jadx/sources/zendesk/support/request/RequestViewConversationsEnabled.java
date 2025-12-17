package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.r;
import androidx.recyclerview.widget.x;
import com.squareup.picasso.t;
import d.h.l.f0.b;
import d.h.l.u;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import o.b.d;
import o.b.f;
import o.b.q;
import o.b.t;
import zendesk.belvedere.b;
import zendesk.belvedere.e;
import zendesk.belvedere.e.c;

/* loaded from: classes3.dex */
public class RequestViewConversationsEnabled extends FrameLayout implements zendesk.support.request.RequestView {

    private d activity;
    zendesk.support.request.ActionFactory af;
    zendesk.support.request.CellFactory cellFactory;
    private zendesk.support.request.RequestViewConversationsEnabled.ImagePickerDragAnimation imagePickerDragAnimation;
    private e imageStream;
    private zendesk.support.request.ComponentMessageComposer messageComposerComponent;
    private zendesk.support.request.ViewMessageComposer messageComposerView;
    t picasso;
    private RecyclerView recyclerView;
    q store;
    private t subscription;
    private View toolbar;
    private View toolbarContainer;

    static class ImagePickerDragAnimation implements e.c {

        private final Interpolator cubicBezierInterpolator;
        private final View messageComposer;
        private final View recycler;
        private final View toolbar;
        private final View toolbarContainer;
        ImagePickerDragAnimation(View view, View view2, View view3, View view4) {
            super();
            this.toolbarContainer = view;
            this.messageComposer = view2;
            this.recycler = view3;
            this.toolbar = view4;
            this.cubicBezierInterpolator = b.a(1044549468, 0, 1045220557, 1065353216);
        }

        private void animateBackground(int i, float f2) {
            float obj3 = (float)obj3;
            this.messageComposer.setTranslationY(obj3);
            this.recycler.setTranslationY(obj3);
        }

        private void animateToolbar(int i, float f2) {
            float f;
            int obj3;
            int obj4;
            f = (float)i;
            f -= obj4;
            obj3 = (float)i2;
            if (i > 0 && Float.compare(f, obj3) < 0) {
                f -= obj4;
                obj3 = (float)i2;
                if (Float.compare(f, obj3) < 0) {
                    this.toolbarContainer.setTranslationY(f -= obj3);
                } else {
                    this.toolbarContainer.setTranslationY(0);
                }
            } else {
            }
        }

        @Override // zendesk.belvedere.e$c
        public void onScroll(int i, int i2, float f3) {
            animateToolbar(i2, f3);
            animateBackground(i2, f3);
        }
    }

    static class RecyclerListener implements zendesk.support.request.ViewMessageComposer.OnHeightChangeListener, View.OnFocusChangeListener, View.OnLayoutChangeListener, r {

        private static final int FIXED_SCROLL_TIME = 50;
        private static final int SCROLL_INSTANT = 1;
        private static final int SCROLL_SMOOTH_FIXED_TIME = 3;
        private static final int SCROLL_SMOOTH_FIXED_VELOCITY = 2;
        private final LinearLayoutManager linearLayoutManager;
        private final int recyclerDefaultBottomPadding;
        private final RecyclerView recyclerView;
        RecyclerListener(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager2) {
            super();
            this.recyclerView = recyclerView;
            this.linearLayoutManager = linearLayoutManager2;
            this.recyclerDefaultBottomPadding = recyclerView.getResources().getDimensionPixelOffset(d.s);
        }

        static RecyclerView access$000(zendesk.support.request.RequestViewConversationsEnabled.RecyclerListener requestViewConversationsEnabled$RecyclerListener) {
            return recyclerListener.recyclerView;
        }

        static int access$100(zendesk.support.request.RequestViewConversationsEnabled.RecyclerListener requestViewConversationsEnabled$RecyclerListener) {
            return recyclerListener.recyclerDefaultBottomPadding;
        }

        static void access$200(zendesk.support.request.RequestViewConversationsEnabled.RecyclerListener requestViewConversationsEnabled$RecyclerListener, int i2) {
            recyclerListener.scrollToBottom(i2);
        }

        private void postScrollToBottom(int i) {
            RequestViewConversationsEnabled.RecyclerListener.3 anon = new RequestViewConversationsEnabled.RecyclerListener.3(this, i);
            this.recyclerView.post(anon);
        }

        private void scrollToBottom(int i) {
            int layoutManager;
            int context;
            int obj3;
            context = 1;
            itemCount -= context;
            if (layoutManager >= 0) {
                if (i == context) {
                    obj3 = this.recyclerView.a0(layoutManager);
                    obj3 = obj3.itemView;
                    if (obj3 != null && obj3 != null) {
                        obj3 = obj3.itemView;
                        if (obj3 != null) {
                            obj3 = obj3.getHeight();
                        } else {
                            obj3 = 0;
                        }
                    } else {
                    }
                    this.linearLayoutManager.W2(layoutManager, i3 *= -1);
                } else {
                    if (i == 3) {
                        obj3 = new RequestViewConversationsEnabled.RecyclerListener.2(this, this.recyclerView.getContext());
                        obj3.setTargetPosition(layoutManager);
                        this.recyclerView.getLayoutManager().f2(obj3);
                    } else {
                        if (i == 2) {
                            obj3 = new p(this.recyclerView.getContext());
                            obj3.setTargetPosition(layoutManager);
                            this.recyclerView.getLayoutManager().f2(obj3);
                        }
                    }
                }
            }
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onChanged(int i, int i2, Object object3) {
            this.recyclerView.getAdapter().notifyItemRangeChanged(i, i2, object3);
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onFocusChange(View view, boolean z2) {
            int obj1;
            if (z2) {
                postScrollToBottom(2);
            }
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onHeightChange(int i) {
            RequestViewConversationsEnabled.RecyclerListener.1 anon = new RequestViewConversationsEnabled.RecyclerListener.1(this, i);
            this.recyclerView.post(anon);
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onInserted(int i, int i2) {
            this.recyclerView.getAdapter().notifyItemRangeChanged(i, i2);
            postScrollToBottom(3);
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            int obj1;
            if (i5 < i9) {
                postScrollToBottom(1);
            }
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onMoved(int i, int i2) {
            this.recyclerView.getAdapter().notifyItemMoved(i, i2);
        }

        @Override // zendesk.support.request.ViewMessageComposer$OnHeightChangeListener
        public void onRemoved(int i, int i2) {
            this.recyclerView.getAdapter().notifyItemRangeRemoved(i, i2);
        }
    }

    static class RequestItemAnimator extends g {

        private final zendesk.support.request.ComponentRequestAdapter component;
        RequestItemAnimator(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter) {
            super();
            this.component = componentRequestAdapter;
            setSupportsChangeAnimations(false);
        }

        @Override // androidx.recyclerview.widget.g
        public boolean canReuseUpdatedViewHolder(RecyclerView.e0 recyclerView$e0) {
            if (messageForPos instanceof CellType.Attachment) {
                return 1;
            }
            return super.canReuseUpdatedViewHolder(e0);
        }
    }
    public RequestViewConversationsEnabled(Context context) {
        super(context);
        viewInit(context);
    }

    public RequestViewConversationsEnabled(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        viewInit(context);
    }

    public RequestViewConversationsEnabled(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        viewInit(context);
    }

    private t bindComponents(q q) {
        t[] arr = new t[3];
        return d.d(bindMessageComposer(q), bindRecycler(q), bindDialogComponent(q));
    }

    private t bindDialogComponent(q q) {
        ComponentDialog componentDialog = new ComponentDialog(this.activity, this.af, q);
        return q.a(StateUi.class, componentDialog);
    }

    private t bindMessageComposer(q q) {
        super(this.activity, this.imageStream, this.messageComposerView, q, this.af);
        this.messageComposerComponent = componentMessageComposer2;
        return q.e(componentMessageComposer2.getSelector(), this.messageComposerComponent);
    }

    private t bindRecycler(q q) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity);
        RequestViewConversationsEnabled.RecyclerListener recyclerListener = new RequestViewConversationsEnabled.RecyclerListener(this.recyclerView, linearLayoutManager);
        ComponentRequestAdapter componentRequestAdapter = new ComponentRequestAdapter(recyclerListener, this.cellFactory, this.recyclerView);
        CellMarginDecorator cellMarginDecorator = new CellMarginDecorator(componentRequestAdapter, this.activity);
        RequestViewConversationsEnabled.RequestItemAnimator requestItemAnimator = new RequestViewConversationsEnabled.RequestItemAnimator(componentRequestAdapter);
        ComponentRequestAdapter.RequestAdapter requestAdapter = new ComponentRequestAdapter.RequestAdapter(componentRequestAdapter);
        this.recyclerView.setItemAnimator(requestItemAnimator);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.h(cellMarginDecorator);
        this.recyclerView.setAdapter(requestAdapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.messageComposerView.setOnHeightChangeListener(recyclerListener);
        this.messageComposerView.addOnFocusChangeListener(recyclerListener);
        this.recyclerView.addOnLayoutChangeListener(recyclerListener);
        return q.e(componentRequestAdapter.getSelector(), componentRequestAdapter);
    }

    private void bindViews() {
        this.imageStream = b.b(this.activity);
        this.recyclerView = (RecyclerView)findViewById(f.i);
        this.messageComposerView = (ViewMessageComposer)findViewById(f.g);
        this.toolbarContainer = this.activity.findViewById(f.b);
        this.toolbar = this.activity.findViewById(f.k);
        this.messageComposerView.init(this.imageStream);
        installDragAnimation();
    }

    private void installDragAnimation() {
        RequestViewConversationsEnabled.ImagePickerDragAnimation imagePickerDragAnimation = new RequestViewConversationsEnabled.ImagePickerDragAnimation(this.toolbarContainer, this.messageComposerView, this.recyclerView, this.toolbar);
        this.imagePickerDragAnimation = imagePickerDragAnimation;
        this.imageStream.D1(imagePickerDragAnimation);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, h.t, this);
        this.activity = (d)context;
    }

    @Override // android.widget.FrameLayout
    public boolean hasUnsavedInput() {
        zendesk.support.request.ComponentMessageComposer messageComposerComponent;
        int i;
        messageComposerComponent = this.messageComposerComponent;
        if (messageComposerComponent != null && messageComposerComponent.hasUnsavedInput()) {
            i = messageComposerComponent.hasUnsavedInput() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public boolean inflateMenu(MenuInflater menuInflater, Menu menu2) {
        return 0;
    }

    @Override // android.widget.FrameLayout
    void init(zendesk.support.request.RequestComponent requestComponent, boolean z2) {
        Object obj1;
        o.b.a obj2;
        requestComponent.inject(this);
        bindViews();
        obj1 = bindComponents(this.store);
        this.subscription = obj1;
        obj1.a();
        if (z2 != null) {
            this.store.c(this.af.loadCommentsFromCacheAsync());
            this.store.c(this.af.loadRequestAsync());
            this.store.c(this.af.initialLoadCommentsAsync());
            this.messageComposerView.requestFocusForInput();
        }
    }

    @Override // android.widget.FrameLayout
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final t subscription = this.subscription;
        if (subscription != null) {
            subscription.c();
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onOptionsItemClicked(MenuItem menuItem) {
        return 0;
    }
}
