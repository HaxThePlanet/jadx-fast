package app.dogo.com.dogo_android.util.f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* compiled from: BindAdapter.java */
/* loaded from: classes.dex */
public class m {

    class b implements View.OnClickListener {

        final /* synthetic */ LinearLayout a;
        b(LinearLayout linearLayout) {
            this.a = linearLayout;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            final int i = 2131362471;
            final int i2 = 2131362473;
            final int i3 = 2131362474;
            final int i4 = 8;
            final int i5 = 0;
            if (this.a.findViewById(i).getVisibility() == 0) {
                this.a.findViewById(i).setVisibility(i4);
                this.a.findViewById(i3).setVisibility(i5);
                this.a.findViewById(i2).setVisibility(i4);
            } else {
                this.a.findViewById(i).setVisibility(i5);
                this.a.findViewById(i3).setVisibility(i4);
                this.a.findViewById(i2).setVisibility(i5);
            }
        }
    }

    class a implements f<Drawable> {

        final /* synthetic */ ImageView a;
        a(ImageView imageView) {
            this.a = imageView;
            super();
        }

        public boolean a(Drawable drawable, Object object, h<Drawable> hVar, com.bumptech.glide.load.a aVar, boolean z) {
            this.a.setBackground(null);
            return false;
        }

        public boolean onLoadFailed(GlideException exc, Object object, h<Drawable> hVar, boolean z) {
            return false;
        }
    }
    public static void a(ImageView imageView, Uri uri) {
        File file;
        int i = 2131231265;
        if (uri != null) {
            try {
                String uri3 = uri.toString();
            } catch (java.net.URISyntaxException uRISyntax) {
                uRISyntax.printStackTrace();
            }
            if (file != null) {
                m.a(imageView.getContext()).A(uri).y1(d.h()).t1(new d(Long.valueOf(file.lastModified()))).X0(i).Z0(i).R0(g.q0()).C0(imageView);
                return;
            }
        }
        m.a(imageView.getContext()).B(2131231265).R0(g.q0()).C0(imageView);
    }

    public static void b(TextView textView, String str, boolean z) {
        int lineCount;
        int i2 = 2;
        int i3 = 33;
        int lastIndexOf;
        Object obj;
        int i;
        if (str != null) {
            lineCount = Integer.MAX_VALUE;
            textView.setMaxLines(lineCount);
            textView.setText(str);
            if (!z) {
                SpannableString spannableString = new SpannableString(str);
                i2 = 2;
                if (textView.getLineCount() > i2) {
                    int i4 = 1;
                    textView.setMaxLines(i2);
                    str = "More";
                    i = (textView.getLayout().getLineVisibleEnd(i4) - 4) - 3 - i4;
                    i = 0;
                    if (textView.getLayout().getLineVisibleEnd(i4) - 4 - 3 - i4 <= 0) {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    String trimmed = str.substring(i, i).trim();
                    String str3 = "...";
                    str4 = trimmed + str3 + str;
                    lastIndexOf = str4.lastIndexOf(str);
                    lineCount = lastIndexOf + 4;
                    i3 = 33;
                    new SpannableString(str4).setSpan(new ForegroundColorSpan(a.d(textView.getContext(), 2131099840)), lastIndexOf, lineCount, i3);
                }
                textView.setText(obj);
            }
        }
    }

    public static void c(View view, ViewPager viewPager) {
        view.setOnClickListener(new app.dogo.com.dogo_android.util.binding.a(viewPager));
    }

    static /* synthetic */ void d(ViewPager viewPager, View view) {
        final int i = 1;
        viewPager.N(viewPager.getCurrentItem() + i, true);
    }

    static /* synthetic */ void e(View view) {
        view.setVisibility(0);
    }

    static /* synthetic */ void f(View view) {
        view.setVisibility(8);
    }

    public static void g(LinearLayout linearLayout, Void void) {
        linearLayout.findViewById(2131363419).setOnClickListener(new app.dogo.com.dogo_android.util.binding.m.b(linearLayout));
    }

    public static void h(LinearLayout linearLayout, List<String> list) {
        int i = 0;
        Object item;
        View inflate;
        int i2 = 2131363371;
        boolean empty = false;
        int i3 = 2131558460;
        String str;
        if (list != null) {
            linearLayout.getContext();
            Object systemService = linearLayout.getContext().getSystemService("layout_inflater");
            i = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                item = it.next();
                i2 = 2131363371;
                ViewGroup viewGroup = null;
                i3 = 2131558460;
            }
        }
    }

