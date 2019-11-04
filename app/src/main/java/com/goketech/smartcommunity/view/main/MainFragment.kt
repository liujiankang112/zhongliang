package com.goketech.smartcommunity.view.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Toast
import com.bumptech.glide.Glide
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.adapters.HomeRecAdapter
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.constants.Constant
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.home.HomePresenter
import com.goketech.smartcommunity.utils.MyUtils
import com.sunfusheng.marqueeview.MarqueeView
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_main_layout.*
import kotlinx.android.synthetic.main.popuo_lianxiwuye_layout.*


class MainFragment : BaseFragment<HomeConstact.View, HomeConstact.Presenter>(),HomeConstact.View {
    override fun onError(err: String) {

    }

    override fun getIndexReturn(result: IndexBean) {
        val data = result!!.data
        val banner = data!!.banner
        val notice_list = data!!.notice_list
        val activity = data!!.activity

        // 通知
        var arrnotice = ArrayList<String>()
        for (noti: IndexBean.DataBean.NoticeListBean in notice_list!!) {
            arrnotice.add(noti!!.title!!)

        }

        Log.i("tag", "" + banner!!.size)

        //轮播图
        banhome.setImages(banner)
        banhome.setImageLoader(bannerLoad())
        banhome.setDelayTime(3000)
        banhome.start()
        //最新活动rec
        rechome.layoutManager = LinearLayoutManager(context!!)
        val mutableList = activity as MutableList
        rechome.adapter = HomeRecAdapter(mutableList)

    }
    class bannerLoad : ImageLoader() {
        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
            var bean: IndexBean.DataBean.BannerBean = path as IndexBean.DataBean.BannerBean
            Glide.with(context!!).load(bean!!.image).into(imageView!!)
        }
    }

//        var pw : PopupWindow?=null


    override val layout: Int
        get() = R.layout.fragment_main_layout

    override fun initView(view: View) {
//        mainbt_baoxiuFW.setOnClickListener(this)
//        mainbt_lianxiWY.setOnClickListener(this)
//        mainbt_menjinYS.setOnClickListener(this)
//        mainbt_wuyeJF.setOnClickListener(this)
//        mainbt_xinzengFK.setOnClickListener(this)
//        initPopuo()
        mainbt_menjinYS.setOnClickListener(View.OnClickListener {
            var intent = Intent()
            intent.setClass(context, KeyActivity::class.java)
            context!!.startActivity(intent)

        })
    }

    private fun initPopuo() {
        var view = View.inflate(activity, R.layout.popuo_lianxiwuye_layout, null)
//        pw = PopupWindow(view, 300, 300)
        val popu_cancel = view.findViewById<View>(R.id.popuobt_cancel)
        val popu_confirm= view.findViewById<View>(R.id.popuobt_confirm)
//        popu_cancel.setOnClickListener(this)
//        popu_confirm.setOnClickListener(this)
    }

    override fun initData() {
        Constant.TOKEN
        var prams = HashMap<String, String>()
        prams.put("company_id", "1")
        prams.put("community_id", "1")
        val sign = MyUtils.getSign(prams)
        prams.put("sign", sign!!)
        presenter!!.getHome(prams)


    }


    override fun initPresenter(): HomeConstact.Presenter {
            return HomePresenter()
    }


}