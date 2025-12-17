package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class v1 {

    private static final Uri a;
    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        v1.a = parse;
        parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent a(String string) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", "com.google.android.gms", 0));
        return intent;
    }

    public static Intent b(String string, String string2) {
        boolean empty;
        Intent obj3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", string2);
        }
        obj3.setData(appendQueryParameter.build());
        obj3.setPackage("com.android.vending");
        obj3.addFlags(524288);
        return obj3;
    }

    public static Intent c() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
