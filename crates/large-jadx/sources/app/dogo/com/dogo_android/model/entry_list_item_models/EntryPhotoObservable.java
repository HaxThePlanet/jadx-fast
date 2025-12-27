package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.n0;
import app.dogo.com.dogo_android.w.o3;

/* compiled from: EntryPhotoObservable.java */
/* loaded from: classes.dex */
public class EntryPhotoObservable extends EntryPhotoBaseObservable {

    private a1 challengeLocalRepository;
    private ChallengeModel challengeModel;
    private final i2 cloudFunctionsService;
    private int itemPosition;
    private r2 remoteConfigService;
    private s2 stateManager;
    private o3 tracker;
    private boolean wasViewed;
    public EntryPhotoObservable() {
        this(App.h(), App.b(), App.o(), App.j(), App.l(), App.e(), App.g(), App.p(), App.onCreate().getResources(), App.m(), App.f(), App.c(), App.i(), App.k());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getAdImageUrl() {
        String sponsorFeedBannerImageUrl;
        if (this.challengeModel != null) {
            sponsorFeedBannerImageUrl = this.challengeModel.getSponsorFeedBannerImageUrl();
        } else {
            sponsorFeedBannerImageUrl = "";
        }
        return sponsorFeedBannerImageUrl;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getAdVisible() {
        int i = 0;
        int itemPosition2;
        if (this.challengeModel != null && this.challengeModel.hasSponsor()) {
            int r0 = this.challengeModel.sponsorIndexCheck(this.itemPosition) ? 0 : 8;
        }
        return (this.challengeModel.sponsorIndexCheck(this.itemPosition) ? 0 : 8);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        return isCurrentUserEntriesAuthor();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onSponsorBannerClick(a0 a0Var) {
        String customLinkByCountry;
        if (this.challengeModel != null) {
            this.tracker.logEvent(E_Sponsors.a.c(new EP_ChallengeId(), this.challengeModel.getId()));
            try {
                if (CustomUrl.getCustomLinkByCountry(this.challengeModel.getId(), this.remoteConfigService.v()) == null) {
                    customLinkByCountry = this.challengeModel.getSponsorWebsiteUrl();
                }
                str = "android.intent.action.VIEW";
                a0Var.startActivity(new Intent(str, Uri.parse(customLinkByCountry)));
            } catch (android.content.ActivityNotFoundException unused) {
                a0Var.t0(2131886123);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onUserView() {
        String challengeId;
        if (!this.wasViewed) {
            this.stateManager.a.f(getModel().getChallengeId());
        }
        this.wasViewed = true;
        if (this.challengeModel != null && this.challengeModel.hasSponsor()) {
            if (this.challengeModel.sponsorIndexCheck(this.itemPosition)) {
                this.tracker.logEvent(E_Sponsors.c.c(new EP_ChallengeId(), this.challengeModel.getId()));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setCurrentPosition(int i) {
        this.itemPosition = i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setModel(ChallengeEntryModel challengeEntryModel, boolean z) {
        super.setModel(challengeEntryModel, z);
        this.challengeModel = this.challengeLocalRepository.getChallenge(challengeEntryModel.getChallengeId());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void update() {
        updateEntryView();
        notifyChange(3);
        notifyChange(2);
    }

    public EntryPhotoObservable(m2 m2Var, h2 h2Var, o3 o3Var, q2 q2Var, s2 s2Var, a1 a1Var, app.dogo.com.dogo_android.service.u2 u2Var, v2 v2Var, Resources resources, t2 t2Var, k2 k2Var, i2 i2Var, p2 p2Var, r2 r2Var) {
        final Object m2Var3 = this;
        super(m2Var, h2Var, o3Var, q2Var, u2Var, v2Var, resources, a1Var, t2Var, k2Var, p2Var, i2Var);
        m2Var3.wasViewed = false;
        m2Var3.challengeLocalRepository = a1Var;
        m2Var3.tracker = o3Var;
        m2Var3.stateManager = s2Var;
        m2Var3.cloudFunctionsService = i2Var;
        m2Var3.remoteConfigService = r2Var;
    }
}
