package br.com.devmobile.guiapersonagensrickandmorty.util

import br.com.devmobile.guiapersonagensrickandmorty.model.Result

sealed class Status {
    object loader: Status()
    class OnSucess(val list: List<Result>): Status()
    class OnError(val mensagem: String): Status()
}