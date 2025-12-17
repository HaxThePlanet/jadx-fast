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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u008d\u0001\u0008\u0007\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010*\u001a\u00020(J\u0008\u0010+\u001a\u00020(H\u0016J\u0008\u0010,\u001a\u00020(H\u0016J\u0006\u0010-\u001a\u00020.J\"\u0010/\u001a\u00020.2\u0008\u00100\u001a\u0004\u0018\u0001012\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00102\u001a\u00020(J\u0010\u00103\u001a\u00020.2\u0008\u00104\u001a\u0004\u0018\u000105J\u0010\u00106\u001a\u00020.2\u0008\u00104\u001a\u0004\u0018\u000105R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008 \u0010\u001eR\u0011\u0010!\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u001eR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u001c8G¢\u0006\u0006\u001a\u0004\u0008&\u0010\u001eR\u0011\u0010'\u001a\u00020(8G¢\u0006\u0006\u001a\u0004\u0008'\u0010)R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileObservable;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "resources", "Landroid/content/res/Resources;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "challengeAgeString", "", "getChallengeAgeString", "()Ljava/lang/String;", "challengeAvatar", "getChallengeAvatar", "challengeId", "getChallengeId", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeTitle", "getChallengeTitle", "isChallengeActive", "", "()Z", "isAdmin", "isBorderVisible", "isWinner", "notifyViewChange", "", "setModel", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "isPremium", "tryToShowShareAppPopUp", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "tryToTriggerRateItDialog", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends EntryPhotoBaseObservable {

    private final q2 a;
    private final v2 b;
    private final Resources c;
    private ChallengeModel v;
    public f() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
    }

    public f(m2 m2, h2 h22, o3 o33, q2 q24, u2 u25, v2 v26, Resources resources7, t2 t28, i2 i29, a1 a110, k2 k211, p2 p212) {
        final Object obj5 = this;
        final Object obj6 = q24;
        final Object obj7 = v26;
        final Object obj2 = h22;
        n.f(obj2, "authService");
        n.f(obj6, "rateItService");
        n.f(obj7, "utilities");
        n.f(resources7, "resources");
        n.f(i29, "cloudFunctionsService");
        super(m2, obj2, o33, q24, u25, v26, resources7, a110, t28, k211, p212, i29);
        obj5.a = obj6;
        obj5.b = obj7;
        obj5.c = resources7;
    }

    public f(m2 m2, h2 h22, o3 o33, q2 q24, u2 u25, v2 v26, Resources resources7, t2 t28, i2 i29, a1 a110, k2 k211, p2 p212, int i13, g g14) {
        p2 p2Var;
        m2 m2Var;
        h2 h2Var;
        o3 o3Var;
        q2 q2Var;
        u2 u2Var;
        v2 v2Var;
        Resources resources;
        String str;
        t2 t2Var;
        i2 i2Var;
        a1 a1Var;
        k2 k2Var;
        int i = i13;
        if (i & 1 != 0) {
            m2Var = App.Companion.j();
        } else {
            m2Var = m2;
        }
        if (i & 2 != 0) {
            h2Var = App.Companion.c();
        } else {
            h2Var = h22;
        }
        if (i & 4 != 0) {
            o3Var = App.Companion.r();
        } else {
            o3Var = o33;
        }
        if (i & 8 != 0) {
            q2Var = App.Companion.m();
        } else {
            q2Var = q24;
        }
        if (i & 16 != 0) {
            u2Var = App.Companion.h();
        } else {
            u2Var = u25;
        }
        if (i & 32 != 0) {
            v2Var = App.Companion.t();
        } else {
            v2Var = v26;
        }
        if (i & 64 != 0) {
            n.e(App.Companion.b().getResources(), "appContext.resources");
        } else {
            resources = resources7;
        }
        if (i & 128 != 0) {
            t2Var = App.Companion.p();
        } else {
            t2Var = t28;
        }
        if (i & 256 != 0) {
            i2Var = App.Companion.d();
        } else {
            i2Var = i29;
        }
        if (i & 512 != 0) {
            a1Var = App.Companion.f();
        } else {
            a1Var = a110;
        }
        if (i & 1024 != 0) {
            k2Var = App.Companion.g();
        } else {
            k2Var = k211;
        }
        if (i &= 2048 != 0) {
            p2Var = App.Companion.l();
        } else {
            p2Var = p212;
        }
        super(m2Var, h2Var, o3Var, q2Var, u2Var, v2Var, resources, t2Var, i2Var, a1Var, k2Var, p2Var);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String g() {
        String string;
        String startDate;
        if (l()) {
            n.e(this.c.getString(2131886324), "{\n            resources.getString(R.string.challenge_this_week)\n        }");
        } else {
            ChallengeModel challengeModel = this.v;
            n.d(challengeModel);
            string = this.b.l(challengeModel.getStartDate());
        }
        return string;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String h() {
        ChallengeModel challengeModel = this.v;
        n.d(challengeModel);
        return challengeModel.getImageUrl();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String i() {
        ChallengeModel challengeModel = this.v;
        n.d(challengeModel);
        return challengeModel.getId();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        return isCurrentUserEntriesAuthor();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isWinner() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String j() {
        ChallengeModel challengeModel = this.v;
        n.d(challengeModel);
        return challengeModel.getName();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean k() {
        return App.Companion.c().C();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean l() {
        int i;
        ChallengeModel challengeModel = this.v;
        n.d(challengeModel);
        i = Long.compare(endDate, l) > 0 ? 1 : 0;
        return i;
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
    public final void n(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, boolean z3) {
        this.v = challengeModel2;
        super.setModel(challengeEntryModel, z3);
        updateEntryView();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final void o(a0 a0) {
        boolean z;
        final q2.a pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (this.a.k(pHOTO_LIKE.getTag())) {
            n.d(a0);
            this.a.u(a0, pHOTO_LIKE);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final void p(a0 a0) {
        boolean z;
        final q2.a pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (this.a.j(pHOTO_LIKE.getTag())) {
            n.d(a0);
            this.a.a(a0, pHOTO_LIKE);
        }
    }
}
