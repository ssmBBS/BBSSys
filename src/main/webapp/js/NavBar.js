/**
 * Created by Xxy on 2017/7/17.
 */
function toMain() {
    document.forms["nav"].action="main.yue";
    document.forms["nav"].submit();
}
function toFriends() {
    document.forms["nav"].action="friends.yue";
    document.forms["nav"].submit();
}
function toCenter() {
    document.forms["nav"].action="center.yue";
    document.forms["nav"].submit();
}
function logout() {
    document.forms["nav"].action="logout.yue";
    document.forms["nav"].submit();
}
function toMessage(){
    document.forms["nav"].action="message.yue";
    document.forms["nav"].submit();
}