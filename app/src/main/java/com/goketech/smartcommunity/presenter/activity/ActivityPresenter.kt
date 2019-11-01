package com.goketech.smartcommunity.presenter.activity

import com.goketech.smartcommunity.base.BasePresenter
import com.goketech.smartcommunity.commonents.CommonSubscriber
import com.goketech.smartcommunity.commonents.RxUtils
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.HttpManager
import com.goketech.smartcommunity.model.bean.IndexBean

class ActivityPresenter: BasePresenter<HomeConstact.View>(),
    HomeConstact.Presenter {
    override fun getIndex() {

    }

}