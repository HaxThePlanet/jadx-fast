package kotlin.io.path;

import _COROUTINE.ArtificialStackFrames;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\u0008¢\u0006\u0002\u0008\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0008\n\u001a'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0008\u000e\u001a&\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0005H\u0082\u0008¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a\u000c\u0010\u0013\u001a\u00020\u0001*\u00020\tH\u0000\u001a\u0019\u0010\u0014\u001a\u00020\u0001*\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0002\u0008\u0015\u001aw\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\u0008\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0007\u001a´\u0001\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\u0008\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2C\u0008\u0002\u0010$\u001a=\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020&0\u0019¢\u0006\u0002\u0008'H\u0007\u001a\u000c\u0010(\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010)\u001a\u000c\u0012\u0008\u0012\u00060\u001dj\u0002`\u001e0**\u00020\tH\u0002¢\u0006\u0002\u0008+\u001a'\u0010,\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0008.\u001a1\u0010/\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u00080\u001a5\u00101\u001a\u00020\"*\u0008\u0012\u0004\u0012\u00020\t0-2\u0006\u00102\u001a\u00020\t2\u0012\u00103\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020504\"\u000205H\u0002¢\u0006\u0004\u00086\u00107\u001a\u0011\u00108\u001a\u000209*\u00020&H\u0003¢\u0006\u0002\u0008:\u001a\u0011\u00108\u001a\u000209*\u00020 H\u0003¢\u0006\u0002\u0008:¨\u0006;", d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "parent", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "copyToRecursively", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends kotlin.io.path.PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        static {
            int i;
            int ordinal;
            int ordinal4;
            int ordinal3;
            int ordinal2;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[CopyActionResult.CONTINUE.ordinal()] = i;
            int i2 = 2;
            iArr[CopyActionResult.TERMINATE.ordinal()] = i2;
            iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            PathsKt__PathRecursiveFunctionsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[OnErrorResult.TERMINATE.ordinal()] = i;
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = i2;
                PathsKt__PathRecursiveFunctionsKt.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    public static final FileVisitResult access$copyToRecursively$copy(ArrayList stack, Function3 $copyAction, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Function3 $onError, Path source, BasicFileAttributes attributes) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(stack, $copyAction, $this_copyToRecursively, $target, normalizedTarget, $onError, source, attributes);
    }

    public static final FileVisitResult access$copyToRecursively$error(Function3 $onError, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Path source, Exception exception) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt($onError, $this_copyToRecursively, $target, normalizedTarget, source, exception);
    }

    public static final void checkFileName(Path $this$checkFileName) {
        int equals;
        Intrinsics.checkNotNullParameter($this$checkFileName, "<this>");
        String name = PathsKt.getName($this$checkFileName);
        switch (name) {
            case ".":
                IllegalFileNameException illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
            case "..":
                illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
            case "./":
                illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
            case ".\\":
                illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
            case "../":
                illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
            case "..\\":
                illegalFileNameException = new IllegalFileNameException($this$checkFileName);
                throw illegalFileNameException;
        }
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path $this$checkNotSameAs, Path parent) {
        boolean symbolicLink;
        if (Files.isSymbolicLink($this$checkNotSameAs) == null) {
            if (Files.isSameFile($this$checkNotSameAs, parent) != null) {
            } else {
            }
            FileSystemLoopException fileSystemLoopException = new FileSystemLoopException($this$checkNotSameAs.toString());
            throw fileSystemLoopException;
        }
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(kotlin.io.path.ExceptionsCollector collector, Function0<Unit> function) {
        Throwable th;
        final int i = 0;
        function.invoke();
        try {
        }
    }

    public static final Path copyToRecursively(Path $this$copyToRecursively, Path target, Function3<? super Path, ? super Path, ? super Exception, ? extends kotlin.io.path.OnErrorResult> onError, boolean followLinks, Function3<? super kotlin.io.path.CopyActionContext, ? super Path, ? super Path, ? extends kotlin.io.path.CopyActionResult> copyAction) {
        int startsWith2;
        boolean symbolicLink;
        boolean symbolicLink2;
        int realPath2;
        boolean sameFile;
        java.nio.file.FileSystem fileSystem;
        boolean startsWith;
        Path realPath;
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(copyAction, "copyAction");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
        Object[] copyOf = Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.exists($this$copyToRecursively, (LinkOption[])Arrays.copyOf((LinkOption[])copyOf, copyOf.length)) == null) {
        } else {
            startsWith2 = 0;
            if (Files.exists($this$copyToRecursively, (LinkOption[])Arrays.copyOf(new LinkOption[startsWith2], startsWith2)) != null) {
                if (!followLinks) {
                    if (Files.isSymbolicLink($this$copyToRecursively) == null) {
                        realPath2 = 1;
                        if (Files.exists(target, (LinkOption[])Arrays.copyOf(new LinkOption[startsWith2], startsWith2)) != null && Files.isSymbolicLink(target) == null) {
                            symbolicLink = Files.isSymbolicLink(target) == null ? realPath2 : startsWith2;
                        } else {
                        }
                        if (symbolicLink != 0) {
                            if (Files.isSameFile($this$copyToRecursively, target) == null) {
                                if (Intrinsics.areEqual($this$copyToRecursively.getFileSystem(), target.getFileSystem()) == null) {
                                } else {
                                    if (symbolicLink != 0) {
                                        startsWith2 = target.toRealPath(new LinkOption[startsWith2]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[startsWith2]));
                                    } else {
                                        sameFile = target.getParent();
                                        fileSystem = 0;
                                        if (sameFile != null && Files.exists(sameFile, (LinkOption[])Arrays.copyOf(new LinkOption[startsWith2], startsWith2)) != null && sameFile.toRealPath(new LinkOption[startsWith2]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[startsWith2])) != null) {
                                            fileSystem = 0;
                                            if (Files.exists(sameFile, (LinkOption[])Arrays.copyOf(new LinkOption[startsWith2], startsWith2)) != null) {
                                                if (sameFile.toRealPath(new LinkOption[startsWith2]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[startsWith2])) != null) {
                                                    startsWith2 = realPath2;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (startsWith2 != 0) {
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                FileSystemException fileSystemException = new FileSystemException($this$copyToRecursively.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                throw fileSystemException;
            }
            Path normalize = target.normalize();
            ArrayList arrayList = new ArrayList();
            PathsKt__PathRecursiveFunctionsKt.copyToRecursively.5 anon = new PathsKt__PathRecursiveFunctionsKt.copyToRecursively.5(arrayList, copyAction, $this$copyToRecursively, target, normalize, onError);
            ArrayList list = arrayList;
            Path path = normalize;
            PathsKt.visitFileTree$default($this$copyToRecursively, 0, followLinks, (Function1)anon, 1, 0);
            return target;
        }
        NoSuchFileException noSuchFileException = new NoSuchFileException($this$copyToRecursively.toString(), target.toString(), "The source file doesn't exist.");
        throw noSuchFileException;
    }

    public static final Path copyToRecursively(Path $this$copyToRecursively, Path target, Function3<? super Path, ? super Path, ? super Exception, ? extends kotlin.io.path.OnErrorResult> onError, boolean followLinks, boolean overwrite) {
        Path copyToRecursively$default;
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        int i2;
        int i3;
        int i;
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (overwrite) {
            PathsKt__PathRecursiveFunctionsKt.copyToRecursively.2 anon = new PathsKt__PathRecursiveFunctionsKt.copyToRecursively.2(followLinks);
            copyToRecursively$default = PathsKt.copyToRecursively($this$copyToRecursively, target, onError, followLinks, (Function3)anon);
            obj = $this$copyToRecursively;
            obj2 = target;
            obj3 = onError;
            z = followLinks;
        } else {
            copyToRecursively$default = PathsKt.copyToRecursively$default($this$copyToRecursively, target, onError, followLinks, 0, 8, 0);
        }
        return copyToRecursively$default;
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> stack, Function3<? super kotlin.io.path.CopyActionContext, ? super Path, ? super Path, ? extends kotlin.io.path.CopyActionResult> $copyAction, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Function3<? super Path, ? super Path, ? super Exception, ? extends kotlin.io.path.OnErrorResult> $onError, Path source, BasicFileAttributes attributes) {
        boolean empty;
        FileVisitResult fileVisitResult$PathsKt__PathRecursiveFunctionsKt;
        Function3 function3;
        Path path;
        Path path4;
        Path path2;
        Path path3;
        Throwable th;
        if (!(Collection)stack.isEmpty()) {
            try {
                PathsKt.checkFileName(source);
                PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(source, (Path)CollectionsKt.last((List)stack));
                fileVisitResult$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((CopyActionResult)$copyAction.invoke(DefaultCopyActionContext.INSTANCE, source, PathsKt__PathRecursiveFunctionsKt.copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, normalizedTarget, source)));
                path = $this_copyToRecursively;
                path4 = $target;
                path2 = normalizedTarget;
                function3 = $onError;
                path3 = source;
                return fileVisitResult$PathsKt__PathRecursiveFunctionsKt;
            }
        }
    }

    public static Path copyToRecursively$default(Path path, Path path2, Function3 function33, boolean z4, Function3 function35, int i6, Object object7) {
        kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively.3 obj2;
        kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively.4 obj4;
        if (i6 & 2 != 0) {
            obj2 = PathsKt__PathRecursiveFunctionsKt.copyToRecursively.3.INSTANCE;
        }
        if (i6 &= 8 != 0) {
            obj4 = new PathsKt__PathRecursiveFunctionsKt.copyToRecursively.4(z4);
        }
        return PathsKt.copyToRecursively(path, path2, obj2, z4, obj4);
    }

    public static Path copyToRecursively$default(Path path, Path path2, Function3 function33, boolean z4, boolean z5, int i6, Object object7) {
        kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively.1 obj2;
        if (i6 &= 2 != 0) {
            obj2 = PathsKt__PathRecursiveFunctionsKt.copyToRecursively.1.INSTANCE;
        }
        return PathsKt.copyToRecursively(path, path2, obj2, z4, z5);
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path $this_copyToRecursively, Path $target, Path normalizedTarget, Path source) {
        Path resolve = $target.resolve(PathsKt.relativeTo(source, $this_copyToRecursively).toString());
        if (!resolve.normalize().startsWith(normalizedTarget)) {
        } else {
            Intrinsics.checkNotNull(resolve);
            return resolve;
        }
        IllegalFileNameException illegalFileNameException = new IllegalFileNameException(source, resolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        throw illegalFileNameException;
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends kotlin.io.path.OnErrorResult> $onError, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Path source, Exception exception) {
        return PathsKt__PathRecursiveFunctionsKt.toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((OnErrorResult)$onError.invoke(source, PathsKt__PathRecursiveFunctionsKt.copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, normalizedTarget, source), exception));
    }

    public static final void deleteRecursively(Path $this$deleteRecursively) {
        Object next;
        Object obj2;
        int i;
        FileSystemException exc;
        Object obj;
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        List recursivelyImpl$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursively);
        if (!(Collection)recursivelyImpl$PathsKt__PathRecursiveFunctionsKt.isEmpty()) {
            FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            final int i2 = 0;
            final int i3 = 0;
            final Iterator iterator = (Iterable)recursivelyImpl$PathsKt__PathRecursiveFunctionsKt.iterator();
            for (Object next : iterator) {
                i = 0;
                ExceptionsKt.addSuppressed((Throwable)fileSystemException, (Throwable)(Exception)next);
            }
            throw (Throwable)fileSystemException;
        }
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path $this$deleteRecursivelyImpl) {
        int useInsecure;
        int i2;
        Object directoryStream;
        Object obj;
        Object stream;
        int i;
        boolean z;
        Path fileName;
        String str;
        final int i6 = 0;
        ExceptionsCollector exceptionsCollector = new ExceptionsCollector(0, 1, i6);
        int i4 = 0;
        useInsecure = 1;
        Path parent = $this$deleteRecursivelyImpl.getParent();
        if (parent != null) {
            i2 = 0;
            directoryStream = Files.newDirectoryStream(parent);
            obj = directoryStream;
            DirectoryStream stream2 = obj;
            i = 0;
            if (directoryStream != null && stream2 instanceof SecureDirectoryStream != null) {
                obj = directoryStream;
                stream2 = obj;
                i = 0;
                if (stream2 instanceof SecureDirectoryStream != null) {
                    useInsecure = 0;
                    exceptionsCollector.setPath(parent);
                    fileName = $this$deleteRecursivelyImpl.getFileName();
                    Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                    PathsKt__PathRecursiveFunctionsKt.handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream)(DirectoryStream)(DirectoryStream)stream2, fileName, i6, exceptionsCollector);
                }
                stream = Unit.INSTANCE;
                CloseableKt.closeFinally((Closeable)(Closeable)obj, i6);
            }
        }
        if (useInsecure != 0) {
            PathsKt__PathRecursiveFunctionsKt.insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursivelyImpl, i6, exceptionsCollector);
        }
        return exceptionsCollector.getCollectedExceptions();
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> $this$enterDirectory, Path name, kotlin.io.path.ExceptionsCollector collector) {
        int directoryStream;
        int i;
        SecureDirectoryStream directoryStream2;
        Object nOFOLLOW_LINKS;
        int next;
        Path fileName;
        Path path;
        final int i2 = 0;
        final int i3 = 0;
        directoryStream = 0;
        i = 0;
        LinkOption[] arr = new LinkOption[1];
        directoryStream2 = $this$enterDirectory.newDirectoryStream(name, LinkOption.NOFOLLOW_LINKS);
        if (directoryStream2 != null) {
            SecureDirectoryStream stream = directoryStream2;
            i = 0;
            nOFOLLOW_LINKS = (SecureDirectoryStream)stream.iterator();
            for (Path next : nOFOLLOW_LINKS) {
                fileName = next.getFileName();
                Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                PathsKt__PathRecursiveFunctionsKt.handleEntry$PathsKt__PathRecursiveFunctionsKt(stream, fileName, collector.getPath(), collector);
            }
            directoryStream = Unit.INSTANCE;
            CloseableKt.closeFinally((Closeable)directoryStream2, 0);
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> $this$handleEntry, Path name, Path parent, kotlin.io.path.ExceptionsCollector collector) {
        int i;
        Path path;
        int totalExceptions;
        int totalExceptions2;
        int iNSTANCE;
        collector.enterEntry(name);
        final int i2 = 0;
        i = 0;
        if (parent != null) {
            path = collector.getPath();
            Intrinsics.checkNotNull(path);
            PathsKt.checkFileName(path);
            PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path, parent);
        }
        LinkOption[] arr = new LinkOption[1];
        if (PathsKt__PathRecursiveFunctionsKt.isDirectory$PathsKt__PathRecursiveFunctionsKt($this$handleEntry, name, LinkOption.NOFOLLOW_LINKS) != null) {
            PathsKt__PathRecursiveFunctionsKt.enterDirectory$PathsKt__PathRecursiveFunctionsKt($this$handleEntry, name, collector);
            if (collector.getTotalExceptions() == collector.getTotalExceptions()) {
                totalExceptions2 = 0;
                int i4 = 0;
                $this$handleEntry.deleteDirectory(name);
                iNSTANCE = Unit.INSTANCE;
            }
        } else {
            totalExceptions = 0;
            int i3 = 0;
            $this$handleEntry.deleteFile(name);
            totalExceptions2 = Unit.INSTANCE;
        }
        try {
            collector.collect(th);
            collector.exitEntry(name);
        } catch (java.nio.file.NoSuchFileException noSuchFile) {
        } catch (Exception e1) {
        }
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path path, kotlin.io.path.ExceptionsCollector collector) {
        int directoryStream2;
        int i;
        DirectoryStream directoryStream;
        Iterator iterator;
        boolean next;
        final int i2 = 0;
        final int i3 = 0;
        directoryStream2 = 0;
        i = 0;
        directoryStream = Files.newDirectoryStream(path);
        if (directoryStream != null) {
            i = 0;
            iterator = (DirectoryStream)(Closeable)directoryStream.iterator();
            for (Path next : iterator) {
                Intrinsics.checkNotNull(next);
                PathsKt__PathRecursiveFunctionsKt.insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(next, path, collector);
            }
            try {
                directoryStream2 = Unit.INSTANCE;
                CloseableKt.closeFinally(directoryStream, 0);
                throw th2;
                CloseableKt.closeFinally(closeable, th2);
                throw th3;
                collector.collect(th);
            } catch (Exception e) {
            }
        }
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path entry, Path parent, kotlin.io.path.ExceptionsCollector collector) {
        int i;
        int totalExceptions2;
        int totalExceptions;
        final int i2 = 0;
        i = 0;
        if (parent != null) {
            PathsKt.checkFileName(entry);
            PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(entry, parent);
        }
        int i3 = 1;
        totalExceptions = new LinkOption[i3];
        totalExceptions[0] = LinkOption.NOFOLLOW_LINKS;
        if (Files.isDirectory(entry, (LinkOption[])Arrays.copyOf(totalExceptions, i3)) != null) {
            PathsKt__PathRecursiveFunctionsKt.insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(entry, collector);
            if (collector.getTotalExceptions() == collector.getTotalExceptions()) {
                Files.deleteIfExists(entry);
            }
        } else {
            try {
                Files.deleteIfExists(entry);
                collector.collect(th);
            }
        }
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> $this$isDirectory, Path entryName, LinkOption... options) {
        boolean booleanValue;
        Boolean valueOf;
        boolean directory;
        int i = 0;
        int i2 = 0;
        valueOf = Boolean.valueOf((BasicFileAttributeView)$this$isDirectory.getFileAttributeView(entryName, BasicFileAttributeView.class, (LinkOption[])Arrays.copyOf(options, options.length)).readAttributes().isDirectory());
        try {
            if (valueOf != null) {
            } else {
            }
            booleanValue = valueOf.booleanValue();
            booleanValue = 0;
            return booleanValue;
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(kotlin.io.path.CopyActionResult $this$toFileVisitResult) {
        FileVisitResult sKIP_SUBTREE;
        switch (i) {
            case 1:
                sKIP_SUBTREE = FileVisitResult.CONTINUE;
                break;
            case 2:
                sKIP_SUBTREE = FileVisitResult.TERMINATE;
                break;
            case 3:
                sKIP_SUBTREE = FileVisitResult.SKIP_SUBTREE;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return sKIP_SUBTREE;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(kotlin.io.path.OnErrorResult $this$toFileVisitResult) {
        FileVisitResult sKIP_SUBTREE;
        switch (i) {
            case 1:
                sKIP_SUBTREE = FileVisitResult.TERMINATE;
                break;
            case 2:
                sKIP_SUBTREE = FileVisitResult.SKIP_SUBTREE;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return sKIP_SUBTREE;
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function) {
        Object invoke;
        int i;
        final int i2 = 0;
        invoke = function.invoke();
        return invoke;
    }
}
