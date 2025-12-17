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
import app.dogo.com.dogo_android.util.d0.a;
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
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.j0.h;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B1\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u001f\u001a\u00020\rH\u0002J\u0008\u0010 \u001a\u00020\u0016H\u0016J\u0006\u0010!\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0016H\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\r\u0010,\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010-J\r\u0010.\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010-J\u0010\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0008\u00102\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u00020\rR\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$VideoHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoUrl", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "cardClickCallBack", "Lkotlin/Function0;", "", "(Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lkotlin/jvm/functions/Function0;)V", "getCardClickCallBack", "()Lkotlin/jvm/functions/Function0;", "currentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItems", "()Ljava/util/List;", "outlineLeft", "", "outlineRight", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "videoPlayers", "Landroid/util/SparseArray;", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getVideoUrl", "()Ljava/lang/String;", "clearAllPlayers", "getItemCount", "hideVideos", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onStart", "()Lkotlin/Unit;", "onStop", "onViewAttachedToWindow", "onViewDetachedFromWindow", "pauseAll", "playOne", "setupTouchListener", "view", "Landroid/view/View;", "startPlay", "VideoHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends RecyclerView.h<app.dogo.com.dogo_android.n.m.u.o.a> implements a {

    private final List<TrickItem.VideoStep> a;
    private final String b;
    private final c0 c;
    private final a<w> d;
    private RecyclerView e;
    private final SparseArray<e2> f;
    private int g;
    private int h;

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$onCreateViewHolder$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "isOutlineCalculated", "", "shouldCalculateOutline", "Lcom/google/android/exoplayer2/ui/PlayerView;", "surfaceRight", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewOutlineProvider {

        final app.dogo.com.dogo_android.n.m.u.o a;
        b(app.dogo.com.dogo_android.n.m.u.o o) {
            this.a = o;
            super();
        }

        private final boolean a() {
            int i;
            i = o.g(this.a) != 0 ? 1 : 0;
            return i;
        }

        private final boolean b(PlayerView playerView, int i2) {
            int obj2;
            if (playerView.getWidth() != 0 && i2 != 0 && playerView.getWidth() != i2) {
                if (i2 != 0) {
                    obj2 = playerView.getWidth() != i2 ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline2) {
            Resources resources;
            int right;
            int i2;
            Object obj;
            int i;
            int i3;
            int width;
            int height;
            float dimension;
            n.f(view, "view");
            n.f(outline2, "outline");
            int i4 = 2131165620;
            if (a()) {
                outline2.setRoundRect(o.f(this.a), 0, o.g(this.a), view.getHeight(), view.getResources().getDimension(i4));
            } else {
                Object obj2 = view;
                View videoSurfaceView = (PlayerView)obj2.getVideoSurfaceView();
                if (videoSurfaceView == null) {
                    right = 0;
                } else {
                    right = videoSurfaceView.getRight();
                }
                if (b(obj2, right)) {
                    o.h(this.a, i5 /= 2);
                    app.dogo.com.dogo_android.n.m.u.o oVar4 = this.a;
                    o.i(oVar4, i7 += right);
                    outline2.setRoundRect(o.f(this.a), 0, o.g(this.a), obj2.getHeight(), obj2.getResources().getDimension(i4));
                } else {
                    outline2.setRoundRect(0, 0, obj2.getWidth(), obj2.getHeight(), obj2.getResources().getDimension(i4));
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final app.dogo.com.dogo_android.n.m.u.o a;
        c(app.dogo.com.dogo_android.n.m.u.o o) {
            this.a = o;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            n.f(motionEvent, "e");
            this.a.l().invoke();
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/VideoTrickDetailsAdapter$VideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickVideoStepBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.e0 {

        private final k3 a;
        public a(k3 k3) {
            n.f(k3, "binding");
            super(k3.w());
            this.a = k3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final k3 a() {
            return this.a;
        }
    }
    public o(List<TrickItem.VideoStep> list, String string2, c0 c03, a<w> a4) {
        n.f(list, "items");
        n.f(string2, "videoUrl");
        n.f(c03, "videoPlayerFactory");
        n.f(a4, "cardClickCallBack");
        super();
        this.a = list;
        this.b = string2;
        this.c = c03;
        this.d = a4;
        SparseArray obj2 = new SparseArray();
        this.f = obj2;
    }

    public static final int f(app.dogo.com.dogo_android.n.m.u.o o) {
        return o.g;
    }

    public static final int g(app.dogo.com.dogo_android.n.m.u.o o) {
        return o.h;
    }

    public static final void h(app.dogo.com.dogo_android.n.m.u.o o, int i2) {
        o.g = i2;
    }

    public static final void i(app.dogo.com.dogo_android.n.m.u.o o, int i2) {
        o.h = i2;
    }

    private final void j() {
        Object next;
        Iterator it = j.a(this.f);
        for (e2 next : it) {
            next.stop();
            next.a();
        }
    }

    public static boolean n(d d, View view2, MotionEvent motionEvent3) {
        return o.x(d, view2, motionEvent3);
    }

    private final void u(RecyclerView recyclerView) {
        Object player;
        boolean z;
        Iterator iterator = x.b(recyclerView).iterator();
        while (iterator.hasNext()) {
            player = recyclerView.j0((View)iterator.next());
            if (player instanceof o.a) {
            }
            player = k3Var.P.getPlayer();
            if (player == null) {
            } else {
            }
            player.A(false);
        }
    }

    private final void v() {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int i;
        View view;
        View player;
        v1 player2;
        Integer valueOf;
        boolean intValue;
        boolean z;
        RecyclerView view2 = this.e;
        player2 = 0;
        if (view2 == null) {
            layoutManager = player2;
        } else {
            layoutManager = view2.getLayoutManager();
        }
        if (layoutManager instanceof LinearLayoutManager != null) {
        } else {
            layoutManager = player2;
        }
        if (layoutManager == null) {
            valueOf = player2;
        } else {
            valueOf = Integer.valueOf(layoutManager.r2());
        }
        final int i4 = 1;
        if (valueOf != null) {
            player = layoutManager.Z(valueOf.intValue());
            if (player != null) {
                intValue = this.e;
                if (intValue == null) {
                } else {
                    player2 = intValue.j0(player);
                }
                Objects.requireNonNull(player2, "null cannot be cast to non-null type app.dogo.com.dogo_android.library.tricks.trickdetails.VideoTrickDetailsAdapter.VideoHolder");
                player = k3Var.P.getPlayer();
                if (player == null) {
                } else {
                    player.A(i4);
                }
            }
        } else {
            RecyclerView view3 = this.e;
            int i2 = 0;
            if (view3 == null) {
                i = player2;
            } else {
                i = x.a(view3, i2);
            }
            if (i instanceof ViewGroup) {
            } else {
                i = player2;
            }
            if (i == 0) {
                view = player2;
            } else {
                view = x.a(i, i2);
            }
            if (view instanceof ViewGroup) {
            } else {
                view = player2;
            }
            if (view == null) {
                player = player2;
            } else {
                player = x.a(view, i2);
            }
            if (player instanceof PlayerView != null) {
            } else {
                player = player2;
            }
            if (player == 0) {
            } else {
                player2 = player.getPlayer();
            }
            if (player2 == null) {
            } else {
                player2.A(i4);
            }
        }
    }

    private final void w(View view) {
        o.c cVar = new o.c(this);
        d dVar = new d(view.getContext(), cVar);
        h hVar = new h(dVar);
        view.setOnTouchListener(hVar);
    }

    private static final boolean x(d d, View view2, MotionEvent motionEvent3) {
        n.f(d, "$tapGestureDetector");
        n.f(view2, "touchView");
        d.a(motionEvent3);
        view2.performClick();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    public final a<w> l() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void m() {
        Object iterator;
        boolean next;
        boolean z;
        iterator = this.e;
        if (iterator == null) {
        } else {
            iterator = x.b(iterator);
            if (iterator == null) {
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    RecyclerView view = this.e;
                    if (view == null) {
                    } else {
                    }
                    next = view.j0((View)iterator.next());
                    if (next instanceof o.a) {
                    }
                    k3Var.P.setVisibility(4);
                    next = 0;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void o(app.dogo.com.dogo_android.n.m.u.o.a o$a, int i2) {
        n.f(a, "holder");
        Object obj = this.a.get(i2);
        a.a().V((TrickItem.VideoStep)this.a.get(i2));
        this.f.append(i2, c0.c(this.c, this.b, (TrickItem.VideoStep)obj.getStartTimeSeconds(), obj.getEndTimeSeconds(), 0, 8, 0));
        a.a().p();
        android.widget.TextView obj10 = obj10.O;
        n.e(obj10, "holder.binding.description");
        w(obj10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.e = recyclerView;
        w(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        o((o.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return p(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        j();
        this.e = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewAttachedToWindow(RecyclerView.e0 recyclerView$e0) {
        s((o.a)e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
        t((o.a)e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.n.m.u.o.a p(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final k3 obj2 = k3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        obj2.P.setClipToOutline(true);
        o.b bVar = new o.b(this);
        obj2.P.setOutlineProvider(bVar);
        o.a obj3 = new o.a(obj2);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w q() {
        int i;
        i = this.e == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w r() {
        int i;
        RecyclerView view = this.e;
        i = view == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void s(app.dogo.com.dogo_android.n.m.u.o.a o$a) {
        n.f(a, "holder");
        super.onViewAttachedToWindow(a);
        Object obj = this.a.get(a.getAbsoluteAdapterPosition());
        obj6.P.setPlayer(this.c.b(this.b, (TrickItem.VideoStep)obj.getStartTimeSeconds(), obj.getEndTimeSeconds(), (e2)this.f.get(a.getAbsoluteAdapterPosition())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void t(app.dogo.com.dogo_android.n.m.u.o.a o$a) {
        n.f(a, "holder");
        super.onViewDetachedFromWindow(a);
        v1 player = k3Var.P.getPlayer();
        if (player == null) {
        } else {
            player.stop();
        }
        obj2.P.setPlayer(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void y() {
        final RecyclerView view = this.e;
        if (view == null) {
        } else {
            u(view);
        }
        v();
    }
}
