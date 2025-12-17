package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o6 implements com.google.android.gms.internal.measurement.e7 {

    public final Context a;
    public o6(Context context) {
        super();
        this.a = context;
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        com.google.android.gms.internal.measurement.b7 b7Var;
        Context deviceProtectedStorageContext;
        String allowThreadDiskReads;
        boolean deviceProtectedStorage;
        String tAGS;
        boolean bufferedReader;
        File file;
        Object hashMap2;
        StringBuilder stringBuilder;
        String decode2;
        Object str;
        String[] length;
        boolean hashMap;
        String string;
        int length2;
        Object decode;
        int i;
        String str3 = "HermeticFileOverrides";
        deviceProtectedStorageContext = this.a;
        int i2 = w6.j;
        allowThreadDiskReads = Build.TYPE;
        tAGS = Build.TAGS;
        if (!allowThreadDiskReads.equals("eng") && !allowThreadDiskReads.equals("userdebug")) {
            if (!allowThreadDiskReads.equals("userdebug")) {
                b7Var = b7.c();
            } else {
                if (!tAGS.contains("dev-keys")) {
                    if (tAGS.contains("test-keys")) {
                        if (x5.a() && deviceProtectedStorageContext.isDeviceProtectedStorage() == null) {
                            if (deviceProtectedStorageContext.isDeviceProtectedStorage() == null) {
                                deviceProtectedStorageContext = deviceProtectedStorageContext.createDeviceProtectedStorageContext();
                            }
                        }
                        StrictMode.allowThreadDiskWrites();
                        tAGS = 0;
                        file = new File(deviceProtectedStorageContext.getDir("phenotype_hermetic", tAGS), "overrides.txt");
                        if (file.exists() != null) {
                            deviceProtectedStorageContext = b7.d(file);
                        } else {
                            deviceProtectedStorageContext = b7.c();
                        }
                        if (deviceProtectedStorageContext.b() != null) {
                            Object obj = deviceProtectedStorageContext.a();
                            FileInputStream fileInputStream = new FileInputStream((File)obj);
                            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                            bufferedReader = new BufferedReader(inputStreamReader);
                            hashMap2 = new HashMap();
                            HashMap hashMap3 = new HashMap();
                            decode2 = bufferedReader.readLine();
                            while (decode2 != null) {
                                int i5 = 3;
                                length = decode2.split(" ", i5);
                                if (length.length != i5) {
                                } else {
                                }
                                string = new String(length[tAGS]);
                                String string3 = new String(length[1]);
                                length2 = 2;
                                if ((String)hashMap3.get(length[length2]) == null) {
                                }
                                if (!hashMap2.containsKey(string)) {
                                }
                                (Map)hashMap2.get(string).put(Uri.decode(string3), decode);
                                decode2 = bufferedReader.readLine();
                                hashMap = new HashMap();
                                hashMap2.put(string, hashMap);
                                length2 = new String(length[length2]);
                                decode = Uri.decode(length2);
                                if (decode.length() >= 1024) {
                                } else {
                                }
                                hashMap3.put(length2, decode);
                                if (decode == length2) {
                                }
                                str = "Invalid: ";
                                if (decode2.length() != 0) {
                                } else {
                                }
                                decode2 = new String(str);
                                Log.e(str3, decode2);
                                decode2 = str.concat(decode2);
                            }
                            String string2 = obj.toString();
                            stringBuilder = new StringBuilder(length3 += 7);
                            stringBuilder.append("Parsed ");
                            stringBuilder.append(string2);
                            Log.i(str3, stringBuilder.toString());
                            k6 k6Var = new k6(hashMap2);
                            bufferedReader.close();
                            b7Var = b7.d(k6Var);
                        } else {
                            b7Var = b7.c();
                        }
                        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        return b7Var;
    }
}
