package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public class FirebaseInitProvider extends ContentProvider {

    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseinitprovider";
    private static final String TAG = "FirebaseInitProvider";
    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        r.k(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseinitprovider".equals(providerInfo.authority)) {
        } else {
        }
        IllegalStateException obj1 = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        throw obj1;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo2) {
        FirebaseInitProvider.checkContentProviderAuthority(providerInfo2);
        super.attachInfo(context, providerInfo2);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String string2, String[] string3Arr3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String str;
        final String str2 = "FirebaseInitProvider";
        if (FirebaseApp.initializeApp(getContext()) == null) {
            Log.i(str2, "FirebaseApp initialization unsuccessful");
        } else {
            Log.i(str2, "FirebaseApp initialization successful");
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues2, String string3, String[] string4Arr4) {
        return 0;
    }
}
