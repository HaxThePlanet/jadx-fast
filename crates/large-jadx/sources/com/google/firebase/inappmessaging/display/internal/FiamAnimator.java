package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

/* loaded from: classes2.dex */
public class FiamAnimator {

    public interface AnimationCompleteListener {
        public abstract void onComplete();
    }

    public static enum Position {

        LEFT,
        RIGHT,
        TOP,
        BOTTOM;
        static Point access$000(com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position fiamAnimator$Position, View view2) {
            return FiamAnimator.Position.getPoint(position, view2);
        }

        private static Point getPoint(com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position fiamAnimator$Position, View view2) {
            int i = -2;
            view2.measure(i, i);
            int obj3 = FiamAnimator.3.$SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position[position.ordinal()];
            int i2 = 1;
            final int i3 = 0;
            if (obj3 != i2 && obj3 != 2 && obj3 != 3 && obj3 != 4) {
                if (obj3 != 2) {
                    if (obj3 != 3) {
                        if (obj3 != 4) {
                            obj3 = new Point(i3, obj4 *= -1);
                            return obj3;
                        }
                        obj3 = new Point(i3, obj4 *= i2);
                        return obj3;
                    }
                    obj3 = new Point(i3, obj4 *= -1);
                    return obj3;
                }
                obj3 = new Point(obj4 *= i2, i3);
                return obj3;
            }
            obj3 = new Point(obj4 *= -1, i3);
            return obj3;
        }
    }
    public void slideIntoView(Application application, View view2, com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position fiamAnimator$Position3) {
        view2.setAlpha(0);
        Point obj5 = FiamAnimator.Position.access$000(position3, view2);
        float f = (float)i3;
        FiamAnimator.1 anon = new FiamAnimator.1(this, view2, application);
        view2.animate().translationX(f).translationY((float)obj5).setDuration(1).setListener(anon);
    }

    public void slideOutOfView(Application application, View view2, com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position fiamAnimator$Position3, com.google.firebase.inappmessaging.display.internal.FiamAnimator.AnimationCompleteListener fiamAnimator$AnimationCompleteListener4) {
        Point obj4 = FiamAnimator.Position.access$000(position3, view2);
        FiamAnimator.2 anon = new FiamAnimator.2(this, animationCompleteListener4);
        float obj5 = (float)obj5;
        view2.animate().translationX(obj5).translationY((float)obj4).setDuration((long)obj2).setListener(anon);
    }
}
