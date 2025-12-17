package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u00081\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u0008\u0010A\u001a\u00020BH\u0016R1\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R1\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u0014\"\u0004\u0008\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001f\u0010\u0018\u001a\u0004\u0008\u000f\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR1\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\"\u0010\u0018\u001a\u0004\u0008 \u0010\u0014\"\u0004\u0008!\u0010\u0016R1\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008%\u0010\u0018\u001a\u0004\u0008#\u0010\u0014\"\u0004\u0008$\u0010\u0016R1\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008(\u0010\u0018\u001a\u0004\u0008&\u0010\u0014\"\u0004\u0008'\u0010\u0016R1\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008+\u0010\u0018\u001a\u0004\u0008)\u0010\u0014\"\u0004\u0008*\u0010\u0016R1\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008.\u0010\u0018\u001a\u0004\u0008,\u0010\u0014\"\u0004\u0008-\u0010\u0016R1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00081\u0010\u0018\u001a\u0004\u0008/\u0010\u0014\"\u0004\u00080\u0010\u0016R1\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00084\u0010\u0018\u001a\u0004\u00082\u0010\u0014\"\u0004\u00083\u0010\u0016R1\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00087\u0010\u0018\u001a\u0004\u00085\u0010\u0014\"\u0004\u00086\u0010\u0016R1\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008:\u0010\u0018\u001a\u0004\u00088\u0010\u0014\"\u0004\u00089\u0010\u0016R1\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008=\u0010\u0018\u001a\u0004\u0008;\u0010\u0014\"\u0004\u0008<\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006C", d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Colors {

    public static final int $stable;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;
    static {
    }

    private Colors(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        super();
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(primary), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(secondary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(background), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(error), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(onSecondary), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(onSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(isLight), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(obj17), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(obj19), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(obj21), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(obj23), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(obj25), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(obj27), SnapshotStateKt.structuralEqualityPolicy());
    }

    public Colors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, boolean z13, DefaultConstructorMarker defaultConstructorMarker14) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, z13, defaultConstructorMarker14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25);
    }

    public static androidx.compose.material.Colors copy-pvPzIIM$default(androidx.compose.material.Colors colors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, boolean z14, int i15, Object object16) {
        boolean light;
        long primary-0d7_KjU;
        long onSecondary-0d7_KjU;
        long onBackground-0d7_KjU;
        long onSurface-0d7_KjU;
        long onError-0d7_KjU;
        long primaryVariant-0d7_KjU;
        long secondary-0d7_KjU;
        long secondaryVariant-0d7_KjU;
        long background-0d7_KjU;
        long surface-0d7_KjU;
        long error-0d7_KjU;
        long onPrimary-0d7_KjU;
        int i = obj45;
        if (i & 1 != 0) {
            primary-0d7_KjU = colors.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            primaryVariant-0d7_KjU = colors.getPrimaryVariant-0d7_KjU();
        } else {
            primaryVariant-0d7_KjU = l4;
        }
        if (i & 4 != 0) {
            secondary-0d7_KjU = colors.getSecondary-0d7_KjU();
        } else {
            secondary-0d7_KjU = l6;
        }
        if (i & 8 != 0) {
            secondaryVariant-0d7_KjU = colors.getSecondaryVariant-0d7_KjU();
        } else {
            secondaryVariant-0d7_KjU = l8;
        }
        if (i & 16 != 0) {
            background-0d7_KjU = colors.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = l10;
        }
        if (i & 32 != 0) {
            surface-0d7_KjU = colors.getSurface-0d7_KjU();
        } else {
            surface-0d7_KjU = l12;
        }
        if (i & 64 != 0) {
            error-0d7_KjU = colors.getError-0d7_KjU();
        } else {
            error-0d7_KjU = z14;
        }
        if (i & 128 != 0) {
            onPrimary-0d7_KjU = colors.getOnPrimary-0d7_KjU();
        } else {
            onPrimary-0d7_KjU = object16;
        }
        if (i & 256 != 0) {
            onSecondary-0d7_KjU = colors.getOnSecondary-0d7_KjU();
        } else {
            onSecondary-0d7_KjU = obj36;
        }
        if (i & 512 != 0) {
            onBackground-0d7_KjU = colors.getOnBackground-0d7_KjU();
        } else {
            onBackground-0d7_KjU = obj38;
        }
        final long obj22 = onBackground-0d7_KjU;
        if (i & 1024 != 0) {
            onSurface-0d7_KjU = colors.getOnSurface-0d7_KjU();
        } else {
            onSurface-0d7_KjU = obj40;
        }
        final long obj24 = onSurface-0d7_KjU;
        if (i & 2048 != 0) {
            onError-0d7_KjU = colors.getOnError-0d7_KjU();
        } else {
            onError-0d7_KjU = obj42;
        }
        if (i &= 4096 != 0) {
            light = colors.isLight();
        } else {
            light = obj44;
        }
        return colors.copy-pvPzIIM(primary-0d7_KjU, obj22, primaryVariant-0d7_KjU, obj24, secondary-0d7_KjU, l8, secondaryVariant-0d7_KjU, l10, background-0d7_KjU, l12, surface-0d7_KjU, z14, error-0d7_KjU);
    }

    public final androidx.compose.material.Colors copy-pvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        Colors colors = new Colors(primary, obj2, secondary, obj4, background, obj6, error, obj8, onSecondary, obj10, onSurface, obj12, isLight, obj14, obj42, obj16, obj44, obj18, obj46, obj20, obj48, obj22, obj50, obj24, obj52, 0);
        return colors;
    }

    public final long getBackground-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.background$delegate.getValue().unbox-impl();
    }

    public final long getError-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.error$delegate.getValue().unbox-impl();
    }

    public final long getOnBackground-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.onBackground$delegate.getValue().unbox-impl();
    }

    public final long getOnError-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.onError$delegate.getValue().unbox-impl();
    }

    public final long getOnPrimary-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.onPrimary$delegate.getValue().unbox-impl();
    }

    public final long getOnSecondary-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.onSecondary$delegate.getValue().unbox-impl();
    }

    public final long getOnSurface-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.onSurface$delegate.getValue().unbox-impl();
    }

    public final long getPrimary-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.primary$delegate.getValue().unbox-impl();
    }

    public final long getPrimaryVariant-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.primaryVariant$delegate.getValue().unbox-impl();
    }

    public final long getSecondary-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.secondary$delegate.getValue().unbox-impl();
    }

    public final long getSecondaryVariant-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.secondaryVariant$delegate.getValue().unbox-impl();
    }

    public final long getSurface-0d7_KjU() {
        final int i = 0;
        final int i2 = 0;
        return (Color)(State)this.surface$delegate.getValue().unbox-impl();
    }

    public final boolean isLight() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isLight$delegate.getValue().booleanValue();
    }

    public final void setBackground-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.background$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setError-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.error$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setLight$material_release(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isLight$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setOnBackground-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.onBackground$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setOnError-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.onError$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setOnPrimary-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.onPrimary$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setOnSecondary-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.onSecondary$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setOnSurface-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.onSurface$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setPrimary-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.primary$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setPrimaryVariant-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.primaryVariant$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setSecondary-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.secondary$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setSecondaryVariant-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.secondaryVariant$delegate.setValue(Color.box-impl(<set-?>));
    }

    public final void setSurface-8_81llA$material_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.surface$delegate.setValue(Color.box-impl(<set-?>));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str12 = ", onError=";
        stringBuilder.append("Colors(primary=").append(Color.toString-impl(getPrimary-0d7_KjU())).append(", primaryVariant=").append(Color.toString-impl(getPrimaryVariant-0d7_KjU())).append(", secondary=").append(Color.toString-impl(getSecondary-0d7_KjU())).append(", secondaryVariant=").append(Color.toString-impl(getSecondaryVariant-0d7_KjU())).append(", background=").append(Color.toString-impl(getBackground-0d7_KjU())).append(", surface=").append(Color.toString-impl(getSurface-0d7_KjU())).append(", error=").append(Color.toString-impl(getError-0d7_KjU())).append(", onPrimary=").append(Color.toString-impl(getOnPrimary-0d7_KjU())).append(", onSecondary=").append(Color.toString-impl(getOnSecondary-0d7_KjU())).append(", onBackground=").append(Color.toString-impl(getOnBackground-0d7_KjU())).append(", onSurface=").append(Color.toString-impl(getOnSurface-0d7_KjU())).append(str12);
        stringBuilder.append(Color.toString-impl(getOnError-0d7_KjU())).append(", isLight=").append(isLight()).append(')');
        return stringBuilder.toString();
    }
}
