package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Connector;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008 \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\"\u0010\u000bJ\u0010\u0010#\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008$\u0010\u000bJ\u0010\u0010%\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\u0008&\u0010\u0013J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J=\u0010*\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u001a\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u00080\u00101J\u0010\u00102\u001a\u000203HÖ\u0001¢\u0006\u0004\u00084\u00105J\u000f\u00106\u001a\u000207H\u0016¢\u0006\u0004\u00088\u00109R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0011\u0010\t\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\t\u001a\u0004\u0008\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\t\u001a\u0004\u0008\u0019\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\u0008\u001a\u0010\u001b\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006;", d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Color {

    private static final long Black;
    private static final long Blue;
    public static final androidx.compose.ui.graphics.Color.Companion Companion;
    private static final long Cyan;
    private static final long DarkGray;
    private static final long Gray;
    private static final long Green;
    private static final long LightGray;
    private static final long Magenta;
    private static final long Red;
    private static final long Transparent;
    private static final long Unspecified;
    private static final long White;
    private static final long Yellow;
    private final long value;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008*\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J?\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020/2\u0008\u0008\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00085\u00106J(\u00107\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020/H\u0002J?\u0010=\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010>\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020/2\u0008\u0008\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008?\u00106J(\u0010@\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0019\u0010\u0002\u001a\u0004\u0008\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001c\u0010\u0002\u001a\u0004\u0008\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u0007R$\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\"\u0010\u0002\u001a\u0004\u0008#\u0010\u0007R$\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008%\u0010\u0002\u001a\u0004\u0008&\u0010\u0007R$\u0010'\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008(\u0010\u0002\u001a\u0004\u0008)\u0010\u0007R$\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008+\u0010\u0002\u001a\u0004\u0008,\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006B", d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", "v", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getBlack-0d7_KjU$annotations() {
        }

        public static void getBlue-0d7_KjU$annotations() {
        }

        public static void getCyan-0d7_KjU$annotations() {
        }

        public static void getDarkGray-0d7_KjU$annotations() {
        }

        public static void getGray-0d7_KjU$annotations() {
        }

        public static void getGreen-0d7_KjU$annotations() {
        }

        public static void getLightGray-0d7_KjU$annotations() {
        }

        public static void getMagenta-0d7_KjU$annotations() {
        }

        public static void getRed-0d7_KjU$annotations() {
        }

        public static void getTransparent-0d7_KjU$annotations() {
        }

        public static void getUnspecified-0d7_KjU$annotations() {
        }

        public static void getWhite-0d7_KjU$annotations() {
        }

        public static void getYellow-0d7_KjU$annotations() {
        }

        public static long hsl-JlNiLsg$default(androidx.compose.ui.graphics.Color.Companion color$Companion, float f2, float f3, float f4, float f5, Rgb rgb6, int i7, Object object8) {
            int i;
            Rgb rgb;
            int obj10;
            Rgb obj11;
            i = i7 & 8 != 0 ? obj10 : f5;
            if (i7 & 16 != 0) {
                rgb = obj11;
            } else {
                rgb = rgb6;
            }
            return companion.hsl-JlNiLsg(f2, f3, f4, i, rgb);
        }

        private final float hslToRgbComponent(int n, float h, float s, float l) {
            i %= i5;
            int i6 = 1065353216;
            return l - i7;
        }

        public static long hsv-JlNiLsg$default(androidx.compose.ui.graphics.Color.Companion color$Companion, float f2, float f3, float f4, float f5, Rgb rgb6, int i7, Object object8) {
            int i;
            Rgb rgb;
            int obj10;
            Rgb obj11;
            i = i7 & 8 != 0 ? obj10 : f5;
            if (i7 & 16 != 0) {
                rgb = obj11;
            } else {
                rgb = rgb6;
            }
            return companion.hsv-JlNiLsg(f2, f3, f4, i, rgb);
        }

        private final float hsvToRgbComponent(int n, float h, float s, float v) {
            i %= i5;
            return v - i7;
        }

        public final long getBlack-0d7_KjU() {
            return Color.access$getBlack$cp();
        }

        public final long getBlue-0d7_KjU() {
            return Color.access$getBlue$cp();
        }

        public final long getCyan-0d7_KjU() {
            return Color.access$getCyan$cp();
        }

        public final long getDarkGray-0d7_KjU() {
            return Color.access$getDarkGray$cp();
        }

        public final long getGray-0d7_KjU() {
            return Color.access$getGray$cp();
        }

        public final long getGreen-0d7_KjU() {
            return Color.access$getGreen$cp();
        }

        public final long getLightGray-0d7_KjU() {
            return Color.access$getLightGray$cp();
        }

        public final long getMagenta-0d7_KjU() {
            return Color.access$getMagenta$cp();
        }

        public final long getRed-0d7_KjU() {
            return Color.access$getRed$cp();
        }

        public final long getTransparent-0d7_KjU() {
            return Color.access$getTransparent$cp();
        }

        public final long getUnspecified-0d7_KjU() {
            return Color.access$getUnspecified$cp();
        }

        public final long getWhite-0d7_KjU() {
            return Color.access$getWhite$cp();
        }

        public final long getYellow-0d7_KjU() {
            return Color.access$getYellow$cp();
        }

        public final long hsl-JlNiLsg(float hue, float saturation, float lightness, float alpha, Rgb colorSpace) {
            int i;
            int cmp;
            int cmp3;
            int $i$a$RequirePreconditionColor$Companion$hsl$1;
            int cmp2;
            int i2;
            int append;
            String str;
            i = 0;
            i2 = 1;
            int i8 = 0;
            if (Float.compare(i, hue) <= 0 && Float.compare(hue, i4) <= 0) {
                $i$a$RequirePreconditionColor$Companion$hsl$1 = Float.compare(hue, i4) <= 0 ? i2 : i8;
            } else {
            }
            if ($i$a$RequirePreconditionColor$Companion$hsl$1 != 0) {
                append = 1065353216;
                if (Float.compare(i, saturation) <= 0 && Float.compare(saturation, append) <= 0) {
                    $i$a$RequirePreconditionColor$Companion$hsl$1 = Float.compare(saturation, append) <= 0 ? i2 : i8;
                } else {
                }
                if ($i$a$RequirePreconditionColor$Companion$hsl$1 != 0) {
                    if (Float.compare(i, lightness) <= 0 && Float.compare(lightness, append) <= 0) {
                        i = Float.compare(lightness, append) <= 0 ? i2 : i8;
                    } else {
                    }
                    if (i != 0) {
                    } else {
                        i2 = i8;
                    }
                } else {
                }
            } else {
            }
            int i3 = 0;
            if (i2 == 0) {
                int i5 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = ", ";
                InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("HSL (").append(hue).append(str3).append(saturation).append(str3).append(lightness).append(") must be in range (0..360, 0..1, 0..1)").toString());
            }
            return ColorKt.Color(hslToRgbComponent(i8, hue, saturation, lightness), hslToRgbComponent(8, hue, saturation, lightness), hslToRgbComponent(4, hue, saturation, lightness), alpha, (ColorSpace)colorSpace);
        }

        public final long hsv-JlNiLsg(float hue, float saturation, float value, float alpha, Rgb colorSpace) {
            int i;
            int cmp2;
            int cmp;
            int $i$a$RequirePreconditionColor$Companion$hsv$1;
            int cmp3;
            int i2;
            int append;
            String str;
            i = 0;
            int i7 = 1;
            i2 = 0;
            if (Float.compare(i, hue) <= 0 && Float.compare(hue, i4) <= 0) {
                $i$a$RequirePreconditionColor$Companion$hsv$1 = Float.compare(hue, i4) <= 0 ? i7 : i2;
            } else {
            }
            if ($i$a$RequirePreconditionColor$Companion$hsv$1 != 0) {
                append = 1065353216;
                if (Float.compare(i, saturation) <= 0 && Float.compare(saturation, append) <= 0) {
                    $i$a$RequirePreconditionColor$Companion$hsv$1 = Float.compare(saturation, append) <= 0 ? i7 : i2;
                } else {
                }
                if ($i$a$RequirePreconditionColor$Companion$hsv$1 != 0) {
                    if (Float.compare(i, value) <= 0 && Float.compare(value, append) <= 0) {
                        i = Float.compare(value, append) <= 0 ? i7 : i2;
                    } else {
                    }
                    if (i != 0) {
                        i2 = i7;
                    }
                }
            }
            int i3 = 0;
            if (i2 == 0) {
                int i5 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = ", ";
                InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("HSV (").append(hue).append(str3).append(saturation).append(str3).append(value).append(") must be in range (0..360, 0..1, 0..1)").toString());
            }
            return ColorKt.Color(hsvToRgbComponent(5, hue, saturation, value), hsvToRgbComponent(3, hue, saturation, value), hsvToRgbComponent(i7, hue, saturation, value), alpha, (ColorSpace)colorSpace);
        }
    }
    static {
        int i2 = 0;
        Color.Companion companion = new Color.Companion(i2);
        Color.Companion = companion;
        Color.Black = ColorKt.Color(4278190080L);
        Color.DarkGray = ColorKt.Color(4282664004L);
        Color.Gray = ColorKt.Color(4287137928L);
        Color.LightGray = ColorKt.Color(4291611852L);
        Color.White = ColorKt.Color(4294967295L);
        Color.Red = ColorKt.Color(4294901760L);
        Color.Green = ColorKt.Color(4278255360L);
        Color.Blue = ColorKt.Color(4278190335L);
        Color.Yellow = ColorKt.Color(4294967040L);
        Color.Cyan = ColorKt.Color(4278255615L);
        Color.Magenta = ColorKt.Color(4294902015L);
        Color.Transparent = ColorKt.Color(0);
        int i3 = 0;
        Color.Unspecified = ColorKt.Color(i3, i3, i3, i3, (ColorSpace)ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());
    }

    private Color(long value) {
        super();
        this.value = value;
    }

    public static final long access$getBlack$cp() {
        return Color.Black;
    }

    public static final long access$getBlue$cp() {
        return Color.Blue;
    }

    public static final long access$getCyan$cp() {
        return Color.Cyan;
    }

    public static final long access$getDarkGray$cp() {
        return Color.DarkGray;
    }

    public static final long access$getGray$cp() {
        return Color.Gray;
    }

    public static final long access$getGreen$cp() {
        return Color.Green;
    }

    public static final long access$getLightGray$cp() {
        return Color.LightGray;
    }

    public static final long access$getMagenta$cp() {
        return Color.Magenta;
    }

    public static final long access$getRed$cp() {
        return Color.Red;
    }

    public static final long access$getTransparent$cp() {
        return Color.Transparent;
    }

    public static final long access$getUnspecified$cp() {
        return Color.Unspecified;
    }

    public static final long access$getWhite$cp() {
        return Color.White;
    }

    public static final long access$getYellow$cp() {
        return Color.Yellow;
    }

    public static final androidx.compose.ui.graphics.Color box-impl(long l) {
        Color color = new Color(l, obj2);
        return color;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return Color.getRed-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return Color.getGreen-impl(arg0);
    }

    public static final float component3-impl(long arg0) {
        final int i = 0;
        return Color.getBlue-impl(arg0);
    }

    public static final float component4-impl(long arg0) {
        final int i = 0;
        return Color.getAlpha-impl(arg0);
    }

    public static final ColorSpace component5-impl(long arg0) {
        final int i = 0;
        return Color.getColorSpace-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long convert-vNxB06k(long arg0, ColorSpace colorSpace) {
        return ColorSpaceKt.connect-YBCOT_4$default(Color.getColorSpace-impl(arg0), obj6, 0, 2, 0).transformToColor-l2rxGTc$ui_graphics_release(arg0);
    }

    public static final long copy-wmQWz5c(long arg0, float alpha, float red, float green, float blue) {
        return ColorKt.Color(green, blue, obj7, red, Color.getColorSpace-impl(arg0));
    }

    public static long copy-wmQWz5c$default(long l, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float f;
        float f7;
        float f6;
        float f8;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        if (object7 & 1 != 0) {
            f = obj8;
        } else {
            f = f3;
        }
        if (object7 & 2 != 0) {
            f7 = obj9;
        } else {
            f7 = f4;
        }
        if (object7 & 4 != 0) {
            f6 = obj10;
        } else {
            f6 = f5;
        }
        if (object7 & 8 != 0) {
            f8 = obj11;
        } else {
            f8 = i6;
        }
        return Color.copy-wmQWz5c(l, obj1, f, f7, f6);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof Color) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        return ULong.equals-impl0(l, l2);
    }

    public static void getAlpha$annotations() {
    }

    public static final float getAlpha-impl(long arg0) {
        int i2;
        int i;
        int i3;
        if (Long.compare(constructor-impl, i12) == 0) {
            f /= i;
        } else {
            f2 /= i;
        }
        return i2;
    }

    public static void getBlue$annotations() {
    }

    public static final float getBlue-impl(long arg0) {
        int h$iv;
        int i5;
        int i;
        int i2;
        int i6;
        int i3;
        int o$iv;
        int i4;
        int outE$iv;
        int outM$iv;
        int $i$f$floatFromBits;
        if (Long.compare(constructor-impl, i16) == 0) {
            f /= i5;
        } else {
            i5 = 0;
            i18 &= s;
            i19 &= i;
            i3 = 31;
            i20 &= i3;
            i4 = i & 1023;
            outE$iv = 0;
            outM$iv = 0;
            if (i6 == 0) {
                if (i4 != 0) {
                    int i25 = 0;
                    bits$iv$iv -= $i$f$floatFromBits;
                    h$iv = i2 == 0 ? o$iv : $i$f$floatFromBits;
                } else {
                    int i27 = 0;
                    h$iv = $i$f$floatFromBits;
                }
            } else {
                outM$iv = i4 << 13;
                if (i6 == i3) {
                    outE$iv = 255;
                    if (outM$iv != 0) {
                        outM$iv |= i3;
                    }
                } else {
                    outE$iv = i3 + 127;
                }
            }
        }
        return h$iv;
    }

    public static void getColorSpace$annotations() {
    }

    public static final ColorSpace getColorSpace-impl(long arg0) {
        final int i4 = 0;
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int)constructor-impl];
    }

    public static void getGreen$annotations() {
    }

    public static final float getGreen-impl(long arg0) {
        int h$iv;
        int i5;
        int i2;
        int i3;
        int i6;
        int i4;
        int o$iv;
        int i;
        int outE$iv;
        int outM$iv;
        int $i$f$floatFromBits;
        if (Long.compare(constructor-impl, i16) == 0) {
            f /= i5;
        } else {
            i5 = 0;
            i18 &= s;
            i19 &= i2;
            i4 = 31;
            i20 &= i4;
            i = i2 & 1023;
            outE$iv = 0;
            outM$iv = 0;
            if (i6 == 0) {
                if (i != 0) {
                    int i25 = 0;
                    bits$iv$iv -= $i$f$floatFromBits;
                    h$iv = i3 == 0 ? o$iv : $i$f$floatFromBits;
                } else {
                    int i27 = 0;
                    h$iv = $i$f$floatFromBits;
                }
            } else {
                outM$iv = i << 13;
                if (i6 == i4) {
                    outE$iv = 255;
                    if (outM$iv != 0) {
                        outM$iv |= i4;
                    }
                } else {
                    outE$iv = i4 + 127;
                }
            }
        }
        return h$iv;
    }

    public static void getRed$annotations() {
    }

    public static final float getRed-impl(long arg0) {
        int h$iv;
        int i4;
        int i;
        int i2;
        int i5;
        int i3;
        int o$iv;
        int i6;
        int outE$iv;
        int outM$iv;
        int $i$f$floatFromBits;
        int i14 = 48;
        if (Long.compare(constructor-impl, i15) == 0) {
            f /= i4;
        } else {
            i4 = 0;
            i17 &= s;
            i18 &= i;
            i3 = 31;
            i19 &= i3;
            i6 = i & 1023;
            outE$iv = 0;
            outM$iv = 0;
            if (i5 == 0) {
                if (i6 != 0) {
                    int i24 = 0;
                    bits$iv$iv -= $i$f$floatFromBits;
                    h$iv = i2 == 0 ? o$iv : $i$f$floatFromBits;
                } else {
                    int i26 = 0;
                    h$iv = $i$f$floatFromBits;
                }
            } else {
                outM$iv = i6 << 13;
                if (i5 == i3) {
                    outE$iv = 255;
                    if (outM$iv != 0) {
                        outM$iv |= i3;
                    }
                } else {
                    outE$iv = i3 + 127;
                }
            }
        }
        return h$iv;
    }

    public static int hashCode-impl(long l) {
        return ULong.hashCode-impl(l);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", ";
        return stringBuilder.append("Color(").append(Color.getRed-impl(arg0)).append(str2).append(Color.getGreen-impl(arg0)).append(str2).append(Color.getBlue-impl(arg0)).append(str2).append(Color.getAlpha-impl(arg0)).append(str2).append(Color.getColorSpace-impl(arg0).getName()).append(')').toString();
    }

    public boolean equals(Object object) {
        return Color.equals-impl(this.value, obj1);
    }

    public final long getValue-s-VKNKU() {
        return this.value;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    public String toString() {
        return Color.toString-impl(this.value);
    }

    public final long unbox-impl() {
        return this.value;
    }
}
