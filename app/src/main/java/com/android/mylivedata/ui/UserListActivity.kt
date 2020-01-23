package com.android.mylivedata.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mylivedata.R
import com.android.mylivedata.adapter.UserAdapter
import com.android.mylivedata.model.user.User
import com.android.mylivedata.utils.CommonMethods
import com.android.mylivedata.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_list.*
import com.kaopiz.kprogresshud.KProgressHUD

class UserListActivity : AppCompatActivity() {

    var mList =  ArrayList<User>()
    var mainViewModel : UserViewModel? = null
    var mBlogAdapter  : UserAdapter? = null
    lateinit var kProgressHUD: KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        prepareRecyclerView()

        mainViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        if(!CommonMethods.isNetworkAvailable(this@UserListActivity)) {
            CommonMethods.showToast(this@UserListActivity, getString(R.string.no_internet))
            return
        }

        getPopularBlog()

    }

    private fun getPopularBlog() {
        kProgressHUD = CommonMethods.createHUD(this@UserListActivity)
        mainViewModel!!.allBlog.observe(this, Observer { blogList ->
            cancelHUD()
            mBlogAdapter?.addUser(blogList as ArrayList<User>)
        })

    }

    private fun prepareRecyclerView() {

        mBlogAdapter = UserAdapter(mList, this@UserListActivity)

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerUser.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerUser.layoutManager = GridLayoutManager(this, 2)
        }

        recyclerUser.itemAnimator = DefaultItemAnimator()
        recyclerUser.adapter = mBlogAdapter

    }

    private fun cancelHUD() {
        if(::kProgressHUD.isInitialized) {
            CommonMethods.cancelHUD(kProgressHUD)
        }
    }

}