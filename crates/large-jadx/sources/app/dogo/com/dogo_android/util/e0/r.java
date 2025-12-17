package app.dogo.com.dogo_android.util.e0;

import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;
import androidx.lifecycle.e0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.u.b;
import i.b.j0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u001a\u0010 \u001a\u00020\u001b2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u001bJ,\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0008\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0008\u0010/\u001a\u00020\u001bH\u0014J\u0008\u00100\u001a\u00020\u001bH\u0016J\u0008\u00101\u001a\u00020\u001bH\u0016J\u0012\u00102\u001a\u00020\u001b2\u0008\u00103\u001a\u0004\u0018\u00010$H\u0016J\u0008\u00104\u001a\u00020\u001bH\u0016J\n\u00105\u001a\u0004\u0018\u00010$H\u0016J\u0008\u00106\u001a\u00020\u001bH\u0016J\u0008\u00107\u001a\u00020\u001bH\u0016J\u001c\u00108\u001a\u00020\u001b2\u0008\u00109\u001a\u0004\u0018\u00010\u00102\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010:\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010;\u001a\u00020\nJ\u0010\u0010<\u001a\u00020\u001b2\u0008\u0008\u0001\u0010=\u001a\u00020\u0014J\u000e\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/databinding/Observable;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "loadingDialogTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "messageEmmiter", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$MessageHolder;", "getMessageEmmiter", "()Landroidx/lifecycle/MutableLiveData;", "parent", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "registry", "Landroidx/databinding/PropertyChangeRegistry;", "resToast", "", "stringToast", "", "title", "getTitle", "()Ljava/lang/String;", "addOnPropertyChangedCallback", "", "callback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "callLoadingDialog", "dismissLoadingDialog", "emitMessage", "action", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "mail", "Landroid/os/Bundle;", "notifyChange", "propertyId", "notifyChangeAll", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onCleared", "onDestroy", "onPause", "onRestoreState", "state", "onResume", "onSaveState", "onStart", "onStop", "refreshView", "caller", "removeOnPropertyChangedCallback", "setupMenuItemsVisibility", "showToast", "message", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class r extends e0 implements h {

    private final j a;
    public final x<String> b;
    public final x<Integer> c;
    public final x<Boolean> v;
    public q w;
    private final x<u.b> x;
    private final a y;
    public r() {
        super();
        j jVar = new j();
        this.a = jVar;
        x xVar = new x();
        this.b = xVar;
        x xVar2 = new x();
        this.c = xVar2;
        x xVar3 = new x();
        this.v = xVar3;
        x xVar4 = new x();
        this.x = xVar4;
        a aVar = new a();
        this.y = aVar;
    }

    @Override // androidx.lifecycle.e0
    public void addOnPropertyChangedCallback(h.a h$a) {
        n.f(a, "callback");
        this.a.a(a);
    }

    @Override // androidx.lifecycle.e0
    public final a getDisposable() {
        return this.y;
    }

    @Override // androidx.lifecycle.e0
    public final void h() {
        this.v.setValue(Boolean.TRUE);
    }

    @Override // androidx.lifecycle.e0
    public final void i() {
        this.v.setValue(Boolean.FALSE);
    }

    @Override // androidx.lifecycle.e0
    public final void j(h h, Bundle bundle2) {
        u.b bVar = new u.b(h, bundle2);
        this.x.setValue(bVar);
    }

    public final x<u.b> k() {
        return this.x;
    }

    @Override // androidx.lifecycle.e0
    public final void l(int i) {
        this.a.m(this, i);
    }

    @Override // androidx.lifecycle.e0
    public void m(int i, int i2, Intent intent3, app.dogo.com.dogo_android.util.e0.a0 a04) {
    }

    @Override // androidx.lifecycle.e0
    public void n() {
    }

    @Override // androidx.lifecycle.e0
    public void o() {
    }

    @Override // androidx.lifecycle.e0
    protected void onCleared() {
        super.onCleared();
        this.y.d();
    }

    @Override // androidx.lifecycle.e0
    public void p(Bundle bundle) {
    }

    @Override // androidx.lifecycle.e0
    public void q() {
    }

    @Override // androidx.lifecycle.e0
    public Bundle r() {
        return null;
    }

    @Override // androidx.lifecycle.e0
    public void removeOnPropertyChangedCallback(h.a h$a) {
        n.f(a, "callback");
        this.a.j(a);
    }

    @Override // androidx.lifecycle.e0
    public void s() {
    }

    @Override // androidx.lifecycle.e0
    public void t() {
    }

    @Override // androidx.lifecycle.e0
    public void u(q q, app.dogo.com.dogo_android.util.e0.a0 a02) {
    }

    @Override // androidx.lifecycle.e0
    public final void v(int i) {
        this.c.setValue(Integer.valueOf(i));
    }
}
