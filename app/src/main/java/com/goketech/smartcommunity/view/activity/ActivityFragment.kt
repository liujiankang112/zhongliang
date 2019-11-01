package com.goketech.smartcommunity.view.activity

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.activity.ActivityPresenter
import com.goketech.smartcommunity.presenter.home.HomePresenter

class ActivityFragment : BaseFragment<HomeConstact.View, HomeConstact.Presenter>(),HomeConstact.View {
    override fun getIndexReturn(result: IndexBean) {

    }

    override fun onError(err: String) {

    }

    override fun initView(view: View) {

    }

    override val layout: Int
        get() = R.layout.fragment_activity_layout



    override fun initData() {

    }

    override fun initPresenter(): HomeConstact.Presenter {
        return ActivityPresenter()
    }
}