package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008`\u0018\u00002\u00020\u0001J\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0012\u0010\r\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\tR\u0018\u0010\u0014\u001a\u00020\u000bX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u000c\"\u0004\u0008\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\tR\u0012\u0010\u001a\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\tø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006'À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "index", "", "getIndex", "()I", "isVertical", "", "()Z", "key", "getKey", "()Ljava/lang/Object;", "lane", "getLane", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "placeablesCount", "getPlaceablesCount", "span", "getSpan", "getOffset", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-Bjo55l4", "(I)J", "getParentData", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyLayoutMeasuredItem {
    public abstract long getConstraints-msEJaDk();

    public abstract int getIndex();

    public abstract Object getKey();

    public abstract int getLane();

    public abstract int getMainAxisSizeWithSpacings();

    public abstract boolean getNonScrollableItem();

    public abstract long getOffset-Bjo55l4(int i);

    public abstract Object getParentData(int i);

    public abstract int getPlaceablesCount();

    public abstract int getSpan();

    public abstract boolean isVertical();

    public abstract void position(int i, int i2, int i3, int i4);

    public abstract void setNonScrollableItem(boolean z);
}
