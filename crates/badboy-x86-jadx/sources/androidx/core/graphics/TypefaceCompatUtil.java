package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class TypefaceCompatUtil {

    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";
    public static void closeQuietly(Closeable c) {
        Throwable th;
        if (c != null) {
            c.close();
        }
    }

    public static ByteBuffer copyToDirectBuffer(Context context, Resources res, int id) {
        final File tempFile = TypefaceCompatUtil.getTempFile(context);
        int i = 0;
        if (tempFile == null) {
            return i;
        }
        if (TypefaceCompatUtil.copyToFile(tempFile, res, id) == null) {
            tempFile.delete();
            return i;
        }
        tempFile.delete();
        return TypefaceCompatUtil.mmap(tempFile);
    }

    public static boolean copyToFile(File file, Resources res, int id) {
        int i = 0;
        InputStream is = rawResource;
        TypefaceCompatUtil.closeQuietly(is);
        return TypefaceCompatUtil.copyToFile(file, is);
    }

    public static boolean copyToFile(File file, InputStream is) {
        String read;
        StringBuilder string;
        String message;
        int i = 0;
        int i2 = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(file, i2);
        FileOutputStream os = fileOutputStream;
        byte[] bArr = new byte[1024];
        read = is.read(bArr);
        while (read != -1) {
            os.write(bArr, i2, read);
            read = is.read(bArr);
        }
        TypefaceCompatUtil.closeQuietly(os);
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskWrites());
        return 1;
    }

    public static File getTempFile(Context context) {
        int i;
        int myTid;
        Throwable newFile;
        final File cacheDir = context.getCacheDir();
        final int i2 = 0;
        if (cacheDir == null) {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "-";
        i = 0;
        while (i < 100) {
            StringBuilder stringBuilder2 = new StringBuilder();
            myTid = new File(cacheDir, stringBuilder2.append(stringBuilder.append(".font").append(Process.myPid()).append(str2).append(Process.myTid()).append(str2).toString()).append(i).toString());
            i++;
        }
        return i2;
    }

    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
        Throwable th;
        Throwable th3;
        final ParcelFileDescriptor parcelFileDescriptor = fileDescriptor;
        if (parcelFileDescriptor == null && parcelFileDescriptor != null) {
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        FileInputStream inputStream = fileInputStream;
        final FileChannel fileChannel = channel;
        inputStream.close();
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, obj8);
                th3 = th2;
                th.close();
                th3.addSuppressed(th2);
                throw th3;
                th = th2;
                if (obj3 == null) {
                } else {
                }
                obj3.close();
                th.addSuppressed(th2);
                throw th;
                return obj2;
            } catch (Throwable th) {
            }
        }
    }

    private static ByteBuffer mmap(File file) {
        Throwable th;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            final FileInputStream inputStream = fileInputStream;
            final FileChannel fileChannel = channel;
            inputStream.close();
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, obj5);
            th = th2;
            i.close();
            th.addSuppressed(th2);
            throw th;
            int i = 0;
            return i;
        } catch (Throwable th) {
        }
    }

    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(Context context, FontsContractCompat.FontInfo[] fonts, CancellationSignal cancellationSignal) {
        int i;
        Object obj;
        int resultCode;
        ByteBuffer mmap;
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < fonts.length) {
            obj = fonts[i];
            if (obj.getResultCode() != 0) {
            } else {
            }
            resultCode = obj.getUri();
            if (hashMap.containsKey(resultCode)) {
            } else {
            }
            hashMap.put(resultCode, TypefaceCompatUtil.mmap(context, cancellationSignal, resultCode));
            i++;
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
