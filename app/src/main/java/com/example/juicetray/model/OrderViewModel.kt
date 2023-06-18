package com.example.juicetray.model

import android.icu.text.NumberFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.juicetray.data.DataSource

class OrderViewModel: ViewModel() {

    val juicyItems = DataSource.juicyItems

    private  var previousOpenPrice = 0.0
    private  var previousSidePrice = 0.0
    private var previousComplementPrice = 0.0


    private val taxRate = 0.08

    private val _open = MutableLiveData<JuicyItem?>()
    val  open: LiveData<JuicyItem?> = _open

    private  val _side = MutableLiveData<JuicyItem?>()
    val side : LiveData<JuicyItem?> = _side

    private  val _complement = MutableLiveData<JuicyItem?>()
    val complement: LiveData<JuicyItem?> = _complement

    private val _subtotal = MutableLiveData(0.0)
    @RequiresApi(Build.VERSION_CODES.N)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private  val _total = MutableLiveData(0.0)
     @RequiresApi(Build.VERSION_CODES.N)
     val total : LiveData<String> = Transformations.map(_total) {
         NumberFormat.getCurrencyInstance().format(it)
     }

    private val _tax = MutableLiveData(0.0)
    @RequiresApi(Build.VERSION_CODES.N)
    val tax : LiveData<String> = Transformations.map(_tax) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    fun setOpen(open: String){
        if (_open.value != null) {
            previousOpenPrice = _open.value!!.price
        }

        if (_subtotal.value != null){
            _subtotal.value = _subtotal.value!!.minus(previousOpenPrice)
        }
        _open.value = juicyItems[open]
        updateSubtotal(_open.value!!.price)
    }

    fun setSide(side: String) {
        if (_side.value != null){
            previousSidePrice = _side.value!!.price
        }
        if (_subtotal.value != null){
            _subtotal.value = _subtotal.value!!.minus(previousSidePrice)
        }
        _side.value = juicyItems[side]
        updateSubtotal(_side.value!!.price)

    }

    fun setComplement(complement: String){
        if (_complement.value != null){
            previousComplementPrice = _complement.value!!.price
        }
        if (_subtotal.value != null){
            _subtotal.value = _subtotal.value!!.minus(previousComplementPrice)
        }
        _complement.value = juicyItems[complement]
        updateSubtotal(_complement.value!!.price)

    }

    private fun updateSubtotal(itemPrice: Double) {
        if (_subtotal.value != null){
            _subtotal.value = _subtotal.value!!.plus(itemPrice)
        } else {
            _subtotal.value = itemPrice
        }

        calculateTaxAndTotal()

    }

    fun calculateTaxAndTotal() {

        _tax.value = _subtotal.value!!.times(taxRate)

        _total.value = _subtotal.value!!.plus(_tax.value!!)

    }

    fun resetOrder() {
           previousOpenPrice = 0.0
           previousSidePrice = 0.0
           previousComplementPrice = 0.0




      _open.value = null

         _side.value = null


         _complement.value = null

         _subtotal.value = 0.0


         _total.value = 0.0


         _tax.value = 0.0


    }

}