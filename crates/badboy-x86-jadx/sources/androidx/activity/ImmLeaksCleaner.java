package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 \u000c2\u00020\u0001:\u0004\u000b\u000c\r\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/activity/ImmLeaksCleaner;", "Landroidx/lifecycle/LifecycleEventObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "Cleaner", "Companion", "FailedInitialization", "ValidCleaner", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    public static final androidx.activity.ImmLeaksCleaner.Companion Companion;
    private static final Lazy<androidx.activity.ImmLeaksCleaner.Cleaner> cleaner$delegate;
    private final Activity activity;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u000c\u0010\u000b\u001a\u00020\u000c*\u00020\u0004H&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f", d2 = {"Landroidx/activity/ImmLeaksCleaner$Cleaner;", "", "()V", "lock", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Cleaner {
        public Cleaner(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public abstract boolean clearNextServedView(InputMethodManager inputMethodManager);

        public abstract Object getLock(InputMethodManager inputMethodManager);

        public abstract View getServedView(InputMethodManager inputMethodManager);
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Landroidx/activity/ImmLeaksCleaner$Companion;", "", "()V", "cleaner", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "getCleaner", "()Landroidx/activity/ImmLeaksCleaner$Cleaner;", "cleaner$delegate", "Lkotlin/Lazy;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.activity.ImmLeaksCleaner.Cleaner getCleaner() {
            return (ImmLeaksCleaner.Cleaner)ImmLeaksCleaner.access$getCleaner$delegate$cp().getValue();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u000c\u001a\u00020\r*\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u0004\u0018\u00010\t*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "()V", "lock", "", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FailedInitialization extends androidx.activity.ImmLeaksCleaner.Cleaner {

        public static final androidx.activity.ImmLeaksCleaner.FailedInitialization INSTANCE;
        static {
            ImmLeaksCleaner.FailedInitialization failedInitialization = new ImmLeaksCleaner.FailedInitialization();
            ImmLeaksCleaner.FailedInitialization.INSTANCE = failedInitialization;
        }

        private FailedInitialization() {
            super(0);
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public boolean clearNextServedView(InputMethodManager $this$clearNextServedView) {
            Intrinsics.checkNotNullParameter($this$clearNextServedView, "<this>");
            return 0;
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public Object getLock(InputMethodManager $this$lock) {
            Intrinsics.checkNotNullParameter($this$lock, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public View getServedView(InputMethodManager $this$servedView) {
            Intrinsics.checkNotNullParameter($this$servedView, "<this>");
            return null;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000c\u0010\u0010\u001a\u00020\u0011*\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u0004\u0018\u00010\r*\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "hField", "Ljava/lang/reflect/Field;", "servedViewField", "nextServedViewField", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;)V", "lock", "", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ValidCleaner extends androidx.activity.ImmLeaksCleaner.Cleaner {

        private final Field hField;
        private final Field nextServedViewField;
        private final Field servedViewField;
        public ValidCleaner(Field hField, Field servedViewField, Field nextServedViewField) {
            Intrinsics.checkNotNullParameter(hField, "hField");
            Intrinsics.checkNotNullParameter(servedViewField, "servedViewField");
            Intrinsics.checkNotNullParameter(nextServedViewField, "nextServedViewField");
            super(0);
            this.hField = hField;
            this.servedViewField = servedViewField;
            this.nextServedViewField = nextServedViewField;
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public boolean clearNextServedView(InputMethodManager $this$clearNextServedView) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter($this$clearNextServedView, "<this>");
            this.nextServedViewField.set($this$clearNextServedView, 0);
            i = 1;
            return i;
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public Object getLock(InputMethodManager $this$lock) {
            Object obj;
            int i;
            Intrinsics.checkNotNullParameter($this$lock, "<this>");
            obj = this.hField.get($this$lock);
            return obj;
        }

        @Override // androidx.activity.ImmLeaksCleaner$Cleaner
        public View getServedView(InputMethodManager $this$servedView) {
            Object obj;
            Intrinsics.checkNotNullParameter($this$servedView, "<this>");
            int i = 0;
            return (View)this.servedViewField.get($this$servedView);
        }
    }
    static {
        ImmLeaksCleaner.Companion companion = new ImmLeaksCleaner.Companion(0);
        ImmLeaksCleaner.Companion = companion;
        ImmLeaksCleaner.cleaner$delegate = LazyKt.lazy((Function0)ImmLeaksCleaner.Companion.cleaner.2.INSTANCE);
    }

    public ImmLeaksCleaner(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super();
        this.activity = activity;
    }

    public static final Lazy access$getCleaner$delegate$cp() {
        return ImmLeaksCleaner.cleaner$delegate;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_DESTROY) {
        }
        Object systemService = this.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        androidx.activity.ImmLeaksCleaner.Cleaner cleaner = ImmLeaksCleaner.Companion.getCleaner();
        final int i = 0;
        final Object lock = cleaner.getLock((InputMethodManager)systemService);
        if (lock == null) {
        }
        final int i2 = 0;
        final View servedView = cleaner.getServedView(systemService);
        synchronized (lock) {
        }
        systemService.isActive();
    }
}
