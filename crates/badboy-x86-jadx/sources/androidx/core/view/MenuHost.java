package androidx.core.view;

import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes5.dex */
public interface MenuHost {
    public abstract void addMenuProvider(androidx.core.view.MenuProvider menuProvider);

    public abstract void addMenuProvider(androidx.core.view.MenuProvider menuProvider, LifecycleOwner lifecycleOwner2);

    public abstract void addMenuProvider(androidx.core.view.MenuProvider menuProvider, LifecycleOwner lifecycleOwner2, Lifecycle.State lifecycle$State3);

    public abstract void invalidateMenu();

    public abstract void removeMenuProvider(androidx.core.view.MenuProvider menuProvider);
}
