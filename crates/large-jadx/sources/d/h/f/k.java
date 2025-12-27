package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import d.h.i.f.b;
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

/* compiled from: TypefaceCompatUtil.java */
/* loaded from: classes.dex */
public class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                return;
            }
        }
    }

    public static ByteBuffer b(Context context, Resources resources, int i) {
        final File file = k.e(context);
        i = 0;
        if (file == null) {
            return null;
        }
        try {
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) resources;
        }
        if (k.c(file, resources, i) == null) {
            file.delete();
            return i;
        }
        try {
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) resources;
        }
        file.delete();
        return k.g(file);
    }

    public static boolean c(File file, Resources resources, int i) {
        try {
            final InputStream rawResource = resources.openRawResource(i);
        } catch (Throwable th) {
        }
        try {
        } catch (Throwable th) {
        }
        k.a(rawResource);
        return k.d(th, rawResource);
    }

    public static boolean d(File file, InputStream inputStream) {
        Object stringBuilder;
        final boolean z2 = false;
        int bytesRead = 0;
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file, z2);
        } catch (Throwable th) {
        } catch (java.io.IOException ioException1) {
        }
        try {
            byte[] bArr = new byte[1024];
            bytesRead = inputStream.read(bArr);
            int i = -1;
            fileOutputStream.write(bArr, z2, bytesRead);
        } catch (Throwable th) {
        } catch (java.io.IOException ioException1) {
        }
        k.a(fileOutputStream);
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskWrites());
        return true;
    }

    public static File e(Context context) {
        int i = 0;
        final File cacheDir = context.getCacheDir();
        final int i2 = 0;
        if (cacheDir == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ".font";
        int myPid = Process.myPid();
        String str3 = "-";
        int myTid = Process.myTid();
        str = str2 + myPid + str3 + myTid + str3;
        i = 0;
        while (i < 100) {
            StringBuilder stringBuilder2 = new StringBuilder();
            r4 = str + i;
            File file = new File(cacheDir, r4);
            try {
            } catch (java.io.IOException unused) {
                i = i + 1;
            }
            if (file.createNewFile() != null) {
                return file;
            }
        }
        return i2;
    }

    public static ByteBuffer f(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor fileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (fileDescriptor != null) {
                fileDescriptor.close();
            }
        } catch (Throwable th) {
        }
        try {
            final FileInputStream fileInputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        } catch (Throwable th) {
        }
        try {
            FileChannel channel = fileInputStream.getChannel();
        } catch (Throwable th) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable th) {
        }
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (Throwable th) {
            }
        }
        return channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
    }

    private static ByteBuffer g(File file) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
        }
        try {
            final FileChannel channel = fileInputStream.getChannel();
        } catch (Throwable th) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable th) {
        }
        return channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
    }

    public static Map<Uri, ByteBuffer> h(Context context, f.b[] bVarArr, CancellationSignal cancellationSignal) {
        int i = 0;
        Object obj;
        int i2;
        final HashMap hashMap = new HashMap();
        i = 0;
        for (Object obj : bVarArr) {
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
