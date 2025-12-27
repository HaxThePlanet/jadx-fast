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
import h.a.b.b;
import h.a.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: ChallengeEntryListAdapter.java */
/* loaded from: classes.dex */
public class e extends d<h.a.b.h.f> {

    public boolean F0;
    private a0 G0;
    private g0 H0;
    private s2 I0;
    private List<String> J0;
    private int K0;
    private String L0;
    private boolean M0;
    private boolean N0;
    public e(List<h.a.b.h.f> list, g0 g0Var, a0 a0Var, app.dogo.com.dogo_android.util.k0.f fVar, q qVar) {
        this(list, g0Var, a0Var, App.l(), fVar, qVar);
    }

    private boolean o2(EntryItem entryItem, EntryItem entryItem2) {
        return entryItem.isItemOlderThen(entryItem2);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public boolean Z(int i, List<h.a.b.h.f> list) {
        String str;
        final ArrayList arrayList = new ArrayList();
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof EntryItem;
        }
        return super.Z(i, arrayList);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public boolean g2(List<h.a.b.h.f> list) {
        return Z(getItemCount() - this.M0, list);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void h2() {
        if (!this.M0 && !this.N0) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem = null;
            Y(new BlankScreenCell(entrySortingTabItem));
            boolean z = true;
            this.M0 = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void i2(List<h.a.b.h.f> list) {
        String str2;
        final ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        super.Z(7, arrayList);
        s2();
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void j2() {
        final int i2 = 6;
        int i = getItemCount() - i2;
        this.J0.clear();
        G1(i2, i);
        boolean z = false;
        this.N0 = z;
        this.M0 = z;
        h2();
        notifyItemRangeChanged(i2, i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public int k2() {
        return this.K0 - 6;
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
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void onViewAttachedToWindow(RecyclerView.e0 e0Var) {
        super.onViewAttachedToWindow(e0Var);
        boolean z2 = true;
        if (e0Var.itemView.findViewById(2131363262) != null) {
            this.F0 = z2;
        }
        z = e0Var instanceof EntryViewHolder;
        if (e0Var instanceof EntryViewHolder) {
            z = e0Var instanceof EntryPhotoItem.ViewHolder;
            if (e0Var instanceof EntryPhotoItem.ViewHolder) {
                e0Var.onUserView(z2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void onViewDetachedFromWindow(RecyclerView.e0 e0Var) {
        super.onViewDetachedFromWindow(e0Var);
        if (e0Var.itemView.findViewById(2131363262) != null) {
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
        final h.a.b.h.f fVar = O0(i);
        if (fVar instanceof ChallengeCommentItem) {
            fVar.h();
            notifyItemChanged(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void r2(ChallengeModel challengeModel) {
        this.K0 = this.I0.challengeState.e(challengeModel.getId());
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void removeItem(int i) {
        super.removeItem(i);
        s2();
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void s2() {
        final int i = 6;
        final h.a.b.h.f fVar = O0(i);
        z = fVar instanceof ChallengeCommentsTitleItem;
        if (fVar instanceof ChallengeCommentsTitleItem) {
            fVar.updateCommentCount(getItemCount() - 7);
            notifyItemChanged(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void t2(String str, int i) {
        boolean equals;
        Iterator it = F0().iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            equals = item instanceof PhotoEntryGroup;
            if (item instanceof PhotoEntryGroup) {
            }
        }
        notifyItemChanged(i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void u2() {
        Iterator it = j().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof EntryViewHolder;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void v2() {
        final int i = 6;
        if (O0(i) instanceof ChallengeFeedEndItem) {
            removeItem(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void w2(List<String> list) {
        boolean contains;
        Iterator it = j().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            contains = item instanceof EntryViewHolder;
            if (item instanceof EntryViewHolder) {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void x2() {
        if (this.M0) {
            removeItem(getItemCount() - 1);
            boolean z = false;
            this.M0 = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void y2(String str) {
        this.L0 = str;
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public void z2(List<h.a.b.h.f> list) {
        boolean z;
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    public e(List<h.a.b.h.f> list, g0 g0Var, a0 a0Var, s2 s2Var, app.dogo.com.dogo_android.util.k0.f fVar, q qVar) {
        super(list, fVar, qVar);
        this.J0 = new ArrayList();
        this.K0 = 0;
        this.G0 = a0Var;
        this.H0 = g0Var;
        this.I0 = s2Var;
    }
}
