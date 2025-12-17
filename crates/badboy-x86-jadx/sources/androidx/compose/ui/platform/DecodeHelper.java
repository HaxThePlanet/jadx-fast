package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontSynthesis.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0015\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001b\u0010\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0008\u0010\u001e\u001a\u00020\u0008H\u0002J\u0008\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\u0008\u0010$\u001a\u00020%H\u0002J\u0008\u0010&\u001a\u00020'H\u0002J\u0013\u0010(\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008*\u0010\u0012J\u0015\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008-\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", "string", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "dataAvailable", "", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeByte", "", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeFloat", "", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeInt", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeString", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DecodeHelper {

    public static final int $stable = 8;
    private final Parcel parcel;
    static {
        final int i = 8;
    }

    public DecodeHelper(String string) {
        super();
        this.parcel = Parcel.obtain();
        int i = 0;
        final byte[] decode = Base64.decode(string, i);
        this.parcel.unmarshall(decode, i, decode.length);
        this.parcel.setDataPosition(i);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    private final float decodeBaselineShift-y9eOQZs() {
        return BaselineShift.constructor-impl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        final float decodeFloat2 = decodeFloat();
        Shadow shadow = new Shadow(decodeColor-0d7_KjU(), obj2, OffsetKt.Offset(decodeFloat(), decodeFloat2), decodeFloat2, decodeFloat(), 0);
        return shadow;
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int i;
        TextDecoration lineThrough;
        int underline;
        int i2;
        TextDecoration.Companion companion;
        TextDecoration[] arr;
        TextDecoration lineThrough2;
        final int decodeInt = decodeInt();
        int i4 = 1;
        underline = 0;
        i = mask &= decodeInt != 0 ? i4 : underline;
        i2 = mask2 &= decodeInt != 0 ? i4 : underline;
        if (i != 0 && i2 != 0) {
            if (i2 != 0) {
                arr = new TextDecoration[2];
                arr[underline] = TextDecoration.Companion.getLineThrough();
                arr[i4] = TextDecoration.Companion.getUnderline();
                lineThrough = TextDecoration.Companion.combine(CollectionsKt.listOf(arr));
            } else {
                if (i != 0) {
                    lineThrough = TextDecoration.Companion.getLineThrough();
                } else {
                    if (i2 != 0) {
                        lineThrough = TextDecoration.Companion.getUnderline();
                    } else {
                        lineThrough = TextDecoration.Companion.getNone();
                    }
                }
            }
        } else {
        }
        return lineThrough;
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        TextGeometricTransform textGeometricTransform = new TextGeometricTransform(decodeFloat(), decodeFloat());
        return textGeometricTransform;
    }

    private final long decodeULong-s-VKNKU() {
        return ULong.constructor-impl(this.parcel.readLong());
    }

    public final long decodeColor-0d7_KjU() {
        return Color.constructor-impl(decodeULong-s-VKNKU());
    }

    public final int decodeFontStyle-_-LCdwA() {
        int normal-_-LCdwA;
        int i;
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            normal-_-LCdwA = FontStyle.Companion.getNormal-_-LCdwA();
        } else {
            if (decodeByte == 1) {
                normal-_-LCdwA = FontStyle.Companion.getItalic-_-LCdwA();
            } else {
                normal-_-LCdwA = FontStyle.Companion.getNormal-_-LCdwA();
            }
        }
        return normal-_-LCdwA;
    }

    public final int decodeFontSynthesis-GVVA2EU() {
        int weight-GVVA2EU;
        int i;
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            weight-GVVA2EU = FontSynthesis.Companion.getNone-GVVA2EU();
        } else {
            if (decodeByte == 1) {
                weight-GVVA2EU = FontSynthesis.Companion.getAll-GVVA2EU();
            } else {
                if (decodeByte == 3) {
                    weight-GVVA2EU = FontSynthesis.Companion.getStyle-GVVA2EU();
                } else {
                    if (decodeByte == 2) {
                        weight-GVVA2EU = FontSynthesis.Companion.getWeight-GVVA2EU();
                    } else {
                        weight-GVVA2EU = FontSynthesis.Companion.getNone-GVVA2EU();
                    }
                }
            }
        }
        return weight-GVVA2EU;
    }

    public final FontWeight decodeFontWeight() {
        FontWeight fontWeight = new FontWeight(decodeInt());
        return fontWeight;
    }

    public final SpanStyle decodeSpanStyle() {
        int i3;
        long decodeTextUnit-XSAIIZE;
        int dataAvailable;
        int i;
        FontStyle fontStyle;
        int i4;
        int i2;
        int i5;
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0, obj2, 0, obj4, 0, 0, 0, 0, 0, 0, obj11, 0, 0, 0, 0, obj16, 0, 0, 16383, 0);
        i3 = this;
        i = 1;
        while (i3.parcel.dataAvail() > i) {
            decodeTextUnit-XSAIIZE = i3.decodeByte();
            fontStyle = 8;
            i2 = 5;
            i5 = 4;
            i = 7;
            i = 10;
            i3 = this;
            i = 1;
            mutableSpanStyle.setShadow(i3.decodeShadow());
            mutableSpanStyle.setTextDecoration(i3.decodeTextDecoration());
            mutableSpanStyle.setBackground-8_81llA(i3.decodeColor-0d7_KjU());
            mutableSpanStyle.setTextGeometricTransform(i3.decodeTextGeometricTransform());
            mutableSpanStyle.setBaselineShift-_isdbwI(BaselineShift.box-impl(i3.decodeBaselineShift-y9eOQZs()));
            mutableSpanStyle.setLetterSpacing--R2X_6o(i3.decodeTextUnit-XSAIIZE());
            mutableSpanStyle.setFontFeatureSettings(i3.decodeString());
            mutableSpanStyle.setFontSynthesis-tDdu0R4(FontSynthesis.box-impl(i3.decodeFontSynthesis-GVVA2EU()));
            mutableSpanStyle.setFontStyle-mLjRB2g(FontStyle.box-impl(i3.decodeFontStyle-_-LCdwA()));
            mutableSpanStyle.setFontWeight(i3.decodeFontWeight());
            mutableSpanStyle.setFontSize--R2X_6o(i3.decodeTextUnit-XSAIIZE());
            mutableSpanStyle.setColor-8_81llA(i3.decodeColor-0d7_KjU());
        }
        return mutableSpanStyle.toSpanStyle();
    }

    public final long decodeTextUnit-XSAIIZE() {
        long unspecified-UIouoOA;
        int i;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            unspecified-UIouoOA = TextUnitType.Companion.getSp-UIouoOA();
        } else {
            if (decodeByte == 2) {
                unspecified-UIouoOA = TextUnitType.Companion.getEm-UIouoOA();
            } else {
                unspecified-UIouoOA = TextUnitType.Companion.getUnspecified-UIouoOA();
            }
        }
        if (TextUnitType.equals-impl0(unspecified-UIouoOA, i)) {
            return TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        return TextUnitKt.TextUnit-anM5pPY(decodeFloat(), unspecified-UIouoOA);
    }
}
