package com.goketech.smartcommunity.view.my

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.my.MyPresenter

class My_Fragment : BaseFragment<HomeConstact.View, HomeConstact.Presenter>(),HomeConstact.View {
    override fun getIndexReturn(result: IndexBean) {

    }

    override fun onError(err: String) {

    }

    override val layout: Int
        get() = R.layout.fragment_my_layout
    override fun initView(view: View) {

    }

    override fun initData() {

    }
    override fun initPresenter(): HomeConstact.Presenter {
       return MyPresenter()
    }
}