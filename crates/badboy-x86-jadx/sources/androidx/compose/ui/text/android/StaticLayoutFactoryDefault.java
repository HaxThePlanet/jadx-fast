package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import android.util.Log;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0008H\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StaticLayoutFactoryDefault implements androidx.compose.ui.text.android.StaticLayoutFactoryImpl {

    public static final androidx.compose.ui.text.android.StaticLayoutFactoryDefault.Companion Companion;
    private static boolean isInitialized;
    private static Constructor<StaticLayout> staticLayoutConstructor;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault$Companion;", "", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final Constructor access$getStaticLayoutConstructor(androidx.compose.ui.text.android.StaticLayoutFactoryDefault.Companion $this) {
            return $this.getStaticLayoutConstructor();
        }

        private final Constructor<StaticLayout> getStaticLayoutConstructor() {
            Constructor constructor;
            Class<StaticLayout> obj;
            Class[] arr;
            if (StaticLayoutFactoryDefault.access$isInitialized$cp()) {
                return StaticLayoutFactoryDefault.access$getStaticLayoutConstructor$cp();
            }
            int i = 1;
            StaticLayoutFactoryDefault.access$setInitialized$cp(i);
            arr = new Class[13];
            arr[i] = Integer.TYPE;
            arr[2] = Integer.TYPE;
            arr[3] = TextPaint.class;
            arr[4] = Integer.TYPE;
            arr[5] = Layout.Alignment.class;
            arr[6] = TextDirectionHeuristic.class;
            arr[7] = Float.TYPE;
            arr[8] = Float.TYPE;
            arr[9] = Boolean.TYPE;
            arr[10] = TextUtils.TruncateAt.class;
            arr[11] = Integer.TYPE;
            arr[12] = Integer.TYPE;
            StaticLayoutFactoryDefault.access$setStaticLayoutConstructor$cp(StaticLayout.class.getConstructor(arr));
            return StaticLayoutFactoryDefault.access$getStaticLayoutConstructor$cp();
        }
    }
    static {
        StaticLayoutFactoryDefault.Companion companion = new StaticLayoutFactoryDefault.Companion(0);
        StaticLayoutFactoryDefault.Companion = companion;
    }

    public static final Constructor access$getStaticLayoutConstructor$cp() {
        return StaticLayoutFactoryDefault.staticLayoutConstructor;
    }

    public static final boolean access$isInitialized$cp() {
        return StaticLayoutFactoryDefault.isInitialized;
    }

    public static final void access$setInitialized$cp(boolean <set-?>) {
        StaticLayoutFactoryDefault.isInitialized = <set-?>;
    }

    public static final void access$setStaticLayoutConstructor$cp(Constructor <set-?>) {
        StaticLayoutFactoryDefault.staticLayoutConstructor = <set-?>;
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(androidx.compose.ui.text.android.StaticLayoutParams params) {
        Object instance;
        int i;
        Constructor constructor;
        int i2;
        java.lang.CharSequence text;
        Integer valueOf8;
        Integer valueOf6;
        android.text.TextPaint paint;
        Integer valueOf3;
        android.text.Layout.Alignment alignment;
        android.text.TextDirectionHeuristic textDir;
        Float valueOf7;
        Float valueOf4;
        Boolean valueOf2;
        android.text.TextUtils.TruncateAt ellipsize;
        Integer valueOf;
        Integer valueOf5;
        final String str = "unable to call constructor";
        final String str2 = "StaticLayoutFactory";
        instance = StaticLayoutFactoryDefault.Companion.access$getStaticLayoutConstructor(StaticLayoutFactoryDefault.Companion);
        i = 0;
        if (instance != null) {
            i2 = 0;
            i = instance;
        }
        if (i != 0) {
            return i;
        }
        StaticLayout staticLayout = new StaticLayout(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth(), params.getAlignment(), params.getLineSpacingMultiplier(), params.getLineSpacingExtra(), params.getIncludePadding(), params.getEllipsize(), params.getEllipsizedWidth());
        return staticLayout;
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean useFallbackLineSpacing) {
        return 0;
    }
}
