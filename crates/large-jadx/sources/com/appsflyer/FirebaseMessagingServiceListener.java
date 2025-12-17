package com.appsflyer;

import android.content.Context;
import com.appsflyer.internal.bv;
import com.google.firebase.messaging.FirebaseMessagingService;

/* loaded from: classes.dex */
public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String string) {
        bv bvVar = new bv(getApplicationContext());
        bvVar.valueOf(string);
    }
}
