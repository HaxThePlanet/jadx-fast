package androidx.compose.foundation.text;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a(\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\u000cX\u008a\u0084\u0002", d2 = {"DefaultMinLines", "", "validateMinMaxLines", "", "minLines", "maxLines", "heightInLines", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "foundation_release", "typeface", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HeightInLinesModifierKt {

    public static final int DefaultMinLines = 1;
    public static final Modifier heightInLines(Modifier $this$heightInLines, TextStyle textStyle, int minLines, int maxLines) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new HeightInLinesModifierKt.heightInLines$$inlined.debugInspectorInfo.1(minLines, maxLines, textStyle);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        HeightInLinesModifierKt.heightInLines.2 $i$f$debugInspectorInfo = new HeightInLinesModifierKt.heightInLines.2(minLines, maxLines, textStyle);
        return ComposedModifierKt.composed($this$heightInLines, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier heightInLines$default(Modifier modifier, TextStyle textStyle2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 1;
        }
        if (i5 &= 4 != 0) {
            obj3 = Integer.MAX_VALUE;
        }
        return HeightInLinesModifierKt.heightInLines(modifier, textStyle2, obj2, obj3);
    }

    public static final void validateMinMaxLines(int minLines, int maxLines) {
        int i;
        int i2;
        int i5 = 0;
        if (minLines > 0 && maxLines > 0) {
            i2 = maxLines > 0 ? i : i5;
        } else {
        }
        if (i2 == 0) {
        } else {
            if (minLines <= maxLines) {
            } else {
                i = i5;
            }
            if (i == 0) {
            } else {
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("minLines ").append(minLines).append(" must be less than or equal to maxLines ").append(maxLines).toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("both minLines ").append(minLines).append(" and maxLines ").append(maxLines).append(" must be greater than zero").toString().toString());
        throw illegalArgumentException;
    }
}
