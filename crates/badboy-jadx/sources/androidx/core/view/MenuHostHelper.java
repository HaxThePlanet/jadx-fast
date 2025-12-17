package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class MenuHostHelper {

    private final CopyOnWriteArrayList<androidx.core.view.MenuProvider> mMenuProviders;
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<androidx.core.view.MenuProvider, androidx.core.view.MenuHostHelper.LifecycleContainer> mProviderToLifecycleContainers;

    private static class LifecycleContainer {

        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;
        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver observer) {
            super();
            this.mLifecycle = lifecycle;
            this.mObserver = observer;
            this.mLifecycle.addObserver(observer);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = 0;
        }
    }
    public MenuHostHelper(Runnable onInvalidateMenuCallback) {
        super();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mMenuProviders = copyOnWriteArrayList;
        HashMap hashMap = new HashMap();
        this.mProviderToLifecycleContainers = hashMap;
        this.mOnInvalidateMenuCallback = onInvalidateMenuCallback;
    }

    public void addMenuProvider(androidx.core.view.MenuProvider provider) {
        this.mMenuProviders.add(provider);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(androidx.core.view.MenuProvider provider, LifecycleOwner owner) {
        addMenuProvider(provider);
        Object remove = this.mProviderToLifecycleContainers.remove(provider);
        if ((MenuHostHelper.LifecycleContainer)remove != null) {
            (MenuHostHelper.LifecycleContainer)remove.clearObservers();
        }
        MenuHostHelper$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new MenuHostHelper$$ExternalSyntheticLambda1(this, provider);
        MenuHostHelper.LifecycleContainer lifecycleContainer = new MenuHostHelper.LifecycleContainer(owner.getLifecycle(), externalSyntheticLambda1);
        this.mProviderToLifecycleContainers.put(provider, lifecycleContainer);
    }

    public void addMenuProvider(androidx.core.view.MenuProvider provider, LifecycleOwner owner, Lifecycle.State state) {
        Object remove = this.mProviderToLifecycleContainers.remove(provider);
        if ((MenuHostHelper.LifecycleContainer)remove != null) {
            (MenuHostHelper.LifecycleContainer)remove.clearObservers();
        }
        MenuHostHelper$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new MenuHostHelper$$ExternalSyntheticLambda0(this, state, provider);
        MenuHostHelper.LifecycleContainer lifecycleContainer = new MenuHostHelper.LifecycleContainer(owner.getLifecycle(), externalSyntheticLambda0);
        this.mProviderToLifecycleContainers.put(provider, lifecycleContainer);
    }

    void lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper(androidx.core.view.MenuProvider provider, LifecycleOwner source, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(provider);
        }
    }

    void lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper(Lifecycle.State state, androidx.core.view.MenuProvider provider, LifecycleOwner source, Lifecycle.Event event) {
        Object mOnInvalidateMenuCallback;
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(provider);
        } else {
            if (event == Lifecycle.Event.ON_DESTROY) {
                removeMenuProvider(provider);
            } else {
                if (event == Lifecycle.Event.downFrom(state)) {
                    this.mMenuProviders.remove(provider);
                    this.mOnInvalidateMenuCallback.run();
                }
            }
        }
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Object next;
        Iterator iterator = this.mMenuProviders.iterator();
        for (MenuProvider next : iterator) {
            next.onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(Menu menu) {
        Object next;
        Iterator iterator = this.mMenuProviders.iterator();
        for (MenuProvider next : iterator) {
            next.onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(MenuItem item) {
        Object next;
        boolean onMenuItemSelected;
        Iterator iterator = this.mMenuProviders.iterator();
        for (MenuProvider next : iterator) {
        }
        return 0;
    }

    public void onPrepareMenu(Menu menu) {
        Object next;
        Iterator iterator = this.mMenuProviders.iterator();
        for (MenuProvider next : iterator) {
            next.onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(androidx.core.view.MenuProvider provider) {
        this.mMenuProviders.remove(provider);
        Object remove = this.mProviderToLifecycleContainers.remove(provider);
        if ((MenuHostHelper.LifecycleContainer)remove != null) {
            (MenuHostHelper.LifecycleContainer)remove.clearObservers();
        }
        this.mOnInvalidateMenuCallback.run();
    }
}
