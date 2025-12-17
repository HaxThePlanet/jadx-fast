package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class u3 {

    private final Context a;
    public u3(Context context) {
        super();
        this.a = context;
    }

    static String b(Context context) {
        Bundle obj3 = obj3.metaData;
        if (obj3 == null) {
            try {
                return null;
                return obj3.getString("local_testing_dir");
                return obj0;
            }
        }
    }

    final Context a() {
        return this.a;
    }
}
