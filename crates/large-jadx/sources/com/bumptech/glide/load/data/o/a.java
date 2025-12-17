package com.bumptech.glide.load.data.o;

import java.io.File;

/* loaded from: classes.dex */
class a {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String string) {
        File file = new File(string);
        return file;
    }

    public long c(File file) {
        return file.length();
    }
}
