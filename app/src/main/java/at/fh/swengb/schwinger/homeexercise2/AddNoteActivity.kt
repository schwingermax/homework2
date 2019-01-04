package at.fh.swengb.schwinger.homeexercise2


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*


class AddNoteActivity : AppCompatActivity() {

    lateinit var db: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NotesRoomDatabase.getDatabase(this)
    }

    fun saveNote(view: View) {

        val title = note_title.text.toString()
        val content = note_content.text.toString()
        val note = Note(title,content)

        db.noteDao.insert(note)
        db.noteDao.findAll()
        finish()
    }

}
