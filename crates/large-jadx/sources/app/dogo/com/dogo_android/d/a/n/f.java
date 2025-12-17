package app.dogo.com.dogo_android.d.a.n;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.d.a.k;
import app.dogo.com.dogo_android.h.u0;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u0000 \u001b2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J@\u0010\u0008\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J*\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000bH\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListSimpleItem;", "Leu/davidea/flexibleadapter/items/AbstractFlexibleItem;", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListSimpleItem$ChallengeFanSimpleViewHolder;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;)V", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "ChallengeFanSimpleViewHolder", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends a<app.dogo.com.dogo_android.d.a.n.f.a> {

    public static final app.dogo.com.dogo_android.d.a.n.f.b Companion;
    private final ChallengeEntryVoter a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListSimpleItem$Companion;", "", "()V", "PROFILE_CLICK_AREA", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListSimpleItem$ChallengeFanSimpleViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "(Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListSimpleItem;Landroid/view/View;Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;)V", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeFanItemBinding;", "vm", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListItemObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends b {

        private final u0 a;
        private final app.dogo.com.dogo_android.d.a.n.e b;
        public a(app.dogo.com.dogo_android.d.a.n.f f, View view2, k k3) {
            n.f(f, "this$0");
            super(view2, k3);
            n.d(view2);
            u0 obj8 = u0.T(view2);
            n.e(obj8, "bind(view!!)");
            this.a = obj8;
            super(0, 0, 0, 0, 15, 0);
            this.b = obj9;
            obj8.V(obj9);
            obj8.S.setOnClickListener(this);
        }

        @Override // h.a.c.b
        public final void a(ChallengeEntryVoter challengeEntryVoter) {
            this.b.k(challengeEntryVoter);
        }
    }
    static {
        f.b bVar = new f.b(0);
        f.Companion = bVar;
    }

    public f(ChallengeEntryVoter challengeEntryVoter) {
        n.f(challengeEntryVoter, "model");
        super();
        this.a = challengeEntryVoter;
    }

    @Override // h.a.b.h.a
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (f.a)e02, i3, list4);
    }

    @Override // h.a.b.h.a
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<?>> b, app.dogo.com.dogo_android.d.a.n.f.a f$a2, int i3, List<? extends Object> list4) {
        n.f(a2, "holder");
        n.f(list4, "payloads");
        a2.a(this.a);
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof f) {
            return n.b(this.a.getVoterId(), object.a.getVoterId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.a.n.f.a f(View view, b<f<?>> b2) {
        n.f(view, "view");
        f.a aVar = new f.a(this, view, (k)b2);
        return aVar;
    }

    @Override // h.a.b.h.a
    public final ChallengeEntryVoter g() {
        return this.a;
    }

    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return 2131558468;
    }
}
