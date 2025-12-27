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
import h.a.b.b.p;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeFanListEntryItem.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u0000 \u001b2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JB\u0010\u0008\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J*\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c\u0018\u00010\u000bH\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem;", "Leu/davidea/flexibleadapter/items/AbstractFlexibleItem;", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$ChallengeFanEntryViewHolder;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;)V", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "holder", "position", "", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "ChallengeFanEntryViewHolder", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ChallengeFanListEntryItem extends a<d.a> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final d.b INSTANCE = new d$b(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeEntryVoter model;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$Companion;", "", "()V", "FAN_CLICK_AREA", "", "LIKE_ANIMATION_PAYLOAD", "LIKE_CLICK_AREA", "LIKE_TOGGLE_CLICK_AREA", "PROFILE_CLICK_AREA", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem$ChallengeFanEntryViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "(Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListEntryItem;Landroid/view/View;Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;)V", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeFanEntryItemBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellChallengeFanEntryItemBinding;", "clickListener", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "map", "", "", "", "vm", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListItemObservable;", "setModel", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "showLikeAnimation", "imageView", "Landroid/widget/ImageView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends h.a.c.b {

        private final s0 a;
        /* renamed from: b, reason: from kotlin metadata */
        private final e clickListener;
        private final Map<String, Integer> c = new HashMap<>();
        private final b.p v = new a();
        public a(View view, k kVar) {
            n.f(dVar, "this$0");
            super(view, kVar);
            n.d(view);
            s0 s0Var = s0.T(view);
            n.e(s0Var, "bind(view!!)");
            this.a = s0Var;
            super(null, null, null, null, 15, null);
            this.clickListener = view22;
            HashMap hashMap = new HashMap();
            s0Var.V(view22);
            s0Var.U.setOnClickListener(new app.dogo.com.dogo_android.challenge.challengefanlist.fanlist.b(this));
            s0Var.W.setOnClickListener(this);
            s0Var.Y.setOnClickListener(this);
            s0Var.R.c(new ChallengeFanListEntryItem_ChallengeFanEntryViewHolder_2(this));
            app.dogo.com.dogo_android.d.a.n.a aVar = new app.dogo.com.dogo_android.challenge.challengefanlist.fanlist.a(this);
        }

        private static final void a(d.a aVar, View view) {
            n.f(aVar, "this$0");
            if (aVar.clickListener.i()) {
                return;
            }
            if (aVar.clickListener.h()) {
                aVar.clickListener.setSelectedPage(aVar.e().R.getCurrentItem());
                aVar.onClick(view);
            }
        }

        private static final boolean b(d.a aVar, View view, int i) {
            n.f(aVar, "this$0");
            final boolean z2 = true;
            if (aVar.e().R.getCurrentItem() != i) {
                aVar.e().R.setCurrentItem(i);
                return true;
            }
            if (aVar.clickListener.i()) {
                return false;
            }
            if (aVar.clickListener.j()) {
                aVar.clickListener.setSelectedPage(aVar.e().R.getCurrentItem());
                aVar.onClick(view);
            }
            return true;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public static final /* synthetic */ Map setModel(d.a model) {
            return model.c;
        }

        /* renamed from: d, reason: from kotlin metadata */
        public static final /* synthetic */ e showLikeAnimation(d.a imageView) {
            return imageView.clickListener;
        }

        @Override // h.a.c.b
        public final s0 e() {
            return this.a;
        }

        @Override // h.a.c.b
        public final void h(ChallengeEntryVoter challengeEntryVoter) {
            int intValue = 0;
            n.f(challengeEntryVoter, "model");
            this.clickListener.setModel(challengeEntryVoter);
            app.dogo.com.dogo_android.model.ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
            n.d(voterEntryModel);
            this.a.R.setAdapter(new EntryFanImagePagerAdapter(voterEntryModel, this.v));
            if (this.c.get(this.clickListener.c()) != null) {
                Object value2 = this.c.get(this.clickListener.c());
                n.d(value2);
                intValue = value2.intValue();
            } else {
                intValue = 0;
            }
            this.a.R.setCurrentItem(intValue);
        }

        @Override // h.a.c.b
        public final void showLikeAnimation(ImageView imageView) throws android.content.res.Resources.NotFoundException {
            n.f(imageView, "imageView");
            imageView.setVisibility(0);
            imageView.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
            animation.setAnimationListener(new ChallengeFanListEntryItem_ChallengeFanEntryViewHolder_showLikeAnimation_1(imageView));
            imageView.startAnimation(animation);
        }

        public static /* synthetic */ boolean f(d.a aVar, View view, int i) {
            return ChallengeFanListEntryItem_ChallengeFanEntryViewHolder.b(aVar, view, i);
        }

        public static /* synthetic */ void g(d.a aVar, View view) {
            ChallengeFanListEntryItem_ChallengeFanEntryViewHolder.a(aVar, view);
        }
    }
    public d(ChallengeEntryVoter challengeEntryVoter) {
        n.f(challengeEntryVoter, "model");
        super();
        this.model = challengeEntryVoter;
    }

    @Override // h.a.b.h.a
    public void e(h.a.b.b<f<?>> bVar, d.a aVar, int i, List<? extends Object> list) {
        str = "holder";
        n.f(aVar, str);
        if (list != null) {
            if (list.contains(100)) {
                str2 = "holder.binding.animationLike";
                n.e(imageView, str2);
                aVar.showLikeAnimation(imageView);
            }
        }
        aVar.h(this.model);
    }

    @Override // h.a.b.h.a
    /* operator */ public boolean equals(Object other) {
        if (other instanceof ChallengeFanListEntryItem) {
            return n.b(this.model.getVoterId(), other.model.getVoterId());
        }
        return false;
    }

    @Override // h.a.b.h.a
    public d.a f(View view, h.a.b.b<f<?>> bVar) {
        n.f(view, "view");
        return new ChallengeFanListEntryItem_ChallengeFanEntryViewHolder(this, view, bVar);
    }

    @Override // h.a.b.h.a
    /* renamed from: g, reason: from kotlin metadata */
    public final ChallengeEntryVoter getLayoutRes() {
        return this.model;
    }


    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return R.layout.cell_challenge_fan_entry_item;
    }
}
