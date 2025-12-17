package d.l.a;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import java.io.Closeable;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
class b {

    static class a {
        static void a(FileDescriptor fileDescriptor) {
            Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long l2, int i3) {
            return Os.lseek(fileDescriptor, l2, i3);
        }
    }

    static class b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource2) {
            mediaMetadataRetriever.setDataSource(mediaDataSource2);
        }
    }
    static String a(byte[] bArr) {
        int i;
        String format;
        String str;
        StringBuilder stringBuilder = new StringBuilder(length *= 2);
        int i3 = 0;
        i = i3;
        for (byte b : bArr) {
            Object[] arr = new Object[1];
            arr[i3] = Byte.valueOf(b);
            stringBuilder.append(String.format("%02x", arr));
        }
        return stringBuilder.toString();
    }

    static void b(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
    }

    static long[] c(Object object) {
        int i;
        long l;
        if (object instanceof int[]) {
            long[] lArr = new long[object.length];
            i = 0;
            for (int i2 : object) {
                lArr[i] = (long)i2;
            }
            return lArr;
        }
        if (object instanceof long[]) {
            return (long[])(int[])object;
        }
        return null;
    }

    static boolean d(byte[] bArr, byte[] b2Arr2) {
        int i;
        int length;
        byte b;
        final int i2 = 0;
        if (bArr != null) {
            if (b2Arr2 == null) {
            } else {
                if (bArr.length < b2Arr2.length) {
                    return i2;
                }
                i = i2;
                for (byte b : b2Arr2) {
                }
            }
            return 1;
        }
        return i2;
    }
}
