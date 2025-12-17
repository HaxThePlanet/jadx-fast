package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class BlendMode {

    private static final int Clear;
    private static final int Color;
    private static final int ColorBurn;
    private static final int ColorDodge;
    public static final androidx.compose.ui.graphics.BlendMode.Companion Companion;
    private static final int Darken;
    private static final int Difference;
    private static final int Dst;
    private static final int DstAtop;
    private static final int DstIn;
    private static final int DstOut;
    private static final int DstOver;
    private static final int Exclusion;
    private static final int Hardlight;
    private static final int Hue;
    private static final int Lighten;
    private static final int Luminosity;
    private static final int Modulate;
    private static final int Multiply;
    private static final int Overlay;
    private static final int Plus;
    private static final int Saturation;
    private static final int Screen;
    private static final int Softlight;
    private static final int Src;
    private static final int SrcAtop;
    private static final int SrcIn;
    private static final int SrcOut;
    private static final int SrcOver;
    private static final int Xor;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008<\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008#\u0010\u0006R\u0019\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008%\u0010\u0006R\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008+\u0010\u0006R\u0019\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008-\u0010\u0006R\u0019\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008/\u0010\u0006R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00081\u0010\u0006R\u0019\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00083\u0010\u0006R\u0019\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00085\u0010\u0006R\u0019\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00087\u0010\u0006R\u0019\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00089\u0010\u0006R\u0019\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008;\u0010\u0006R\u0019\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008=\u0010\u0006R\u0019\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008?\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006@", d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getClear-0nO6VwU() {
            return BlendMode.access$getClear$cp();
        }

        public final int getColor-0nO6VwU() {
            return BlendMode.access$getColor$cp();
        }

        public final int getColorBurn-0nO6VwU() {
            return BlendMode.access$getColorBurn$cp();
        }

        public final int getColorDodge-0nO6VwU() {
            return BlendMode.access$getColorDodge$cp();
        }

        public final int getDarken-0nO6VwU() {
            return BlendMode.access$getDarken$cp();
        }

        public final int getDifference-0nO6VwU() {
            return BlendMode.access$getDifference$cp();
        }

        public final int getDst-0nO6VwU() {
            return BlendMode.access$getDst$cp();
        }

        public final int getDstAtop-0nO6VwU() {
            return BlendMode.access$getDstAtop$cp();
        }

        public final int getDstIn-0nO6VwU() {
            return BlendMode.access$getDstIn$cp();
        }

        public final int getDstOut-0nO6VwU() {
            return BlendMode.access$getDstOut$cp();
        }

        public final int getDstOver-0nO6VwU() {
            return BlendMode.access$getDstOver$cp();
        }

        public final int getExclusion-0nO6VwU() {
            return BlendMode.access$getExclusion$cp();
        }

        public final int getHardlight-0nO6VwU() {
            return BlendMode.access$getHardlight$cp();
        }

        public final int getHue-0nO6VwU() {
            return BlendMode.access$getHue$cp();
        }

        public final int getLighten-0nO6VwU() {
            return BlendMode.access$getLighten$cp();
        }

        public final int getLuminosity-0nO6VwU() {
            return BlendMode.access$getLuminosity$cp();
        }

        public final int getModulate-0nO6VwU() {
            return BlendMode.access$getModulate$cp();
        }

        public final int getMultiply-0nO6VwU() {
            return BlendMode.access$getMultiply$cp();
        }

        public final int getOverlay-0nO6VwU() {
            return BlendMode.access$getOverlay$cp();
        }

        public final int getPlus-0nO6VwU() {
            return BlendMode.access$getPlus$cp();
        }

        public final int getSaturation-0nO6VwU() {
            return BlendMode.access$getSaturation$cp();
        }

        public final int getScreen-0nO6VwU() {
            return BlendMode.access$getScreen$cp();
        }

        public final int getSoftlight-0nO6VwU() {
            return BlendMode.access$getSoftlight$cp();
        }

        public final int getSrc-0nO6VwU() {
            return BlendMode.access$getSrc$cp();
        }

        public final int getSrcAtop-0nO6VwU() {
            return BlendMode.access$getSrcAtop$cp();
        }

        public final int getSrcIn-0nO6VwU() {
            return BlendMode.access$getSrcIn$cp();
        }

        public final int getSrcOut-0nO6VwU() {
            return BlendMode.access$getSrcOut$cp();
        }

        public final int getSrcOver-0nO6VwU() {
            return BlendMode.access$getSrcOver$cp();
        }

        public final int getXor-0nO6VwU() {
            return BlendMode.access$getXor$cp();
        }
    }
    static {
        BlendMode.Companion companion = new BlendMode.Companion(0);
        BlendMode.Companion = companion;
        BlendMode.Clear = BlendMode.constructor-impl(0);
        BlendMode.Src = BlendMode.constructor-impl(1);
        BlendMode.Dst = BlendMode.constructor-impl(2);
        BlendMode.SrcOver = BlendMode.constructor-impl(3);
        BlendMode.DstOver = BlendMode.constructor-impl(4);
        BlendMode.SrcIn = BlendMode.constructor-impl(5);
        BlendMode.DstIn = BlendMode.constructor-impl(6);
        BlendMode.SrcOut = BlendMode.constructor-impl(7);
        BlendMode.DstOut = BlendMode.constructor-impl(8);
        BlendMode.SrcAtop = BlendMode.constructor-impl(9);
        BlendMode.DstAtop = BlendMode.constructor-impl(10);
        BlendMode.Xor = BlendMode.constructor-impl(11);
        BlendMode.Plus = BlendMode.constructor-impl(12);
        BlendMode.Modulate = BlendMode.constructor-impl(13);
        BlendMode.Screen = BlendMode.constructor-impl(14);
        BlendMode.Overlay = BlendMode.constructor-impl(15);
        BlendMode.Darken = BlendMode.constructor-impl(16);
        BlendMode.Lighten = BlendMode.constructor-impl(17);
        BlendMode.ColorDodge = BlendMode.constructor-impl(18);
        BlendMode.ColorBurn = BlendMode.constructor-impl(19);
        BlendMode.Hardlight = BlendMode.constructor-impl(20);
        BlendMode.Softlight = BlendMode.constructor-impl(21);
        BlendMode.Difference = BlendMode.constructor-impl(22);
        BlendMode.Exclusion = BlendMode.constructor-impl(23);
        BlendMode.Multiply = BlendMode.constructor-impl(24);
        BlendMode.Hue = BlendMode.constructor-impl(25);
        BlendMode.Saturation = BlendMode.constructor-impl(26);
        BlendMode.Color = BlendMode.constructor-impl(27);
        BlendMode.Luminosity = BlendMode.constructor-impl(28);
    }

    private BlendMode(int value) {
        super();
        this.value = value;
    }

    public static final int access$getClear$cp() {
        return BlendMode.Clear;
    }

    public static final int access$getColor$cp() {
        return BlendMode.Color;
    }

    public static final int access$getColorBurn$cp() {
        return BlendMode.ColorBurn;
    }

    public static final int access$getColorDodge$cp() {
        return BlendMode.ColorDodge;
    }

    public static final int access$getDarken$cp() {
        return BlendMode.Darken;
    }

    public static final int access$getDifference$cp() {
        return BlendMode.Difference;
    }

    public static final int access$getDst$cp() {
        return BlendMode.Dst;
    }

    public static final int access$getDstAtop$cp() {
        return BlendMode.DstAtop;
    }

    public static final int access$getDstIn$cp() {
        return BlendMode.DstIn;
    }

    public static final int access$getDstOut$cp() {
        return BlendMode.DstOut;
    }

    public static final int access$getDstOver$cp() {
        return BlendMode.DstOver;
    }

    public static final int access$getExclusion$cp() {
        return BlendMode.Exclusion;
    }

    public static final int access$getHardlight$cp() {
        return BlendMode.Hardlight;
    }

    public static final int access$getHue$cp() {
        return BlendMode.Hue;
    }

    public static final int access$getLighten$cp() {
        return BlendMode.Lighten;
    }

    public static final int access$getLuminosity$cp() {
        return BlendMode.Luminosity;
    }

    public static final int access$getModulate$cp() {
        return BlendMode.Modulate;
    }

    public static final int access$getMultiply$cp() {
        return BlendMode.Multiply;
    }

    public static final int access$getOverlay$cp() {
        return BlendMode.Overlay;
    }

    public static final int access$getPlus$cp() {
        return BlendMode.Plus;
    }

    public static final int access$getSaturation$cp() {
        return BlendMode.Saturation;
    }

    public static final int access$getScreen$cp() {
        return BlendMode.Screen;
    }

    public static final int access$getSoftlight$cp() {
        return BlendMode.Softlight;
    }

    public static final int access$getSrc$cp() {
        return BlendMode.Src;
    }

    public static final int access$getSrcAtop$cp() {
        return BlendMode.SrcAtop;
    }

    public static final int access$getSrcIn$cp() {
        return BlendMode.SrcIn;
    }

    public static final int access$getSrcOut$cp() {
        return BlendMode.SrcOut;
    }

    public static final int access$getSrcOver$cp() {
        return BlendMode.SrcOver;
    }

    public static final int access$getXor$cp() {
        return BlendMode.Xor;
    }

    public static final androidx.compose.ui.graphics.BlendMode box-impl(int i) {
        BlendMode blendMode = new BlendMode(i);
        return blendMode;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof BlendMode) {
            return i3;
        }
        if (i != (BlendMode)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int arg0) {
        String str;
        str = BlendMode.equals-impl0(arg0, BlendMode.Clear) ? "Clear" : equals-impl02 ? "Src" : equals-impl03 ? "Dst" : equals-impl04 ? "SrcOver" : equals-impl05 ? "DstOver" : equals-impl06 ? "SrcIn" : equals-impl07 ? "DstIn" : equals-impl08 ? "SrcOut" : equals-impl09 ? "DstOut" : equals-impl010 ? "SrcAtop" : equals-impl011 ? "DstAtop" : equals-impl012 ? "Xor" : equals-impl013 ? "Plus" : equals-impl014 ? "Modulate" : equals-impl015 ? "Screen" : equals-impl016 ? "Overlay" : equals-impl017 ? "Darken" : equals-impl018 ? "Lighten" : equals-impl019 ? "ColorDodge" : equals-impl020 ? "ColorBurn" : equals-impl021 ? "HardLight" : equals-impl022 ? "Softlight" : equals-impl023 ? "Difference" : equals-impl024 ? "Exclusion" : equals-impl025 ? "Multiply" : equals-impl026 ? "Hue" : equals-impl027 ? "Saturation" : equals-impl028 ? "Color" : equals-impl029 ? "Luminosity" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return BlendMode.equals-impl(this.value, object);
    }

    public int hashCode() {
        return BlendMode.hashCode-impl(this.value);
    }

    public String toString() {
        return BlendMode.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
