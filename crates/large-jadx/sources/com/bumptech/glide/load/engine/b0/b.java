package com.bumptech.glide.load.engine.b0;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
final class b {

    class a implements FilenameFilter {

        final /* synthetic */ Pattern a;
        a(Pattern pattern) {
            this.a = pattern;
            super();
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }
    static int a() {
        int availableProcessors;
        if (Build.VERSION.SDK_INT < 17) {
            availableProcessors = Math.max(b.b(), Runtime.getRuntime().availableProcessors());
        }
        return availableProcessors;
    }

    private static int b() {
        File[] listFiles;
        int length = 0;
        int str3;
        try {
            listFiles = new File("/sys/devices/system/cpu/").listFiles(new b.a(Pattern.compile("cpu[0-9]+")));
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskReads());
        String str = listFiles != null ? listFiles.length : 0;
        return (listFiles != null ? listFiles.length : 0);
    }
}
