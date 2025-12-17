package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase-auth-api.fp;
import com.google.android.gms.internal.firebase-auth-api.im;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* loaded from: classes2.dex */
public final class zzo implements ActionCodeResult {

    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd = null;
    public zzo(fp fp) {
        String str;
        int i;
        boolean z;
        String equals;
        int zzm;
        String str2;
        int i2;
        Object obj10;
        super();
        if (fp.zzh()) {
            str = fp.zzd();
        } else {
            str = fp.zzc();
        }
        this.zzb = str;
        this.zzc = fp.zzc();
        final int i3 = 3;
        if (!fp.zzi()) {
            this.zza = i3;
        }
        final int i4 = 5;
        final int i5 = 2;
        final int i6 = 1;
        final int i7 = 4;
        switch (equals) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i = i4;
                i = -1;
                break;
            case "PASSWORD_RESET":
                i = i2;
                i = -1;
                break;
            case "VERIFY_EMAIL":
                i = i6;
                i = -1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i = i3;
                i = -1;
                break;
            case "EMAIL_SIGNIN":
                i = i5;
                i = -1;
                break;
            case "RECOVER_EMAIL":
                i = i7;
                i = -1;
                break;
            default:
                i = -1;
        }
        if (i != 0) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i3) {
                        if (i != i7) {
                            i2 = i != i4 ? i3 : 6;
                        } else {
                            i2 = i5;
                        }
                    } else {
                        i2 = i4;
                    }
                } else {
                    i2 = i7;
                }
            } else {
                i2 = i6;
            }
        }
        this.zza = i2;
        if (i2 != i7) {
            if (i2 == i3) {
            } else {
                if (fp.zzg()) {
                    zzm = new zzn(fp.zzc(), zzba.zza(fp.j2()));
                } else {
                    if (fp.zzh()) {
                        zzm = new zzl(fp.zzd(), fp.zzc());
                    } else {
                        if (fp.k2()) {
                            zzm = new zzm(fp.zzc());
                        }
                    }
                }
            }
            this.zzd = zzm;
        }
        this.zzd = 0;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        final int i3 = 0;
        if (this.zza == 4) {
            return i3;
        }
        if (i != 0 && i != 1) {
            if (i != 1) {
                return i3;
            }
            return this.zzc;
        }
        return this.zzb;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }
}
