package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.d.b.z.m;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder;
import app.dogo.com.dogo_android.model.entry_list_item_models.PhotoEntryGroup;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k0.f;
import h.a.b.b;
import h.a.b.e;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class e extends app.dogo.com.dogo_android.util.n0.d<f> {

    public boolean F0;
    private a0 G0;
    private g0 H0;
    private s2 I0;
    private List<String> J0;
    private int K0;
    private String L0;
    private boolean M0;
    private boolean N0;
    public e(List<f> list, g0 g02, a0 a03, s2 s24, f f5, q q6) {
        super(list, f5, q6);
        ArrayList obj1 = new ArrayList();
        this.J0 = obj1;
        this.K0 = 0;
        this.G0 = a03;
        this.H0 = g02;
        this.I0 = s24;
    }

    public e(List<f> list, g0 g02, a0 a03, f f4, q q5) {
        super(list, g02, a03, App.l(), f4, q5);
    }

    private boolean o2(EntryItem entryItem, EntryItem entryItem2) {
        return entryItem.isItemOlderThen(entryItem2);
    }

    public boolean Z(int i, List<f> list2) {
        Object next;
        boolean z;
        String str;
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            if (next instanceof EntryItem) {
            } else {
            }
            arrayList.add((f)next);
            v2();
            if (!this.J0.contains((EntryItem)next.getId())) {
            } else {
            }
            z = M0(next);
            if (z < 0) {
            } else {
            }
            if (o2((EntryItem)O0(z), next)) {
            }
            removeItem(M0(next));
            arrayList.add(next);
            arrayList.add(next);
            this.J0.add(next.getId());
            arrayList.add(next);
        }
        return super.Z(i, arrayList);
    }

    public boolean g2(List<f> list) {
        return Z(itemCount -= m0, list);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void h2() {
        boolean z;
        int i;
        if (!this.M0 && !this.N0) {
            if (!this.N0) {
                BlankScreenCell blankScreenCell = new BlankScreenCell(0);
                Y(blankScreenCell);
                this.M0 = true;
            }
        }
    }

    public void i2(List<f> list) {
        Object next;
        boolean contains;
        String str;
        ArrayList arrayList = new ArrayList(list);
        Iterator obj5 = list.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (r0((f)next)) {
            }
            if (next instanceof EntryItem && (EntryItem)next.getId() != null && !this.J0.contains(next.getId())) {
            }
            if ((EntryItem)next.getId() != null) {
            }
            if (!this.J0.contains(next.getId())) {
            }
            this.J0.add(next.getId());
            b2(next);
            arrayList.remove(next);
        }
        super.Z(7, arrayList);
        s2();
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void j2() {
        final int i2 = 6;
        itemCount -= i2;
        this.J0.clear();
        G1(i2, i);
        int i3 = 0;
        this.N0 = i3;
        this.M0 = i3;
        h2();
        notifyItemRangeChanged(i2, i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public int k2() {
        return k0 += -6;
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public a0 l2() {
        return this.G0;
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public String m2() {
        return this.L0;
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public g0 n2() {
        return this.H0;
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return super.onCreateViewHolder(viewGroup, i2);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void onViewAttachedToWindow(RecyclerView.e0 recyclerView$e0) {
        boolean z;
        super.onViewAttachedToWindow(e0);
        int i2 = 1;
        if (e0.itemView.findViewById(2131363262) != null) {
            this.F0 = i2;
        }
        if (e0 instanceof EntryViewHolder && e0 instanceof EntryPhotoItem.ViewHolder) {
            if (e0 instanceof EntryPhotoItem.ViewHolder) {
                (EntryPhotoItem.ViewHolder)e0.onUserView(i2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
        View obj2;
        super.onViewDetachedFromWindow(e0);
        if (e0.itemView.findViewById(2131363262) != null) {
            this.F0 = false;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void p2() {
        this.N0 = true;
        x2();
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void q2(int i) {
        final f fVar = O0(i);
        if (fVar instanceof k) {
            (k)fVar.h();
            notifyItemChanged(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void r2(ChallengeModel challengeModel) {
        this.K0 = i0.a.e(challengeModel.getId());
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void removeItem(int i) {
        super.removeItem(i);
        s2();
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void s2() {
        boolean z;
        final int i = 6;
        final f fVar = O0(i);
        if (fVar instanceof m) {
            (m)fVar.g(itemCount += -7);
            notifyItemChanged(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void t2(String string, int i2) {
        int i;
        Object next;
        boolean equals;
        Iterator iterator = F0().iterator();
        i = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof PhotoEntryGroup) {
                break;
            } else {
            }
            i++;
            if (string.equals((PhotoEntryGroup)(f)next.getId())) {
                break;
            } else {
            }
        }
        notifyItemChanged(i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void u2() {
        Object next;
        boolean z;
        Iterator iterator = j().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof EntryViewHolder) {
            }
            (EntryViewHolder)(b)next.updateView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void v2() {
        final int i = 6;
        if (fVar instanceof ChallengeFeedEndItem) {
            removeItem(i);
        }
    }

    public void w2(List<String> list) {
        Object next;
        boolean contains;
        int obj4;
        Iterator iterator = j().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof EntryViewHolder) {
                break;
            } else {
            }
            if (list.contains((EntryViewHolder)(b)next.getId())) {
                break;
            } else {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void x2() {
        boolean z;
        if (this.M0) {
            removeItem(itemCount--);
            this.M0 = false;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void y2(String string) {
        this.L0 = string;
    }

    public void z2(List<f> list) {
        Object next;
        boolean z;
        boolean z2;
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if (F0().contains((f)next)) {
            } else {
            }
            X(itemCount -= z2, next);
            if (next instanceof m) {
            } else {
            }
            b2(next);
        }
    }
}
