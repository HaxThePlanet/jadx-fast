package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\u0003H\u0016J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Landroidx/compose/ui/text/font/FontWeight;", "", "weight", "", "(I)V", "getWeight", "()I", "compareTo", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontWeight implements Comparable<androidx.compose.ui.text.font.FontWeight> {

    public static final int $stable;
    private static final androidx.compose.ui.text.font.FontWeight Black;
    private static final androidx.compose.ui.text.font.FontWeight Bold;
    public static final androidx.compose.ui.text.font.FontWeight.Companion Companion;
    private static final androidx.compose.ui.text.font.FontWeight ExtraBold;
    private static final androidx.compose.ui.text.font.FontWeight ExtraLight;
    private static final androidx.compose.ui.text.font.FontWeight Light;
    private static final androidx.compose.ui.text.font.FontWeight Medium;
    private static final androidx.compose.ui.text.font.FontWeight Normal;
    private static final androidx.compose.ui.text.font.FontWeight SemiBold;
    private static final androidx.compose.ui.text.font.FontWeight Thin;
    private static final androidx.compose.ui.text.font.FontWeight W100;
    private static final androidx.compose.ui.text.font.FontWeight W200;
    private static final androidx.compose.ui.text.font.FontWeight W300;
    private static final androidx.compose.ui.text.font.FontWeight W400;
    private static final androidx.compose.ui.text.font.FontWeight W500;
    private static final androidx.compose.ui.text.font.FontWeight W600;
    private static final androidx.compose.ui.text.font.FontWeight W700;
    private static final androidx.compose.ui.text.font.FontWeight W800;
    private static final androidx.compose.ui.text.font.FontWeight W900;
    private static final List<androidx.compose.ui.text.font.FontWeight> values;
    private final int weight;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00087\n\u0002\u0010 \n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0012\u0010\u0002\u001a\u0004\u0008\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0002\u001a\u0004\u0008\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0018\u0010\u0002\u001a\u0004\u0008\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001b\u0010\u0002\u001a\u0004\u0008\u001c\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001e\u0010\u0002\u001a\u0004\u0008\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008!\u0010\u0002\u001a\u0004\u0008\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008$\u0010\u0002\u001a\u0004\u0008%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008'\u0010\u0002\u001a\u0004\u0008(\u0010\u0007R\u001c\u0010)\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008*\u0010\u0002\u001a\u0004\u0008+\u0010\u0007R\u001c\u0010,\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008-\u0010\u0002\u001a\u0004\u0008.\u0010\u0007R\u001c\u0010/\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00080\u0010\u0002\u001a\u0004\u00081\u0010\u0007R\u001c\u00102\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00083\u0010\u0002\u001a\u0004\u00084\u0010\u0007R\u001c\u00105\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00086\u0010\u0002\u001a\u0004\u00087\u0010\u0007R\u001c\u00108\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00089\u0010\u0002\u001a\u0004\u0008:\u0010\u0007R\u001a\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00040<X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010>¨\u0006?", d2 = {"Landroidx/compose/ui/text/font/FontWeight$Companion;", "", "()V", "Black", "Landroidx/compose/ui/text/font/FontWeight;", "getBlack$annotations", "getBlack", "()Landroidx/compose/ui/text/font/FontWeight;", "Bold", "getBold$annotations", "getBold", "ExtraBold", "getExtraBold$annotations", "getExtraBold", "ExtraLight", "getExtraLight$annotations", "getExtraLight", "Light", "getLight$annotations", "getLight", "Medium", "getMedium$annotations", "getMedium", "Normal", "getNormal$annotations", "getNormal", "SemiBold", "getSemiBold$annotations", "getSemiBold", "Thin", "getThin$annotations", "getThin", "W100", "getW100$annotations", "getW100", "W200", "getW200$annotations", "getW200", "W300", "getW300$annotations", "getW300", "W400", "getW400$annotations", "getW400", "W500", "getW500$annotations", "getW500", "W600", "getW600$annotations", "getW600", "W700", "getW700$annotations", "getW700", "W800", "getW800$annotations", "getW800", "W900", "getW900$annotations", "getW900", "values", "", "getValues$ui_text_release", "()Ljava/util/List;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getBlack$annotations() {
        }

        public static void getBold$annotations() {
        }

        public static void getExtraBold$annotations() {
        }

        public static void getExtraLight$annotations() {
        }

        public static void getLight$annotations() {
        }

        public static void getMedium$annotations() {
        }

        public static void getNormal$annotations() {
        }

        public static void getSemiBold$annotations() {
        }

        public static void getThin$annotations() {
        }

        public static void getW100$annotations() {
        }

        public static void getW200$annotations() {
        }

        public static void getW300$annotations() {
        }

        public static void getW400$annotations() {
        }

        public static void getW500$annotations() {
        }

        public static void getW600$annotations() {
        }

        public static void getW700$annotations() {
        }

        public static void getW800$annotations() {
        }

        public static void getW900$annotations() {
        }

        public final androidx.compose.ui.text.font.FontWeight getBlack() {
            return FontWeight.access$getBlack$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getBold() {
            return FontWeight.access$getBold$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getExtraBold() {
            return FontWeight.access$getExtraBold$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getExtraLight() {
            return FontWeight.access$getExtraLight$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getLight() {
            return FontWeight.access$getLight$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getMedium() {
            return FontWeight.access$getMedium$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getNormal() {
            return FontWeight.access$getNormal$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getSemiBold() {
            return FontWeight.access$getSemiBold$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getThin() {
            return FontWeight.access$getThin$cp();
        }

        public final List<androidx.compose.ui.text.font.FontWeight> getValues$ui_text_release() {
            return FontWeight.access$getValues$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW100() {
            return FontWeight.access$getW100$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW200() {
            return FontWeight.access$getW200$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW300() {
            return FontWeight.access$getW300$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW400() {
            return FontWeight.access$getW400$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW500() {
            return FontWeight.access$getW500$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW600() {
            return FontWeight.access$getW600$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW700() {
            return FontWeight.access$getW700$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW800() {
            return FontWeight.access$getW800$cp();
        }

        public final androidx.compose.ui.text.font.FontWeight getW900() {
            return FontWeight.access$getW900$cp();
        }
    }
    static {
        FontWeight.Companion companion = new FontWeight.Companion(0);
        FontWeight.Companion = companion;
        FontWeight fontWeight = new FontWeight(100);
        FontWeight.W100 = fontWeight;
        FontWeight fontWeight2 = new FontWeight(200);
        FontWeight.W200 = fontWeight2;
        FontWeight fontWeight3 = new FontWeight(300);
        FontWeight.W300 = fontWeight3;
        FontWeight fontWeight4 = new FontWeight(400);
        FontWeight.W400 = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(500);
        FontWeight.W500 = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        FontWeight.W600 = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(700);
        FontWeight.W700 = fontWeight7;
        FontWeight fontWeight8 = new FontWeight(800);
        FontWeight.W800 = fontWeight8;
        FontWeight fontWeight9 = new FontWeight(900);
        FontWeight.W900 = fontWeight9;
        FontWeight.Thin = FontWeight.W100;
        FontWeight.ExtraLight = FontWeight.W200;
        FontWeight.Light = FontWeight.W300;
        FontWeight.Normal = FontWeight.W400;
        FontWeight.Medium = FontWeight.W500;
        FontWeight.SemiBold = FontWeight.W600;
        FontWeight.Bold = FontWeight.W700;
        FontWeight.ExtraBold = FontWeight.W800;
        FontWeight.Black = FontWeight.W900;
        FontWeight.values = CollectionsKt.listOf(/* result */);
    }

    public FontWeight(int weight) {
        int i;
        int i2;
        super();
        this.weight = weight;
        int weight2 = this.weight;
        i = 0;
        int i4 = 1;
        if (i4 <= weight2 && weight2 < 1001) {
            i = weight2 < 1001 ? i4 : i;
        }
        if (i == 0) {
        } else {
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Font weight can be in range [1, 1000]. Current value: ").append(this.weight).toString().toString());
        throw illegalArgumentException;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getBlack$cp() {
        return FontWeight.Black;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getBold$cp() {
        return FontWeight.Bold;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getExtraBold$cp() {
        return FontWeight.ExtraBold;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getExtraLight$cp() {
        return FontWeight.ExtraLight;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getLight$cp() {
        return FontWeight.Light;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getMedium$cp() {
        return FontWeight.Medium;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getNormal$cp() {
        return FontWeight.Normal;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getSemiBold$cp() {
        return FontWeight.SemiBold;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getThin$cp() {
        return FontWeight.Thin;
    }

    public static final List access$getValues$cp() {
        return FontWeight.values;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW100$cp() {
        return FontWeight.W100;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW200$cp() {
        return FontWeight.W200;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW300$cp() {
        return FontWeight.W300;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW400$cp() {
        return FontWeight.W400;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW500$cp() {
        return FontWeight.W500;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW600$cp() {
        return FontWeight.W600;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW700$cp() {
        return FontWeight.W700;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW800$cp() {
        return FontWeight.W800;
    }

    public static final androidx.compose.ui.text.font.FontWeight access$getW900$cp() {
        return FontWeight.W900;
    }

    @Override // java.lang.Comparable
    public int compareTo(androidx.compose.ui.text.font.FontWeight other) {
        return Intrinsics.compare(this.weight, other.weight);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo((FontWeight)other);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof FontWeight) {
            return i2;
        }
        if (this.weight != obj.weight) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final int getWeight() {
        return this.weight;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.weight;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FontWeight(weight=").append(this.weight).append(')').toString();
    }
}
