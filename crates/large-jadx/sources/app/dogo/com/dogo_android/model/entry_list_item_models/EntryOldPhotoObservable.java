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

/* compiled from: EntryOldPhotoObservable.java */
/* loaded from: classes.dex */
public class EntryOldPhotoObservable extends EntryPhotoBaseObservable {

    private a1 challengeLocalRepository;
    private i2 cloudFunctionsService;
    private boolean firstRunnerUp;
    private Resources resources;
    private boolean winner;
    public EntryOldPhotoObservable() {
        this(App.h(), App.b(), App.e(), App.onCreate().getResources(), App.o(), App.j(), App.g(), App.m(), App.p(), App.f(), App.c(), App.i());
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getMedalUrl() {
        int i = 0;
        i = 0;
        if (getModel() == null) {
            return null;
        }
        ChallengeModel challengeModel = this.challengeLocalRepository.a(getModel().getChallengeId());
        if (challengeModel != null) {
            String medalImageUrl = challengeModel.getMedalImageUrl();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getWinnerString() throws android.content.res.Resources.NotFoundException {
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
        return this.resources.getString(2131886278, new Object[] { name });
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        boolean z = false;
        if (isWinner() || this.isCurrentUserEntriesAuthor()) {
            int i2 = 1;
        }
        return z;
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
    public void setModel(ChallengeEntryModel challengeEntryModel, int i, boolean z, boolean z2) {
        int challengeEntryModel2;
        setModel(challengeEntryModel, z2);
        challengeEntryModel2 = 0;
        challengeEntryModel2 = 1;
        int r0 = i == 0 && !z ? challengeEntryModel2 : 0;
        this.winner = (i == 0 && !z ? challengeEntryModel2 : 0);
        if (i == challengeEntryModel2 && !z) {
        }
        this.firstRunnerUp = challengeEntryModel2;
        update();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void update() {
        updateEntryView();
        notifyChange(71);
        notifyChange(188);
        notifyChange(107);
    }

    public EntryOldPhotoObservable(m2 m2Var, h2 h2Var, a1 a1Var, Resources resources, o3 o3Var, q2 q2Var, u2 u2Var, t2 t2Var, v2 v2Var, k2 k2Var, i2 i2Var, p2 p2Var) {
        final Object m2Var3 = this;
        super(m2Var, h2Var, o3Var, q2Var, u2Var, v2Var, resources, a1Var, t2Var, k2Var, p2Var, i2Var);
        m2Var3.challengeLocalRepository = a1Var;
        m2Var3.resources = resources;
        m2Var3.cloudFunctionsService = i2Var;
    }
}
