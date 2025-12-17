package zendesk.support.request;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* loaded from: classes3.dex */
interface RequestView {
    public abstract boolean hasUnsavedInput();

    public abstract boolean inflateMenu(MenuInflater menuInflater, Menu menu2);

    public abstract boolean onOptionsItemClicked(MenuItem menuItem);
}
