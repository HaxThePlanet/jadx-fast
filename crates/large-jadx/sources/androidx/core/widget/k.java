package androidx.core.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import d.h.j.d;
import d.h.j.d.a;
import d.h.j.d.a.a;
import d.h.k.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    private static class a implements ActionMode.Callback {

        private final ActionMode.Callback a;
        private final TextView b;
        private Class<?> c;
        private Method d;
        private boolean e;
        private boolean f = false;
        a(ActionMode.Callback actionMode$Callback, TextView textView2) {
            super();
            this.a = callback;
            this.b = textView2;
            final int obj1 = 0;
        }

        private Intent a() {
            Intent intent = new Intent();
            return intent.setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView2) {
            android.content.pm.ActivityInfo obj3 = resolveInfo.activityInfo;
            return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", obj4 ^= 1).setClassName(obj3.packageName, obj3.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager2) {
            Intent next;
            int i;
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity == null) {
                return arrayList;
            }
            Iterator obj5 = packageManager2.queryIntentActivities(a(), 0).iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if (e((ResolveInfo)next, context) != 0) {
                }
                arrayList.add(next);
            }
            return arrayList;
        }

        private boolean d(TextView textView) {
            boolean onCheckIsTextEditor;
            int obj2;
            if (textView instanceof Editable && textView.onCheckIsTextEditor() && textView.isEnabled()) {
                if (textView.onCheckIsTextEditor()) {
                    obj2 = textView.isEnabled() ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        private boolean e(ResolveInfo resolveInfo, Context context2) {
            int i;
            String obj4;
            if (context2.getPackageName().equals(activityInfo.packageName)) {
                return 1;
            }
            obj4 = resolveInfo.activityInfo;
            final int i2 = 0;
            if (!obj4.exported) {
                return i2;
            }
            obj4 = obj4.permission;
            if (obj4 != null) {
                if (context2.checkSelfPermission(obj4) == 0) {
                } else {
                    i = i2;
                }
            }
            return i;
        }

        private void f(Menu menu) {
            boolean declaredMethod2;
            boolean instance;
            Method declaredMethod;
            int i;
            int intent;
            Class[] equals;
            Class valueOf;
            Context context = this.b.getContext();
            final PackageManager packageManager = context.getPackageManager();
            String str2 = "removeItemAt";
            final int i3 = 0;
            final int i4 = 1;
            if (!this.f) {
                this.f = i4;
                Class forName = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.c = forName;
                equals = new Class[i4];
                equals[i3] = Integer.TYPE;
                this.d = forName.getDeclaredMethod(str2, equals);
                this.e = i4;
            }
            if (this.e && this.c.isInstance(menu)) {
                if (this.c.isInstance(menu)) {
                    declaredMethod = this.d;
                } else {
                    equals = new Class[i4];
                    equals[i3] = Integer.TYPE;
                    declaredMethod = menu.getClass().getDeclaredMethod(str2, equals);
                }
            } else {
            }
            size -= i4;
            while (intent >= 0) {
                equals = menu.getItem(intent);
                if (equals.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(equals.getIntent().getAction())) {
                }
                intent--;
                if ("android.intent.action.PROCESS_TEXT".equals(equals.getIntent().getAction())) {
                }
                equals = new Object[i4];
                equals[i3] = Integer.valueOf(intent);
                declaredMethod.invoke(menu, equals);
            }
            List list = c(context, packageManager);
            i = i3;
            while (i < list.size()) {
                Object obj = list.get(i);
                menu.add(i3, i3, i + 100, (ResolveInfo)obj.loadLabel(packageManager)).setIntent(b(obj, this.b)).setShowAsAction(i4);
                i++;
            }
        }

        @Override // android.view.ActionMode$Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem2) {
            return this.a.onActionItemClicked(actionMode, menuItem2);
        }

        @Override // android.view.ActionMode$Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu2) {
            return this.a.onCreateActionMode(actionMode, menu2);
        }

        @Override // android.view.ActionMode$Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode$Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu2) {
            f(menu2);
            return this.a.onPrepareActionMode(actionMode, menu2);
        }
    }
    public static Drawable[] a(TextView textView) {
        int layoutDirection;
        int i;
        Drawable drawable;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (sDK_INT >= 17) {
            final int i4 = 0;
            if (textView.getLayoutDirection() == 1) {
            } else {
                i = i4;
            }
            Drawable[] obj4 = textView.getCompoundDrawables();
            if (i != 0) {
                layoutDirection = 2;
                obj4[i4] = obj4[layoutDirection];
                obj4[layoutDirection] = obj4[i4];
            }
            return obj4;
        }
        return textView.getCompoundDrawables();
    }

    public static int b(TextView textView) {
        return paddingTop -= obj1;
    }

    public static int c(TextView textView) {
        return paddingBottom += obj1;
    }

    public static int d(TextView textView) {
        boolean z;
        Field field;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        int i2 = 1;
        if (!k.d) {
            k.c = k.h("mMaxMode");
            k.d = i2;
        }
        field = k.c;
        if (field != null && k.i(field, textView) == i2 && !k.b) {
            if (k.i(field, textView) == i2) {
                if (!k.b) {
                    k.a = k.h("mMaximum");
                    k.b = i2;
                }
                field = k.a;
                if (field != null) {
                    return k.i(field, textView);
                }
            }
        }
        return -1;
    }

    private static int e(TextDirectionHeuristic textDirectionHeuristic) {
        final int i = 1;
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return i;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return i;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return i;
    }

    private static TextDirectionHeuristic f(TextView textView) {
        int sDK_INT;
        int i2;
        int i;
        TextDirectionHeuristic obj4;
        if (transformationMethod instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        i = 0;
        final int i5 = 1;
        obj4 = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[i].codePointAt(i));
        if (Build.VERSION.SDK_INT >= 28 && inputType &= 15 == 3 && obj4 != i5 && obj4 == 2) {
            if (inputType &= 15 == 3) {
                obj4 = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[i].codePointAt(i));
                if (obj4 != i5) {
                    if (obj4 == 2) {
                    }
                    return TextDirectionHeuristics.LTR;
                }
                return TextDirectionHeuristics.RTL;
            }
        }
        if (textView.getLayoutDirection() == i5) {
            i = i5;
        }
        switch (obj4) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                obj4 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                return obj4;
        }
        obj4 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
    }

    public static d.a g(TextView textView) {
        int hyphenationFrequency;
        Object obj4;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 28) {
            d.a aVar = new d.a(textView.getTextMetricsParams());
            return aVar;
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        d.a.a aVar2 = new d.a.a(textPaint);
        if (sDK_INT >= 23) {
            aVar2.b(textView.getBreakStrategy());
            aVar2.c(textView.getHyphenationFrequency());
        }
        if (sDK_INT >= 18) {
            aVar2.d(k.f(textView));
        }
        return aVar2.a();
    }

    private static Field h(String string) {
        int i;
        String str;
        String obj3;
        int i2 = 0;
        Field declaredField = TextView.class.getDeclaredField(string);
        declaredField.setAccessible(true);
        return declaredField;
    }

    private static int i(Field field, TextView textView2) {
        try {
            return field.getInt(textView2);
            textView2 = new StringBuilder();
            textView2.append("Could not retrieve value of ");
            field = field.getName();
            textView2.append(field);
            field = " field.";
            textView2.append(field);
            field = textView2.toString();
            textView2 = "TextViewCompat";
            Log.d(textView2, field);
            field = -1;
            return field;
        }
    }

    public static void j(TextView textView, ColorStateList colorStateList2) {
        int sDK_INT;
        i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList2);
        } else {
            if (textView instanceof m) {
                (m)textView.setSupportCompoundDrawablesTintList(colorStateList2);
            }
        }
    }

    public static void k(TextView textView, PorterDuff.Mode porterDuff$Mode2) {
        int sDK_INT;
        i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode2);
        } else {
            if (textView instanceof m) {
                (m)textView.setSupportCompoundDrawablesTintMode(mode2);
            }
        }
    }

    public static void l(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        int sDK_INT;
        int i;
        Drawable obj3;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable5);
        } else {
            if (sDK_INT >= 17) {
                if (textView.getLayoutDirection() == 1) {
                } else {
                    i = 0;
                }
                sDK_INT = i != 0 ? drawable4 : drawable2;
                if (i != 0) {
                } else {
                    obj3 = drawable4;
                }
                textView.setCompoundDrawables(sDK_INT, drawable3, obj3, drawable5);
            } else {
                textView.setCompoundDrawables(drawable2, drawable3, drawable4, drawable5);
            }
        }
    }

    public static void m(TextView textView, int i2) {
        int paddingLeft;
        int includeFontPadding;
        int paddingRight;
        int paddingBottom;
        int obj4;
        i.b(i2);
        includeFontPadding = Build.VERSION.SDK_INT;
        if (includeFontPadding >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (includeFontPadding >= 16) {
            if (textView.getIncludeFontPadding()) {
                paddingLeft = fontMetricsInt.top;
            } else {
                paddingLeft = fontMetricsInt.ascent;
            }
        } else {
        }
        if (i2 > Math.abs(paddingLeft)) {
            textView.setPadding(textView.getPaddingLeft(), i2 += paddingLeft, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void n(TextView textView, int i2) {
        int paddingLeft;
        boolean includeFontPadding;
        int paddingTop;
        int paddingRight;
        int obj4;
        i.b(i2);
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) {
            if (textView.getIncludeFontPadding()) {
                paddingLeft = fontMetricsInt.bottom;
            } else {
                paddingLeft = fontMetricsInt.descent;
            }
        } else {
        }
        if (i2 > Math.abs(paddingLeft)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 -= paddingLeft);
        }
    }

    public static void o(TextView textView, int i2) {
        int fontMetricsInt;
        int obj3;
        i.b(i2);
        fontMetricsInt = textView.getPaint().getFontMetricsInt(0);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float)obj3, 1065353216);
        }
    }

    public static void p(TextView textView, d d2) {
        int sDK_INT;
        int i;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(d2.b());
        } else {
            if (!k.g(textView).a(d2.a())) {
            } else {
                textView.setText(d2);
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Given text can not be applied to TextView.");
        throw obj2;
    }

    public static void q(TextView textView, int i2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void r(TextView textView, d.a d$a2) {
        float textScaleX;
        int i;
        TextPaint paint;
        int obj3;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 18) {
            textView.setTextDirection(k.e(a2.d()));
        }
        if (sDK_INT < 23) {
            textScaleX = a2.e().getTextScaleX();
            textView.getPaint().set(a2.e());
            if (Float.compare(textScaleX, obj3) == 0) {
                textView.setTextScaleX(obj3 += paint);
            }
            textView.setTextScaleX(textScaleX);
        } else {
            textView.getPaint().set(a2.e());
            textView.setBreakStrategy(a2.b());
            textView.setHyphenationFrequency(a2.c());
        }
    }

    public static ActionMode.Callback s(TextView textView, ActionMode.Callback actionMode$Callback2) {
        int sDK_INT;
        int i;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 26 && sDK_INT <= 27 && !callback2 instanceof k.a && callback2 == null) {
            if (sDK_INT <= 27) {
                if (!callback2 instanceof k.a) {
                    if (callback2 == null) {
                    }
                    k.a aVar = new k.a(callback2, textView);
                    return aVar;
                }
            }
        }
        return callback2;
    }
}
