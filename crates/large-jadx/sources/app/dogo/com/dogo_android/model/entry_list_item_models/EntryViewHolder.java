package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.util.u.b;
import h.a.b.b;
import h.a.b.e;
import h.a.c.b;

/* loaded from: classes.dex */
public abstract class EntryViewHolder extends b {

    private d commentBarManager;
    public EntryViewHolder(View view, b b2) {
        super(view, b2);
    }

    private void a(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable, View view2, boolean z3) {
        entryPhotoBaseObservable.setCommentFieldFocused(z3);
        this.commentBarManager.updateCommentLabelView();
    }

    static b access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder entryViewHolder) {
        return entryViewHolder.mAdapter;
    }

    static b access$100(app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder entryViewHolder) {
        return entryViewHolder.mAdapter;
    }

    static boolean c(sk sk, EditText editText2, View view3, int i4, KeyEvent keyEvent5) {
        if (i4 == 4) {
            obj0.S.requestFocus();
            editText2.setText("");
            return 1;
        }
        return 0;
    }

    @Override // h.a.c.b
    public void b(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable, View view2, boolean z3) {
        a(entryPhotoBaseObservable, view2, z3);
    }

    @Override // h.a.c.b
    public void clearCommentField() {
        final d commentBarManager = this.commentBarManager;
        if (commentBarManager != null) {
            commentBarManager.clearCommentField();
        }
    }

    @Override // h.a.c.b
    public String getId() {
        h.a.b.h.f fVar = this.mAdapter.O0(getAdapterPosition());
        if (fVar instanceof EntryItem) {
            return (EntryItem)fVar.getId();
        }
        return null;
    }

    @Override // h.a.c.b
    public void notifyCommentViewChange() {
        final d commentBarManager = this.commentBarManager;
        if (commentBarManager != null) {
            commentBarManager.updateAll();
        }
    }

    @Override // h.a.c.b
    public abstract void onUserView(boolean z);

    @Override // h.a.c.b
    public void setupCommentField(sk sk, app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable2, a0 a03) {
        EditText editText = ciVar.Q;
        EntryViewHolder.2 anon2 = new EntryViewHolder.2(this, entryPhotoBaseObservable2, a03, sk);
        this.commentBarManager = anon2;
        sk.T.U(anon2);
        z obj5 = new z(this, entryPhotoBaseObservable2);
        editText.setOnFocusChangeListener(obj5);
        obj5 = new y(sk, editText);
        editText.setOnKeyListener(obj5);
        EntryViewHolder.3 anon = new EntryViewHolder.3(this, entryPhotoBaseObservable2, sk);
        this.mAdapter.n().l(anon);
    }

    @Override // h.a.c.b
    protected void showLikeAnimation(ImageView imageView) {
        imageView.setVisibility(0);
        imageView.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
        EntryViewHolder.1 anon = new EntryViewHolder.1(this, imageView);
        animation.setAnimationListener(anon);
        imageView.startAnimation(animation);
    }

    @Override // h.a.c.b
    public void updateFeaturedStarVisibility(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable, sk sk2) {
        FrameLayout obj1;
        int obj2;
        if (entryPhotoBaseObservable.isUserAdmin()) {
            sk2.Z.setVisibility(0);
        } else {
            sk2.Z.setVisibility(8);
        }
    }

    @Override // h.a.c.b
    public abstract void updateView();
}
