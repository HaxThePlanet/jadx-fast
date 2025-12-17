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
import androidx.core.content.a;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.n.e.d;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.s.d;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    class b implements View.OnClickListener {

        final LinearLayout a;
        b(LinearLayout linearLayout) {
            this.a = linearLayout;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            View obj6;
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

        final ImageView a;
        a(ImageView imageView) {
            this.a = imageView;
            super();
        }

        public boolean a(Drawable drawable, Object object2, h<Drawable> h3, a a4, boolean z5) {
            this.a.setBackground(0);
            return 0;
        }

        public boolean onLoadFailed(GlideException glideException, Object object2, h<Drawable> h3, boolean z4) {
            return 0;
        }

        @Override // com.bumptech.glide.r.f
        public boolean onResourceReady(Object object, Object object2, h h3, a a4, boolean z5) {
            return a((Drawable)object, object2, h3, a4, z5);
        }
    }
    public static void a(ImageView imageView, Uri uri2) {
        File file;
        File file2;
        URI uri;
        String string;
        int i = 2131231265;
        if (uri2 != null) {
            int i2 = 0;
            string = uri2.toString();
            uri = new URI(string);
            file2 = new File(uri);
            file = file2;
            if (file != null) {
                d dVar2 = new d(Long.valueOf(file.lastModified()));
                m.a(imageView.getContext()).A(uri2).y1(d.h()).t1(dVar2).X0(i).Z0(i).R0(g.q0()).C0(imageView);
            }
        }
        m.a(imageView.getContext()).B(Integer.valueOf(i)).R0(g.q0()).C0(imageView);
    }

    public static void b(TextView textView, String string2, boolean z3) {
        int lineCount;
        int foregroundColorSpan;
        int i;
        java.lang.CharSequence obj4;
        SpannableString obj5;
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setText(string2);
        obj5 = new SpannableString(string2);
        foregroundColorSpan = 2;
        if (string2 != null && z3 == null && textView.getLineCount() > foregroundColorSpan) {
            textView.setMaxLines(Integer.MAX_VALUE);
            textView.setText(string2);
            if (z3 == null) {
                obj5 = new SpannableString(string2);
                foregroundColorSpan = 2;
                if (textView.getLineCount() > foregroundColorSpan) {
                    int i2 = 1;
                    textView.setMaxLines(foregroundColorSpan);
                    String str = "More";
                    int i3 = 0;
                    if (obj5 -= i2 > 0) {
                    } else {
                        obj5 = i3;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2.substring(i3, obj5).trim());
                    stringBuilder.append("...");
                    stringBuilder.append(str);
                    obj4 = stringBuilder.toString();
                    obj5 = new SpannableString(obj4);
                    obj4 = obj4.lastIndexOf(str);
                    foregroundColorSpan = new ForegroundColorSpan(a.d(textView.getContext(), 2131099840));
                    obj5.setSpan(foregroundColorSpan, obj4, obj4 + 4, 33);
                }
                textView.setText(obj5);
            }
        }
    }

    public static void c(View view, ViewPager viewPager2) {
        a aVar = new a(viewPager2);
        view.setOnClickListener(aVar);
    }

    static void d(ViewPager viewPager, View view2) {
        final int i = 1;
        viewPager.N(obj2 += i, i);
    }

    static void e(View view) {
        view.setVisibility(0);
    }

    static void f(View view) {
        view.setVisibility(8);
    }

    public static void g(LinearLayout linearLayout, Void void2) {
        m.b bVar = new m.b(linearLayout);
        linearLayout.findViewById(2131363419).setOnClickListener(bVar);
    }

    public static void h(LinearLayout linearLayout, List<String> list2) {
        Object systemService;
        int i;
        boolean replaceFirst;
        View inflate;
        int viewById;
        boolean empty;
        int i2;
        String str;
        Iterator obj9;
        if (list2 != null) {
            linearLayout.getContext();
            systemService = linearLayout.getContext().getSystemService("layout_inflater");
            i = 0;
            obj9 = list2.iterator();
            while (obj9.hasNext()) {
                replaceFirst = obj9.next();
                viewById = 2131363371;
                empty = 0;
                i2 = 2131558460;
                if ((String)replaceFirst.contains("*")) {
                } else {
                }
                inflate = (LayoutInflater)systemService.inflate(i2, empty);
                if (!replaceFirst.isEmpty()) {
                }
                (TextView)inflate.findViewById(viewById).setText(replaceFirst);
                (ImageView)inflate.findViewById(2131362619).setVisibility(8);
                replaceFirst = i + 1;
                linearLayout.addView(inflate, i);
                i = replaceFirst;
                replaceFirst = replaceFirst.replaceFirst("\\s*\\*\\s*", "");
                if (!replaceFirst.isEmpty()) {
                }
                inflate = systemService.inflate(i2, empty);
                (TextView)inflate.findViewById(viewById).setText(replaceFirst);
                replaceFirst = i + 1;
                linearLayout.addView(inflate, i);
            }
        }
    }

    public static void i(View view, boolean z2) {
        int cVar;
        int i;
        Object obj5;
        int obj6;
        cVar = 200;
        final int i3 = 0;
        if (z2) {
            if (view.getVisibility() == 4) {
                view.animate().setDuration(0).scaleX(i3).scaleY(i3).start();
            }
            if (view.getVisibility() != 0) {
                int i2 = 1065353216;
                cVar = new b(view);
                view.animate().setDuration(cVar).scaleX(i2).scaleY(i2).withStartAction(cVar).start();
            }
        } else {
            if (view.getVisibility() == 0) {
                cVar = new c(view);
                view.animate().setDuration(cVar).scaleX(i3).scaleY(i3).withEndAction(cVar).start();
            }
        }
    }

    public static void j(LinearLayout linearLayout, int i2, int i3, int i4) {
        ImageView[] arr;
        Context context;
        int i6;
        android.util.DisplayMetrics displayMetrics;
        LinearLayout.LayoutParams layoutParams;
        int drawable;
        int i;
        int i5;
        ImageView obj7;
        int obj8;
        float obj10;
        if (i2 < 0) {
            linearLayout.setVisibility(8);
        } else {
            if (i2 >= i3) {
                obj8 = i3 + -1;
            }
            arr = new ImageView[i3];
            context = linearLayout.getContext();
            linearLayout.setVisibility(0);
            linearLayout.removeAllViews();
            if (i4 == null) {
                obj10 = context.getResources().getDimension(2131165388);
            } else {
                obj10 = TypedValue.applyDimension(1, (float)i4, context.getResources().getDisplayMetrics());
            }
            obj10 = (int)obj10;
            layoutParams = new LinearLayout.LayoutParams(obj10, obj10);
            i = 0;
            while (i6 < i3) {
                ImageView imageView = new ImageView(context);
                arr[i6] = imageView;
                arr[i6].setImageDrawable(context.getResources().getDrawable(2131231369, i));
                arr[i6].setLayoutParams(layoutParams);
                linearLayout.addView(arr[i6]);
                i6++;
            }
            if (i3 > 0) {
                arr[obj8].setImageDrawable(context.getResources().getDrawable(2131231368, i));
            }
        }
    }

    public static void k(Button button, int i2) {
        (MaterialButton)button.setIconResource(i2);
    }

    public static void l(ViewPager viewPager, View view2) {
        int obj4 = Math.round(view2.getX());
        int i4 = 0;
        viewPager.setPadding(obj4, i4, i -= obj4, i4);
        viewPager.setPageMargin(Math.round(TypedValue.applyDimension(1, 1098907648, viewPager.getResources().getDisplayMetrics())));
        viewPager.setClipToPadding(i4);
    }

    public static void m(Chip chip, String string2, int i3) {
        String str;
        int i;
        int obj4;
        if (i3 == 0) {
            obj4 = 1;
        }
        String obj3 = App.p().d(string2, "🏳️");
        if (chip.getPaint().hasGlyph(obj3)) {
            str = obj3;
        }
        obj3 = new StringBuilder();
        i = 0;
        while (i < obj4) {
            obj3.append(str);
            i++;
        }
        chip.setText(obj3);
    }

    public static void n(View view, String string2) {
        g gVar = new g();
        y yVar = new y(16);
        m.a(view.getContext()).D(string2).p1(MyAppGlideModule.d(view.getContext())).R0((g)gVar.k0(yVar)).C0((ImageView)view);
    }

    public static void o(ImageView imageView, String string2) {
        int i = 2131231265;
        m.a(imageView.getContext()).D(string2).p1(MyAppGlideModule.d(imageView.getContext())).R0(g.q0()).Z0(i).X0(i).C0(imageView);
    }

    public static void p(ImageView imageView, String string2) {
        imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
        m.a aVar = new m.a(imageView);
        m.a(imageView.getContext()).D(string2).y1(d.h()).c1(aVar).R0(g.q0()).C0(imageView);
    }

    public static void q(EditText editText, int i2, int i3) {
        if (i3 != 0) {
            editText.setRawInputType(i3);
        }
        if (i2 != 0) {
            editText.setImeOptions(i2);
        }
    }

    public static void r(View view, int i2) {
        if (i2 == 0) {
        }
        view.setBackground(view.getResources().getDrawable(i2, 0));
    }

    public static void s(EditText editText, TextView.OnEditorActionListener textView$OnEditorActionListener2) {
        editText.setOnEditorActionListener(onEditorActionListener2);
    }
}
