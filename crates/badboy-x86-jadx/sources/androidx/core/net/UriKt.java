package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\u0008\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\u0008¨\u0006\u0005", d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UriKt {
    public static final File toFile(Uri $this$toFile) {
        if (Intrinsics.areEqual($this$toFile.getScheme(), "file") == null) {
        } else {
            String path = $this$toFile.getPath();
            if (path == null) {
            } else {
                File file = new File(path);
                return file;
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Uri path is null: ").append($this$toFile).toString().toString());
            throw illegalArgumentException;
        }
        int i2 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Uri lacks 'file' scheme: ").append($this$toFile).toString().toString());
        throw illegalArgumentException2;
    }

    public static final Uri toUri(File $this$toUri) {
        final int i = 0;
        return Uri.fromFile($this$toUri);
    }

    public static final Uri toUri(String $this$toUri) {
        final int i = 0;
        return Uri.parse($this$toUri);
    }
}
