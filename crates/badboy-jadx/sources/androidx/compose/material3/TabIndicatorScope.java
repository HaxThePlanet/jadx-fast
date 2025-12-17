package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008g\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u0003*\u00020\u00032/\u0010\u0004\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0008\u000cH&J\u001e\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/material3/TabIndicatorScope;", "", "tabIndicatorLayout", "Landroidx/compose/ui/Modifier;", "measure", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "", "Landroidx/compose/material3/TabPosition;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "tabIndicatorOffset", "selectedTabIndex", "", "matchContentSize", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TabIndicatorScope {
    public static Modifier tabIndicatorOffset$default(androidx.compose.material3.TabIndicatorScope tabIndicatorScope, Modifier modifier2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj3 = 0;
            }
            return tabIndicatorScope.tabIndicatorOffset(modifier2, i3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tabIndicatorOffset");
        throw obj0;
    }

    public abstract Modifier tabIndicatorLayout(Modifier modifier, Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super List<androidx.compose.material3.TabPosition>, ? extends MeasureResult> function42);

    public abstract Modifier tabIndicatorOffset(Modifier modifier, int i2, boolean z3);
}
