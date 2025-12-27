package app.dogo.com.dogo_android.d.f;

import android.net.Uri;
import android.os.Bundle;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.v2;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeShareViewModel.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;)V", "bitmap", "Landroid/net/Uri;", "getBitmap", "()Landroid/net/Uri;", "setBitmap", "(Landroid/net/Uri;)V", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "cancel", "", "nav", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "generateSharingLink", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "linkType", "", "setArguments", "", "bundle", "Landroid/os/Bundle;", "trackInstagramShare", "trackSharingLink", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ChallengeShareViewModel extends s {

    private final o3 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final k2 challengeLocalRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final a1 challengeModel;
    /* renamed from: d, reason: from kotlin metadata */
    private ChallengeEntryModel dynamicLinkService;
    /* renamed from: e, reason: from kotlin metadata */
    public Uri model;
    /* renamed from: f, reason: from kotlin metadata */
    private ChallengeModel tracker;
    public f(o3 o3Var, k2 k2Var, a1 a1Var) {
        n.f(o3Var, "tracker");
        n.f(k2Var, "dynamicLinkService");
        n.f(a1Var, "challengeLocalRepository");
        super();
        this.a = o3Var;
        this.challengeLocalRepository = k2Var;
        this.challengeModel = a1Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final j<ShortDynamicLink> cancel(String nav) {
        n.f(nav, "linkType");
        final int i = 0;
        if (this.dynamicLinkService == null) {
            n.w("model");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            if (this.tracker == null) {
                n.w("challengeModel");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                return this.challengeLocalRepository.generateSharingLink(nav, this.dynamicLinkService, this.tracker);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final Uri trackInstagramShare() {
        if (this.model == null) {
            n.w("bitmap");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.model;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: j, reason: from kotlin metadata */
    public final boolean generateSharingLink(Bundle linkType) {
        String challengeId = null;
        if (linkType != null) {
            android.os.Parcelable parcelable = linkType.getParcelable("bitmap");
            android.os.Parcelable parcelable2 = linkType.getParcelable("model");
            if (parcelable2 == null) {
                int i = 0;
            } else {
                challengeId = parcelable2.getChallengeId();
            }
            ChallengeModel challenge = this.challengeModel.getChallenge(challengeId);
            if (parcelable != null && parcelable2 != null && challenge != null) {
                this.dynamicLinkService = parcelable2;
                setArguments(parcelable);
                this.tracker = challenge;
                return true;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final void setArguments(Uri bundle) {
        n.f(bundle, "<set-?>");
        this.model = bundle;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        int i = 0;
        final String str = "model";
        if (this.dynamicLinkService == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            if (this.dynamicLinkService == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.a.logEvent(E_ChallengeSharing.b.c(new EP_EntryId(), this.dynamicLinkService.getDocumentId(), new EP_ChallengeId(), this.dynamicLinkService.getChallengeId()));
                return;
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        int i = 0;
        final String str = "model";
        if (this.dynamicLinkService == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            if (this.dynamicLinkService == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.a.logEvent(E_ChallengeSharing.a.c(new EP_EntryId(), this.dynamicLinkService.getDocumentId(), new EP_ChallengeId(), this.dynamicLinkService.getChallengeId()));
                return;
            }
        }
    }
}
