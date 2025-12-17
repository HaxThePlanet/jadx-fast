package com.google.android.gms.common;

import android.content.Intent;

/* loaded from: classes2.dex */
public class UserRecoverableException extends Exception {

    private final Intent zza;
    public UserRecoverableException(String string, Intent intent2) {
        super(string);
        this.zza = intent2;
    }
}
