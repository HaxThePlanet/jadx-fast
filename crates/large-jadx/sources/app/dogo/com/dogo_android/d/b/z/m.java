package app.dogo.com.dogo_android.d.b.z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.m0;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0001\"B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0004\u0018\u00010\u00112\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J(\u0010\u0018\u001a\u00020\u00022\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0004\u0018\u00010\u0011H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u001e\u001a\u00020\tH\u0016J\u0008\u0010\u001f\u001a\u00020\u000bH\u0016J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\tR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;)V", "count", "", "id", "", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "toString", "updateCommentCount", "newCount", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends EntryItem<app.dogo.com.dogo_android.d.b.z.m.a, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<app.dogo.com.dogo_android.d.b.z.m.a> {

    private final ChallengeEntryModel a;
    private int b;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentsTitleBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "count", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {

        private final m0 a;
        private final app.dogo.com.dogo_android.d.b.z.n b;
        public a(View view, b<?> b2) {
            super(view, b2);
            n.d(view);
            final m0 obj1 = m0.T(view);
            n.e(obj1, "bind(view!!)");
            this.a = obj1;
            n obj2 = new n();
            this.b = obj2;
            obj1.V(obj2);
        }

        @Override // h.a.c.b
        public final void a(ChallengeEntryModel challengeEntryModel, int i2) {
            this.b.b(challengeEntryModel, i2);
        }
    }
    public m(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "model");
        super();
        this.a = challengeEntryModel;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (m.a)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.d.b.z.m.a m$a2, int i3, List<Object> list4) {
        ChallengeEntryModel obj1;
        int obj3;
        if (a2 == null) {
        } else {
            a2.a(this.a, this.b);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof m) {
            return n.b(getId(), (m)object.getId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.b.z.m.a f(View view, b<f<RecyclerView.e0>> b2) {
        m.a aVar = new m.a(view, b2);
        return aVar;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final void g(int i) {
        this.b = i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return n.o("CommentTitleItem", this.a.getDocumentId());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558464;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommentTitleItem[");
        stringBuilder.append(super.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
