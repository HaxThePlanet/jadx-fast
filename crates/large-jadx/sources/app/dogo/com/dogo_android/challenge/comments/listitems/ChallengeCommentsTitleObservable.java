package app.dogo.com.dogo_android.d.b.z;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.util.e0.o;
import kotlin.Metadata;

/* compiled from: ChallengeCommentsTitleObservable.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0004R \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentsTitleObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "()V", "<set-?>", "", "commentCount", "getCommentCount", "()I", "commentCountString", "", "getCommentCountString", "()Ljava/lang/String;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "notifyModelChange", "", "setModel", "count", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class ChallengeCommentsTitleObservable extends o {

    /* renamed from: a, reason: from kotlin metadata */
    private int commentCount;
    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: a, reason: from kotlin metadata */
    public final int notifyModelChange() {
        return this.commentCount;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: b, reason: from kotlin metadata */
    public final void setModel(ChallengeEntryModel model, int count) {
        this.commentCount = count;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
    }
}
