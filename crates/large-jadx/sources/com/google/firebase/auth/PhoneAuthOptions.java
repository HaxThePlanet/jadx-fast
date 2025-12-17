package com.google.firebase.auth;

import android.app.Activity;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.l;
import com.google.firebase.auth.internal.zzag;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class PhoneAuthOptions {

    private final com.google.firebase.auth.FirebaseAuth zza;
    private Long zzb;
    private com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc;
    private Executor zzd;
    private String zze;
    private Activity zzf;
    private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken zzg;
    private com.google.firebase.auth.MultiFactorSession zzh;
    private com.google.firebase.auth.PhoneMultiFactorInfo zzi;
    private boolean zzj;

    public static final class Builder {

        private final com.google.firebase.auth.FirebaseAuth zza;
        private String zzb;
        private Long zzc;
        private com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
        private Executor zze;
        private Activity zzf;
        private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken zzg;
        private com.google.firebase.auth.MultiFactorSession zzh;
        private com.google.firebase.auth.PhoneMultiFactorInfo zzi;
        private boolean zzj;
        public Builder(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
            super();
            r.j(firebaseAuth);
            this.zza = (FirebaseAuth)firebaseAuth;
        }

        public com.google.firebase.auth.PhoneAuthOptions build() {
            int cmp;
            int i2;
            Object zzi;
            int i3;
            int i;
            String str;
            r.k(this.zza, "FirebaseAuth instance cannot be null");
            r.k(this.zzc, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            r.k(this.zzd, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            r.k(this.zzf, "You must specify an Activity on your PhoneAuthOptions. Please call #setActivity()");
            this.zze = l.a;
            if (Long.compare(longValue, i3) < 0) {
            } else {
                if (Long.compare(longValue2, i3) > 0) {
                } else {
                    com.google.firebase.auth.MultiFactorSession zzh = this.zzh;
                    String str7 = "A phoneMultiFactorInfo must be set for second factor sign-in.";
                    int i5 = 1;
                    if (zzh == null) {
                        r.g(this.zzb, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                        r.b(zzj ^= i5, "You cannot require sms validation without setting a multi-factor session.");
                        if (this.zzi == null) {
                            i = i5;
                        }
                        r.b(i, str7);
                    } else {
                        if ((zzag)zzh.zze()) {
                            r.f(this.zzb);
                            if (this.zzi == null) {
                                i = i5;
                            }
                            r.b(i, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
                        } else {
                            i2 = this.zzi != null ? i5 : i;
                            r.b(i2, str7);
                            if (this.zzb == null) {
                                i = i5;
                            }
                            r.b(i, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
                        }
                    }
                    super(this.zza, this.zzc, this.zzd, this.zze, this.zzb, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, 0);
                    return phoneAuthOptions;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            throw illegalArgumentException;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder requireSmsValidation(boolean z) {
            this.zzj = z;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setActivity(Activity activity) {
            this.zzf = activity;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setCallbacks(com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks) {
            this.zzd = onVerificationStateChangedCallbacks;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setForceResendingToken(com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken) {
            this.zzg = forceResendingToken;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setMultiFactorHint(com.google.firebase.auth.PhoneMultiFactorInfo phoneMultiFactorInfo) {
            this.zzi = phoneMultiFactorInfo;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setMultiFactorSession(com.google.firebase.auth.MultiFactorSession multiFactorSession) {
            this.zzh = multiFactorSession;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setPhoneNumber(String string) {
            this.zzb = string;
            return this;
        }

        public com.google.firebase.auth.PhoneAuthOptions.Builder setTimeout(Long long, TimeUnit timeUnit2) {
            this.zzc = Long.valueOf(TimeUnit.SECONDS.convert(long.longValue(), obj2));
            return this;
        }
    }
    PhoneAuthOptions(com.google.firebase.auth.FirebaseAuth firebaseAuth, Long long2, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks3, Executor executor4, String string5, Activity activity6, com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken7, com.google.firebase.auth.MultiFactorSession multiFactorSession8, com.google.firebase.auth.PhoneMultiFactorInfo phoneMultiFactorInfo9, boolean z10, com.google.firebase.auth.zzad zzad11) {
        super();
        this.zza = firebaseAuth;
        this.zze = string5;
        this.zzb = long2;
        this.zzc = onVerificationStateChangedCallbacks3;
        this.zzf = activity6;
        this.zzd = executor4;
        this.zzg = forceResendingToken7;
        this.zzh = multiFactorSession8;
        this.zzi = phoneMultiFactorInfo9;
        this.zzj = z10;
    }

    public static com.google.firebase.auth.PhoneAuthOptions.Builder newBuilder() {
        PhoneAuthOptions.Builder builder = new PhoneAuthOptions.Builder(FirebaseAuth.getInstance());
        return builder;
    }

    public static com.google.firebase.auth.PhoneAuthOptions.Builder newBuilder(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        PhoneAuthOptions.Builder builder = new PhoneAuthOptions.Builder(firebaseAuth);
        return builder;
    }

    public final Activity zza() {
        return this.zzf;
    }

    public final com.google.firebase.auth.FirebaseAuth zzb() {
        return this.zza;
    }

    public final com.google.firebase.auth.MultiFactorSession zzc() {
        return this.zzh;
    }

    public final com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken zzd() {
        return this.zzg;
    }

    public final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zze() {
        return this.zzc;
    }

    public final com.google.firebase.auth.PhoneMultiFactorInfo zzf() {
        return this.zzi;
    }

    public final Long zzg() {
        return this.zzb;
    }

    public final String zzh() {
        return this.zze;
    }

    public final Executor zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        if (this.zzh != null) {
            return 1;
        }
        return 0;
    }
}
