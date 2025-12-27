package app.dogo.com.dogo_android.n.m.u;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.SparseArray;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.k3;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;
import app.dogo.com.dogo_android.util.c0;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import d.h.k.j;
import d.h.l.d;
import d.h.l.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.j0.h;
import kotlin.w;

/* compiled from: VideoTrickDetailsAdapter.kt */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B1\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u001f\u001a\u00020\rH\u0002J\u0008\u0010 \u001a\u00020\u0016H\u0016J\u0006\u0010!\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0016H\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\r\u0010,\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010-J\r\u0010.\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010-J\u0010\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0008\u00102\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u00020\rR\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$VideoHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoUrl", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "cardClickCallBack", "Lkotlin/Function0;", "", "(Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lkotlin/jvm/functions/Function0;)V", "getCardClickCallBack", "()Lkotlin/jvm/functions/Function0;", "currentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItems", "()Ljava/util/List;", "outlineLeft", "", "outlineRight", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "videoPlayers", "Landroid/util/SparseArray;", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getVideoUrl", "()Ljava/lang/String;", "clearAllPlayers", "getItemCount", "hideVideos", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onStart", "()Lkotlin/Unit;", "onStop", "onViewAttachedToWindow", "onViewDetachedFromWindow", "pauseAll", "playOne", "setupTouchListener", "view", "Landroid/view/View;", "startPlay", "VideoHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class VideoTrickDetailsAdapter extends RecyclerView.h<o.a> implements app.dogo.com.dogo_android.util.d0.a {

    private final List<TrickItem.VideoStep> a;
    /* renamed from: b, reason: from kotlin metadata */
    private final String currentRecyclerView;
    private final c0 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final kotlin.d0.c.a<w> outlineLeft;
    /* renamed from: e, reason: from kotlin metadata */
    private RecyclerView outlineRight;
    private final SparseArray<e2> f = new SparseArray<>();
    /* renamed from: g, reason: from kotlin metadata */
    private int videoPlayers;
    private int h;

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$onCreateViewHolder$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "isOutlineCalculated", "", "shouldCalculateOutline", "Lcom/google/android/exoplayer2/ui/PlayerView;", "surfaceRight", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewOutlineProvider {

        final /* synthetic */ o a;
        b() {
            this.a = oVar;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        private final boolean isOutlineCalculated() {
            boolean z = true;
            int r0 = this.a.h != 0 ? 1 : 0;
            return (this.a.h != 0 ? 1 : 0);
        }

        /* renamed from: b, reason: from kotlin metadata */
        private final boolean getOutline(PlayerView view, int outline) {
            boolean z = true;
            view = view.getWidth() != 0 && outline != 0 && view.getWidth() != outline ? 1 : 0;
            return (view.getWidth() != 0 && outline != 0 && view.getWidth() != outline ? 1 : 0);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) throws android.content.res.Resources.NotFoundException {
            int right = 0;
            n.f(view, "view");
            n.f(outline, "outline");
            int i2 = 2131165620;
            if (isOutlineCalculated()) {
                int i = 0;
                outline.setRoundRect(onAttachedToRecyclerView, i, this.a.h, view.getHeight(), view.getResources().getDimension(i2));
            } else {
                PlayerView outline23 = view;
                View videoSurfaceView = outline23.getVideoSurfaceView();
                if (videoSurfaceView == null) {
                    right = 0;
                } else {
                    right = videoSurfaceView.getRight();
                }
                if (getOutline(outline23, right)) {
                    this.a.videoPlayers = (outline23.getWidth() - right) / 2;
                    this.a.h = this.a.videoPlayers + right;
                    i = 0;
                    outline.setRoundRect(onAttachedToRecyclerView, i, this.a.h, outline23.getHeight(), outline23.getResources().getDimension(i2));
                } else {
                    int onAttachedToRecyclerView = 0;
                    i = 0;
                    outline.setRoundRect(onAttachedToRecyclerView, i, outline23.getWidth(), outline23.getHeight(), outline23.getResources().getDimension(i2));
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final /* synthetic */ o a;
        c() {
            this.a = oVar;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            n.f(e, "e");
            this.a.l().invoke();
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$VideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.e0 {

        private final k3 a;
        public a(k3 k3Var) {
            n.f(k3Var, "binding");
            super(k3Var.w());
            this.a = k3Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final k3 a() {
            return this.a;
        }
    }
    public o(List<TrickItem.VideoStep> list, String str, c0 c0Var, kotlin.d0.c.a<w> aVar) {
        n.f(list, "items");
        n.f(str, "videoUrl");
        n.f(c0Var, "videoPlayerFactory");
        n.f(aVar, "cardClickCallBack");
        super();
        this.a = list;
        this.currentRecyclerView = str;
        this.c = c0Var;
        this.outlineLeft = aVar;
        final SparseArray sparseArray = new SparseArray();
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ int onAttachedToRecyclerView(o recyclerView) {
        return recyclerView.videoPlayers;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final /* synthetic */ int onDetachedFromRecyclerView(o recyclerView) {
        return recyclerView.h;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(o holder, int position) {
        holder.videoPlayers = position;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateViewHolder(o parent, int viewType) {
        parent.h = viewType;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void clearAllPlayers() {
        Iterator contains = j.contains(this.f);
        while (contains.hasNext()) {
            Object item = contains.next();
            item.stop();
            item.a();
        }
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final void onViewAttachedToWindow(RecyclerView holder) {
        Iterator it = x.contains(holder).iterator();
        while (it.hasNext()) {
            RecyclerView.e0 e0Var = holder.j0((View)it.next());
            z = e0Var instanceof VideoTrickDetailsAdapter_VideoHolder;
        }
    }

    private final void v() {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int i;
        ViewGroup viewGroup;
        View view;
        Object obj;
        View view2;
        v1 player = null;
        RecyclerView.e0 e0Var = null;
        Integer num;
        i = 0;
        if (this.outlineRight == null) {
        } else {
            layoutManager = this.outlineRight.getLayoutManager();
        }
        LinearLayoutManager r0 = layoutManager instanceof LinearLayoutManager ? (inearLayoutManager)layoutManager : i;
        if (this.outlineRight == 0) {
        } else {
            num = Integer.valueOf(i.r2());
        }
        final boolean z4 = true;
        if (num == null) {
            int i2 = 0;
            if (this.outlineRight == null) {
            } else {
                View view3 = x.a(this.outlineRight, i2);
            }
            r0 = i instanceof ViewGroup ? (ViewGroup)i : i;
            if (this.outlineRight == null) {
            } else {
                view = x.a(viewGroup, i2);
            }
            z2 = view instanceof ViewGroup;
            r0 = view instanceof ViewGroup ? (ViewGroup)view : i;
            if (this.outlineRight == null) {
            } else {
                view2 = x.a(obj, i2);
            }
            z = view2 instanceof PlayerView;
            r0 = view2 instanceof PlayerView ? (PlayerView)view2 : i;
            if (this.outlineRight != 0) {
                player = i.getPlayer();
            }
            if (player != null) {
                player.A(z4);
            }
        } else {
            View view4 = i.Z(num.intValue());
            if (view4 != null && this.outlineRight == null) {
                Objects.requireNonNull(e0Var, "null cannot be cast to non-null type app.dogo.com.dogo_android.library.tricks.trickdetails.VideoTrickDetailsAdapter.VideoHolder");
                v1 player2 = e0Var.a().P.getPlayer();
                if (player2 != null) {
                    player2.A(z4);
                }
            }
        }
    }

    /* renamed from: w, reason: from kotlin metadata */
    private final void onViewDetachedFromWindow(View holder) {
        holder.setOnTouchListener(new app.dogo.com.dogo_android.library.tricks.trickdetails.h(new d(holder.getContext(), new VideoTrickDetailsAdapter_setupTouchListener_tapGestureDetector_1(this))));
    }

    private static final boolean x(d dVar, View view, MotionEvent motionEvent) {
        n.f(dVar, "$tapGestureDetector");
        n.f(view, "touchView");
        dVar.a(motionEvent);
        view.performClick();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final kotlin.d0.c.a<w> l() {
        return this.outlineLeft;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void m() {
        int i = 0;
        int i2 = 4;
        if (this.outlineRight != null) {
            h contains = x.contains(this.outlineRight);
            if (contains != null) {
                Iterator it = contains.iterator();
                while (it.hasNext()) {
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void o(o.a aVar, int i) {
        n.f(aVar, "holder");
        Object item = this.a.get(i);
        aVar.a().V((TrickItem_VideoStep)this.a.get(i));
        this.f.append(i, VideoPlayerFactory.c(this.c, this.currentRecyclerView, item.getStartTimeSeconds(), item.getEndTimeSeconds(), null, 8, null));
        aVar.a().p();
        n.e(textView, "holder.binding.description");
        onViewDetachedFromWindow(textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.outlineRight = recyclerView;
        onViewDetachedFromWindow(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        clearAllPlayers();
        this.outlineRight = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public o.a p(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final k3 k3Var = k3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(k3Var, "inflate(inflater, parent, false)");
        k3Var.P.setClipToOutline(true);
        k3Var.P.setOutlineProvider(new VideoTrickDetailsAdapter_onCreateViewHolder_1(this));
        return new VideoTrickDetailsAdapter_VideoHolder(k3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w q() {
        int i = 0;
        i = this.outlineRight == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w r() {
        int i = 0;
        i = this.outlineRight == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: s, reason: from kotlin metadata */
    public void pauseAll(o.a recyclerView) {
        n.f(recyclerView, "holder");
        super.onViewAttachedToWindow(recyclerView);
        Object item = this.a.get(recyclerView.getAbsoluteAdapterPosition());
        recyclerView.a().P.setPlayer(this.c.getVideoStepsPlayer(this.currentRecyclerView, item.getStartTimeSeconds(), item.getEndTimeSeconds(), (e2)this.f.get(recyclerView.getAbsoluteAdapterPosition())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: t, reason: from kotlin metadata */
    public void setupTouchListener(o.a view) {
        n.f(view, "holder");
        super.onViewDetachedFromWindow(view);
        v1 player = view.a().P.getPlayer();
        if (player != null) {
            player.stop();
        }
        view.a().P.setPlayer(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void y() {
        if (this.outlineRight != null) {
            onViewAttachedToWindow(this.outlineRight);
        }
        v();
    }

    public static /* synthetic */ boolean n(d dVar, View view, MotionEvent motionEvent) {
        return VideoTrickDetailsAdapter.x(dVar, view, motionEvent);
    }
}
