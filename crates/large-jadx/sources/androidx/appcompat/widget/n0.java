package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import d.a.a;
import d.a.f;
import d.i.a.a;
import d.i.a.c;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class n0 extends c implements View.OnClickListener {

    private final androidx.appcompat.widget.SearchView D;
    private final SearchableInfo E;
    private final Context F;
    private final WeakHashMap<String, Drawable.ConstantState> G;
    private final int H;
    private boolean I = false;
    private int J = 1;
    private ColorStateList K;
    private int L = -1;
    private int M = -1;
    private int N = -1;
    private int O = -1;
    private int P = -1;
    private int Q = -1;

    private static final class a {

        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;
        public a(View view) {
            super();
            this.a = (TextView)view.findViewById(16908308);
            this.b = (TextView)view.findViewById(16908309);
            this.c = (ImageView)view.findViewById(16908295);
            this.d = (ImageView)view.findViewById(16908296);
            this.e = (ImageView)view.findViewById(f.q);
        }
    }
    public n0(Context context, androidx.appcompat.widget.SearchView searchView2, SearchableInfo searchableInfo3, WeakHashMap<String, Drawable.ConstantState> weakHashMap4) {
        super(context, searchView2.getSuggestionRowLayout(), 0, 1);
        int i = 0;
        int i2 = -1;
        this.D = searchView2;
        this.E = searchableInfo3;
        this.H = searchView2.getSuggestionCommitIconResId();
        this.F = context;
        this.G = weakHashMap4;
    }

    private void A(String string, Drawable drawable2) {
        WeakHashMap map;
        Drawable.ConstantState obj3;
        if (drawable2 != null) {
            this.G.put(string, drawable2.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        String str;
        Bundle obj2;
        if (cursor != null) {
            obj2 = cursor.getExtras();
        } else {
            obj2 = 0;
        }
        if (obj2 != null) {
        }
    }

    private Drawable k(String string) {
        Object obj2 = this.G.get(string);
        if ((Drawable.ConstantState)obj2 == null) {
            return null;
        }
        return (Drawable.ConstantState)obj2.newDrawable();
    }

    private java.lang.CharSequence l(java.lang.CharSequence charSequence) {
        ColorStateList colorStateList;
        Resources resources;
        int i2;
        int i;
        if (this.K == null) {
            TypedValue typedValue = new TypedValue();
            this.v.getTheme().resolveAttribute(a.N, typedValue, true);
            this.K = this.v.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        super(0, 0, 0, this.K, 0);
        spannableString.setSpan(textAppearanceSpan2, 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.v.getPackageManager();
        final int i2 = 0;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
        final int iconResource = activityInfo.getIconResource();
        if (iconResource == null) {
            return i2;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid icon resource ");
            stringBuilder.append(iconResource);
            stringBuilder.append(" for ");
            stringBuilder.append(componentName.flattenToShortString());
            Log.w("SuggestionsAdapter", stringBuilder.toString());
            return i2;
        }
        return drawable;
    }

    private Drawable n(ComponentName componentName) {
        Object flattenToShortString;
        Drawable.ConstantState constantState;
        flattenToShortString = componentName.flattenToShortString();
        constantState = 0;
        if (this.G.containsKey(flattenToShortString)) {
            Object obj4 = this.G.get(flattenToShortString);
            if ((Drawable.ConstantState)obj4 == null) {
            } else {
                constantState = (Drawable.ConstantState)obj4.newDrawable(this.F.getResources());
            }
            return constantState;
        }
        obj4 = m(componentName);
        if (obj4 == null) {
        } else {
            constantState = obj4.getConstantState();
        }
        this.G.put(flattenToShortString, constantState);
        return obj4;
    }

    public static String o(Cursor cursor, String string2) {
        return n0.w(cursor, cursor.getColumnIndex(string2));
    }

    private Drawable p() {
        Drawable drawable = n(this.E.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }
        return this.v.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        String str;
        StringBuilder stringBuilder;
        InputStream inputStream;
        String str2;
        StringBuilder stringBuilder2;
        str = "Error closing icon stream for ";
        final String str3 = "SuggestionsAdapter";
        if ("android.resource".equals(uri.getScheme())) {
            return r(uri);
        }
        inputStream = this.F.getContentResolver().openInputStream(uri);
        if (inputStream == null) {
        } else {
            inputStream.close();
            return Drawable.createFromStream(inputStream, 0);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Failed to open ");
        stringBuilder3.append(uri);
        FileNotFoundException fileNotFoundException = new FileNotFoundException(stringBuilder3.toString());
        throw fileNotFoundException;
    }

    private Drawable s(String string) {
        int i;
        StringBuilder equals;
        i = 0;
        if (string != null && !string.isEmpty()) {
            if (!string.isEmpty()) {
                if ("0".equals(string)) {
                } else {
                    int int = Integer.parseInt(string);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("android.resource://");
                    stringBuilder.append(this.F.getPackageName());
                    stringBuilder.append("/");
                    stringBuilder.append(int);
                    String string2 = stringBuilder.toString();
                    Drawable drawable3 = k(string2);
                    if (drawable3 != null) {
                        return drawable3;
                    }
                }
                Drawable drawable2 = a.f(this.F, int);
                A(string2, drawable2);
                return drawable2;
            }
        }
        return i;
    }

    private Drawable t(Cursor cursor) {
        final int i = this.O;
        if (i == -1) {
            return null;
        }
        Drawable obj3 = s(cursor.getString(i));
        if (obj3 != null) {
            return obj3;
        }
        return p();
    }

    private Drawable u(Cursor cursor) {
        final int i = this.P;
        if (i == -1) {
            return null;
        }
        return s(cursor.getString(i));
    }

    private static String w(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        return cursor.getString(i2);
    }

    private void y(ImageView imageView, Drawable drawable2, int i3) {
        int obj1;
        int obj3;
        imageView.setImageDrawable(drawable2);
        if (drawable2 == null) {
            imageView.setVisibility(i3);
        } else {
            obj3 = 0;
            imageView.setVisibility(obj3);
            drawable2.setVisible(obj3, obj3);
            drawable2.setVisible(true, obj3);
        }
    }

    private void z(TextView textView, java.lang.CharSequence charSequence2) {
        int obj2;
        textView.setText(charSequence2);
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // d.i.a.c
    public void a(Cursor cursor) {
        boolean str;
        Cursor obj3;
        Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
        if (this.I && cursor != null) {
            Log.w(str9, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
        }
        super.a(cursor);
        if (cursor != null) {
            this.L = cursor.getColumnIndex("suggest_text_1");
            this.M = cursor.getColumnIndex("suggest_text_2");
            this.N = cursor.getColumnIndex("suggest_text_2_url");
            this.O = cursor.getColumnIndex("suggest_icon_1");
            this.P = cursor.getColumnIndex("suggest_icon_2");
            this.Q = cursor.getColumnIndex("suggest_flags");
        }
    }

    @Override // d.i.a.c
    public java.lang.CharSequence c(Cursor cursor) {
        boolean rewriteQueryFromData;
        boolean rewriteQueryFromText;
        Object obj3;
        final int i = 0;
        if (cursor == null) {
            return i;
        }
        String str2 = n0.o(cursor, "suggest_intent_query");
        if (str2 != null) {
            return str2;
        }
        rewriteQueryFromData = n0.o(cursor, "suggest_intent_data");
        if (this.E.shouldRewriteQueryFromData() && rewriteQueryFromData != null) {
            rewriteQueryFromData = n0.o(cursor, "suggest_intent_data");
            if (rewriteQueryFromData != null) {
                return rewriteQueryFromData;
            }
        }
        obj3 = n0.o(cursor, "suggest_text_1");
        if (this.E.shouldRewriteQueryFromText() && obj3 != null) {
            obj3 = n0.o(cursor, "suggest_text_1");
            if (obj3 != null) {
                return obj3;
            }
        }
        return i;
    }

    @Override // d.i.a.c
    public Cursor d(java.lang.CharSequence charSequence) {
        int windowVisibility;
        String str;
        String obj4;
        if (charSequence == null) {
            obj4 = "";
        } else {
            obj4 = charSequence.toString();
        }
        if (this.D.getVisibility() == 0) {
            if (this.D.getWindowVisibility() != 0) {
            } else {
                obj4 = v(this.E, obj4, 50);
                if (obj4 != null) {
                    obj4.getCount();
                    return obj4;
                }
            }
        }
        return null;
    }

    @Override // d.i.a.c
    public void e(View view, Context context2, Cursor cursor3) {
        Object view5;
        Object view2;
        TextView view4;
        TextView view3;
        TextView view6;
        int i;
        ImageView obj7;
        int obj8;
        Object obj9;
        obj7 = view.getTag();
        obj8 = this.Q;
        final int i2 = 0;
        if (obj8 != -1) {
            obj8 = cursor3.getInt(obj8);
        } else {
            obj8 = i2;
        }
        if (obj7.a != null) {
            z(obj7.a, n0.w(cursor3, this.L));
        }
        int i7 = 2;
        final int i8 = 1;
        if (obj7.b != null) {
            String str = n0.w(cursor3, this.N);
            if (str != null) {
                view2 = l(str);
            } else {
                view2 = n0.w(cursor3, this.M);
            }
            if (TextUtils.isEmpty(view2)) {
                view3 = obj7.a;
                if (view3 != null) {
                    view3.setSingleLine(i2);
                    obj7.a.setMaxLines(i7);
                }
            } else {
                view3 = obj7.a;
                if (view3 != null) {
                    view3.setSingleLine(i8);
                    obj7.a.setMaxLines(i8);
                }
            }
            z(obj7.b, view2);
        }
        ImageView view7 = obj7.c;
        if (view7 != null) {
            y(view7, t(cursor3), 4);
        }
        ImageView view8 = obj7.d;
        int i9 = 8;
        if (view8 != null) {
            y(view8, u(cursor3), i9);
        }
        obj9 = this.J;
        if (obj9 != i7) {
            if (obj9 == i8 && obj8 &= i8 != 0) {
                if (obj8 &= i8 != 0) {
                    obj7.e.setVisibility(i2);
                    obj7.e.setTag(obj7.a.getText());
                    obj7.e.setOnClickListener(this);
                } else {
                    obj7.e.setVisibility(i9);
                }
            } else {
            }
        } else {
        }
    }

    @Override // d.i.a.c
    public View getDropDownView(int i, View view2, ViewGroup viewGroup3) {
        try {
            return super.getDropDownView(i, view2, viewGroup3);
            view2 = "SuggestionsAdapter";
            String str = "Search suggestions cursor threw exception.";
            Log.w(view2, str, i);
            view2 = this.v;
            str = this.c;
            view2 = g(view2, str, viewGroup3);
            if (view2 != null) {
            }
            viewGroup3 = view2.getTag();
            viewGroup3 = viewGroup3.a;
            i = i.toString();
            (n0.a)viewGroup3.setText(i);
            return view2;
        }
    }

    @Override // d.i.a.c
    public View getView(int i, View view2, ViewGroup viewGroup3) {
        try {
            return super.getView(i, view2, viewGroup3);
            view2 = "SuggestionsAdapter";
            String str = "Search suggestions cursor threw exception.";
            Log.w(view2, str, i);
            view2 = this.v;
            str = this.c;
            view2 = h(view2, str, viewGroup3);
            if (view2 != null) {
            }
            viewGroup3 = view2.getTag();
            viewGroup3 = viewGroup3.a;
            i = i.toString();
            (n0.a)viewGroup3.setText(i);
            return view2;
        }
    }

    @Override // d.i.a.c
    public View h(Context context, Cursor cursor2, ViewGroup viewGroup3) {
        final View obj1 = super.h(context, cursor2, viewGroup3);
        n0.a obj2 = new n0.a(obj1);
        obj1.setTag(obj2);
        (ImageView)obj1.findViewById(f.q).setImageResource(this.H);
        return obj1;
    }

    @Override // d.i.a.c
    public boolean hasStableIds() {
        return 0;
    }

    @Override // d.i.a.c
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // d.i.a.c
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // d.i.a.c
    public void onClick(View view) {
        boolean z;
        final Object obj2 = view.getTag();
        if (obj2 instanceof CharSequence) {
            this.D.onQueryRefine((CharSequence)obj2);
        }
    }

    @Override // d.i.a.c
    Drawable r(Uri uri) {
        int identifier;
        Object pathSegments;
        int size;
        int i;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
        } else {
            Resources resourcesForApplication = this.v.getPackageManager().getResourcesForApplication(authority);
            pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
            } else {
                size = pathSegments.size();
                final int i2 = 0;
                final int i3 = 1;
                if (size == i3) {
                    identifier = Integer.parseInt((String)pathSegments.get(i2));
                    if (identifier == 0) {
                    } else {
                        return resourcesForApplication.getDrawable(identifier);
                    }
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("No resource found for: ");
                    stringBuilder4.append(uri);
                    FileNotFoundException fileNotFoundException4 = new FileNotFoundException(stringBuilder4.toString());
                    throw fileNotFoundException4;
                } else {
                    if (size != 2) {
                    } else {
                        identifier = resourcesForApplication.getIdentifier((String)pathSegments.get(i3), (String)pathSegments.get(i2), authority);
                    }
                }
                try {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("More than two path segments: ");
                    stringBuilder5.append(uri);
                    FileNotFoundException fileNotFoundException5 = new FileNotFoundException(stringBuilder5.toString());
                    throw fileNotFoundException5;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("No path: ");
                    stringBuilder3.append(uri);
                    FileNotFoundException fileNotFoundException3 = new FileNotFoundException(stringBuilder3.toString());
                    throw fileNotFoundException3;
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "No package found for authority: ";
                    stringBuilder.append(str);
                    stringBuilder.append(uri);
                    uri = stringBuilder.toString();
                    FileNotFoundException fileNotFoundException = new FileNotFoundException(uri);
                    throw fileNotFoundException;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("No authority: ");
                    stringBuilder2.append(uri);
                    FileNotFoundException fileNotFoundException2 = new FileNotFoundException(stringBuilder2.toString());
                    throw fileNotFoundException2;
                } catch (java.lang.NumberFormatException numberFormat) {
                }
            }
        }
    }

    @Override // d.i.a.c
    Cursor v(SearchableInfo searchableInfo, String string2, int i3) {
        String[] strArr;
        int obj10;
        String obj11;
        strArr = 0;
        if (searchableInfo == 0) {
            return strArr;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return strArr;
        }
        Uri.Builder builder = new Uri.Builder();
        String str = "";
        Uri.Builder fragment = builder.scheme("content").authority(suggestAuthority).query(str).fragment(str);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        final String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            new String[1][0] = string2;
        } else {
            fragment.appendPath(string2);
        }
        if (i3 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return this.v.getContentResolver().query(fragment.build(), 0, suggestSelection, strArr, 0);
    }

    @Override // d.i.a.c
    public void x(int i) {
        this.J = i;
    }
}
