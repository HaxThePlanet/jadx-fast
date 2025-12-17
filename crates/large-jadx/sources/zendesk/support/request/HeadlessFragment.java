package zendesk.support.request;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import androidx.fragment.app.w;

/* loaded from: classes3.dex */
public class HeadlessFragment<E>  extends Fragment {

    private static final String TAG = "ZendeskHeadlessFragment";
    private E data;
    private E getData() {
        return this.data;
    }

    static <E> E getData(n n) {
        Fragment obj1 = n.k0("ZendeskHeadlessFragment");
        if (obj1 instanceof HeadlessFragment != null) {
            return (HeadlessFragment)obj1.getData();
        }
        return 0;
    }

    static <E> void install(n n, E e2) {
        HeadlessFragment headlessFragment = new HeadlessFragment();
        headlessFragment.setData(e2);
        final w obj1 = n.n();
        obj1.d(headlessFragment, "ZendeskHeadlessFragment");
        obj1.g();
    }

    private void setData(E e) {
        this.data = e;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        setRetainInstance(true);
        return null;
    }
}
