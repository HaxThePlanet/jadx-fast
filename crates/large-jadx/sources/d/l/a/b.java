package d.l.a;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import java.io.Closeable;
import java.io.FileDescriptor;

/* compiled from: ExifInterfaceUtils.java */
/* loaded from: classes.dex */
class b {

    static class a {
        static void a(FileDescriptor fileDescriptor) throws android.system.ErrnoException {
            Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) throws android.system.ErrnoException {
            return Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long j, int i) throws android.system.ErrnoException {
            return Os.lseek(fileDescriptor, j, i);
        }
    }

    static class b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }
    static String a(byte[] bArr) {
        int i;
        final StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        i = 0;
        for (byte b : bArr) {
            Object[] arr = new Object[1];
            arr[i] = Byte.valueOf(b);
            str = "%02x";
            stringBuilder.append(String.format(str, arr));
        }
        return stringBuilder.toString();
    }

    static void b(Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
                return;
            }
        }
    }

    static long[] c(Object object) {
        int i = 0;
        if (object instanceof int[]) {
            long[] lArr = new long[object.length];
            i = 0;
            while (i < object.length) {
                l = (long)object[i];
                lArr[i] = l;
                i = i + 1;
            }
            return lArr;
        }
        if (object instanceof long[]) {
            return object;
        }
        return null;
    }

    static boolean d(byte[] bArr, byte[] bArr2) {
        int i;
        i = 0;
        return false;
    }
}
