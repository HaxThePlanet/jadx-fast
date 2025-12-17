package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0016J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J(\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0013J0\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u00182\u000c\u0010$\u001a\u0008\u0018\u00010%R\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0001\u0010!\u001a\u00020\u0005J8\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00182\u000c\u0010$\u001a\u0008\u0018\u00010%R\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0001\u0010!\u001a\u00020\u00052\u0008\u0008\u0001\u0010\u001c\u001a\u00020\u0005J(\u0010)\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016J(\u0010*\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0001\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0018\u0010+\u001a\u0004\u0018\u00010 2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\t\u0010,\u001a\u00020\u0005HÖ\u0001J,\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020&2\u000c\u0010$\u001a\u0008\u0018\u00010%R\u00020&2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\t\u00103\u001a\u00020 HÖ\u0001J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u000c8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u00067", d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getConfig", "()I", "setConfig", "(I)V", "pathParser", "Landroidx/compose/ui/graphics/vector/PathParser;", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "component1", "component2", "copy", "equals", "", "other", "getDimension", "", "typedArray", "Landroid/content/res/TypedArray;", "index", "defValue", "getFloat", "defaultValue", "getInt", "getNamedBoolean", "attrName", "", "resId", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedFloat", "getNamedInt", "getString", "hashCode", "obtainAttributes", "res", "set", "Landroid/util/AttributeSet;", "attrs", "", "toString", "updateConfig", "", "resConfig", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidVectorParser {

    public static final int $stable = 8;
    private int config;
    public final PathParser pathParser;
    private final XmlPullParser xmlParser;
    static {
        final int i = 8;
    }

    public AndroidVectorParser(XmlPullParser xmlParser, int config) {
        super();
        this.xmlParser = xmlParser;
        this.config = config;
        PathParser pathParser = new PathParser();
        this.pathParser = pathParser;
    }

    public AndroidVectorParser(XmlPullParser xmlPullParser, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(xmlPullParser, obj2);
    }

    public static androidx.compose.ui.graphics.vector.compat.AndroidVectorParser copy$default(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser androidVectorParser, XmlPullParser xmlPullParser2, int i3, int i4, Object object5) {
        XmlPullParser obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = androidVectorParser.xmlParser;
        }
        if (i4 &= 2 != 0) {
            obj2 = androidVectorParser.config;
        }
        return androidVectorParser.copy(obj1, obj2);
    }

    private final void updateConfig(int resConfig) {
        this.config = config |= resConfig;
    }

    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    public final androidx.compose.ui.graphics.vector.compat.AndroidVectorParser copy(XmlPullParser xmlPullParser, int i2) {
        AndroidVectorParser androidVectorParser = new AndroidVectorParser(xmlPullParser, i2);
        return androidVectorParser;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof AndroidVectorParser) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.xmlParser, obj.xmlParser)) {
            return i2;
        }
        if (this.config != obj.config) {
            return i2;
        }
        return i;
    }

    public final int getConfig() {
        return this.config;
    }

    public final float getDimension(TypedArray typedArray, int index, float defValue) {
        final Object obj = typedArray;
        final int i = 0;
        updateConfig(obj.getChangingConfigurations());
        return obj.getDimension(index, defValue);
    }

    public final float getFloat(TypedArray typedArray, int index, float defaultValue) {
        final Object obj = typedArray;
        final int i = 0;
        updateConfig(obj.getChangingConfigurations());
        return obj.getFloat(index, defaultValue);
    }

    public final int getInt(TypedArray typedArray, int index, int defaultValue) {
        final Object obj = typedArray;
        final int i = 0;
        updateConfig(obj.getChangingConfigurations());
        return obj.getInt(index, defaultValue);
    }

    public final boolean getNamedBoolean(TypedArray typedArray, String attrName, int resId, boolean defaultValue) {
        final TypedArray typedArray2 = typedArray;
        final int i = 0;
        updateConfig(typedArray2.getChangingConfigurations());
        return TypedArrayUtils.getNamedBoolean(typedArray2, this.xmlParser, attrName, resId, defaultValue);
    }

    public final ColorStateList getNamedColorStateList(TypedArray typedArray, Resources.Theme theme, String attrName, int resId) {
        final int i = 0;
        updateConfig(typedArray.getChangingConfigurations());
        return TypedArrayUtils.getNamedColorStateList(typedArray, this.xmlParser, theme, attrName, resId);
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String attrName, int resId, int defaultValue) {
        final TypedArray typedArray2 = typedArray;
        final int i3 = 0;
        updateConfig(typedArray2.getChangingConfigurations());
        return TypedArrayUtils.getNamedComplexColor(typedArray2, this.xmlParser, theme, attrName, resId, defaultValue);
    }

    public final float getNamedFloat(TypedArray typedArray, String attrName, int resId, float defaultValue) {
        final TypedArray typedArray2 = typedArray;
        final int i = 0;
        updateConfig(typedArray2.getChangingConfigurations());
        return TypedArrayUtils.getNamedFloat(typedArray2, this.xmlParser, attrName, resId, defaultValue);
    }

    public final int getNamedInt(TypedArray typedArray, String attrName, int resId, int defaultValue) {
        final TypedArray typedArray2 = typedArray;
        final int i = 0;
        updateConfig(typedArray2.getChangingConfigurations());
        return TypedArrayUtils.getNamedInt(typedArray2, this.xmlParser, attrName, resId, defaultValue);
    }

    public final String getString(TypedArray typedArray, int index) {
        final Object obj = typedArray;
        final int i = 0;
        updateConfig(obj.getChangingConfigurations());
        return obj.getString(index);
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        final TypedArray attributes = TypedArrayUtils.obtainAttributes(res, theme, set, attrs);
        updateConfig(attributes.getChangingConfigurations());
        return attributes;
    }

    public final void setConfig(int <set-?>) {
        this.config = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AndroidVectorParser(xmlParser=").append(this.xmlParser).append(", config=").append(this.config).append(')').toString();
    }
}
