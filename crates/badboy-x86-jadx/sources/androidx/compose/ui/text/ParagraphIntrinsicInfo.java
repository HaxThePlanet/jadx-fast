package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "", "intrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "startIndex", "", "endIndex", "(Landroidx/compose/ui/text/ParagraphIntrinsics;II)V", "getEndIndex", "()I", "getIntrinsics", "()Landroidx/compose/ui/text/ParagraphIntrinsics;", "getStartIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParagraphIntrinsicInfo {

    public static final int $stable = 8;
    private final int endIndex;
    private final androidx.compose.ui.text.ParagraphIntrinsics intrinsics;
    private final int startIndex;
    static {
        final int i = 8;
    }

    public ParagraphIntrinsicInfo(androidx.compose.ui.text.ParagraphIntrinsics intrinsics, int startIndex, int endIndex) {
        super();
        this.intrinsics = intrinsics;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static androidx.compose.ui.text.ParagraphIntrinsicInfo copy$default(androidx.compose.ui.text.ParagraphIntrinsicInfo paragraphIntrinsicInfo, androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics2, int i3, int i4, int i5, Object object6) {
        androidx.compose.ui.text.ParagraphIntrinsics obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = paragraphIntrinsicInfo.intrinsics;
        }
        if (i5 & 2 != 0) {
            obj2 = paragraphIntrinsicInfo.startIndex;
        }
        if (i5 &= 4 != 0) {
            obj3 = paragraphIntrinsicInfo.endIndex;
        }
        return paragraphIntrinsicInfo.copy(obj1, obj2, obj3);
    }

    public final androidx.compose.ui.text.ParagraphIntrinsics component1() {
        return this.intrinsics;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final androidx.compose.ui.text.ParagraphIntrinsicInfo copy(androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics, int i2, int i3) {
        ParagraphIntrinsicInfo paragraphIntrinsicInfo = new ParagraphIntrinsicInfo(paragraphIntrinsics, i2, i3);
        return paragraphIntrinsicInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ParagraphIntrinsicInfo) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.intrinsics, obj.intrinsics)) {
            return i2;
        }
        if (this.startIndex != obj.startIndex) {
            return i2;
        }
        if (this.endIndex != obj.endIndex) {
            return i2;
        }
        return i;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final androidx.compose.ui.text.ParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ParagraphIntrinsicInfo(intrinsics=").append(this.intrinsics).append(", startIndex=").append(this.startIndex).append(", endIndex=").append(this.endIndex).append(')').toString();
    }
}