    public static void i(View view, boolean z) {
        int i = 4;
        long l = 200L;
        final float f2 = 0.0f;
        if (z) {
            i = 4;
            if (view.getVisibility() == 4) {
                view.animate().setDuration(0L).scaleX(0.0f).scaleY(0.0f).start();
            }
            if (view.getVisibility() != 0) {
                float f = 1f;
                view.animate().setDuration(l).scaleX(f).scaleY(f).withStartAction(new app.dogo.com.dogo_android.util.binding.b(view)).start();
            }
        } else {
            if (view.getVisibility() == 0) {
                view.animate().setDuration(l).scaleX(0.0f).scaleY(0.0f).withEndAction(new app.dogo.com.dogo_android.util.binding.c(view)).start();
            }
        }
    }

    public static void j(LinearLayout linearLayout, int i, int i2, int i3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources.Theme theme = null;
        int i7;
        float dimension;
        if (i < 0) {
            i7 = 8;
            linearLayout.setVisibility(i7);
        } else {
            if (i >= i2) {
                i7 = i2 - 1;
            }
            ImageView[] arr = new ImageView[i2];
            Context context = linearLayout.getContext();
            i = 0;
            linearLayout.setVisibility(i);
            linearLayout.removeAllViews();
            if (i3 == 0) {
                dimension = context.getResources().getDimension(2131165388);
            } else {
                int i5 = 1;
                dimension = TypedValue.applyDimension(i5, (float)i3, context.getResources().getDisplayMetrics());
            }
            int i10 = (int)dimension;
            theme = null;
            int i6 = 2131231369;
            while (i < i2) {
                arr[i] = new ImageView(context);
                arr[i].setImageDrawable(context.getResources().getDrawable(i6, theme));
                arr[i].setLayoutParams(new LinearLayout.LayoutParams(i10, i10));
                linearLayout.addView(arr[i]);
                i = i + 1;
            }
            if (i2 > 0) {
                arr[i7].setImageDrawable(context.getResources().getDrawable(2131231368, theme));
            }
        }
    }

    public static void k(Button button, int i) {
        button.setIconResource(i);
    }

    public static void l(ViewPager viewPager, View view) {
        int rounded = Math.round(view.getX());
        int i4 = 0;
        viewPager.setPadding(rounded, i4, (viewPager.getWidth() - viewPager.getHeight()) - rounded, i4);
        viewPager.setPageMargin(Math.round(TypedValue.applyDimension(1, 16f, viewPager.getResources().getDisplayMetrics())));
        viewPager.setClipToPadding(false);
    }

    public static void m(Chip chip, String str, int i) {
        String str22;
        int i2 = 1;
        if (i == 0) {
            i2 = 1;
        }
        str22 = "🏳️";
        str22 = App.p().d(str, str22);
        if (chip.getPaint().hasGlyph(str22)) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < i2) {
            stringBuilder.append(str22);
            i = i + 1;
        }
        chip.setText(stringBuilder);
    }

    public static void n(View view, String str) {
        m.a(view.getContext()).D(str).p1(MyAppGlideModule.d(view.getContext())).R0((g)new g().k0(new y(16))).C0(view);
    }

    public static void o(ImageView imageView, String str) {
        int i = 2131231265;
        m.a(imageView.getContext()).D(str).p1(MyAppGlideModule.d(imageView.getContext())).R0(g.q0()).Z0(i).X0(i).C0(imageView);
    }

    public static void p(ImageView imageView, String str) {
        imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
        m.a(imageView.getContext()).D(str).y1(d.h()).c1(new app.dogo.com.dogo_android.util.binding.m.a(imageView)).R0(g.q0()).C0(imageView);
    }

    public static void q(EditText editText, int i, int i2) {
        if (i2 != 0) {
            editText.setRawInputType(i2);
        }
        if (i != 0) {
            editText.setImeOptions(i);
        }
    }

    public static void r(View view, int i) throws android.content.res.Resources.NotFoundException {
        if (i == 0) {
            return;
        }
        view.setBackground(view.getResources().getDrawable(i, null));
    }

    public static void s(EditText editText, TextView.OnEditorActionListener list) {
        editText.setOnEditorActionListener(list);
    }
}
