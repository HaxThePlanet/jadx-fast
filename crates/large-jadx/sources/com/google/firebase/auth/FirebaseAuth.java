package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.hm;
import com.google.android.gms.internal.firebase-auth-api.hp;
import com.google.android.gms.internal.firebase-auth-api.jm;
import com.google.android.gms.internal.firebase-auth-api.kl;
import com.google.android.gms.internal.firebase-auth-api.kn;
import com.google.android.gms.internal.firebase-auth-api.ml;
import com.google.android.gms.internal.firebase-auth-api.ql;
import com.google.android.gms.internal.firebase-auth-api.qm;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.android.gms.internal.firebase-auth-api.un;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class FirebaseAuth implements InternalAuthProvider {

    private FirebaseApp zza;
    private final List<com.google.firebase.auth.FirebaseAuth.IdTokenListener> zzb;
    private final List<IdTokenListener> zzc;
    private List<com.google.firebase.auth.FirebaseAuth.AuthStateListener> zzd;
    private kl zze;
    private com.google.firebase.auth.FirebaseUser zzf;
    private zzw zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private final zzbg zzl;
    private final zzbm zzm;
    private final zzf zzn;
    private zzbi zzo;
    private zzbj zzp;

    public interface AuthStateListener {
        public abstract void onAuthStateChanged(com.google.firebase.auth.FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        public abstract void onIdTokenChanged(com.google.firebase.auth.FirebaseAuth firebaseAuth);
    }
    public FirebaseAuth(FirebaseApp firebaseApp) {
        Object zzf;
        zzbg zzbg;
        com.google.android.gms.common.internal.safeparcel.a obj6;
        String apiKey = firebaseApp.getOptions().getApiKey();
        r.f(apiKey);
        zzf = jm.a(firebaseApp.getApplicationContext(), hm.a(apiKey));
        zzbg = new zzbg(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbm zzbm = zzbm.zzc();
        zzf zzf2 = zzf.zzb();
        super();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.zzb = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.zzc = copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        this.zzd = copyOnWriteArrayList3;
        Object object = new Object();
        this.zzh = object;
        Object object2 = new Object();
        this.zzj = object2;
        this.zzp = zzbj.zza();
        r.j(firebaseApp);
        this.zza = (FirebaseApp)firebaseApp;
        r.j(zzf);
        this.zze = (kl)zzf;
        r.j(zzbg);
        this.zzl = (zzbg)zzbg;
        obj6 = new zzw();
        this.zzg = obj6;
        r.j(zzbm);
        this.zzm = (zzbm)zzbm;
        r.j(zzf2);
        this.zzn = (zzf)zzf2;
        obj6 = zzbg.zza();
        this.zzf = obj6;
        obj6 = zzbg.zzb(obj6);
        if (obj6 != null && obj6 != null) {
            obj6 = zzbg.zzb(obj6);
            if (obj6 != null) {
                zzbg = 0;
                FirebaseAuth.zzG(this, this.zzf, obj6, zzbg, zzbg);
            }
        }
        zzbm.zze(this);
    }

    public static com.google.firebase.auth.FirebaseAuth getInstance() {
        return (FirebaseAuth)FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static com.google.firebase.auth.FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth)firebaseApp.get(FirebaseAuth.class);
    }

    static List zzA(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzb;
    }

    static List zzB(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzd;
    }

    public static void zzE(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        String str;
        StringBuilder stringBuilder;
        String obj4;
        String str2 = "FirebaseAuth";
        if (firebaseUser2 != null) {
            obj4 = firebaseUser2.getUid();
            stringBuilder = new StringBuilder(length += 47);
            stringBuilder.append("Notifying auth state listeners about user ( ");
            stringBuilder.append(obj4);
            stringBuilder.append(" ).");
            Log.d(str2, stringBuilder.toString());
        } else {
            Log.d(str2, "Notifying auth state listeners about a sign-out event.");
        }
        zzm zzm = new zzm(firebaseAuth);
        firebaseAuth.zzp.execute(zzm);
    }

    public static void zzF(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        String string;
        String str;
        StringBuilder stringBuilder;
        int obj5;
        String str2 = "FirebaseAuth";
        if (firebaseUser2 != null) {
            String uid = firebaseUser2.getUid();
            stringBuilder = new StringBuilder(length += 45);
            stringBuilder.append("Notifying id token listeners about user ( ");
            stringBuilder.append(uid);
            stringBuilder.append(" ).");
            Log.d(str2, stringBuilder.toString());
        } else {
            Log.d(str2, "Notifying id token listeners about a sign-out event.");
        }
        if (firebaseUser2 != null) {
            obj5 = firebaseUser2.zze();
        } else {
            obj5 = 0;
        }
        InternalTokenResult internalTokenResult = new InternalTokenResult(obj5);
        zzl zzl = new zzl(firebaseAuth, internalTokenResult);
        firebaseAuth.zzp.execute(zzl);
    }

    static void zzG(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseUser firebaseUser2, to to3, boolean z4, boolean z5) {
        com.google.firebase.auth.FirebaseUser equals;
        int i;
        boolean anonymous;
        Object enrolledFactors;
        int zzf;
        int i2;
        String uid;
        Object obj4;
        com.google.android.gms.common.internal.safeparcel.a obj5;
        zzbg obj7;
        int obj8;
        r.j(firebaseUser2);
        r.j(to3);
        i2 = 1;
        if (firebaseAuth.zzf != null && firebaseUser2.getUid().equals(firebaseAuth.zzf.getUid())) {
            i = firebaseUser2.getUid().equals(firebaseAuth.zzf.getUid()) ? i2 : zzf;
        } else {
        }
        if (i == 0 && !z5) {
            if (!z5) {
            }
        }
        obj8 = firebaseAuth.zzf;
        if (obj8 == null) {
            obj8 = i2;
        } else {
            if (i != 0 && obj8 ^= i2 == 0) {
                if (obj8 ^= i2 == 0) {
                } else {
                    zzf = i2;
                }
            } else {
            }
            obj8 = i3;
            i2 = zzf;
        }
        r.j(firebaseUser2);
        enrolledFactors = firebaseAuth.zzf;
        if (enrolledFactors == null) {
            firebaseAuth.zzf = firebaseUser2;
        } else {
            enrolledFactors.zzc(firebaseUser2.getProviderData());
            if (!firebaseUser2.isAnonymous()) {
                firebaseAuth.zzf.zzb();
            }
            firebaseAuth.zzf.zzi(firebaseUser2.getMultiFactor().getEnrolledFactors());
        }
        if (z4 != null) {
            firebaseAuth.zzl.zzd(firebaseAuth.zzf);
        }
        com.google.firebase.auth.FirebaseUser zzf2 = firebaseAuth.zzf;
        if (i2 != 0 && zzf2 != null) {
            zzf2 = firebaseAuth.zzf;
            if (zzf2 != null) {
                zzf2.zzh(to3);
            }
            FirebaseAuth.zzF(firebaseAuth, firebaseAuth.zzf);
        }
        if (obj8 != null) {
            FirebaseAuth.zzE(firebaseAuth, firebaseAuth.zzf);
        }
        if (z4 != null) {
            firebaseAuth.zzl.zze(firebaseUser2, to3);
        }
        obj5 = firebaseAuth.zzf;
        if (obj5 != null) {
            FirebaseAuth.zzx(firebaseAuth).zzd(obj5.zzd());
        }
    }

    private final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zzJ(String string, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks2) {
        boolean z;
        boolean obj2;
        if (this.zzg.zzd() && string != null && string.equals(this.zzg.zza())) {
            if (string != null) {
                if (string.equals(this.zzg.zza())) {
                    obj2 = new zzq(this, onVerificationStateChangedCallbacks2);
                    return obj2;
                }
            }
        }
        return onVerificationStateChangedCallbacks2;
    }

    private final boolean zzK(String string) {
        String zzk;
        com.google.firebase.auth.ActionCodeUrl obj2;
        obj2 = ActionCodeUrl.parseLink(string);
        if (obj2 != null && !TextUtils.equals(this.zzk, obj2.zza())) {
            if (!TextUtils.equals(this.zzk, obj2.zza())) {
                return 1;
            }
        }
        return 0;
    }

    static com.google.firebase.auth.FirebaseUser zzs(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzf;
    }

    static com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zzt(com.google.firebase.auth.FirebaseAuth firebaseAuth, String string2, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks3) {
        return firebaseAuth.zzJ(string2, onVerificationStateChangedCallbacks3);
    }

    static kl zzu(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zze;
    }

    static zzw zzv(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzg;
    }

    public static zzbi zzx(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        Object zzo;
        zzbi zzbi;
        if (firebaseAuth.zzo == null) {
            zzo = firebaseAuth.zza;
            r.j(zzo);
            zzbi = new zzbi((FirebaseApp)zzo);
            firebaseAuth.zzo = zzbi;
        }
        return firebaseAuth.zzo;
    }

    static String zzy(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzi;
    }

    static List zzz(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        return firebaseAuth.zzc;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addAuthStateListener(com.google.firebase.auth.FirebaseAuth.AuthStateListener firebaseAuth$AuthStateListener) {
        this.zzd.add(authStateListener);
        zzk zzk = new zzk(this, authStateListener);
        this.zzp.execute(zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.FirebaseAuth.IdTokenListener firebaseAuth$IdTokenListener) {
        this.zzb.add(idTokenListener);
        zzbj zzp = this.zzp;
        r.j(zzp);
        zzj zzj = new zzj(this, idTokenListener);
        (zzbj)zzp.execute(zzj);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(IdTokenListener idTokenListener) {
        r.j(idTokenListener);
        this.zzc.add(idTokenListener);
        zzw().zzc(this.zzc.size());
    }

    public j<Void> applyActionCode(String string) {
        r.f(string);
        return this.zze.x(this.zza, string, this.zzk);
    }

    public j<com.google.firebase.auth.ActionCodeResult> checkActionCode(String string) {
        r.f(string);
        return this.zze.y(this.zza, string, this.zzk);
    }

    public j<Void> confirmPasswordReset(String string, String string2) {
        r.f(string);
        r.f(string2);
        return this.zze.z(this.zza, string, string2, this.zzk);
    }

    public j<com.google.firebase.auth.AuthResult> createUserWithEmailAndPassword(String string, String string2) {
        r.f(string);
        r.f(string2);
        zzs zzs = new zzs(this);
        return this.zze.A(this.zza, string, string2, this.zzk, zzs);
    }

    public j<com.google.firebase.auth.SignInMethodQueryResult> fetchSignInMethodsForEmail(String string) {
        r.f(string);
        return this.zze.C(this.zza, string, this.zzk);
    }

    public final j<com.google.firebase.auth.GetTokenResult> getAccessToken(boolean z) {
        return zzc(this.zzf, z);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public FirebaseApp getApp() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public com.google.firebase.auth.FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public com.google.firebase.auth.FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public String getLanguageCode() {
        final Object zzh = this.zzh;
        return this.zzi;
        synchronized (zzh) {
            zzh = this.zzh;
            return this.zzi;
        }
    }

    public j<com.google.firebase.auth.AuthResult> getPendingAuthResult() {
        return this.zzm.zza();
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public String getTenantId() {
        final Object zzj = this.zzj;
        return this.zzk;
        synchronized (zzj) {
            zzj = this.zzj;
            return this.zzk;
        }
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final String getUid() {
        com.google.firebase.auth.FirebaseUser zzf = this.zzf;
        if (zzf == null) {
            return null;
        }
        return zzf.getUid();
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public boolean isSignInWithEmailLink(String string) {
        return EmailAuthCredential.zzi(string);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeAuthStateListener(com.google.firebase.auth.FirebaseAuth.AuthStateListener firebaseAuth$AuthStateListener) {
        this.zzd.remove(authStateListener);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.FirebaseAuth.IdTokenListener firebaseAuth$IdTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        r.j(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzw().zzc(this.zzc.size());
    }

    public j<Void> sendPasswordResetEmail(String string) {
        r.f(string);
        return sendPasswordResetEmail(string, 0);
    }

    public j<Void> sendPasswordResetEmail(String string, com.google.firebase.auth.ActionCodeSettings actionCodeSettings2) {
        com.google.firebase.auth.ActionCodeSettings obj5;
        r.f(string);
        if (actionCodeSettings2 == null) {
            obj5 = ActionCodeSettings.zzb();
        }
        String zzi = this.zzi;
        if (zzi != null) {
            obj5.zzf(zzi);
        }
        obj5.zzg(1);
        return this.zze.R(this.zza, string, obj5, this.zzk);
    }

    public j<Void> sendSignInLinkToEmail(String string, com.google.firebase.auth.ActionCodeSettings actionCodeSettings2) {
        r.f(string);
        r.j(actionCodeSettings2);
        if (!actionCodeSettings2.canHandleCodeInApp()) {
        } else {
            String zzi = this.zzi;
            if (zzi != null) {
                actionCodeSettings2.zzf(zzi);
            }
            return this.zze.S(this.zza, string, actionCodeSettings2, this.zzk);
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        throw obj4;
    }

    public j<Void> setFirebaseUIVersion(String string) {
        return this.zze.e(string);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void setLanguageCode(String string) {
        r.f(string);
        final Object zzh = this.zzh;
        this.zzi = string;
        return;
        synchronized (zzh) {
            r.f(string);
            zzh = this.zzh;
            this.zzi = string;
        }
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void setTenantId(String string) {
        r.f(string);
        final Object zzj = this.zzj;
        this.zzk = string;
        return;
        synchronized (zzj) {
            r.f(string);
            zzj = this.zzj;
            this.zzk = string;
        }
    }

    public j<com.google.firebase.auth.AuthResult> signInAnonymously() {
        com.google.firebase.auth.FirebaseUser anonymous;
        anonymous = this.zzf;
        if (anonymous != null && anonymous.isAnonymous()) {
            if (anonymous.isAnonymous()) {
                com.google.firebase.auth.FirebaseUser zzf = this.zzf;
                (zzx)zzf.zzq(false);
                zzr zzr = new zzr(zzf);
                return m.e(zzr);
            }
        }
        zzs zzs = new zzs(this);
        return this.zze.f(this.zza, zzs, this.zzk);
    }

    public j<com.google.firebase.auth.AuthResult> signInWithCredential(com.google.firebase.auth.AuthCredential authCredential) {
        r.j(authCredential);
        com.google.firebase.auth.AuthCredential obj8 = authCredential.zza();
        if (obj8 instanceof EmailAuthCredential && !(EmailAuthCredential)obj8.zzg()) {
            if (!(EmailAuthCredential)obj8.zzg()) {
                final String str3 = obj8.zze();
                r.f(str3);
                zzs zzs4 = new zzs(this);
                return this.zze.i(this.zza, obj8.zzd(), str3, this.zzk, zzs4);
            }
            String str = obj8.zzf();
            r.f(str);
            if (zzK(str)) {
                obj8 = new Status(17072);
                return m.d(ql.a(obj8));
            }
            zzs zzs = new zzs(this);
            return this.zze.j(this.zza, obj8, zzs);
        }
        if (obj8 instanceof PhoneAuthCredential) {
            zzs zzs2 = new zzs(this);
            return this.zze.k(this.zza, (PhoneAuthCredential)obj8, this.zzk, zzs2);
        }
        zzs zzs3 = new zzs(this);
        return this.zze.g(this.zza, obj8, this.zzk, zzs3);
    }

    public j<com.google.firebase.auth.AuthResult> signInWithCustomToken(String string) {
        r.f(string);
        zzs zzs = new zzs(this);
        return this.zze.h(this.zza, string, this.zzk, zzs);
    }

    public j<com.google.firebase.auth.AuthResult> signInWithEmailAndPassword(String string, String string2) {
        r.f(string);
        r.f(string2);
        zzs zzs = new zzs(this);
        return this.zze.i(this.zza, string, string2, this.zzk, zzs);
    }

    public j<com.google.firebase.auth.AuthResult> signInWithEmailLink(String string, String string2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(string, string2));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void signOut() {
        zzC();
        final zzbi zzo = this.zzo;
        if (zzo != null) {
            zzo.zzb();
        }
    }

    public j<com.google.firebase.auth.AuthResult> startActivityForSignInWithProvider(Activity activity, com.google.firebase.auth.FederatedAuthProvider federatedAuthProvider2) {
        r.j(federatedAuthProvider2);
        r.j(activity);
        k kVar = new k();
        if (!this.zzm.zzi(activity, kVar, this)) {
            Status obj4 = new Status(17057);
            return m.d(ql.a(obj4));
        }
        this.zzm.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider2.zzc(activity);
        return kVar.a();
    }

    public j<Void> updateCurrentUser(com.google.firebase.auth.FirebaseUser firebaseUser) {
        String tenantId;
        String apiKey;
        boolean equals;
        if (firebaseUser == null) {
        } else {
            tenantId = firebaseUser.getTenantId();
            if (tenantId != null) {
                equals = this.zzk;
                if (tenantId.equals(this.zzk) && equals != null && equals.equals(tenantId)) {
                    equals = this.zzk;
                    if (equals != null) {
                        if (equals.equals(tenantId)) {
                        }
                    }
                }
                Status obj4 = new Status(17072);
                return m.d(ql.a(obj4));
            } else {
            }
            if (firebaseUser.zzd().n2() && this.zza.getOptions().getApiKey().equals(firebaseUser.zza().getOptions().getApiKey())) {
                if (apiKey2.equals(apiKey)) {
                    zzD(zzx.zzk(this.zza, firebaseUser), firebaseUser.zzd(), true);
                    return m.e(0);
                }
            }
            zzu zzu = new zzu(this);
            return zzg(firebaseUser, zzu);
        }
        obj4 = new IllegalArgumentException("Cannot update current user with null user!");
        throw obj4;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void useAppLanguage() {
        final Object zzh = this.zzh;
        this.zzi = qm.a();
        return;
        synchronized (zzh) {
            zzh = this.zzh;
            this.zzi = qm.a();
        }
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void useEmulator(String string, int i2) {
        int i;
        int i3;
        r.f(string);
        i = 0;
        if (i2 >= 0 && i2 <= 65535) {
            if (i2 <= 65535) {
                i = 1;
            }
        }
        r.b(i, "Port number must be in the range 0-65535");
        un.f(this.zza, string, i2);
    }

    public j<String> verifyPasswordResetCode(String string) {
        r.f(string);
        return this.zze.u(this.zza, string, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final void zzC() {
        Object format;
        zzbg zzl;
        Object[] arr;
        int i;
        r.j(this.zzl);
        format = this.zzf;
        final int i2 = 0;
        if (format != null) {
            r.j(format);
            arr = new Object[1];
            this.zzl.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", format.getUid()));
            this.zzf = i2;
        }
        this.zzl.zzc("com.google.firebase.auth.FIREBASE_USER");
        FirebaseAuth.zzF(this, i2);
        FirebaseAuth.zzE(this, i2);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final void zzD(com.google.firebase.auth.FirebaseUser firebaseUser, to to2, boolean z3) {
        FirebaseAuth.zzG(this, firebaseUser, to2, true, false);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final void zzH(com.google.firebase.auth.PhoneAuthOptions phoneAuthOptions) {
        Object obj;
        boolean uid;
        com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks2;
        Activity activity;
        Object obj2;
        String str;
        long longValue;
        TimeUnit sECONDS;
        com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
        Activity activity2;
        Executor executor;
        int i;
        com.google.firebase.auth.PhoneAuthOptions obj14;
        if (phoneAuthOptions.zzk()) {
            obj = phoneAuthOptions.zzb();
            com.google.firebase.auth.MultiFactorSession multiFactorSession = phoneAuthOptions.zzc();
            r.j(multiFactorSession);
            if ((zzag)multiFactorSession.zze()) {
                r.f(phoneAuthOptions.zzh());
            } else {
                com.google.firebase.auth.PhoneMultiFactorInfo phoneMultiFactorInfo = phoneAuthOptions.zzf();
                r.j(phoneMultiFactorInfo);
                r.f((PhoneMultiFactorInfo)phoneMultiFactorInfo.getUid());
            }
            activity = phoneAuthOptions.zza();
            r.j(activity);
            if (phoneAuthOptions.zzd() != null && kn.d(uid, phoneAuthOptions.zze(), (Activity)activity, phoneAuthOptions.zzi())) {
                activity = phoneAuthOptions.zza();
                r.j(activity);
                if (kn.d(uid, phoneAuthOptions.zze(), (Activity)activity, phoneAuthOptions.zzi())) {
                }
            }
            Activity activity3 = phoneAuthOptions.zza();
            r.j(activity3);
            zzp zzp = new zzp(obj, phoneAuthOptions);
            obj.zzn.zza(obj, phoneAuthOptions.zzh(), (Activity)activity3, ml.b()).addOnCompleteListener(zzp);
        }
        obj2 = phoneAuthOptions.zzb();
        str = phoneAuthOptions.zzh();
        r.f(str);
        onVerificationStateChangedCallbacks = phoneAuthOptions.zze();
        obj = phoneAuthOptions.zza();
        r.j(obj);
        activity2 = obj;
        executor = phoneAuthOptions.zzi();
        obj14 = phoneAuthOptions.zzd() != null ? 1 : 0;
        i = obj14;
        if (i == 0 && !kn.d(str, onVerificationStateChangedCallbacks, (Activity)activity2, executor)) {
            if (!kn.d(str, onVerificationStateChangedCallbacks, activity2, executor)) {
            }
        }
        super(obj2, str, phoneAuthOptions.zzg().longValue(), obj7, TimeUnit.SECONDS, onVerificationStateChangedCallbacks, activity2, executor, i);
        obj2.zzn.zza(obj2, str, activity2, ml.b()).addOnCompleteListener(zzo);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final void zzI(String string, long l2, TimeUnit timeUnit3, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks4, Activity activity5, Executor executor6, boolean z7, String string8, String string9) {
        int cmp;
        final Object obj = this;
        long l = l2;
        long convert = TimeUnit.SECONDS.convert(l2, timeUnit3);
        if (Long.compare(convert, i) < 0) {
        } else {
            if (Long.compare(convert, i2) > 0) {
            } else {
                super(string, convert, obj5, string8, obj.zzi, obj.zzk, string9, ml.b(), obj22);
                String str2 = string;
                obj.zze.w(obj.zza, hpVar, zzJ(string, activity5), executor6, z7);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        throw illegalArgumentException;
    }

    public final j<Void> zza(com.google.firebase.auth.FirebaseUser firebaseUser) {
        r.j(firebaseUser);
        zzi zzi = new zzi(this, firebaseUser);
        return this.zze.B(firebaseUser, zzi);
    }

    public final j<Void> zzb(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.MultiFactorAssertion multiFactorAssertion2, String string3) {
        r.j(firebaseUser);
        r.j(multiFactorAssertion2);
        if (multiFactorAssertion2 instanceof PhoneMultiFactorAssertion) {
            zzs zzs = new zzs(this);
            return this.zze.D(this.zza, (PhoneMultiFactorAssertion)multiFactorAssertion2, firebaseUser, string3, zzs);
        }
        Status obj8 = new Status(17499);
        return m.d(ql.a(obj8));
    }

    public final j<com.google.firebase.auth.GetTokenResult> zzc(com.google.firebase.auth.FirebaseUser firebaseUser, boolean z2) {
        if (firebaseUser == null) {
            Status obj4 = new Status(17495);
            return m.d(ql.a(obj4));
        }
        to toVar = firebaseUser.zzd();
        if (toVar.n2() && !z2) {
            if (!z2) {
                return m.e(zzay.zza(toVar.zze()));
            }
        }
        zzn zzn = new zzn(this);
        return this.zze.F(this.zza, firebaseUser, toVar.zzf(), zzn);
    }

    public final j<com.google.firebase.auth.AuthResult> zzd(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.AuthCredential authCredential2) {
        r.j(authCredential2);
        r.j(firebaseUser);
        zzt zzt = new zzt(this);
        return this.zze.G(this.zza, firebaseUser, authCredential2.zza(), zzt);
    }

    public final j<Void> zze(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.AuthCredential authCredential2) {
        r.j(firebaseUser);
        r.j(authCredential2);
        final com.google.firebase.auth.AuthCredential authCredential = authCredential2.zza();
        if (authCredential instanceof EmailAuthCredential && "password".equals((EmailAuthCredential)authCredential.getSignInMethod())) {
            if ("password".equals((EmailAuthCredential)authCredential.getSignInMethod())) {
                String str3 = authCredential.zze();
                r.f(str3);
                zzt zzt4 = new zzt(this);
                return this.zze.L(this.zza, firebaseUser, authCredential.zzd(), str3, firebaseUser.getTenantId(), zzt4);
            }
            String obj13 = authCredential.zzf();
            r.f(obj13);
            if (zzK(obj13)) {
                Status obj12 = new Status(17072);
                return m.d(ql.a(obj12));
            }
            zzt zzt = new zzt(this);
            return this.zze.J(this.zza, firebaseUser, authCredential, zzt);
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzt zzt3 = new zzt(this);
            return this.zze.N(this.zza, firebaseUser, (PhoneAuthCredential)authCredential, this.zzk, zzt3);
        }
        zzt zzt2 = new zzt(this);
        return this.zze.H(this.zza, firebaseUser, authCredential, firebaseUser.getTenantId(), zzt2);
    }

    public final j<com.google.firebase.auth.AuthResult> zzf(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.AuthCredential authCredential2) {
        r.j(firebaseUser);
        r.j(authCredential2);
        final com.google.firebase.auth.AuthCredential authCredential = authCredential2.zza();
        if (authCredential instanceof EmailAuthCredential && "password".equals((EmailAuthCredential)authCredential.getSignInMethod())) {
            if ("password".equals((EmailAuthCredential)authCredential.getSignInMethod())) {
                String str3 = authCredential.zze();
                r.f(str3);
                zzt zzt4 = new zzt(this);
                return this.zze.M(this.zza, firebaseUser, authCredential.zzd(), str3, firebaseUser.getTenantId(), zzt4);
            }
            String obj13 = authCredential.zzf();
            r.f(obj13);
            if (zzK(obj13)) {
                Status obj12 = new Status(17072);
                return m.d(ql.a(obj12));
            }
            zzt zzt = new zzt(this);
            return this.zze.K(this.zza, firebaseUser, authCredential, zzt);
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzt zzt3 = new zzt(this);
            return this.zze.O(this.zza, firebaseUser, (PhoneAuthCredential)authCredential, this.zzk, zzt3);
        }
        zzt zzt2 = new zzt(this);
        return this.zze.I(this.zza, firebaseUser, authCredential, firebaseUser.getTenantId(), zzt2);
    }

    public final j<Void> zzg(com.google.firebase.auth.FirebaseUser firebaseUser, zzbk zzbk2) {
        r.j(firebaseUser);
        return this.zze.P(this.zza, firebaseUser, zzbk2);
    }

    public final j<com.google.firebase.auth.AuthResult> zzh(com.google.firebase.auth.MultiFactorAssertion multiFactorAssertion, zzag zzag2, com.google.firebase.auth.FirebaseUser firebaseUser3) {
        r.j(multiFactorAssertion);
        r.j(zzag2);
        final String str = zzag2.zzd();
        r.f(str);
        zzs zzs = new zzs(this);
        return this.zze.E(this.zza, firebaseUser3, (PhoneMultiFactorAssertion)multiFactorAssertion, str, zzs);
    }

    public final j<Void> zzi(com.google.firebase.auth.ActionCodeSettings actionCodeSettings, String string2) {
        String zzi;
        com.google.firebase.auth.ActionCodeSettings obj3;
        r.f(string2);
        if (this.zzi != null && actionCodeSettings == null) {
            if (actionCodeSettings == null) {
                obj3 = ActionCodeSettings.zzb();
            }
            obj3.zzf(this.zzi);
        }
        return this.zze.Q(this.zza, obj3, string2);
    }

    public final j<com.google.firebase.auth.AuthResult> zzj(Activity activity, com.google.firebase.auth.FederatedAuthProvider federatedAuthProvider2, com.google.firebase.auth.FirebaseUser firebaseUser3) {
        r.j(activity);
        r.j(federatedAuthProvider2);
        r.j(firebaseUser3);
        k kVar = new k();
        if (!this.zzm.zzj(activity, kVar, this, firebaseUser3)) {
            Status obj4 = new Status(17057);
            return m.d(ql.a(obj4));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser3);
        federatedAuthProvider2.zza(activity);
        return kVar.a();
    }

    public final j<com.google.firebase.auth.AuthResult> zzk(Activity activity, com.google.firebase.auth.FederatedAuthProvider federatedAuthProvider2, com.google.firebase.auth.FirebaseUser firebaseUser3) {
        r.j(activity);
        r.j(federatedAuthProvider2);
        r.j(firebaseUser3);
        k kVar = new k();
        if (!this.zzm.zzj(activity, kVar, this, firebaseUser3)) {
            Status obj4 = new Status(17057);
            return m.d(ql.a(obj4));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser3);
        federatedAuthProvider2.zzb(activity);
        return kVar.a();
    }

    public final j<Void> zzl(com.google.firebase.auth.FirebaseUser firebaseUser, String string2) {
        r.j(firebaseUser);
        r.f(string2);
        zzt zzt = new zzt(this);
        zzr obj5 = new zzr(this);
        return this.zze.n(this.zza, firebaseUser, string2, zzt).continueWithTask(obj5);
    }

    public final j<com.google.firebase.auth.AuthResult> zzm(com.google.firebase.auth.FirebaseUser firebaseUser, String string2) {
        r.f(string2);
        r.j(firebaseUser);
        zzt zzt = new zzt(this);
        return this.zze.o(this.zza, firebaseUser, string2, zzt);
    }

    public final j<Void> zzn(com.google.firebase.auth.FirebaseUser firebaseUser, String string2) {
        r.j(firebaseUser);
        r.f(string2);
        zzt zzt = new zzt(this);
        return this.zze.p(this.zza, firebaseUser, string2, zzt);
    }

    public final j<Void> zzo(com.google.firebase.auth.FirebaseUser firebaseUser, String string2) {
        r.j(firebaseUser);
        r.f(string2);
        zzt zzt = new zzt(this);
        return this.zze.q(this.zza, firebaseUser, string2, zzt);
    }

    public final j<Void> zzp(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential2) {
        r.j(firebaseUser);
        r.j(phoneAuthCredential2);
        zzt zzt = new zzt(this);
        return this.zze.r(this.zza, firebaseUser, phoneAuthCredential2.zzb(), zzt);
    }

    public final j<Void> zzq(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.UserProfileChangeRequest userProfileChangeRequest2) {
        r.j(firebaseUser);
        r.j(userProfileChangeRequest2);
        zzt zzt = new zzt(this);
        return this.zze.s(this.zza, firebaseUser, userProfileChangeRequest2, zzt);
    }

    public final j<Void> zzr(String string, String string2, com.google.firebase.auth.ActionCodeSettings actionCodeSettings3) {
        com.google.firebase.auth.ActionCodeSettings obj4;
        r.f(string);
        r.f(string2);
        if (actionCodeSettings3 == null) {
            obj4 = ActionCodeSettings.zzb();
        }
        String zzi = this.zzi;
        if (zzi != null) {
            obj4.zzf(zzi);
        }
        return this.zze.t(string, string2, obj4);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public final zzbi zzw() {
        return FirebaseAuth.zzx(this);
        synchronized (this) {
            return FirebaseAuth.zzx(this);
        }
    }
}
