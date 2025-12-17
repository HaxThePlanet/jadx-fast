package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.Context;
import android.content.res.Resources;
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
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.w.o3;

/* loaded from: classes.dex */
public class EntryOldPhotoObservable extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable {

    private a1 challengeLocalRepository;
    private i2 cloudFunctionsService;
    private boolean firstRunnerUp;
    private Resources resources;
    private boolean winner;
    public EntryOldPhotoObservable() {
        super(App.h(), App.b(), App.e(), App.a().getResources(), App.o(), App.j(), App.g(), App.m(), App.p(), App.f(), App.c(), App.i());
    }

    public EntryOldPhotoObservable(m2 m2, h2 h22, a1 a13, Resources resources4, o3 o35, q2 q26, u2 u27, t2 t28, v2 v29, k2 k210, i2 i211, p2 p212) {
        final Object obj2 = this;
        super(m2, h22, o35, q26, u27, v29, resources4, a13, t28, k210, p212, i211);
        obj2.challengeLocalRepository = a13;
        obj2.resources = resources4;
        obj2.cloudFunctionsService = i211;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getMedalUrl() {
        int medalImageUrl;
        if (getModel() == null) {
            return null;
        }
        ChallengeModel challengeModel = this.challengeLocalRepository.a(getModel().getChallengeId());
        if (challengeModel != null) {
            medalImageUrl = challengeModel.getMedalImageUrl();
        }
        return medalImageUrl;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getWinnerString() {
        String name;
        if (getModel() == null) {
            return null;
        }
        ChallengeModel challengeModel = this.challengeLocalRepository.a(getModel().getChallengeId());
        if (challengeModel != null) {
            name = challengeModel.getName();
        } else {
            name = "";
        }
        Object[] arr = new Object[1];
        return this.resources.getString(2131886278, name);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        int i;
        boolean currentUserEntriesAuthor;
        if (!isWinner()) {
            if (isCurrentUserEntriesAuthor()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isFirstRunnerUp() {
        return this.firstRunnerUp;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isWinner() {
        return this.winner;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setModel(ChallengeEntryModel challengeEntryModel, int i2, boolean z3, boolean z4) {
        int i;
        int obj2;
        setModel(challengeEntryModel, z4);
        final int obj5 = 1;
        if (i2 == 0 && !z3) {
            i = !z3 ? obj5 : obj2;
        } else {
        }
        this.winner = i;
        if (i2 == obj5 && !z3) {
            if (!z3) {
                obj2 = obj5;
            }
        }
        this.firstRunnerUp = obj2;
        update();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void update() {
        updateEntryView();
        notifyChange(71);
        notifyChange(188);
        notifyChange(107);
    }
}
