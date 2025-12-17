package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes5.dex */
public abstract class ActionProvider {

    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private androidx.core.view.ActionProvider.SubUiVisibilityListener mSubUiVisibilityListener;
    private androidx.core.view.ActionProvider.VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
        public abstract void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        public abstract void onActionProviderVisibilityChanged(boolean z);
    }
    public ActionProvider(Context context) {
        super();
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return 0;
    }

    public boolean isVisible() {
        return 1;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem forItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return 0;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return 0;
    }

    public void refreshVisibility() {
        androidx.core.view.ActionProvider.VisibilityListener overridesItemVisibility;
        boolean visible;
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            if (overridesItemVisibility()) {
                this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
            }
        }
    }

    public void reset() {
        final int i = 0;
        this.mVisibilityListener = i;
        this.mSubUiVisibilityListener = i;
    }

    public void setSubUiVisibilityListener(androidx.core.view.ActionProvider.SubUiVisibilityListener listener) {
        this.mSubUiVisibilityListener = listener;
    }

    public void setVisibilityListener(androidx.core.view.ActionProvider.VisibilityListener listener) {
        Object mVisibilityListener;
        String str;
        if (this.mVisibilityListener != null && listener != null) {
            if (listener != null) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w("ActionProvider(support)", stringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
            }
        }
        this.mVisibilityListener = listener;
    }

    public void subUiVisibilityChanged(boolean isVisible) {
        androidx.core.view.ActionProvider.SubUiVisibilityListener mSubUiVisibilityListener;
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }
}
