package com.goketech.smartcommunity.view.neighbourhood

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.neighbourhood.NeighbourhoodPresenter

class NeighbourhoodFragment : BaseFragment<HomeConstact.View, HomeConstact.Presenter>(),HomeConstact.View {
    override fun getIndexReturn(result: IndexBean) {

    }

    override fun onError(err: String) {

    }

    override fun initView(view: View) {

    }

    override val layout: Int
        get() = R.layout.fragment_neighbourhood_layout


    override fun initData() {

    }

    override fun initPresenter(): HomeConstact.Presenter {
        return NeighbourhoodPresenter()
    }
}