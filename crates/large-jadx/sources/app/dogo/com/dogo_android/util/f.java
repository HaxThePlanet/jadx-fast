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
        super(App.o(), App.n(), App.b());
    }

    protected f(o3 o3, n3 n32, h2 h23) {
        super();
        final int i = 0;
        this.lastSimpleClickTimestamp = i;
        this.lastToggleClickTimestamp = i;
        this.tracker = o3;
        this.subscribeInteractor = n32;
        this.authService = h23;
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

    public boolean onDeleteRequest(m2 m2, o3 o32, ChallengeEntryModel challengeEntryModel3, String string4, int i5) {
        if (challengeEntryModel3.isLastPhoto()) {
            m2.g(string4, challengeEntryModel3.getDocumentId(), challengeEntryModel3.getChallengeId());
            return 1;
        }
        m2.f(challengeEntryModel3, i5);
        return 0;
    }

    public abstract void onEntryUnvote(ChallengeEntryModel challengeEntryModel, String string2);

    public abstract void onEntryUpvote(ChallengeEntryModel challengeEntryModel, String string2);

    public boolean onSimpleLikeClick(long l, ChallengeEntryModel challengeEntryModel2, String string3) {
        if (Long.compare(i, i2) < 0 && !string3.getLikeStateForImage(obj8)) {
            if (!string3.getLikeStateForImage(obj8)) {
                onEntryUpvote(string3, obj8);
            }
            this.lastSimpleClickTimestamp = 0;
            return 1;
        }
        this.lastSimpleClickTimestamp = l;
        return 0;
    }

    public boolean onToggleLikeClick(long l, ChallengeEntryModel challengeEntryModel2, String string3) {
        if (Long.compare(i, i2) > 0) {
            if (!string3.getLikeStateForImage(obj8)) {
                onEntryUpvote(string3, obj8);
            } else {
                onEntryUnvote(string3, obj8);
            }
            this.lastToggleClickTimestamp = l;
            return 1;
        }
        return 0;
    }

    public void setCommentFieldFocused(boolean z) {
        this.commentFieldFocusedFlag = z;
    }

    public void setExpandedCaptionFlag(boolean z) {
        this.expandedCaptionFlag = z;
    }

    public void setSourceTag(String string) {
        this.sourceTag = string;
    }

    public void toggleFeaturedLogic(h2 h2, m2 m22, ChallengeEntryModel challengeEntryModel3, int i4) {
        Object stringBuilder;
        Object[] arr;
        String str;
        boolean obj3;
        f obj5;
        String obj6;
        if (h2.C()) {
            obj3 ^= 1;
            challengeEntryModel3.setFeatured(obj3, i4);
            if (challengeEntryModel3.getImageIdAt(i4) != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("images.");
                stringBuilder.append(challengeEntryModel3.getImageIdAt(i4));
                stringBuilder.append(".featured");
                obj6 = stringBuilder.toString();
            } else {
                obj6 = "featured";
            }
            m22.C0(f.entry.forEntryId(challengeEntryModel3.getDocumentId()), obj6, Boolean.valueOf(obj3), new Object[0]);
        }
    }

    public void unVoteLogic(m2 m2, o3 o32, String string3, ChallengeEntryModel challengeEntryModel4, String string5) {
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        o32.d(u.c.c(i1Var, challengeEntryModel4.getDocumentId(), c1Var, challengeEntryModel4.getChallengeId(), r2Var, this.sourceTag));
        m2.y0(string3, challengeEntryModel4, string5);
        challengeEntryModel4.setLikeStateForImage(string5, false);
        challengeEntryModel4.incrementVotes(-1);
    }

    public boolean uploadComment(m2 m2, ChallengeEntryModel challengeEntryModel2, String string3, ChallengeComment challengeComment4, String string5, DogProfileModel dogProfileModel6, a0 a07, boolean z8) {
        final Object obj = this;
        Object obj2 = m2;
        ChallengeComment challengeComment = challengeComment4;
        Object obj3 = a07;
        super(string5, string3, challengeEntryModel2.getDocumentId(), dogProfileModel6, challengeEntryModel2.getChallengeId(), challengeEntryModel2.getAuthor());
        challengeComment3.setBadges(m2.a(dogProfileModel6.getId(), z8));
        if (challengeComment != null) {
            challengeComment3.setReplyTarget(challengeComment);
        }
        int i5 = 0;
        if (challengeComment3.getDogName() == null) {
            obj3.w0(dogProfileModel6.getId(), 11100);
            obj3.t0(2131886415);
            return i5;
        }
        if (!obj.authService.D()) {
            obj3.R("challenges_entry");
            return i5;
        }
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        obj.tracker.d(u.d.c(i1Var, challengeEntryModel2.getDocumentId(), c1Var, challengeEntryModel2.getChallengeId(), r2Var, y.commentSourceParser(obj.sourceTag)));
        m2.D0(challengeComment3);
        int i4 = 1;
        Object obj4 = challengeEntryModel2;
        challengeEntryModel2.setCommentCount(commentCount += i4);
        return i4;
    }

    public void upvoteLogic(m2 m2, q2 q22, o3 o33, ChallengeEntryModel challengeEntryModel4, String string5, String string6, String string7, String string8, String string9) {
        final ChallengeEntryModel challengeEntryModel2 = challengeEntryModel4;
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        Object obj2 = o33;
        o33.d(u.b.c(i1Var, challengeEntryModel4.getDocumentId(), c1Var, challengeEntryModel4.getChallengeId(), r2Var, obj3.sourceTag));
        m2.E0(string5, challengeEntryModel4, string6, string7, string8, string9);
        int i = 1;
        challengeEntryModel4.setLikeStateForImage(string9, i);
        challengeEntryModel4.incrementVotes(i);
        q22.l();
        q22.m();
    }
}
