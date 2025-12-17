package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import d.h.l.d0.a;
import d.l.a.a;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    private final androidx.constraintlayout.widget.ConstraintLayout a;
    androidx.constraintlayout.widget.d b;
    int c = -1;
    int d = -1;
    private SparseArray<androidx.constraintlayout.widget.c.a> e;
    private SparseArray<androidx.constraintlayout.widget.d> f;
    private androidx.constraintlayout.widget.f g;

    static class a {

        int a;
        ArrayList<androidx.constraintlayout.widget.c.b> b;
        int c = -1;
        androidx.constraintlayout.widget.d d;
        public a(Context context, XmlPullParser xmlPullParser2) {
            int i;
            int resourceId;
            int str;
            int i2;
            super();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            int i3 = -1;
            TypedArray obj7 = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser2), i.P5);
            i = 0;
            while (i < obj7.getIndexCount()) {
                resourceId = obj7.getIndex(i);
                if (resourceId == i.Q5) {
                } else {
                }
                this.c = obj7.getResourceId(resourceId, this.c);
                context.getResources().getResourceName(this.c);
                if (resourceId == i.R5 && "layout".equals(context.getResources().getResourceTypeName(this.c))) {
                }
                i++;
                this.c = obj7.getResourceId(resourceId, this.c);
                context.getResources().getResourceName(this.c);
                if ("layout".equals(context.getResources().getResourceTypeName(this.c))) {
                }
                resourceId = new d();
                this.d = resourceId;
                resourceId.f(context, this.c);
                this.a = obj7.getResourceId(resourceId, this.a);
            }
            obj7.recycle();
        }

        void a(androidx.constraintlayout.widget.c.b c$b) {
            this.b.add(b);
        }

        public int b(float f, float f2) {
            int i;
            boolean z;
            i = 0;
            while (i < this.b.size()) {
                i++;
            }
            return -1;
        }
    }

    static class b {

        float a = NaNf;
        float b = NaNf;
        float c = NaNf;
        float d = NaNf;
        int e = -1;
        androidx.constraintlayout.widget.d f;
        public b(Context context, XmlPullParser xmlPullParser2) {
            int i;
            boolean dVar;
            String str;
            int i2;
            super();
            int i3 = 2143289344;
            int i4 = -1;
            TypedArray obj7 = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser2), i.f6);
            i = 0;
            while (i < obj7.getIndexCount()) {
                int index = obj7.getIndex(i);
                if (index == i.g6) {
                } else {
                }
                if (index == i.h6) {
                } else {
                }
                if (index == i.i6) {
                } else {
                }
                if (index == i.j6) {
                } else {
                }
                if (index == i.k6) {
                } else {
                }
                Log.v("ConstraintLayoutStates", "Unknown tag");
                i++;
                this.a = obj7.getDimension(index, this.a);
                this.c = obj7.getDimension(index, this.c);
                this.b = obj7.getDimension(index, this.b);
                this.d = obj7.getDimension(index, this.d);
                this.e = obj7.getResourceId(index, this.e);
                context.getResources().getResourceName(this.e);
                if ("layout".equals(context.getResources().getResourceTypeName(this.e))) {
                }
                dVar = new d();
                this.f = dVar;
                dVar.f(context, this.e);
            }
            obj7.recycle();
        }

        boolean a(float f, float f2) {
            boolean naN;
            boolean naN2;
            boolean naN3;
            float obj3;
            final int i = 0;
            if (!Float.isNaN(this.a) && Float.compare(f, f7) < 0) {
                if (Float.compare(f, f7) < 0) {
                    return i;
                }
            }
            if (!Float.isNaN(this.b) && Float.compare(f2, f6) < 0) {
                if (Float.compare(f2, f6) < 0) {
                    return i;
                }
            }
            if (!Float.isNaN(this.c) && Float.compare(f, naN3) > 0) {
                if (Float.compare(f, naN3) > 0) {
                    return i;
                }
            }
            if (!Float.isNaN(this.d) && Float.compare(f2, obj3) > 0) {
                if (Float.compare(f2, obj3) > 0) {
                    return i;
                }
            }
            return 1;
        }
    }
    c(Context context, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, int i3) {
        super();
        int i = -1;
        SparseArray sparseArray = new SparseArray();
        this.e = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        this.f = sparseArray2;
        this.a = constraintLayout2;
        a(context, i3);
    }

    private void a(Context context, int i2) {
        int aVar;
        int eventType;
        int str;
        int i3;
        int i5;
        int str2;
        int i;
        int i4;
        Context obj9;
        final android.content.res.XmlResourceParser obj10 = context.getResources().getXml(i2);
        aVar = 0;
        eventType = obj10.getEventType();
        while (eventType != 1) {
            if (eventType != 0) {
            } else {
            }
            obj10.getName();
            eventType = obj10.next();
            i3 = 2;
            if (eventType != i3) {
            } else {
            }
            eventType = obj10.getName();
            i = 4;
            i4 = 3;
            str = i5;
            if (str != i3) {
            } else {
            }
            aVar = new c.a(context, obj10);
            this.e.put(aVar.a, aVar);
            if (str != i4) {
            } else {
            }
            eventType = new c.b(context, obj10);
            if (aVar != 0) {
            }
            aVar.a(eventType);
            if (str != i) {
            } else {
            }
            b(context, obj10);
            if (eventType.equals("Variant")) {
            } else {
            }
            str = i4;
            if (eventType.equals("layoutDescription")) {
            } else {
            }
            str = 0;
            if (eventType.equals("StateSet")) {
            } else {
            }
            if (eventType.equals("State")) {
            } else {
            }
            str = i3;
            if (eventType.equals("ConstraintSet")) {
            } else {
            }
            str = i;
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser2) {
        int attributeCount;
        int length;
        String attributeName;
        String attributeValue;
        String str;
        Resources resources;
        String packageName;
        Object obj9;
        d dVar = new d();
        length = 0;
        while (length < xmlPullParser2.getAttributeCount()) {
            attributeName = xmlPullParser2.getAttributeName(length);
            attributeValue = xmlPullParser2.getAttributeValue(length);
            if (attributeName != null) {
                break;
            } else {
            }
            length++;
            if (attributeValue != null) {
                break;
            } else {
            }
            str = "id";
            if (str.equals(attributeName)) {
                break;
            } else {
            }
        }
    }

    public void c(androidx.constraintlayout.widget.f f) {
    }

    public void d(int i, float f2, float f3) {
        int i3;
        int i2;
        int i4;
        androidx.constraintlayout.widget.d dVar;
        int obj5;
        androidx.constraintlayout.widget.f obj6;
        float obj7;
        i2 = this.c;
        int i5 = -1;
        if (i2 == i) {
            if (i == i5) {
                obj5 = this.e.valueAt(0);
            } else {
                obj5 = this.e.get(i2);
            }
            i3 = this.d;
            if (i3 != i5 && (c.b)obj5.b.get(i3).a(f2, f3)) {
                if ((c.b)obj5.b.get(i3).a(f2, f3)) {
                }
            }
            obj6 = obj5.b(f2, f3);
            if (this.d == obj6) {
            }
            if (obj6 == i5) {
                obj7 = this.b;
            } else {
                obj7 = obj7.f;
            }
            if (obj6 == i5) {
                obj5 = obj5.c;
            } else {
                obj5 = obj5.e;
            }
            if (obj7 == null) {
            }
            this.d = obj6;
            obj6 = this.g;
            if (obj6 != null) {
                obj6.b(i5, obj5);
            }
            obj7.c(this.a);
            obj6 = this.g;
            if (obj6 != null) {
                obj6.a(i5, obj5);
            }
        } else {
            this.c = i;
            Object obj = this.e.get(i);
            i4 = (c.a)obj.b(f2, f3);
            if (i4 == i5) {
                dVar = obj.d;
            } else {
                dVar = obj4.f;
            }
            if (i4 == i5) {
                i3 = obj.c;
            } else {
                i3 = obj2.e;
            }
            if (dVar == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NO Constraint set found ! id=");
                stringBuilder.append(i);
                stringBuilder.append(", dim =");
                stringBuilder.append(f2);
                stringBuilder.append(", ");
                stringBuilder.append(f3);
                Log.v("ConstraintLayoutStates", stringBuilder.toString());
            }
            this.d = i4;
            obj6 = this.g;
            if (obj6 != null) {
                obj6.b(i, i3);
            }
            dVar.c(this.a);
            obj6 = this.g;
            if (obj6 != null) {
                obj6.a(i, i3);
            }
        }
    }
}
