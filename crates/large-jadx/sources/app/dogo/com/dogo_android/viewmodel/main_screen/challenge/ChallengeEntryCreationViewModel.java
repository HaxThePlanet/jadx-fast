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

/* compiled from: ChallengeEntryCreationViewModel.kt */
@Metadata(d1 = "\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 l2\u00020\u0001:\u0001lBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010<\u001a\u00020=J&\u0010>\u001a\u0008\u0012\u0004\u0012\u00020.0?2\u0016\u0010@\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010B0AH\u0002J\u0006\u0010C\u001a\u00020=J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020.J\u0010\u0010G\u001a\u00020=2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u000e\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u000c\u0010L\u001a\u0008\u0012\u0004\u0012\u00020.0?J\u000e\u0010M\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ8\u0010N\u001a\u00020=2\u0006\u0010I\u001a\u00020J2\u0008\u0010O\u001a\u0004\u0018\u00010\u001c2\u0006\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020.2\u0006\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020.J\u000e\u0010T\u001a\u00020=2\u0006\u0010I\u001a\u00020JJ\u0008\u0010U\u001a\u00020=H\u0002J\u001c\u0010V\u001a\u00020=2\u0008\u0010W\u001a\u0004\u0018\u00010X2\u0008\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0008\u0010Y\u001a\u00020=H\u0002J\u000e\u0010Z\u001a\u00020.2\u0006\u0010[\u001a\u00020\\J\u0008\u0010]\u001a\u00020=H\u0002JZ\u0010^\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010B0A2\u0006\u0010_\u001a\u0002072\u0008\u0010`\u001a\u0004\u0018\u00010\u00192\u0008\u0010&\u001a\u0004\u0018\u00010\u00192\u0008\u0010a\u001a\u0004\u0018\u00010\u00192\u0008\u0010b\u001a\u0004\u0018\u00010\u00192\u0008\u0010c\u001a\u0004\u0018\u00010\u00192\u0008\u0010d\u001a\u0004\u0018\u00010\u0019J \u0010e\u001a\u00020=2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010a\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H\u0002J\u0010\u0010g\u001a\u00020.2\u0008\u0010h\u001a\u0004\u0018\u00010*J\u0010\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0010\u0012\u000c\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010'\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008(\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u0008-\u0010/R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00080\u0010/R\u0011\u00101\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00081\u0010/R\u0011\u00102\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u00082\u0010/R\u001e\u00103\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020.@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010/R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001909X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "appIntentServiceManager", "Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "context", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;Lapp/dogo/com/dogo_android/service/PreferenceService;Landroid/content/Context;)V", "captionField", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "comment", "connectivityManager", "Landroid/net/ConnectivityManager;", "dogAvatar", "getDogAvatar", "()Ljava/lang/String;", "entryId", "image", "getImage", "imageUri", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "isChallengeEnded", "", "()Z", "isConnected", "isPolicyAccepted", "isSizeCorrect", "isUserEntryListReady", "lastPublishClickTimestampMs", "", "selectedDog", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "userEntryIdList", "", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "checkIfEntryIsValidAndStartUpload", "Lcom/google/android/gms/tasks/Task;", "entryData", "", "", "detachUserEntryListener", "imageSizes", "", "isPublishClickTimeoutOver", "markUploadAsFailed", "onCancelClick", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onChangeClick", "onPublishClick", "onTermsClick", "openChallengeDetailsDialog", "model", "showCheckBox", "scrollToPrize", "scrollToRules", "shouldTriggerPublish", "openPolicyAcceptWindow", "pingToSwitchToYourTab", "refreshView", "caller", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "resetUserEntryListReady", "setArguments", "arguments", "Landroid/os/Bundle;", "setUserEntryListReady", "setupEntryData", "dogProfile", "userId", "challengeId", "entryType", "caption", "countryCode", "startPhotoUpload", "photoId", "tempSaveImage", "imagePath", "transformRemoteErrorCodeToLocalErrorCode", "", "remoteErrorCode", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public final class ChallengeEntryCreationViewModel extends r {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final e0.a INSTANCE = new e0$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final h2 appIntentServiceManager;
    /* renamed from: B, reason: from kotlin metadata */
    private final m2 authService;
    /* renamed from: C, reason: from kotlin metadata */
    private final p1 captionField;
    private final o3 D;
    /* renamed from: E, reason: from kotlin metadata */
    private final v2 cloudFunctionsService;
    /* renamed from: F, reason: from kotlin metadata */
    private final i2 comment;
    /* renamed from: G, reason: from kotlin metadata */
    private final g2 connectivityManager;
    private final p2 H;
    /* renamed from: I, reason: from kotlin metadata */
    public i<String> entryId = new i<>("");
    /* renamed from: J, reason: from kotlin metadata */
    private LiteDogProfile firestoreService;
    private ChallengeModel K;
    private String L;
    private String M;
    private final ConnectivityManager N;
    /* renamed from: O, reason: from kotlin metadata */
    private boolean isPolicyAccepted;
    private final Set<String> P = new HashSet<>();
    private ListenerRegistration Q;
    /* renamed from: R, reason: from kotlin metadata */
    private long lastPublishClickTimestampMs;
    /* renamed from: z, reason: from kotlin metadata */
    private final t2 preferenceService;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel$Companion;", "", "()V", "ENTRY_IMAGE_NAME", "", "ERROR_ALREADY_PARTICIPATED", "", "ERROR_INVALID_ENTRY_ID", "ERROR_INVALID_RESPONSE", "ERROR_NO_DOG_SELECTED", "ERROR_VALIDATION_FAILED", "MAX_ENTRIES", "MINIMUM_IMAGE_SIZE", "PUBLISH_DEBOUNCE_MILLIS", "TEMP_ENTRY_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public e0(t2 t2Var, h2 h2Var, m2 m2Var, p1 p1Var, o3 o3Var, v2 v2Var, i2 i2Var, g2 g2Var, p2 p2Var, Context context) {
        n.f(t2Var, "storageService");
        n.f(h2Var, "authService");
        n.f(m2Var, "firestoreService");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(v2Var, "utilities");
        n.f(i2Var, "cloudFunctionsService");
        n.f(g2Var, "appIntentServiceManager");
        n.f(p2Var, "preferenceService");
        n.f(context, "context");
        super();
        this.preferenceService = t2Var;
        this.appIntentServiceManager = h2Var;
        this.authService = m2Var;
        this.captionField = p1Var;
        this.D = o3Var;
        this.cloudFunctionsService = v2Var;
        this.comment = i2Var;
        this.connectivityManager = g2Var;
        this.H = p2Var;
        i iVar = new i("");
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.N = systemService;
        HashSet hashSet = new HashSet();
    }

    /* renamed from: N, reason: from kotlin metadata */
    private final void checkIfEntryIsValidAndStartUpload(String entryData) {
        this.authService.r0(entryData);
    }

    /* renamed from: U, reason: from kotlin metadata */
    private final void attachUserEntryListener() {
        emitMessage(FragmentMessageAction.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB, new Bundle());
    }

    private final void V() {
        this.isPolicyAccepted = false;
    }

    private final void X() {
        this.isPolicyAccepted = true;
    }

    private final void Z(String str, String str2, String str3) {
        this.preferenceService.n("entryTemp", "challenge_pending", "entry.jpg", n.o(str, ".jpg"));
        if (this.connectivityManager.startEntryUploadService(str, StoragePath.entry_photo.setChallengeId(str2).setId(str).setPhotoId(str3).getPath()) != null) {
            this.D.logEvent(E_Challenges.t.c(new EP_ChallengeId(), str2));
            attachUserEntryListener();
            this.captionField.e(str2);
        } else {
            int i = 2131886123;
            showToast(i);
            checkIfEntryIsValidAndStartUpload(str);
        }
    }

    private static final void x(e0 e0Var, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        Set set;
        String str;
        str2 = "this$0";
        n.f(e0Var, str2);
        if (querySnapshot != null) {
            e0Var.X();
            Iterator it = querySnapshot.iterator();
            while (it.hasNext()) {
                String str2 = (QueryDocumentSnapshot)it.next().getId();
                str = "doc.id";
                n.e(str2, str);
                e0Var.P.add(str2);
            }
        }
    }

    /* renamed from: y, reason: from kotlin metadata */
    private final j<Boolean> onCancelClick(Map<String, ? extends Object> navigator) {
        j continueWith = this.comment.resetRecapInformation(navigator).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.c(this));
        n.e(continueWith, "cloudFunctionsService.checkIfEntryUpdateIsValid(entryData).continueWith { task: Task<EntryValidationResponse> ->\n            val response = task.result\n            if (!response.isResponseDataValid) {\n                val errorResponse = transformRemoteErrorCodeToLocalErrorCode(response.errorCode)\n                throw ExceptionForTaskChain(errorResponse)\n            }\n            startPhotoUpload(response.entryId, challengeModel!!.id, response.imageId)\n            true\n        }");
        return continueWith;
    }

    private static final Boolean z(e0 e0Var, j jVar) throws ExceptionForTaskChain {
        n.f(e0Var, "this$0");
        n.f(jVar, "task");
        Object result = jVar.getResult();
        if (!result.d()) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new ExceptionForTaskChain(e0Var.markUploadAsFailed(result.b()));
        } else {
            String str3 = result.a();
            n.e(str3, "response.entryId");
            ChallengeModel challengeModel = e0Var.B();
            n.d(challengeModel);
            String str6 = result.c();
            n.e(str6, "response.imageId");
            e0Var.Z(str3, challengeModel.getId(), str6);
            return Boolean.TRUE;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void A() {
        if (this.Q != null) {
            n.d(this.Q);
            this.Q.remove();
            ListenerRegistration listenerRegistration = null;
            this.Q = listenerRegistration;
            V();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel B() {
        return this.K;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String C() {
        int i = 0;
        Uri uri = this.preferenceService.h("entryTemp", "entry.jpg");
        if (uri == null) {
            i = 0;
        } else {
            String path = uri.getPath();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final Uri D() {
        return this.preferenceService.h("entryTemp", "entry.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int[] E() {
        return this.preferenceService.e(D());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean F() {
        boolean hasEnded = true;
        if (this.K != null) {
            n.d(this.K);
            hasEnded = this.K.isHasEnded(this.cloudFunctionsService);
        } else {
            int i = 1;
        }
        return hasEnded;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean G() {
        boolean z = false;
        NetworkInfo activeNetworkInfo = this.N.getActiveNetworkInfo();
        int r0 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0;
        return (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean H() {
        return this.captionField.L("challenge_terms_v1");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean I() {
        boolean z = true;
        long l = this.cloudFunctionsService.g();
        long l3 = this.lastPublishClickTimestampMs + (long)5000;
        if (l > this.lastPublishClickTimestampMs) {
            this.lastPublishClickTimestampMs = this.cloudFunctionsService.g();
            int i = 1;
        } else {
            int i2 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J() {
        boolean z = false;
        Uri uri = this.preferenceService.h("entryTemp", "entry.jpg");
        int i3 = 0;
        if (uri == null) {
            return false;
        }
        int[] iArr = this.preferenceService.e(uri);
        final int i = 1;
        final int i5 = 800;
        if (iArr[i3] >= i5) {
            if (iArr[i] >= i5) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean K() {
        return this.isPolicyAccepted;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: O, reason: from kotlin metadata */
    public final void onChangeClick(a0 navigator) {
        n.f(navigator, "navigator");
        this.D.logEvent(E_Challenges.y);
        navigator.r(DialogTags.CHALLENGE_ENTRY_CREATION);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: P, reason: from kotlin metadata */
    public final void onTermsClick(a0 navigator) {
        n.f(navigator, "navigator");
        final int i2 = 800;
        navigator.B0(false, i2, i2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final j<Boolean> Q() {
        Object obj = null;
        j onCancelClick;
        String str;
        int i = 0;
        if (this.firestoreService != null) {
            obj = this.entryId.d();
            i = 1;
            if (obj != null) {
                int r2 = obj.length() == 0 ? i : 0;
                if (i != 0) {
                    int i2 = 0;
                }
            }
            n.d(this.K);
            n.d(this.K);
            if (this.M == null) {
                if (this.P.isEmpty() ^ i) {
                    str = "{\n                Tasks.forException(ExceptionForTaskChain(ERROR_INVALID_ENTRY_ID))\n            }";
                    n.e(m.d(new ExceptionForTaskChain(3)), str);
                } else {
                    onCancelClick = onCancelClick(this.setupEntryData(this.firestoreService, this.appIntentServiceManager.v(), this.M, this.K.getId(), this.K.getEntryType(), obj, this.H.p()));
                }
            }
        } else {
            str = "{\n            Tasks.forException(ExceptionForTaskChain(ERROR_NO_DOG_SELECTED))\n        }";
            n.e(m.d(new ExceptionForTaskChain(4)), str);
        }
        return onCancelClick;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: R, reason: from kotlin metadata */
    public final void openPolicyAcceptWindow(a0 navigator) {
        n.f(navigator, "navigator");
        this.openChallengeDetailsDialog(navigator, this.K, false, false, true, false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: S, reason: from kotlin metadata */
    public final void openChallengeDetailsDialog(a0 navigator, ChallengeModel model, boolean showCheckBox, boolean scrollToPrize, boolean scrollToRules, boolean shouldTriggerPublish) {
        n.f(navigator, "navigator");
        Bundle bundle = new Bundle();
        bundle.putParcelable("challenge", model);
        bundle.putBoolean("show_checkbox", showCheckBox);
        bundle.putBoolean("show_prize", scrollToPrize);
        bundle.putBoolean("show_rules", scrollToRules);
        boolean z = true;
        bundle.putBoolean("hide_participate_button", z);
        bundle.putBoolean("is_user_over_limit", z);
        bundle.putBoolean("shouldStartCreationFlow", false);
        bundle.putBoolean("shouldTriggerPublish", shouldTriggerPublish);
        bundle.putInt("style", 2131951968);
        navigator.k(DialogTags.CHALLENGE_DETAILS_DIALOG, bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: T, reason: from kotlin metadata */
    public final void setArguments(a0 arguments) {
        n.f(arguments, "navigator");
        this.openChallengeDetailsDialog(arguments, this.K, true, false, true, true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: W, reason: from kotlin metadata */
    public final boolean tempSaveImage(Bundle imagePath) {
        boolean z = true;
        n.f(imagePath, "arguments");
        this.K = (ChallengeModel)imagePath.getParcelable("challengeModel");
        this.firestoreService = (LiteDogProfile)imagePath.getParcelable("selectedDog");
        this.L = imagePath.getString("comment");
        str = "entryId";
        this.M = imagePath.getString(str);
        if (this.L != null) {
            this.entryId.e(this.L);
        }
        notifyChange(63);
        if (this.K != null) {
            n.d(this.K);
            imagePath = this.K.getEntryType() != null && this.firestoreService != null ? 1 : 0;
        }
        return (this.K.getEntryType() != null && this.firestoreService != null ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: Y, reason: from kotlin metadata */
    public final Map<String, Object> setupEntryData(LiteDogProfile dogProfile, String userId, String entryId, String challengeId, String entryType, String caption, String countryCode) {
        n.f(dogProfile, "dogProfile");
        HashMap hashMap = new HashMap();
        hashMap.put("userId", userId);
        hashMap.put("entryId", entryId);
        hashMap.put("challengeId", challengeId);
        hashMap.put("dogId", dogProfile.getId());
        hashMap.put("dogName", dogProfile.getName());
        hashMap.put("dogAvatarUrl", dogProfile.getAvatar());
        hashMap.put("comment", caption);
        hashMap.put("entryType", entryType);
        hashMap.put("country", countryCode);
        hashMap.put("ver", 2);
        return hashMap;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: a0, reason: from kotlin metadata */
    public final boolean transformRemoteErrorCodeToLocalErrorCode(Uri remoteErrorCode) {
        boolean z = false;
        if (remoteErrorCode == null) {
            int i = 0;
        } else {
            str = "entryTemp";
            str2 = "entry.jpg";
            z = this.preferenceService.j(str, remoteErrorCode, str2);
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String getDogAvatar() {
        String avatar = null;
        if (this.firestoreService != null) {
            n.d(this.firestoreService);
            avatar = this.firestoreService.getAvatar();
        } else {
            int i = 0;
        }
        return avatar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void u(q qVar, a0 a0Var) {
        notifyChange(85);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void w() {
        if (this.Q != null) {
            return;
        }
        if (this.K == null) {
            return;
        }
        n.d(this.K);
        this.Q = this.authService.fetchUserLikeListForEntry(this.appIntentServiceManager.v(), this.K.getId(), 1).addSnapshotListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.b(this));
    }


    /* renamed from: L, reason: from kotlin metadata */
    public static /* synthetic */ void startPhotoUpload(e0 entryId, QuerySnapshot challengeId, FirebaseFirestoreException photoId) {
        ChallengeEntryCreationViewModel.x(entryId, challengeId, photoId);
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static /* synthetic */ Boolean refreshView(e0 caller, j navigator) {
        return ChallengeEntryCreationViewModel.z(caller, navigator);
    }

    /* renamed from: b0, reason: from kotlin metadata */
    private final int markUploadAsFailed(int entryId) {
        int i = 2;
        i = 2;
        i = 1;
        if (entryId != i && entryId != 2) {
        }
        return i;
    }
}
