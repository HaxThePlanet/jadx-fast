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
import h.a.b.e;

/* compiled from: EntryViewHolder.java */
/* loaded from: classes.dex */
public abstract class EntryViewHolder extends h.a.c.b {

    private d commentBarManager;
    public EntryViewHolder(View view, h.a.b.b bVar) {
        super(view, bVar);
    }

    private /* synthetic */ void a(EntryPhotoBaseObservable entryPhotoBaseObservable, View view, boolean z) {
        entryPhotoBaseObservable.setCommentFieldFocused(z);
        this.commentBarManager.updateCommentLabelView();
    }

    static /* synthetic */ h.a.b.b access$000(EntryViewHolder entryViewHolder) {
        return entryViewHolder.mAdapter;
    }

    static /* synthetic */ h.a.b.b access$100(EntryViewHolder entryViewHolder) {
        return entryViewHolder.mAdapter;
    }

    static /* synthetic */ boolean c(sk skVar, EditText editText, View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            skVar.T.S.requestFocus();
            editText.setText("");
            return true;
        }
        return false;
    }

    @Override // h.a.c.b
    public void clearCommentField() {
        if (this.commentBarManager != null) {
            this.commentBarManager.clearCommentField();
        }
    }

    @Override // h.a.c.b
    public String getId() {
        h.a.b.h.f fVar = this.mAdapter.O0(getAdapterPosition());
        if (fVar instanceof EntryItem) {
            return fVar.getId();
        }
        return null;
    }

    @Override // h.a.c.b
    public void notifyCommentViewChange() {
        if (this.commentBarManager != null) {
            this.commentBarManager.updateAll();
        }
    }

    @Override // h.a.c.b
    public void setupCommentField(sk skVar, EntryPhotoBaseObservable entryPhotoBaseObservable, a0 a0Var) {
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder.AnonymousClass2 anonymousClass2 = new EntryViewHolder.AnonymousClass2(this, entryPhotoBaseObservable, a0Var, skVar);
        this.commentBarManager = anonymousClass2;
        skVar.T.U(anonymousClass2);
        skVar.T.Q.setOnFocusChangeListener(new z(this, entryPhotoBaseObservable));
        skVar.T.Q.setOnKeyListener(new y(skVar, editText));
        this.mAdapter.n().l(new EntryViewHolder.AnonymousClass3(this, entryPhotoBaseObservable, skVar));
    }

    @Override // h.a.c.b
    protected void showLikeAnimation(ImageView imageView) throws android.content.res.Resources.NotFoundException {
        imageView.setVisibility(0);
        imageView.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(imageView.getContext(), 2130772015);
        animation.setAnimationListener(new EntryViewHolder.AnonymousClass1(this, imageView));
        imageView.startAnimation(animation);
    }

    @Override // h.a.c.b
    public void updateFeaturedStarVisibility(EntryPhotoBaseObservable entryPhotoBaseObservable, sk skVar) {
        if (entryPhotoBaseObservable.isUserAdmin()) {
            int i = 0;
            skVar.Z.setVisibility(i);
        } else {
            i = 8;
            skVar.Z.setVisibility(i);
        }
    }

    @Override // h.a.c.b
    public /* synthetic */ void b(EntryPhotoBaseObservable entryPhotoBaseObservable, View view, boolean z) {
        a(entryPhotoBaseObservable, view, z);
    }

    @Override // h.a.c.b
    public abstract void onUserView(boolean z);

    @Override // h.a.c.b
    public abstract void updateView();
}
