package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.d.d.q;
import app.dogo.com.dogo_android.h.e2;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.n0.d;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.l;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import h.a.b.b;
import h.a.b.h.f;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0014\u0012\u0008\u0012\u00060\u0002R\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JD\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u000c\u0010\u0017\u001a\u0008\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J,\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0016J\u0013\u0010 \u001a\u00020\u00102\u0008\u0010!\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Lapp/dogo/com/dogo_android/model/ChallengeModel;)V", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "id", "", "getId", "()Ljava/lang/String;", "isPremium", "", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "setLikeState", "state", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends EntryItem<app.dogo.com.dogo_android.d.d.r.e.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    private final ChallengeEntryModel a;
    private final ChallengeModel b;
    private final boolean c;

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001e\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0008\u0010\u001b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "(Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileItem;Landroid/view/View;Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntryProfileItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileObservable;", "onUserView", "", "viewed", "", "setModel", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "isPremium", "setupEntryCell", "binding", "showDeleteDialog", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "position", "", "updateView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends EntryViewHolder {

        private final e2 a;
        private final app.dogo.com.dogo_android.d.d.r.f b;
        public a(app.dogo.com.dogo_android.d.d.r.e e, View view2, q q3) {
            final Object obj = this;
            Object obj2 = q3;
            n.f(e, "this$0");
            n.f(obj2, "adapter");
            super(view2, obj2);
            n.d(view2);
            e2 e2Var = e2.T(view2);
            n.e(e2Var, "bind(view!!)");
            obj.a = e2Var;
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
            obj.b = fVar;
            e2Var.W(fVar);
            e2Var.V(q3.l2());
            e2Var.O.T(fVar);
            e2Var.O.U(q3.l2());
            obj.j(e2Var, obj2);
            obj.setupCommentField(e2Var.O, fVar, q3.l2());
            fVar.setParentTag(q3.d2().getTag());
            e.a.a aVar = new e.a.a(obj);
            skVar.S.c(aVar);
        }

        public static final app.dogo.com.dogo_android.d.d.r.f d(app.dogo.com.dogo_android.d.d.r.e.a e$a) {
            return a.b;
        }

        public static void e(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, e2 e23, View view4) {
            e.a.k(a, q2, e23, view4);
        }

        public static void f(app.dogo.com.dogo_android.d.d.r.e.a e$a, e2 e22, View view3) {
            e.a.n(a, e22, view3);
        }

        public static void g(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, e2 e23, View view4) {
            e.a.m(a, q2, e23, view4);
        }

        public static void h(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, View view3) {
            e.a.l(a, q2, view3);
        }

        private final void j(e2 e2, q q2) {
            a aVar = new a(this, q2, e2);
            skVar.S.setOnClickListener(aVar);
            d dVar = new d(this, q2);
            skVar2.f0.setOnClickListener(dVar);
            c cVar = new c(this, q2, e2);
            skVar3.b0.setOnClickListener(cVar);
            b bVar = new b(this, e2);
            obj4.Z.setOnClickListener(bVar);
            updateFeaturedStarVisibility(this.b, obj4.O);
        }

        private static final void k(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, e2 e23, View view4) {
            long currentTimeMillis;
            int currentItem;
            Object obj3;
            Object obj4;
            Object obj5;
            boolean obj6;
            n.f(a, "this$0");
            n.f(q2, "$adapter");
            n.f(e23, "$binding");
            obj6 = a.b;
            obj6.setUserEntryId(q2.A2(obj6.i()));
            if (a.b.isAllowedToVote() && a.b.simpleLike(System.currentTimeMillis(), obj1)) {
                obj6 = a.b;
                obj6.setUserEntryId(q2.A2(obj6.i()));
                if (a.b.simpleLike(System.currentTimeMillis(), obj1)) {
                    a.showLikeAnimation(obj5.Q);
                    a.b.p(q2.l2());
                    a.b.o(q2.l2());
                }
            }
        }

        private static final void l(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, View view3) {
            int pagePosition;
            int bVar;
            app.dogo.com.dogo_android.w.t2 t2Var;
            Object obj5;
            n.f(a, "this$0");
            n.f(q2, "$adapter");
            n.f(view3, "view");
            if (a.b.isCurrentUserEntriesAuthor()) {
                a.showDeleteDialog(view3, q2, a.b.getPagePosition());
            } else {
                pagePosition = a.b.getEntryId();
                n.e(pagePosition, "entryId");
                if (z ^= 1 != 0) {
                    App.Companion.r().c(u.B);
                    obj5 = i1.a(view3.getContext());
                    if (obj5 == null) {
                    } else {
                        bVar = new e.a.b(a, q2);
                        g1.Y(obj5, pagePosition, bVar);
                    }
                }
            }
        }

        private static final void m(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, e2 e23, View view4) {
            long currentTimeMillis;
            Object obj2;
            Object obj3;
            Object obj4;
            boolean obj5;
            n.f(a, "this$0");
            n.f(q2, "$adapter");
            n.f(e23, "$binding");
            obj5 = a.b;
            obj5.setUserEntryId(q2.A2(obj5.i()));
            a.b.toggleLike(System.currentTimeMillis(), obj1);
            if (a.b.isAllowedToVote() && a.b.getLikeState()) {
                obj5 = a.b;
                obj5.setUserEntryId(q2.A2(obj5.i()));
                a.b.toggleLike(System.currentTimeMillis(), obj1);
                if (a.b.getLikeState()) {
                    a.b.p(q2.l2());
                    a.b.o(q2.l2());
                }
            }
        }

        private static final void n(app.dogo.com.dogo_android.d.d.r.e.a e$a, e2 e22, View view3) {
            n.f(a, "this$0");
            n.f(e22, "$binding");
            a.b.toggleFeatured(obj1.S.getCurrentItem());
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public final void i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, boolean z3) {
            n.f(challengeEntryModel, "entryModel");
            this.b.n(challengeEntryModel, challengeModel2, z3);
            this.b.m();
            if (!this.b.isModelTheSame(challengeEntryModel)) {
                clearCommentField();
            }
            l obj6 = new l(challengeEntryModel, 0, 2, 0);
            obj5.S.setAdapter(obj6);
            updateFeaturedStarVisibility(this.b, obj5.O);
            notifyCommentViewChange();
            this.a.p();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public final void showDeleteDialog(View view, e e2, int i3) {
            Object cVar;
            n.f(view, "view");
            n.f(e2, "adapter");
            androidx.fragment.app.e obj2 = i1.a(view.getContext());
            if (obj2 == null) {
            } else {
                cVar = new e.a.c(this, i3, e2);
                f1.O(obj2, cVar);
            }
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.b.notifyChangeAll();
        }
    }
    public e(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2) {
        n.f(challengeEntryModel, "entryModel");
        n.f(challengeModel2, "challengeModel");
        super(0);
        this.a = challengeEntryModel;
        this.b = challengeModel2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (e.a)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.d.d.r.e.a e$a2, int i3, List<Object> list4) {
        ChallengeEntryModel obj1;
        ChallengeModel obj3;
        boolean obj4;
        if (a2 == null) {
        } else {
            a2.i(this.a, this.b, this.c);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof e) {
            return n.b(this.a.getDocumentId(), object.a.getDocumentId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.d.r.e.a f(View view, b<f<RecyclerView.e0>> b2) {
        Objects.requireNonNull(b2, "null cannot be cast to non-null type app.dogo.com.dogo_android.challenge.profile.ChallengeProfileListAdapter");
        e.a aVar = new e.a(this, view, (q)b2);
        return aVar;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final ChallengeEntryModel g() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.a.getDocumentId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558487;
    }
}
