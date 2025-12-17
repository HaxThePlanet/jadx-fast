package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.c;
import androidx.core.os.e;
import com.google.android.gms.common.g;
import com.google.android.gms.common.j;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.i;
import d.e.g;
import f.c.a.d.a.b;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class d0 {

    private static final g<String, String> a;
    private static Locale b;
    static {
        g gVar = new g();
        d0.a = gVar;
    }

    public static String a(Context context, int i2) {
        Resources resources = context.getResources();
        final int i4 = 0;
        final String str2 = "GoogleApiAvailability";
        switch (i2) {
            case 1:
                return resources.getString(b.f);
            case 2:
                return resources.getString(b.l);
            case 3:
                return resources.getString(b.c);
            case 4:
                return i4;
            case 5:
                Log.e(str2, "An invalid account was specified when connecting. Please provide a valid account.");
                return d0.i(context, "common_google_play_services_invalid_account_title");
            case 6:
                Log.e(str2, "Network error occurred. Please retry request later.");
                return d0.i(context, "common_google_play_services_network_error_title");
            case 7:
                Log.e(str2, "Internal error occurred. Please see logs for detailed information");
                return i4;
            case 8:
                Log.e(str2, "Google Play services is invalid. Cannot recover.");
                return i4;
            case 9:
                Log.e(str2, "Developer error occurred. Please see logs for detailed information");
                return i4;
            case 10:
                Log.e(str2, "The application is not licensed to the user.");
                return i4;
            case 11:
                StringBuilder obj3 = new StringBuilder(33);
                obj3.append("Unexpected error code ");
                obj3.append(i2);
                Log.e(str2, obj3.toString());
                return i4;
            case 12:
                Log.e(str2, "One of the API components you attempted to connect to is not available.");
                return i4;
            case 13:
                Log.e(str2, "The specified account could not be signed in.");
                return d0.i(context, "common_google_play_services_sign_in_failed_title");
            default:
                Log.e(str2, "The current user profile is restricted and could not use authenticated features.");
                return d0.i(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String b(Context context, int i2) {
        String obj2;
        if (i2 == 6) {
            obj2 = d0.i(context, "common_google_play_services_resolution_required_title");
        } else {
            obj2 = d0.a(context, i2);
        }
        if (obj2 == null) {
            return context.getResources().getString(b.h);
        }
        return obj2;
    }

    public static String c(Context context, int i2) {
        final Resources resources = context.getResources();
        final String str = d0.f(context);
        final int i = 0;
        final int i3 = 1;
        if (i2 != i3 && i2 != 2 && i2 != 3 && i2 != 5 && i2 != 7 && i2 != 9 && i2 != 20) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        if (i2 != 7) {
                            if (i2 != 9) {
                                if (i2 != 20) {
                                    switch (i2) {
                                        case 16:
                                            return d0.h(context, "common_google_play_services_api_unavailable_text", str);
                                        case 17:
                                            return d0.h(context, "common_google_play_services_sign_in_failed_text", str);
                                        case 18:
                                            Object[] obj6 = new Object[i3];
                                            obj6[i] = str;
                                            return resources.getString(b.m, obj6);
                                        default:
                                            obj6 = new Object[i3];
                                            obj6[i] = str;
                                            return resources.getString(j.a, obj6);
                                    }
                                }
                                return d0.h(context, "common_google_play_services_restricted_profile_text", str);
                            }
                            obj6 = new Object[i3];
                            obj6[i] = str;
                            return resources.getString(b.i, obj6);
                        }
                        return d0.h(context, "common_google_play_services_network_error_text", str);
                    }
                    return d0.h(context, "common_google_play_services_invalid_account_text", str);
                }
                obj6 = new Object[i3];
                obj6[i] = str;
                return resources.getString(b.b, obj6);
            }
            if (i.f(context)) {
                return resources.getString(b.n);
            }
            obj6 = new Object[i3];
            obj6[i] = str;
            return resources.getString(b.k, obj6);
        }
        obj6 = new Object[i3];
        obj6[i] = str;
        return resources.getString(b.e, obj6);
    }

    public static String d(Context context, int i2) {
        int i;
        if (i2 != 6 && i2 == 19) {
            if (i2 == 19) {
            }
            return d0.c(context, i2);
        }
        return d0.h(context, "common_google_play_services_resolution_required_text", d0.f(context));
    }

    public static String e(Context context, int i2) {
        Resources obj1 = context.getResources();
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return obj1.getString(17039370);
                }
                return obj1.getString(b.a);
            }
            return obj1.getString(b.j);
        }
        return obj1.getString(b.d);
    }

    public static String f(Context context) {
        return c.a(context).d(context.getPackageName()).toString();
    }

    public static String g(Context context) {
        return context.getResources().getString(b.g);
    }

    private static String h(Context context, String string2, String string3) {
        String obj2;
        Resources resources = context.getResources();
        if (d0.i(context, string2) == null) {
            obj2 = resources.getString(j.a);
        }
        Object[] arr = new Object[1];
        return String.format(obj3.locale, obj2, string3);
    }

    private static String i(Context context, String string2) {
        String obj5;
        final g gVar = d0.a;
        Locale locale = c.a(context.getResources().getConfiguration()).c(0);
        synchronized (gVar) {
            gVar.clear();
            d0.b = locale;
            Object obj = gVar.get(string2);
            if ((String)obj != null) {
                try {
                    return (String)obj;
                    Resources obj4 = g.e(context);
                    int i = 0;
                    if (obj4 == null) {
                    }
                    return i;
                    int identifier = obj4.getIdentifier(string2, "string", "com.google.android.gms");
                    if (identifier == 0) {
                    }
                    String str3 = "Missing resource: ";
                    if (string2.length() != 0) {
                    } else {
                    }
                    obj5 = str3.concat(string2);
                    obj5 = new String(str3);
                    Log.w("GoogleApiAvailability", obj5);
                    return i;
                    obj4 = obj4.getString(identifier);
                    if (TextUtils.isEmpty(obj4)) {
                    }
                    String str2 = "Got empty resource: ";
                    if (string2.length() != 0) {
                    } else {
                    }
                    obj5 = str2.concat(string2);
                    obj5 = new String(str2);
                    Log.w("GoogleApiAvailability", obj5);
                    return i;
                    gVar.put(string2, obj4);
                    return obj4;
                    throw context;
                }
            }
        }
    }
}
