package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.d.b.y;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.w2;

/* compiled from: BaseEntryLayoutHelper.java */
/* loaded from: classes.dex */
public abstract class f {

    private final h2 authService;
    private boolean commentFieldFocusedFlag;
    private boolean expandedCaptionFlag;
    private long lastSimpleClickTimestamp;
    private long lastToggleClickTimestamp;
    private q parent;
    private String sourceTag;
    private final n3 subscribeInteractor;
    private final o3 tracker;
    public f() {
        this(App.o(), App.n(), App.b());
    }

    public q getParent() {
        return this.parent;
    }

    public boolean isCommentFieldFocused() {
        return this.commentFieldFocusedFlag;
    }

    public boolean isExpandedCaption() {
        return this.expandedCaptionFlag;
    }

    public boolean onDeleteRequest(m2 m2Var, o3 o3Var, ChallengeEntryModel challengeEntryModel, String str, int i) {
        if (challengeEntryModel.isLastPhoto()) {
            m2Var.g(str, challengeEntryModel.getDocumentId(), challengeEntryModel.getChallengeId());
            return true;
        }
        m2Var.f(challengeEntryModel, i);
        return false;
    }

    public boolean onSimpleLikeClick(long j, ChallengeEntryModel challengeEntryModel, String str) {
        long l = j - this.lastSimpleClickTimestamp;
        if (this.lastSimpleClickTimestamp < 500 && !challengeEntryModel.getLikeStateForImage(str)) {
            onEntryUpvote(challengeEntryModel, str);
            this.lastSimpleClickTimestamp = 0L;
            return true;
        }
        this.lastSimpleClickTimestamp = j;
        return false;
    }

    public boolean onToggleLikeClick(long j, ChallengeEntryModel challengeEntryModel, String str) {
        long l = j - this.lastToggleClickTimestamp;
        if (this.lastToggleClickTimestamp > 500 && !challengeEntryModel.getLikeStateForImage(str)) {
            onEntryUpvote(challengeEntryModel, str);
            this.lastToggleClickTimestamp = j;
            return true;
        }
        return false;
    }

    public void setCommentFieldFocused(boolean z) {
        this.commentFieldFocusedFlag = z;
    }

    public void setExpandedCaptionFlag(boolean z) {
        this.expandedCaptionFlag = z;
    }

    public void setSourceTag(String str) {
        this.sourceTag = str;
    }

    public void toggleFeaturedLogic(h2 h2Var, m2 m2Var, ChallengeEntryModel challengeEntryModel, int i) {
        String str;
        String str2;
        if (h2Var.C()) {
            int i2 = !challengeEntryModel.isFeatured(i);
            challengeEntryModel.setFeatured(i2, i);
            if (challengeEntryModel.getImageIdAt(i) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "images.";
                String imageIdAt2 = challengeEntryModel.getImageIdAt(i);
                String str4 = ".featured";
                str2 = str + imageIdAt2 + str4;
            } else {
                str2 = "featured";
            }
            m2Var.C0(FirestorePath.entry.forEntryId(challengeEntryModel.getDocumentId()), str2, Boolean.valueOf(i2), new Object[0]);
        }
    }

    public void unVoteLogic(m2 m2Var, o3 o3Var, String str, ChallengeEntryModel challengeEntryModel, String str2) {
        o3Var.logEvent(E_Challenges.c.c(new EP_EntryId(), challengeEntryModel.getDocumentId(), new EP_ChallengeId(), challengeEntryModel.getChallengeId(), new EP_ViewSource(), this.sourceTag));
        m2Var.y0(str, challengeEntryModel, str2);
        challengeEntryModel.setLikeStateForImage(str2, false);
        challengeEntryModel.incrementVotes(-1);
    }

    public boolean uploadComment(m2 m2Var, ChallengeEntryModel challengeEntryModel, String str, ChallengeComment challengeComment, String str2, DogProfileModel dogProfileModel, a0 a0Var, boolean z) {
        final Object m2Var2 = this;
        ChallengeComment challengeComment42 = challengeComment;
        Object z83 = a0Var;
        challengeComment = new ChallengeComment(str2, str, challengeEntryModel.getDocumentId(), dogProfileModel, challengeEntryModel.getChallengeId(), challengeEntryModel.getAuthor());
        challengeComment.setBadges(m2Var.a(dogProfileModel.getId(), z));
        if (challengeComment42 != null) {
            challengeComment.setReplyTarget(challengeComment42);
        }
        boolean z2 = false;
        if (challengeComment.getDogName() == null) {
            z83.w0(dogProfileModel.getId(), 11100);
            z83.t0(2131886415);
            return false;
        }
        if (!m2Var2.authService.D()) {
            z83.R("challenges_entry");
            return false;
        }
        m2Var2.tracker.logEvent(E_Challenges.d.c(new EP_EntryId(), challengeEntryModel.getDocumentId(), new EP_ChallengeId(), challengeEntryModel.getChallengeId(), new EP_ViewSource(), CommentSource.commentSourceParser(m2Var2.sourceTag)));
        m2Var.D0(challengeComment);
        int i4 = 1;
        challengeEntryModel.setCommentCount(challengeEntryModel.getCommentCount() + i4);
        return true;
    }

    public void upvoteLogic(m2 m2Var, q2 q2Var, o3 o3Var, ChallengeEntryModel challengeEntryModel, String str, String str2, String str3, String str4, String str5) {
        o3Var.logEvent(E_Challenges.b.c(new EP_EntryId(), challengeEntryModel.getDocumentId(), new EP_ChallengeId(), challengeEntryModel.getChallengeId(), new EP_ViewSource(), this.sourceTag));
        m2Var.E0(str, challengeEntryModel, str2, str3, str4, str5);
        boolean z = true;
        challengeEntryModel.setLikeStateForImage(str5, z);
        challengeEntryModel.incrementVotes(z);
        q2Var.l();
        q2Var.m();
    }

    protected f(o3 o3Var, n3 n3Var, h2 h2Var) {
        super();
        final long l = 0L;
        this.lastSimpleClickTimestamp = l;
        this.lastToggleClickTimestamp = l;
        this.tracker = o3Var;
        this.subscribeInteractor = n3Var;
        this.authService = h2Var;
    }

    public abstract void onEntryUnvote(ChallengeEntryModel challengeEntryModel, String str);

    public abstract void onEntryUpvote(ChallengeEntryModel challengeEntryModel, String str);
}
