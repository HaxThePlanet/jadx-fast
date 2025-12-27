package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.Context;
import android.content.res.Resources;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;

/* compiled from: ChallengePagerCardItem.java */
/* loaded from: classes.dex */
public class ChallengePagerCardItem implements h {

    public String id;
    private ChallengeModel model;
    private final j registry;
    private Resources resources;
    private v2 utilities;
    public ChallengePagerCardItem(ChallengeModel challengeModel, Resources resources, v2 v2Var) {
        super();
        this.registry = new j();
        this.model = challengeModel;
        this.resources = resources;
        this.utilities = v2Var;
        this.id = challengeModel.getId();
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.registry.a(aVar);
    }

    public String getDescription() {
        return this.model.getDescription();
    }

    public boolean getHasEnded() {
        return this.model.isHasEnded(this.utilities);
    }

    public String getImageUrl() {
        return this.model.getImageUrl();
    }

    public ChallengeModel getModel() {
        return this.model;
    }

    public String getName() {
        return this.model.getName();
    }

    public String getTimeLeft() throws android.content.res.Resources.NotFoundException {
        if (this.model.isHasEnded(this.utilities)) {
            return "";
        }
        Object[] arr = new Object[1];
        return this.resources.getString(2131886325, new Object[] { this.model.getTimeLeft(this.utilities) });
    }

    public boolean isTimeVisible() {
        return !this.model.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING);
    }

    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    public void refreshCard(ChallengeModel challengeModel) {
        this.model = challengeModel;
        updateView();
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.registry.j(aVar);
    }

    public void updateView() {
        notifyChange(157);
        notifyChange(159);
        notifyChange(77);
    }

    public ChallengePagerCardItem(ChallengeModel challengeModel) {
        this(challengeModel, App.onCreate().getResources(), App.p());
    }
}
