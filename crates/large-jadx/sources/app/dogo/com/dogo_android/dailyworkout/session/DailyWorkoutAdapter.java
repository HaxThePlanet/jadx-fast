package app.dogo.com.dogo_android.f.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.h.a8;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* compiled from: DailyWorkoutAdapter.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ \u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "callback", "Lkotlin/Function1;", "", "", "onSessionFinished", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lkotlin/jvm/functions/Function1;Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;Ljava/util/List;)V", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "objectView", "", "getCount", "getCountWithoutOffset", "getPageTitle", "", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "reachedEmptyViewPlace", "Companion", "OnSessionFinished", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class DailyWorkoutAdapter extends a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    /* renamed from: c, reason: from kotlin metadata */
    private final l<Integer, w> callback;
    /* renamed from: d, reason: from kotlin metadata */
    private final i.b onSessionFinished;
    /* renamed from: e, reason: from kotlin metadata */
    private final List<TrickItem> trickList;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$Companion;", "", "()V", "EMPTY_CARD_COUNT_OFFSET", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "", "finished", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: m1, reason: from kotlin metadata */
        void finished();
    }
    public i(l<? super Integer, w> lVar, i.b bVar, List<TrickItem> list) {
        n.f(lVar, "callback");
        n.f(bVar, "onSessionFinished");
        n.f(list, "trickList");
        super();
        this.callback = lVar;
        this.onSessionFinished = bVar;
        this.trickList = list;
    }

    /* renamed from: u, reason: from kotlin metadata */
    private static final void destroyItem(i container, int position, View objectView) {
        n.f(container, "this$0");
        container.callback.invoke(Integer.valueOf(position));
    }

    /* renamed from: w, reason: from kotlin metadata */
    private final boolean getPageTitle(int position) {
        boolean z = true;
        position = position > p.i(this.trickList) ? 1 : 0;
        return (position > p.i(this.trickList) ? 1 : 0);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object object) {
        n.f(viewGroup, "container");
        n.f(object, "objectView");
        viewGroup.removeView(object);
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: d, reason: from kotlin metadata */
    public int getCount() {
        return this.trickList.size() + 2;
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: f, reason: from kotlin metadata */
    public java.lang.CharSequence getPageWidth(int position) {
        int i = 0;
        Object obj = p.a0(this.trickList, position);
        if (obj == null) {
            i = 0;
        } else {
            String id = obj.getId();
        }
        return i;
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: h, reason: from kotlin metadata */
    public Object instantiateItem(ViewGroup container, int position) {
        n.f(container, "container");
        a8 a8Var = a8.T(LayoutInflater.from(container.getContext()), container, false);
        n.e(a8Var, "inflate(inflater, container, false)");
        View view = a8Var.w();
        n.e(view, "binding.root");
        container.addView(view);
        view.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.session.a(this, position));
        if (getPageTitle(position)) {
            int i = 4;
            a8Var.O.setVisibility(i);
        } else {
            a8Var.V((TrickItem)this.trickList.get(position));
        }
        return view;
    }

    @Override // androidx.viewpager.widget.a
    public final int t() {
        return this.trickList.size();
    }


    public static /* synthetic */ void v(i iVar, int i, View view) {
        DailyWorkoutAdapter.destroyItem(iVar, i, view);
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: g, reason: from kotlin metadata */
    public float reachedEmptyViewPlace(int position) {
        return 1059481190;
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: i, reason: from kotlin metadata */
    public boolean isViewFromObject(View view, Object objectView) {
        boolean z = true;
        n.f(view, "view");
        n.f(objectView, "objectView");
        view = view == objectView ? 1 : 0;
        return (view == objectView ? 1 : 0);
    }
}
