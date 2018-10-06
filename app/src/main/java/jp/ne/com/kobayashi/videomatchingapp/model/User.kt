package jp.ne.com.kobayashi.videomatchingapp.model

data class User(
    val name: String,
    val email: String,
    val avata: String,
    var status: Status,
    var message: Message
) {
    // 初期化処理
    init {
        status = Status(false, 0)
        message = Message("0","0", "", 0)
    }
}