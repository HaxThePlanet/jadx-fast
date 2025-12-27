package app.dogo.com.dogo_android.util.e0;

import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.c;
import androidx.databinding.h.a;
import androidx.databinding.j;
import androidx.lifecycle.e0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.u.b;
import i.b.j0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u001a\u0010 \u001a\u00020\u001b2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u001bJ,\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0008\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0008\u0010/\u001a\u00020\u001bH\u0014J\u0008\u00100\u001a\u00020\u001bH\u0016J\u0008\u00101\u001a\u00020\u001bH\u0016J\u0012\u00102\u001a\u00020\u001b2\u0008\u00103\u001a\u0004\u0018\u00010$H\u0016J\u0008\u00104\u001a\u00020\u001bH\u0016J\n\u00105\u001a\u0004\u0018\u00010$H\u0016J\u0008\u00106\u001a\u00020\u001bH\u0016J\u0008\u00107\u001a\u00020\u001bH\u0016J\u001c\u00108\u001a\u00020\u001b2\u0008\u00109\u001a\u0004\u0018\u00010\u00102\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010:\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010;\u001a\u00020\nJ\u0010\u0010<\u001a\u00020\u001b2\u0008\u0008\u0001\u0010=\u001a\u00020\u0014J\u000e\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/databinding/Observable;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "loadingDialogTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "messageEmmiter", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$MessageHolder;", "getMessageEmmiter", "()Landroidx/lifecycle/MutableLiveData;", "parent", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "registry", "Landroidx/databinding/PropertyChangeRegistry;", "resToast", "", "stringToast", "", "title", "getTitle", "()Ljava/lang/String;", "addOnPropertyChangedCallback", "", "callback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "callLoadingDialog", "dismissLoadingDialog", "emitMessage", "action", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "mail", "Landroid/os/Bundle;", "notifyChange", "propertyId", "notifyChangeAll", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onCleared", "onDestroy", "onPause", "onRestoreState", "state", "onResume", "onSaveState", "onStart", "onStop", "refreshView", "caller", "removeOnPropertyChangedCallback", "setupMenuItemsVisibility", "showToast", "message", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public class BaseViewModel extends e0 implements androidx.databinding.h {

    private final j a = new j();
    /* renamed from: b, reason: from kotlin metadata */
    public final x<String> loadingDialogTrigger = new x<>();
    public final x<Integer> c = new x<>();
    /* renamed from: v, reason: from kotlin metadata */
    public final x<Boolean> parent = new x<>();
    /* renamed from: w, reason: from kotlin metadata */
    public q registry;
    /* renamed from: x, reason: from kotlin metadata */
    private final x<u.b> resToast = new x<>();
    /* renamed from: y, reason: from kotlin metadata */
    private final a stringToast = new a();
    public r() {
        super();
        j jVar = new j();
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        x xVar4 = new x();
        a aVar = new a();
    }

    @Override // androidx.lifecycle.e0
    public void addOnPropertyChangedCallback(h.a callback) {
        n.f(callback, "callback");
        this.a.a(callback);
    }

    @Override // androidx.lifecycle.e0
    public final a getDisposable() {
        return this.stringToast;
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: h, reason: from kotlin metadata */
    public final void callLoadingDialog() {
        this.parent.setValue(Boolean.TRUE);
    }

    @Override // androidx.lifecycle.e0
    public final void i() {
        this.parent.setValue(Boolean.FALSE);
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: j, reason: from kotlin metadata */
    public final void emitMessage(app.dogo.com.dogo_android.k.h action, Bundle mail) {
        this.resToast.setValue(new u.b(action, mail));
    }

    @Override // androidx.lifecycle.e0
    public final x<u.b> k() {
        return this.resToast;
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: l, reason: from kotlin metadata */
    public final void notifyChange(int propertyId) {
        this.a.m(this, propertyId);
    }

    @Override // androidx.lifecycle.e0
    protected void onCleared() {
        super.onCleared();
        this.stringToast.d();
    }

    @Override // androidx.lifecycle.e0
    public void removeOnPropertyChangedCallback(h.a callback) {
        n.f(callback, "callback");
        this.a.j(callback);
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: v, reason: from kotlin metadata */
    public final void showToast(int message) {
        this.c.setValue(Integer.valueOf(message));
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: m, reason: from kotlin metadata */
    public void onActivityResult(int requestCode, int resultCode, Intent data, a0 navigator) {
    }

    @Override // androidx.lifecycle.e0
    public void n() {
    }

    @Override // androidx.lifecycle.e0
    public void o() {
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: p, reason: from kotlin metadata */
    public void onRestoreState(Bundle state) {
    }

    @Override // androidx.lifecycle.e0
    public void q() {
    }

    @Override // androidx.lifecycle.e0
    public Bundle r() {
        return null;
    }

    @Override // androidx.lifecycle.e0
    public void s() {
    }

    @Override // androidx.lifecycle.e0
    public void t() {
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: u, reason: from kotlin metadata */
    public void refreshView(q caller, a0 navigator) {
    }
}
