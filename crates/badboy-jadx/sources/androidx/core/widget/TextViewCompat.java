package androidx.core.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.ReplaceWith;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class TextViewCompat {

    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    static class Api23Impl {
        static int getBreakStrategy(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList getCompoundDrawableTintList(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int getHyphenationFrequency(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void setBreakStrategy(TextView textView, int breakStrategy) {
            textView.setBreakStrategy(breakStrategy);
        }

        static void setCompoundDrawableTintList(TextView textView, ColorStateList tint) {
            textView.setCompoundDrawableTintList(tint);
        }

        static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode tintMode) {
            textView.setCompoundDrawableTintMode(tintMode);
        }

        static void setHyphenationFrequency(TextView textView, int hyphenationFrequency) {
            textView.setHyphenationFrequency(hyphenationFrequency);
        }
    }

    static class Api24Impl {
        static DecimalFormatSymbols getInstance(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    static class Api26Impl {
        static int getAutoSizeMaxTextSize(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        static int getAutoSizeMinTextSize(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static int[] getAutoSizeTextAvailableSizes(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        static int getAutoSizeTextType(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] presetSizes, int unit) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, unit);
        }

        static void setAutoSizeTextTypeWithDefaults(TextView textView, int autoSizeTextType) {
            textView.setAutoSizeTextTypeWithDefaults(autoSizeTextType);
        }
    }

    static class Api28Impl {
        static java.lang.CharSequence castToCharSequence(PrecomputedText precomputedText) {
            return precomputedText;
        }

        static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params getTextMetricsParams(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void setFirstBaselineToTopHeight(TextView textView, int firstBaselineToTopHeight) {
            textView.setFirstBaselineToTopHeight(firstBaselineToTopHeight);
        }
    }

    static class Api34Impl {
        public static void setLineHeight(TextView textView, int unit, float lineHeight) {
            textView.setLineHeight(unit, lineHeight);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    private static class OreoCallback implements ActionMode.Callback {

        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;
        OreoCallback(ActionMode.Callback callback, TextView textView) {
            super();
            this.mCallback = callback;
            this.mTextView = textView;
            final int i = 0;
        }

        private Intent createProcessTextIntent() {
            Intent intent = new Intent();
            return intent.setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo info, TextView textView11) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", editable ^= 1).setClassName(activityInfo.packageName, activityInfo2.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            Object next;
            boolean supportedActivity;
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity == null) {
                return arrayList;
            }
            Iterator iterator = packageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (isSupportedActivity((ResolveInfo)next, context)) {
                }
                arrayList.add(next);
            }
            return arrayList;
        }

        private boolean isEditable(TextView textView11) {
            int i;
            boolean onCheckIsTextEditor;
            if (textView11 instanceof Editable && textView11.onCheckIsTextEditor() && textView11.isEnabled()) {
                if (textView11.onCheckIsTextEditor()) {
                    i = textView11.isEnabled() ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        private boolean isSupportedActivity(ResolveInfo info, Context context) {
            int checkSelfPermission;
            int i;
            if (context.getPackageName().equals(activityInfo4.packageName)) {
                return 1;
            }
            final int i2 = 0;
            if (!activityInfo.exported) {
                return i2;
            }
            if (activityInfo2.permission != null) {
                if (context.checkSelfPermission(activityInfo3.permission) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        private void recomputeProcessTextMenuItems(Menu menu) {
            boolean mInitializedMenuBuilderReferences;
            boolean e;
            Method mMenuBuilderRemoveItemAtMethod;
            int i2;
            int i;
            int item;
            Class tYPE;
            String processTextIntentForResolveInfo;
            Context context = this.mTextView.getContext();
            final PackageManager packageManager = context.getPackageManager();
            String str2 = "removeItemAt";
            final int i3 = 0;
            final int i4 = 1;
            if (!this.mInitializedMenuBuilderReferences) {
                this.mInitializedMenuBuilderReferences = i4;
                this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
                item = new Class[i4];
                item[i3] = Integer.TYPE;
                this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod(str2, item);
                this.mCanUseMenuBuilderReferences = i4;
            }
            if (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu)) {
                if (this.mMenuBuilderClass.isInstance(menu)) {
                    mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderRemoveItemAtMethod;
                } else {
                    item = new Class[i4];
                    item[i3] = Integer.TYPE;
                    mMenuBuilderRemoveItemAtMethod = menu.getClass().getDeclaredMethod(str2, item);
                }
            } else {
            }
            size -= i4;
            while (i2 >= 0) {
                item = menu.getItem(i2);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                }
                i2--;
                if ("android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                }
                mMenuBuilderRemoveItemAtMethod.invoke(menu, /* result */);
            }
            List supportedActivities2 = getSupportedActivities(context, packageManager);
            i = 0;
            while (i < supportedActivities2.size()) {
                item = supportedActivities2.get(i);
                menu.add(i3, i3, i + 100, (ResolveInfo)item.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(item, this.mTextView)).setShowAsAction(i4);
                i++;
            }
        }

        @Override // android.view.ActionMode$Callback
        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Override // android.view.ActionMode$Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mCallback.onActionItemClicked(mode, item);
        }

        @Override // android.view.ActionMode$Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mCallback.onCreateActionMode(mode, menu);
        }

        @Override // android.view.ActionMode$Callback
        public void onDestroyActionMode(ActionMode mode) {
            this.mCallback.onDestroyActionMode(mode);
        }

        @Override // android.view.ActionMode$Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(mode, menu);
        }
    }
    public static int getAutoSizeMaxTextSize(TextView textView) {
        return TextViewCompat.Api26Impl.getAutoSizeMaxTextSize(textView);
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        return TextViewCompat.Api26Impl.getAutoSizeMinTextSize(textView);
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        return TextViewCompat.Api26Impl.getAutoSizeStepGranularity(textView);
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        return TextViewCompat.Api26Impl.getAutoSizeTextAvailableSizes(textView);
    }

    public static int getAutoSizeTextType(TextView textView) {
        return TextViewCompat.Api26Impl.getAutoSizeTextType(textView);
    }

    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        Preconditions.checkNotNull(textView);
        return TextViewCompat.Api23Impl.getCompoundDrawableTintList(textView);
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        Preconditions.checkNotNull(textView);
        return TextViewCompat.Api23Impl.getCompoundDrawableTintMode(textView);
    }

    @ReplaceWith(expression = "textView.getCompoundDrawablesRelative()")
    @Deprecated
    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        return paddingTop -= top;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        return paddingBottom += bottom;
    }

    @ReplaceWith(expression = "textView.getMaxLines()")
    @Deprecated
    public static int getMaxLines(TextView textView) {
        return textView.getMaxLines();
    }

    @ReplaceWith(expression = "textView.getMinLines()")
    @Deprecated
    public static int getMinLines(TextView textView) {
        return textView.getMinLines();
    }

    private static int getTextDirection(TextDirectionHeuristic heuristic) {
        final int i7 = 1;
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return i7;
        }
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return i7;
        }
        if (heuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (heuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (heuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (heuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return i7;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView textView) {
        TextDirectionHeuristic fIRSTSTRONG_RTL;
        int i;
        int i2;
        if (transformationMethod instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        i = 0;
        i2 = 1;
        final byte directionality = Character.getDirectionality(TextViewCompat.Api28Impl.getDigitStrings(TextViewCompat.Api24Impl.getInstance(textView.getTextLocale()))[i].codePointAt(i));
        if (inputType &= 15 == 3 && directionality != i2 && directionality == 2) {
            directionality = Character.getDirectionality(TextViewCompat.Api28Impl.getDigitStrings(TextViewCompat.Api24Impl.getInstance(textView.getTextLocale()))[i].codePointAt(i));
            if (directionality != i2) {
                if (directionality == 2) {
                }
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        if (textView.getLayoutDirection() == i2) {
            i = i2;
        }
        switch (textDirection) {
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
                fIRSTSTRONG_RTL = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                return fIRSTSTRONG_RTL;
        }
        fIRSTSTRONG_RTL = TextDirectionHeuristics.FIRSTSTRONG_RTL;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
        PrecomputedTextCompat.Params params = new PrecomputedTextCompat.Params(TextViewCompat.Api28Impl.getTextMetricsParams(textView));
        return params;
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws java.lang.IllegalArgumentException {
        TextViewCompat.Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] presetSizes, int unit) throws java.lang.IllegalArgumentException {
        TextViewCompat.Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, presetSizes, unit);
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int autoSizeTextType) {
        TextViewCompat.Api26Impl.setAutoSizeTextTypeWithDefaults(textView, autoSizeTextType);
    }

    public static void setCompoundDrawableTintList(TextView textView, ColorStateList tint) {
        Preconditions.checkNotNull(textView);
        TextViewCompat.Api23Impl.setCompoundDrawableTintList(textView, tint);
    }

    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode tintMode) {
        Preconditions.checkNotNull(textView);
        TextViewCompat.Api23Impl.setCompoundDrawableTintMode(textView, tintMode);
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelative(start, top, end, bottom)")
    @Deprecated
    public static void setCompoundDrawablesRelative(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
        textView.setCompoundDrawablesRelative(start, top, end, bottom);
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)")
    @Deprecated
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int start, int top, int end, int bottom) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)")
    @Deprecated
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
    }

    @ReplaceWith(expression = "textView.setCustomSelectionActionModeCallback(callback)")
    @Deprecated
    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int firstBaselineToTopHeight) {
        Preconditions.checkArgumentNonnegative(firstBaselineToTopHeight);
        TextViewCompat.Api28Impl.setFirstBaselineToTopHeight(textView, firstBaselineToTopHeight);
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int lastBaselineToBottomHeight) {
        int fontMetricsBottom;
        int i;
        int paddingLeft;
        int paddingTop;
        int paddingRight;
        Preconditions.checkArgumentNonnegative(lastBaselineToBottomHeight);
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        fontMetricsBottom = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (lastBaselineToBottomHeight > Math.abs(fontMetricsBottom)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), lastBaselineToBottomHeight - fontMetricsBottom);
        }
    }

    public static void setLineHeight(TextView textView, int lineHeight) {
        int i2;
        int i;
        Preconditions.checkArgumentNonnegative(lineHeight);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(0);
        if (lineHeight != fontMetricsInt) {
            textView.setLineSpacing((float)i3, 1065353216);
        }
    }

    public static void setLineHeight(TextView textView, int unit, float lineHeight) {
        int sDK_INT;
        int round;
        if (Build.VERSION.SDK_INT >= 34) {
            TextViewCompat.Api34Impl.setLineHeight(textView, unit, lineHeight);
        } else {
            TextViewCompat.setLineHeight(textView, Math.round(TypedValue.applyDimension(unit, lineHeight, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputed) {
        textView.setText(TextViewCompat.Api28Impl.castToCharSequence(precomputed.getPrecomputedText()));
    }

    public static void setTextAppearance(TextView textView, int resId) {
        textView.setTextAppearance(resId);
    }

    public static void setTextMetricsParams(TextView textView, PrecomputedTextCompat.Params params) {
        textView.setTextDirection(TextViewCompat.getTextDirection(params.getTextDirection()));
        textView.getPaint().set(params.getTextPaint());
        TextViewCompat.Api23Impl.setBreakStrategy(textView, params.getBreakStrategy());
        TextViewCompat.Api23Impl.setHyphenationFrequency(textView, params.getHyphenationFrequency());
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        if (callback instanceof TextViewCompat.OreoCallback != null) {
            return (TextViewCompat.OreoCallback)callback.getWrappedCallback();
        }
        return callback;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        return callback;
    }
}
