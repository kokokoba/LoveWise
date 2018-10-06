package jp.ne.com.kobayashi.videomatchingapp.model

data class Message (
    var idSender: String,
    var idReceiver: String,
    var text: String,
    var timestamp: Long
)