package zendesk.support.request;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes3.dex */
class RequestViewLoading extends View implements zendesk.support.request.RequestView {
    public RequestViewLoading(Context context) {
        super(context);
    }

    public RequestViewLoading(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    public RequestViewLoading(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
    }

    @Override // android.view.View
    public boolean hasUnsavedInput() {
        return 0;
    }

    @Override // android.view.View
    public boolean inflateMenu(MenuInflater menuInflater, Menu menu2) {
        return 0;
    }

    @Override // android.view.View
    public boolean onOptionsItemClicked(MenuItem menuItem) {
        return 0;
    }
}
