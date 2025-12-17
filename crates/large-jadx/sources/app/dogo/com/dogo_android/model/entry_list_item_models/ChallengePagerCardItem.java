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

/* loaded from: classes.dex */
public class ChallengePagerCardItem implements h {

    public String id;
    private ChallengeModel model;
    private final j registry;
    private Resources resources;
    private v2 utilities;
    public ChallengePagerCardItem(ChallengeModel challengeModel) {
        super(challengeModel, App.a().getResources(), App.p());
    }

    public ChallengePagerCardItem(ChallengeModel challengeModel, Resources resources2, v2 v23) {
        super();
        j jVar = new j();
        this.registry = jVar;
        this.model = challengeModel;
        this.resources = resources2;
        this.utilities = v23;
        this.id = challengeModel.getId();
    }

    @Override // androidx.databinding.h
    public void addOnPropertyChangedCallback(h.a h$a) {
        this.registry.a(a);
    }

    @Override // androidx.databinding.h
    public String getDescription() {
        return this.model.getDescription();
    }

    @Override // androidx.databinding.h
    public boolean getHasEnded() {
        return this.model.isHasEnded(this.utilities);
    }

    @Override // androidx.databinding.h
    public String getImageUrl() {
        return this.model.getImageUrl();
    }

    @Override // androidx.databinding.h
    public ChallengeModel getModel() {
        return this.model;
    }

    @Override // androidx.databinding.h
    public String getName() {
        return this.model.getName();
    }

    @Override // androidx.databinding.h
    public String getTimeLeft() {
        if (this.model.isHasEnded(this.utilities)) {
            return "";
        }
        Object[] arr = new Object[1];
        return this.resources.getString(2131886325, this.model.getTimeLeft(this.utilities));
    }

    @Override // androidx.databinding.h
    public boolean isTimeVisible() {
        return equals ^= 1;
    }

    @Override // androidx.databinding.h
    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    @Override // androidx.databinding.h
    public void refreshCard(ChallengeModel challengeModel) {
        this.model = challengeModel;
        updateView();
    }

    @Override // androidx.databinding.h
    public void removeOnPropertyChangedCallback(h.a h$a) {
        this.registry.j(a);
    }

    @Override // androidx.databinding.h
    public void updateView() {
        notifyChange(157);
        notifyChange(159);
        notifyChange(77);
    }
}
