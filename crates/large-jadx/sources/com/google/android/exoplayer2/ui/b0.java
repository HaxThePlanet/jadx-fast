package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.common.base.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class b0 extends FrameLayout implements com.google.android.exoplayer2.ui.SubtitleView.a {

    private final com.google.android.exoplayer2.ui.j a;
    private final WebView b;
    private List<c> c;
    private com.google.android.exoplayer2.ui.k v;
    private float w;
    private int x;
    private float y;

    class a extends WebView {
        a(com.google.android.exoplayer2.ui.b0 b0, Context context2, AttributeSet attributeSet3) {
            super(context2, attributeSet3);
        }

        @Override // android.webkit.WebView
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return 0;
        }

        @Override // android.webkit.WebView
        public boolean performClick() {
            super.performClick();
            return 0;
        }
    }

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b0.b.a = iArr;
            iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            b0.b.a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            b0.b.a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
        }
    }
    public b0(Context context) {
        super(context, 0);
    }

    public b0(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        this.c = Collections.emptyList();
        this.v = k.g;
        this.w = 1029329178;
        int i2 = 0;
        this.x = i2;
        this.y = 1034147594;
        j jVar = new j(context, attributeSet2);
        this.a = jVar;
        b0.a aVar = new b0.a(this, context, attributeSet2);
        this.b = aVar;
        aVar.setBackgroundColor(i2);
        addView(jVar);
        addView(aVar);
    }

    private static int b(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                return 0;
            }
            return -100;
        }
        return -50;
    }

    private static String c(Layout.Alignment layout$Alignment) {
        final String str = "center";
        if (alignment == null) {
            return str;
        }
        int obj2 = b0.b.a[alignment.ordinal()];
        if (obj2 != 1 && obj2 != 2) {
            if (obj2 != 2) {
                return str;
            }
            return "end";
        }
        return "start";
    }

    private static String d(com.google.android.exoplayer2.ui.k k) {
        int i = k.d;
        final int i2 = 0;
        final int i3 = 1;
        if (i != i3 && i != 2 && i != 3 && i != 4) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "unset";
                    }
                    Object[] arr2 = new Object[i3];
                    arr2[i2] = n.b(k.e);
                    return p0.z("-0.05em -0.05em 0.15em %s", arr2);
                }
                Object[] arr3 = new Object[i3];
                arr3[i2] = n.b(k.e);
                return p0.z("0.06em 0.08em 0.15em %s", arr3);
            }
            Object[] arr = new Object[i3];
            arr[i2] = n.b(k.e);
            return p0.z("0.1em 0.12em 0.15em %s", arr);
        }
        Object[] arr4 = new Object[i3];
        arr4[i2] = n.b(k.e);
        return p0.z("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", arr4);
    }

    private String e(int i, float f2) {
        float obj4 = y.f(i, f2, getHeight(), i3 -= paddingBottom);
        if (Float.compare(obj4, obj5) == 0) {
            return "unset";
        }
        Object[] obj5 = new Object[1];
        return p0.z("%.2fpx", Float.valueOf(obj4 /= obj5));
    }

    private static String f(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                return "horizontal-tb";
            }
            return "vertical-lr";
        }
        return "vertical-rl";
    }

    private static String h(c c) {
        String obj4;
        final float f = c.q;
        if (Float.compare(f, i) != 0) {
            obj4 = c.p;
            int i2 = 1;
            int i3 = 2;
            if (obj4 != i3) {
                if (obj4 == i2) {
                    obj4 = "skewY";
                } else {
                    obj4 = "skewX";
                }
            } else {
            }
            Object[] arr = new Object[i3];
            arr[0] = obj4;
            arr[i2] = Float.valueOf(f);
            return p0.z("%s(%.2fdeg)", arr);
        }
        return "";
    }

    private void i() {
        Object obj;
        com.google.android.exoplayer2.ui.w.b bVar;
        String str8;
        int i2;
        Object equals;
        int i11;
        String str;
        int str5;
        String str11;
        int arr2;
        int i10;
        String arr;
        int i3;
        int i5;
        String str2;
        int i7;
        int i12;
        String str6;
        String str10;
        int i16;
        int i17;
        int i14;
        int i20;
        Iterator iterator;
        Object obj2;
        int i13;
        int i;
        String str9;
        int i18;
        int i9;
        int i4;
        int cmp;
        int i8;
        int i6;
        int i15;
        boolean next;
        String str3;
        Resources resources;
        String str4;
        String str7;
        int i19;
        com.google.android.exoplayer2.ui.w.b bVar2;
        obj = this;
        StringBuilder stringBuilder2 = new StringBuilder();
        Object[] arr6 = new Object[4];
        arr2 = 0;
        arr6[arr2] = n.b(kVar.a);
        i10 = 1;
        arr6[i10] = obj.e(obj.x, obj.w);
        arr6[2] = 1.2f;
        arr6[3] = b0.d(obj.v);
        stringBuilder2.append(p0.z("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", arr6));
        HashMap hashMap = new HashMap();
        String str33 = "default_bg";
        Object[] arr10 = new Object[i10];
        arr10[arr2] = n.b(kVar3.b);
        hashMap.put(n.a(str33), p0.z("background-color:%s;", arr10));
        i12 = arr2;
        while (i12 < obj.c.size()) {
            str6 = obj.c.get(i12);
            float f6 = str6.h;
            int i52 = -8388609;
            i18 = 1120403456;
            if (Float.compare(f6, i52) != 0) {
            } else {
            }
            i16 = 1112014848;
            float f = str6.e;
            i8 = 1065353216;
            String str34 = "%.2f%%";
            if (Float.compare(f, i52) != 0) {
            } else {
            }
            Object[] arr5 = new Object[i10];
            arr5[arr2] = Float.valueOf(i57 *= i18);
            str = p0.z(str34, arr5);
            i5 = -100;
            i14 = arr2;
            float f2 = str6.j;
            if (Float.compare(f2, i58) != 0) {
            } else {
            }
            str11 = "fit-content";
            if (str6.l) {
            } else {
            }
            i9 = kVar4.c;
            int i49 = str6.p;
            str3 = "right";
            i19 = i55;
            if (i49 != 1) {
            } else {
            }
            if (i14 != 0) {
            }
            str4 = str7;
            i20 = 2;
            str7 = str3;
            if (i49 != i20) {
            } else {
            }
            str2 = "height";
            i13 = i15;
            i15 = i19;
            bVar = w.a(str6.a, displayMetrics.density);
            iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                obj2 = next4;
                equals = hashMap.put(obj2, (String)hashMap.get((String)obj2));
                if ((String)equals != null) {
                } else {
                }
                i2 = 1;
                g.f(i2);
                iterator = i19;
                bVar = bVar2;
                if ((String)equals.equals(hashMap.get(obj2))) {
                } else {
                }
                i2 = 0;
            }
            bVar2 = bVar;
            Object[] arr3 = new Object[14];
            i17 = 2;
            arr3[i17] = Float.valueOf(i16);
            str10 = 3;
            arr3[str10] = str7;
            i4 = 4;
            arr3[i4] = str;
            arr3[5] = str2;
            arr3[6] = str11;
            arr3[7] = b0.c(str6.b);
            arr3[8] = b0.f(str6.p);
            arr3[9] = obj.e(str6.n, str6.o);
            arr3[10] = n.b(i9);
            arr3[11] = Integer.valueOf(i13);
            arr3[12] = Integer.valueOf(i15);
            arr3[13] = b0.h((c)str6);
            stringBuilder2.append(p0.z("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", arr3));
            int i22 = 1;
            Object[] arr4 = new Object[i22];
            int i41 = 0;
            arr4[i41] = str33;
            stringBuilder2.append(p0.z("<span class='%s'>", arr4));
            Layout.Alignment alignment = str6.c;
            String str30 = "</span>";
            if (alignment != null) {
            } else {
            }
            stringBuilder2.append(bVar3.a);
            stringBuilder2.append(str30);
            stringBuilder2.append("</div>");
            i12++;
            str5 = 1067030938;
            arr2 = 0;
            obj = this;
            i7 = str10;
            i3 = i17;
            i11 = i4;
            i10 = 1;
            arr = new Object[i22];
            arr[i41] = b0.c(alignment);
            stringBuilder2.append(p0.z("<span style='display:inline-block; text-align:%s;'>", arr));
            stringBuilder2.append(bVar4.a);
            stringBuilder2.append(str30);
            obj2 = next4;
            equals = hashMap.put(obj2, (String)hashMap.get((String)obj2));
            if ((String)equals != null) {
            } else {
            }
            i2 = 1;
            g.f(i2);
            iterator = i19;
            bVar = bVar2;
            if ((String)equals.equals(hashMap.get(obj2))) {
            } else {
            }
            i2 = 0;
            if (i49 == 1) {
            } else {
            }
            str2 = "width";
            i13 = i19;
            str3 = str4;
            if (i49 != 2) {
            } else {
            }
            if (i14 != 0) {
            } else {
            }
            if (i14 != 0) {
            }
            i20 = 2;
            str7 = "bottom";
            i9 = str6.m;
            arr2 = new Object[i10];
            arr2[0] = Float.valueOf(f2 *= i18);
            str11 = p0.z(str34, arr2);
            if (str6.f != i10) {
            } else {
            }
            String str38 = "%.2fem";
            if (Float.compare(f, i48) >= 0) {
            } else {
            }
            Object[] arr8 = new Object[i10];
            arr8[arr2] = Float.valueOf(i25 *= str5);
            str = p0.z(str38, arr8);
            i5 = arr2;
            i14 = i10;
            Object[] arr9 = new Object[i10];
            arr9[arr2] = Float.valueOf(f *= str5);
            str = p0.z(str38, arr9);
            i14 = i5;
            Object[] arr7 = new Object[i10];
            arr7[arr2] = Float.valueOf(f *= i18);
            str = p0.z(str34, arr7);
            if (str6.p == i10) {
            } else {
            }
            i5 = b0.b(str6.g);
            i5 = -i47;
            f6 *= i18;
        }
        stringBuilder2.append("</div></body></html>");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><style>");
        Iterator iterator2 = hashMap.keySet().iterator();
        for (String next3 : iterator2) {
            stringBuilder.append(next3);
            stringBuilder.append("{");
            stringBuilder.append((String)hashMap.get(next3));
            stringBuilder.append("}");
        }
        stringBuilder.append("</style></head>");
        stringBuilder2.insert(0, stringBuilder.toString());
        obj3.b.loadData(Base64.encodeToString(stringBuilder2.toString().getBytes(d.c), 1), "text/html", "base64");
    }

    public void a(List<c> list, com.google.android.exoplayer2.ui.k k2, float f3, int i4, float f5) {
        int i;
        Object obj;
        android.graphics.Bitmap bitmap;
        boolean obj7;
        this.v = k2;
        this.w = f3;
        this.x = i4;
        this.y = f5;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            if (obj.d != null) {
            } else {
            }
            arrayList.add((c)obj);
            i++;
            arrayList2.add(obj);
        }
        if (this.c.isEmpty()) {
            if (!arrayList.isEmpty()) {
                this.c = arrayList;
                i();
            }
        } else {
        }
        this.a.a(arrayList2, k2, f3, i4, f5);
        invalidate();
    }

    @Override // android.widget.FrameLayout
    public void g() {
        this.b.destroy();
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean obj1;
        super.onLayout(z, i2, i3, i4, i5);
        if (z && !this.c.isEmpty()) {
            if (!this.c.isEmpty()) {
                i();
            }
        }
    }
}
