package app.dogo.com.dogo_android.d.d.r;

import android.content.Context;
import android.content.res.Resources;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeProfileObservable.kt */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u008d\u0001\u0008\u0007\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010*\u001a\u00020(J\u0008\u0010+\u001a\u00020(H\u0016J\u0008\u0010,\u001a\u00020(H\u0016J\u0006\u0010-\u001a\u00020.J\"\u0010/\u001a\u00020.2\u0008\u00100\u001a\u0004\u0018\u0001012\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00102\u001a\u00020(J\u0010\u00103\u001a\u00020.2\u0008\u00104\u001a\u0004\u0018\u000105J\u0010\u00106\u001a\u00020.2\u0008\u00104\u001a\u0004\u0018\u000105R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008 \u0010\u001eR\u0011\u0010!\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u001eR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u001c8G¢\u0006\u0006\u001a\u0004\u0008&\u0010\u001eR\u0011\u0010'\u001a\u00020(8G¢\u0006\u0006\u001a\u0004\u0008'\u0010)R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileObservable;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "resources", "Landroid/content/res/Resources;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "challengeAgeString", "", "getChallengeAgeString", "()Ljava/lang/String;", "challengeAvatar", "getChallengeAvatar", "challengeId", "getChallengeId", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeTitle", "getChallengeTitle", "isChallengeActive", "", "()Z", "isAdmin", "isBorderVisible", "isWinner", "notifyViewChange", "", "setModel", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "isPremium", "tryToShowShareAppPopUp", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "tryToTriggerRateItDialog", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ChallengeProfileObservable extends EntryPhotoBaseObservable {

    private final q2 a;
    private final v2 b;
    private final Resources c;
    /* renamed from: v, reason: from kotlin metadata */
    private ChallengeModel challengeModel;
    public /* synthetic */ f(m2 m2Var, h2 h2Var, o3 o3Var, q2 q2Var, u2 u2Var, v2 v2Var, Resources resources, t2 t2Var, i2 i2Var, a1 a1Var, k2 k2Var, p2 p2Var, int i, g gVar) {
        p2 p2Var122;
        m2 m2Var2;
        h2 h2Var22;
        o3 o3Var32;
        q2 q2Var42;
        u2 u2Var52;
        v2 v2Var62;
        Resources resources72;
        t2 t2Var82;
        i2 i2Var92;
        a1 a1Var102;
        k2 k2Var112;
        int i132 = i;
        if (i132 & 1 != 0) {
            m2Var2 = App.INSTANCE.j();
        } else {
            m2Var2 = m2Var;
        }
        if (i132 & 2 != 0) {
            h2Var22 = App.INSTANCE.c();
        } else {
            h2Var22 = h2Var;
        }
        if (i132 & 4 != 0) {
            o3Var32 = App.INSTANCE.r();
        } else {
            o3Var32 = o3Var;
        }
        if (i132 & 8 != 0) {
            q2Var42 = App.INSTANCE.m();
        } else {
            q2Var42 = q2Var;
        }
        if (i132 & 16 != 0) {
            u2Var52 = App.INSTANCE.h();
        } else {
            u2Var52 = u2Var;
        }
        if (i132 & 32 != 0) {
            v2Var62 = App.INSTANCE.t();
        } else {
            v2Var62 = v2Var;
        }
        if (i132 & 64 != 0) {
            str = "appContext.resources";
            n.e(App.INSTANCE.b().getResources(), str);
        } else {
            resources72 = resources;
        }
        if (i132 & 128 != 0) {
            t2Var82 = App.INSTANCE.p();
        } else {
            t2Var82 = t2Var;
        }
        if (i132 & 256 != 0) {
            i2Var92 = App.INSTANCE.d();
        } else {
            i2Var92 = i2Var;
        }
        if (i132 & 512 != 0) {
            a1Var102 = App.INSTANCE.f();
        } else {
            a1Var102 = a1Var;
        }
        if (i132 & 1024 != 0) {
            k2Var112 = App.INSTANCE.g();
        } else {
            k2Var112 = k2Var;
        }
        if (i132 & 2048 != 0) {
            p2Var122 = App.INSTANCE.l();
        } else {
            p2Var122 = p2Var;
        }
        this(m2Var2, h2Var22, o3Var32, q2Var42, u2Var52, v2Var62, resources72, t2Var82, i2Var92, a1Var102, k2Var112, p2Var122);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    /* renamed from: g, reason: from kotlin metadata */
    public final String isAdmin() throws android.content.res.Resources.NotFoundException {
        String hideKeyboard;
        if (l()) {
            str = "{\n            resources.getString(R.string.challenge_this_week)\n        }";
            n.e(this.c.getString(2131886324), str);
        } else {
            n.d(this.challengeModel);
            hideKeyboard = this.b.hideKeyboard(this.challengeModel.getStartDate());
        }
        return hideKeyboard;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String h() {
        n.d(this.challengeModel);
        return this.challengeModel.getImageUrl();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String i() {
        n.d(this.challengeModel);
        return this.challengeModel.getId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        return isCurrentUserEntriesAuthor();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String j() {
        n.d(this.challengeModel);
        return this.challengeModel.getName();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean k() {
        return App.INSTANCE.c().C();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean l() {
        boolean z = true;
        n.d(this.challengeModel);
        long endDate = this.challengeModel.getEndDate();
        long l = this.b.g();
        int r0 = endDate > l ? 1 : 0;
        return (endDate > l ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final void m() {
        notifyChange(33);
        notifyChange(37);
        notifyChange(35);
        notifyChange(34);
        updateEntryView();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    /* renamed from: n, reason: from kotlin metadata */
    public final void setModel(ChallengeEntryModel model, ChallengeModel challengeModel, boolean isPremium) {
        this.challengeModel = challengeModel;
        super.setModel(model, isPremium);
        updateEntryView();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    /* renamed from: o, reason: from kotlin metadata */
    public final void tryToShowShareAppPopUp(a0 navigator) {
        final q2.a pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
        if (this.a.shouldTriggerReminderPopUp(pHOTO_LIKE2.getTag())) {
            n.d(navigator);
            this.a.showShareDialog(navigator, RateItService_RateSource.PHOTO_LIKE);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    /* renamed from: p, reason: from kotlin metadata */
    public final void tryToTriggerRateItDialog(a0 navigator) {
        final q2.a pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
        if (this.a.shouldTriggerRateUsPopUp(pHOTO_LIKE2.getTag())) {
            n.d(navigator);
            this.a.callDialog(navigator, RateItService_RateSource.PHOTO_LIKE);
        }
    }

    public f(m2 m2Var, h2 h2Var, o3 o3Var, q2 q2Var, u2 u2Var, v2 v2Var, Resources resources, t2 t2Var, i2 i2Var, a1 a1Var, k2 k2Var, p2 p2Var) {
        final Object m2Var3 = this;
        final Object q2Var42 = q2Var;
        final Object v2Var62 = v2Var;
        final Object h2Var22 = h2Var;
        n.f(h2Var22, "authService");
        n.f(q2Var42, "rateItService");
        n.f(v2Var62, "utilities");
        n.f(resources, "resources");
        n.f(i2Var, "cloudFunctionsService");
        super(m2Var, h2Var22, o3Var, q2Var, u2Var, v2Var, resources, a1Var, t2Var, k2Var, p2Var, i2Var);
        m2Var3.a = q2Var42;
        m2Var3.b = v2Var62;
        m2Var3.c = resources;
    }

    public f() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isWinner() {
        return false;
    }
}
