package com.splicer.bluetothandroidmonitor

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import java.io.IOException
import java.util.*

class ConnectThread(private val device: BluetoothDevice) : Thread() {
    val uuid = "00001101-0000-1000-8000-00805F9B34FB"
    var mSocket: BluetoothSocket? = null

    init {
        try {
            mSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(uuid))
        } catch (i: IOException) {
        }
    }

    override fun run() {
        try {
            mSocket?.connect()
        } catch (i: IOException){}
        closeConnection()
        }
    fun closeConnection() {
        try {
            mSocket?.close()
        } catch (i: IOException){}
    }
    }


