package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
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
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.n0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;

/* loaded from: classes.dex */
public class EntryPhotoObservable extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable {

    private a1 challengeLocalRepository;
    private ChallengeModel challengeModel;
    private final i2 cloudFunctionsService;
    private int itemPosition;
    private r2 remoteConfigService;
    private s2 stateManager;
    private o3 tracker;
    private boolean wasViewed;
    public EntryPhotoObservable() {
        super(App.h(), App.b(), App.o(), App.j(), App.l(), App.e(), App.g(), App.p(), App.a().getResources(), App.m(), App.f(), App.c(), App.i(), App.k());
    }

    public EntryPhotoObservable(m2 m2, h2 h22, o3 o33, q2 q24, s2 s25, a1 a16, u2 u27, v2 v28, Resources resources9, t2 t210, k2 k211, i2 i212, p2 p213, r2 r214) {
        final Object obj2 = this;
        super(m2, h22, o33, q24, u27, v28, resources9, a16, t210, k211, p213, i212);
        obj2.wasViewed = false;
        obj2.challengeLocalRepository = a16;
        obj2.tracker = o33;
        obj2.stateManager = s25;
        obj2.cloudFunctionsService = i212;
        obj2.remoteConfigService = r214;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getAdImageUrl() {
        String sponsorFeedBannerImageUrl;
        ChallengeModel challengeModel = this.challengeModel;
        if (challengeModel != null) {
            sponsorFeedBannerImageUrl = challengeModel.getSponsorFeedBannerImageUrl();
        } else {
            sponsorFeedBannerImageUrl = "";
        }
        return sponsorFeedBannerImageUrl;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public int getAdVisible() {
        int i;
        ChallengeModel sponsorIndexCheck;
        int itemPosition;
        sponsorIndexCheck = this.challengeModel;
        if (sponsorIndexCheck != null && sponsorIndexCheck.hasSponsor() && this.challengeModel.sponsorIndexCheck(this.itemPosition)) {
            if (sponsorIndexCheck.hasSponsor()) {
                i = this.challengeModel.sponsorIndexCheck(this.itemPosition) ? 0 : 8;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        return isCurrentUserEntriesAuthor();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onSponsorBannerClick(a0 a0) {
        String sponsorWebsiteUrl;
        Object challengeModel;
        Intent intent;
        String str;
        String str2;
        if (this.challengeModel != null) {
            c1 c1Var = new c1();
            this.tracker.d(n0.a.c(c1Var, this.challengeModel.getId()));
            if (k.a(this.challengeModel.getId(), this.remoteConfigService.v()) != null) {
            } else {
                sponsorWebsiteUrl = this.challengeModel.getSponsorWebsiteUrl();
            }
            intent = new Intent("android.intent.action.VIEW", Uri.parse(sponsorWebsiteUrl));
            a0.startActivity(intent);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onUserView() {
        boolean wasViewed;
        ChallengeModel sponsorIndexCheck;
        String itemPosition;
        c1 c1Var;
        String str;
        if (!this.wasViewed) {
            stateManager.a.f(getModel().getChallengeId());
        }
        this.wasViewed = true;
        sponsorIndexCheck = this.challengeModel;
        if (sponsorIndexCheck != null && sponsorIndexCheck.hasSponsor() && this.challengeModel.sponsorIndexCheck(this.itemPosition)) {
            if (sponsorIndexCheck.hasSponsor()) {
                if (this.challengeModel.sponsorIndexCheck(this.itemPosition)) {
                    c1Var = new c1();
                    this.tracker.d(n0.c.c(c1Var, this.challengeModel.getId()));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setCurrentPosition(int i) {
        this.itemPosition = i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setModel(ChallengeEntryModel challengeEntryModel, boolean z2) {
        super.setModel(challengeEntryModel, z2);
        this.challengeModel = this.challengeLocalRepository.a(challengeEntryModel.getChallengeId());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void update() {
        updateEntryView();
        notifyChange(3);
        notifyChange(2);
    }
}
