package com.example.note_to_self

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class DailogShowNote: DialogFragment() {

    private var note: Note? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())
        val inflater = requireActivity().layoutInflater

        val dailogView = inflater.inflate(R.layout.dailog_show_note, null)

        val txtTitle = dailogView.findViewById(R.id.txtTitle) as TextView
        val txtDescription = dailogView.findViewById(R.id.txtDescription) as TextView

        txtTitle.text = note!!.title
        txtDescription.text = note!!.description

        val txtImportant = dailogView.findViewById(R.id.textViewImportant) as TextView
        val txtTodo = dailogView.findViewById(R.id.textViewTodo) as TextView
        val txtIdea = dailogView.findViewById(R.id.textViewIdea) as TextView

        if(!note!!.important){
            txtImportant.visibility = View.GONE
        }
        if(!note!!.todo){
            txtTodo.visibility = View.GONE
        }
        if(!note!!.idea){
            txtIdea.visibility = View.GONE

        }

        val btnOk = dailogView.findViewById(R.id.btnOk) as Button


        builder.setView(dailogView).setMessage("Your Note")

        btnOk.setOnClickListener({
            dismiss()
        })

        return builder.create()

    }

    fun sendNoteSelected(noteSelected: Note) {
        note = noteSelected

    }
}