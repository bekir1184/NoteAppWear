package com.beko.noteappwear.ui.main.dialog

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.beko.noteappwear.data.Note
import com.beko.noteappwear.databinding.FragmentAddNoteDialogBinding
import com.beko.noteappwear.ui.main.NoteViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddNoteDialog : BottomSheetDialogFragment() {

    private lateinit var mNoteViewModel: NoteViewModel
    private lateinit var binding : FragmentAddNoteDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteDialogBinding.inflate(layoutInflater)
        mNoteViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(NoteViewModel::class.java)

        setOnClicks()
        return binding.root
    }

    private fun setOnClicks() {
        binding.addBtn.setOnClickListener {
            insertNoteToDatabase()
        }
    }

    private fun insertNoteToDatabase() {
        val noteTitle = binding.noteTitle.text.toString()
        val noteContent = binding.noteContent.text.toString()
        if(inputCheck(noteTitle, noteContent)){
            val note = Note(0,noteTitle,noteContent)
            mNoteViewModel.addNote(note)
            Toast.makeText(requireContext(),"Not Eklendi",Toast.LENGTH_SHORT).show()
            //Succes
            dismiss()
        }else{
            Toast.makeText(requireContext(),"Lütfen tüm alanları doldurunuz",Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(noteTitle : String , noteContent : String) : Boolean{
        return !(TextUtils.isEmpty(noteTitle) && TextUtils.isEmpty(noteContent))
    }

}