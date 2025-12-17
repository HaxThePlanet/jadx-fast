package androidx.room.f1;

import android.os.Build.VERSION;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
public class d {
    public static void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel2) {
        int inputStream;
        int outputStream;
        byte[] bArr;
        ReadableByteChannel read;
        int i;
        long l;
        try {
            final int i2 = 0;
            if (Build.VERSION.SDK_INT > 23) {
            } else {
            }
            fileChannel2.transferFrom(readableByteChannel, 0, obj6);
            bArr = new byte[4096];
            read = Channels.newInputStream(readableByteChannel).read(bArr);
            while (read > 0) {
                Channels.newOutputStream(fileChannel2).write(bArr, i2, read);
                read = inputStream.read(bArr);
            }
            outputStream.write(bArr, i2, read);
            fileChannel2.force(i2);
            readableByteChannel.close();
            fileChannel2.close();
            readableByteChannel.close();
            fileChannel2.close();
            throw th;
        }
    }
}
