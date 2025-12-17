package androidx.compose.material3.internal;

import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u0008H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"ProvideContentColorTextStyle", "", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ProvideContentColorTextStyle-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProvideContentColorTextStyleKt {
    public static final void ProvideContentColorTextStyle-3J-VO9M(long contentColor, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int merge;
        int $dirty;
        int i4;
        int i;
        int i2;
        boolean traceInProgress2;
        boolean traceInProgress;
        int i3;
        long contentColor2;
        int str2;
        Object consume;
        Object obj;
        String str;
        Object obj2;
        int i5;
        merge = -716124955;
        final Composer obj12 = $changed.startRestartGroup(merge);
        ComposerKt.sourceInformation(obj12, "C(ProvideContentColorTextStyle)P(1:c#ui.graphics.Color,2)39@1423L7,40@1452L151:ProvideContentColorTextStyle.kt#mqatfk");
        i3 = 2;
        if (obj13 & 6 == 0) {
            i4 = obj12.changed(contentColor) ? 4 : i3;
            $dirty |= i4;
        }
        if (obj13 & 48 == 0) {
            i = obj12.changed(content) ? 32 : 16;
            $dirty |= i;
        }
        if (obj13 & 384 == 0) {
            i2 = obj12.changedInstance($composer) ? 256 : 128;
            $dirty |= i2;
        }
        if ($dirty & 147 == 146) {
            if (!obj12.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(merge, $dirty, -1, "androidx.compose.material3.internal.ProvideContentColorTextStyle (ProvideContentColorTextStyle.kt:38)");
                }
                int i6 = 6;
                int i7 = 0;
                ComposerKt.sourceInformationMarkerStart(obj12, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj12);
                ProvidedValue[] arr = new ProvidedValue[i3];
                arr[0] = ContentColorKt.getLocalContentColor().provides(Color.box-impl(contentColor));
                arr[1] = TextKt.getLocalTextStyle().provides((TextStyle)obj12.consume((CompositionLocal)TextKt.getLocalTextStyle()).merge(content));
                CompositionLocalKt.CompositionLocalProvider(arr, $composer, obj12, $stable |= str2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj12.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj12.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ProvideContentColorTextStyleKt.ProvideContentColorTextStyle.1(contentColor, str2, content, $composer, obj13);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            contentColor2 = contentColor;
            obj = content;
            obj2 = $composer;
            i5 = obj13;
        }
    }
}
