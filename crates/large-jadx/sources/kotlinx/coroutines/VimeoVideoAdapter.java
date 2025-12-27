package app.dogo.com.dogo_android.m;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.m3;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.util.d0.a.a;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import d.h.l.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.j0.h;
import kotlin.w;

/* compiled from: VimeoVideoAdapter.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0016J\r\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010$J\r\u0010%\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010$J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0002J\u0008\u0010)\u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter$VideoHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "(Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;)V", "currentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "clearAllPlayers", "", "recyclerView", "getItemCount", "", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onStart", "()Lkotlin/Unit;", "onStop", "onViewDetachedFromWindow", "onViewRecycled", "pauseAll", "playOne", "startPlay", "VideoHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class VimeoVideoAdapter extends RecyclerView.h<d.a> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] d;
    /* renamed from: a, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.util.c0 currentRecyclerView;
    private final c b = new d$c();
    private RecyclerView c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter$VideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.e0 {

        private final m3 a;
        public a(m3 m3Var) {
            n.f(m3Var, "binding");
            super(m3Var.w());
            this.a = m3Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final m3 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends b<List<? extends GoodTrickExample>> {

        final /* synthetic */ Object a;
        final /* synthetic */ d b;
        public c(Object object, Object object2, d dVar) {
            this.a = object;
            this.b = dVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends GoodTrickExample> oldValue, List<? extends GoodTrickExample> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.d.b.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.p<GoodTrickExample, GoodTrickExample, Boolean> {

        public static final d.b a = new d$b();
        @Override // kotlin.d0.d.p
        public final boolean a(GoodTrickExample goodTrickExample, GoodTrickExample goodTrickExample2) {
            boolean z = true;
            n.f(goodTrickExample, "o");
            n.f(goodTrickExample2, "n");
            long vimeoContentId = goodTrickExample.getVimeoContentId();
            long vimeoContentId2 = goodTrickExample2.getVimeoContentId();
            goodTrickExample = vimeoContentId == vimeoContentId2 ? 1 : 0;
            return (vimeoContentId == vimeoContentId2 ? 1 : 0);
        }


        b() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        VimeoVideoAdapter.d = new l[] { c0.f(new t(c0.b(VimeoVideoAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public d(app.dogo.com.dogo_android.util.c0 c0Var) {
        n.f(c0Var, "videoPlayerFactory");
        super();
        this.currentRecyclerView = c0Var;
        List list = p.g();
        app.dogo.com.dogo_android.m.d.c delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final void clearAllPlayers(RecyclerView recyclerView) {
        Iterator it = x.b(recyclerView).iterator();
        while (it.hasNext()) {
            RecyclerView.e0 e0Var = recyclerView.j0((View)it.next());
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Iterator it = x.b(recyclerView).iterator();
        while (it.hasNext()) {
            RecyclerView.e0 e0Var = recyclerView.j0((View)it.next());
            z = e0Var instanceof VimeoVideoAdapter_VideoHolder;
        }
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final void getItemCount() {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int i;
        ViewGroup viewGroup;
        android.view.View view;
        Object obj;
        android.view.View view2;
        v1 player = null;
        RecyclerView.e0 e0Var = null;
        Integer num;
        i = 0;
        if (this.c == null) {
        } else {
            layoutManager = this.c.getLayoutManager();
        }
        LinearLayoutManager r0 = layoutManager instanceof LinearLayoutManager ? (inearLayoutManager)layoutManager : i;
        if (this.c == 0) {
        } else {
            num = Integer.valueOf(i.r2());
        }
        final boolean z4 = true;
        if (num == null) {
            int i2 = 0;
            if (this.c == null) {
            } else {
                android.view.View view3 = x.a(this.c, i2);
            }
            r0 = i instanceof ViewGroup ? (ViewGroup)i : i;
            if (this.c == null) {
            } else {
                view = x.a(viewGroup, i2);
            }
            z2 = view instanceof ViewGroup;
            r0 = view instanceof ViewGroup ? (ViewGroup)view : i;
            if (this.c == null) {
            } else {
                view2 = x.a(obj, i2);
            }
            z = view2 instanceof PlayerView;
            r0 = view2 instanceof PlayerView ? (PlayerView)view2 : i;
            if (this.c != 0) {
                player = i.getPlayer();
            }
            if (player != null) {
                player.A(z4);
            }
        } else {
            android.view.View view4 = i.Z(num.intValue());
            if (view4 != null && this.c == null) {
                Objects.requireNonNull(e0Var, "null cannot be cast to non-null type app.dogo.com.dogo_android.goodexamples.VimeoVideoAdapter.VideoHolder");
                v1 player2 = e0Var.a().O.getPlayer();
                if (player2 != null) {
                    player2.A(z4);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final List<GoodTrickExample> g() {
        return (List)this.b.getValue(this, VimeoVideoAdapter.d[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(d.a holder, int position) {
        String videoUrl;
        n.f(holder, "holder");
        holder.a().W((GoodTrickExample)g().get(position));
        GoodTrickExample goodTrickExample = holder.a().T();
        videoUrl = "";
        if (goodTrickExample != null) {
            videoUrl = goodTrickExample.getVideoUrl();
            if (videoUrl != null) {
            }
        }
        holder.a().O.setPlayer(this.currentRecyclerView.getGoodExamplesPlayer(videoUrl));
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public d.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final m3 m3Var = m3.U(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(m3Var, "inflate(inflater, parent, false)");
        return new VimeoVideoAdapter_VideoHolder(m3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w j() {
        int i = 0;
        i = this.c == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w l() {
        int i = 0;
        i = this.c == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: m, reason: from kotlin metadata */
    public void onDetachedFromRecyclerView(d.a recyclerView) {
        n.f(recyclerView, "holder");
        super.onViewDetachedFromWindow(recyclerView);
        v1 player = recyclerView.a().O.getPlayer();
        if (player != null) {
            long l = 0L;
            player.w(l);
        }
        v1 player2 = recyclerView.a().O.getPlayer();
        if (player2 != null) {
            boolean z = false;
            player2.A(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: n, reason: from kotlin metadata */
    public void onViewDetachedFromWindow(d.a holder) {
        n.f(holder, "holder");
        super.onViewRecycled(holder);
        v1 player = holder.a().O.getPlayer();
        if (player != null) {
            player.stop();
        }
        v1 player2 = holder.a().O.getPlayer();
        if (player2 != null) {
            player2.a();
        }
        holder.a().O.setPlayer(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) throws android.content.res.Resources.NotFoundException {
        n.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        int i2 = 0;
        recyclerView.setPadding(recyclerView.getContext().getResources().getDimensionPixelSize(2131165436), i2, i2, i2);
        recyclerView.setClipToPadding(false);
        this.c = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        clearAllPlayers(recyclerView);
        this.c = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: q, reason: from kotlin metadata */
    public final void pauseAll(List<GoodTrickExample> recyclerView) {
        n.f(recyclerView, "<set-?>");
        this.b.setValue(this, VimeoVideoAdapter.d[0], recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void r() {
        if (this.c != null) {
            onAttachedToRecyclerView(this.c);
        }
        getItemCount();
    }
}
