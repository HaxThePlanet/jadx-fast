package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontSynthesis.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\u0008-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00060", d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncodeHelper {

    public static final int $stable = 8;
    private Parcel parcel;
    static {
        final int i = 8;
    }

    public EncodeHelper() {
        super();
        this.parcel = Parcel.obtain();
    }

    public final void encode(byte byte) {
        this.parcel.writeByte(byte);
    }

    public final void encode(float float) {
        this.parcel.writeFloat(float);
    }

    public final void encode(int int) {
        this.parcel.writeInt(int);
    }

    public final void encode(Shadow shadow) {
        encode-8_81llA(shadow.getColor-0d7_KjU());
        encode(Offset.getX-impl(shadow.getOffset-F1C5BW0()));
        encode(Offset.getY-impl(shadow.getOffset-F1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(SpanStyle spanStyle) {
        boolean color-0d7_KjU;
        boolean fontSize-XSAIIZE;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        boolean letterSpacing-XSAIIZE;
        BaselineShift unbox-impl;
        boolean background-0d7_KjU;
        long l;
        long unspecified-XSAIIZE2;
        long unspecified-XSAIIZE;
        long unspecified-0d7_KjU;
        if (!Color.equals-impl0(spanStyle.getColor-0d7_KjU(), obj1)) {
            encode(1);
            encode-8_81llA(spanStyle.getColor-0d7_KjU());
        }
        if (!TextUnit.equals-impl0(spanStyle.getFontSize-XSAIIZE(), obj1)) {
            encode(2);
            encode--R2X_6o(spanStyle.getFontSize-XSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            l = 0;
            encode(3);
            encode(fontWeight);
        }
        fontStyle-4Lr2A7w = spanStyle.getFontStyle-4Lr2A7w();
        if (fontStyle-4Lr2A7w != null) {
            l = 0;
            encode(4);
            encode-nzbMABs(fontStyle-4Lr2A7w.unbox-impl());
        }
        fontSynthesis-ZQGJjVo = spanStyle.getFontSynthesis-ZQGJjVo();
        if (fontSynthesis-ZQGJjVo != null) {
            l = 0;
            encode(5);
            encode-6p3vJLY(fontSynthesis-ZQGJjVo.unbox-impl());
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            l = 0;
            encode(6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.equals-impl0(spanStyle.getLetterSpacing-XSAIIZE(), l)) {
            encode(7);
            encode--R2X_6o(spanStyle.getLetterSpacing-XSAIIZE());
        }
        unbox-impl = spanStyle.getBaselineShift-5SSeXJ0();
        if (unbox-impl != null) {
            l = 0;
            encode(8);
            encode-4Dl_Bck(unbox-impl.unbox-impl());
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            l = 0;
            encode(9);
            encode(textGeometricTransform);
        }
        if (!Color.equals-impl0(spanStyle.getBackground-0d7_KjU(), l)) {
            encode(10);
            encode-8_81llA(spanStyle.getBackground-0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            l = 0;
            encode(11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            l = 0;
            encode(12);
            encode(shadow);
        }
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }

    public final void encode--R2X_6o(long textUnit) {
        long type-UIouoOA;
        boolean value-impl;
        boolean companion;
        int i;
        long sp-UIouoOA;
        type-UIouoOA = TextUnit.getType-UIouoOA(textUnit);
        i = 0;
        if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
        } else {
            if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                i = 1;
            } else {
                if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                    i = 2;
                } else {
                }
            }
        }
        encode(i);
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(textUnit), obj1)) {
            encode(TextUnit.getValue-impl(textUnit));
        }
    }

    public final void encode-4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode-6p3vJLY(int fontSynthesis) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getNone-GVVA2EU())) {
        } else {
            if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getAll-GVVA2EU())) {
                i = 1;
            } else {
                if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getWeight-GVVA2EU())) {
                    i = 2;
                } else {
                    if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getStyle-GVVA2EU())) {
                        i = 3;
                    } else {
                    }
                }
            }
        }
        encode(i);
    }

    public final void encode-8_81llA(long color) {
        encode-VKZWuLQ(color);
    }

    public final void encode-VKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode-nzbMABs(int fontStyle) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getNormal-_-LCdwA())) {
        } else {
            if (FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getItalic-_-LCdwA())) {
                i = 1;
            } else {
            }
        }
        encode(i);
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }
}
