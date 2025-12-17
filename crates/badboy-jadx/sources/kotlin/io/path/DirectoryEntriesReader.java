package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0015", d2 = {"Lkotlin/io/path/DirectoryEntriesReader;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "followLinks", "", "(Z)V", "directoryNode", "Lkotlin/io/path/PathNode;", "entries", "Lkotlin/collections/ArrayDeque;", "getFollowLinks", "()Z", "preVisitDirectory", "Ljava/nio/file/FileVisitResult;", "dir", "attrs", "Ljava/nio/file/attribute/BasicFileAttributes;", "readEntries", "", "visitFile", "file", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DirectoryEntriesReader extends SimpleFileVisitor<Path> {

    private kotlin.io.path.PathNode directoryNode;
    private ArrayDeque<kotlin.io.path.PathNode> entries;
    private final boolean followLinks;
    public DirectoryEntriesReader(boolean followLinks) {
        super();
        this.followLinks = followLinks;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.entries = arrayDeque;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public final boolean getFollowLinks() {
        return this.followLinks;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult preVisitDirectory(Object p0, BasicFileAttributes p1) {
        return preVisitDirectory((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        PathNode pathNode = new PathNode(dir, attrs.fileKey(), this.directoryNode);
        this.entries.add(pathNode);
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    public final List<kotlin.io.path.PathNode> readEntries(kotlin.io.path.PathNode directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.directoryNode = directoryNode;
        Files.walkFileTree(directoryNode.getPath(), LinkFollowing.INSTANCE.toVisitOptions(this.followLinks), 1, (FileVisitor)this);
        this.entries.removeFirst();
        ArrayDeque entries2 = this.entries;
        ArrayDeque queue = entries2;
        int i2 = 0;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.entries = arrayDeque;
        return (List)entries2;
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFile(Object p0, BasicFileAttributes p1) {
        return visitFile((Path)p0, p1);
    }

    @Override // java.nio.file.SimpleFileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        PathNode pathNode = new PathNode(file, 0, this.directoryNode);
        this.entries.add(pathNode);
        FileVisitResult visitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(visitFile, "visitFile(...)");
        return visitFile;
    }
}
