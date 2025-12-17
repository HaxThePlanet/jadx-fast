package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class PackageInfoCompat {

    private static class Api28Impl {
        static Signature[] getApkContentsSigners(SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        static long getLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        static Signature[] getSigningCertificateHistory(SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        static boolean hasMultipleSigners(SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        static boolean hasSigningCertificate(PackageManager packageManager, String packageName, byte[] bytes, int type) {
            return packageManager.hasSigningCertificate(packageName, bytes, type);
        }
    }
    private static boolean byteArrayContains(byte[][] array, byte[] expected) {
        int i;
        Object obj;
        boolean equals;
        final int i3 = 0;
        i = i3;
        while (i < array.length) {
            i++;
        }
        return i3;
    }

    private static byte[] computeSHA256Digest(byte[] bytes) {
        try {
            return MessageDigest.getInstance("SHA256").digest(bytes);
            RuntimeException runtimeException = new RuntimeException("Device doesn't support SHA256 cert checking", th);
            throw runtimeException;
        }
    }

    public static long getLongVersionCode(PackageInfo info) {
        return PackageInfoCompat.Api28Impl.getLongVersionCode(info);
    }

    public static List<Signature> getSignatures(PackageManager packageManager, String packageName) throws PackageManager.NameNotFoundException {
        Signature[] signingCertificateHistory;
        final SigningInfo signingInfo = packageInfo.signingInfo;
        if (PackageInfoCompat.Api28Impl.hasMultipleSigners(signingInfo)) {
            signingCertificateHistory = PackageInfoCompat.Api28Impl.getApkContentsSigners(signingInfo);
        } else {
            signingCertificateHistory = PackageInfoCompat.Api28Impl.getSigningCertificateHistory(signingInfo);
        }
        if (signingCertificateHistory == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(signingCertificateHistory);
    }

    public static boolean hasSignatures(PackageManager packageManager, String packageName, Map<byte[], Integer> map3, boolean matchExact) throws PackageManager.NameNotFoundException {
        Object next;
        String str;
        boolean byteArrayContains;
        Object next2;
        int size;
        int intValue;
        int sha256Digests;
        boolean index;
        byte[] sHA256Digest;
        int intValue2;
        int i = 0;
        if (map3.isEmpty()) {
            return i;
        }
        Set keySet = map3.keySet();
        Iterator iterator = keySet.iterator();
        str = "Unsupported certificate type ";
        for (byte[] next : iterator) {
            next2 = map3.get(next);
            str = "Unsupported certificate type ";
        }
        List signatures = PackageInfoCompat.getSignatures(packageManager, packageName);
        int i2 = 1;
        if (!matchExact) {
            Iterator iterator2 = keySet.iterator();
            for (byte[] next2 : iterator2) {
            }
            return i2;
        }
        if (signatures.size() != 0 && map3.size() <= signatures.size()) {
            if (map3.size() <= signatures.size()) {
                if (matchExact && map3.size() != signatures.size()) {
                    if (map3.size() != signatures.size()) {
                    } else {
                        sha256Digests = 0;
                        if (map3.containsValue(Integer.valueOf(i2))) {
                            index = 0;
                            while (index < signatures.size()) {
                                new byte[signatures.size()][index] = PackageInfoCompat.computeSHA256Digest((Signature)signatures.get(index).toByteArray());
                                index++;
                            }
                        }
                        Iterator iterator3 = keySet.iterator();
                        if (iterator3.hasNext()) {
                            Object next5 = iterator3.next();
                            Object obj2 = map3.get((byte[])next5);
                            switch (intValue2) {
                                case 0:
                                    byteArrayContains = new Signature(next5);
                                    return i;
                                case 1:
                                    return i;
                                default:
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder4.append(str).append(obj2).toString());
                                    throw illegalArgumentException;
                            }
                            return i2;
                        }
                    }
                } else {
                }
                return i;
            }
        }
        return i;
    }
}
