package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.savedstate.d;

/* loaded from: classes.dex */
public class d extends androidx.fragment.app.Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId = -1;
    private boolean mCancelable = true;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated = false;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private y<q> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog = true;
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mViewDestroyed;

    class a implements Runnable {

        final androidx.fragment.app.d a;
        a(androidx.fragment.app.d d) {
            this.a = d;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            d.access$100(this.a).onDismiss(d.access$000(this.a));
        }
    }

    class b implements DialogInterface.OnCancelListener {

        final androidx.fragment.app.d a;
        b(androidx.fragment.app.d d) {
            this.a = d;
            super();
        }

        @Override // android.content.DialogInterface$OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Dialog dialog;
            Object obj2;
            if (d.access$000(this.a) != null) {
                obj2 = this.a;
                obj2.onCancel(d.access$000(obj2));
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {

        final androidx.fragment.app.d a;
        c(androidx.fragment.app.d d) {
            this.a = d;
            super();
        }

        @Override // android.content.DialogInterface$OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Dialog dialog;
            Object obj2;
            if (d.access$000(this.a) != null) {
                obj2 = this.a;
                obj2.onDismiss(d.access$000(obj2));
            }
        }
    }

    class d implements y<q> {

        final androidx.fragment.app.d a;
        d(androidx.fragment.app.d d) {
            this.a = d;
            super();
        }

        @Override // androidx.lifecycle.y
        public void a(q q) {
            boolean string;
            Dialog dialog;
            String str;
            boolean obj3;
            if (q && d.access$200(this.a)) {
                if (d.access$200(this.a)) {
                    obj3 = this.a.requireView();
                    if (obj3.getParent() != null) {
                    } else {
                        if (d.access$000(this.a) != null && n.I0(3)) {
                            if (n.I0(3)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("DialogFragment ");
                                stringBuilder.append(this);
                                stringBuilder.append(" setting the content view on ");
                                stringBuilder.append(d.access$000(this.a));
                                Log.d("FragmentManager", stringBuilder.toString());
                            }
                            d.access$000(this.a).setContentView(obj3);
                        }
                    }
                    obj3 = new IllegalStateException("DialogFragment can not be attached to a container view");
                    throw obj3;
                }
            }
        }

        @Override // androidx.lifecycle.y
        public void onChanged(Object object) {
            a((q)object);
        }
    }

    class e extends androidx.fragment.app.g {

        final androidx.fragment.app.g a;
        final androidx.fragment.app.d b;
        e(androidx.fragment.app.d d, androidx.fragment.app.g g2) {
            this.b = d;
            this.a = g2;
            super();
        }

        @Override // androidx.fragment.app.g
        public View c(int i) {
            if (this.a.d()) {
                return this.a.c(i);
            }
            return this.b.onFindViewById(i);
        }

        @Override // androidx.fragment.app.g
        public boolean d() {
            int i;
            boolean onHasView;
            if (!this.a.d()) {
                if (this.b.onHasView()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
    }
    public d() {
        super();
        d.a aVar = new d.a(this);
        this.mDismissRunnable = aVar;
        d.b bVar = new d.b(this);
        this.mOnCancelListener = bVar;
        d.c cVar = new d.c(this);
        this.mOnDismissListener = cVar;
        int i = 0;
        int i2 = 1;
        int i3 = -1;
        d.d dVar = new d.d(this);
        this.mObserver = dVar;
    }

    public d(int i) {
        super(i);
        d.a obj2 = new d.a(this);
        this.mDismissRunnable = obj2;
        obj2 = new d.b(this);
        this.mOnCancelListener = obj2;
        obj2 = new d.c(this);
        this.mOnDismissListener = obj2;
        obj2 = 0;
        int i2 = 1;
        int i3 = -1;
        d.d dVar = new d.d(this);
        this.mObserver = dVar;
    }

    static Dialog access$000(androidx.fragment.app.d d) {
        return d.mDialog;
    }

    static DialogInterface.OnDismissListener access$100(androidx.fragment.app.d d) {
        return d.mOnDismissListener;
    }

    static boolean access$200(androidx.fragment.app.d d) {
        return d.mShowsDialog;
    }

    private void dismissInternal(boolean z, boolean z2) {
        Object mDismissRunnable;
        int i;
        int obj4;
        Object obj5;
        if (this.mDismissed) {
        }
        int i2 = 1;
        this.mDismissed = i2;
        this.mShownByMe = false;
        mDismissRunnable = this.mDialog;
        mDismissRunnable.setOnDismissListener(0);
        this.mDialog.dismiss();
        if (mDismissRunnable != null && z2 == null) {
            mDismissRunnable.setOnDismissListener(0);
            this.mDialog.dismiss();
            if (z2 == null) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = i2;
        if (this.mBackStackId >= 0) {
            getParentFragmentManager().a1(this.mBackStackId, i2);
            this.mBackStackId = -1;
        } else {
            obj5 = getParentFragmentManager().n();
            obj5.n(this);
            if (z != 0) {
                obj5.h();
            } else {
                obj5.g();
            }
        }
    }

    private void prepareDialog(Bundle bundle) {
        boolean mDialogCreated;
        int i;
        boolean mOnDismissListener;
        boolean mDialog;
        int obj4;
        if (!this.mShowsDialog) {
        }
        if (!this.mDialogCreated) {
            i = 1;
            this.mCreatingDialog = i;
            obj4 = onCreateDialog(bundle);
            this.mDialog = obj4;
            if (this.mShowsDialog) {
                setupDialog(obj4, this.mStyle);
                obj4 = getContext();
                if (obj4 instanceof Activity != null) {
                    this.mDialog.setOwnerActivity((Activity)obj4);
                }
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnCancelListener(this.mOnCancelListener);
                this.mDialog.setOnDismissListener(this.mOnDismissListener);
                this.mDialogCreated = i;
            } else {
                this.mDialog = 0;
            }
            this.mCreatingDialog = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    androidx.fragment.app.g createFragmentContainer() {
        d.e eVar = new d.e(this, super.createFragmentContainer());
        return eVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void dismiss() {
        final int i = 0;
        dismissInternal(i, i);
    }

    @Override // androidx.fragment.app.Fragment
    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public Dialog getDialog() {
        return this.mDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public int getTheme() {
        return this.mTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        boolean obj2;
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i;
        int str;
        Bundle obj4;
        super.onCreate(bundle);
        Handler handler = new Handler();
        this.mHandler = handler;
        str = 1;
        final int i2 = 0;
        i = this.mContainerId == 0 ? str : i2;
        this.mShowsDialog = i;
        if (bundle != null) {
            this.mStyle = bundle.getInt("android:style", i2);
            this.mTheme = bundle.getInt("android:theme", i2);
            this.mCancelable = bundle.getBoolean("android:cancelable", str);
            this.mShowsDialog = bundle.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        boolean obj3;
        if (n.I0(3)) {
            obj3 = new StringBuilder();
            obj3.append("onCreateDialog called for DialogFragment ");
            obj3.append(this);
            Log.d("FragmentManager", obj3.toString());
        }
        obj3 = new Dialog(requireContext(), getTheme());
        return obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        boolean mDismissed;
        Dialog mDialog;
        int i;
        super.onDestroyView();
        mDialog = this.mDialog;
        this.mViewDestroyed = true;
        i = 0;
        mDialog.setOnDismissListener(i);
        this.mDialog.dismiss();
        if (mDialog != null && !this.mDismissed) {
            this.mViewDestroyed = true;
            i = 0;
            mDialog.setOnDismissListener(i);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = i;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        boolean mShownByMe;
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            if (!this.mDismissed) {
                this.mDismissed = true;
            }
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDismiss(DialogInterface dialogInterface) {
        String str;
        boolean obj2;
        if (!this.mViewDestroyed && n.I0(3)) {
            if (n.I0(3)) {
                obj2 = new StringBuilder();
                obj2.append("onDismiss called for DialogFragment ");
                obj2.append(this);
                Log.d("FragmentManager", obj2.toString());
            }
            obj2 = 1;
            dismissInternal(obj2, obj2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    View onFindViewById(int i) {
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            return mDialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater;
        boolean mCreatingDialog;
        int str;
        boolean obj5;
        onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        str = 2;
        final String str4 = "FragmentManager";
        if (this.mShowsDialog) {
            if (this.mCreatingDialog) {
            } else {
                prepareDialog(bundle);
                if (n.I0(str)) {
                    obj5 = new StringBuilder();
                    obj5.append("get layout inflater for DialogFragment ");
                    obj5.append(this);
                    obj5.append(" from dialog context");
                    Log.d(str4, obj5.toString());
                }
                obj5 = this.mDialog;
                if (obj5 != null) {
                    onGetLayoutInflater = onGetLayoutInflater.cloneInContext(obj5.getContext());
                }
            }
            return onGetLayoutInflater;
        }
        if (n.I0(str)) {
            obj5 = new StringBuilder();
            obj5.append("getting layout inflater for DialogFragment ");
            obj5.append(this);
            obj5 = obj5.toString();
            if (!this.mShowsDialog) {
                mCreatingDialog = new StringBuilder();
                mCreatingDialog.append("mShowsDialog = false: ");
                mCreatingDialog.append(obj5);
                Log.d(str4, mCreatingDialog.toString());
            } else {
                mCreatingDialog = new StringBuilder();
                mCreatingDialog.append("mCreatingDialog = true: ");
                mCreatingDialog.append(obj5);
                Log.d(str4, mCreatingDialog.toString());
            }
        }
        return onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Object onSaveInstanceState;
        String str3;
        int str;
        String str2;
        super.onSaveInstanceState(bundle);
        onSaveInstanceState = this.mDialog;
        if (onSaveInstanceState != null) {
            onSaveInstanceState = onSaveInstanceState.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int mStyle = this.mStyle;
        if (mStyle != 0) {
            bundle.putInt("android:style", mStyle);
        }
        int mTheme = this.mTheme;
        if (mTheme != 0) {
            bundle.putInt("android:theme", mTheme);
        }
        boolean mCancelable = this.mCancelable;
        if (!mCancelable) {
            bundle.putBoolean("android:cancelable", mCancelable);
        }
        boolean mShowsDialog = this.mShowsDialog;
        if (!mShowsDialog) {
            bundle.putBoolean("android:showsDialog", mShowsDialog);
        }
        int mBackStackId = this.mBackStackId;
        if (mBackStackId != -1) {
            bundle.putInt("android:backStackId", mBackStackId);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Object decorView;
        int i;
        super.onStart();
        decorView = this.mDialog;
        if (decorView != null) {
            this.mViewDestroyed = false;
            decorView.show();
            decorView = this.mDialog.getWindow().getDecorView();
            k0.a(decorView, this);
            l0.a(decorView, this);
            d.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Object mDialog;
        Bundle obj2;
        super.onViewStateRestored(bundle);
        obj2 = bundle.getBundle("android:savedDialogState");
        if (this.mDialog != null && bundle != null && obj2 != null) {
            if (bundle != null) {
                obj2 = bundle.getBundle("android:savedDialogState");
                if (obj2 != null) {
                    this.mDialog.onRestoreInstanceState(obj2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj1;
        Object obj2;
        super.performCreateView(layoutInflater, viewGroup2, bundle3);
        obj1 = bundle3.getBundle("android:savedDialogState");
        if (this.mView == null && this.mDialog != null && bundle3 != null && obj1 != null) {
            if (this.mDialog != null) {
                if (bundle3 != null) {
                    obj1 = bundle3.getBundle("android:savedDialogState");
                    if (obj1 != null) {
                        this.mDialog.onRestoreInstanceState(obj1);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog == null) {
        } else {
            return dialog;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DialogFragment ");
        stringBuilder.append(this);
        stringBuilder.append(" does not have a Dialog.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // androidx.fragment.app.Fragment
    public void setCancelable(boolean z) {
        this.mCancelable = z;
        final Dialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.setCancelable(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void setStyle(int i, int i2) {
        int i3;
        boolean string;
        String str;
        int obj4;
        i3 = 2;
        if (n.I0(i3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Setting style and theme for DialogFragment ");
            stringBuilder.append(this);
            stringBuilder.append(" to ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(i2);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        this.mStyle = i;
        if (i != i3) {
            if (i == 3) {
                this.mTheme = 16973913;
            }
        } else {
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setupDialog(Dialog dialog, int i2) {
        int i;
        int obj4;
        final int i3 = 1;
        if (i2 != i3 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                    obj4 = dialog.getWindow();
                    if (obj4 != null) {
                        obj4.addFlags(24);
                    }
                    dialog.requestWindowFeature(i3);
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public int show(androidx.fragment.app.w w, String string2) {
        final int i = 0;
        this.mDismissed = i;
        this.mShownByMe = true;
        w.d(this, string2);
        this.mViewDestroyed = i;
        final int obj3 = w.g();
        this.mBackStackId = obj3;
        return obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void show(androidx.fragment.app.n n, String string2) {
        this.mDismissed = false;
        this.mShownByMe = true;
        final androidx.fragment.app.w obj2 = n.n();
        obj2.d(this, string2);
        obj2.g();
    }

    @Override // androidx.fragment.app.Fragment
    public void showNow(androidx.fragment.app.n n, String string2) {
        this.mDismissed = false;
        this.mShownByMe = true;
        final androidx.fragment.app.w obj2 = n.n();
        obj2.d(this, string2);
        obj2.i();
    }
}
