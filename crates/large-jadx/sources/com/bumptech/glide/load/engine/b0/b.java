package com.bumptech.glide.load.engine.b0;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class b {

    class a implements FilenameFilter {

        final Pattern a;
        a(Pattern pattern) {
            this.a = pattern;
            super();
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String string2) {
            return this.a.matcher(string2).matches();
        }
    }
    static int a() {
        int availableProcessors;
        int sDK_INT;
        if (Build.VERSION.SDK_INT < 17) {
            availableProcessors = Math.max(b.b(), Runtime.getRuntime().availableProcessors());
        }
        return availableProcessors;
    }

    private static int b() {
        File[] listFiles;
        int length;
        Throwable th;
        File file;
        int str;
        Pattern compile;
        String str3 = "GlideRuntimeCompat";
        file = new File("/sys/devices/system/cpu/");
        b.a aVar = new b.a(Pattern.compile("cpu[0-9]+"));
        listFiles = file.listFiles(aVar);
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
        if (listFiles != null) {
            length = listFiles.length;
        } else {
            try {
                length = 0;
                return Math.max(1, length);
                StrictMode.setThreadPolicy(obj1);
                throw str2;
            } catch (Throwable th) {
            }
        }
    }
}
