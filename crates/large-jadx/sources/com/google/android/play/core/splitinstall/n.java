package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.internal.r1;
import java.io.File;

/* loaded from: classes2.dex */
public final class n implements r1<File> {

    private final r1<Context> a;
    public n(r1<Context> r1) {
        super();
        this.a = r1;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Object metaData;
        String packageName;
        Context context = (l)this.a.a();
        final int i = 0;
        metaData = applicationInfo.metaData;
        if (metaData == null) {
        } else {
            metaData = metaData.getString("local_testing_dir");
            if (metaData != null) {
                File file = new File(context.getExternalFilesDir(i), metaData);
                return file;
            }
        }
        return i;
    }
}
