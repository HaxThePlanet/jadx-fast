package app.dogo.com.dogo_android.a0.g.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.databinding.i;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.p;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.g2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.exceptions.ExceptionForTaskChain;
import app.dogo.com.dogo_android.util.o0.a;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 l2\u00020\u0001:\u0001lBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010<\u001a\u00020=J&\u0010>\u001a\u0008\u0012\u0004\u0012\u00020.0?2\u0016\u0010@\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010B0AH\u0002J\u0006\u0010C\u001a\u00020=J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020.J\u0010\u0010G\u001a\u00020=2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u000e\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u000c\u0010L\u001a\u0008\u0012\u0004\u0012\u00020.0?J\u000e\u0010M\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ8\u0010N\u001a\u00020=2\u0006\u0010I\u001a\u00020J2\u0008\u0010O\u001a\u0004\u0018\u00010\u001c2\u0006\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020.2\u0006\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020.J\u000e\u0010T\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u0008\u0010U\u001a\u00020=H\u0002J\u001c\u0010V\u001a\u00020=2\u0008\u0010W\u001a\u0004\u0018\u00010X2\u0008\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0008\u0010Y\u001a\u00020=H\u0002J\u000e\u0010Z\u001a\u00020.2\u0006\u0010[\u001a\u00020\\J\u0008\u0010]\u001a\u00020=H\u0002JZ\u0010^\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010B0A2\u0006\u0010_\u001a\u0002072\u0008\u0010`\u001a\u0004\u0018\u00010\u00192\u0008\u0010&\u001a\u0004\u0018\u00010\u00192\u0008\u0010a\u001a\u0004\u0018\u00010\u00192\u0008\u0010b\u001a\u0004\u0018\u00010\u00192\u0008\u0010c\u001a\u0004\u0018\u00010\u00192\u0008\u0010d\u001a\u0004\u0018\u00010\u0019J \u0010e\u001a\u00020=2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010a\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H\u0002J\u0010\u0010g\u001a\u00020.2\u0008\u0010h\u001a\u0004\u0018\u00010*J\u0010\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0010\u0012\u000c\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010'\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008(\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u0008-\u0010/R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00080\u0010/R\u0011\u00101\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00081\u0010/R\u0011\u00102\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00082\u0010/R\u001e\u00103\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020.@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010/R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001909X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "appIntentServiceManager", "Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "context", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;Lapp/dogo/com/dogo_android/service/PreferenceService;Landroid/content/Context;)V", "captionField", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "comment", "connectivityManager", "Landroid/net/ConnectivityManager;", "dogAvatar", "getDogAvatar", "()Ljava/lang/String;", "entryId", "image", "getImage", "imageUri", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "isChallengeEnded", "", "()Z", "isConnected", "isPolicyAccepted", "isSizeCorrect", "isUserEntryListReady", "lastPublishClickTimestampMs", "", "selectedDog", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "userEntryIdList", "", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "checkIfEntryIsValidAndStartUpload", "Lcom/google/android/gms/tasks/Task;", "entryData", "", "", "detachUserEntryListener", "imageSizes", "", "isPublishClickTimeoutOver", "markUploadAsFailed", "onCancelClick", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onChangeClick", "onPublishClick", "onTermsClick", "openChallengeDetailsDialog", "model", "showCheckBox", "scrollToPrize", "scrollToRules", "shouldTriggerPublish", "openPolicyAcceptWindow", "pingToSwitchToYourTab", "refreshView", "caller", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "resetUserEntryListReady", "setArguments", "arguments", "Landroid/os/Bundle;", "setUserEntryListReady", "setupEntryData", "dogProfile", "userId", "challengeId", "entryType", "caption", "countryCode", "startPhotoUpload", "photoId", "tempSaveImage", "imagePath", "transformRemoteErrorCodeToLocalErrorCode", "", "remoteErrorCode", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e0 extends r {

    public static final app.dogo.com.dogo_android.a0.g.f.e0.a Companion;
    private final h2 A;
    private final m2 B;
    private final p1 C;
    private final o3 D;
    private final v2 E;
    private final i2 F;
    private final g2 G;
    private final p2 H;
    public i<String> I;
    private LiteDogProfile J;
    private ChallengeModel K;
    private String L;
    private String M;
    private final ConnectivityManager N;
    private boolean O;
    private final Set<String> P;
    private ListenerRegistration Q;
    private long R;
    private final t2 z;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel$Companion;", "", "()V", "ENTRY_IMAGE_NAME", "", "ERROR_ALREADY_PARTICIPATED", "", "ERROR_INVALID_ENTRY_ID", "ERROR_INVALID_RESPONSE", "ERROR_NO_DOG_SELECTED", "ERROR_VALIDATION_FAILED", "MAX_ENTRIES", "MINIMUM_IMAGE_SIZE", "PUBLISH_DEBOUNCE_MILLIS", "TEMP_ENTRY_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        e0.a aVar = new e0.a(0);
        e0.Companion = aVar;
    }

    public e0(t2 t2, h2 h22, m2 m23, p1 p14, o3 o35, v2 v26, i2 i27, g2 g28, p2 p29, Context context10) {
        n.f(t2, "storageService");
        n.f(h22, "authService");
        n.f(m23, "firestoreService");
        n.f(p14, "userRepository");
        n.f(o35, "tracker");
        n.f(v26, "utilities");
        n.f(i27, "cloudFunctionsService");
        n.f(g28, "appIntentServiceManager");
        n.f(p29, "preferenceService");
        n.f(context10, "context");
        super();
        this.z = t2;
        this.A = h22;
        this.B = m23;
        this.C = p14;
        this.D = o35;
        this.E = v26;
        this.F = i27;
        this.G = g28;
        this.H = p29;
        i obj2 = new i("");
        this.I = obj2;
        obj2 = context10.getSystemService("connectivity");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.N = (ConnectivityManager)obj2;
        obj2 = new HashSet();
        this.P = obj2;
    }

    public static void L(app.dogo.com.dogo_android.a0.g.f.e0 e0, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        e0.x(e0, querySnapshot2, firebaseFirestoreException3);
    }

    public static Boolean M(app.dogo.com.dogo_android.a0.g.f.e0 e0, j j2) {
        return e0.z(e0, j2);
    }

    private final void N(String string) {
        this.B.r0(string);
    }

    private final void U() {
        Bundle bundle = new Bundle();
        j(h.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB, bundle);
    }

    private final void V() {
        this.O = false;
    }

    private final void X() {
        this.O = true;
    }

    private final void Z(String string, String string2, String string3) {
        Object c1Var;
        Object obj6;
        String obj7;
        app.dogo.com.dogo_android.w.h3 obj8;
        this.z.n("entryTemp", "challenge_pending", "entry.jpg", n.o(string, ".jpg"));
        if (this.G.a(string, p.entry_photo.setChallengeId(string2).setId(string).setPhotoId(string3).getPath())) {
            c1Var = new c1();
            this.D.d(u.t.c(c1Var, string2));
            U();
            this.C.e(string2);
        } else {
            v(2131886123);
            N(string);
        }
    }

    private final int b0(int i) {
        int i2;
        final int i3 = 1;
        if (i != i3) {
            i2 = i != 2 ? i3 : 4;
        }
        return i2;
    }

    private static final void x(app.dogo.com.dogo_android.a0.g.f.e0 e0, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        Set set;
        String str;
        Iterator obj3;
        String obj4;
        n.f(e0, "this$0");
        if (querySnapshot2 != null) {
            e0.X();
            obj3 = querySnapshot2.iterator();
            for (QueryDocumentSnapshot obj4 : obj3) {
                obj4 = obj4.getId();
                n.e(obj4, "doc.id");
                e0.P.add(obj4);
            }
        }
    }

    private final j<Boolean> y(Map<String, ? extends Object> map) {
        c cVar = new c(this);
        j obj2 = this.F.a(map).continueWith(cVar);
        n.e(obj2, "cloudFunctionsService.checkIfEntryUpdateIsValid(entryData).continueWith { task: Task<EntryValidationResponse> ->\n            val response = task.result\n            if (!response.isResponseDataValid) {\n                val errorResponse = transformRemoteErrorCodeToLocalErrorCode(response.errorCode)\n                throw ExceptionForTaskChain(errorResponse)\n            }\n            startPhotoUpload(response.entryId, challengeModel!!.id, response.imageId)\n            true\n        }");
        return obj2;
    }

    private static final Boolean z(app.dogo.com.dogo_android.a0.g.f.e0 e0, j j2) {
        n.f(e0, "this$0");
        n.f(j2, "task");
        Object obj4 = j2.getResult();
        if (!(a)obj4.d()) {
        } else {
            String str3 = obj4.a();
            n.e(str3, "response.entryId");
            ChallengeModel challengeModel = e0.B();
            n.d(challengeModel);
            obj4 = obj4.c();
            n.e(obj4, "response.imageId");
            e0.Z(str3, challengeModel.getId(), obj4);
            return Boolean.TRUE;
        }
        obj4 = new ExceptionForTaskChain(e0.b0(obj4.b()));
        throw obj4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void A() {
        ListenerRegistration list;
        list = this.Q;
        if (list != null) {
            n.d(list);
            list.remove();
            this.Q = 0;
            V();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel B() {
        return this.K;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String C() {
        int path;
        Uri uri = this.z.h("entryTemp", "entry.jpg");
        if (uri == null) {
            path = 0;
        } else {
            path = uri.getPath();
        }
        return path;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final Uri D() {
        return this.z.h("entryTemp", "entry.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int[] E() {
        return this.z.e(D());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean F() {
        boolean hasEnded;
        v2 v2Var;
        ChallengeModel challengeModel = this.K;
        if (challengeModel != null) {
            n.d(challengeModel);
            hasEnded = challengeModel.isHasEnded(this.E);
        } else {
            hasEnded = 1;
        }
        return hasEnded;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean G() {
        NetworkInfo connectedOrConnecting;
        int i;
        connectedOrConnecting = this.N.getActiveNetworkInfo();
        if (connectedOrConnecting != null && connectedOrConnecting.isConnectedOrConnecting()) {
            i = connectedOrConnecting.isConnectedOrConnecting() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean H() {
        return this.C.L("challenge_terms_v1");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean I() {
        int i;
        if (Long.compare(l, i2) > 0) {
            this.R = this.E.g();
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J() {
        int[] iArr;
        int i;
        Uri uri = this.z.h("entryTemp", "entry.jpg");
        i = 0;
        if (uri == null) {
            return i;
        }
        iArr = this.z.e(uri);
        final int i3 = 1;
        final int i4 = 800;
        if (iArr[i] >= i4 && iArr[i3] >= i4) {
            if (iArr[i3] >= i4) {
                i = i3;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean K() {
        return this.O;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void O(a0 a0) {
        n.f(a0, "navigator");
        this.D.c(u.y);
        a0.r(c.CHALLENGE_ENTRY_CREATION);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void P(a0 a0) {
        n.f(a0, "navigator");
        final int i2 = 800;
        a0.B0(false, i2, i2);
    }

    public final j<Boolean> Q() {
        Object obj;
        j jVar;
        String str;
        int i2;
        String str3;
        String str2;
        String entryType;
        Object obj2;
        String str4;
        int i;
        LiteDogProfile liteDogProfile = this.J;
        if (liteDogProfile != null) {
            obj = this.I.d();
            i = 1;
            if ((String)obj != null) {
                i2 = (String)obj.length() == 0 ? i : 0;
                if (i2 != 0) {
                    obj = 0;
                }
            }
            ChallengeModel challengeModel = this.K;
            n.d(challengeModel);
            ChallengeModel challengeModel2 = this.K;
            n.d(challengeModel2);
            if (this.M == null && empty ^= i != 0) {
                if (empty ^= i != 0) {
                    ExceptionForTaskChain exceptionForTaskChain2 = new ExceptionForTaskChain(3);
                    n.e(m.d(exceptionForTaskChain2), "{\n                Tasks.forException(ExceptionForTaskChain(ERROR_INVALID_ENTRY_ID))\n            }");
                } else {
                    jVar = y(this.Y(liteDogProfile, this.A.v(), this.M, challengeModel.getId(), challengeModel2.getEntryType(), obj, this.H.p()));
                }
            } else {
            }
        } else {
            ExceptionForTaskChain exceptionForTaskChain = new ExceptionForTaskChain(4);
            n.e(m.d(exceptionForTaskChain), "{\n            Tasks.forException(ExceptionForTaskChain(ERROR_NO_DOG_SELECTED))\n        }");
        }
        return jVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void R(a0 a0) {
        n.f(a0, "navigator");
        this.S(a0, this.K, false, false, true, false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void S(a0 a0, ChallengeModel challengeModel2, boolean z3, boolean z4, boolean z5, boolean z6) {
        n.f(a0, "navigator");
        Bundle bundle = new Bundle();
        bundle.putParcelable("challenge", challengeModel2);
        bundle.putBoolean("show_checkbox", z3);
        bundle.putBoolean("show_prize", z4);
        bundle.putBoolean("show_rules", z5);
        int obj5 = 1;
        bundle.putBoolean("hide_participate_button", obj5);
        bundle.putBoolean("is_user_over_limit", obj5);
        bundle.putBoolean("shouldStartCreationFlow", false);
        bundle.putBoolean("shouldTriggerPublish", z6);
        bundle.putInt("style", 2131951968);
        a0.k(c.CHALLENGE_DETAILS_DIALOG, bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void T(a0 a0) {
        n.f(a0, "navigator");
        this.S(a0, this.K, true, false, true, true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean W(Bundle bundle) {
        Object str;
        int obj2;
        n.f(bundle, "arguments");
        this.K = (ChallengeModel)bundle.getParcelable("challengeModel");
        this.J = (LiteDogProfile)bundle.getParcelable("selectedDog");
        this.L = bundle.getString("comment");
        this.M = bundle.getString("entryId");
        obj2 = this.L;
        if (obj2 != null) {
            this.I.e(obj2);
        }
        l(63);
        obj2 = this.K;
        n.d(obj2);
        if (obj2 != null && obj2.getEntryType() != null && this.J != null) {
            n.d(obj2);
            if (obj2.getEntryType() != null) {
                obj2 = this.J != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public final Map<String, Object> Y(LiteDogProfile liteDogProfile, String string2, String string3, String string4, String string5, String string6, String string7) {
        n.f(liteDogProfile, "dogProfile");
        HashMap hashMap = new HashMap();
        hashMap.put("userId", string2);
        hashMap.put("entryId", string3);
        hashMap.put("challengeId", string4);
        hashMap.put("dogId", liteDogProfile.getId());
        hashMap.put("dogName", liteDogProfile.getName());
        hashMap.put("dogAvatarUrl", liteDogProfile.getAvatar());
        hashMap.put("comment", string6);
        hashMap.put("entryType", string5);
        hashMap.put("country", string7);
        hashMap.put("ver", 2);
        return hashMap;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean a0(Uri uri) {
        t2 t2Var;
        String str2;
        String str;
        int obj4;
        if (uri == null) {
            obj4 = 0;
        } else {
            obj4 = this.z.j("entryTemp", uri, "entry.jpg");
        }
        return obj4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String getDogAvatar() {
        String avatar;
        LiteDogProfile liteDogProfile = this.J;
        if (liteDogProfile != null) {
            n.d(liteDogProfile);
            avatar = liteDogProfile.getAvatar();
        } else {
            avatar = 0;
        }
        return avatar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void u(q q, a0 a02) {
        l(85);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void w() {
        if (this.Q != null) {
        }
        if (this.K == null) {
        }
        ChallengeModel challengeModel2 = this.K;
        n.d(challengeModel2);
        b bVar = new b(this);
        this.Q = this.B.N(this.A.v(), challengeModel2.getId(), 1).addSnapshotListener(bVar);
    }
}
