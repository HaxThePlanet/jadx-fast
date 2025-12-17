package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.h;

/* loaded from: classes2.dex */
public final class zzb {

    private SharedPreferences zzs = null;
    public zzb(Context context) {
        String str;
        int str2;
        int obj4;
        super();
        obj4 = h.d(context);
        if (obj4 == null) {
            obj4 = i;
        } else {
            obj4 = obj4.getSharedPreferences("google_ads_flags", 0);
        }
        this.zzs = obj4;
    }

    public final boolean getBoolean(String string, boolean z2) {
        final int obj4 = 0;
        final SharedPreferences zzs = this.zzs;
        if (zzs == null) {
            try {
                return obj4;
                return zzs.getBoolean(string, obj4);
                Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", string);
                return z2;
            }
        }
    }

    final float getFloat(String string, float f2) {
        final int obj4 = 0;
        final SharedPreferences zzs = this.zzs;
        if (zzs == null) {
            try {
                return obj4;
                return zzs.getFloat(string, obj4);
                Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", string);
                return f2;
            }
        }
    }

    final String getString(String string, String string2) {
        try {
            final SharedPreferences zzs = this.zzs;
            if (zzs == null) {
            }
            return string2;
            return zzs.getString(string, string2);
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", string);
            return string2;
        }
    }
}
