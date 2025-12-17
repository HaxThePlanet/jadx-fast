package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\u000c*\u00020\u0008H\u0002¢\u0006\u0002\u0008\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0008*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public static final File getRoot(File $this$root) {
        Intrinsics.checkNotNullParameter($this$root, "<this>");
        File file = new File(FilesKt.getRootName($this$root));
        return file;
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String $this$getRootLength) {
        int first;
        int endsWith$default;
        int charAt;
        int separatorChar;
        int i;
        int separatorChar2;
        int i5;
        int i3;
        int i4;
        int i2;
        first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, 0, false, 4, 0);
        int i6 = 1;
        first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, 2, false, 4, 0);
        int first2 = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, first + 1, false, 4, 0);
        if (first == 0 && $this$getRootLength.length() > i6 && $this$getRootLength.charAt(i6) == File.separatorChar && first >= 0 && first2 >= 0) {
            if ($this$getRootLength.length() > i6) {
                if ($this$getRootLength.charAt(i6) == File.separatorChar) {
                    first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, 2, false, 4, 0);
                    if (first >= 0) {
                        first2 = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, first + 1, false, 4, 0);
                        if (first2 >= 0) {
                            return first2 + 1;
                        }
                        return $this$getRootLength.length();
                    }
                }
            }
            return i6;
        }
        int i9 = 58;
        if (first > 0 && $this$getRootLength.charAt(first + -1) == i9) {
            if ($this$getRootLength.charAt(first + -1) == i9) {
                return first += i6;
            }
        }
        int i10 = 0;
        if (first == -1 && StringsKt.endsWith$default((CharSequence)$this$getRootLength, i9, i10, 2, 0)) {
            if (StringsKt.endsWith$default((CharSequence)$this$getRootLength, i9, i10, 2, 0)) {
                return $this$getRootLength.length();
            }
        }
        return i10;
    }

    public static final String getRootName(File $this$rootName) {
        Intrinsics.checkNotNullParameter($this$rootName, "<this>");
        String path = $this$rootName.getPath();
        String str2 = "getPath(...)";
        Intrinsics.checkNotNullExpressionValue(path, str2);
        String path2 = $this$rootName.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, str2);
        String substring = path.substring(0, FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final boolean isRooted(File $this$isRooted) {
        int i;
        Intrinsics.checkNotNullParameter($this$isRooted, "<this>");
        String path = $this$isRooted.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        i = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(path) > 0 ? 1 : 0;
        return i;
    }

    public static final File subPath(File $this$subPath, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$subPath, "<this>");
        return FilesKt.toComponents($this$subPath).subPath(beginIndex, endIndex);
    }

    public static final kotlin.io.FilePathComponents toComponents(File $this$toComponents) {
        Object $this$map$iv;
        int i3;
        ArrayList arrayList;
        java.util.List list;
        int i4;
        Iterator iterator;
        boolean next2;
        int next;
        int i;
        int i2;
        File file;
        Intrinsics.checkNotNullParameter($this$toComponents, "<this>");
        String path = $this$toComponents.getPath();
        Intrinsics.checkNotNull(path);
        final int rootLength$FilesKt__FilePathComponentsKt = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(path);
        int i5 = 0;
        final String substring = path.substring(i5, rootLength$FilesKt__FilePathComponentsKt);
        String str2 = "substring(...)";
        Intrinsics.checkNotNullExpressionValue(substring, str2);
        final String substring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(substring2, str2);
        arrayList = 1;
        i3 = (CharSequence)substring2.length() == 0 ? arrayList : i5;
        if (i3 != 0) {
            $this$map$iv = CollectionsKt.emptyList();
        } else {
            char[] cArr = new char[arrayList];
            cArr[i5] = File.separatorChar;
            java.util.List split$default = StringsKt.split$default((CharSequence)substring2, cArr, false, 0, 6, 0);
            i3 = 0;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)split$default, 10));
            i4 = 0;
            iterator = split$default.iterator();
            for (Object next : iterator) {
                i2 = 0;
                file = new File((String)next);
                (Collection)arrayList.add(file);
            }
            $this$map$iv = arrayList;
        }
        File file2 = new File(substring);
        FilePathComponents filePathComponents = new FilePathComponents(file2, $this$map$iv);
        return filePathComponents;
    }
}
