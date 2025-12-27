package app.dogo.com.dogo_android.util.n0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.qn;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;
import app.dogo.com.dogo_android.util.e0.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChallengeViewPagerCardAdapter.java */
/* loaded from: classes.dex */
public class g extends a {

    private List<qn> c = new ArrayList<>();
    private float d;
    private List<ChallengePagerCardItem> e = new ArrayList<>();
    private g0 f;
    private a0 g;
    public g(g0 g0Var, a0 a0Var) {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f = g0Var;
        this.g = a0Var;
    }

    private /* synthetic */ void A(ChallengePagerCardItem challengePagerCardItem, int i, View view) {
        this.f.Z1(challengePagerCardItem.getModel(), this.g, i);
    }

    private void u(ChallengePagerCardItem challengePagerCardItem, qn qnVar, int i) {
        qnVar.V(challengePagerCardItem);
        qnVar.O.setOnClickListener(new app.dogo.com.dogo_android.util.recycle_views.b(this, challengePagerCardItem, i));
    }

    @Override // androidx.viewpager.widget.a
    public void C(ChallengeModel challengeModel) {
        boolean equals;
        String str;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.id.equals(challengeModel.getId())) {
                item.refreshCard(challengeModel);
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public void D(int i) {
        this.f.C((ChallengePagerCardItem)this.e.get(i).getModel());
    }

    @Override // androidx.viewpager.widget.a
    public void E() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            (ChallengePagerCardItem)it.next().updateView();
        }
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object object) {
        viewGroup.removeView(object);
        this.c.set(i, null);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.e.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i) {
        qn qnVar = qn.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        viewGroup.addView(qnVar.w());
        u((ChallengePagerCardItem)this.e.get(i), qnVar, i);
        if (this.d == 0) {
            this.d = qnVar.O.getCardElevation();
        }
        qnVar.O.setMaxCardElevation(this.d * 3f);
        this.c.set(i, qnVar);
        return qnVar.w();
    }

    @Override // androidx.viewpager.widget.a
    public boolean t(List<ChallengeModel> list) {
        boolean empty2 = this.e.isEmpty();
        final int i = 0;
        if (list != null && !list.isEmpty()) {
            this.c.addAll(new ArrayList(Collections.nCopies(list.size(), null)));
            final Iterator it = list.iterator();
            while (it.hasNext()) {
                this.e.add(new ChallengePagerCardItem((ChallengeModel)it.next()));
            }
            if (empty2) {
                D(i);
            }
            return this.e.isEmpty();
        }
        return false;
    }

    @Override // androidx.viewpager.widget.a
    public void v() {
        this.c.clear();
        this.e.clear();
    }

    @Override // androidx.viewpager.widget.a
    public int w(ChallengeModel challengeModel) {
        int i = 0;
        Iterator it = this.e.iterator();
        i = 0;
        while (it.hasNext()) {
            if ((ChallengePagerCardItem)it.next().getModel().getId().equals(challengeModel.getId())) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.a
    public int x(String str) {
        int i = 0;
        Iterator it = this.e.iterator();
        i = 0;
        while (it.hasNext()) {
            if ((ChallengePagerCardItem)it.next().getModel().getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.a
    public int y() {
        return this.e.size();
    }

    @Override // androidx.viewpager.widget.a
    public ChallengePagerCardItem z(int i) {
        return (ChallengePagerCardItem)this.e.get(i);
    }

    @Override // androidx.viewpager.widget.a
    public /* synthetic */ void B(ChallengePagerCardItem challengePagerCardItem, int i, View view) {
        A(challengePagerCardItem, i, view);
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object object) {
        boolean z = true;
        view = view == object ? 1 : 0;
        return (view == object ? 1 : 0);
    }
}
