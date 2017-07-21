package lkp.com.photogallery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.Fragment

/**
 * Created by Administrator on 2017/7/21.
 */
class PhotoPageActivity : SingleFragmentActivity() {
    companion object {
        fun newIntent(context: Context, photoPageUri: Uri): Intent{
            var intent = Intent(context, PhotoPageActivity::class.java).setData(photoPageUri)
            intent.setData(photoPageUri)
            return intent
        }
    }
    override fun createFragment(): Fragment {
        return PhotoPageFragment.newIntance(intent.data)
    }
}