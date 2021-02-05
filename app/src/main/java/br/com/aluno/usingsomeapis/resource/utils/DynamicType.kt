package br.com.aluno.usingsomeapis.resource.utils

class DynamicType<T>(v: T)  {

    private var listener: (T) -> (Unit) = {}
    var value: T = v
        set(newValue) {
            field = newValue
            this.listener(newValue)
        }

    fun bind(listenerIn: (T) -> Unit) {
        this.listener = listenerIn
    }

    init {
        this.value = v
    }
}