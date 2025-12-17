package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0081\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\n¨\u0006\u0016", d2 = {"Landroidx/compose/material3/internal/DateInputFormat;", "", "patternWithDelimiters", "", "delimiter", "", "(Ljava/lang/String;C)V", "getDelimiter", "()C", "getPatternWithDelimiters", "()Ljava/lang/String;", "patternWithoutDelimiters", "getPatternWithoutDelimiters", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateInputFormat {

    public static final int $stable;
    private final char delimiter;
    private final String patternWithDelimiters;
    private final String patternWithoutDelimiters;
    static {
    }

    public DateInputFormat(String patternWithDelimiters, char delimiter) {
        super();
        this.patternWithDelimiters = patternWithDelimiters;
        this.delimiter = delimiter;
        this.patternWithoutDelimiters = StringsKt.replace$default(this.patternWithDelimiters, String.valueOf(this.delimiter), "", false, 4, 0);
    }

    public static androidx.compose.material3.internal.DateInputFormat copy$default(androidx.compose.material3.internal.DateInputFormat dateInputFormat, String string2, char c3, int i4, Object object5) {
        String obj1;
        char obj2;
        if (i4 & 1 != 0) {
            obj1 = dateInputFormat.patternWithDelimiters;
        }
        if (i4 &= 2 != 0) {
            obj2 = dateInputFormat.delimiter;
        }
        return dateInputFormat.copy(obj1, obj2);
    }

    public final String component1() {
        return this.patternWithDelimiters;
    }

    public final char component2() {
        return this.delimiter;
    }

    public final androidx.compose.material3.internal.DateInputFormat copy(String string, char c2) {
        DateInputFormat dateInputFormat = new DateInputFormat(string, c2);
        return dateInputFormat;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DateInputFormat) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.patternWithDelimiters, obj.patternWithDelimiters)) {
            return i2;
        }
        if (this.delimiter != obj.delimiter) {
            return i2;
        }
        return i;
    }

    public final char getDelimiter() {
        return this.delimiter;
    }

    public final String getPatternWithDelimiters() {
        return this.patternWithDelimiters;
    }

    public final String getPatternWithoutDelimiters() {
        return this.patternWithoutDelimiters;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DateInputFormat(patternWithDelimiters=").append(this.patternWithDelimiters).append(", delimiter=").append(this.delimiter).append(')').toString();
    }
}
