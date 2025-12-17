package okhttp3.internal.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.d0.d.g;
import l.b0;
import l.d0;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\n\u0008f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\n\u0010\tJ\u0017\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0019\u0010\r¨\u0006\u001b", d2 = {"Lokhttp3/internal/io/FileSystem;", "", "Ljava/io/File;", "file", "Ll/d0;", "source", "(Ljava/io/File;)Ll/d0;", "Ll/b0;", "sink", "(Ljava/io/File;)Ll/b0;", "appendingSink", "Lkotlin/w;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface FileSystem {

    public static final okhttp3.internal.io.FileSystem.Companion Companion;
    public static final okhttp3.internal.io.FileSystem SYSTEM;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\u0008\u0091F0\u0001¨\u0006\u0008", d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "Lokhttp3/internal/io/FileSystem;", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "<init>", "()V", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.internal.io.FileSystem.Companion $$INSTANCE;
        public Companion(g g) {
            super();
        }
    }
    static {
        FileSystem.Companion companion = new FileSystem.Companion(0);
        FileSystem.Companion = companion;
        FileSystem.Companion.SystemFileSystem systemFileSystem = new FileSystem.Companion.SystemFileSystem();
        FileSystem.SYSTEM = systemFileSystem;
    }

    public abstract b0 appendingSink(File file);

    public abstract void delete(File file);

    public abstract void deleteContents(File file);

    public abstract boolean exists(File file);

    public abstract void rename(File file, File file2);

    public abstract b0 sink(File file);

    public abstract long size(File file);

    public abstract d0 source(File file);
}
