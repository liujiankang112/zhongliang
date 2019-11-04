package com.goketech.smartcommunity.view.main

import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.Toast
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.home.HomePresenter
import kotlinx.android.synthetic.main.fragment_main_layout.*
import kotlinx.android.synthetic.main.popuo_lianxiwuye_layout.*


class MainFragment : BaseFragment<HomeConstact.View, HomeConstact.Presenter>(),HomeConstact.View, View.OnClickListener {
    override fun onError(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIndexReturn(result: IndexBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//        var pw : PopupWindow?=null


    override val layout: Int
        get() = R.layout.fragment_main_layout

    override fun initView(view: View) {
        mainbt_baoxiuFW.setOnClickListener(this)
        mainbt_lianxiWY.setOnClickListener(this)
        mainbt_menjinYS.setOnClickListener(this)
        mainbt_wuyeJF.setOnClickListener(this)
        mainbt_xinzengFK.setOnClickListener(this)
//        initPopuo()
    }

    private fun initPopuo() {
        var view = View.inflate(activity, R.layout.popuo_lianxiwuye_layout, null)
//        pw = PopupWindow(view, 300, 300)
        val popu_cancel = view.findViewById<View>(R.id.popuobt_cancel)
        val popu_confirm= view.findViewById<View>(R.id.popuobt_confirm)
        popu_cancel.setOnClickListener(this)
        popu_confirm.setOnClickListener(this)
    }

    override fun initData() {

    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mainbt_menjinYS -> {

            }
            R.id.mainbt_lianxiWY -> {

            }
            R.id.mainbt_wuyeJF -> {

            }
            R.id.mainbt_baoxiuFW -> {

            }
            R.id.mainbt_xinzengFK -> {

            }

        }
    }

    override fun initPresenter(): HomeConstact.Presenter {
            return HomePresenter()
    }


}