package androidx.compose.foundation.text;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B%\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\n¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "", "width", "", "height", "place", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "(IILkotlin/jvm/functions/Function0;)V", "getHeight", "()I", "getPlace", "()Lkotlin/jvm/functions/Function0;", "getWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextRangeLayoutMeasureResult {

    public static final int $stable;
    private final int height;
    private final Function0<IntOffset> place;
    private final int width;
    static {
    }

    public TextRangeLayoutMeasureResult(int width, int height, Function0<IntOffset> place) {
        super();
        this.width = width;
        this.height = height;
        this.place = place;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Function0<IntOffset> getPlace() {
        return this.place;
    }

    public final int getWidth() {
        return this.width;
    }
}
