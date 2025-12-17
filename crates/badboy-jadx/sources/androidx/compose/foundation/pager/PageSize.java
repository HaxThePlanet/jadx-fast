package androidx.compose.foundation.pager;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001:\u0002\u0007\u0008J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/pager/PageSize;", "", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "availableSpace", "pageSpacing", "Fill", "Fixed", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PageSize {

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/pager/PageSize$Fill;", "Landroidx/compose/foundation/pager/PageSize;", "()V", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "availableSpace", "pageSpacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Fill implements androidx.compose.foundation.pager.PageSize {

        public static final int $stable;
        public static final androidx.compose.foundation.pager.PageSize.Fill INSTANCE;
        static {
            PageSize.Fill fill = new PageSize.Fill();
            PageSize.Fill.INSTANCE = fill;
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(Density $this$calculateMainAxisPageSize, int availableSpace, int pageSpacing) {
            return availableSpace;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/pager/PageSize$Fixed;", "Landroidx/compose/foundation/pager/PageSize;", "pageSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPageSize-D9Ej5fM", "()F", "F", "equals", "", "other", "", "hashCode", "", "calculateMainAxisPageSize", "Landroidx/compose/ui/unit/Density;", "availableSpace", "pageSpacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Fixed implements androidx.compose.foundation.pager.PageSize {

        public static final int $stable;
        private final float pageSize;
        static {
        }

        private Fixed(float pageSize) {
            super();
            this.pageSize = pageSize;
        }

        public Fixed(float f, DefaultConstructorMarker defaultConstructorMarker2) {
            super(f);
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(Density $this$calculateMainAxisPageSize, int availableSpace, int pageSpacing) {
            return $this$calculateMainAxisPageSize.roundToPx-0680j_4(this.pageSize);
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public boolean equals(Object other) {
            if (this == other) {
                return 1;
            }
            if (!other instanceof PageSize.Fixed) {
                return 0;
            }
            return Dp.equals-impl0(this.pageSize, obj.pageSize);
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public final float getPageSize-D9Ej5fM() {
            return this.pageSize;
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int hashCode() {
            return Dp.hashCode-impl(this.pageSize);
        }
    }
    public abstract int calculateMainAxisPageSize(Density density, int i2, int i3);
}
