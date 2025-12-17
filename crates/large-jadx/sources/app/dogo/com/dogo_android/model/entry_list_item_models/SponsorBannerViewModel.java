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

/* loaded from: classes.dex */
public class SponsorBannerViewModel implements h {

    private ChallengeModel model;
    private final j registry;
    private r2 remoteConfigService;
    private o3 tracker;
    private v2 utilities;
    public SponsorBannerViewModel() {
        super(App.o(), App.p(), App.k());
    }

    public SponsorBannerViewModel(o3 o3, v2 v22, r2 r23) {
        super();
        j jVar = new j();
        this.registry = jVar;
        this.tracker = o3;
        this.utilities = v22;
        this.remoteConfigService = r23;
    }

    @Override // androidx.databinding.h
    public void addOnPropertyChangedCallback(h.a h$a) {
        this.registry.a(a);
    }

    @Override // androidx.databinding.h
    public void changeModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
        notifyChange(21);
        notifyChange(19);
        notifyChange(76);
        notifyChange(168);
        notifyChange(149);
    }

    @Override // androidx.databinding.h
    public String getSponsorImageUrl() {
        ChallengeModel sponsor;
        int sponsorHeaderBannerImageUrl;
        sponsor = this.model;
        if (sponsor != null && sponsor.hasSponsor()) {
            if (sponsor.hasSponsor()) {
                sponsorHeaderBannerImageUrl = this.model.getSponsorHeaderBannerImageUrl();
            } else {
                sponsorHeaderBannerImageUrl = 0;
            }
        } else {
        }
        return sponsorHeaderBannerImageUrl;
    }

    @Override // androidx.databinding.h
    public boolean isBannerVisible() {
        int i;
        ChallengeModel hasEnded;
        v2 utilities;
        hasEnded = this.model;
        if (hasEnded != null && hasEnded.hasPrize() && !this.model.isHasEnded(this.utilities)) {
            if (hasEnded.hasPrize()) {
                i = !this.model.isHasEnded(this.utilities) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.databinding.h
    public boolean isBarkboxVisible() {
        Object mediaType;
        int i;
        ChallengeModel.MediaTypes pHOTO_BARKBOX;
        mediaType = this.model;
        if (mediaType != null && mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_BARKBOX) {
            i = mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_BARKBOX ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.databinding.h
    public boolean isFriendlyCollarVisible() {
        Object mediaType;
        int i;
        ChallengeModel.MediaTypes pHOTO_FRIENDLY_COLLAR;
        mediaType = this.model;
        if (mediaType != null && mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_FRIENDLY_COLLAR) {
            i = mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.databinding.h
    public boolean isUniversalBannerVisible() {
        ChallengeModel sponsor;
        int i;
        sponsor = this.model;
        if (sponsor != null && sponsor.hasSponsor()) {
            i = sponsor.hasSponsor() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.databinding.h
    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    @Override // androidx.databinding.h
    public void onSponsorBannerClick(a0 a0, g0 g02) {
        Intent intent;
        Object str2;
        Object c1Var;
        String str;
        int i2;
        int i;
        Uri obj8;
        c1Var = new c1();
        this.tracker.d(n0.b.c(c1Var, this.model.getId()));
        if (this.model.hasSponsor()) {
            if (k.a(g02.W().getId(), this.remoteConfigService.v()) != null) {
            } else {
                obj8 = this.model.getSponsorWebsiteUrl();
            }
            intent = new Intent("android.intent.action.VIEW", Uri.parse(obj8));
            a0.startActivity(intent);
        } else {
            g02.I2(a0, this.model, true, true, false);
        }
    }

    @Override // androidx.databinding.h
    public void removeOnPropertyChangedCallback(h.a h$a) {
        this.registry.j(a);
    }

    @Override // androidx.databinding.h
    public void setModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
        notifyChange(21);
        notifyChange(19);
        notifyChange(76);
        notifyChange(168);
        notifyChange(149);
    }
}
