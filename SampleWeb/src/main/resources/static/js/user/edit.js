$('#btn-submit').on('click', function() {
  const list = checkChanges();
  if(!list.length) {
    return
  }
  const message = list.join(',') + "を変更します。よろしいですか？";
  if(!confirm(message)) {
    return false;
  }
});

/**
 * フォームに変更があった項目のリストを返します。
 * return フォームに変更があった項目のリスト
 */
const checkChanges = function() {
  const invisibleClass = $('.invisible');
  const beforeName = invisibleClass.find('#userName').val();
  const beforeAddress = invisibleClass.find('#userAddress').val();
  const beforePhone = invisibleClass.find('#userPhone').val();
  const afterName = $('#name').val();
  const afterAddress = $('#address').val();
  const afterPhone = $('#phone').val();
  
  const list = [];
  
  if(beforeName !== afterName) {
    list.push("名前")
  }
  if(beforeAddress !== afterAddress) {
    list.push("住所")
  }
  if(beforePhone !== afterPhone) {
    list.push("電話番号")
  }
  return list;
};