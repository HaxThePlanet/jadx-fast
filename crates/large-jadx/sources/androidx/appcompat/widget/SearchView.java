package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import d.a.a;
import d.a.d;
import d.a.f;
import d.a.g;
import d.a.h;
import d.a.j;
import d.a.o.c;
import d.h.l.u;
import d.i.a.a;
import d.j.a.a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends androidx.appcompat.widget.e0 implements c {

    static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    static final androidx.appcompat.widget.SearchView.n PRE_API_29_HIDDEN_METHOD_INVOKER = null;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final java.lang.CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private java.lang.CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private androidx.appcompat.widget.SearchView.k mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private androidx.appcompat.widget.SearchView.l mOnQueryChangeListener;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private androidx.appcompat.widget.SearchView.m mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private java.lang.CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final androidx.appcompat.widget.SearchView.SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    a mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private androidx.appcompat.widget.SearchView.p mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private java.lang.CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    class a implements TextWatcher {

        final androidx.appcompat.widget.SearchView a;
        a(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            this.a.onTextChanged(charSequence);
        }
    }

    class b implements Runnable {

        final androidx.appcompat.widget.SearchView a;
        b(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.updateFocusedState();
        }
    }

    class c implements Runnable {

        final androidx.appcompat.widget.SearchView a;
        c(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            a mSuggestionsAdapter = view.mSuggestionsAdapter;
            if (mSuggestionsAdapter instanceof n0) {
                mSuggestionsAdapter.a(0);
            }
        }
    }

    class d implements View.OnFocusChangeListener {

        final androidx.appcompat.widget.SearchView a;
        d(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.view.View$OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            final androidx.appcompat.widget.SearchView obj2 = this.a;
            final View.OnFocusChangeListener mOnQueryTextFocusChangeListener = obj2.mOnQueryTextFocusChangeListener;
            if (mOnQueryTextFocusChangeListener != null) {
                mOnQueryTextFocusChangeListener.onFocusChange(obj2, z2);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {

        final androidx.appcompat.widget.SearchView a;
        e(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.view.View$OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a.adjustDropDownSizeAndPosition();
        }
    }

    class f implements View.OnClickListener {

        final androidx.appcompat.widget.SearchView a;
        f(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object mSearchSrcTextView;
            final androidx.appcompat.widget.SearchView view2 = this.a;
            if (view == view2.mSearchButton) {
                view2.onSearchClicked();
            } else {
                if (view == view2.mCloseButton) {
                    view2.onCloseClicked();
                } else {
                    if (view == view2.mGoButton) {
                        view2.onSubmitQuery();
                    } else {
                        if (view == view2.mVoiceButton) {
                            view2.onVoiceClicked();
                        } else {
                            if (view == view2.mSearchSrcTextView) {
                                view2.forceSuggestionQuery();
                            }
                        }
                    }
                }
            }
        }
    }

    class g implements View.OnKeyListener {

        final androidx.appcompat.widget.SearchView a;
        g(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.view.View$OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent3) {
            boolean listSelection;
            boolean noModifiers;
            SearchableInfo mSearchable;
            KeyEvent obj6;
            androidx.appcompat.widget.SearchView view2 = this.a;
            final int i = 0;
            if (view2.mSearchable == null) {
                return i;
            }
            if (view2.mSearchSrcTextView.isPopupShowing() && view3.mSearchSrcTextView.getListSelection() != -1) {
                if (view3.mSearchSrcTextView.getListSelection() != -1) {
                    return this.a.onSuggestionsKey(view, i2, keyEvent3);
                }
            }
            noModifiers = 1;
            if (!view5.mSearchSrcTextView.b() && keyEvent3.hasNoModifiers() && keyEvent3.getAction() == noModifiers && i2 == 66) {
                if (keyEvent3.hasNoModifiers()) {
                    noModifiers = 1;
                    if (keyEvent3.getAction() == noModifiers) {
                        if (i2 == 66) {
                            view.cancelLongPress();
                            androidx.appcompat.widget.SearchView obj4 = this.a;
                            obj4.launchQuerySearch(i, 0, obj4.mSearchSrcTextView.getText().toString());
                            return noModifiers;
                        }
                    }
                }
            }
            return i;
        }
    }

    class h implements TextView.OnEditorActionListener {

        final androidx.appcompat.widget.SearchView a;
        h(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        @Override // android.widget.TextView$OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent3) {
            this.a.onSubmitQuery();
            return 1;
        }
    }

    class i implements AdapterView.OnItemClickListener {

        final androidx.appcompat.widget.SearchView a;
        i(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
            this.a.onItemClicked(i3, 0, 0);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {

        final androidx.appcompat.widget.SearchView a;
        j(androidx.appcompat.widget.SearchView searchView) {
            this.a = searchView;
            super();
        }

        public void onItemSelected(AdapterView<?> adapterView, View view2, int i3, long l4) {
            this.a.onItemSelected(i3);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        public abstract boolean onClose();
    }

    public interface l {
        public abstract boolean onQueryTextChange(String string);

        public abstract boolean onQueryTextSubmit(String string);
    }

    public interface m {
        public abstract boolean a(int i);

        public abstract boolean b(int i);
    }

    private static class n {

        private Method a = null;
        private Method b = null;
        private Method c = null;
        n() {
            super();
            int i = 0;
            SearchView.n.d();
            int i2 = 0;
            final int i3 = 1;
            Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[i2]);
            this.a = declaredMethod;
            declaredMethod.setAccessible(i3);
            Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[i2]);
            this.b = declaredMethod2;
            declaredMethod2.setAccessible(i3);
            Class[] arr3 = new Class[i3];
            arr3[i2] = Boolean.TYPE;
            Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", arr3);
            this.c = method;
            method.setAccessible(i3);
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
            } else {
            }
            UnsupportedClassVersionError unsupportedClassVersionError = new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            throw unsupportedClassVersionError;
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            Object[] arr;
            SearchView.n.d();
            final Method method = this.b;
            if (method != null) {
                method.invoke(autoCompleteTextView, new Object[0]);
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            Object[] arr;
            SearchView.n.d();
            final Method method = this.a;
            if (method != null) {
                method.invoke(autoCompleteTextView, new Object[0]);
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            Object[] arr;
            int i;
            Boolean tRUE;
            SearchView.n.d();
            final Method method = this.c;
            if (method != null) {
                arr = new Object[1];
                method.invoke(autoCompleteTextView, Boolean.TRUE);
            }
        }
    }

    private static class p extends TouchDelegate {

        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;
        public p(Rect rect, Rect rect2, View view3) {
            super(rect, view3);
            this.e = ViewConfiguration.get(view3.getContext()).getScaledTouchSlop();
            Rect rect3 = new Rect();
            this.b = rect3;
            Rect rect4 = new Rect();
            this.d = rect4;
            Rect rect5 = new Rect();
            this.c = rect5;
            a(rect, rect2);
            this.a = view3;
        }

        @Override // android.view.TouchDelegate
        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            int i = this.e;
            this.d.inset(-i, -i);
            this.c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float f2;
            int view;
            float f;
            boolean z;
            int contains2;
            int contains;
            int left;
            boolean i2;
            int dispatchTouchEvent;
            boolean contains3;
            int i;
            view = (int)f3;
            f = (int)f4;
            contains2 = motionEvent.getAction();
            left = 2;
            i2 = 1;
            dispatchTouchEvent = 0;
            if (contains2 != 0) {
                if (contains2 != i2 && contains2 != left) {
                    if (contains2 != left) {
                        if (contains2 != 3) {
                            contains = i2;
                            i2 = dispatchTouchEvent;
                        } else {
                            z = this.f;
                            this.f = dispatchTouchEvent;
                            i2 = z;
                            contains = i;
                        }
                    } else {
                        z = this.f;
                        if (z && !this.d.contains(view, f)) {
                            if (!this.d.contains(view, f)) {
                                i2 = z;
                                contains = dispatchTouchEvent;
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
                if (this.b.contains(view, f)) {
                    this.f = i2;
                    contains = i2;
                } else {
                }
            }
            if (i2) {
                if (contains != 0 && !this.c.contains(view, f)) {
                    if (!this.c.contains(view, f)) {
                        motionEvent.setLocation((float)i4, (float)i6);
                    } else {
                        Rect rect2 = this.c;
                        motionEvent.setLocation((float)i3, (float)i5);
                    }
                } else {
                }
                dispatchTouchEvent = this.a.dispatchTouchEvent(motionEvent);
            }
            return dispatchTouchEvent;
        }
    }

    static class o extends a {

        public static final Parcelable.Creator<androidx.appcompat.widget.SearchView.o> CREATOR;
        boolean c;
        static {
            SearchView.o.a aVar = new SearchView.o.a();
            SearchView.o.CREATOR = aVar;
        }

        public o(Parcel parcel, java.lang.ClassLoader classLoader2) {
            super(parcel, classLoader2);
            this.c = (Boolean)parcel.readValue(0).booleanValue();
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SearchView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" isIconified=");
            stringBuilder.append(this.c);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.c));
        }
    }

    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        private int v;
        private androidx.appcompat.widget.SearchView w;
        private boolean x;
        final Runnable y;
        public SearchAutoComplete(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2, a.p);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet2, int i3) {
            super(context, attributeSet2, i3);
            SearchView.SearchAutoComplete.a obj1 = new SearchView.SearchAutoComplete.a(this);
            this.y = obj1;
            this.v = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            android.content.res.Configuration configuration;
            int i2;
            int i;
            configuration = getResources().getConfiguration();
            final int screenWidthDp = configuration.screenWidthDp;
            final int screenHeightDp = configuration.screenHeightDp;
            if (screenWidthDp >= 960 && screenHeightDp >= 720 && configuration.orientation == 2) {
                if (screenHeightDp >= 720) {
                    if (configuration.orientation == 2) {
                        return 256;
                    }
                }
            }
            if (screenWidthDp < 600 && screenWidthDp >= 640 && screenHeightDp >= 480) {
                if (screenWidthDp >= 640) {
                    if (screenHeightDp >= 480) {
                    }
                }
                return 160;
            }
            return 192;
        }

        @Override // androidx.appcompat.widget.d
        void a() {
            androidx.appcompat.widget.SearchView.n pRE_API_29_HIDDEN_METHOD_INVOKER;
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                }
            } else {
                SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.c(this);
            }
        }

        @Override // androidx.appcompat.widget.d
        boolean b() {
            int i;
            i = TextUtils.getTrimmedLength(getText()) == 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.appcompat.widget.d
        void c() {
            boolean systemService;
            int i;
            if (this.x) {
                i = 0;
                (InputMethodManager)getContext().getSystemService("input_method").showSoftInput(this, i);
                this.x = i;
            }
        }

        @Override // androidx.appcompat.widget.d
        public boolean enoughToFilter() {
            int i;
            int enoughToFilter;
            if (this.v > 0) {
                if (super.enoughToFilter()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // androidx.appcompat.widget.d
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            boolean z;
            if (this.x) {
                removeCallbacks(this.y);
                post(this.y);
            }
            return super.onCreateInputConnection(editorInfo);
        }

        @Override // androidx.appcompat.widget.d
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int)dimension);
        }

        @Override // androidx.appcompat.widget.d
        protected void onFocusChanged(boolean z, int i2, Rect rect3) {
            super.onFocusChanged(z, i2, rect3);
            this.w.onTextFocusChanged();
        }

        @Override // androidx.appcompat.widget.d
        public boolean onKeyPreIme(int i, KeyEvent keyEvent2) {
            int repeatCount;
            int tracking;
            int i2;
            i2 = 1;
            KeyEvent.DispatcherState obj3 = getKeyDispatcherState();
            if (i == 4 && keyEvent2.getAction() == 0 && keyEvent2.getRepeatCount() == 0 && obj3 != null) {
                i2 = 1;
                if (keyEvent2.getAction() == 0) {
                    if (keyEvent2.getRepeatCount() == 0) {
                        obj3 = getKeyDispatcherState();
                        if (obj3 != null) {
                            obj3.startTracking(keyEvent2, this);
                        }
                        return i2;
                    }
                }
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyEvent2.getAction() == i2 && keyDispatcherState != null) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent2);
                    }
                    if (keyEvent2.isTracking() && !keyEvent2.isCanceled()) {
                        if (!keyEvent2.isCanceled()) {
                            this.w.clearFocus();
                            setImeVisibility(false);
                            return i2;
                        }
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent2);
        }

        @Override // androidx.appcompat.widget.d
        public void onWindowFocusChanged(boolean z) {
            boolean obj1;
            super.onWindowFocusChanged(z);
            this.x = true;
            if (z && this.w.hasFocus() && getVisibility() == 0 && SearchView.isLandscapeMode(getContext())) {
                if (this.w.hasFocus()) {
                    if (getVisibility() == 0) {
                        this.x = true;
                        if (SearchView.isLandscapeMode(getContext())) {
                            a();
                        }
                    }
                }
            }
        }

        @Override // androidx.appcompat.widget.d
        public void performCompletion() {
        }

        @Override // androidx.appcompat.widget.d
        protected void replaceText(java.lang.CharSequence charSequence) {
        }

        @Override // androidx.appcompat.widget.d
        void setImeVisibility(boolean z) {
            Object systemService = getContext().getSystemService("input_method");
            int i = 0;
            if (!z) {
                this.x = i;
                removeCallbacks(this.y);
                (InputMethodManager)systemService.hideSoftInputFromWindow(getWindowToken(), i);
            }
            if (systemService.isActive(this)) {
                this.x = i;
                removeCallbacks(this.y);
                systemService.showSoftInput(this, i);
            }
            this.x = true;
        }

        @Override // androidx.appcompat.widget.d
        void setSearchView(androidx.appcompat.widget.SearchView searchView) {
            this.w = searchView;
        }

        @Override // androidx.appcompat.widget.d
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.v = i;
        }
    }
    static {
        if (Build.VERSION.SDK_INT < 29) {
            SearchView.n nVar = new SearchView.n();
        }
        int i = 0;
    }

    public SearchView(Context context) {
        super(context, 0);
    }

    public SearchView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.J);
    }

    public SearchView(Context context, AttributeSet attributeSet2, int i3) {
        int eVar;
        final Object obj = this;
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        obj.mSearchSrcTextViewBounds = rect;
        Rect rect2 = new Rect();
        obj.mSearchSrtTextViewBoundsExpanded = rect2;
        int i = 2;
        obj.mTemp = new int[i];
        obj.mTemp2 = new int[i];
        SearchView.b bVar = new SearchView.b(obj);
        obj.mUpdateDrawableStateRunnable = bVar;
        SearchView.c cVar = new SearchView.c(obj);
        obj.mReleaseCursorRunnable = cVar;
        WeakHashMap weakHashMap = new WeakHashMap();
        obj.mOutsideDrawablesCache = weakHashMap;
        SearchView.f fVar = new SearchView.f(obj);
        obj.mOnClickListener = fVar;
        SearchView.g gVar = new SearchView.g(obj);
        obj.mTextKeyListener = gVar;
        SearchView.h hVar = new SearchView.h(obj);
        obj.mOnEditorActionListener = hVar;
        SearchView.i iVar = new SearchView.i(obj);
        obj.mOnItemClickListener = iVar;
        SearchView.j jVar = new SearchView.j(obj);
        obj.mOnItemSelectedListener = jVar;
        SearchView.a aVar = new SearchView.a(obj);
        obj.mTextWatcher = aVar;
        int i13 = 0;
        androidx.appcompat.widget.t0 t0Var = t0.v(context, attributeSet2, j.W1, i3, i13);
        LayoutInflater.from(context).inflate(t0Var.n(j.g2, g.r), obj, true);
        View viewById2 = obj.findViewById(f.D);
        obj.mSearchSrcTextView = (SearchView.SearchAutoComplete)viewById2;
        viewById2.setSearchView(obj);
        obj.mSearchEditFrame = obj.findViewById(f.z);
        View viewById4 = obj.findViewById(f.C);
        obj.mSearchPlate = viewById4;
        View viewById5 = obj.findViewById(f.J);
        obj.mSubmitArea = viewById5;
        View viewById6 = obj.findViewById(f.x);
        obj.mSearchButton = (ImageView)viewById6;
        View viewById7 = obj.findViewById(f.A);
        obj.mGoButton = (ImageView)viewById7;
        View viewById8 = obj.findViewById(f.y);
        obj.mCloseButton = (ImageView)viewById8;
        View viewById9 = obj.findViewById(f.E);
        obj.mVoiceButton = (ImageView)viewById9;
        View viewById10 = obj.findViewById(f.B);
        obj.mCollapsedIcon = (ImageView)viewById10;
        u.o0(viewById4, t0Var.g(j.h2));
        u.o0(viewById5, t0Var.g(j.l2));
        int i21 = j.k2;
        viewById6.setImageDrawable(t0Var.g(i21));
        viewById7.setImageDrawable(t0Var.g(j.e2));
        viewById8.setImageDrawable(t0Var.g(j.b2));
        viewById9.setImageDrawable(t0Var.g(j.n2));
        viewById10.setImageDrawable(t0Var.g(i21));
        obj.mSearchHintIcon = t0Var.g(j.j2);
        v0.a(viewById6, getResources().getString(h.l));
        obj.mSuggestionRowLayout = t0Var.n(j.m2, g.q);
        obj.mSuggestionCommitIconResId = t0Var.n(j.c2, i13);
        viewById6.setOnClickListener(fVar);
        viewById8.setOnClickListener(fVar);
        viewById7.setOnClickListener(fVar);
        viewById9.setOnClickListener(fVar);
        viewById2.setOnClickListener(fVar);
        viewById2.addTextChangedListener(obj.mTextWatcher);
        viewById2.setOnEditorActionListener(hVar);
        viewById2.setOnItemClickListener(iVar);
        viewById2.setOnItemSelectedListener(jVar);
        viewById2.setOnKeyListener(obj.mTextKeyListener);
        SearchView.d dVar = new SearchView.d(obj);
        viewById2.setOnFocusChangeListener(dVar);
        obj.setIconifiedByDefault(t0Var.a(j.f2, true));
        int i11 = -1;
        int i4 = t0Var.f(j.Y1, i11);
        if (i4 != i11) {
            obj.setMaxWidth(i4);
        }
        obj.mDefaultQueryHint = t0Var.p(j.d2);
        obj.mQueryHint = t0Var.p(j.i2);
        int i8 = t0Var.k(j.a2, i11);
        if (i8 != i11) {
            obj.setImeOptions(i8);
        }
        int i9 = t0Var.k(j.Z1, i11);
        if (i9 != i11) {
            obj.setInputType(i9);
        }
        obj.setFocusable(t0Var.a(j.X1, true));
        t0Var.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        obj.mVoiceWebSearchIntent = intent;
        eVar = 268435456;
        intent.addFlags(eVar);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        obj.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(eVar);
        View viewById = obj.findViewById(viewById2.getDropDownAnchor());
        obj.mDropDownAnchor = viewById;
        if (viewById != null) {
            eVar = new SearchView.e(obj);
            viewById.addOnLayoutChangeListener(eVar);
        }
        obj.updateViewsVisibility(obj.mIconifiedByDefault);
        updateQueryHint();
    }

    private Intent createIntent(String string, Uri uri2, String string3, String string4, int i5, String string6) {
        Object obj2;
        String obj3;
        Intent intent = new Intent(string);
        intent.addFlags(268435456);
        if (uri2 != null) {
            intent.setData(uri2);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (string4 != null) {
            intent.putExtra("query", string4);
        }
        if (string3 != null) {
            intent.putExtra("intent_extra_data_key", string3);
        }
        obj2 = this.mAppSearchData;
        if (obj2 != null) {
            intent.putExtra("app_data", obj2);
        }
        if (i5 != 0) {
            intent.putExtra("action_key", i5);
            intent.putExtra("action_msg", string6);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i2, String string3) {
        String suggestIntentAction;
        String suggestIntentData;
        String str;
        Uri uri;
        StringBuilder stringBuilder;
        if (n0.o(cursor, "suggest_intent_action") == null) {
            try {
                suggestIntentAction = this.mSearchable.getSuggestIntentAction();
                if (suggestIntentAction == null) {
                }
                suggestIntentAction = "android.intent.action.SEARCH";
                if (n0.o(cursor, "suggest_intent_data") == null) {
                }
                suggestIntentData = this.mSearchable.getSuggestIntentData();
                str = n0.o(cursor, "suggest_intent_data_id");
                if (suggestIntentData != null && str != null) {
                }
                str = n0.o(cursor, "suggest_intent_data_id");
                if (str != null) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(suggestIntentData);
                stringBuilder.append("/");
                stringBuilder.append(Uri.encode(str));
                suggestIntentData = stringBuilder.toString();
                if (suggestIntentData == null) {
                } else {
                }
                uri = i;
                uri = suggestIntentData;
                return this.createIntent(suggestIntentAction, uri, n0.o(cursor, "suggest_intent_extra_data"), n0.o(cursor, "suggest_intent_query"), i2, string3);
                cursor = cursor.getPosition();
                cursor = -1;
                string3 = new StringBuilder();
                string3.append("Search suggestions cursor at row ");
                string3.append(cursor);
                cursor = " returned exception.";
                string3.append(cursor);
                cursor = string3.toString();
                string3 = "SearchView";
                Log.w(string3, cursor, i2);
                return obj0;
            } catch (RuntimeException e) {
            }
        }
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo2) {
        int str;
        String string2;
        String string;
        String string3;
        int flattenToShortString;
        int voiceLanguageId;
        int obj10;
        final ComponentName searchActivity = searchableInfo2.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Bundle bundle = new Bundle();
        Bundle mAppSearchData = this.mAppSearchData;
        if (mAppSearchData != null) {
            bundle.putParcelable("app_data", mAppSearchData);
        }
        Intent intent3 = new Intent(intent);
        obj10 = 1;
        Resources resources = getResources();
        if (searchableInfo2.getVoiceLanguageModeId() != 0) {
            string = resources.getString(searchableInfo2.getVoiceLanguageModeId());
        } else {
            string = "free_form";
        }
        flattenToShortString = 0;
        if (searchableInfo2.getVoicePromptTextId() != 0) {
            string3 = resources.getString(searchableInfo2.getVoicePromptTextId());
        } else {
            string3 = flattenToShortString;
        }
        if (searchableInfo2.getVoiceLanguageId() != 0) {
            string2 = resources.getString(searchableInfo2.getVoiceLanguageId());
        } else {
            string2 = flattenToShortString;
        }
        if (searchableInfo2.getVoiceMaxResults() != 0) {
            obj10 = searchableInfo2.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string3);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", obj10);
        if (searchActivity == null) {
        } else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", flattenToShortString);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", PendingIntent.getActivity(getContext(), 0, intent2, 1073741824));
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo2) {
        int obj2;
        Intent intent2 = new Intent(intent);
        obj2 = searchableInfo2.getSearchActivity();
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.flattenToShortString();
        }
        intent2.putExtra("calling_package", obj2);
        return intent2;
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect2) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] mTemp3 = this.mTemp;
        int i3 = 1;
        final int[] mTemp22 = this.mTemp2;
        i8 -= i4;
        int i5 = 0;
        i -= i6;
        rect2.set(i2, i9, width += i2, obj5 += i9);
    }

    private java.lang.CharSequence getDecoratedHint(java.lang.CharSequence charSequence) {
        boolean mIconifiedByDefault;
        if (this.mIconifiedByDefault && this.mSearchHintIcon == null) {
            if (this.mSearchHintIcon == null) {
            }
            int i2 = (int)i;
            int i3 = 0;
            this.mSearchHintIcon.setBounds(i3, i3, i2, i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            ImageSpan imageSpan = new ImageSpan(this.mSearchHintIcon);
            spannableStringBuilder.setSpan(imageSpan, 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(d.g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.h);
    }

    private boolean hasVoiceSearch() {
        SearchableInfo mVoiceWebSearchIntent;
        int i;
        boolean voiceSearchLaunchWebSearch;
        int i2;
        mVoiceWebSearchIntent = this.mSearchable;
        i = 0;
        if (mVoiceWebSearchIntent != null && mVoiceWebSearchIntent.getVoiceSearchEnabled()) {
            if (mVoiceWebSearchIntent.getVoiceSearchEnabled()) {
                mVoiceWebSearchIntent = 0;
                if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                    mVoiceWebSearchIntent = this.mVoiceWebSearchIntent;
                } else {
                    if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                        mVoiceWebSearchIntent = this.mVoiceAppSearchIntent;
                    }
                }
                if (mVoiceWebSearchIntent != null && getContext().getPackageManager().resolveActivity(mVoiceWebSearchIntent, 65536) != null) {
                    if (getContext().getPackageManager().resolveActivity(mVoiceWebSearchIntent, 65536) != null) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    static boolean isLandscapeMode(Context context) {
        int obj1;
        obj1 = obj1.orientation == 2 ? 1 : 0;
        return obj1;
    }

    private boolean isSubmitAreaEnabled() {
        int i;
        boolean mSubmitButtonEnabled;
        if (!this.mSubmitButtonEnabled) {
            if (this.mVoiceButtonEnabled && !isIconified()) {
                i = !isIconified() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void launchIntent(Intent intent) {
        Context context;
        StringBuilder str2;
        String str;
        Intent obj4;
        if (intent == null) {
        }
        getContext().startActivity(intent);
    }

    private boolean launchSuggestion(int i, int i2, String string3) {
        int obj2;
        Cursor cursor = this.mSuggestionsAdapter.b();
        if (cursor != null && cursor.moveToPosition(i)) {
            if (cursor.moveToPosition(i)) {
                launchIntent(createIntentFromSuggestion(cursor, i2, string3));
                return 1;
            }
        }
        return 0;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int i) {
        java.lang.CharSequence obj3;
        Editable text = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.b();
        if (cursor == null) {
        }
        if (cursor.moveToPosition(i)) {
            obj3 = this.mSuggestionsAdapter.c(cursor);
            if (obj3 != null) {
                setQuery(obj3);
            } else {
                setQuery(text);
            }
        } else {
            setQuery(text);
        }
    }

    private void setQuery(java.lang.CharSequence charSequence) {
        int obj3;
        this.mSearchSrcTextView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            obj3 = 0;
        } else {
            obj3 = charSequence.length();
        }
        this.mSearchSrcTextView.setSelection(obj3);
    }

    private void updateCloseButton() {
        int[] eNABLED_STATE_SET;
        int i2;
        int i;
        boolean mExpandedInActionView;
        empty ^= i2;
        if (eNABLED_STATE_SET == null) {
            if (this.mIconifiedByDefault && this.mExpandedInActionView == null) {
                if (this.mExpandedInActionView == null) {
                } else {
                    i2 = i;
                }
            } else {
            }
        }
        if (i2 != 0) {
        } else {
            i = 8;
        }
        this.mCloseButton.setVisibility(i);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            eNABLED_STATE_SET = eNABLED_STATE_SET != null ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
            drawable.setState(eNABLED_STATE_SET);
        }
    }

    private void updateQueryHint() {
        Object queryHint;
        if (getQueryHint() == null) {
            queryHint = "";
        }
        this.mSearchSrcTextView.setHint(getDecoratedHint(queryHint));
    }

    private void updateSearchAutoComplete() {
        int inputType;
        Object mSuggestionsAdapter;
        int suggestAuthority;
        androidx.appcompat.widget.SearchView.SearchAutoComplete mSearchSrcTextView;
        int i;
        SearchableInfo mSearchable;
        WeakHashMap mOutsideDrawablesCache;
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        inputType = this.mSearchable.getInputType();
        if (inputType & 15 == 1 && this.mSearchable.getSuggestAuthority() != null) {
            if (this.mSearchable.getSuggestAuthority() != null) {
                i2 |= suggestAuthority;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        a mSuggestionsAdapter2 = this.mSuggestionsAdapter;
        if (mSuggestionsAdapter2 != null) {
            mSuggestionsAdapter2.a(0);
        }
        n0 n0Var = new n0(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
        this.mSuggestionsAdapter = n0Var;
        this.mSearchSrcTextView.setAdapter(n0Var);
        if (this.mSearchable.getSuggestAuthority() != null && this.mQueryRefinement) {
            n0Var = new n0(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSuggestionsAdapter = n0Var;
            this.mSearchSrcTextView.setAdapter(n0Var);
            if (this.mQueryRefinement) {
                i = 2;
            }
            (n0)this.mSuggestionsAdapter.x(i);
        }
    }

    private void updateSubmitArea() {
        int submitAreaEnabled;
        int i;
        if (isSubmitAreaEnabled()) {
            if (this.mGoButton.getVisibility() != 0) {
                i = this.mVoiceButton.getVisibility() == 0 ? 0 : 8;
            } else {
            }
        } else {
        }
        this.mSubmitArea.setVisibility(i);
    }

    private void updateSubmitButton(boolean z) {
        boolean mSubmitButtonEnabled;
        int obj2;
        if (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()) {
            if (isSubmitAreaEnabled()) {
                if (hasFocus()) {
                    if (!z) {
                        obj2 = !this.mVoiceButtonEnabled ? 0 : 8;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        this.mGoButton.setVisibility(obj2);
    }

    private void updateViewsVisibility(boolean z) {
        int i;
        int i2;
        int obj6;
        this.mIconified = z;
        i = 0;
        final int i3 = 8;
        i2 = z ? i : i3;
        empty ^= 1;
        this.mSearchButton.setVisibility(i2);
        updateSubmitButton(i4);
        obj6 = z ? i3 : i;
        this.mSearchEditFrame.setVisibility(obj6);
        if (this.mCollapsedIcon.getDrawable() != null) {
            if (this.mIconifiedByDefault) {
                i = i3;
            }
        } else {
        }
        this.mCollapsedIcon.setVisibility(i);
        updateCloseButton();
        updateVoiceButton(i4 ^ 1);
        updateSubmitArea();
    }

    private void updateVoiceButton(boolean z) {
        boolean mVoiceButtonEnabled;
        int i;
        int obj3;
        if (this.mVoiceButtonEnabled && !isIconified() && z != 0) {
            if (!isIconified()) {
                if (z != 0) {
                    this.mGoButton.setVisibility(8);
                    i = obj3;
                }
            }
        }
        this.mVoiceButton.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.e0
    void adjustDropDownSizeAndPosition() {
        Resources dimensionPixelSize;
        int i2;
        int width;
        int mSearchSrcTextView;
        int right;
        int left;
        int i3;
        int i;
        if (this.mDropDownAnchor.getWidth() > 1) {
            dimensionPixelSize = getContext().getResources();
            int paddingLeft = this.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            if (this.mIconifiedByDefault) {
                dimensionPixelSize2 += dimensionPixelSize;
            } else {
                i3 = 0;
            }
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (z0.b(this)) {
                i2 = -left3;
            } else {
                i2 = paddingLeft - i7;
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(i2);
            this.mSearchSrcTextView.setDropDownWidth(i6 -= paddingLeft);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        final int i2 = 0;
        this.mSearchSrcTextView.setImeVisibility(i2);
        this.mClearingFocus = i2;
    }

    @Override // androidx.appcompat.widget.e0
    void forceSuggestionQuery() {
        Object pRE_API_29_HIDDEN_METHOD_INVOKER;
        int mSearchSrcTextView;
        if (Build.VERSION.SDK_INT >= 29) {
            this.mSearchSrcTextView.refreshAutoCompleteResults();
        } else {
            pRE_API_29_HIDDEN_METHOD_INVOKER = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
            pRE_API_29_HIDDEN_METHOD_INVOKER.b(this.mSearchSrcTextView);
            pRE_API_29_HIDDEN_METHOD_INVOKER.a(this.mSearchSrcTextView);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    @Override // androidx.appcompat.widget.e0
    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    @Override // androidx.appcompat.widget.e0
    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // androidx.appcompat.widget.e0
    public java.lang.CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    @Override // androidx.appcompat.widget.e0
    public java.lang.CharSequence getQueryHint() {
        java.lang.CharSequence mDefaultQueryHint;
        SearchableInfo mSearchable;
        int hintId;
        if (this.mQueryHint != null) {
        } else {
            mSearchable = this.mSearchable;
            if (mSearchable != null && mSearchable.getHintId() != 0) {
                if (mSearchable.getHintId() != 0) {
                    mDefaultQueryHint = getContext().getText(this.mSearchable.getHintId());
                } else {
                    mDefaultQueryHint = this.mDefaultQueryHint;
                }
            } else {
            }
        }
        return mDefaultQueryHint;
    }

    @Override // androidx.appcompat.widget.e0
    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    @Override // androidx.appcompat.widget.e0
    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    @Override // androidx.appcompat.widget.e0
    public a getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean isIconified() {
        return this.mIconified;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    @Override // androidx.appcompat.widget.e0
    void launchQuerySearch(int i, String string2, String string3) {
        getContext().startActivity(this.createIntent("android.intent.action.SEARCH", 0, 0, string3, i, string2));
    }

    @Override // androidx.appcompat.widget.e0
    public void onActionViewCollapsed() {
        final int i2 = 0;
        setQuery("", i2);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = i2;
    }

    @Override // androidx.appcompat.widget.e0
    public void onActionViewExpanded() {
        if (this.mExpandedInActionView != null) {
        }
        this.mExpandedInActionView = true;
        int imeOptions = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = imeOptions;
        this.mSearchSrcTextView.setImeOptions(imeOptions |= i4);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    @Override // androidx.appcompat.widget.e0
    void onCloseClicked() {
        androidx.appcompat.widget.SearchView.k mIconifiedByDefault;
        String str;
        final int i = 1;
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            if (this.mIconifiedByDefault) {
                mIconifiedByDefault = this.mOnCloseListener;
                if (mIconifiedByDefault != null) {
                    if (!mIconifiedByDefault.onClose()) {
                        clearFocus();
                        updateViewsVisibility(i);
                    }
                } else {
                }
            }
        } else {
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.setImeVisibility(i);
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.e0
    boolean onItemClicked(int i, int i2, String string3) {
        androidx.appcompat.widget.SearchView.m obj2;
        obj2 = this.mOnSuggestionListener;
        final int obj3 = 0;
        if (obj2 != null && !obj2.b(i)) {
            if (!obj2.b(i)) {
            }
            return obj3;
        }
        launchSuggestion(i, obj3, 0);
        this.mSearchSrcTextView.setImeVisibility(obj3);
        dismissSuggestions();
        return 1;
    }

    @Override // androidx.appcompat.widget.e0
    boolean onItemSelected(int i) {
        androidx.appcompat.widget.SearchView.m mOnSuggestionListener;
        mOnSuggestionListener = this.mOnSuggestionListener;
        if (mOnSuggestionListener != null && !mOnSuggestionListener.a(i)) {
            if (!mOnSuggestionListener.a(i)) {
            }
            return 0;
        }
        rewriteQueryFromSuggestion(i);
        return 1;
    }

    @Override // androidx.appcompat.widget.e0
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        boolean obj2;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            obj3 = this.mSearchSrcTextViewBounds;
            this.mSearchSrtTextViewBoundsExpanded.set(obj3.left, 0, obj3.right, i5 -= i3);
            obj2 = this.mTouchDelegate;
            if (obj2 == null) {
                obj2 = new SearchView.p(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                this.mTouchDelegate = obj2;
                setTouchDelegate(obj2);
            } else {
                obj2.a(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void onMeasure(int i, int i2) {
        int preferredWidth;
        int preferredHeight;
        int obj4;
        int obj5;
        if (isIconified()) {
            super.onMeasure(i, i2);
        }
        preferredWidth = View.MeasureSpec.getMode(i);
        obj4 = View.MeasureSpec.getSize(i);
        final int i3 = Integer.MIN_VALUE;
        final int i4 = 1073741824;
        if (preferredWidth != i3) {
            if (preferredWidth != 0) {
                if (preferredWidth != i4) {
                } else {
                    preferredWidth = this.mMaxWidth;
                    if (preferredWidth > 0) {
                        obj4 = Math.min(preferredWidth, obj4);
                    }
                }
            } else {
                if (this.mMaxWidth > 0) {
                } else {
                    obj4 = getPreferredWidth();
                }
            }
        } else {
            preferredWidth = this.mMaxWidth;
            if (preferredWidth > 0) {
                obj4 = Math.min(preferredWidth, obj4);
            } else {
                obj4 = Math.min(getPreferredWidth(), obj4);
            }
        }
        preferredHeight = View.MeasureSpec.getMode(i2);
        if (preferredHeight != i3) {
            if (preferredHeight != 0) {
            } else {
                obj5 = getPreferredHeight();
            }
        } else {
            obj5 = Math.min(getPreferredHeight(), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(obj4, i4), View.MeasureSpec.makeMeasureSpec(obj5, i4));
    }

    @Override // androidx.appcompat.widget.e0
    void onQueryRefine(java.lang.CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // androidx.appcompat.widget.e0
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof SearchView.o) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((SearchView.o)parcelable.a());
        updateViewsVisibility(parcelable.c);
        requestLayout();
    }

    @Override // androidx.appcompat.widget.e0
    protected Parcelable onSaveInstanceState() {
        SearchView.o oVar = new SearchView.o(super.onSaveInstanceState());
        oVar.c = isIconified();
        return oVar;
    }

    @Override // androidx.appcompat.widget.e0
    void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener mOnSearchClickListener = this.mOnSearchClickListener;
        if (mOnSearchClickListener != null) {
            mOnSearchClickListener.onClick(this);
        }
    }

    @Override // androidx.appcompat.widget.e0
    void onSubmitQuery() {
        Object mSearchSrcTextView;
        int mOnQueryChangeListener;
        String string;
        mSearchSrcTextView = this.mSearchSrcTextView.getText();
        if (mSearchSrcTextView != null && TextUtils.getTrimmedLength(mSearchSrcTextView) > 0) {
            if (TextUtils.getTrimmedLength(mSearchSrcTextView) > 0) {
                mOnQueryChangeListener = this.mOnQueryChangeListener;
                if (mOnQueryChangeListener != null) {
                    string = 0;
                    if (!mOnQueryChangeListener.onQueryTextSubmit(mSearchSrcTextView.toString()) && this.mSearchable != null) {
                        string = 0;
                        if (this.mSearchable != null) {
                            launchQuerySearch(string, 0, mSearchSrcTextView.toString());
                        }
                        this.mSearchSrcTextView.setImeVisibility(string);
                        dismissSuggestions();
                    }
                } else {
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    boolean onSuggestionsKey(View view, int i2, KeyEvent keyEvent3) {
        int obj2;
        int obj4;
        final int i = 0;
        if (this.mSearchable == null) {
            return i;
        }
        if (this.mSuggestionsAdapter == null) {
            return i;
        }
        if (keyEvent3.getAction() == 0 && keyEvent3.hasNoModifiers() && i2 != 66 && i2 != 84) {
            if (keyEvent3.hasNoModifiers()) {
                if (i2 != 66) {
                    if (i2 != 84) {
                        if (i2 == 61) {
                        } else {
                            obj2 = 21;
                            if (i2 != obj2) {
                                if (i2 == 22) {
                                    if (i2 == obj2) {
                                        obj2 = i;
                                    } else {
                                        obj2 = this.mSearchSrcTextView.length();
                                    }
                                } else {
                                    if (i2 == 19 && this.mSearchSrcTextView.getListSelection() == 0) {
                                        if (this.mSearchSrcTextView.getListSelection() == 0) {
                                            return i;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                        this.mSearchSrcTextView.setSelection(obj2);
                        this.mSearchSrcTextView.setListSelection(i);
                        this.mSearchSrcTextView.clearListSelection();
                        this.mSearchSrcTextView.a();
                        return 1;
                    }
                }
                return onItemClicked(this.mSearchSrcTextView.getListSelection(), i, 0);
            }
        }
        return i;
    }

    @Override // androidx.appcompat.widget.e0
    void onTextChanged(java.lang.CharSequence charSequence) {
        androidx.appcompat.widget.SearchView.l mOnQueryChangeListener;
        String string;
        Editable text = this.mSearchSrcTextView.getText();
        this.mUserQuery = text;
        empty ^= 1;
        updateSubmitButton(i);
        updateVoiceButton(i ^= 1);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(charSequence, this.mOldQueryText)) {
            if (!TextUtils.equals(charSequence, this.mOldQueryText)) {
                this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
            }
        }
        this.mOldQueryText = charSequence.toString();
    }

    @Override // androidx.appcompat.widget.e0
    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    @Override // androidx.appcompat.widget.e0
    void onVoiceClicked() {
        Object voiceWebSearchIntent;
        Context voiceSearchLaunchRecognizer;
        voiceWebSearchIntent = this.mSearchable;
        if (voiceWebSearchIntent == null) {
        }
        if (voiceWebSearchIntent.getVoiceSearchLaunchWebSearch()) {
            getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, voiceWebSearchIntent));
        } else {
            if (voiceWebSearchIntent.getVoiceSearchLaunchRecognizer()) {
                try {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, voiceWebSearchIntent));
                    Log.w("SearchView", "Could not find voice search activity");
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        postUpdateFocusedState();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean requestFocus(int i, Rect rect2) {
        final int i2 = 0;
        if (this.mClearingFocus) {
            return i2;
        }
        if (!isFocusable()) {
            return i2;
        }
        boolean obj3 = this.mSearchSrcTextView.requestFocus(i, rect2);
        if (!isIconified() && obj3 != null) {
            obj3 = this.mSearchSrcTextView.requestFocus(i, rect2);
            if (obj3 != null) {
                updateViewsVisibility(i2);
            }
            return obj3;
        }
        return super.requestFocus(i, rect2);
    }

    @Override // androidx.appcompat.widget.e0
    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    @Override // androidx.appcompat.widget.e0
    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault == z) {
        }
        this.mIconifiedByDefault = z;
        updateViewsVisibility(z);
        updateQueryHint();
    }

    @Override // androidx.appcompat.widget.e0
    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    @Override // androidx.appcompat.widget.e0
    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    @Override // androidx.appcompat.widget.e0
    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnCloseListener(androidx.appcompat.widget.SearchView.k searchView$k) {
        this.mOnCloseListener = k;
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener view$OnFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnQueryTextListener(androidx.appcompat.widget.SearchView.l searchView$l) {
        this.mOnQueryChangeListener = l;
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnSearchClickListener(View.OnClickListener view$OnClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnSuggestionListener(androidx.appcompat.widget.SearchView.m searchView$m) {
        this.mOnSuggestionListener = m;
    }

    @Override // androidx.appcompat.widget.e0
    public void setQuery(java.lang.CharSequence charSequence, boolean z2) {
        androidx.appcompat.widget.SearchView.SearchAutoComplete mSearchSrcTextView;
        int length;
        java.lang.CharSequence obj3;
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            mSearchSrcTextView = this.mSearchSrcTextView;
            mSearchSrcTextView.setSelection(mSearchSrcTextView.length());
            this.mUserQuery = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            if (!TextUtils.isEmpty(charSequence)) {
                onSubmitQuery();
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setQueryHint(java.lang.CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    @Override // androidx.appcompat.widget.e0
    public void setQueryRefinementEnabled(boolean z) {
        int obj3;
        this.mQueryRefinement = z;
        final a mSuggestionsAdapter = this.mSuggestionsAdapter;
        if (mSuggestionsAdapter instanceof n0) {
            obj3 = z ? 2 : 1;
            (n0)mSuggestionsAdapter.x(obj3);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setSearchableInfo(SearchableInfo searchableInfo) {
        String str;
        boolean obj2;
        this.mSearchable = searchableInfo;
        if (searchableInfo != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        obj2 = hasVoiceSearch();
        this.mVoiceButtonEnabled = obj2;
        if (obj2 != null) {
            this.mSearchSrcTextView.setPrivateImeOptions("nm");
        }
        updateViewsVisibility(isIconified());
    }

    @Override // androidx.appcompat.widget.e0
    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(isIconified());
    }

    @Override // androidx.appcompat.widget.e0
    public void setSuggestionsAdapter(a a) {
        this.mSuggestionsAdapter = a;
        this.mSearchSrcTextView.setAdapter(a);
    }

    @Override // androidx.appcompat.widget.e0
    void updateFocusedState() {
        int[] fOCUSED_STATE_SET;
        fOCUSED_STATE_SET = this.mSearchSrcTextView.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(fOCUSED_STATE_SET);
        }
        Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(fOCUSED_STATE_SET);
        }
        invalidate();
    }
}
