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
import h.a.b.h.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeCommentCaptionItem.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 .2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0003./0B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rJ>\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u00040\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00172\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J&\u0010$\u001a\u00020\u00022\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u00040\u001dH\u0016J\u0013\u0010'\u001a\u00020\n2\u0008\u0010(\u001a\u0004\u0018\u00010#H\u0096\u0002J\u0008\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008J\u0008\u0010+\u001a\u00020\u000cH\u0016J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\nR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "isPremium", "", "id", "", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Lapp/dogo/com/dogo_android/model/ChallengeModel;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "lastSelectedCaptionPhotoPosition", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$PositionTracker;", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "getPhotoId", "photoPosition", "", "getPhotoPosition", "()I", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "setChallengeModel", "toString", "updateLikeState", "state", "Companion", "PositionTracker", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class ChallengeCommentCaptionItem extends EntryItem<i.c, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<i.c> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeEntryModel challengeModel;
    /* renamed from: b, reason: from kotlin metadata */
    private ChallengeModel isPremium;
    /* renamed from: c, reason: from kotlin metadata */
    private final boolean lastSelectedCaptionPhotoPosition;
    private final String d;
    private final i.b e;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem$Companion;", "", "()V", "CAPTION_CHALLENGE_TITLE", "", "CAPTION_FAN_CLICK_AREA", "CAPTION_IMAGE_CLICK_AREA", "CAPTION_LIKE_CLICK_AREA", "CAPTION_PROFILE_ICON", "CAPTION_REPORT_CLICK_AREA", "LIKE_ANIMATION_PAYLOAD", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
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
    public static final class c extends h.a.c.b {

        private final i0 a;
        /* renamed from: b, reason: from kotlin metadata */
        private final j posTracker;
        private i.b c;
        public c(View view, p<?> pVar) {
            final Object view2 = this;
            super(view, pVar);
            n.d(view);
            i0 i0Var = i0.T(view);
            n.e(i0Var, "bind(view!!)");
            view2.a = i0Var;
            super(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
            view2.posTracker = challengeCommentCaptionObservable;
            view2.c = new ChallengeCommentCaptionItem_PositionTracker();
            i0Var.W(challengeCommentCaptionObservable);
            i0Var.V(challengeCommentCaptionObservable);
            view2.g(i0Var);
            i0Var.T.c(new ChallengeCommentCaptionItem_ViewHolder_1(view2));
        }

        /* renamed from: a, reason: from kotlin metadata */
        public static final /* synthetic */ i.b setupEntryCell(i.c binding) {
            return binding.c;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public static final /* synthetic */ j showLikeAnimation(i.c imageView) {
            return imageView.posTracker;
        }

        private final void g(i0 i0Var) {
            i0Var.a0.setOnClickListener(this);
            i0Var.T.setOnClickListener(new app.dogo.com.dogo_android.challenge.comments.listitems.b(this));
            i0Var.d0.setOnClickListener(this);
            i0Var.Z.setOnClickListener(this);
            i0Var.R.setOnClickListener(this);
            i0Var.V.setOnClickListener(new app.dogo.com.dogo_android.challenge.comments.listitems.a(this));
        }

        private static final void h(i.c cVar, View view) {
            n.f(cVar, "this$0");
            if (!cVar.posTracker.isCurrentUserEntriesAuthor()) {
                cVar.onClick(view);
            }
        }

        private static final void i(i.c cVar, View view) {
            n.f(cVar, "this$0");
            if (!cVar.posTracker.isCurrentUserEntriesAuthor()) {
                cVar.onClick(view);
            }
        }

        @Override // h.a.c.b
        public final i0 c() {
            return this.a;
        }

        @Override // h.a.c.b
        /* renamed from: f, reason: from kotlin metadata */
        public final void setModel(ChallengeEntryModel model, ChallengeModel challengeModel, i.b positionTracker, boolean isPremium) {
            n.f(model, "model");
            n.f(positionTracker, "positionTracker");
            this.posTracker.p(model, challengeModel, isPremium);
            this.c = positionTracker;
            this.a.T.setAdapter(new EntryImagePagerAdapter(model, false, 2, null));
            a adapter = this.a.T.getAdapter();
            n.d(adapter);
            adapter.j();
            if (this.c.a() >= model.getImageCount()) {
                i = model.getImageCount() - 1;
                this.c.b(i);
            }
            this.a.T.setCurrentItem(this.c.a());
            this.a.p();
        }

        @Override // h.a.c.b
        public final void showLikeAnimation(ImageView imageView) throws android.content.res.Resources.NotFoundException {
            n.f(imageView, "imageView");
            imageView.setVisibility(0);
            imageView.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
            animation.setAnimationListener(new ChallengeCommentCaptionItem_ViewHolder_showLikeAnimation_1(imageView));
            imageView.startAnimation(animation);
        }

        public static /* synthetic */ void d(i.c cVar, View view) {
            ChallengeCommentCaptionItem_ViewHolder.i(cVar, view);
        }

        public static /* synthetic */ void e(i.c cVar, View view) {
            ChallengeCommentCaptionItem_ViewHolder.h(cVar, view);
        }
    }
    public /* synthetic */ i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel, boolean z, String str, int i, g gVar) {
        String documentId;
        if (i & 8 != 0) {
            documentId = challengeEntryModel.getDocumentId();
        }
        this(challengeEntryModel, challengeModel, z, documentId);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void e(h.a.b.b<f<RecyclerView.e0>> bVar, i.c cVar, int i, List<Object> list) {
        boolean contains;
        String str;
        str = "adapter";
        n.f(bVar, str);
        if (list != null && list.contains(Integer.valueOf(100))) {
            if (cVar != null) {
                str = "holder.holderBinding.animationLike";
                n.e(imageView, str);
                cVar.showLikeAnimation(imageView);
            }
        }
        if (cVar != null) {
            cVar.setModel(this.challengeModel, this.isPremium, this.e, this.lastSelectedCaptionPhotoPosition);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        if (other instanceof ChallengeCommentCaptionItem) {
            return n.b(getId(), other.getId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public i.c f(View view, h.a.b.b<f<RecyclerView.e0>> bVar) {
        n.f(bVar, "adapter");
        return new ChallengeCommentCaptionItem_ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: g, reason: from kotlin metadata */
    public final String getLayoutRes() {
        return this.challengeModel.getImageIdAt(this.e.a());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final ChallengeEntryModel getModel() {
        return this.challengeModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final int h() {
        return this.e.a();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: i, reason: from kotlin metadata */
    public final void setChallengeModel(ChallengeModel challengeModel) {
        this.isPremium = challengeModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: j, reason: from kotlin metadata */
    public final void updateLikeState(boolean state) {
        this.challengeModel.setUserLiked(state);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CommentCaptionItem[";
        String object = super.toString();
        str = str2 + object + 93;
        return str;
    }

    public i(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel, boolean z, String str) {
        n.f(challengeEntryModel, "model");
        super(null);
        this.challengeModel = challengeEntryModel;
        this.isPremium = challengeModel;
        this.lastSelectedCaptionPhotoPosition = z;
        this.d = str;
        this.e = new ChallengeCommentCaptionItem_PositionTracker();
    }


    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_comment_caption_item;
    }
}
