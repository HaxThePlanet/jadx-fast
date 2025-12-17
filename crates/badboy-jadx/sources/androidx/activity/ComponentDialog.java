package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryController.Companion;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0008\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0003\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0008\u0010%\u001a\u00020 H\u0017J\u0008\u0010&\u001a\u00020 H\u0017J\u0012\u0010'\u001a\u00020 2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0015J\u0008\u0010*\u001a\u00020)H\u0016J\u0008\u0010+\u001a\u00020 H\u0015J\u0008\u0010,\u001a\u00020 H\u0015J\u0010\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0008H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u0014¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "()V", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "addContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "initializeViewTreeOwners", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "onStart", "onStop", "setContentView", "layoutResID", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ComponentDialog extends Dialog implements LifecycleOwner, androidx.activity.OnBackPressedDispatcherOwner, SavedStateRegistryOwner {

    private LifecycleRegistry _lifecycleRegistry;
    private final androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher;
    private final SavedStateRegistryController savedStateRegistryController;
    public static void $r8$lambda$qrzmfDOyDuplJFtpJLozn3P9EZI(androidx.activity.ComponentDialog componentDialog) {
        ComponentDialog.onBackPressedDispatcher$lambda$1(componentDialog);
    }

    public ComponentDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, 0, 2, 0);
    }

    public ComponentDialog(Context context, int themeResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, themeResId);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create((SavedStateRegistryOwner)this);
        ComponentDialog$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ComponentDialog$$ExternalSyntheticLambda0(this);
        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(externalSyntheticLambda0);
        this.onBackPressedDispatcher = onBackPressedDispatcher;
    }

    public ComponentDialog(Context context, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(context, obj2);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry _lifecycleRegistry;
        LifecycleRegistry lifecycleRegistry;
        int i;
        if (this._lifecycleRegistry == null) {
            _lifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
            i = 0;
            this._lifecycleRegistry = _lifecycleRegistry;
        }
        return _lifecycleRegistry;
    }

    public static void getOnBackPressedDispatcher$annotations() {
    }

    private static final void onBackPressedDispatcher$lambda$1(androidx.activity.ComponentDialog this$0) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.addContentView(view, params);
    }

    @Override // android.app.Dialog
    public Lifecycle getLifecycle() {
        return (Lifecycle)getLifecycleRegistry();
    }

    @Override // android.app.Dialog
    public final androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // android.app.Dialog
    public void initializeViewTreeOwners() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        View decorView = window.getDecorView();
        String str = "window!!.decorView";
        Intrinsics.checkNotNullExpressionValue(decorView, str);
        ViewTreeLifecycleOwner.set(decorView, (LifecycleOwner)this);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        View decorView2 = window2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, str);
        ViewTreeOnBackPressedDispatcherOwner.set(decorView2, (OnBackPressedDispatcherOwner)this);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        View decorView3 = window3.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView3, str);
        ViewTreeSavedStateRegistryOwner.set(decorView3, (SavedStateRegistryOwner)this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        int onBackPressedDispatcher;
        int onBackInvokedDispatcher;
        String str;
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            Intrinsics.checkNotNullExpressionValue(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            this.onBackPressedDispatcher.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        }
        this.savedStateRegistryController.performRestore(savedInstanceState);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        final Bundle onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()");
        this.savedStateRegistryController.performSave(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = 0;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        initializeViewTreeOwners();
        super.setContentView(layoutResID);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view, params);
    }
}
