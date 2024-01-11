package com.example.e_commerce.addItemView

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerce.R
import com.example.e_commerce.listView.ItemListActivity
import com.example.e_commerce.mockData.DummyItems
import kotlinx.android.synthetic.main.activity_add.*

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        toolbar.title = "Add new Item"

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Add_IdTextView.text = buildString {
            append("ID: ")
            append((DummyItems.getSize() + 1).toString())
        }

        var ok = false
        while (!ok) {
            var price = addPriceInput.text.toString().toDoubleOrNull()
            var quantity = addQuantityInput.text.toString().toIntOrNull()
            var error = ""
            if (price != null)
                error += "Price should be a double value!"

            if (quantity != null)
                error += "Quantity should be integer"

            addError.text = error

            if (error == "")
                ok = true



        }

        addItemBtn.setOnClickListener {
                var name = addProductNameInput.text.toString()
                var description = addDescriptionInput.text.toString()
                var price = addPriceInput.text.toString().toDoubleOrNull()
                var quantity = addQuantityInput.text.toString().toIntOrNull()

                var error = ""
                if (price == null)
                    error += "Price should be a double value!\n"

                if (quantity == null)
                    error += "Quantity should be integer!\n"

                if (error == "")
                {
                    if (price != null) {
                        if (quantity != null) {
                            DummyItems.addItem(name,description,price,quantity,null)
                        }
                    }

                    val intent = Intent(this, ItemListActivity::class.java)
                    startActivity(intent)
                }
            else
                {
                    addError.text = error
                }

            }

        }

    }
