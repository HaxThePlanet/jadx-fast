package app.dogo.com.dogo_android.d.b;

import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.d.b.z.i;
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.d.b.z.k.b;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell;
import app.dogo.com.dogo_android.util.e0.p;
import h.a.b.b;
import h.a.b.e;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00020\u0001B-\u0012\u0014\u0010\u0003\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0002\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ$\u0010\u000c\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0004J\u0008\u0010\u0012\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004J\u001a\u0010\u0014\u001a\u00020\r2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\rJ\u0008\u0010\u001e\u001a\u00020\rH\u0002J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0011J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "items", "", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "isPremium", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/enums/TagGlue;Z)V", "endOfList", "loadingCellState", "addComments", "", "models", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "markedCommentIds", "", "addLoadingCell", "addNewComments", "insertCaptionItem", "captionModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "markEndOfList", "markItemAsSpam", "position", "", "refreshCommentTime", "removeLoadingCell", "scrollToComment", "commentId", "updateCaption", "model", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w extends p<f<?>> {

    private boolean D0;
    private boolean E0;
    private final boolean F0;
    public w(List<? extends f<?>> list, q q2, boolean z3) {
        super(list, q2);
        f2();
        this.F0 = z3;
    }

    private final void f2() {
        boolean z;
        int i;
        if (!this.D0 && !this.E0) {
            if (!this.E0) {
                BlankScreenCell blankScreenCell = new BlankScreenCell(0);
                Y(blankScreenCell);
                this.D0 = true;
            }
        }
    }

    private final void l2() {
        boolean z;
        if (this.D0) {
            removeItem(itemCount--);
            this.D0 = false;
        }
    }

    public final void e2(List<ChallengeComment> list, List<String> list2) {
        boolean z;
        k kVar;
        boolean z2;
        n.f(list, "models");
        n.f(list2, "markedCommentIds");
        ArrayList arrayList = new ArrayList();
        Iterator obj5 = list.iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            n.d((ChallengeComment)next2);
            kVar = new k(next2, p.N(list2, next2.getDocumentId()));
            if (r0(kVar)) {
            } else {
            }
            arrayList.add(kVar);
            b2(kVar);
        }
        Z(obj5 -= obj6, arrayList);
    }

    public final void g2(List<ChallengeComment> list) {
        Object next;
        k kVar;
        int i3;
        int i2;
        int i;
        boolean z;
        n.f(list, "models");
        ArrayList arrayList = new ArrayList();
        Iterator obj8 = list.iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            n.d((ChallengeComment)next);
            i3 = 0;
            i2 = 2;
            i = 0;
            kVar = new k(next, i3, i2, i);
            if (r0(kVar)) {
            } else {
            }
            kVar = new k(next, i3, i2, i);
            arrayList.add(kVar);
            b2(kVar);
        }
        Z(1, arrayList);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void h2(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2) {
        n.d(challengeEntryModel);
        super(challengeEntryModel, challengeModel2, this.F0, 0, 8, 0);
        X(0, iVar2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void i2() {
        this.E0 = true;
        l2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void j2(int i) {
        final f fVar = O0(i);
        if (fVar instanceof k) {
            (k)fVar.h();
            notifyItemChanged(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void k2() {
        Object next;
        boolean z;
        Iterator iterator = j().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof k.b) {
            }
            (k.b)(b)next.e();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void m2(String string) {
        int i;
        int next;
        Object next2;
        boolean z;
        n.f(string, "commentId");
        List list = F0();
        n.e(list, "currentItems");
        Iterator iterator = list.iterator();
        int i2 = 0;
        i = i2;
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if (next2 instanceof k && n.b((k)(f)next2.getId(), string)) {
            } else {
            }
            next = i2;
            i++;
            if (n.b((k)next2.getId(), string)) {
            } else {
            }
            next = 1;
        }
        i = -1;
        if (i >= 0) {
            V1(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void n2(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2) {
        Object obj4;
        n.f(challengeEntryModel, "model");
        int i = 0;
        final f fVar = O0(i);
        if (fVar instanceof i) {
            (i)fVar.j(challengeEntryModel.hasUserLiked());
            fVar.i(challengeModel2);
            notifyItemChanged(i, Integer.valueOf(i));
        }
    }
}
