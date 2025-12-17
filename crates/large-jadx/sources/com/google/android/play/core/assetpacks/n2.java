package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
final class n2 {

    private static final h b;
    private final com.google.android.play.core.assetpacks.f0 a;
    static {
        h hVar = new h("MergeSliceTaskHandler");
        n2.b = hVar;
    }

    n2(com.google.android.play.core.assetpacks.f0 f0) {
        super();
        this.a = f0;
    }

    private static void b(File file, File file2) {
        boolean listFiles;
        int length;
        int i;
        File file4;
        File file3;
        String name;
        boolean obj7;
        if (file.isDirectory() != null) {
            file2.mkdirs();
            listFiles = file.listFiles();
            i = 0;
            while (i < listFiles.length) {
                file4 = listFiles[i];
                file3 = new File(file2, file4.getName());
                n2.b(file4, file3);
                i++;
            }
            if (file.delete() == null) {
            } else {
            }
            String obj6 = String.valueOf(file);
            StringBuilder stringBuilder3 = new StringBuilder(length4 += 28);
            stringBuilder3.append("Unable to delete directory: ");
            stringBuilder3.append(obj6);
            obj7 = new g1(stringBuilder3.toString());
            throw obj7;
        }
        if (file2.exists() != null) {
        } else {
            if (file.renameTo(file2) == null) {
            } else {
            }
            obj6 = String.valueOf(file);
            StringBuilder stringBuilder2 = new StringBuilder(length3 += 21);
            stringBuilder2.append("Unable to move file: ");
            stringBuilder2.append(obj6);
            obj7 = new g1(stringBuilder2.toString());
            throw obj7;
        }
        obj7 = String.valueOf(file2);
        StringBuilder stringBuilder = new StringBuilder(length2 += 51);
        stringBuilder.append("File clashing with existing file from other slice: ");
        stringBuilder.append(obj7);
        obj6 = new g1(stringBuilder.toString());
        throw obj6;
    }

    public final void a(com.google.android.play.core.assetpacks.m2 m2) {
        File file = this.a.D(m2.b, m2.c, m2.d, message);
        if (file.exists() == null) {
        } else {
            long l3 = m2.d;
            File file2 = this.a.w(m2.b, m2.c, l3);
            if (file2.exists() == null) {
                file2.mkdirs();
            }
            n2.b(file, file2);
            this.a.a(m2.b, m2.c, m2.d, obj8);
        }
        Object[] arr = new Object[1];
        g1 g1Var = new g1(String.format("Cannot find verified files for slice %s.", m2.e), m2.a);
        throw g1Var;
    }
}
