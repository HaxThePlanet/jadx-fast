package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class i3 {

    private static final Pattern a;
    static {
        i3.a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");
    }

    static List<File> a(File file, File file2) {
        int length2;
        File[] arr;
        int i;
        int exists;
        File fileInputStream;
        int file3;
        File length;
        File[] obj9;
        ArrayList arrayList = new ArrayList();
        obj9 = file2.listFiles(h3.a);
        int i2 = 0;
        if (obj9 == null) {
            obj9 = new File[i2];
        } else {
            length2 = obj9.length;
            arr = new File[length2];
            exists = i2;
            while (exists < length2) {
                fileInputStream = obj9[exists];
                file3 = Integer.parseInt(fileInputStream.getName().split("-")[i2]);
                arr[file3] = fileInputStream;
                exists++;
            }
            obj9 = arr;
        }
        i = i2;
        while (i < obj9.length) {
            exists = obj9[i];
            arrayList.add(exists);
            i++;
            fileInputStream = new FileInputStream(exists);
            r0 r0Var = new r0(fileInputStream);
            com.google.android.play.core.assetpacks.m3 m3Var = r0Var.c();
            file3 = new File(file, m3Var.c());
            arrayList.add(file3);
            fileInputStream.close();
        }
        return arrayList;
    }

    static boolean b(File file, String string2) {
        return i3.a.matcher(string2).matches();
    }
}
