package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0007j\u0002`\u0008J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000cJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000cR\u001b\u0010\u0005\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u001b", d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", "limit", "", "(I)V", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "<set-?>", "totalExceptions", "getTotalExceptions", "()I", "collect", "", "exception", "enterEntry", "name", "exitEntry", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ExceptionsCollector {

    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;
    public ExceptionsCollector() {
        super(0, 1, 0);
    }

    public ExceptionsCollector(int limit) {
        super();
        this.limit = limit;
        ArrayList arrayList = new ArrayList();
        this.collectedExceptions = (List)arrayList;
    }

    public ExceptionsCollector(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 64 : obj1;
        super(obj1);
    }

    public final void collect(Exception exception) {
        int cause;
        int i;
        int collectedExceptions;
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.totalExceptions = totalExceptions += i;
        if (this.collectedExceptions.size() < this.limit) {
        } else {
            i = 0;
        }
        if (i != 0) {
            if (this.path != null) {
                FileSystemException fileSystemException = new FileSystemException(String.valueOf(this.path));
                Intrinsics.checkNotNull(fileSystemException.initCause((Throwable)exception), "null cannot be cast to non-null type java.nio.file.FileSystemException");
            } else {
                cause = exception;
            }
            this.collectedExceptions.add(cause);
        }
    }

    public final void enterEntry(Path name) {
        Path resolve;
        Intrinsics.checkNotNullParameter(name, "name");
        Path path = this.path;
        if (path != null) {
            resolve = path.resolve(name);
        } else {
            resolve = 0;
        }
        this.path = resolve;
    }

    public final void exitEntry(Path name) {
        int fileName;
        int parent;
        Intrinsics.checkNotNullParameter(name, "name");
        Path path = this.path;
        if (path != null) {
            fileName = path.getFileName();
        } else {
            fileName = parent;
        }
        if (Intrinsics.areEqual(name, fileName) == null) {
        } else {
            Path path2 = this.path;
            if (path2 != null) {
                parent = path2.getParent();
            }
            this.path = parent;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    public final List<Exception> getCollectedExceptions() {
        return this.collectedExceptions;
    }

    public final Path getPath() {
        return this.path;
    }

    public final int getTotalExceptions() {
        return this.totalExceptions;
    }

    public final void setPath(Path <set-?>) {
        this.path = <set-?>;
    }
}
