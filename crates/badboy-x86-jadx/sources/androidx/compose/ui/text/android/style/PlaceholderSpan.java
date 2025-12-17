package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJR\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0016J4\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0008\u0010'\u001a\u0004\u0018\u00010\u000cH\u0017R\u001e\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)", d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "widthUnit", "", "height", "heightUnit", "pxPerSp", "verticalAlign", "(FIFIFI)V", "<set-?>", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "heightPx", "getHeightPx", "()I", "isLaidOut", "", "getVerticalAlign", "widthPx", "getWidthPx", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderSpan extends ReplacementSpan {

    public static final int $stable = 0;
    public static final int ALIGN_ABOVE_BASELINE = 0;
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TEXT_BOTTOM = 5;
    public static final int ALIGN_TEXT_CENTER = 6;
    public static final int ALIGN_TEXT_TOP = 4;
    public static final int ALIGN_TOP = 1;
    public static final androidx.compose.ui.text.android.style.PlaceholderSpan.Companion Companion = null;
    public static final int UNIT_EM = 1;
    public static final int UNIT_SP = 0;
    public static final int UNIT_UNSPECIFIED = 2;
    private Paint.FontMetricsInt fontMetrics;
    private final float height;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final float pxPerSp;
    private final int verticalAlign;
    private final float width;
    private int widthPx;
    private final int widthUnit;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion;", "", "()V", "ALIGN_ABOVE_BASELINE", "", "ALIGN_BOTTOM", "ALIGN_CENTER", "ALIGN_TEXT_BOTTOM", "ALIGN_TEXT_CENTER", "ALIGN_TEXT_TOP", "ALIGN_TOP", "UNIT_EM", "UNIT_SP", "UNIT_UNSPECIFIED", "Unit", "VerticalAlign", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        PlaceholderSpan.Companion companion = new PlaceholderSpan.Companion(0);
        PlaceholderSpan.Companion = companion;
        PlaceholderSpan.$stable = 8;
    }

    public PlaceholderSpan(float width, int widthUnit, float height, int heightUnit, float pxPerSp, int verticalAlign) {
        super();
        this.width = width;
        this.widthUnit = widthUnit;
        this.height = height;
        this.heightUnit = heightUnit;
        this.pxPerSp = pxPerSp;
        this.verticalAlign = verticalAlign;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, java.lang.CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetrics = this.fontMetrics;
        if (fontMetrics != null) {
            return fontMetrics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getHeightPx() {
        if (!this.isLaidOut) {
        } else {
            return this.heightPx;
        }
        int i = 0;
        IllegalStateException $i$a$CheckPlaceholderSpan$heightPx$1 = new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
        throw $i$a$CheckPlaceholderSpan$heightPx$1;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, java.lang.CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        int i;
        int i2;
        int ceilToInt;
        float pxPerSp;
        int pxPerSp2;
        int ascent;
        int heightPx;
        int descent;
        int heightPx2;
        int ascent2;
        this.isLaidOut = true;
        final float textSize = paint.getTextSize();
        this.fontMetrics = paint.getFontMetricsInt();
        if (fontMetrics.descent > fontMetrics2.ascent) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
            pxPerSp = "Unsupported unit.";
            switch (widthUnit) {
                case 0:
                    width2 *= pxPerSp2;
                    break;
                case 1:
                    width *= textSize;
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(pxPerSp);
                    throw illegalArgumentException;
            }
            this.widthPx = PlaceholderSpan_androidKt.ceilToInt(i2);
            switch (heightUnit) {
                case 0:
                    ceilToInt = PlaceholderSpan_androidKt.ceilToInt(height *= pxPerSp);
                    break;
                case 1:
                    ceilToInt = PlaceholderSpan_androidKt.ceilToInt(height2 *= textSize);
                    break;
                default:
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(pxPerSp);
                    throw illegalArgumentException2;
            }
            this.heightPx = ceilToInt;
            if (fm != null) {
                ceilToInt = fm;
                pxPerSp = 0;
                ceilToInt.ascent = fontMetrics3.ascent;
                ceilToInt.descent = fontMetrics4.descent;
                ceilToInt.leading = fontMetrics5.leading;
                switch (verticalAlign) {
                    case 0:
                        ceilToInt.ascent = -heightPx3;
                        break;
                    case 1:
                        ceilToInt.descent = ascent7 += heightPx;
                        break;
                    case 2:
                        ceilToInt.ascent = descent4 -= heightPx;
                        break;
                    case 3:
                        ceilToInt.ascent = ascent4 -= i9;
                        ceilToInt.descent = ascent5 += heightPx;
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Unknown verticalAlign.");
                        throw illegalArgumentException3;
                }
                ceilToInt.top = Math.min(fontMetrics6.top, ceilToInt.ascent);
                ceilToInt.bottom = Math.max(fontMetrics7.bottom, ceilToInt.descent);
            }
            return getWidthPx();
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequirePlaceholderSpan$getSize$1 = new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
        throw $i$a$RequirePlaceholderSpan$getSize$1;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getWidthPx() {
        if (!this.isLaidOut) {
        } else {
            return this.widthPx;
        }
        int i = 0;
        IllegalStateException $i$a$CheckPlaceholderSpan$widthPx$1 = new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
        throw $i$a$CheckPlaceholderSpan$widthPx$1;
    }
}
