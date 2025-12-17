package com.google.android.play.core.assetpacks;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class j2 {
    static String a(List<File> list) {
        Object next;
        FileInputStream fileInputStream;
        int i;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        Iterator obj5 = list.iterator();
        for (File next : obj5) {
            fileInputStream = new FileInputStream(next);
            next = fileInputStream.read(bArr);
            do {
                next = fileInputStream.read(bArr);
                if (next != -1) {
                }
                instance.update(bArr, 0, next);
            } while (next > 0);
            if (next != -1) {
            }
            fileInputStream.close();
            instance.update(bArr, 0, next);
        }
        return Base64.encodeToString(instance.digest(), 11);
    }
}
