package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlaceholderVerticalAlign.Companion;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00088BX\u0082\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderExtensions_androidKt {
    private static final int getSpanUnit--R2X_6o(long $this$spanUnit) {
        int i;
        boolean em-UIouoOA;
        long type-UIouoOA = TextUnit.getType-UIouoOA($this$spanUnit);
        i = TextUnitType.equals-impl0(type-UIouoOA, obj1) ? 0 : equals-impl0 ? 1 : 2;
        return i;
    }

    private static void getSpanUnit--R2X_6o$annotations(long l) {
    }

    private static final int getSpanVerticalAlign-do9X-Gg(int $this$spanVerticalAlign) {
        int i;
        if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getAboveBaseline-J6kI3mc())) {
            i = 0;
            return i;
        } else {
            if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getTop-J6kI3mc())) {
                i = 1;
            } else {
                if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getBottom-J6kI3mc())) {
                    i = 2;
                } else {
                    if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc())) {
                        i = 3;
                    } else {
                        if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getTextTop-J6kI3mc())) {
                            i = 4;
                        } else {
                            if (PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getTextBottom-J6kI3mc())) {
                                i = 5;
                            } else {
                                if (!PlaceholderVerticalAlign.equals-impl0($this$spanVerticalAlign, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc())) {
                                } else {
                                    i = 6;
                                }
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
        throw illegalStateException;
    }

    private static void getSpanVerticalAlign-do9X-Gg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable $this$setPlaceholder, Placeholder placeholder, int start, int end, Density density) {
        int i;
        long l3;
        long l2;
        long l;
        Object[] spans = $this$setPlaceholder.getSpans(start, end, EmojiSpan.class);
        int i2 = 0;
        i = 0;
        while (i < spans.length) {
            l = 0;
            $this$setPlaceholder.removeSpan((EmojiSpan)spans[i]);
            i++;
        }
        Object obj2 = placeholder;
        int i3 = 0;
        PlaceholderSpan placeholderSpan = new PlaceholderSpan(TextUnit.getValue-impl(obj2.getWidth-XSAIIZE()), PlaceholderExtensions_androidKt.getSpanUnit--R2X_6o(obj2.getWidth-XSAIIZE()), TextUnit.getValue-impl(obj2.getHeight-XSAIIZE()), PlaceholderExtensions_androidKt.getSpanUnit--R2X_6o(obj2.getHeight-XSAIIZE()), fontScale *= density2, PlaceholderExtensions_androidKt.getSpanVerticalAlign-do9X-Gg(obj2.getPlaceholderVerticalAlign-J6kI3mc()));
        SpannableExtensions_androidKt.setSpan($this$setPlaceholder, placeholderSpan, start, end);
    }

    public static final void setPlaceholders(Spannable $this$setPlaceholders, List<AnnotatedString.Range<Placeholder>> placeholders, Density density) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        Object component1;
        int component2;
        int component3;
        final Object obj3 = placeholders;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj = obj2;
            i = 0;
            PlaceholderExtensions_androidKt.setPlaceholder($this$setPlaceholders, (Placeholder)(AnnotatedString.Range)obj.component1(), obj.component2(), obj.component3(), density);
            index$iv++;
        }
    }
}
