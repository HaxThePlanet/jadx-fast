package com.facebook.internal.h0.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.widget.TextView;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0018H\u0002¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "", "()V", "lithoViewToStringMethod", "Ljava/lang/reflect/Method;", "rootResolver", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver;", "webViewDumpHelper", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper;", "dumpViewHierarchy", "", "prefix", "", "writer", "Ljava/io/PrintWriter;", "view", "Landroid/view/View;", "leftOffset", "", "topOffset", "withWebView", "", "withProps", "args", "", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "writeLithoViewSubHierarchy", "Api21Utils", "Api24Utils", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static com.facebook.internal.h0.a.b d;
    private static Method e;
    public static final com.facebook.internal.h0.a.b.c f;
    private final com.facebook.internal.h0.a.a a;
    private final com.facebook.internal.h0.a.d b;
    private Method c;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0008R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api21Utils;", "", "()V", "keyedTagsField", "Ljava/lang/reflect/Field;", "getTags", "Lorg/json/JSONObject;", "view", "Landroid/view/View;", "writeExtraProps", "", "writer", "Ljava/io/PrintWriter;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        private static Field a;
        public static final com.facebook.internal.h0.a.b.a b;
        static {
            String str;
            b.a aVar = new b.a();
            b.a.b = aVar;
            Field declaredField = View.class.getDeclaredField("mKeyedTags");
            b.a.a = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
        }

        private final JSONObject a(View view) {
            int i2;
            int i;
            Field declaredField;
            Object obj;
            String jSONObject;
            int size;
            String str;
            Object valueAt;
            declaredField = View.class.getDeclaredField("mKeyedTags");
            b.a.a = declaredField;
            if (b.a.a == null && declaredField != null) {
                try {
                    declaredField = View.class.getDeclaredField("mKeyedTags");
                    b.a.a = declaredField;
                    if (declaredField != null) {
                    }
                    declaredField.setAccessible(true);
                    Field field = b.a.a;
                    if (field != null) {
                    } else {
                    }
                    obj = field.get(view);
                    obj = i2;
                    if (obj == null) {
                    } else {
                    }
                    if (obj != null && (SparseArray)obj.size() > 0) {
                    }
                    if (obj.size() > 0) {
                    }
                    jSONObject = new JSONObject();
                    i = 0;
                    while (i < obj.size()) {
                        jSONObject.put(c.c(view.getResources(), obj.keyAt(i)), obj.valueAt(i));
                        i++;
                    }
                    jSONObject.put(c.c(view.getResources(), obj.keyAt(i)), obj.valueAt(i));
                    i++;
                    i2 = jSONObject;
                    NullPointerException obj7 = new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<*>");
                    throw obj7;
                    return i2;
                } catch (Exception e) {
                }
            }
        }

        public final void b(PrintWriter printWriter, View view2) {
            Object str;
            int length;
            AccessibilityNodeInfo accessibilityNodeInfo;
            JSONObject jSONObject;
            int i2;
            boolean label;
            boolean next;
            boolean visibleToUser;
            java.lang.CharSequence className;
            int i;
            Object obj8;
            int obj9;
            n.f(printWriter, "writer");
            n.f(view2, "view");
            if (Build.VERSION.SDK_INT < 21) {
            }
            str = b.f;
            accessibilityNodeInfo = b.c.a(str, view2);
            jSONObject = new JSONObject();
            i2 = 50;
            if (accessibilityNodeInfo != null && view2 instanceof TextView != null) {
                jSONObject = new JSONObject();
                i2 = 50;
                if (view2 instanceof TextView != null) {
                    ColorStateList textColors = (TextView)view2.getTextColors();
                    String str26 = "view.textColors";
                    n.e(textColors, str26);
                    jSONObject.put("textColor", textColors.getDefaultColor());
                    jSONObject.put("textSize", (double)textSize);
                    jSONObject.put("hint", b.c.b(str, (TextView)view2.getHint(), 100));
                }
                obj9 = a(view2);
                if (obj9 != null) {
                    jSONObject.put("keyedTags", obj9);
                }
                obj9 = new JSONArray();
                Iterator iterator = accessibilityNodeInfo.getActionList().iterator();
                for (AccessibilityNodeInfo.AccessibilityAction next2 : iterator) {
                    n.e(next2, "action");
                    label = next2.getLabel();
                    if ((String)label) {
                    }
                    obj9.put(b.c.b(b.f, (String)label, i2));
                }
                if (obj9.length() > 0) {
                    jSONObject.put("actions", obj9);
                }
                obj9 = b.f;
                String str6 = b.c.b(obj9, accessibilityNodeInfo.getContentDescription(), i2);
                if (str6 != null) {
                    next = str6.length() > 0 ? 1 : 0;
                    if (next != 0) {
                        jSONObject.put("content-description", str6);
                    }
                }
                jSONObject.put("accessibility-focused", accessibilityNodeInfo.isAccessibilityFocused()).put("checkable", accessibilityNodeInfo.isCheckable()).put("checked", accessibilityNodeInfo.isChecked()).put("class-name", b.c.b(obj9, accessibilityNodeInfo.getClassName(), i2)).put("clickable", accessibilityNodeInfo.isClickable()).put("content-invalid", accessibilityNodeInfo.isContentInvalid()).put("dismissable", accessibilityNodeInfo.isDismissable()).put("editable", accessibilityNodeInfo.isEditable()).put("enabled", accessibilityNodeInfo.isEnabled()).put("focusable", accessibilityNodeInfo.isFocusable()).put("focused", accessibilityNodeInfo.isFocused()).put("long-clickable", accessibilityNodeInfo.isLongClickable()).put("multiline", accessibilityNodeInfo.isMultiLine()).put("password", accessibilityNodeInfo.isPassword()).put("scrollable", accessibilityNodeInfo.isScrollable()).put("selected", accessibilityNodeInfo.isSelected()).put("visible-to-user", accessibilityNodeInfo.isVisibleToUser());
                if (Build.VERSION.SDK_INT >= 24) {
                    b.b.a.a(jSONObject, accessibilityNodeInfo);
                }
                printWriter.append(" props=\"").append(jSONObject.toString()).append("\"");
            }
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api24Utils;", "", "()V", "addExtraProps", "", "props", "Lorg/json/JSONObject;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b {

        public static final com.facebook.internal.h0.a.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        public final void a(JSONObject jSONObject, AccessibilityNodeInfo accessibilityNodeInfo2) {
            n.f(jSONObject, "props");
            n.f(accessibilityNodeInfo2, "nodeInfo");
            if (Build.VERSION.SDK_INT < 24) {
            }
            jSONObject.put("context-clickable", accessibilityNodeInfo2.isContextClickable()).put("drawing-order", accessibilityNodeInfo2.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo2.isImportantForAccessibility());
        }
    }

    @Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J%\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J-\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010)\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010-\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010.\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Companion;", "", "()V", "ALL_ROOTS_ARGUMENT", "", "E2E_ARGUMENT", "LITHO_VIEW_CLASS", "LITHO_VIEW_TEST_HELPER_CLASS", "LITHO_VIEW_TO_STRING_METHOD", "RC_TEXT_VIEW_SIMPLE_CLASS_NAME", "TOP_ROOT_ARGUMENT", "WITH_PROPS_ARGUMENT", "WITH_WEBVIEW_ARGUMENT", "instance", "Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "rcTextViewGetTextMethod", "Ljava/lang/reflect/Method;", "createNodeInfoFromView", "Landroid/view/accessibility/AccessibilityNodeInfo;", "view", "Landroid/view/View;", "fixString", "str", "", "maxLength", "", "getTextFromRcTextView", "hasArgument", "", "args", "", "argument", "([Ljava/lang/String;Ljava/lang/String;)Z", "isExtendsLithoView", "maybeDump", "prefix", "writer", "Ljava/io/PrintWriter;", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)Z", "maybeWriteViewTestIdFromTag", "", "writeViewBounds", "leftOffset", "topOffset", "writeViewFlags", "writeViewTestId", "writeViewText", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c {
        public c(g g) {
            super();
        }

        public static final AccessibilityNodeInfo a(com.facebook.internal.h0.a.b.c b$c, View view2) {
            return c.i(view2);
        }

        public static final String b(com.facebook.internal.h0.a.b.c b$c, java.lang.CharSequence charSequence2, int i3) {
            return c.j(charSequence2, i3);
        }

        public static final boolean c(com.facebook.internal.h0.a.b.c b$c, String[] string2Arr2, String string3) {
            return c.l(string2Arr2, string3);
        }

        public static final boolean d(com.facebook.internal.h0.a.b.c b$c, View view2) {
            return c.m(view2);
        }

        public static final void e(com.facebook.internal.h0.a.b.c b$c, PrintWriter printWriter2, View view3, int i4, int i5) {
            c.p(printWriter2, view3, i4, i5);
        }

        public static final void f(com.facebook.internal.h0.a.b.c b$c, PrintWriter printWriter2, View view3) {
            c.q(printWriter2, view3);
        }

        public static final void g(com.facebook.internal.h0.a.b.c b$c, PrintWriter printWriter2, View view3) {
            c.r(printWriter2, view3);
        }

        public static final void h(com.facebook.internal.h0.a.b.c b$c, PrintWriter printWriter2, View view3) {
            c.s(printWriter2, view3);
        }

        private final AccessibilityNodeInfo i(View view) {
            if (view == null) {
                return null;
            }
            final AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            view.onInitializeAccessibilityNodeInfo(obtain);
            return obtain;
        }

        private final String j(java.lang.CharSequence charSequence, int i2) {
            int str2;
            int i;
            String string;
            int i3;
            int stringBuilder;
            String str;
            str2 = i2;
            if (charSequence != null) {
                i3 = 0;
                i = charSequence.length() == 0 ? 1 : i3;
                if (i != 0) {
                } else {
                    final int i4 = 0;
                    final int i5 = 4;
                    final int i6 = 0;
                    string = l.G(l.G(l.G(charSequence.toString(), " \n", " ", i4, i5, i6), "\n", " ", false, 4, 0), "\"", "", i4, i5, i6);
                    if (charSequence.length() > str2) {
                        stringBuilder = new StringBuilder();
                        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
                        String substring = string.substring(i3, str2);
                        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        stringBuilder.append(substring);
                        stringBuilder.append("...");
                        string = stringBuilder.toString();
                    }
                }
                return string;
            }
            return "";
        }

        private final String k(View view) {
            Method declaredMethod;
            Object[] arr2;
            Class[] arr;
            int string;
            String str;
            Object obj5;
            arr2 = 0;
            if (b.c() == null) {
                b.e(view.getClass().getDeclaredMethod("getText", new Class[arr2]));
            }
            Method method = b.c();
            if (method != null) {
                obj5 = method.invoke(view, new Object[arr2]);
            } else {
                obj5 = string;
            }
            if (obj5 != null) {
                string = obj5.toString();
            }
            return string;
        }

        private final boolean l(String[] stringArr, String string2) {
            int i;
            boolean z;
            int i2;
            final int i3 = 0;
            if (stringArr == null) {
                return i3;
            }
            i = i3;
            while (i < stringArr.length) {
                i2 = 1;
                i++;
            }
            return i3;
        }

        private final boolean m(View view) {
            boolean z;
            String str;
            Class obj3;
            obj3 = view.getClass();
            while (obj3 != null) {
                obj3 = obj3.getSuperclass();
            }
            return 0;
        }

        private final void o(PrintWriter printWriter, View view2) {
            int i2;
            boolean i;
            Object obj3;
            if (obj3 instanceof String == null) {
                obj3 = 0;
            }
            if ((String)obj3 != null) {
                i2 = (String)obj3.length() == 0 ? 1 : 0;
                if (i2 != 0) {
                }
                printWriter.print(" app:tag/");
                printWriter.print(j(obj3, 60));
            }
        }

        private final void p(PrintWriter printWriter, View view2, int i3, int i4) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            printWriter.print(" ");
            int i2 = 0;
            printWriter.print(i8 -= i3);
            String str2 = ",";
            printWriter.print(str2);
            final int i10 = 1;
            printWriter.print(i11 -= i4);
            printWriter.print("-");
            printWriter.print(i6 -= i3);
            printWriter.print(str2);
            printWriter.print(obj8 -= i4);
        }

        private final void q(PrintWriter printWriter, View view2) {
            String str5;
            String str9;
            int visibility;
            String str7;
            String str10;
            String str4;
            String str11;
            String str;
            String str6;
            String str3;
            int i;
            String str2;
            String str8;
            String str12 = " ";
            printWriter.print(str12);
            visibility = view2.getVisibility();
            str3 = ".";
            if (visibility != 0) {
                if (visibility != 4) {
                    if (visibility != 8) {
                        printWriter.print(str3);
                    } else {
                        printWriter.print("G");
                    }
                } else {
                    printWriter.print("I");
                }
            } else {
                printWriter.print("V");
            }
            str7 = view2.isFocusable() ? str2 : str3;
            printWriter.print(str7);
            str10 = view2.isEnabled() ? "E" : str3;
            printWriter.print(str10);
            printWriter.print(str3);
            str4 = view2.isHorizontalScrollBarEnabled() ? str8 : str3;
            printWriter.print(str4);
            if (view2.isVerticalScrollBarEnabled()) {
            } else {
                str6 = str3;
            }
            printWriter.print(str6);
            str11 = view2.isClickable() ? "C" : str3;
            printWriter.print(str11);
            str = view2.isLongClickable() ? "L" : str3;
            printWriter.print(str);
            printWriter.print(str12);
            if (view2.isFocused()) {
            } else {
                str2 = str3;
            }
            printWriter.print(str2);
            str5 = view2.isSelected() ? "S" : str3;
            printWriter.print(str5);
            if (view2.isHovered()) {
            } else {
                str8 = str3;
            }
            printWriter.print(str8);
            str9 = view2.isActivated() ? "A" : str3;
            printWriter.print(str9);
            if (view2.isDirty()) {
                str3 = "D";
            }
            printWriter.print(str3);
        }

        private final void r(PrintWriter printWriter, View view2) {
            String resourcePackageName;
            String str;
            try {
                int id = view2.getId();
                if (id == -1) {
                }
                o(printWriter, view2);
                printWriter.append(" #");
                printWriter.append(Integer.toHexString(id));
                Resources resources = view2.getResources();
                if (id > 0 && resources == null) {
                }
                if (resources == null) {
                }
                i2 &= id;
                if (i3 != 16777216) {
                } else {
                }
                if (i3 != 2130706432) {
                } else {
                }
                n.e(resources.getResourcePackageName(id), "resources.getResourcePackageName(id)");
                resourcePackageName = "app";
                resourcePackageName = "android";
                printWriter.print(" ");
                printWriter.print(resourcePackageName);
                printWriter.print(":");
                printWriter.print(resources.getResourceTypeName(id));
                printWriter.print("/");
                printWriter.print(resources.getResourceEntryName(id));
                o(printWriter, view2);
                o(printWriter, view2);
            }
        }

        private final void s(PrintWriter printWriter, View view2) {
            int string;
            int i4;
            java.lang.CharSequence contentDescription;
            int i;
            int str;
            int i3;
            int i2;
            int i5;
            Object obj9;
            string = 0;
            i = 0;
            final int i6 = 1;
            if (view2 instanceof TextView != null) {
                try {
                    obj9 = (TextView)view2.getText().toString();
                    if (n.b(view2.getClass().getSimpleName(), "RCTextView")) {
                    } else {
                    }
                    obj9 = k(view2);
                    contentDescription = view2.getContentDescription();
                    if (contentDescription != null) {
                    }
                    string = contentDescription.toString();
                    if (string != null) {
                    } else {
                    }
                    if (string.length() == 0) {
                    } else {
                    }
                    contentDescription = i6;
                    contentDescription = i;
                    obj9 = view2.getTag();
                    if (contentDescription != 0 && obj9 != null) {
                    } else {
                    }
                    obj9 = view2.getTag();
                    if (obj9 != null) {
                    } else {
                    }
                    obj9 = obj9.toString();
                    length -= i6;
                    str = contentDescription;
                    while (contentDescription <= i4) {
                        if (str == null) {
                        } else {
                        }
                        i2 = i4;
                        if (n.h(obj9.charAt(i2), 32) <= 0) {
                        } else {
                        }
                        i3 = i;
                        if (str != null) {
                            break;
                        } else {
                        }
                        if (i3 == 0) {
                            break;
                        } else {
                        }
                        i4--;
                        if (i3 == 0) {
                        } else {
                        }
                        contentDescription++;
                        str = i6;
                        i3 = i6;
                        i2 = contentDescription;
                    }
                    if (str == null) {
                    } else {
                    }
                    i2 = contentDescription;
                    i2 = i4;
                    if (n.h(obj9.charAt(i2), 32) <= 0) {
                    } else {
                    }
                    i3 = i6;
                    i3 = i;
                    if (str == null) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    str = i6;
                    contentDescription++;
                    if (i3 == 0) {
                    } else {
                    }
                    i4--;
                    obj9 = obj9.subSequence(contentDescription, i4 += i6).toString();
                    obj9 = string;
                    if (obj9 != null && obj9.length() == 0) {
                    }
                    if (obj9.length() == 0) {
                    }
                    i = i6;
                    if (i != 0) {
                    } else {
                    }
                    printWriter.print(" text=\"");
                    printWriter.print(j(obj9, 600));
                    printWriter.print("\"");
                }
            } else {
            }
        }

        public final boolean n(String string, PrintWriter printWriter2, String[] string3Arr3) {
            com.facebook.internal.h0.a.b bVar;
            int i3;
            int i2;
            int i;
            String str;
            n.f(string, "prefix");
            n.f(printWriter2, "writer");
            int i4 = 0;
            if (string3Arr3 != null) {
                i = 1;
                i2 = string3Arr3.length == 0 ? i : i4;
                if (i2 ^= i != 0 && n.b("e2e", string3Arr3[i4]) && b.b() == null) {
                    if (n.b("e2e", string3Arr3[i4])) {
                        if (b.b() == null) {
                            bVar = new b();
                            b.d(bVar);
                        }
                        com.facebook.internal.h0.a.b bVar2 = b.b();
                        if (bVar2 != null) {
                            b.a(bVar2, string, printWriter2, string3Arr3);
                        }
                        return i;
                    }
                }
            }
            return i4;
        }
    }
    static {
        b.c cVar = new b.c(0);
        b.f = cVar;
    }

    public b() {
        super();
        a aVar = new a();
        this.a = aVar;
        d dVar = new d();
        this.b = dVar;
    }

    public static final void a(com.facebook.internal.h0.a.b b, String string2, PrintWriter printWriter3, String[] string4Arr4) {
        b.g(string2, printWriter3, string4Arr4);
    }

    public static final com.facebook.internal.h0.a.b b() {
        return b.d;
    }

    public static final Method c() {
        return b.e;
    }

    public static final void d(com.facebook.internal.h0.a.b b) {
        b.d = b;
    }

    public static final void e(Method method) {
        b.e = method;
    }

    private final void f(String string, PrintWriter printWriter2, View view3, int i4, int i5, boolean z6, boolean z7) {
        int i;
        View view;
        boolean z2;
        StringBuilder stringBuilder;
        int sDK_INT;
        Object childAt;
        int i3;
        int i2;
        boolean z;
        int i6;
        int i7;
        final Object obj = this;
        String str = string;
        final PrintWriter writer = printWriter2;
        view = view3;
        final boolean z5 = z7;
        writer.print(str);
        if (view == null) {
            writer.println("null");
        }
        writer.print(view3.getClass().getName());
        writer.print("{");
        writer.print(Integer.toHexString(view3.hashCode()));
        com.facebook.internal.h0.a.b.c cVar = b.f;
        b.c.f(cVar, writer, view);
        b.c.e(cVar, writer, view, i4, i5);
        b.c.g(cVar, writer, view);
        b.c.h(cVar, writer, view);
        if (z5 && Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                b.a.b.b(writer, view);
            }
        }
        writer.println("}");
        if (b.c.d(cVar, view)) {
            obj.h(writer, view, str, z5);
        }
        if (z6 && view instanceof WebView != null) {
            if (view instanceof WebView != null) {
                obj.b.c((WebView)view);
            }
        }
        if (!view instanceof ViewGroup) {
        }
        final View view2 = view;
        final int childCount = (ViewGroup)view2.getChildCount();
        if (childCount <= 0) {
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        final int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        final int i10 = 0;
        i6 = i10;
        while (i6 < childCount) {
            this.f(stringBuilder.toString(), printWriter2, view2.getChildAt(i6), iArr[i10], iArr[1], z6, z7);
            i6 = i7 + 1;
        }
    }

    private final void g(String string, PrintWriter printWriter2, String[] string3Arr3) {
        com.facebook.internal.h0.a.d dVar;
        List visibility;
        com.facebook.internal.h0.a.b.c empty;
        int string2;
        String str;
        View view;
        int i;
        int i2;
        boolean z;
        boolean z2;
        List list;
        final Object obj2 = this;
        String str2 = string;
        final PrintWriter writer = printWriter2;
        String[] strArr = string3Arr3;
        writer.print(str2);
        writer.println("Top Level Window View Hierarchy:");
        empty = b.f;
        visibility = obj2.a.b();
        if (visibility != null && visibility.isEmpty()) {
            if (visibility.isEmpty()) {
            }
            Collections.reverse(visibility);
            string2 = 0;
            final Iterator iterator = visibility.iterator();
            while (iterator.hasNext()) {
                list = visibility;
                if ((a.a)list != null) {
                    break;
                } else {
                }
                visibility = (a.a)list.b();
                if (visibility != null) {
                    break;
                } else {
                }
                if (visibility.getVisibility() == null) {
                    break;
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append("  ");
                this.f(stringBuilder2.toString(), printWriter2, list.b(), 0, 0, b.c.c(empty, strArr, "webview"), b.c.c(empty, strArr, "props"));
                string2 = visibility;
            }
            obj2.b.b(writer);
        }
    }

    private final void h(PrintWriter printWriter, View view2, String string3, boolean z4) {
        Method declaredMethod;
        int arr;
        String str;
        int invoke;
        Class[] arr2;
        Class tYPE;
        PrintWriter obj9;
        Object obj10;
        java.lang.CharSequence obj11;
        String obj12;
        try {
            final int i = 0;
            arr = 3;
            final int i2 = 2;
            final int i3 = 1;
            if (this.c == null) {
            }
            Class forName = Class.forName("com.facebook.litho.LithoViewTestHelper");
            n.e(forName, "Class.forName(LITHO_VIEW_TEST_HELPER_CLASS)");
            arr2 = new Class[arr];
            arr2[i] = View.class;
            arr2[i3] = Integer.TYPE;
            arr2[i2] = Boolean.TYPE;
            this.c = forName.getDeclaredMethod("viewToStringForE2E", arr2);
            Method method = this.c;
            if (method != null) {
            }
            arr = new Object[arr];
            arr[i] = view2;
            arr[i3] = Integer.valueOf(obj10 += i3);
            arr[i2] = Boolean.valueOf(z4);
            invoke = method.invoke(0, arr);
            if (invoke == 0) {
            } else {
            }
            n.e(printWriter.append((String)invoke), "writer.append(lithoViewDump)");
            obj10 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            throw obj10;
            printWriter = printWriter.append(string3);
            string3 = "Failed litho view sub hierarch dump: ";
            printWriter = printWriter.append(string3);
            string3 = b.f;
            view2 = view2.getMessage();
            z4 = true;
            view2 = b.c.b(string3, view2, z4);
            printWriter = printWriter.append(view2);
            printWriter.println();
        }
    }
}
