package app.dogo.com.dogo_android.service;

import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;
import app.dogo.android.network.DogoApiClient;
import app.dogo.android.network.d;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecordKt;
import app.dogo.com.dogo_android.s.b.d1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.externalmodel.model.requests.UserLoginRequest;
import app.dogo.externalmodel.model.requests.UserMergeRequest;
import app.dogo.externalmodel.model.responses.UserApiModel;
import com.facebook.k;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest.Builder;
import com.google.firebase.messaging.FirebaseMessaging;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.interfaces.ReceivePurchaserInfoListener;
import i.b.a0;
import i.b.c0;
import i.b.f;
import i.b.g0;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: AuthService.kt */
@Metadata(d1 = "\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0008\u0010<\u001a\u00020=H\u0002J\n\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0016\u0010@\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0008\u0008\u0002\u0010C\u001a\u000204J \u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0008\u0010H\u001a\u0004\u0018\u00010IJ \u0010J\u001a\u00020=2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0008\u0010H\u001a\u0004\u0018\u00010IJ\u001e\u0010K\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$H\u0002J\u0014\u0010N\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PJ\u0016\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u0008\u0010R\u001a\u0004\u0018\u00010SJ$\u0010T\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010U\u001a\u000204J\u000e\u0010V\u001a\u00020?2\u0006\u0010L\u001a\u00020$J\u0016\u0010W\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u0016\u0010X\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020B0AJ\u000e\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020$J\u000e\u0010\\\u001a\u00020?2\u0006\u0010L\u001a\u00020$J\u0012\u0010]\u001a\u00020?2\u0008\u0008\u0002\u0010C\u001a\u000204H\u0002R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\u0008(\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020$0,8F¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\u0014\u00103\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00083\u00105R\u0011\u00106\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00086\u00105R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00087\u00105R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_", d2 = {"Lapp/dogo/com/dogo_android/service/AuthService;", "", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "fireBaseDBService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "resources", "Landroid/content/res/Resources;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "connectivityManager", "Landroid/net/ConnectivityManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "facebookLoginManager", "Lcom/facebook/login/LoginManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "credentialRepository", "Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "apiAdapter", "Lapp/dogo/android/network/ApiAdapter;", "firebaseMessaging", "Lcom/google/firebase/messaging/FirebaseMessaging;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lcom/google/firebase/auth/FirebaseAuth;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/tracking/Tracker;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/revenuecat/purchases/Purchases;Landroid/net/ConnectivityManager;Lcom/facebook/CallbackManager;Lcom/facebook/login/LoginManager;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/network/ApiAdapter;Lcom/google/firebase/messaging/FirebaseMessaging;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "authProviderId", "", "getAuthProviderId", "()Ljava/lang/String;", "currentUserId", "getCurrentUserId", "getFacebookLoginManager", "()Lcom/facebook/login/LoginManager;", "facebookPermissionList", "", "getFacebookPermissionList", "()Ljava/util/List;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "isConnected", "", "()Z", "isUserAdmin", "isUserSignedIn", "revCatLogoutListener", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "getRevCatLogoutListener", "()Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "abortSignIn", "", "addNewDogIfNeeded", "Lio/reactivex/Completable;", "anonymousSignInSingle", "Lio/reactivex/Single;", "Lcom/google/firebase/auth/AuthResult;", "forceDogCreation", "configureFacebookOnActivityResults", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "configureGmailOnActivityResults", "createUserWithPassword", "email", "password", "firebaseAuthLinking", "lastCredential", "Lcom/google/firebase/auth/AuthCredential;", "firebaseAuthMerge", "getUserAuthRecord", "Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "launchEmailAuthentication", "accCreationFlag", "sendPasswordResetEmail", "signIn", "signInWithCredentialSingle", "signOut", "updateDisplayName", "displayName", "updateEmail", "userSyncWithBackend", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h2, reason: from kotlin metadata */
public final class AuthService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h2.a INSTANCE = new h2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseAuth apiAdapter;
    /* renamed from: b, reason: from kotlin metadata */
    private final u2 apiClient;
    private final o3 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final Resources callbackManager;
    /* renamed from: e, reason: from kotlin metadata */
    private final m2 connectivityManager;
    /* renamed from: f, reason: from kotlin metadata */
    private final Purchases credentialRepository;
    private final ConnectivityManager g;
    private final k h;
    private final com.facebook.login.p i;
    /* renamed from: j, reason: from kotlin metadata */
    private com.google.android.gms.auth.api.signin.b fireBaseDBService;
    /* renamed from: k, reason: from kotlin metadata */
    private final d1 firebaseAuth;
    /* renamed from: l, reason: from kotlin metadata */
    private final DogoApiClient firebaseMessaging;
    /* renamed from: m, reason: from kotlin metadata */
    private final p2 firestoreService;
    private final app.dogo.android.network.c n;
    private final FirebaseMessaging o;
    private final r2 p;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/service/AuthService$Companion;", "", "()V", "AUTH_PROVIDER_FIREBASE", "", "AUTH_PROVIDER_PASSWORD", "UNKNOWN", "createBlankStringIfNullOrEmpty", "value", "isEmail", "", "email", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final String createBlankStringIfNullOrEmpty(String value) {
            int i = 0;
            String str;
            if (value == null || value.length() == 0) {
                i = 1;
            }
            if (i != 0) {
                str = " ";
            }
            return str;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final boolean isEmail(String email) {
            n.f(email, "email");
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/service/AuthService$revCatLogoutListener$1", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements ReceivePurchaserInfoListener {
        b() {
            super();
        }

        public void onError(PurchasesError error) {
            n.f(error, "error");
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = "User logout failed failed, with code ";
            com.revenuecat.purchases.PurchasesErrorCode code = error.getCode();
            String str3 = "and message ";
            String message = error.getMessage();
            String str4 = " \n extra: ";
            String underlyingErrorMessage = error.getUnderlyingErrorMessage();
            error = str2 + code + str3 + message + str4 + underlyingErrorMessage + 41;
            a.d(new Exception(error));
        }

        public void onReceived(PurchaserInfo purchaserInfo) {
            n.f(purchaserInfo, "purchaserInfo");
            a.f("User successfully logged out", new Object[0]);
        }
    }
    public h2(FirebaseAuth firebaseAuth, u2 u2Var, o3 o3Var, Resources resources, m2 m2Var, Purchases purchases, ConnectivityManager connectivityManager, k kVar, com.facebook.login.p pVar, com.google.android.gms.auth.api.signin.b bVar, d1 d1Var, DogoApiClient dogoApiClient, p2 p2Var, app.dogo.android.network.c cVar, FirebaseMessaging firebaseMessaging, r2 r2Var) {
        Object firebaseAuth2 = firebaseAuth;
        final Object u2Var22 = u2Var;
        final Object o3Var32 = o3Var;
        final Object resources42 = resources;
        final Object m2Var52 = m2Var;
        final Object purchases62 = purchases;
        final Object connectivityManager72 = connectivityManager;
        final Object kVar82 = kVar;
        final Object pVar92 = pVar;
        final Object bVar102 = bVar;
        final Object d1Var112 = d1Var;
        final Object dogoApiClient122 = dogoApiClient;
        final Object p2Var132 = p2Var;
        final Object cVar142 = cVar;
        n.f(firebaseAuth2, "firebaseAuth");
        n.f(u2Var22, "fireBaseDBService");
        n.f(o3Var32, "tracker");
        n.f(resources42, "resources");
        n.f(m2Var52, "firestoreService");
        n.f(purchases62, "purchases");
        n.f(connectivityManager72, "connectivityManager");
        n.f(kVar82, "callbackManager");
        n.f(pVar92, "facebookLoginManager");
        n.f(bVar102, "googleSignInClient");
        n.f(d1Var112, "credentialRepository");
        n.f(dogoApiClient122, "apiClient");
        n.f(p2Var132, "preferenceService");
        n.f(cVar142, "apiAdapter");
        n.f(firebaseMessaging, "firebaseMessaging");
        Object r2Var162 = r2Var;
        n.f(r2Var162, "remoteConfigService");
        super();
        Object firebaseAuth3 = this;
        firebaseAuth3.apiAdapter = firebaseAuth2;
        firebaseAuth3.apiClient = u2Var22;
        firebaseAuth3.c = o3Var32;
        firebaseAuth3.callbackManager = resources42;
        firebaseAuth3.connectivityManager = m2Var52;
        firebaseAuth3.credentialRepository = purchases62;
        firebaseAuth3.g = connectivityManager72;
        firebaseAuth3.h = kVar82;
        firebaseAuth3.i = pVar92;
        firebaseAuth3.fireBaseDBService = bVar102;
        firebaseAuth3.firebaseAuth = d1Var112;
        firebaseAuth3.firebaseMessaging = dogoApiClient122;
        firebaseAuth3.firestoreService = p2Var132;
        firebaseAuth3.n = cVar142;
        firebaseAuth3.o = firebaseMessaging;
        firebaseAuth3.p = r2Var162;
    }

    /* renamed from: A0, reason: from kotlin metadata */
    private static final g0 createUserWithPassword(h2 email, w password) {
        n.f(email, "this$0");
        n.f(password, "it");
        j token = email.o.getToken();
        n.e(token, "firebaseMessaging.token");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.translateIfAnonymousNameFound(token).map(new c(email));
    }

    /* renamed from: B, reason: from kotlin metadata */
    private final boolean abortSignIn() {
        boolean z = false;
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        int r0 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0;
        return (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0);
    }

    private static final w B0(h2 h2Var, String str) {
        n.f(h2Var, "this$0");
        n.f(str, "token");
        h2Var.firestoreService.K0(str);
        return w.a;
    }

    /* renamed from: C0, reason: from kotlin metadata */
    private static final f configureFacebookOnActivityResults(h2 requestCode, boolean resultCode, w data) {
        n.f(requestCode, "this$0");
        n.f(data, "it");
        return requestCode.firebaseMessaging.loginUserSingle(new UserLoginRequest(requestCode.apiClient.A().i().a())).flatMapCompletable(new g(requestCode)).q(a.b()).d(requestCode.p.m0()).flatMapCompletable(new o(requestCode, resultCode));
    }

    private static final f D0(h2 h2Var, UserApiModel userApiModel) {
        String str;
        n.f(h2Var, "this$0");
        n.f(userApiModel, "it");
        if (h2Var.firestoreService.i0()) {
            if (h2Var.firestoreService.C() == null) {
                str = "";
            }
            if (str.compareTo(userApiModel.getFirstAppOpenVersion()) > 0) {
                h2Var.firestoreService.S0(userApiModel.getFirstAppOpenVersion());
                h2Var.firestoreService.M0(Integer.valueOf(userApiModel.getFirstAppOpenBuild()));
                h2Var.c.l();
            }
        }
        String str4 = null;
        return UserLocalCacheService.c0(h2Var.apiClient, userApiModel, str4, 2, str4);
    }

    /* renamed from: E0, reason: from kotlin metadata */
    private static final f configureGmailOnActivityResults(h2 requestCode, boolean resultCode, Boolean data) {
        i.b.b bVar;
        n.f(requestCode, "this$0");
        n.f(data, "it");
        requestCode.c.setCurrentDogBirthdayUserProperties(requestCode.apiClient.A().i());
        if (resultCode) {
            bVar = requestCode.b();
        } else {
            bVar = b.f();
        }
        return bVar;
    }

    private final void a() {
        this.apiAdapter.signOut();
        this.fireBaseDBService.d();
        this.credentialRepository.logOut(z());
    }

    private final i.b.b b() {
        i.b.b ignoreElement;
        int i2 = 0;
        if (this.apiClient.A().m().isEmpty()) {
            a.f("Creating a new dog on login", new Object[i2]);
            int i = 2;
            String str2 = null;
            ignoreElement = UserLocalCacheService.c(this.apiClient, v(), str2, i, str2).ignoreElement();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "User has ";
            int size = this.apiClient.A().m().size();
            String str6 = " dogs";
            str3 = str5 + size + str6;
            a.f(str3, new Object[i2]);
            ignoreElement = b.f();
        }
        return ignoreElement;
    }

    public static /* synthetic */ a0 d(h2 h2Var, boolean z, int i, Object object) {
        final int object42 = 1;
        if (i & object42 != 0) {
        }
        return h2Var.c(z);
    }

    private static final void e(h2 h2Var, c0 c0Var) {
        n.f(h2Var, "this$0");
        n.f(c0Var, "it");
        try {
            Object obj = m.a(h2Var.apiAdapter.signInAnonymously());
            n.d(obj);
            c0Var.onSuccess(obj);
        } catch (Exception e) {
            a.d(e);
            c0Var.a(e);
        }
    }

    private static final g0 f(h2 h2Var, boolean z, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(authResult, "result");
        return h2Var.w0(z).B(new y(h2Var, authResult));
    }

    private static final AuthResult g(h2 h2Var, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(authResult, "$result");
        h2Var.c.l();
        return authResult;
    }

    private static final void i0(h2 h2Var, String str, i.b.c cVar) {
        n.f(h2Var, "this$0");
        n.f(str, "$email");
        n.f(cVar, "emitter");
        j sendPasswordResetEmail = h2Var.apiAdapter.sendPasswordResetEmail(str);
        n.e(sendPasswordResetEmail, "firebaseAuth.sendPasswordResetEmail(email)");
        sendPasswordResetEmail.addOnSuccessListener(new v(cVar));
        sendPasswordResetEmail.addOnFailureListener(new t(cVar));
    }

    private final a0<AuthResult> j(String str, String str2) {
        a0 flatMapped = a0.create(new e(this, str, str2)).flatMap(new w(this));
        n.e(flatMapped, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.createUserWithEmailAndPassword(email, password))\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.d(e)\n                it.tryOnError(e)\n            }\n        }.flatMap { result: AuthResult ->\n            userSyncWithBackend().toSingle { result }\n        }");
        return flatMapped;
    }

    private static final void j0(i.b.c cVar, Void void) {
        n.f(cVar, "$emitter");
        cVar.onComplete();
    }

    private static final void k(h2 h2Var, String str, String str2, c0 c0Var) {
        n.f(h2Var, "this$0");
        n.f(str, "$email");
        n.f(str2, "$password");
        n.f(c0Var, "it");
        try {
            c0Var.onSuccess((AuthResult)m.a(h2Var.apiAdapter.createUserWithEmailAndPassword(str, str2)));
        } catch (Exception e) {
            a.b(e);
            c0Var.a(e);
        }
    }

    private static final void k0(i.b.c cVar, Exception exc) {
        n.f(cVar, "$emitter");
        cVar.a(exc);
    }

    private static final g0 l(h2 h2Var, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(authResult, "result");
        return AuthService.x0(h2Var, false, 1, null).B(new n(authResult));
    }

    /* renamed from: l0, reason: from kotlin metadata */
    private final a0<AuthResult> signIn(AuthCredential lastCredential) {
        a0 flatMapped = a0.create(new l(this, lastCredential)).subscribeOn(a.b()).subscribeOn(a.b()).flatMap(new h(this));
        n.e(flatMapped, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.signInWithCredential(lastCredential))\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.d(e)\n                it.tryOnError(e)\n            }\n        }.subscribeOn(Schedulers.io())\n            .subscribeOn(Schedulers.io())\n            .flatMap { userSyncWithBackend().toSingle { it } }");
        return flatMapped;
    }

    private static final void m0(h2 h2Var, AuthCredential authCredential, c0 c0Var) {
        n.f(h2Var, "this$0");
        n.f(authCredential, "$lastCredential");
        n.f(c0Var, "it");
        try {
            c0Var.onSuccess((AuthResult)m.a(h2Var.apiAdapter.signInWithCredential(authCredential)));
        } catch (Exception e) {
            a.b(e);
            c0Var.a(e);
        }
    }

    private static final g0 n0(h2 h2Var, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(authResult, "it");
        return AuthService.x0(h2Var, false, 1, null).B(new c0(authResult));
    }

    private static final g0 o(h2 h2Var, AuthCredential authCredential, Throwable th) {
        n.f(h2Var, "this$0");
        n.f(authCredential, "$lastCredential");
        n.f(th, "error");
        if (!(th instanceof FirebaseAuthUserCollisionException)) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        } else {
            return h2Var.updateEmail(authCredential);
        }
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final a0<AuthResult> updateEmail(AuthCredential email) {
        final a0 flatMapped = app.dogo.com.dogo_android.util.extensionfunction.j1.translateIfAnonymousNameFound(app.dogo.com.dogo_android.util.extensionfunction.j1.s0(this.apiAdapter, false)).flatMap(new p(this, email, this.apiClient.A().f()));
        n.e(flatMapped, "firebaseAuth.refreshIdToken(false).toSingle().flatMap { oldToken ->\n            signInWithCredentialSingle(lastCredential).flatMap { authResults ->\n                userSyncWithBackend().andThen(apiClient.mergeUsers(UserMergeRequest(otherUserToken = oldToken))).flatMap {\n                    fireBaseDBService.updateLocalUserData(it, currentDogId).toSingle { authResults }\n                }\n            }\n        }");
        return flatMapped;
    }

    /* renamed from: p0, reason: from kotlin metadata */
    private final a0<AuthResult> userSyncWithBackend(AuthCredential forceDogCreation) {
        a0 flatMapped = a0.create(new m(this, forceDogCreation)).flatMap(new s(this));
        n.e(flatMapped, "create<AuthResult> { emitter ->\n            firebaseAuth.signInWithCredential(lastCredential).addOnCompleteListener { task ->\n                if (task.isSuccessful && task.result != null) {\n                    emitter.onSuccess(task.result)\n                } else {\n                    emitter.tryOnError(task.exception ?: Throwable(\"auth, error while singing in with credentials\"))\n                }\n            }\n        }.flatMap { userSyncWithBackend().toSingle { it } }");
        return flatMapped;
    }

    private static final g0 q(h2 h2Var, AuthCredential authCredential, String str, String str2) {
        n.f(h2Var, "this$0");
        n.f(authCredential, "$lastCredential");
        n.f(str, "$currentDogId");
        n.f(str2, "oldToken");
        return h2Var.userSyncWithBackend(authCredential).flatMap(new a0(h2Var, str2, str));
    }

    private static final void q0(h2 h2Var, AuthCredential authCredential, c0 c0Var) {
        n.f(h2Var, "this$0");
        n.f(authCredential, "$lastCredential");
        n.f(c0Var, "emitter");
        h2Var.apiAdapter.signInWithCredential(authCredential).addOnCompleteListener(new r(c0Var));
    }

    private static final g0 r(h2 h2Var, String str, String str2, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(str, "$oldToken");
        n.f(str2, "$currentDogId");
        n.f(authResult, "authResults");
        return AuthService.x0(h2Var, false, 1, null).d(h2Var.firebaseMessaging.mergeUsers(new UserMergeRequest(str))).flatMap(new z(h2Var, str2, authResult));
    }

    private static final void r0(c0 c0Var, j jVar) {
        boolean successful;
        Exception exception;
        n.f(c0Var, "$emitter");
        if (!jVar.isSuccessful() || jVar.getResult() == null) {
            if (jVar.getException() == null) {
                Throwable throwable = new Throwable("auth, error while singing in with credentials");
            }
            c0Var.a(exception);
        } else {
            c0Var.onSuccess(jVar.getResult());
        }
    }

    private static final g0 s(h2 h2Var, String str, AuthResult authResult, UserApiModel userApiModel) {
        n.f(h2Var, "this$0");
        n.f(str, "$currentDogId");
        n.f(authResult, "$authResults");
        n.f(userApiModel, "it");
        return h2Var.apiClient.b0(userApiModel, str).B(new q(authResult));
    }

    private static final g0 s0(h2 h2Var, AuthResult authResult) {
        n.f(h2Var, "this$0");
        n.f(authResult, "it");
        return AuthService.x0(h2Var, false, 1, null).B(new d(authResult));
    }

    private final i.b.b w0(boolean z) {
        i.b.b bVar2 = app.dogo.com.dogo_android.util.extensionfunction.j1.translateIfAnonymousNameFound(app.dogo.com.dogo_android.util.extensionfunction.j1.s0(this.apiAdapter, false)).map(new b(this)).flatMap(new i(this)).flatMapCompletable(new u(this, z)).t(new x(this));
        n.e(bVar2, "firebaseAuth.refreshIdToken(false).toSingle().map { token ->\n            apiAdapter.tokenInterceptor.token = token\n        }.flatMap {\n            firebaseMessaging.token.toSingle().map { token ->\n                preferenceService.fcmToken = token\n            }\n        }.flatMapCompletable {\n            apiClient.loginUserSingle(\n                UserLoginRequest(\n                    device = fireBaseDBService.getUserAndDogCache().deviceData.buildUserDeviceModel()\n                )\n            ).flatMapCompletable {\n                if (preferenceService.isFirstTimeLaunch && (preferenceService.firstOpenVersion ?: \"\") > it.firstAppOpenVersion) {\n                    preferenceService.firstOpenVersion = it.firstAppOpenVersion\n                    preferenceService.firstOpenBuild = it.firstAppOpenBuild\n                    tracker.setFirstAppOpenUserProperties()\n                }\n                fireBaseDBService.updateLocalUserData(it)\n            }.observeOn(Schedulers.io()).andThen(\n                remoteConfigService.safeRefresh()\n            ).flatMapCompletable {\n                tracker.trackDeviceData(fireBaseDBService.getUserAndDogCache().deviceData)\n                if (forceDogCreation) {\n                    addNewDogIfNeeded()\n                } else {\n                    Completable.complete()\n                }\n            }\n        }.onErrorResumeNext {\n            abortSignIn()\n            Completable.error(it)\n        }");
        return bVar2;
    }

    static /* synthetic */ i.b.b x0(h2 h2Var, boolean z, int i, Object object) {
        final int object42 = 1;
        if (i & object42 != 0) {
        }
        return h2Var.w0(z);
    }

    private static final f y0(h2 h2Var, Throwable th) {
        n.f(h2Var, "this$0");
        n.f(th, "it");
        h2Var.a();
        return b.m(th);
    }

    private final ReceivePurchaserInfoListener z() {
        return new AuthService_revCatLogoutListener_1();
    }

    private static final w z0(h2 h2Var, String str) {
        n.f(h2Var, "this$0");
        n.f(str, "token");
        h2Var.n.c().g(str);
        return w.a;
    }

    public final UserAuthRecord A() {
        int i = 0;
        FirebaseUser currentUser = this.apiAdapter.getCurrentUser();
        if (currentUser == null) {
            i = 0;
        } else {
            UserAuthRecord userAuthRecord = UserAuthRecordKt.toUserAuthRecord(currentUser);
        }
        return i;
    }

    public final boolean C() {
        String email = null;
        if (D()) {
            FirebaseUser currentUser = this.apiAdapter.getCurrentUser();
            if (currentUser == null) {
                int i = 0;
            } else {
                email = currentUser.getEmail();
            }
            if (this.apiAdapter != null) {
                return this.connectivityManager.f.contains(email);
            }
        }
        return false;
    }

    public final boolean D() {
        boolean z = false;
        FirebaseUser currentUser = this.apiAdapter.getCurrentUser();
        int r0 = currentUser != null && !currentUser.isAnonymous() ? 1 : 0;
        return (currentUser != null && !currentUser.isAnonymous() ? 1 : 0);
    }

    public final a0<AuthResult> c(boolean z) {
        final a0 flatMapped = a0.create(new j(this)).flatMap(new b0(this, z));
        n.e(flatMapped, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.signInAnonymously())!!\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.e(e)\n                it.tryOnError(e)\n            }\n        }.flatMap { result: AuthResult ->\n            userSyncWithBackend(forceDogCreation).toSingle {\n                tracker.setFirstAppOpenUserProperties()\n                result\n            }\n        }");
        return flatMapped;
    }

    public final a0<AuthResult> g0(String str, String str2, boolean z) {
        a0 error;
        n.f(str, "email");
        n.f(str2, "password");
        if (!abortSignIn()) {
            str4 = "{\n            Single.error(UnknownHostException())\n        }";
            n.e(a0.error(new UnknownHostException()), str4);
        } else {
            AuthCredential credential = EmailAuthProvider.getCredential(str, str2);
            str3 = "getCredential(email, password)";
            n.e(credential, str3);
            this.firebaseAuth.b(credential);
            if (this.apiAdapter.getCurrentUser() != null || !z) {
                AuthCredential authCredential = this.firebaseAuth.a();
                if (authCredential != null) {
                    error = n(authCredential);
                } else {
                    str4 = "{\n                    Single.error(Throwable(\"can not link auth\"))\n                }";
                    n.e(a0.error(new Throwable("can not link auth")), str4);
                }
            } else {
                error = j(str, str2);
            }
        }
        return error;
    }

    public final void h(int i, int i2, Intent intent) {
        this.h.a(i, i2, intent);
    }

    public final i.b.b h0(String str) {
        n.f(str, "email");
        final i.b.b bVar = b.g(new f(this, str));
        n.e(bVar, "create { emitter ->\n            val task = firebaseAuth.sendPasswordResetEmail(email)\n            task.addOnSuccessListener { emitter.onComplete() }\n            task.addOnFailureListener { emitter.tryOnError(it) }\n        }");
        return bVar;
    }

    public final void i(int i, int i2, Intent intent) {
        int i3 = 10001;
        if (i == 10001 && i2 == -1) {
            try {
                AuthCredential credential = GoogleAuthProvider.getCredential((GoogleSignInAccount)a.b(intent).getResult(ApiException.class).getIdToken(), null);
                n.e(credential, "getCredential(account.idToken, null)");
                this.firebaseAuth.b(credential);
            } catch (com.google.android.gms.common.api.ApiException e) {
                a.d(e);
            }
        }
    }

    public final a0<AuthResult> n(AuthCredential authCredential) {
        a0 onErrorResumeNext;
        n.f(authCredential, "lastCredential");
        FirebaseUser currentUser = this.apiAdapter.getCurrentUser();
        if (currentUser != null) {
            str = "{\n            currentUser.linkWithCredentialSingle(lastCredential)\n                .onErrorResumeNext { error ->\n                    if (error is FirebaseAuthUserCollisionException) {\n                        firebaseAuthMerge(lastCredential)\n                    } else {\n                        throw error\n                    }\n                }\n        }";
            n.e(app.dogo.com.dogo_android.util.extensionfunction.j1.h0(currentUser, authCredential).onErrorResumeNext(new k(this, authCredential)), str);
        } else {
            onErrorResumeNext = signIn(authCredential);
        }
        return onErrorResumeNext;
    }

    public final String u() {
        FirebaseUser currentUser;
        int i = 0;
        boolean hasNext;
        int i2;
        int i3;
        boolean z2;
        Object str2;
        i = 0;
        if (D()) {
            currentUser = this.apiAdapter.getCurrentUser();
            if (currentUser != null) {
                Iterator it = currentUser.getProviderData().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    i3 = 1;
                    i2 = (n.b(item.getProviderId(), "firebase")) ^ i3;
                    str2 = "password";
                }
            } else {
            }
            if (i != 0) {
            } else {
                str = "Could not determine authentication provider, even though usr is logged in.";
                a.d(new RuntimeException(str));
            }
        }
        return i;
    }

    public final a0<AuthResult> u0() throws android.content.res.Resources.NotFoundException {
        a0 error;
        boolean z = false;
        if (abortSignIn()) {
            this.apiAdapter.signOut();
            this.fireBaseDBService.d();
            this.credentialRepository.logOut(z());
            Object obj = null;
            str = "{\n            firebaseAuth.signOut()\n            googleSignInClient.signOut()\n            purchases.logOut(revCatLogoutListener)\n            fireBaseDBService.deactivateDevice(userId).andThen(anonymousSignInSingle())\n        }";
            n.e(this.apiClient.i(v()).d(AuthService.d(this, z, 1, obj)), str);
        } else {
            int i2 = 2131886953;
            a.c(this.callbackManager.getString(i2), new Object[z]);
            str = "{\n            Timber.e(resources.getString(R.string.no_internet_connection))\n            Single.error(UnknownHostException(resources.getString(R.string.no_internet_connection)))\n        }";
            n.e(a0.error(new UnknownHostException(this.callbackManager.getString(i2))), str);
        }
        return error;
    }

    public final String v() {
        String uid;
        if (this.apiAdapter.getUid() == null) {
            uid = "";
        }
        return uid;
    }

    public final i.b.b v0(String str) {
        n.f(str, "displayName");
        com.google.firebase.auth.UserProfileChangeRequest builder2 = new UserProfileChangeRequest.Builder().setDisplayName(str).build();
        n.e(builder2, "Builder()\n                .setDisplayName(displayName)\n                .build()");
        FirebaseUser currentUser = this.apiAdapter.getCurrentUser();
        n.d(currentUser);
        j profile = currentUser.updateProfile(builder2);
        n.e(profile, "firebaseAuth.currentUser!!.updateProfile(profileUpdates)");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.setMaxLines(profile);
    }

    public final com.facebook.login.p w() {
        return this.i;
    }

    public final List<String> x() {
        return p.j(new String[] { "public_profile", "email" });
    }

    public final com.google.android.gms.auth.api.signin.b y() {
        return this.fireBaseDBService;
    }


    public static /* synthetic */ w E(h2 h2Var, String str) {
        return AuthService.z0(h2Var, str);
    }

    public static /* synthetic */ w F(h2 h2Var, String str) {
        return AuthService.B0(h2Var, str);
    }

    /* renamed from: G, reason: from kotlin metadata */
    public static /* synthetic */ AuthResult anonymousSignInSingle(AuthResult forceDogCreation) {
        AuthService.t0(forceDogCreation);
        return forceDogCreation;
    }

    public static /* synthetic */ void H(h2 h2Var, String str, String str2, c0 c0Var) {
        AuthService.k(h2Var, str, str2, c0Var);
    }

    /* renamed from: I, reason: from kotlin metadata */
    public static /* synthetic */ void launchEmailAuthentication(h2 email, String password, i.b.c accCreationFlag) {
        AuthService.i0(email, password, accCreationFlag);
    }

    public static /* synthetic */ f J(h2 h2Var, UserApiModel userApiModel) {
        return AuthService.D0(h2Var, userApiModel);
    }

    public static /* synthetic */ g0 K(h2 h2Var, AuthResult authResult) {
        return AuthService.n0(h2Var, authResult);
    }

    public static /* synthetic */ g0 L(h2 h2Var, w wVar) {
        return AuthService.createUserWithPassword(h2Var, wVar);
    }

    public static /* synthetic */ void M(h2 h2Var, c0 c0Var) {
        AuthService.e(h2Var, c0Var);
    }

    public static /* synthetic */ g0 N(h2 h2Var, AuthCredential authCredential, Throwable th) {
        return AuthService.o(h2Var, authCredential, th);
    }

    public static /* synthetic */ void O(h2 h2Var, AuthCredential authCredential, c0 c0Var) {
        AuthService.m0(h2Var, authCredential, c0Var);
    }

    public static /* synthetic */ void P(h2 h2Var, AuthCredential authCredential, c0 c0Var) {
        AuthService.q0(h2Var, authCredential, c0Var);
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static /* synthetic */ AuthResult firebaseAuthLinking(AuthResult lastCredential) {
        AuthService.signInWithCredentialSingle(lastCredential);
        return lastCredential;
    }

    public static /* synthetic */ f R(h2 h2Var, boolean z, Boolean boolean) {
        return AuthService.configureGmailOnActivityResults(h2Var, z, boolean);
    }

    public static /* synthetic */ g0 S(h2 h2Var, AuthCredential authCredential, String str, String str2) {
        return AuthService.q(h2Var, authCredential, str, str2);
    }

    /* renamed from: T, reason: from kotlin metadata */
    public static /* synthetic */ AuthResult firebaseAuthMerge(AuthResult lastCredential) {
        AuthService.t(lastCredential);
        return lastCredential;
    }

    public static /* synthetic */ void U(c0 c0Var, j jVar) {
        AuthService.r0(c0Var, jVar);
    }

    public static /* synthetic */ g0 V(h2 h2Var, AuthResult authResult) {
        return AuthService.s0(h2Var, authResult);
    }

    public static /* synthetic */ void W(i.b.c cVar, Exception exc) {
        AuthService.k0(cVar, exc);
    }

    public static /* synthetic */ f X(h2 h2Var, boolean z, w wVar) {
        return AuthService.configureFacebookOnActivityResults(h2Var, z, wVar);
    }

    public static /* synthetic */ void Y(i.b.c cVar, Void void) {
        AuthService.j0(cVar, void);
    }

    public static /* synthetic */ g0 Z(h2 h2Var, AuthResult authResult) {
        return AuthService.l(h2Var, authResult);
    }

    public static /* synthetic */ f a0(h2 h2Var, Throwable th) {
        return AuthService.y0(h2Var, th);
    }

    public static /* synthetic */ AuthResult b0(h2 h2Var, AuthResult authResult) {
        AuthService.g(h2Var, authResult);
        return authResult;
    }

    public static /* synthetic */ g0 c0(h2 h2Var, String str, AuthResult authResult, UserApiModel userApiModel) {
        return AuthService.s(h2Var, str, authResult, userApiModel);
    }

    public static /* synthetic */ g0 d0(h2 h2Var, String str, String str2, AuthResult authResult) {
        return AuthService.r(h2Var, str, str2, authResult);
    }

    public static /* synthetic */ g0 e0(h2 h2Var, boolean z, AuthResult authResult) {
        return AuthService.f(h2Var, z, authResult);
    }

    /* renamed from: f0, reason: from kotlin metadata */
    public static /* synthetic */ AuthResult sendPasswordResetEmail(AuthResult email) {
        AuthService.updateDisplayName(email);
        return email;
    }

    /* renamed from: m, reason: from kotlin metadata */
    private static final AuthResult signInWithCredentialSingle(AuthResult lastCredential) {
        n.f(lastCredential, "$result");
        return lastCredential;
    }

    /* renamed from: o0, reason: from kotlin metadata */
    private static final AuthResult updateDisplayName(AuthResult displayName) {
        n.f(displayName, "$it");
        return displayName;
    }

    private static final AuthResult t(AuthResult authResult) {
        n.f(authResult, "$authResults");
        return authResult;
    }

    private static final AuthResult t0(AuthResult authResult) {
        n.f(authResult, "$it");
        return authResult;
    }
}
