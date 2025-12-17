package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* loaded from: classes5.dex */
public interface MenuProvider {
    public abstract void onCreateMenu(Menu menu, MenuInflater menuInflater2);

    public void onMenuClosed(Menu menu) {
    }

    public abstract boolean onMenuItemSelected(MenuItem menuItem);

    public void onPrepareMenu(Menu menu) {
    }
}
