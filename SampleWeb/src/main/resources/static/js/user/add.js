/**
 * 登録ボタンで確認アラートを表示させます。
 */
$("#btn-submit").on('click', function() {
    const message = "新規ユーザーを登録しますか？";
    if(!confirm(message)) {
        return false;
    }
});