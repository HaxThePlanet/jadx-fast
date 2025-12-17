package com.google.firebase.storage.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Util {

    public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
    public static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageUtil";
    public static boolean equals(Object object, Object object2) {
        return p.a(object, object2);
    }

    public static String getCurrentAppCheckToken(InternalAppCheckTokenProvider internalAppCheckTokenProvider) {
        Object string;
        long error;
        if (internalAppCheckTokenProvider == null) {
            return null;
        }
        Object obj5 = m.b(internalAppCheckTokenProvider.getToken(false), 30000, error);
        if ((AppCheckTokenResult)obj5.getError() != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error getting App Check token; using placeholder token instead. Error: ");
            stringBuilder2.append(obj5.getError());
            Log.w("StorageUtil", stringBuilder2.toString());
        }
        return obj5.getToken();
    }

    public static String getCurrentAuthToken(InternalAuthProvider internalAuthProvider) {
        int stringBuilder;
        boolean empty;
        long str;
        TimeUnit mILLISECONDS;
        String obj5;
        final int i = 0;
        if (internalAuthProvider != null) {
            obj5 = (GetTokenResult)m.b(internalAuthProvider.getAccessToken(false), 30000, str).getToken();
        } else {
            obj5 = i;
        }
        if (!TextUtils.isEmpty(obj5)) {
            return obj5;
        }
        Log.w("StorageUtil", "no auth token for request");
        return i;
    }

    public static Uri normalize(FirebaseApp firebaseApp, String string2) {
        String slashize;
        boolean equals;
        int indexOf2;
        String str;
        int indexOf;
        String str2;
        boolean startsWith;
        String obj6;
        String obj7;
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        String str3 = "gs://";
        if (string2.toLowerCase().startsWith(str3)) {
            obj7 = new StringBuilder();
            obj7.append(str3);
            obj7.append(Slashes.preserveSlashEncode(Slashes.normalizeSlashes(string2.substring(5))));
            return Uri.parse(obj7.toString());
        }
        obj7 = Uri.parse(string2);
        String scheme = obj7.getScheme();
        String str4 = "StorageUtil";
        if (scheme == null) {
        } else {
            if (!Util.equals(scheme.toLowerCase(), "http") && Util.equals(scheme.toLowerCase(), "https")) {
                if (!Util.equals(scheme.toLowerCase(), "https")) {
                } else {
                    obj6 = obj7.getAuthority().toLowerCase().indexOf(NetworkRequest.PROD_BASE_URL.getAuthority());
                    slashize = Slashes.slashize(obj7.getEncodedPath());
                    indexOf2 = 0;
                    String str6 = "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().";
                    str2 = "/";
                    if (obj6 == null && slashize.startsWith(str2)) {
                        str2 = "/";
                        if (slashize.startsWith(str2)) {
                            obj6 = slashize.indexOf("/b/", indexOf2);
                            obj7 = obj6 + 3;
                            indexOf = slashize.indexOf(str2, obj7);
                            indexOf2 = slashize.indexOf("/o/", indexOf2);
                            startsWith = -1;
                            if (obj6 == startsWith) {
                            } else {
                                if (indexOf == startsWith) {
                                } else {
                                    obj6 = slashize.substring(obj7, indexOf);
                                    if (indexOf2 != startsWith) {
                                        obj7 = slashize.substring(indexOf2 += 3);
                                    } else {
                                        obj7 = "";
                                    }
                                    slashize = obj7;
                                    r.g(obj6, "No bucket specified");
                                    obj7 = new Uri.Builder();
                                    return obj7.scheme("gs").authority(obj6).encodedPath(slashize).build();
                                }
                            }
                            Log.w(str4, str6);
                            obj6 = new IllegalArgumentException(str6);
                            throw obj6;
                        }
                    }
                    indexOf = 1;
                    if (obj6 <= indexOf) {
                    } else {
                        obj6 = obj7.getAuthority().substring(indexOf2, obj6 -= indexOf);
                    }
                }
            } else {
            }
            Log.w(str4, str6);
            obj6 = new IllegalArgumentException(str6);
            throw obj6;
        }
        obj6 = new StringBuilder();
        obj6.append("FirebaseStorage is unable to support the scheme:");
        obj6.append(scheme);
        Log.w(str4, obj6.toString());
        obj6 = new IllegalArgumentException("Uri scheme");
        throw obj6;
    }

    public static long parseDateTime(String string) {
        if (string == null) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        return simpleDateFormat.parse(string.replaceAll("Z$", "-0000")).getTime();
    }
}
