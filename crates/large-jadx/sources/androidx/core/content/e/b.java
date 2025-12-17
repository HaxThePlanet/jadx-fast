package androidx.core.content.e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Shader;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b {

    private final Shader a;
    private final ColorStateList b;
    private int c;
    private b(Shader shader, ColorStateList colorStateList2, int i3) {
        super();
        this.a = shader;
        this.b = colorStateList2;
        this.c = i3;
    }

    private static androidx.core.content.e.b a(Resources resources, int i2, Resources.Theme resources$Theme3) {
        int next;
        int i;
        int i3;
        android.content.res.XmlResourceParser obj5 = resources.getXml(i2);
        final android.util.AttributeSet attributeSet = Xml.asAttributeSet(obj5);
        next = obj5.next();
        i = 2;
        while (next != i) {
            if (next != 1) {
            }
            next = obj5.next();
            i = 2;
        }
        if (next != i) {
        } else {
            String name = obj5.getName();
            name.hashCode();
            if (!name.equals("gradient")) {
                if (!name.equals("selector")) {
                } else {
                    return b.c(a.b(resources, obj5, attributeSet, theme3));
                }
                StringBuilder obj6 = new StringBuilder();
                obj6.append(obj5.getPositionDescription());
                obj6.append(": unsupported complex color tag ");
                obj6.append(name);
                XmlPullParserException obj4 = new XmlPullParserException(obj6.toString());
                throw obj4;
            }
            return b.d(d.b(resources, obj5, attributeSet, theme3));
        }
        obj4 = new XmlPullParserException("No start tag found");
        throw obj4;
    }

    static androidx.core.content.e.b b(int i) {
        final int i2 = 0;
        b bVar = new b(i2, i2, i);
        return bVar;
    }

    static androidx.core.content.e.b c(ColorStateList colorStateList) {
        b bVar = new b(0, colorStateList, colorStateList.getDefaultColor());
        return bVar;
    }

    static androidx.core.content.e.b d(Shader shader) {
        b bVar = new b(shader, 0, 0);
        return bVar;
    }

    public static androidx.core.content.e.b g(Resources resources, int i2, Resources.Theme resources$Theme3) {
        try {
            return b.a(resources, i2, theme3);
            i2 = "ComplexColorCompat";
            theme3 = "Failed to inflate ComplexColor.";
            Log.e(i2, theme3, resources);
            resources = null;
            return resources;
        }
    }

    public int e() {
        return this.c;
    }

    public Shader f() {
        return this.a;
    }

    public boolean h() {
        int i;
        i = this.a != null ? 1 : 0;
        return i;
    }

    public boolean i() {
        int i;
        Shader stateful;
        stateful = this.b;
        if (this.a == null && stateful != null && stateful.isStateful()) {
            stateful = this.b;
            if (stateful != null) {
                i = stateful.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public boolean j(int[] iArr) {
        boolean z;
        int i;
        int defaultColor;
        int[] obj3;
        ColorStateList list = this.b;
        obj3 = list.getColorForState(iArr, list.getDefaultColor());
        if (i() && obj3 != this.c) {
            list = this.b;
            obj3 = list.getColorForState(iArr, list.getDefaultColor());
            if (obj3 != this.c) {
                i = 1;
                this.c = obj3;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void k(int i) {
        this.c = i;
    }

    public boolean l() {
        int i;
        boolean z;
        if (!h()) {
            if (this.c != 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
