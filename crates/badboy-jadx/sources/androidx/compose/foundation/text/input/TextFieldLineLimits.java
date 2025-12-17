package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "", "Companion", "MultiLine", "SingleLine", "Landroidx/compose/foundation/text/input/TextFieldLineLimits$MultiLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits$SingleLine;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextFieldLineLimits {

    public static final androidx.compose.foundation.text.input.TextFieldLineLimits.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/input/TextFieldLineLimits$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "getDefault", "()Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.text.input.TextFieldLineLimits.Companion $$INSTANCE;
        private static final androidx.compose.foundation.text.input.TextFieldLineLimits Default;
        static {
            TextFieldLineLimits.Companion companion = new TextFieldLineLimits.Companion();
            TextFieldLineLimits.Companion.$$INSTANCE = companion;
            final int i3 = 0;
            TextFieldLineLimits.MultiLine multiLine = new TextFieldLineLimits.MultiLine(i3, i3, 3, 0);
            TextFieldLineLimits.Companion.Default = (TextFieldLineLimits)multiLine;
        }

        public final androidx.compose.foundation.text.input.TextFieldLineLimits getDefault() {
            return TextFieldLineLimits.Companion.Default;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u0003H\u0016J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0010", d2 = {"Landroidx/compose/foundation/text/input/TextFieldLineLimits$MultiLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "minHeightInLines", "", "maxHeightInLines", "(II)V", "getMaxHeightInLines", "()I", "getMinHeightInLines", "equals", "", "other", "", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MultiLine implements androidx.compose.foundation.text.input.TextFieldLineLimits {

        public static final int $stable;
        private final int maxHeightInLines;
        private final int minHeightInLines;
        static {
        }

        public MultiLine() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public MultiLine(int minHeightInLines, int maxHeightInLines) {
            int i;
            super();
            this.minHeightInLines = minHeightInLines;
            this.maxHeightInLines = maxHeightInLines;
            int minHeightInLines2 = this.minHeightInLines;
            i = 0;
            final int i3 = 1;
            if (i3 <= minHeightInLines2 && minHeightInLines2 <= this.maxHeightInLines) {
                i = minHeightInLines2 <= this.maxHeightInLines ? i3 : i;
            }
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected 1 ≤ minHeightInLines ≤ maxHeightInLines, were ").append(this.minHeightInLines).append(", ").append(this.maxHeightInLines).toString().toString());
            throw illegalArgumentException;
        }

        public MultiLine(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            int obj1;
            int obj2;
            obj1 = i3 & 1 != 0 ? 1 : obj1;
            obj2 = i3 &= 2 != 0 ? 0x7fffffff /* Unknown resource */ : obj2;
            super(obj1, obj2);
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (other == null) {
                return i2;
            }
            if (getClass() != other.getClass()) {
                return i2;
            }
            Object obj = other;
            if (this.minHeightInLines != obj2.minHeightInLines) {
                return i2;
            }
            if (this.maxHeightInLines != obj3.maxHeightInLines) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public final int getMaxHeightInLines() {
            return this.maxHeightInLines;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public final int getMinHeightInLines() {
            return this.minHeightInLines;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public int hashCode() {
            return i += maxHeightInLines;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("MultiLine(minHeightInLines=").append(this.minHeightInLines).append(", maxHeightInLines=").append(this.maxHeightInLines).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/input/TextFieldLineLimits$SingleLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "()V", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SingleLine implements androidx.compose.foundation.text.input.TextFieldLineLimits {

        public static final int $stable;
        public static final androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine INSTANCE;
        static {
            TextFieldLineLimits.SingleLine singleLine = new TextFieldLineLimits.SingleLine();
            TextFieldLineLimits.SingleLine.INSTANCE = singleLine;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldLineLimits
        public String toString() {
            return "TextFieldLineLimits.SingleLine";
        }
    }
    static {
        TextFieldLineLimits.Companion = TextFieldLineLimits.Companion.$$INSTANCE;
    }
}
