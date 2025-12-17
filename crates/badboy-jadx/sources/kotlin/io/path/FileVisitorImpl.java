package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0008\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0008\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {

    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;
    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onPreVisitDirectory, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onVisitFile, Function2<? super Path, ? super IOException, ? extends FileVisitResult> onVisitFileFailed, Function2<? super Path, ? super IOException, ? extends FileVisitResult> onPostVisitDirectory) {
        super();
        this.onPreVisitDirectory = onPreVisitDirectory;
        this.onVisitFile = onVisitFile;
        this.onVisitFileFailed = onVisitFileFailed;
        this.onPostVisitDirectory = onPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult postVisitDirectory(Object p0, IOException p1) {
        return postVisitDirectory((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        Object onPostVisitDirectory;
        String str;
        Intrinsics.checkNotNullParameter(dir, "dir");
        onPostVisitDirectory = this.onPostVisitDirectory;
        if (onPostVisitDirectory != null) {
            if ((FileVisitResult)onPostVisitDirectory.invoke(dir, exc) == null) {
                Intrinsics.checkNotNullExpressionValue(super.postVisitDirectory(dir, exc), "postVisitDirectory(...)");
            }
        } else {
        }
        return onPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult preVisitDirectory(Object p0, BasicFileAttributes p1) {
        return preVisitDirectory((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        Object onPreVisitDirectory;
        String str;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        onPreVisitDirectory = this.onPreVisitDirectory;
        if (onPreVisitDirectory != null) {
            if ((FileVisitResult)onPreVisitDirectory.invoke(dir, attrs) == null) {
                Intrinsics.checkNotNullExpressionValue(super.preVisitDirectory(dir, attrs), "preVisitDirectory(...)");
            }
        } else {
        }
        return onPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFile(Object p0, BasicFileAttributes p1) {
        return visitFile((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Object onVisitFile;
        String str;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        onVisitFile = this.onVisitFile;
        if (onVisitFile != null) {
            if ((FileVisitResult)onVisitFile.invoke(file, attrs) == null) {
                Intrinsics.checkNotNullExpressionValue(super.visitFile(file, attrs), "visitFile(...)");
            }
        } else {
        }
        return onVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFileFailed(Object p0, IOException p1) {
        return visitFileFailed((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        Object onVisitFileFailed;
        String str;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(exc, "exc");
        onVisitFileFailed = this.onVisitFileFailed;
        if (onVisitFileFailed != null) {
            if ((FileVisitResult)onVisitFileFailed.invoke(file, exc) == null) {
                Intrinsics.checkNotNullExpressionValue(super.visitFileFailed(file, exc), "visitFileFailed(...)");
            }
        } else {
        }
        return onVisitFileFailed;
    }
}
