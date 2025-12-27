@Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"org/koin/androidx/scope/LifecycleScopeDelegate$2", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: 2 */
public final class LifecycleScopeDelegate_2 implements androidx.lifecycle.p {

    final /* synthetic */ org.koin.androidx.scope.a a;
    @z(j$b.ON_DESTROY)
    public final void onDestroy(androidx.lifecycle.q owner) throws StringBuilder {
        n.f(owner, "owner");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Closing scope: ");
        stringBuilder.append(this.a.a);
        stringBuilder.append(" for ");
        this.a.b();
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
