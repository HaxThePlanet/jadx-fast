package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.l.a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PhoneAuthProvider {

    public static final String PHONE_SIGN_IN_METHOD = "phone";
    public static final String PROVIDER_ID = "phone";
    private com.google.firebase.auth.FirebaseAuth zza;

    public static abstract class OnVerificationStateChangedCallbacks {

        private static final a zza;
        static {
            a aVar = new a("PhoneAuthProvider", new String[0]);
            PhoneAuthProvider.OnVerificationStateChangedCallbacks.zza = aVar;
        }

        public void onCodeAutoRetrievalTimeOut(String string) {
            PhoneAuthProvider.OnVerificationStateChangedCallbacks.zza.e("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(String string, com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken2) {
        }

        public abstract void onVerificationCompleted(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(FirebaseException firebaseException);
    }

    public static class ForceResendingToken extends a {

        public static final Parcelable.Creator<com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken> CREATOR;
        static {
            zzd zzd = new zzd();
            PhoneAuthProvider.ForceResendingToken.CREATOR = zzd;
        }

        public static com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken zza() {
            PhoneAuthProvider.ForceResendingToken forceResendingToken = new PhoneAuthProvider.ForceResendingToken();
            return forceResendingToken;
        }

        @Override // com.google.android.gms.common.internal.safeparcel.a
        public final void writeToParcel(Parcel parcel, int i2) {
            b.b(parcel, b.a(parcel));
        }
    }
    private PhoneAuthProvider(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        super();
        this.zza = firebaseAuth;
    }

    public static com.google.firebase.auth.PhoneAuthCredential getCredential(String string, String string2) {
        return PhoneAuthCredential.zzc(string, string2);
    }

    @Deprecated
    public static com.google.firebase.auth.PhoneAuthProvider getInstance() {
        PhoneAuthProvider phoneAuthProvider = new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
        return phoneAuthProvider;
    }

    @Deprecated
    public static com.google.firebase.auth.PhoneAuthProvider getInstance(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        PhoneAuthProvider phoneAuthProvider = new PhoneAuthProvider(firebaseAuth);
        return phoneAuthProvider;
    }

    public static void verifyPhoneNumber(com.google.firebase.auth.PhoneAuthOptions phoneAuthOptions) {
        r.j(phoneAuthOptions);
        phoneAuthOptions.zzb().zzH(phoneAuthOptions);
    }

    @Deprecated
    public void verifyPhoneNumber(String string, long l2, TimeUnit timeUnit3, Activity activity4, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks5) {
        com.google.firebase.auth.PhoneAuthOptions.Builder builder = PhoneAuthOptions.newBuilder(this.zza);
        builder.setPhoneNumber(string);
        builder.setTimeout(Long.valueOf(l2), activity4);
        builder.setActivity(onVerificationStateChangedCallbacks5);
        builder.setCallbacks(obj7);
        PhoneAuthProvider.verifyPhoneNumber(builder.build());
    }

    @Deprecated
    public void verifyPhoneNumber(String string, long l2, TimeUnit timeUnit3, Activity activity4, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks5, com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken6) {
        com.google.firebase.auth.PhoneAuthOptions.Builder builder = PhoneAuthOptions.newBuilder(this.zza);
        builder.setPhoneNumber(string);
        builder.setTimeout(Long.valueOf(l2), activity4);
        builder.setActivity(onVerificationStateChangedCallbacks5);
        builder.setCallbacks(forceResendingToken6);
        if (obj8 != null) {
            builder.setForceResendingToken(obj8);
        }
        PhoneAuthProvider.verifyPhoneNumber(builder.build());
    }
}
