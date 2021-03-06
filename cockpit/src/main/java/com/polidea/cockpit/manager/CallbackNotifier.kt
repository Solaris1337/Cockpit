package com.polidea.cockpit.manager

import com.polidea.cockpit.event.ActionRequestCallback

internal class CallbackNotifier {

    private val callbacks: MutableMap<String, MutableSet<ActionRequestCallback>> = mutableMapOf()

    fun add(paramName: String, callback: ActionRequestCallback) {
        val paramListeners = getCallbacks(paramName)
        paramListeners.add(callback)
        callbacks[paramName] = paramListeners
    }

    fun remove(paramName: String, callback: ActionRequestCallback) {
        callbacks[paramName]?.remove(callback)
    }

    fun requestAction(paramName: String) {
        val paramListeners = getCallbacks(paramName)
        paramListeners.forEach {
            it.onActionRequested()
        }
    }

    private fun getCallbacks(name: String): MutableSet<ActionRequestCallback> = callbacks[name] ?: mutableSetOf()
}