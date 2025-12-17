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
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 %2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0004:\u0002%&B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ@\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0004\u0018\u00010\u00152\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J(\u0010\u001d\u001a\u00020\u00022\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010 \u001a\u00020\u00082\u0008\u0010!\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\"\u001a\u00020\u0019H\u0016J\u0006\u0010#\u001a\u00020\u0013J\u0008\u0010$\u001a\u00020\u000bH\u0017R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/IFlexible;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "marked", "", "(Lapp/dogo/com/dogo_android/model/ChallengeComment;Z)V", "id", "", "getId", "()Ljava/lang/String;", "getMarked", "()Z", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeComment;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "markItemAsSpam", "toString", "Companion", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends EntryItem<app.dogo.com.dogo_android.d.b.z.k.b, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements f<app.dogo.com.dogo_android.d.b.z.k.b> {

    public static final app.dogo.com.dogo_android.d.b.z.k.a Companion;
    private final ChallengeComment a;
    private final boolean b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$Companion;", "", "()V", "COMMENT_DELETE_CLICK_AREA", "", "COMMENT_PROFILE_ICON_CLICK_AREA", "COMMENT_REPLY_CLICK_AREA", "COMMENT_REPORT_CLICK_AREA", "COMMUNITY_RULES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000cR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeCommentItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItemObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "isMarked", "", "updateTimeStamp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {

        private final k0 a;
        private final app.dogo.com.dogo_android.d.b.z.l b;
        public b(View view, p<?> p2) {
            n.f(p2, "adapter");
            super(view, p2);
            n.d(view);
            k0 obj13 = k0.T(view);
            n.e(obj13, "bind(view!!)");
            this.a = obj13;
            super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
            this.b = lVar;
            obj13.V(lVar);
            obj13.Y.setOnClickListener(this);
            obj13.Z.setOnClickListener(this);
            obj13.T.setOnClickListener(this);
            obj13.a0.setOnClickListener(this);
            obj13.S.setOnClickListener(this);
            f fVar = new f(this);
            obj13.U.setOnClickListener(fVar);
            lVar.E(p2.d2().getTag());
            k.b.a obj14 = new k.b.a(this);
            obj13.Q.addTextChangedListener(obj14);
        }

        private static final void a(app.dogo.com.dogo_android.d.b.z.k.b k$b, View view2) {
            Object obj0;
            n.f(b, "this$0");
            if (!b.b.y()) {
                b.b.B();
            }
        }

        public static final k0 b(app.dogo.com.dogo_android.d.b.z.k.b k$b) {
            return b.a;
        }

        public static void c(app.dogo.com.dogo_android.d.b.z.k.b k$b, View view2) {
            k.b.a(b, view2);
        }

        @Override // h.a.c.b
        public final void d(ChallengeComment challengeComment, boolean z2) {
            this.b.D(challengeComment);
            this.b.C(z2);
            this.a.p();
        }

        @Override // h.a.c.b
        public final void e() {
            this.b.G();
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.Companion = aVar;
    }

    public k(ChallengeComment challengeComment, boolean z2) {
        n.f(challengeComment, "model");
        super();
        this.a = challengeComment;
        this.b = z2;
    }

    public k(ChallengeComment challengeComment, boolean z2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(challengeComment, obj2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (k.b)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.d.b.z.k.b k$b2, int i3, List<Object> list4) {
        ChallengeComment obj1;
        boolean obj3;
        if (b2 == null) {
        } else {
            b2.d(this.a, this.b);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        Object obj2;
        Object obj;
        String str;
        boolean obj3;
        if (object instanceof k) {
            obj = object;
            if (getId() != null && (k)obj.getId() != null) {
                obj = object;
                if ((k)obj.getId() != null) {
                    obj3 = n.b(getId(), obj.getId());
                } else {
                    obj3 = n.b(this.a, object.a);
                }
            } else {
            }
            return obj3;
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.b.z.k.b f(View view, b<f<RecyclerView.e0>> b2) {
        Objects.requireNonNull(b2, "null cannot be cast to non-null type app.dogo.com.dogo_android.util.base_classes.BaseNavComponentFlexibleAdapter<*>");
        k.b bVar = new k.b(view, (p)b2);
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final ChallengeComment g() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.a.getDocumentId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558463;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public final void h() {
        this.a.setMarked(ChallengeComment.MarkTypes.SPAM.getIdentifier());
        this.a.setPublished(false);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommentItem[");
        stringBuilder.append(super.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
