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
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.v1;
import d.h.l.x;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.j0.h;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0016J\r\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010$J\r\u0010%\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010$J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0008H\u0002J\u0008\u0010)\u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter$VideoHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "(Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;)V", "currentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "clearAllPlayers", "", "recyclerView", "getItemCount", "", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onStart", "()Lkotlin/Unit;", "onStop", "onViewDetachedFromWindow", "onViewRecycled", "pauseAll", "playOne", "startPlay", "VideoHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends RecyclerView.h<app.dogo.com.dogo_android.m.d.a> implements a {

    static final l<Object>[] d;
    private final c0 a;
    private final c b;
    private RecyclerView c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/VimeoVideoAdapter$VideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLoadingVideoBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends RecyclerView.e0 {

        private final m3 a;
        public a(m3 m3) {
            n.f(m3, "binding");
            super(m3.w());
            this.a = m3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final m3 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends b<List<? extends GoodTrickExample>> {

        final Object a;
        final app.dogo.com.dogo_android.m.d b;
        public c(Object object, Object object2, app.dogo.com.dogo_android.m.d d3) {
            this.a = object;
            this.b = d3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends GoodTrickExample> list2, List<? extends GoodTrickExample> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.m.d obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, d.b.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements p<GoodTrickExample, GoodTrickExample, Boolean> {

        public static final app.dogo.com.dogo_android.m.d.b a;
        static {
            d.b bVar = new d.b();
            d.b.a = bVar;
        }

        b() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(GoodTrickExample goodTrickExample, GoodTrickExample goodTrickExample2) {
            int obj3;
            n.f(goodTrickExample, "o");
            n.f(goodTrickExample2, "n");
            obj3 = Long.compare(vimeoContentId, obj3) == 0 ? 1 : 0;
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((GoodTrickExample)object, (GoodTrickExample)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(d.class), "items", "getItems()Ljava/util/List;");
        d.d = arr;
    }

    public d(c0 c0) {
        n.f(c0, "videoPlayerFactory");
        super();
        this.a = c0;
        a obj2 = a.a;
        obj2 = p.g();
        d.c cVar = new d.c(obj2, obj2, this);
        this.b = cVar;
    }

    private final void f(RecyclerView recyclerView) {
        Object player;
        boolean player2;
        Iterator iterator = x.b(recyclerView).iterator();
        while (iterator.hasNext()) {
            player = recyclerView.j0((View)iterator.next());
            if (player instanceof d.a) {
            }
            player2 = m3Var2.O.getPlayer();
            if (player2 == null) {
            } else {
            }
            player2.stop();
            player = m3Var.O.getPlayer();
            if (player == null) {
            } else {
            }
            player.a();
        }
    }

    private final void o(RecyclerView recyclerView) {
        Object player;
        boolean z;
        Iterator iterator = x.b(recyclerView).iterator();
        while (iterator.hasNext()) {
            player = recyclerView.j0((View)iterator.next());
            if (player instanceof d.a) {
            }
            player = m3Var.O.getPlayer();
            if (player == null) {
            } else {
            }
            player.A(false);
        }
    }

    private final void p() {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int i;
        android.view.View view;
        android.view.View player;
        v1 player2;
        Integer valueOf;
        boolean intValue;
        boolean z;
        RecyclerView view2 = this.c;
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
                intValue = this.c;
                if (intValue == null) {
                } else {
                    player2 = intValue.j0(player);
                }
                Objects.requireNonNull(player2, "null cannot be cast to non-null type app.dogo.com.dogo_android.goodexamples.VimeoVideoAdapter.VideoHolder");
                player = m3Var.O.getPlayer();
                if (player == null) {
                } else {
                    player.A(i4);
                }
            }
        } else {
            RecyclerView view3 = this.c;
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

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<GoodTrickExample> g() {
        return (List)this.b.getValue(this, d.d[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.m.d.a d$a, int i2) {
        Object videoUrl;
        String str;
        n.f(a, "holder");
        a.a().W((GoodTrickExample)g().get(i2));
        videoUrl = a.a().T();
        str = "";
        if (videoUrl == null) {
        } else {
            videoUrl = videoUrl.getVideoUrl();
            if (videoUrl == null) {
            } else {
                str = videoUrl;
            }
        }
        obj5.O.setPlayer(this.a.a(str));
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.m.d.a i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final m3 obj2 = m3.U(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        d.a obj3 = new d.a(obj2);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w j() {
        int i;
        i = this.c == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final w l() {
        int i;
        RecyclerView view = this.c;
        i = view == null ? 0 : w.a;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void m(app.dogo.com.dogo_android.m.d.a d$a) {
        int player;
        int i;
        n.f(a, "holder");
        super.onViewDetachedFromWindow(a);
        player = m3Var.O.getPlayer();
        if (player == null) {
        } else {
            player.w(0);
        }
        v1 obj4 = obj4.O.getPlayer();
        if (obj4 == null) {
        } else {
            obj4.A(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void n(app.dogo.com.dogo_android.m.d.a d$a) {
        n.f(a, "holder");
        super.onViewRecycled(a);
        v1 player = m3Var.O.getPlayer();
        if (player == null) {
        } else {
            player.stop();
        }
        v1 player2 = m3Var2.O.getPlayer();
        if (player2 == null) {
        } else {
            player2.a();
        }
        obj2.O.setPlayer(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        int i2 = 0;
        recyclerView.setPadding(recyclerView.getContext().getResources().getDimensionPixelSize(2131165436), i2, i2, i2);
        recyclerView.setClipToPadding(i2);
        this.c = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((d.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        n.f(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        f(recyclerView);
        this.c = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
        m((d.a)e0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewRecycled(RecyclerView.e0 recyclerView$e0) {
        n((d.a)e0);
    }

    public final void q(List<GoodTrickExample> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, d.d[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void r() {
        final RecyclerView view = this.c;
        if (view == null) {
        } else {
            o(view);
        }
        p();
    }
}
