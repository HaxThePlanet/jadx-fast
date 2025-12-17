package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001:\u0002\u000c\rJ=\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\u0008\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007¢\u0006\u0002\u0008\tH&ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout;", "", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "BeyondBoundsScope", "LayoutDirection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BeyondBoundsLayout {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "", "hasMoreContent", "", "getHasMoreContent", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BeyondBoundsScope {
        public abstract boolean getHasMoreContent();
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class LayoutDirection {

        private static final int Above;
        private static final int After;
        private static final int Before;
        private static final int Below;
        public static final androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion Companion;
        private static final int Left;
        private static final int Right;
        private final int value;
        static {
            BeyondBoundsLayout.LayoutDirection.Companion companion = new BeyondBoundsLayout.LayoutDirection.Companion(0);
            BeyondBoundsLayout.LayoutDirection.Companion = companion;
            BeyondBoundsLayout.LayoutDirection.Before = BeyondBoundsLayout.LayoutDirection.constructor-impl(1);
            BeyondBoundsLayout.LayoutDirection.After = BeyondBoundsLayout.LayoutDirection.constructor-impl(2);
            BeyondBoundsLayout.LayoutDirection.Left = BeyondBoundsLayout.LayoutDirection.constructor-impl(3);
            BeyondBoundsLayout.LayoutDirection.Right = BeyondBoundsLayout.LayoutDirection.constructor-impl(4);
            BeyondBoundsLayout.LayoutDirection.Above = BeyondBoundsLayout.LayoutDirection.constructor-impl(5);
            BeyondBoundsLayout.LayoutDirection.Below = BeyondBoundsLayout.LayoutDirection.constructor-impl(6);
        }

        private LayoutDirection(int value) {
            super();
            this.value = value;
        }

        public static final int access$getAbove$cp() {
            return BeyondBoundsLayout.LayoutDirection.Above;
        }

        public static final int access$getAfter$cp() {
            return BeyondBoundsLayout.LayoutDirection.After;
        }

        public static final int access$getBefore$cp() {
            return BeyondBoundsLayout.LayoutDirection.Before;
        }

        public static final int access$getBelow$cp() {
            return BeyondBoundsLayout.LayoutDirection.Below;
        }

        public static final int access$getLeft$cp() {
            return BeyondBoundsLayout.LayoutDirection.Left;
        }

        public static final int access$getRight$cp() {
            return BeyondBoundsLayout.LayoutDirection.Right;
        }

        public static final androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection box-impl(int i) {
            BeyondBoundsLayout.LayoutDirection layoutDirection = new BeyondBoundsLayout.LayoutDirection(i);
            return layoutDirection;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof BeyondBoundsLayout.LayoutDirection) {
                return i3;
            }
            if (i != (BeyondBoundsLayout.LayoutDirection)object2.unbox-impl()) {
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

        public static String toString-impl(int arg0) {
            String str;
            str = BeyondBoundsLayout.LayoutDirection.equals-impl0(arg0, BeyondBoundsLayout.LayoutDirection.Before) ? "Before" : equals-impl02 ? "After" : equals-impl03 ? "Left" : equals-impl04 ? "Right" : equals-impl05 ? "Above" : equals-impl06 ? "Below" : "invalid LayoutDirection";
            return str;
        }

        public boolean equals(Object object) {
            return BeyondBoundsLayout.LayoutDirection.equals-impl(this.value, object);
        }

        public int hashCode() {
            return BeyondBoundsLayout.LayoutDirection.hashCode-impl(this.value);
        }

        public String toString() {
            return BeyondBoundsLayout.LayoutDirection.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    public abstract <T> T layout-o7g1Pn8(int i, Function1<? super androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function12);
}
