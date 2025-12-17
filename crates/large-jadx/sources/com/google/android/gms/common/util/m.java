package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.r;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: classes2.dex */
public class m {

    private static String a;
    private static int b;
    static {
    }

    public static String a() {
        String line;
        int myPid;
        java.io.Closeable trim;
        android.os.StrictMode.ThreadPolicy allowThreadDiskReads;
        Object bufferedReader;
        FileReader fileReader;
        if (m.a == null && m.b == 0) {
            if (m.b == 0) {
                m.b = Process.myPid();
            }
            line = m.b;
            trim = 0;
            if (line <= 0) {
            } else {
                StringBuilder stringBuilder = new StringBuilder(25);
                stringBuilder.append("/proc/");
                stringBuilder.append(line);
                stringBuilder.append("/cmdline");
                fileReader = new FileReader(stringBuilder.toString());
                bufferedReader = new BufferedReader(fileReader);
                StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
                line = bufferedReader.readLine();
                r.j(line);
                trim = line.trim();
                k.a(bufferedReader);
            }
            m.a = trim;
        }
        return m.a;
    }
}
