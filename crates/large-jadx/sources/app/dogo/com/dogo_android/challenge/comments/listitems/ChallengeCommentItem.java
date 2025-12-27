package app.dogo.com.dogo_android.d.b.z;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.k0;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeComment.MarkTypes;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.util.e0.p;
import com.google.firebase.database.annotations.NotNull;
import h.a.b.h.f;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeCommentItem.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 %2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0002%&B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ@\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0004\u0018\u00010\u00152\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J(\u0010\u001d\u001a\u00020\u00022\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010 \u001a\u00020\u00082\u0008\u0010!\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\"\u001a\u00020\u0019H\u0016J\u0006\u0010#\u001a\u00020\u0013J\u0008\u0010$\u001a\u00020\u000bH\u0017R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "marked", "", "(Lapp/dogo/com/dogo_android/model/ChallengeComment;Z)V", "id", "", "getId", "()Ljava/lang/String;", "getMarked", "()Z", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeComment;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "markItemAsSpam", "toString", "Companion", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ChallengeCommentItem extends EntryItem<k.b, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<k.b> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final k.a INSTANCE = new k$a(0);
    private final ChallengeComment a;
    private final boolean b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$Companion;", "", "()V", "COMMENT_DELETE_CLICK_AREA", "", "COMMENT_PROFILE_ICON_CLICK_AREA", "COMMENT_REPLY_CLICK_AREA", "COMMENT_REPORT_CLICK_AREA", "COMMUNITY_RULES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000cR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItemObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "isMarked", "", "updateTimeStamp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends h.a.c.b {

        /* renamed from: a, reason: from kotlin metadata */
        private final k0 holderBinding;
        private final l b;
        public b(View view, p<?> pVar) {
            n.f(pVar, "adapter");
            super(view, pVar);
            n.d(view);
            k0 k0Var = k0.T(view);
            n.e(k0Var, "bind(view!!)");
            this.holderBinding = k0Var;
            super(null, null, null, null, null, null, null, null, 255, null);
            this.b = challengeCommentItemObservable;
            k0Var.V(challengeCommentItemObservable);
            k0Var.Y.setOnClickListener(this);
            k0Var.Z.setOnClickListener(this);
            k0Var.T.setOnClickListener(this);
            k0Var.a0.setOnClickListener(this);
            k0Var.S.setOnClickListener(this);
            k0Var.U.setOnClickListener(new app.dogo.com.dogo_android.challenge.comments.listitems.f(this));
            challengeCommentItemObservable.E(pVar.d2().getTag());
            k0Var.Q.addTextChangedListener(new ChallengeCommentItem_ViewHolder_2(this));
        }

        /* renamed from: a, reason: from kotlin metadata */
        private static final void setModel(k.b model, View isMarked) {
            n.f(model, "this$0");
            if (!model.b.y()) {
                model.b.B();
            }
        }

        public static final /* synthetic */ k0 b(k.b bVar) {
            return bVar.holderBinding;
        }

        @Override // h.a.c.b
        public final void d(ChallengeComment challengeComment, boolean z) {
            this.b.D(challengeComment);
            this.b.setSpinnerVisibility(z);
            this.holderBinding.p();
        }

        @Override // h.a.c.b
        /* renamed from: e, reason: from kotlin metadata */
        public final void updateTimeStamp() {
            this.b.G();
        }

        public static /* synthetic */ void c(k.b bVar, View view) {
            ChallengeCommentItem_ViewHolder.setModel(bVar, view);
        }
    }
    public k(ChallengeComment challengeComment, boolean z) {
        n.f(challengeComment, "model");
        super();
        this.a = challengeComment;
        this.b = z;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void e(h.a.b.b<f<RecyclerView.e0>> bVar, k.b bVar2, int i, List<Object> list) {
        if (bVar2 != null) {
            bVar2.d(this.a, this.b);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        String str2;
        boolean z;
        if (other instanceof ChallengeCommentItem && this.getId() != null) {
            Object other2 = other;
            if (other2.getId() != null) {
                z = n.b(getId(), other2.getId());
            } else {
                z = n.b(this.a, other.a);
            }
            return z;
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public k.b f(View view, h.a.b.b<f<RecyclerView.e0>> bVar) {
        Objects.requireNonNull(bVar, "null cannot be cast to non-null type app.dogo.com.dogo_android.util.base_classes.BaseNavComponentFlexibleAdapter<*>");
        return new ChallengeCommentItem_ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: g, reason: from kotlin metadata */
    public final ChallengeComment getLayoutRes() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.a.getDocumentId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final void h() {
        this.a.setMarked(ChallengeComment_MarkTypes.SPAM.getIdentifier());
        this.a.setPublished(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CommentItem[";
        String object = super.toString();
        str = str2 + object + 93;
        return str;
    }

    public /* synthetic */ k(ChallengeComment challengeComment, boolean z, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(challengeComment, z);
    }


    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_comment_item;
    }
}
