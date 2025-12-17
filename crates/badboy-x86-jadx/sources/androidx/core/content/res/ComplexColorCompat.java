package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Shader;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public final class ComplexColorCompat {

    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;
    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int color) {
        super();
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = color;
    }

    private static androidx.core.content.res.ComplexColorCompat createFromXml(Resources resources, int resId, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        int i;
        int equals;
        int i2;
        int equals2;
        final android.content.res.XmlResourceParser xml = resources.getXml(resId);
        final android.util.AttributeSet attributeSet = Xml.asAttributeSet(xml);
        next = xml.next();
        i = next;
        i2 = 2;
        while (next != i2) {
            if (i != 1) {
            }
            next = xml.next();
            i = next;
            i2 = 2;
        }
        if (i != i2) {
        } else {
            String name2 = xml.getName();
            switch (name2) {
                case "gradient":
                    equals = -1;
                    break;
                case "selector":
                    equals = 0;
                    equals = -1;
                    break;
                default:
                    equals = -1;
            }
            switch (equals) {
                case 0:
                    return ComplexColorCompat.from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, attributeSet, theme));
                case 1:
                    return ComplexColorCompat.from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, attributeSet, theme));
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    XmlPullParserException xmlPullParserException = new XmlPullParserException(stringBuilder.append(xml.getPositionDescription()).append(": unsupported complex color tag ").append(name2).toString());
                    throw xmlPullParserException;
            }
        }
        XmlPullParserException name = new XmlPullParserException("No start tag found");
        throw name;
    }

    static androidx.core.content.res.ComplexColorCompat from(int color) {
        final int i = 0;
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(i, i, color);
        return complexColorCompat;
    }

    static androidx.core.content.res.ComplexColorCompat from(ColorStateList colorStateList) {
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(0, colorStateList, colorStateList.getDefaultColor());
        return complexColorCompat;
    }

    static androidx.core.content.res.ComplexColorCompat from(Shader shader) {
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(shader, 0, 0);
        return complexColorCompat;
    }

    public static androidx.core.content.res.ComplexColorCompat inflate(Resources resources, int resId, Resources.Theme theme) {
        try {
            return ComplexColorCompat.createFromXml(resources, resId, theme);
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            Throwable e = null;
            return e;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        int i;
        i = this.mShader != null ? 1 : 0;
        return i;
    }

    public boolean isStateful() {
        int i;
        Shader mColorStateList;
        if (this.mShader == null && this.mColorStateList != null && this.mColorStateList.isStateful()) {
            if (this.mColorStateList != null) {
                i = this.mColorStateList.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public boolean onStateChanged(int[] stateSet) {
        int changed;
        boolean colorForState;
        int mColor;
        changed = 0;
        colorForState = this.mColorStateList.getColorForState(stateSet, this.mColorStateList.getDefaultColor());
        if (isStateful() && colorForState != this.mColor) {
            colorForState = this.mColorStateList.getColorForState(stateSet, this.mColorStateList.getDefaultColor());
            if (colorForState != this.mColor) {
                changed = 1;
                this.mColor = colorForState;
            }
        }
        return changed;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public boolean willDraw() {
        int i;
        boolean mColor;
        if (!isGradient()) {
            if (this.mColor != 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
