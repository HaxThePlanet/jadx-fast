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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;)V", "bitmap", "Landroid/net/Uri;", "getBitmap", "()Landroid/net/Uri;", "setBitmap", "(Landroid/net/Uri;)V", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "cancel", "", "nav", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "generateSharingLink", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "linkType", "", "setArguments", "", "bundle", "Landroid/os/Bundle;", "trackInstagramShare", "trackSharingLink", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    private final o3 a;
    private final k2 b;
    private final a1 c;
    private ChallengeEntryModel d;
    public Uri e;
    private ChallengeModel f;
    public f(o3 o3, k2 k22, a1 a13) {
        n.f(o3, "tracker");
        n.f(k22, "dynamicLinkService");
        n.f(a13, "challengeLocalRepository");
        super();
        this.a = o3;
        this.b = k22;
        this.c = a13;
    }

    public final j<ShortDynamicLink> h(String string) {
        n.f(string, "linkType");
        final ChallengeEntryModel challengeEntryModel = this.d;
        final int i = 0;
        if (challengeEntryModel == null) {
        } else {
            final ChallengeModel challengeModel = this.f;
            if (challengeModel == null) {
            } else {
                return this.b.d(string, challengeEntryModel, challengeModel);
            }
            n.w("challengeModel");
            throw i;
        }
        n.w("model");
        throw i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri i() {
        Uri uri = this.e;
        if (uri == null) {
        } else {
            return uri;
        }
        n.w("bitmap");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean j(Bundle bundle) {
        android.os.Parcelable parcelable;
        ChallengeModel challengeModel;
        String challengeId;
        android.os.Parcelable obj4;
        if (bundle != null) {
            parcelable = bundle.getParcelable("bitmap");
            obj4 = bundle.getParcelable("model");
            if ((ChallengeEntryModel)obj4 == null) {
                challengeId = 0;
            } else {
                challengeId = (ChallengeEntryModel)obj4.getChallengeId();
            }
            challengeModel = this.c.a(challengeId);
            if ((Uri)parcelable != null && obj4 != null && challengeModel != null) {
                if (obj4 != null) {
                    if (challengeModel != null) {
                        this.d = obj4;
                        k((Uri)parcelable);
                        this.f = challengeModel;
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k(Uri uri) {
        n.f(uri, "<set-?>");
        this.e = uri;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        i1 i1Var = new i1();
        ChallengeEntryModel challengeEntryModel = this.d;
        int i = 0;
        final String str = "model";
        if (challengeEntryModel == null) {
        } else {
            c1 c1Var = new c1();
            final ChallengeEntryModel challengeEntryModel2 = this.d;
            if (challengeEntryModel2 == null) {
            } else {
                this.a.d(t.b.c(i1Var, challengeEntryModel.getDocumentId(), c1Var, challengeEntryModel2.getChallengeId()));
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        i1 i1Var = new i1();
        ChallengeEntryModel challengeEntryModel = this.d;
        int i = 0;
        final String str = "model";
        if (challengeEntryModel == null) {
        } else {
            c1 c1Var = new c1();
            final ChallengeEntryModel challengeEntryModel2 = this.d;
            if (challengeEntryModel2 == null) {
            } else {
                this.a.d(t.a.c(i1Var, challengeEntryModel.getDocumentId(), c1Var, challengeEntryModel2.getChallengeId()));
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }
}
