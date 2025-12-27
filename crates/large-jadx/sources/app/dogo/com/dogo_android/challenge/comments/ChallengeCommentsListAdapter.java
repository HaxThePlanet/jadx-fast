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
import h.a.b.b;
import h.a.b.e;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeCommentsListAdapter.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00020\u0001B-\u0012\u0014\u0010\u0003\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0002\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ$\u0010\u000c\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0004J\u0008\u0010\u0012\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004J\u001a\u0010\u0014\u001a\u00020\r2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\rJ\u0008\u0010\u001e\u001a\u00020\rH\u0002J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0011J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseNavComponentFlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "items", "", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "isPremium", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/enums/TagGlue;Z)V", "endOfList", "loadingCellState", "addComments", "", "models", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "markedCommentIds", "", "addLoadingCell", "addNewComments", "insertCaptionItem", "captionModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "markEndOfList", "markItemAsSpam", "position", "", "refreshCommentTime", "removeLoadingCell", "scrollToComment", "commentId", "updateCaption", "model", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class ChallengeCommentsListAdapter extends app.dogo.com.dogo_android.util.e0.p<f<?>> {

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean endOfList;
    /* renamed from: E0, reason: from kotlin metadata */
    private boolean isPremium;
    /* renamed from: F0, reason: from kotlin metadata */
    private final boolean loadingCellState;
    public w(List<? extends f<?>> list, q qVar, boolean z) {
        super(list, qVar);
        addLoadingCell();
        this.loadingCellState = z;
    }

    /* renamed from: f2, reason: from kotlin metadata */
    private final void addLoadingCell() {
        if (this.endOfList == null && !this.isPremium) {
            app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem = null;
            Y(new BlankScreenCell(entrySortingTabItem));
            boolean endOfList2 = true;
            this.endOfList = endOfList2;
        }
    }

    private final void l2() {
        if (this.endOfList != null) {
            removeItem(getItemCount() - 1);
            boolean endOfList2 = false;
            this.endOfList = endOfList2;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: e2, reason: from kotlin metadata */
    public final void addComments(List<ChallengeComment> models, List<String> markedCommentIds) {
        n.f(models, "models");
        n.f(markedCommentIds, "markedCommentIds");
        ArrayList arrayList = new ArrayList();
        Iterator it = models.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            n.d(item);
            k challengeCommentItem = new ChallengeCommentItem(item, p.N(markedCommentIds, item.getDocumentId()));
        }
        Z(getItemCount() - this.endOfList, arrayList);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: g2, reason: from kotlin metadata */
    public final void addNewComments(List<ChallengeComment> models) {
        n.f(models, "models");
        ArrayList arrayList = new ArrayList();
        Iterator it = models.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            n.d(item);
            boolean z = false;
            int i = 2;
            kotlin.d0.d.g gVar = null;
            k challengeCommentItem = new ChallengeCommentItem(item, z, i, gVar);
        }
        Z(1, arrayList);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: h2, reason: from kotlin metadata */
    public final void insertCaptionItem(ChallengeEntryModel captionModel, ChallengeModel challengeModel) {
        n.d(captionModel);
        ChallengeCommentCaptionItem challengeCommentCaptionItem = new ChallengeCommentCaptionItem(captionModel, challengeModel, this.loadingCellState, null, 8, null);
        X(0, challengeCommentCaptionItem);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void i2() {
        this.isPremium = true;
        l2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: j2, reason: from kotlin metadata */
    public final void markItemAsSpam(int position) {
        final f fVar = O0(position);
        if (fVar instanceof ChallengeCommentItem) {
            fVar.h();
            notifyItemChanged(position);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public final void k2() {
        Iterator it = j().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof ChallengeCommentItem_ViewHolder;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: m2, reason: from kotlin metadata */
    public final void scrollToComment(String commentId) {
        int i;
        boolean z;
        n.f(commentId, "commentId");
        List list = F0();
        n.e(list, "currentItems");
        Iterator it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof ChallengeCommentItem;
            if (i != 0) {
                break;
            }
        }
        i = -1;
        if (i >= 0) {
            V1(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    /* renamed from: n2, reason: from kotlin metadata */
    public final void updateCaption(ChallengeEntryModel model, ChallengeModel challengeModel) {
        n.f(model, "model");
        int i = 0;
        final f fVar = O0(i);
        if (fVar instanceof ChallengeCommentCaptionItem) {
            fVar.j(model.hasUserLiked());
            fVar.i(challengeModel);
            notifyItemChanged(i, null);
        }
    }
}
