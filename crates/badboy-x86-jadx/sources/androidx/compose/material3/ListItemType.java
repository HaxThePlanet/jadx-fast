package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0083@\u0018\u0000 \u00152\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u000cHÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class ListItemType implements Comparable<androidx.compose.material3.ListItemType> {

    public static final androidx.compose.material3.ListItemType.Companion Companion;
    private static final int OneLine;
    private static final int ThreeLine;
    private static final int TwoLine;
    private final int lines;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0080\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "ThreeLine", "getThreeLine-AlXitO8", "TwoLine", "getTwoLine-AlXitO8", "invoke", "hasOverline", "", "hasSupporting", "isSupportingMultiline", "invoke-Z-LSjz4$material3_release", "(ZZZ)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getOneLine-AlXitO8() {
            return ListItemType.access$getOneLine$cp();
        }

        public final int getThreeLine-AlXitO8() {
            return ListItemType.access$getThreeLine$cp();
        }

        public final int getTwoLine-AlXitO8() {
            return ListItemType.access$getTwoLine$cp();
        }

        public final int invoke-Z-LSjz4$material3_release(boolean hasOverline, boolean hasSupporting, boolean isSupportingMultiline) {
            int threeLine-AlXitO8;
            if (hasOverline) {
                if (!hasSupporting) {
                    if (isSupportingMultiline) {
                        threeLine-AlXitO8 = getThreeLine-AlXitO8();
                    } else {
                        if (!hasOverline) {
                            if (hasSupporting) {
                                threeLine-AlXitO8 = getTwoLine-AlXitO8();
                            } else {
                                threeLine-AlXitO8 = getOneLine-AlXitO8();
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return threeLine-AlXitO8;
        }
    }
    static {
        ListItemType.Companion companion = new ListItemType.Companion(0);
        ListItemType.Companion = companion;
        ListItemType.OneLine = ListItemType.constructor-impl(1);
        ListItemType.TwoLine = ListItemType.constructor-impl(2);
        ListItemType.ThreeLine = ListItemType.constructor-impl(3);
    }

    private ListItemType(int lines) {
        super();
        this.lines = lines;
    }

    public static final int access$getOneLine$cp() {
        return ListItemType.OneLine;
    }

    public static final int access$getThreeLine$cp() {
        return ListItemType.ThreeLine;
    }

    public static final int access$getTwoLine$cp() {
        return ListItemType.TwoLine;
    }

    public static final androidx.compose.material3.ListItemType box-impl(int i) {
        ListItemType listItemType = new ListItemType(i);
        return listItemType;
    }

    public static int compareTo-yh95HIg(int arg0, int other) {
        return Intrinsics.compare(arg0, other);
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof ListItemType) {
            return i3;
        }
        if (i != (ListItemType)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ListItemType(lines=").append(i).append(')').toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo-yh95HIg((ListItemType)other.unbox-impl());
    }

    @Override // java.lang.Comparable
    public int compareTo-yh95HIg(int other) {
        return ListItemType.compareTo-yh95HIg(this.lines, other);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return ListItemType.equals-impl(this.lines, object);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return ListItemType.hashCode-impl(this.lines);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return ListItemType.toString-impl(this.lines);
    }

    @Override // java.lang.Comparable
    public final int unbox-impl() {
        return this.lines;
    }
}
