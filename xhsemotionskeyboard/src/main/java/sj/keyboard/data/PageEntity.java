package sj.keyboard.data;

import android.view.View;
import android.view.ViewGroup;

import sj.keyboard.interfaces.PageViewInstantiateListener;

/**
 * Created by liyuzhao on 16/9/23.
 */
public class PageEntity<T extends  PageEntity> implements PageViewInstantiateListener<T> {

    protected View mRootView;

    protected PageViewInstantiateListener mPageViewInstantiateListener;

    public void setIPageViewInstantiateItem(PageViewInstantiateListener pageViewInstantiateListener) { this.mPageViewInstantiateListener = pageViewInstantiateListener; }

    public View getRootView() {
        return mRootView;
    }

    public void setRootView(View rootView) {
        this.mRootView = rootView;
    }

    public PageEntity(){ }

    public PageEntity(View view){
        this.mRootView = view;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position, T pageEntity) {
        if(mPageViewInstantiateListener != null){
            return mPageViewInstantiateListener.instantiateItem(container, position, this);
        }
        return getRootView();
    }
}
