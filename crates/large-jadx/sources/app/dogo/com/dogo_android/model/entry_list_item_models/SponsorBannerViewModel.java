package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.n0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;

/* compiled from: SponsorBannerViewModel.java */
/* loaded from: classes.dex */
public class SponsorBannerViewModel implements h {

    private ChallengeModel model;
    private final j registry;
    private r2 remoteConfigService;
    private o3 tracker;
    private v2 utilities;
    public SponsorBannerViewModel() {
        this(App.o(), App.p(), App.k());
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.registry.a(aVar);
    }

    public void changeModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
        notifyChange(21);
        notifyChange(19);
        notifyChange(76);
        notifyChange(168);
        notifyChange(149);
    }

    public String getSponsorImageUrl() {
        int i = 0;
        if (this.model == null || !this.model.hasSponsor()) {
            i = 0;
        } else {
            String sponsorHeaderBannerImageUrl = this.model.getSponsorHeaderBannerImageUrl();
        }
        return i;
    }

    public boolean isBannerVisible() {
        boolean z = true;
        v2 utilities2;
        if (this.model != null && this.model.hasPrize()) {
            int r0 = !this.model.isHasEnded(this.utilities) ? 1 : 0;
        }
        return (!this.model.isHasEnded(this.utilities) ? 1 : 0);
    }

    public boolean isBarkboxVisible() {
        boolean z = false;
        ChallengeModel.MediaTypes pHOTO_BARKBOX2;
        if (this.model != null) {
            int r0 = this.model.getMediaType() == ChallengeModel_MediaTypes.PHOTO_BARKBOX ? 1 : 0;
        }
        return (this.model.getMediaType() == ChallengeModel_MediaTypes.PHOTO_BARKBOX ? 1 : 0);
    }

    public boolean isFriendlyCollarVisible() {
        boolean z = false;
        ChallengeModel.MediaTypes pHOTO_FRIENDLY_COLLAR2;
        if (this.model != null) {
            int r0 = this.model.getMediaType() == ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0;
        }
        return (this.model.getMediaType() == ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0);
    }

    public boolean isUniversalBannerVisible() {
        boolean z = false;
        int r0 = this.model != null && this.model.hasSponsor() ? 1 : 0;
        return (this.model != null && this.model.hasSponsor() ? 1 : 0);
    }

    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    public void onSponsorBannerClick(a0 a0Var, g0 g0Var) {
        String customLinkByCountry;
        this.tracker.logEvent(E_Sponsors.b.c(new EP_ChallengeId(), this.model.getId()));
        if (this.model.hasSponsor()) {
            try {
                if (CustomUrl.getCustomLinkByCountry(g0Var.W().getId(), this.remoteConfigService.v()) == null) {
                    customLinkByCountry = this.model.getSponsorWebsiteUrl();
                }
                a0Var.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(customLinkByCountry)));
            } catch (Exception unused) {
                g0Var = 2131886123;
                a0Var.t0(g0Var);
            }
        } else {
            boolean z = true;
            boolean z2 = true;
            boolean z3 = false;
            g0Var.I2(a0Var, this.model, z, z2, z3);
        }
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.registry.j(aVar);
    }

    public void setModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
        notifyChange(21);
        notifyChange(19);
        notifyChange(76);
        notifyChange(168);
        notifyChange(149);
    }

    public SponsorBannerViewModel(o3 o3Var, v2 v2Var, r2 r2Var) {
        super();
        this.registry = new j();
        this.tracker = o3Var;
        this.utilities = v2Var;
        this.remoteConfigService = r2Var;
    }
}
