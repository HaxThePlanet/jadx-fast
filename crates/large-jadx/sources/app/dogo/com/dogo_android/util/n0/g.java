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

/* loaded from: classes.dex */
public class g extends a {

    private List<qn> c;
    private float d;
    private List<ChallengePagerCardItem> e;
    private g0 f;
    private a0 g;
    public g(g0 g0, a0 a02) {
        super();
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        this.f = g0;
        this.g = a02;
    }

    private void A(ChallengePagerCardItem challengePagerCardItem, int i2, View view3) {
        this.f.Z1(challengePagerCardItem.getModel(), this.g, i2);
    }

    private void u(ChallengePagerCardItem challengePagerCardItem, qn qn2, int i3) {
        qn2.V(challengePagerCardItem);
        b bVar = new b(this, challengePagerCardItem, i3);
        qn2.O.setOnClickListener(bVar);
    }

    @Override // androidx.viewpager.widget.a
    public void B(ChallengePagerCardItem challengePagerCardItem, int i2, View view3) {
        A(challengePagerCardItem, i2, view3);
    }

    @Override // androidx.viewpager.widget.a
    public void C(ChallengeModel challengeModel) {
        Object next;
        boolean equals;
        String str;
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next.id.equals(challengeModel.getId())) {
                break;
            } else {
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public void D(int i) {
        this.f.C((ChallengePagerCardItem)this.e.get(i).getModel());
    }

    @Override // androidx.viewpager.widget.a
    public void E() {
        Object next;
        Iterator iterator = this.e.iterator();
        for (ChallengePagerCardItem next : iterator) {
            next.updateView();
        }
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object object3) {
        viewGroup.removeView((View)object3);
        this.c.set(i2, 0);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.e.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        int obj4;
        qn qnVar = qn.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        viewGroup.addView(qnVar.w());
        u((ChallengePagerCardItem)this.e.get(i2), qnVar, i2);
        if (Float.compare(obj4, i3) == 0) {
            this.d = qnVar.O.getCardElevation();
        }
        qnVar.O.setMaxCardElevation(f *= i5);
        this.c.set(i2, qnVar);
        return qnVar.w();
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object object2) {
        int obj1;
        obj1 = view == object2 ? 1 : 0;
        return obj1;
    }

    public boolean t(List<ChallengeModel> list) {
        List next;
        boolean empty;
        ArrayList arrayList;
        List challengePagerCardItem;
        boolean empty2 = this.e.isEmpty();
        final int i = 0;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                arrayList = new ArrayList(Collections.nCopies(list.size(), 0));
                this.c.addAll(arrayList);
                final Iterator obj7 = list.iterator();
                for (ChallengeModel next : obj7) {
                    challengePagerCardItem = new ChallengePagerCardItem(next);
                    this.e.add(challengePagerCardItem);
                }
                if (empty2) {
                    D(i);
                }
                return empty2;
            }
        }
        return i;
    }

    @Override // androidx.viewpager.widget.a
    public void v() {
        this.c.clear();
        this.e.clear();
    }

    @Override // androidx.viewpager.widget.a
    public int w(ChallengeModel challengeModel) {
        int i;
        boolean equals;
        String str;
        Iterator iterator = this.e.iterator();
        i = 0;
        for (ChallengePagerCardItem next2 : iterator) {
            i++;
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.a
    public int x(String string) {
        int i;
        boolean equals;
        Iterator iterator = this.e.iterator();
        i = 0;
        for (ChallengePagerCardItem next2 : iterator) {
            i++;
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
}
