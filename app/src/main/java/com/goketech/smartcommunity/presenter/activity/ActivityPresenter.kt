package com.goketech.smartcommunity.presenter.activity

import com.goketech.smartcommunity.base.BasePresenter
import com.goketech.smartcommunity.commonents.CommonSubscriber
import com.goketech.smartcommunity.commonents.RxUtils
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.HttpManager
import com.goketech.smartcommunity.model.bean.IndexBean

class ActivityPresenter: BasePresenter<HomeConstact.View>(),
    HomeConstact.Presenter {
    override fun getHome(param: Map<String, String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}