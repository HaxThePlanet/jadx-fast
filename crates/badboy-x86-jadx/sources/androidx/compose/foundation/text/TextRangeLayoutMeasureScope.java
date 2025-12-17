package androidx.compose.foundation.text;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutMeasureScope;", "", "()V", "layout", "Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "width", "", "height", "place", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextRangeLayoutMeasureScope {

    public static final int $stable;
    static {
    }

    public final androidx.compose.foundation.text.TextRangeLayoutMeasureResult layout(int width, int height, Function0<IntOffset> place) {
        TextRangeLayoutMeasureResult textRangeLayoutMeasureResult = new TextRangeLayoutMeasureResult(width, height, place);
        return textRangeLayoutMeasureResult;
    }
}
