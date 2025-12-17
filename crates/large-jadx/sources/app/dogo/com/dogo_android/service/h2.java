package app.dogo.com.dogo_android.service;

import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;
import app.dogo.android.network.DogoApiClient;
import app.dogo.android.network.c;
import app.dogo.android.network.d;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecordKt;
import app.dogo.com.dogo_android.s.b.d1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.a;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.externalmodel.model.requests.UserLoginRequest;
import app.dogo.externalmodel.model.requests.UserMergeRequest;
import app.dogo.externalmodel.model.responses.UserApiModel;
import com.facebook.k;
import com.facebook.login.p;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
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
import i.b.b;
import i.b.c;
import i.b.c0;
import i.b.f;
import i.b.g0;
import i.b.s0.a;
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
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0008\u0010<\u001a\u00020=H\u0002J\n\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0016\u0010@\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0008\u0008\u0002\u0010C\u001a\u000204J \u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0008\u0010H\u001a\u0004\u0018\u00010IJ \u0010J\u001a\u00020=2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0008\u0010H\u001a\u0004\u0018\u00010IJ\u001e\u0010K\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$H\u0002J\u0014\u0010N\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PJ\u0016\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u0008\u0010R\u001a\u0004\u0018\u00010SJ$\u0010T\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010U\u001a\u000204J\u000e\u0010V\u001a\u00020?2\u0006\u0010L\u001a\u00020$J\u0016\u0010W\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u0016\u0010X\u001a\u0008\u0012\u0004\u0012\u00020B0A2\u0006\u0010O\u001a\u00020PH\u0002J\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020B0AJ\u000e\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020$J\u000e\u0010\\\u001a\u00020?2\u0006\u0010L\u001a\u00020$J\u0012\u0010]\u001a\u00020?2\u0008\u0008\u0002\u0010C\u001a\u000204H\u0002R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\u0008(\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020$0,8F¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\u0014\u00103\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00083\u00105R\u0011\u00106\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00086\u00105R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00087\u00105R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_", d2 = {"Lapp/dogo/com/dogo_android/service/AuthService;", "", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "fireBaseDBService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "resources", "Landroid/content/res/Resources;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "connectivityManager", "Landroid/net/ConnectivityManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "facebookLoginManager", "Lcom/facebook/login/LoginManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "credentialRepository", "Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "apiAdapter", "Lapp/dogo/android/network/ApiAdapter;", "firebaseMessaging", "Lcom/google/firebase/messaging/FirebaseMessaging;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lcom/google/firebase/auth/FirebaseAuth;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/tracking/Tracker;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/revenuecat/purchases/Purchases;Landroid/net/ConnectivityManager;Lcom/facebook/CallbackManager;Lcom/facebook/login/LoginManager;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/network/ApiAdapter;Lcom/google/firebase/messaging/FirebaseMessaging;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "authProviderId", "", "getAuthProviderId", "()Ljava/lang/String;", "currentUserId", "getCurrentUserId", "getFacebookLoginManager", "()Lcom/facebook/login/LoginManager;", "facebookPermissionList", "", "getFacebookPermissionList", "()Ljava/util/List;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "isConnected", "", "()Z", "isUserAdmin", "isUserSignedIn", "revCatLogoutListener", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "getRevCatLogoutListener", "()Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "abortSignIn", "", "addNewDogIfNeeded", "Lio/reactivex/Completable;", "anonymousSignInSingle", "Lio/reactivex/Single;", "Lcom/google/firebase/auth/AuthResult;", "forceDogCreation", "configureFacebookOnActivityResults", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "configureGmailOnActivityResults", "createUserWithPassword", "email", "password", "firebaseAuthLinking", "lastCredential", "Lcom/google/firebase/auth/AuthCredential;", "firebaseAuthMerge", "getUserAuthRecord", "Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "launchEmailAuthentication", "accCreationFlag", "sendPasswordResetEmail", "signIn", "signInWithCredentialSingle", "signOut", "updateDisplayName", "displayName", "updateEmail", "userSyncWithBackend", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h2 {

    public static final app.dogo.com.dogo_android.service.h2.a Companion;
    private final FirebaseAuth a;
    private final app.dogo.com.dogo_android.service.u2 b;
    private final o3 c;
    private final Resources d;
    private final app.dogo.com.dogo_android.service.m2 e;
    private final Purchases f;
    private final ConnectivityManager g;
    private final k h;
    private final p i;
    private b j;
    private final d1 k;
    private final DogoApiClient l;
    private final app.dogo.com.dogo_android.service.p2 m;
    private final c n;
    private final FirebaseMessaging o;
    private final app.dogo.com.dogo_android.service.r2 p;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/service/AuthService$Companion;", "", "()V", "AUTH_PROVIDER_FIREBASE", "", "AUTH_PROVIDER_PASSWORD", "UNKNOWN", "createBlankStringIfNullOrEmpty", "value", "isEmail", "", "email", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final String a(String string) {
            int i;
            int length;
            String obj2;
            if (string != null) {
                if (string.length() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            if (i != 0) {
                obj2 = " ";
            }
            return obj2;
        }

        public final boolean b(String string) {
            n.f(string, "email");
            return Patterns.EMAIL_ADDRESS.matcher(string).matches();
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/service/AuthService$revCatLogoutListener$1", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements ReceivePurchaserInfoListener {
        @Override // com.revenuecat.purchases.interfaces.ReceivePurchaserInfoListener
        public void onError(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User logout failed failed, with code ");
            stringBuilder.append(purchasesError.getCode());
            stringBuilder.append("and message ");
            stringBuilder.append(purchasesError.getMessage());
            stringBuilder.append(" \n extra: ");
            stringBuilder.append(purchasesError.getUnderlyingErrorMessage());
            stringBuilder.append(')');
            Exception exception = new Exception(stringBuilder.toString());
            a.d(exception);
        }

        @Override // com.revenuecat.purchases.interfaces.ReceivePurchaserInfoListener
        public void onReceived(PurchaserInfo purchaserInfo) {
            n.f(purchaserInfo, "purchaserInfo");
            a.f("User successfully logged out", new Object[0]);
        }
    }
    static {
        h2.a aVar = new h2.a(0);
        h2.Companion = aVar;
    }

    public h2(FirebaseAuth firebaseAuth, app.dogo.com.dogo_android.service.u2 u22, o3 o33, Resources resources4, app.dogo.com.dogo_android.service.m2 m25, Purchases purchases6, ConnectivityManager connectivityManager7, k k8, p p9, b b10, d1 d111, DogoApiClient dogoApiClient12, app.dogo.com.dogo_android.service.p2 p213, c c14, FirebaseMessaging firebaseMessaging15, app.dogo.com.dogo_android.service.r2 r216) {
        Object obj = this;
        Object obj3 = firebaseAuth;
        final Object obj4 = u22;
        final Object obj5 = o33;
        final Object obj6 = resources4;
        final Object obj7 = m25;
        final Object obj8 = purchases6;
        final Object obj9 = connectivityManager7;
        final Object obj10 = k8;
        final Object obj11 = p9;
        final Object obj12 = b10;
        final Object obj13 = d111;
        final Object obj14 = dogoApiClient12;
        final Object obj15 = p213;
        final Object obj16 = c14;
        n.f(obj3, "firebaseAuth");
        n.f(obj4, "fireBaseDBService");
        n.f(obj5, "tracker");
        n.f(obj6, "resources");
        n.f(obj7, "firestoreService");
        n.f(obj8, "purchases");
        n.f(obj9, "connectivityManager");
        n.f(obj10, "callbackManager");
        n.f(obj11, "facebookLoginManager");
        n.f(obj12, "googleSignInClient");
        n.f(obj13, "credentialRepository");
        n.f(obj14, "apiClient");
        n.f(obj15, "preferenceService");
        n.f(obj16, "apiAdapter");
        n.f(firebaseMessaging15, "firebaseMessaging");
        Object obj18 = r216;
        n.f(obj18, "remoteConfigService");
        super();
        Object obj2 = this;
        obj2.a = obj3;
        obj2.b = obj4;
        obj2.c = obj5;
        obj2.d = obj6;
        obj2.e = obj7;
        obj2.f = obj8;
        obj2.g = obj9;
        obj2.h = obj10;
        obj2.i = obj11;
        obj2.j = obj12;
        obj2.k = obj13;
        obj2.l = obj14;
        obj2.m = obj15;
        obj2.n = obj16;
        obj2.o = firebaseMessaging15;
        obj2.p = obj18;
    }

    private static final g0 A0(app.dogo.com.dogo_android.service.h2 h2, w w2) {
        n.f(h2, "this$0");
        n.f(w2, "it");
        j obj2 = h2.o.getToken();
        n.e(obj2, "firebaseMessaging.token");
        c cVar = new c(h2);
        return j1.N0(obj2).map(cVar);
    }

    private final boolean B() {
        NetworkInfo connectedOrConnecting;
        int i;
        connectedOrConnecting = this.g.getActiveNetworkInfo();
        if (connectedOrConnecting != null && connectedOrConnecting.isConnectedOrConnecting()) {
            i = connectedOrConnecting.isConnectedOrConnecting() ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final w B0(app.dogo.com.dogo_android.service.h2 h2, String string2) {
        n.f(h2, "this$0");
        n.f(string2, "token");
        h2.m.K0(string2);
        return w.a;
    }

    private static final f C0(app.dogo.com.dogo_android.service.h2 h2, boolean z2, w w3) {
        n.f(h2, "this$0");
        n.f(w3, "it");
        UserLoginRequest userLoginRequest = new UserLoginRequest(h2.b.A().i().a());
        g gVar = new g(h2);
        o oVar = new o(h2, z2);
        return h2.l.loginUserSingle(userLoginRequest).flatMapCompletable(gVar).q(a.b()).d(h2.p.m0()).flatMapCompletable(oVar);
    }

    private static final f D0(app.dogo.com.dogo_android.service.h2 h2, UserApiModel userApiModel2) {
        String str;
        boolean compareTo;
        Object firstAppOpenVersion;
        n.f(h2, "this$0");
        n.f(userApiModel2, "it");
        if (h2.m.i0() && h2.m.C() == null) {
            if (h2.m.C() == null) {
                str = "";
            }
            if (str.compareTo(userApiModel2.getFirstAppOpenVersion()) > 0) {
                h2.m.S0(userApiModel2.getFirstAppOpenVersion());
                h2.m.M0(Integer.valueOf(userApiModel2.getFirstAppOpenBuild()));
                h2.c.l();
            }
        }
        int i2 = 0;
        return u2.c0(h2.b, userApiModel2, i2, 2, i2);
    }

    public static w E(app.dogo.com.dogo_android.service.h2 h2, String string2) {
        return h2.z0(h2, string2);
    }

    private static final f E0(app.dogo.com.dogo_android.service.h2 h2, boolean z2, Boolean boolean3) {
        b obj1;
        n.f(h2, "this$0");
        n.f(boolean3, "it");
        h2.c.r(h2.b.A().i());
        if (z2) {
            obj1 = h2.b();
        } else {
            obj1 = b.f();
        }
        return obj1;
    }

    public static w F(app.dogo.com.dogo_android.service.h2 h2, String string2) {
        return h2.B0(h2, string2);
    }

    public static AuthResult G(AuthResult authResult) {
        h2.t0(authResult);
        return authResult;
    }

    public static void H(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3, c0 c04) {
        h2.k(h2, string2, string3, c04);
    }

    public static void I(app.dogo.com.dogo_android.service.h2 h2, String string2, c c3) {
        h2.i0(h2, string2, c3);
    }

    public static f J(app.dogo.com.dogo_android.service.h2 h2, UserApiModel userApiModel2) {
        return h2.D0(h2, userApiModel2);
    }

    public static g0 K(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        return h2.n0(h2, authResult2);
    }

    public static g0 L(app.dogo.com.dogo_android.service.h2 h2, w w2) {
        return h2.A0(h2, w2);
    }

    public static void M(app.dogo.com.dogo_android.service.h2 h2, c0 c02) {
        h2.e(h2, c02);
    }

    public static g0 N(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, Throwable throwable3) {
        return h2.o(h2, authCredential2, throwable3);
    }

    public static void O(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, c0 c03) {
        h2.m0(h2, authCredential2, c03);
    }

    public static void P(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, c0 c03) {
        h2.q0(h2, authCredential2, c03);
    }

    public static AuthResult Q(AuthResult authResult) {
        h2.m(authResult);
        return authResult;
    }

    public static f R(app.dogo.com.dogo_android.service.h2 h2, boolean z2, Boolean boolean3) {
        return h2.E0(h2, z2, boolean3);
    }

    public static g0 S(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, String string3, String string4) {
        return h2.q(h2, authCredential2, string3, string4);
    }

    public static AuthResult T(AuthResult authResult) {
        h2.t(authResult);
        return authResult;
    }

    public static void U(c0 c0, j j2) {
        h2.r0(c0, j2);
    }

    public static g0 V(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        return h2.s0(h2, authResult2);
    }

    public static void W(c c, Exception exception2) {
        h2.k0(c, exception2);
    }

    public static f X(app.dogo.com.dogo_android.service.h2 h2, boolean z2, w w3) {
        return h2.C0(h2, z2, w3);
    }

    public static void Y(c c, Void void2) {
        h2.j0(c, void2);
    }

    public static g0 Z(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        return h2.l(h2, authResult2);
    }

    private final void a() {
        this.a.signOut();
        this.j.d();
        this.f.logOut(z());
    }

    public static f a0(app.dogo.com.dogo_android.service.h2 h2, Throwable throwable2) {
        return h2.y0(h2, throwable2);
    }

    private final b b() {
        b ignoreElement;
        String arr;
        int str;
        int i;
        int i2 = 0;
        if (this.b.A().m().isEmpty()) {
            a.f("Creating a new dog on login", new Object[i2]);
            i = 0;
            ignoreElement = u2.c(this.b, v(), i, 2, i).ignoreElement();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User has ");
            stringBuilder.append(this.b.A().m().size());
            stringBuilder.append(" dogs");
            a.f(stringBuilder.toString(), new Object[i2]);
            ignoreElement = b.f();
        }
        return ignoreElement;
    }

    public static AuthResult b0(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        h2.g(h2, authResult2);
        return authResult2;
    }

    public static g0 c0(app.dogo.com.dogo_android.service.h2 h2, String string2, AuthResult authResult3, UserApiModel userApiModel4) {
        return h2.s(h2, string2, authResult3, userApiModel4);
    }

    public static a0 d(app.dogo.com.dogo_android.service.h2 h2, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return h2.c(obj1);
    }

    public static g0 d0(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3, AuthResult authResult4) {
        return h2.r(h2, string2, string3, authResult4);
    }

    private static final void e(app.dogo.com.dogo_android.service.h2 h2, c0 c02) {
        Object obj1;
        n.f(h2, "this$0");
        n.f(c02, "it");
        obj1 = m.a(h2.a.signInAnonymously());
        n.d(obj1);
        c02.onSuccess((AuthResult)obj1);
    }

    public static g0 e0(app.dogo.com.dogo_android.service.h2 h2, boolean z2, AuthResult authResult3) {
        return h2.f(h2, z2, authResult3);
    }

    private static final g0 f(app.dogo.com.dogo_android.service.h2 h2, boolean z2, AuthResult authResult3) {
        n.f(h2, "this$0");
        n.f(authResult3, "result");
        y yVar = new y(h2, authResult3);
        return h2.w0(z2).B(yVar);
    }

    public static AuthResult f0(AuthResult authResult) {
        h2.o0(authResult);
        return authResult;
    }

    private static final AuthResult g(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        n.f(h2, "this$0");
        n.f(authResult2, "$result");
        h2.c.l();
        return authResult2;
    }

    private static final void i0(app.dogo.com.dogo_android.service.h2 h2, String string2, c c3) {
        n.f(h2, "this$0");
        n.f(string2, "$email");
        n.f(c3, "emitter");
        j obj1 = h2.a.sendPasswordResetEmail(string2);
        n.e(obj1, "firebaseAuth.sendPasswordResetEmail(email)");
        v obj2 = new v(c3);
        obj1.addOnSuccessListener(obj2);
        obj2 = new t(c3);
        obj1.addOnFailureListener(obj2);
    }

    private final a0<AuthResult> j(String string, String string2) {
        e eVar = new e(this, string, string2);
        w obj3 = new w(this);
        a0 obj2 = a0.create(eVar).flatMap(obj3);
        n.e(obj2, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.createUserWithEmailAndPassword(email, password))\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.d(e)\n                it.tryOnError(e)\n            }\n        }.flatMap { result: AuthResult ->\n            userSyncWithBackend().toSingle { result }\n        }");
        return obj2;
    }

    private static final void j0(c c, Void void2) {
        n.f(c, "$emitter");
        c.onComplete();
    }

    private static final void k(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3, c0 c04) {
        Object obj1;
        n.f(h2, "this$0");
        n.f(string2, "$email");
        n.f(string3, "$password");
        n.f(c04, "it");
        c04.onSuccess((AuthResult)m.a(h2.a.createUserWithEmailAndPassword(string2, string3)));
    }

    private static final void k0(c c, Exception exception2) {
        n.f(c, "$emitter");
        c.a(exception2);
    }

    private static final g0 l(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        n.f(h2, "this$0");
        n.f(authResult2, "result");
        n nVar = new n(authResult2);
        return h2.x0(h2, false, 1, 0).B(nVar);
    }

    private final a0<AuthResult> l0(AuthCredential authCredential) {
        l lVar = new l(this, authCredential);
        h hVar = new h(this);
        a0 obj2 = a0.create(lVar).subscribeOn(a.b()).subscribeOn(a.b()).flatMap(hVar);
        n.e(obj2, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.signInWithCredential(lastCredential))\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.d(e)\n                it.tryOnError(e)\n            }\n        }.subscribeOn(Schedulers.io())\n            .subscribeOn(Schedulers.io())\n            .flatMap { userSyncWithBackend().toSingle { it } }");
        return obj2;
    }

    private static final AuthResult m(AuthResult authResult) {
        n.f(authResult, "$result");
        return authResult;
    }

    private static final void m0(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, c0 c03) {
        Object obj1;
        n.f(h2, "this$0");
        n.f(authCredential2, "$lastCredential");
        n.f(c03, "it");
        c03.onSuccess((AuthResult)m.a(h2.a.signInWithCredential(authCredential2)));
    }

    private static final g0 n0(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        n.f(h2, "this$0");
        n.f(authResult2, "it");
        c0 c0Var = new c0(authResult2);
        return h2.x0(h2, false, 1, 0).B(c0Var);
    }

    private static final g0 o(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, Throwable throwable3) {
        n.f(h2, "this$0");
        n.f(authCredential2, "$lastCredential");
        n.f(throwable3, "error");
        if (throwable3 instanceof FirebaseAuthUserCollisionException == null) {
        } else {
            return h2.p(authCredential2);
        }
        throw throwable3;
    }

    private static final AuthResult o0(AuthResult authResult) {
        n.f(authResult, "$it");
        return authResult;
    }

    private final a0<AuthResult> p(AuthCredential authCredential) {
        p pVar = new p(this, authCredential, this.b.A().f());
        final a0 obj4 = j1.N0(j1.s0(this.a, false)).flatMap(pVar);
        n.e(obj4, "firebaseAuth.refreshIdToken(false).toSingle().flatMap { oldToken ->\n            signInWithCredentialSingle(lastCredential).flatMap { authResults ->\n                userSyncWithBackend().andThen(apiClient.mergeUsers(UserMergeRequest(otherUserToken = oldToken))).flatMap {\n                    fireBaseDBService.updateLocalUserData(it, currentDogId).toSingle { authResults }\n                }\n            }\n        }");
        return obj4;
    }

    private final a0<AuthResult> p0(AuthCredential authCredential) {
        m mVar = new m(this, authCredential);
        s sVar = new s(this);
        a0 obj2 = a0.create(mVar).flatMap(sVar);
        n.e(obj2, "create<AuthResult> { emitter ->\n            firebaseAuth.signInWithCredential(lastCredential).addOnCompleteListener { task ->\n                if (task.isSuccessful && task.result != null) {\n                    emitter.onSuccess(task.result)\n                } else {\n                    emitter.tryOnError(task.exception ?: Throwable(\"auth, error while singing in with credentials\"))\n                }\n            }\n        }.flatMap { userSyncWithBackend().toSingle { it } }");
        return obj2;
    }

    private static final g0 q(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, String string3, String string4) {
        n.f(h2, "this$0");
        n.f(authCredential2, "$lastCredential");
        n.f(string3, "$currentDogId");
        n.f(string4, "oldToken");
        a0 a0Var = new a0(h2, string4, string3);
        return h2.p0(authCredential2).flatMap(a0Var);
    }

    private static final void q0(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2, c0 c03) {
        n.f(h2, "this$0");
        n.f(authCredential2, "$lastCredential");
        n.f(c03, "emitter");
        r obj2 = new r(c03);
        h2.a.signInWithCredential(authCredential2).addOnCompleteListener(obj2);
    }

    private static final g0 r(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3, AuthResult authResult4) {
        n.f(h2, "this$0");
        n.f(string2, "$oldToken");
        n.f(string3, "$currentDogId");
        n.f(authResult4, "authResults");
        UserMergeRequest userMergeRequest = new UserMergeRequest(string2);
        z zVar = new z(h2, string3, authResult4);
        return h2.x0(h2, false, 1, 0).d(h2.l.mergeUsers(userMergeRequest)).flatMap(zVar);
    }

    private static final void r0(c0 c0, j j2) {
        boolean successful;
        Throwable obj2;
        n.f(c0, "$emitter");
        if (j2.isSuccessful() && j2.getResult() != null) {
            if (j2.getResult() != null) {
                c0.onSuccess(j2.getResult());
            } else {
                if (j2.getException() == null) {
                    obj2 = new Throwable("auth, error while singing in with credentials");
                }
                c0.a(obj2);
            }
        } else {
        }
    }

    private static final g0 s(app.dogo.com.dogo_android.service.h2 h2, String string2, AuthResult authResult3, UserApiModel userApiModel4) {
        n.f(h2, "this$0");
        n.f(string2, "$currentDogId");
        n.f(authResult3, "$authResults");
        n.f(userApiModel4, "it");
        q obj2 = new q(authResult3);
        return h2.b.b0(userApiModel4, string2).B(obj2);
    }

    private static final g0 s0(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        n.f(h2, "this$0");
        n.f(authResult2, "it");
        d dVar = new d(authResult2);
        return h2.x0(h2, false, 1, 0).B(dVar);
    }

    private static final AuthResult t(AuthResult authResult) {
        n.f(authResult, "$authResults");
        return authResult;
    }

    private static final AuthResult t0(AuthResult authResult) {
        n.f(authResult, "$it");
        return authResult;
    }

    private final b w0(boolean z) {
        b bVar = new b(this);
        i iVar = new i(this);
        u uVar = new u(this, z);
        x xVar = new x(this);
        b obj3 = j1.N0(j1.s0(this.a, false)).map(bVar).flatMap(iVar).flatMapCompletable(uVar).t(xVar);
        n.e(obj3, "firebaseAuth.refreshIdToken(false).toSingle().map { token ->\n            apiAdapter.tokenInterceptor.token = token\n        }.flatMap {\n            firebaseMessaging.token.toSingle().map { token ->\n                preferenceService.fcmToken = token\n            }\n        }.flatMapCompletable {\n            apiClient.loginUserSingle(\n                UserLoginRequest(\n                    device = fireBaseDBService.getUserAndDogCache().deviceData.buildUserDeviceModel()\n                )\n            ).flatMapCompletable {\n                if (preferenceService.isFirstTimeLaunch && (preferenceService.firstOpenVersion ?: \"\") > it.firstAppOpenVersion) {\n                    preferenceService.firstOpenVersion = it.firstAppOpenVersion\n                    preferenceService.firstOpenBuild = it.firstAppOpenBuild\n                    tracker.setFirstAppOpenUserProperties()\n                }\n                fireBaseDBService.updateLocalUserData(it)\n            }.observeOn(Schedulers.io()).andThen(\n                remoteConfigService.safeRefresh()\n            ).flatMapCompletable {\n                tracker.trackDeviceData(fireBaseDBService.getUserAndDogCache().deviceData)\n                if (forceDogCreation) {\n                    addNewDogIfNeeded()\n                } else {\n                    Completable.complete()\n                }\n            }\n        }.onErrorResumeNext {\n            abortSignIn()\n            Completable.error(it)\n        }");
        return obj3;
    }

    static b x0(app.dogo.com.dogo_android.service.h2 h2, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return h2.w0(obj1);
    }

    private static final f y0(app.dogo.com.dogo_android.service.h2 h2, Throwable throwable2) {
        n.f(h2, "this$0");
        n.f(throwable2, "it");
        h2.a();
        return b.m(throwable2);
    }

    private final ReceivePurchaserInfoListener z() {
        h2.b bVar = new h2.b();
        return bVar;
    }

    private static final w z0(app.dogo.com.dogo_android.service.h2 h2, String string2) {
        n.f(h2, "this$0");
        n.f(string2, "token");
        h2.n.c().g(string2);
        return w.a;
    }

    public final UserAuthRecord A() {
        int userAuthRecord;
        FirebaseUser currentUser = this.a.getCurrentUser();
        if (currentUser == null) {
            userAuthRecord = 0;
        } else {
            userAuthRecord = UserAuthRecordKt.toUserAuthRecord(currentUser);
        }
        return userAuthRecord;
    }

    public final boolean C() {
        String email;
        if (D()) {
            FirebaseUser currentUser = this.a.getCurrentUser();
            if (currentUser == null) {
                email = 0;
            } else {
                email = currentUser.getEmail();
            }
            if (email != null) {
                return m2Var.f.contains(email);
            }
        }
        return 0;
    }

    public final boolean D() {
        FirebaseUser currentUser;
        int i;
        currentUser = this.a.getCurrentUser();
        if (currentUser != null && !currentUser.isAnonymous()) {
            i = !currentUser.isAnonymous() ? 1 : 0;
        } else {
        }
        return i;
    }

    public final a0<AuthResult> c(boolean z) {
        j jVar = new j(this);
        b0 b0Var = new b0(this, z);
        final a0 obj3 = a0.create(jVar).flatMap(b0Var);
        n.e(obj3, "create<AuthResult> {\n            try {\n                val await = Tasks.await(firebaseAuth.signInAnonymously())!!\n                it.onSuccess(await)\n            } catch (e: Exception) {\n                Timber.e(e)\n                it.tryOnError(e)\n            }\n        }.flatMap { result: AuthResult ->\n            userSyncWithBackend(forceDogCreation).toSingle {\n                tracker.setFirstAppOpenUserProperties()\n                result\n            }\n        }");
        return obj3;
    }

    public final a0<AuthResult> g0(String string, String string2, boolean z3) {
        boolean currentUser;
        AuthCredential credential;
        String str;
        a0 obj4;
        Object obj5;
        n.f(string, "email");
        n.f(string2, "password");
        if (B()) {
            credential = EmailAuthProvider.getCredential(string, string2);
            n.e(credential, "getCredential(email, password)");
            this.k.b(credential);
            if (this.a.getCurrentUser() == null && z3) {
                if (z3) {
                    obj4 = j(string, string2);
                } else {
                    obj4 = this.k.a();
                    if (obj4 != null) {
                        obj4 = n(obj4);
                    } else {
                        obj4 = new Throwable("can not link auth");
                        n.e(a0.error(obj4), "{\n                    Single.error(Throwable(\"can not link auth\"))\n                }");
                    }
                }
            } else {
            }
        } else {
            obj4 = new UnknownHostException();
            n.e(a0.error(obj4), "{\n            Single.error(UnknownHostException())\n        }");
        }
        return obj4;
    }

    public final void h(int i, int i2, Intent intent3) {
        this.h.a(i, i2, intent3);
    }

    public final b h0(String string) {
        n.f(string, "email");
        f fVar = new f(this, string);
        final b obj2 = b.g(fVar);
        n.e(obj2, "create { emitter ->\n            val task = firebaseAuth.sendPasswordResetEmail(email)\n            task.addOnSuccessListener { emitter.onComplete() }\n            task.addOnFailureListener { emitter.tryOnError(it) }\n        }");
        return obj2;
    }

    public final void i(int i, int i2, Intent intent3) {
        int str;
        int obj2;
        int obj3;
        Object obj4;
        if (i == 10001) {
            if (i2 == -1) {
                obj2 = GoogleAuthProvider.getCredential((GoogleSignInAccount)a.b(intent3).getResult(ApiException.class).getIdToken(), 0);
                n.e(obj2, "getCredential(account.idToken, null)");
                this.k.b(obj2);
            } else {
                obj4 = new StringBuilder();
                obj4.append("Google unexpected result code [ ");
                obj4.append(i2);
                obj4.append(" ]");
                obj2 = new IllegalStateException(obj4.toString());
                a.j(obj2);
            }
        }
    }

    public final a0<AuthResult> n(AuthCredential authCredential) {
        Object currentUser;
        app.dogo.com.dogo_android.service.k kVar;
        a0 obj3;
        n.f(authCredential, "lastCredential");
        currentUser = this.a.getCurrentUser();
        if (currentUser != null) {
            kVar = new k(this, authCredential);
            n.e(j1.h0(currentUser, authCredential).onErrorResumeNext(kVar), "{\n            currentUser.linkWithCredentialSingle(lastCredential)\n                .onErrorResumeNext { error ->\n                    if (error is FirebaseAuthUserCollisionException) {\n                        firebaseAuthMerge(lastCredential)\n                    } else {\n                        throw error\n                    }\n                }\n        }");
        } else {
            obj3 = l0(authCredential);
        }
        return obj3;
    }

    public final String u() {
        Object runtimeException;
        int i;
        int providerId;
        boolean next;
        int i2;
        int i3;
        boolean z;
        String str;
        i = 0;
        if (D()) {
            runtimeException = this.a.getCurrentUser();
            if (runtimeException != null) {
                runtimeException = runtimeException.getProviderData().iterator();
                providerId = i;
                while (runtimeException.hasNext()) {
                    next = runtimeException.next();
                    if (n.b(next.getProviderId(), "password")) {
                    }
                    if (z2 ^= i3 != 0 && i3 != 0) {
                    }
                    if (i3 != 0) {
                    }
                    providerId = next.getProviderId();
                    if (providerId == 0) {
                    } else {
                    }
                    i3 = 0;
                }
            } else {
                providerId = i;
            }
            if (providerId != 0) {
                i = providerId;
            } else {
                runtimeException = new RuntimeException("Could not determine authentication provider, even though usr is logged in.");
                a.d(runtimeException);
            }
        }
        return i;
    }

    public final a0<AuthResult> u0() {
        a0 error;
        String str;
        int i2;
        int i;
        i2 = 0;
        if (B()) {
            this.a.signOut();
            this.j.d();
            this.f.logOut(z());
            n.e(this.b.i(v()).d(h2.d(this, i2, 1, 0)), "{\n            firebaseAuth.signOut()\n            googleSignInClient.signOut()\n            purchases.logOut(revCatLogoutListener)\n            fireBaseDBService.deactivateDevice(userId).andThen(anonymousSignInSingle())\n        }");
        } else {
            int i4 = 2131886953;
            a.c(this.d.getString(i4), new Object[i2]);
            UnknownHostException unknownHostException = new UnknownHostException(this.d.getString(i4));
            n.e(a0.error(unknownHostException), "{\n            Timber.e(resources.getString(R.string.no_internet_connection))\n            Single.error(UnknownHostException(resources.getString(R.string.no_internet_connection)))\n        }");
        }
        return error;
    }

    public final String v() {
        String uid;
        if (this.a.getUid() == null) {
            uid = "";
        }
        return uid;
    }

    public final b v0(String string) {
        n.f(string, "displayName");
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        com.google.firebase.auth.UserProfileChangeRequest obj2 = builder.setDisplayName(string).build();
        n.e(obj2, "Builder()\n                .setDisplayName(displayName)\n                .build()");
        FirebaseUser currentUser = this.a.getCurrentUser();
        n.d(currentUser);
        obj2 = currentUser.updateProfile(obj2);
        n.e(obj2, "firebaseAuth.currentUser!!.updateProfile(profileUpdates)");
        return j1.I0(obj2);
    }

    public final p w() {
        return this.i;
    }

    public final List<String> x() {
        return p.j(/* result */);
    }

    public final b y() {
        return this.j;
    }
}
