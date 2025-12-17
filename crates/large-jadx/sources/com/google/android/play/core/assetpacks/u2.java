package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/* loaded from: classes2.dex */
final class u2 {

    private static final h d;
    private final com.google.android.play.core.assetpacks.f0 a;
    private final com.google.android.play.core.assetpacks.w2 b;
    private final c c;
    static {
        h hVar = new h("PackMetadataManager");
        u2.d = hVar;
    }

    u2(com.google.android.play.core.assetpacks.f0 f0, com.google.android.play.core.assetpacks.w2 w22, c c3) {
        super();
        this.a = f0;
        this.b = w22;
        this.c = c3;
    }

    final String a(String string) {
        boolean z;
        int arr;
        Object property;
        int i;
        String exists;
        String obj6;
        if (this.c.a("assetOnlyUpdates")) {
            if (!this.a.f(string)) {
            } else {
                int i2 = this.b.a();
                com.google.android.play.core.assetpacks.f0 f0Var2 = this.a;
                property = f0Var2.x(string, i2, f0Var2.r(string));
                if (!property.exists()) {
                    obj6 = String.valueOf(i2);
                } else {
                    FileInputStream fileInputStream = new FileInputStream(property);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    property = properties.getProperty("moduleVersionTag");
                    if (property == null) {
                        obj6 = String.valueOf(i2);
                    } else {
                        obj6 = property;
                    }
                }
            }
            return obj6;
        }
        return "";
    }

    final void b(String string, int i2, long l3, String string4) {
        boolean empty;
        String obj7;
        if (obj7 != null) {
            if (obj7.isEmpty()) {
                obj7 = String.valueOf(i2);
            }
        } else {
        }
        Properties properties = new Properties();
        properties.put("moduleVersionTag", obj7);
        File obj3 = this.a.x(string, i2, l3);
        obj3.getParentFile().mkdirs();
        obj3.createNewFile();
        obj7 = new FileOutputStream(obj3);
        properties.store(obj7, 0);
        obj7.close();
    }
}
