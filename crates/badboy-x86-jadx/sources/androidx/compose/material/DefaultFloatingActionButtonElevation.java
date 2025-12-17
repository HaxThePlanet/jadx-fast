package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0017¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultFloatingActionButtonElevation implements androidx.compose.material.FloatingActionButtonElevation {

    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    private DefaultFloatingActionButtonElevation(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
    }

    public DefaultFloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, f3, f4);
    }

    public static final float access$getDefaultElevation$p(androidx.compose.material.DefaultFloatingActionButtonElevation $this) {
        return $this.defaultElevation;
    }

    public static final float access$getFocusedElevation$p(androidx.compose.material.DefaultFloatingActionButtonElevation $this) {
        return $this.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(androidx.compose.material.DefaultFloatingActionButtonElevation $this) {
        return $this.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(androidx.compose.material.DefaultFloatingActionButtonElevation $this) {
        return $this.pressedElevation;
    }

    public State<Dp> elevation(InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed3;
        int i2;
        boolean traceInProgress;
        int changed;
        String pressedElevation;
        int i5;
        int i3;
        float hoveredElevation;
        int changed2;
        int i;
        int focusedElevation;
        int empty;
        Object empty2;
        Object anon2;
        Object empty3;
        Object anon;
        Object floatingActionButtonElevationAnimatable;
        float defaultElevation;
        float f;
        float f3;
        float f2;
        int i4;
        final Object obj = this;
        final Object obj2 = interactionSource;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i7 = -478475335;
        composer.startReplaceGroup(i7);
        ComposerKt.sourceInformation(composer, "C(elevation)272@11455L317,281@11803L276,281@11782L297,290@12123L1318,290@12089L1352:FloatingActionButton.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:271)");
        }
        String str2 = "CC(remember):FloatingActionButton.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, -1395508928, str2);
        focusedElevation = 4;
        if (i9 ^= 6 > focusedElevation) {
            if (!composer.changed(obj2)) {
                i2 = i6 & 6 == focusedElevation ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer4 = $composer;
        int i23 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        empty2 = 0;
        if (i2 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty3 = 0;
                floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(obj.defaultElevation, obj.pressedElevation, obj.hoveredElevation, obj.focusedElevation, 0);
                composer4.updateRememberedValue(floatingActionButtonElevationAnimatable);
            } else {
                floatingActionButtonElevationAnimatable = rememberedValue3;
            }
        } else {
        }
        Object invalid$iv = floatingActionButtonElevationAnimatable;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1395497833, str2);
        int i20 = 32;
        if (i18 ^= 48 > i20) {
            if (!composer.changed(obj)) {
                i = i6 & 48 == i20 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i21 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        empty = 0;
        int i24 = 0;
        if (changedInstance2 |= i == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new DefaultFloatingActionButtonElevation.elevation.1.1(invalid$iv, obj, i24);
                composer3.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(obj, (Function2)anon, composer, i15 &= 14);
        ComposerKt.sourceInformationMarkerStart(composer, -1395486551, str2);
        if (i10 ^= 6 > 4) {
            if (!composer.changed(obj2)) {
                i3 = i6 & 6 == 4 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i19 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i22 = 0;
        if (changedInstance |= i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon2 = new DefaultFloatingActionButtonElevation.elevation.2.1(obj2, invalid$iv, i24);
                composer2.updateRememberedValue((Function2)anon2);
            } else {
                anon2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(obj2, (Function2)anon2, composer, i6 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return invalid$iv.asState();
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        int i2 = 0;
        if (!other instanceof DefaultFloatingActionButtonElevation) {
            return i2;
        }
        if (!Dp.equals-impl0(this.defaultElevation, obj2.defaultElevation)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.pressedElevation, obj3.pressedElevation)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.hoveredElevation, obj4.hoveredElevation)) {
            return i2;
        }
        return Dp.equals-impl0(this.focusedElevation, obj.focusedElevation);
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public int hashCode() {
        return result2 += i8;
    }
}
