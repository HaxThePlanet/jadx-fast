package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0008\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u001a0\u0010\u0007\u001a\u00020\u0008*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u00080\nH\u0086\u0008\u001a\u0012\u0010\u000f\u001a\u00020\u0008*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u0008*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0013", d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile $this$readBytes) {
        final int i = 0;
        return $this$readBytes.readFully();
    }

    public static final String readText(AtomicFile $this$readText, Charset charset) {
        String string = new String($this$readText.readFully(), charset);
        return string;
    }

    public static String readText$default(AtomicFile atomicFile, Charset charset2, int i3, Object object4) {
        Charset obj1;
        if (i3 &= 1 != 0) {
            obj1 = Charsets.UTF_8;
        }
        return AtomicFileKt.readText(atomicFile, obj1);
    }

    public static final void tryWrite(AtomicFile $this$tryWrite, Function1<? super FileOutputStream, Unit> block) {
        final int i = 0;
        final FileOutputStream write = $this$tryWrite.startWrite();
        int i2 = 0;
        block.invoke(write);
        int success = 1;
        $this$tryWrite.finishWrite(write);
    }

    public static final void writeBytes(AtomicFile $this$writeBytes, byte[] array) {
        final Object obj = $this$writeBytes;
        final int i = 0;
        final FileOutputStream write = obj.startWrite();
        int i2 = 0;
        final int i3 = 0;
        write.write(array);
        int success$iv = 1;
        obj.finishWrite(write);
    }

    public static final void writeText(AtomicFile $this$writeText, String text, Charset charset) {
        final byte[] bytes = text.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        AtomicFileKt.writeBytes($this$writeText, bytes);
    }

    public static void writeText$default(AtomicFile atomicFile, String string2, Charset charset3, int i4, Object object5) {
        Charset obj2;
        if (i4 &= 2 != 0) {
            obj2 = Charsets.UTF_8;
        }
        AtomicFileKt.writeText(atomicFile, string2, obj2);
    }
}
