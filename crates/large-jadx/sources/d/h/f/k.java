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

/* loaded from: classes.dex */
public class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    public static ByteBuffer b(Context context, Resources resources2, int i3) {
        final File obj1 = k.e(context);
        final int i = 0;
        if (obj1 == null) {
            return i;
        }
        if (!k.c(obj1, resources2, i3)) {
            obj1.delete();
            return i;
        }
        obj1.delete();
        return k.g(obj1);
    }

    public static boolean c(File file, Resources resources2, int i3) {
        try {
            final InputStream obj1 = resources2.openRawResource(i3);
            k.a(obj1);
            return k.d(file, obj1);
            resources2 = 0;
            k.a(resources2);
            throw file;
        } catch (Throwable th) {
        }
    }

    public static boolean d(File file, InputStream inputStream2) {
        Closeable closeable;
        int read;
        String str;
        final int i = 0;
        read = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(file, i);
        byte[] obj5 = new byte[1024];
        read = inputStream2.read(obj5);
        while (read != -1) {
            fileOutputStream.write(obj5, i, read);
            read = inputStream2.read(obj5);
        }
        k.a(fileOutputStream);
        StrictMode.setThreadPolicy(StrictMode.allowThreadDiskWrites());
        return 1;
    }

    public static File e(Context context) {
        int i;
        int myTid;
        boolean newFile;
        final File obj5 = context.getCacheDir();
        final int i2 = 0;
        if (obj5 == null) {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".font");
        stringBuilder.append(Process.myPid());
        String str2 = "-";
        stringBuilder.append(str2);
        stringBuilder.append(Process.myTid());
        stringBuilder.append(str2);
        i = 0;
        while (i < 100) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append(i);
            myTid = new File(obj5, stringBuilder2.toString());
            i++;
        }
        return i2;
    }

    public static ByteBuffer f(Context context, CancellationSignal cancellationSignal2, Uri uri3) {
        ParcelFileDescriptor obj7 = context.getContentResolver().openFileDescriptor(uri3, "r", cancellationSignal2);
        if (obj7 == null && obj7 != null) {
            if (obj7 != null) {
                obj7.close();
            }
            return null;
        }
        FileInputStream obj8 = new FileInputStream(obj7.getFileDescriptor());
        FileChannel channel = obj8.getChannel();
        obj8.close();
        if (obj7 != null) {
            try {
                obj7.close();
                return channel.map(FileChannel.MapMode.READ_ONLY, 0, obj4);
                cancellationSignal2.close();
                uri3.addSuppressed(cancellationSignal2);
                throw uri3;
                if (context == null) {
                } else {
                }
                context.close();
                cancellationSignal2.addSuppressed(context);
                throw cancellationSignal2;
                return obj0;
            } catch (Throwable th) {
            }
        }
    }

    private static ByteBuffer g(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            final FileChannel channel = fileInputStream.getChannel();
            fileInputStream.close();
            return channel.map(FileChannel.MapMode.READ_ONLY, 0, obj4);
            th.close();
            file.addSuppressed(th);
            throw file;
            file = null;
            return file;
        } catch (Throwable th) {
        }
    }

    public static Map<Uri, ByteBuffer> h(Context context, f.b[] f$b2Arr2, CancellationSignal cancellationSignal3) {
        int i;
        Object obj;
        int key;
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < b2Arr2.length) {
            obj = b2Arr2[i];
            if (obj.b() != 0) {
            } else {
            }
            obj = obj.d();
            if (hashMap.containsKey(obj)) {
            } else {
            }
            hashMap.put(obj, k.f(context, cancellationSignal3, obj));
            i++;
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
