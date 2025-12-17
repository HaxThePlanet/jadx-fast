package app.dogo.com.dogo_android.d.b.z;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.h.i0;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.util.e0.p;
import app.dogo.com.dogo_android.util.n0.l;
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 .2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0003./0B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rJ>\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u00040\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00172\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J&\u0010$\u001a\u00020\u00022\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u00040\u001dH\u0016J\u0013\u0010'\u001a\u00020\n2\u0008\u0010(\u001a\u0004\u0018\u00010#H\u0096\u0002J\u0008\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008J\u0008\u0010+\u001a\u00020\u000cH\u0016J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\nR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "isPremium", "", "id", "", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Lapp/dogo/com/dogo_android/model/ChallengeModel;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "lastSelectedCaptionPhotoPosition", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$PositionTracker;", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "getPhotoId", "photoPosition", "", "getPhotoPosition", "()I", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "setChallengeModel", "toString", "updateLikeState", "state", "Companion", "PositionTracker", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends EntryItem<app.dogo.com.dogo_android.d.b.z.i.c, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<app.dogo.com.dogo_android.d.b.z.i.c> {

    public static final app.dogo.com.dogo_android.d.b.z.i.a Companion;
    private final ChallengeEntryModel a;
    private ChallengeModel b;
    private final boolean c;
    private final String d;
    private final app.dogo.com.dogo_android.d.b.z.i.b e;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$Companion;", "", "()V", "CAPTION_CHALLENGE_TITLE", "", "CAPTION_FAN_CLICK_AREA", "CAPTION_IMAGE_CLICK_AREA", "CAPTION_LIKE_CLICK_AREA", "CAPTION_PROFILE_ICON", "CAPTION_REPORT_CLICK_AREA", "LIKE_ANIMATION_PAYLOAD", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$PositionTracker;", "", "()V", "pos", "", "getPos", "()I", "setPos", "(I)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {

        private int a;
        public final int a() {
            return this.a;
        }

        public final void b(int i) {
            this.a = i;
        }
    }

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0008H\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentCaptionItemBinding;", "getHolderBinding", "()Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentCaptionItemBinding;", "posTracker", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$PositionTracker;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "positionTracker", "isPremium", "", "setupEntryCell", "binding", "showLikeAnimation", "imageView", "Landroid/widget/ImageView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends b {

        private final i0 a;
        private final app.dogo.com.dogo_android.d.b.z.j b;
        private app.dogo.com.dogo_android.d.b.z.i.b c;
        public c(View view, p<?> p2) {
            final Object obj = this;
            super(view, p2);
            n.d(view);
            i0 i0Var = i0.T(view);
            n.e(i0Var, "bind(view!!)");
            obj.a = i0Var;
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
            obj.b = jVar;
            i.b bVar = new i.b();
            obj.c = bVar;
            i0Var.W(jVar);
            i0Var.V(jVar);
            obj.g(i0Var);
            i.c.a aVar = new i.c.a(obj);
            i0Var.T.c(aVar);
        }

        public static final app.dogo.com.dogo_android.d.b.z.i.b a(app.dogo.com.dogo_android.d.b.z.i.c i$c) {
            return c.c;
        }

        public static final app.dogo.com.dogo_android.d.b.z.j b(app.dogo.com.dogo_android.d.b.z.i.c i$c) {
            return c.b;
        }

        public static void d(app.dogo.com.dogo_android.d.b.z.i.c i$c, View view2) {
            i.c.i(c, view2);
        }

        public static void e(app.dogo.com.dogo_android.d.b.z.i.c i$c, View view2) {
            i.c.h(c, view2);
        }

        private final void g(i0 i0) {
            i0.a0.setOnClickListener(this);
            b bVar = new b(this);
            i0.T.setOnClickListener(bVar);
            i0.d0.setOnClickListener(this);
            i0.Z.setOnClickListener(this);
            i0.R.setOnClickListener(this);
            a aVar = new a(this);
            i0.V.setOnClickListener(aVar);
        }

        private static final void h(app.dogo.com.dogo_android.d.b.z.i.c i$c, View view2) {
            n.f(c, "this$0");
            if (!c.b.isCurrentUserEntriesAuthor()) {
                c.onClick(view2);
            }
        }

        private static final void i(app.dogo.com.dogo_android.d.b.z.i.c i$c, View view2) {
            n.f(c, "this$0");
            if (!c.b.isCurrentUserEntriesAuthor()) {
                c.onClick(view2);
            }
        }

        @Override // h.a.c.b
        public final i0 c() {
            return this.a;
        }

        @Override // h.a.c.b
        public final void f(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, app.dogo.com.dogo_android.d.b.z.i.b i$b3, boolean z4) {
            Object obj3;
            int obj4;
            n.f(challengeEntryModel, "model");
            n.f(b3, "positionTracker");
            this.b.p(challengeEntryModel, challengeModel2, z4);
            this.c = b3;
            l obj5 = new l(challengeEntryModel, 0, 2, 0);
            obj4.T.setAdapter(obj5);
            obj4 = obj4.T.getAdapter();
            n.d(obj4);
            obj4.j();
            if (this.c.a() >= challengeEntryModel.getImageCount()) {
                this.c.b(obj3--);
            }
            obj3.T.setCurrentItem(this.c.a());
            this.a.p();
        }

        @Override // h.a.c.b
        public final void showLikeAnimation(ImageView imageView) {
            n.f(imageView, "imageView");
            imageView.setVisibility(0);
            imageView.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
            i.c.b bVar = new i.c.b(imageView);
            animation.setAnimationListener(bVar);
            imageView.startAnimation(animation);
        }
    }
    static {
        i.a aVar = new i.a(0);
        i.Companion = aVar;
    }

    public i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, boolean z3, String string4) {
        n.f(challengeEntryModel, "model");
        super(0);
        this.a = challengeEntryModel;
        this.b = challengeModel2;
        this.c = z3;
        this.d = string4;
        i.b obj2 = new i.b();
        this.e = obj2;
    }

    public i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, boolean z3, String string4, int i5, g g6) {
        String obj4;
        if (i5 &= 8 != 0) {
            obj4 = challengeEntryModel.getDocumentId();
        }
        super(challengeEntryModel, challengeModel2, z3, obj4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (i.c)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.d.b.z.i.c i$c2, int i3, List<Object> list4) {
        boolean z;
        Object obj2;
        String obj4;
        app.dogo.com.dogo_android.d.b.z.i.b obj5;
        n.f(b, "adapter");
        if (list4 != null && list4.contains(100)) {
            if (list4.contains(100)) {
                if (c2 == null) {
                } else {
                    obj2 = obj2.P;
                    n.e(obj2, "holder.holderBinding.animationLike");
                    c2.showLikeAnimation(obj2);
                }
            }
        }
        if (c2 == null) {
        } else {
            c2.f(this.a, this.b, this.e, this.c);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof i) {
            return n.b(getId(), (i)object.getId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.b.z.i.c f(View view, b<f<RecyclerView.e0>> b2) {
        n.f(b2, "adapter");
        i.c cVar = new i.c(view, (p)b2);
        return cVar;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final String g() {
        return this.a.getImageIdAt(this.e.a());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558462;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final ChallengeEntryModel getModel() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final int h() {
        return this.e.a();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final void i(ChallengeModel challengeModel) {
        this.b = challengeModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final void j(boolean z) {
        this.a.setUserLiked(z);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommentCaptionItem[");
        stringBuilder.append(super.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
