package com.app.opaynkidsapp.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.opaynkidsapp.navigator.FragmentBehaviour

class FragmentAdd(private val container: Int) : FragmentBehaviour() {

    override fun execute(transaction: FragmentTransaction, fragment: Fragment, tag: String?) {
        transaction.add(container, fragment, tag)
    }

}