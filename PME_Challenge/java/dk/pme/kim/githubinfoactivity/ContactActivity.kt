package dk.pme.kim.githubinfoactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.net.Uri
import android.content.Intent
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

    }

    //  Listener for send mail button:
    fun mailListener(view: View)
    {
        startMailIntent()
    }

    private fun startMailIntent(){

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")

        val sender=id_sender.text.toString()
        intent.putExtra(Intent.EXTRA_EMAIL,sender)

        val subject=id_subject.text.toString()
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)

        val body=id_msg.text.toString()
        intent.putExtra(Intent.EXTRA_TEXT,body)

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}