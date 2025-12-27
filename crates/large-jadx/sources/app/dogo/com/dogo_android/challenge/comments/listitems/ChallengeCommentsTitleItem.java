package app.dogo.com.dogo_android.d.b.z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.m0;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import h.a.b.h.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeCommentsTitleItem.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0001\"B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0004\u0018\u00010\u00112\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J(\u0010\u0018\u001a\u00020\u00022\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0004\u0018\u00010\u0011H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u001e\u001a\u00020\tH\u0016J\u0008\u0010\u001f\u001a\u00020\u000bH\u0016J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\tR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;)V", "count", "", "id", "", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "toString", "updateCommentCount", "newCount", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ChallengeCommentsTitleItem extends EntryItem<m.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<m.a> {

    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeEntryModel count;
    /* renamed from: b, reason: from kotlin metadata */
    private int model;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentsTitleBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "count", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends h.a.c.b {

        /* renamed from: a, reason: from kotlin metadata */
        private final m0 holderBinding;
        private final n b = new n();
        public a(View view, h.a.b.b<?> bVar) {
            super(view, bVar);
            n.d(view);
            final m0 m0Var = m0.T(view);
            n.e(m0Var, "bind(view!!)");
            this.holderBinding = m0Var;
            m0Var.V(new ChallengeCommentsTitleObservable());
        }

        @Override // h.a.c.b
        /* renamed from: a, reason: from kotlin metadata */
        public final void setModel(ChallengeEntryModel model, int count) {
            this.b.b(model, count);
        }
    }
    public m(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "model");
        super();
        this.count = challengeEntryModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void e(h.a.b.b<f<RecyclerView.e0>> bVar, m.a aVar, int i, List<Object> list) {
        if (aVar != null) {
            aVar.setModel(this.count, this.model);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        if (other instanceof ChallengeCommentsTitleItem) {
            return n.b(getId(), other.getId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public m.a f(View view, h.a.b.b<f<RecyclerView.e0>> bVar) {
        return new ChallengeCommentsTitleItem_ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* renamed from: g, reason: from kotlin metadata */
    public final void updateCommentCount(int newCount) {
        this.model = newCount;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return n.o("CommentTitleItem", this.count.getDocumentId());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CommentTitleItem[";
        String object = super.toString();
        str = str2 + object + 93;
        return str;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_comments_title;
    }
}
