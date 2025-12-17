package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.f;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008\u000f\u0010\u0010J%\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\u0008\u000b\u0010\tR\u0016\u0010\r\u001a\u00020\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "", "pos", "Ll/f;", "source", "byteCount", "Lkotlin/w;", "write", "(JLl/f;J)V", "sink", "read", "Ljava/nio/channels/FileChannel;", "fileChannel", "Ljava/nio/channels/FileChannel;", "<init>", "(Ljava/nio/channels/FileChannel;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class FileOperator {

    private final FileChannel fileChannel;
    public FileOperator(FileChannel fileChannel) {
        n.f(fileChannel, "fileChannel");
        super();
        this.fileChannel = fileChannel;
    }

    public final void read(long l, f f2, long l3) {
        int transferTo;
        FileChannel fileChannel;
        long l2;
        int i;
        Object obj;
        int obj10;
        int obj13;
        n.f(l3, "sink");
        int i2 = 0;
        if (Long.compare(obj13, i2) < 0) {
        }
        obj10 = new IndexOutOfBoundsException();
        throw obj10;
    }

    public final void write(long l, f f2, long l3) {
        int transferFrom;
        FileChannel fileChannel;
        Object obj;
        long l2;
        int i;
        int obj10;
        int obj13;
        n.f(l3, "source");
        int i2 = 0;
        if (Long.compare(obj13, i2) < 0) {
        } else {
            if (Long.compare(obj13, size) > 0) {
            }
        }
        obj10 = new IndexOutOfBoundsException();
        throw obj10;
    }
}
