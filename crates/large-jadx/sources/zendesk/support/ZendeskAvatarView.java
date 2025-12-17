package zendesk.support;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.core.content.a;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import f.g.d.c;
import f.g.d.e;
import f.g.d.f;
import f.g.e.g;

/* loaded from: classes3.dex */
public class ZendeskAvatarView extends FrameLayout {

    private static final int[] AVATAR_COLORS;
    private boolean enableOutline;
    private ImageView imageView;
    private int strokeColor;
    private int strokeWidth;
    private TextView textView;
    static {
        int[] iArr = new int[19];
        ZendeskAvatarView.AVATAR_COLORS = iArr;
    }

    public ZendeskAvatarView(Context context) {
        super(context, 0, 0);
    }

    public ZendeskAvatarView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ZendeskAvatarView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int obj1 = 0;
        this.enableOutline = obj1;
        this.strokeColor = obj1;
        this.strokeWidth = obj1;
        initViews();
    }

    private Drawable getBackgroundShape(int i) {
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(a.d(getContext(), i));
        if (this.enableOutline) {
            OvalShape ovalShape2 = new OvalShape();
            ShapeDrawable obj6 = new ShapeDrawable(ovalShape2);
            Paint paint2 = obj6.getPaint();
            paint2.setStyle(Paint.Style.STROKE);
            int i3 = 1;
            paint2.setAntiAlias(i3);
            paint2.setColor(this.strokeColor);
            paint2.setStrokeWidth((float)strokeWidth);
            int i2 = 2;
            Drawable[] arr = new Drawable[i2];
            arr[0] = shapeDrawable;
            InsetDrawable insetDrawable = new InsetDrawable(obj6, strokeWidth2 /= i2);
            arr[i3] = insetDrawable;
            obj6 = new LayerDrawable(arr);
            return obj6;
        }
        return shapeDrawable;
    }

    private int getColorId(Object object) {
        final int[] aVATAR_COLORS = ZendeskAvatarView.AVATAR_COLORS;
        return aVATAR_COLORS[Math.abs(obj3 %= length)];
    }

    private void initViews() {
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setId(f.K0);
        this.textView.setTextColor(a.d(getContext(), c.a));
        this.textView.setGravity(17);
        this.textView.setTextSize(2, 1098907648);
        ImageView imageView = new ImageView(getContext());
        this.imageView = imageView;
        imageView.setId(f.J0);
        addView(this.textView);
        addView(this.imageView);
    }

    private void setTextView(String string) {
        setBackground(getBackgroundShape(getColorId(string)));
        this.textView.setText(String.valueOf(Character.toUpperCase(string.charAt(0))));
    }

    @Override // android.widget.FrameLayout
    public void setStroke(int i, int i2) {
        this.strokeColor = i;
        this.strokeWidth = i2;
        this.enableOutline = true;
    }

    @Override // android.widget.FrameLayout
    public void showUserWithAvatarImage(t t, String string2, String string3, int i4) {
        boolean textView;
        final int i = 0;
        this.imageView.setVisibility(i);
        this.imageView.setImageResource(c.v);
        if (g.c(string3)) {
            this.textView.setVisibility(i);
            setTextView(string3);
        }
        this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final x obj4 = t.l(string2);
        int obj5 = i4 * 2;
        obj4.k(obj5, obj5);
        obj4.a();
        obj4.j();
        obj4.l(PicassoTransformations.getRoundWithBorderTransformation(i4, this.strokeColor, this.strokeWidth));
        obj4.f(this.imageView);
    }

    @Override // android.widget.FrameLayout
    public void showUserWithIdentifier(Object object) {
        int i;
        Object obj2;
        if (object != null) {
            setBackground(getBackgroundShape(getColorId(object)));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setImageResource(e.b);
            this.textView.setVisibility(4);
            this.imageView.setVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout
    public void showUserWithName(String string) {
        boolean z;
        Object obj2;
        if (g.c(string)) {
            setTextView(string);
            this.textView.setVisibility(0);
            this.imageView.setVisibility(4);
        }
    }
}
