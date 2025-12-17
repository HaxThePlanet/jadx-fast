package app.dogo.com.dogo_android.d.a.n;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.d.a.k;
import app.dogo.com.dogo_android.h.s0;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import h.a.b.b;
import h.a.b.b.p;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u0000 \u001b2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JB\u0010\u0008\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J*\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000bH\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem;", "Leu/davidea/flexibleadapter/items/AbstractFlexibleItem;", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$ChallengeFanEntryViewHolder;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;)V", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "ChallengeFanEntryViewHolder", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends a<app.dogo.com.dogo_android.d.a.n.d.a> {

    public static final app.dogo.com.dogo_android.d.a.n.d.b Companion;
    private final ChallengeEntryVoter a;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$Companion;", "", "()V", "FAN_CLICK_AREA", "", "LIKE_ANIMATION_PAYLOAD", "LIKE_CLICK_AREA", "LIKE_TOGGLE_CLICK_AREA", "PROFILE_CLICK_AREA", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$ChallengeFanEntryViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "(Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem;Landroid/view/View;Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;)V", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeFanEntryItemBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellChallengeFanEntryItemBinding;", "clickListener", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "map", "", "", "", "vm", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListItemObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "showLikeAnimation", "imageView", "Landroid/widget/ImageView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends b {

        private final s0 a;
        private final app.dogo.com.dogo_android.d.a.n.e b;
        private final Map<String, Integer> c;
        private final b.p v;
        public a(app.dogo.com.dogo_android.d.a.n.d d, View view2, k k3) {
            n.f(d, "this$0");
            super(view2, k3);
            n.d(view2);
            s0 obj8 = s0.T(view2);
            n.e(obj8, "bind(view!!)");
            this.a = obj8;
            super(0, 0, 0, 0, 15, 0);
            this.b = obj9;
            HashMap obj10 = new HashMap();
            this.c = obj10;
            obj8.V(obj9);
            obj10 = new b(this);
            obj8.U.setOnClickListener(obj10);
            obj8.W.setOnClickListener(this);
            obj8.Y.setOnClickListener(this);
            d.a.a obj9 = new d.a.a(this);
            obj8.R.c(obj9);
            obj8 = new a(this);
            this.v = obj8;
        }

        private static final void a(app.dogo.com.dogo_android.d.a.n.d.a d$a, View view2) {
            boolean z;
            int currentItem;
            n.f(a, "this$0");
            if (a.b.i()) {
            }
            if (a.b.h()) {
                a.b.l(s0Var.R.getCurrentItem());
                a.onClick(view2);
            }
        }

        private static final boolean b(app.dogo.com.dogo_android.d.a.n.d.a d$a, View view2, int i3) {
            int currentItem;
            boolean obj4;
            n.f(a, "this$0");
            final int i = 1;
            if (s0Var.R.getCurrentItem() != i3) {
                obj2.R.setCurrentItem(i3);
                return i;
            }
            if (a.b.i()) {
                return 0;
            }
            if (a.b.j()) {
                a.b.l(s0Var2.R.getCurrentItem());
                a.onClick(view2);
            }
            return i;
        }

        public static final Map c(app.dogo.com.dogo_android.d.a.n.d.a d$a) {
            return a.c;
        }

        public static final app.dogo.com.dogo_android.d.a.n.e d(app.dogo.com.dogo_android.d.a.n.d.a d$a) {
            return a.b;
        }

        public static boolean f(app.dogo.com.dogo_android.d.a.n.d.a d$a, View view2, int i3) {
            return d.a.b(a, view2, i3);
        }

        public static void g(app.dogo.com.dogo_android.d.a.n.d.a d$a, View view2) {
            d.a.a(a, view2);
        }

        @Override // h.a.c.b
        public final s0 e() {
            return this.a;
        }

        @Override // h.a.c.b
        public final void h(ChallengeEntryVoter challengeEntryVoter) {
            int intValue;
            String str;
            n.f(challengeEntryVoter, "model");
            this.b.k(challengeEntryVoter);
            app.dogo.com.dogo_android.model.ChallengeEntryModel obj4 = challengeEntryVoter.getVoterEntryModel();
            n.d(obj4);
            g gVar = new g(obj4, this.v);
            s0Var.R.setAdapter(gVar);
            if (this.c.get(this.b.c()) != null) {
                Object obj2 = this.c.get(this.b.c());
                n.d(obj2);
                intValue = (Number)obj2.intValue();
            } else {
                intValue = 0;
            }
            obj4.R.setCurrentItem(intValue);
        }

        @Override // h.a.c.b
        public final void showLikeAnimation(ImageView imageView) {
            n.f(imageView, "imageView");
            imageView.setVisibility(0);
            imageView.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
            d.a.b bVar = new d.a.b(imageView);
            animation.setAnimationListener(bVar);
            imageView.startAnimation(animation);
        }
    }
    static {
        d.b bVar = new d.b(0);
        d.Companion = bVar;
    }

    public d(ChallengeEntryVoter challengeEntryVoter) {
        n.f(challengeEntryVoter, "model");
        super();
        this.a = challengeEntryVoter;
    }

    @Override // h.a.b.h.a
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (d.a)e02, i3, list4);
    }

    @Override // h.a.b.h.a
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<?>> b, app.dogo.com.dogo_android.d.a.n.d.a d$a2, int i3, List<? extends Object> list4) {
        String obj1;
        String obj3;
        n.f(a2, "holder");
        if (list4 != null && list4.contains(100)) {
            if (list4.contains(100)) {
                obj1 = obj1.Q;
                n.e(obj1, "holder.binding.animationLike");
                a2.showLikeAnimation(obj1);
            }
        }
        a2.h(this.a);
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof d) {
            return n.b(this.a.getVoterId(), object.a.getVoterId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.a.n.d.a f(View view, b<f<?>> b2) {
        n.f(view, "view");
        d.a aVar = new d.a(this, view, (k)b2);
        return aVar;
    }

    @Override // h.a.b.h.a
    public final ChallengeEntryVoter g() {
        return this.a;
    }

    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return 2131558467;
    }
}
