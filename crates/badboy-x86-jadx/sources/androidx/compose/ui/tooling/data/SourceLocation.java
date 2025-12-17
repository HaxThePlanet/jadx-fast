package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Landroidx/compose/ui/tooling/data/SourceLocation;", "", "lineNumber", "", "offset", "length", "sourceFile", "", "packageHash", "(IIILjava/lang/String;I)V", "getLength", "()I", "getLineNumber", "getOffset", "getPackageHash", "getSourceFile", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SourceLocation {

    public static final int $stable;
    private final int length;
    private final int lineNumber;
    private final int offset;
    private final int packageHash;
    private final String sourceFile;
    static {
    }

    public SourceLocation(int lineNumber, int offset, int length, String sourceFile, int packageHash) {
        super();
        this.lineNumber = lineNumber;
        this.offset = offset;
        this.length = length;
        this.sourceFile = sourceFile;
        this.packageHash = packageHash;
    }

    public static androidx.compose.ui.tooling.data.SourceLocation copy$default(androidx.compose.ui.tooling.data.SourceLocation sourceLocation, int i2, int i3, int i4, String string5, int i6, int i7, Object object8) {
        int obj1;
        int obj2;
        int obj3;
        String obj4;
        int obj5;
        if (i7 & 1 != 0) {
            obj1 = sourceLocation.lineNumber;
        }
        if (i7 & 2 != 0) {
            obj2 = sourceLocation.offset;
        }
        if (i7 & 4 != 0) {
            obj3 = sourceLocation.length;
        }
        if (i7 & 8 != 0) {
            obj4 = sourceLocation.sourceFile;
        }
        if (i7 &= 16 != 0) {
            obj5 = sourceLocation.packageHash;
        }
        return sourceLocation.copy(obj1, obj2, obj3, obj4, obj5);
    }

    public final int component1() {
        return this.lineNumber;
    }

    public final int component2() {
        return this.offset;
    }

    public final int component3() {
        return this.length;
    }

    public final String component4() {
        return this.sourceFile;
    }

    public final int component5() {
        return this.packageHash;
    }

    public final androidx.compose.ui.tooling.data.SourceLocation copy(int i, int i2, int i3, String string4, int i5) {
        SourceLocation sourceLocation = new SourceLocation(i, i2, i3, string4, i5);
        return sourceLocation;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SourceLocation) {
            return i2;
        }
        Object obj = object;
        if (this.lineNumber != obj.lineNumber) {
            return i2;
        }
        if (this.offset != obj.offset) {
            return i2;
        }
        if (this.length != obj.length) {
            return i2;
        }
        if (Intrinsics.areEqual(this.sourceFile, obj.sourceFile) == null) {
            return i2;
        }
        if (this.packageHash != obj.packageHash) {
            return i2;
        }
        return i;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public int hashCode() {
        int i;
        if (this.sourceFile == null) {
            i = 0;
        } else {
            i = this.sourceFile.hashCode();
        }
        return i5 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SourceLocation(lineNumber=").append(this.lineNumber).append(", offset=").append(this.offset).append(", length=").append(this.length).append(", sourceFile=").append(this.sourceFile).append(", packageHash=").append(this.packageHash).append(')').toString();
    }
}
