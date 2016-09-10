// 退出登录
function LoginOut(compel) {
    art.dialog.through({
        icon: 'error', //图标
        lock: true,
        title: '系统提示',
        content: '您确定要退出会员管理系统专业版么？',
        ok: function () { top.location.href = 'sys/logout.do'; },
        cancel: function () { }
    });
    return false;
}

//修改用户密码
//这个弹框的保存按钮事件，是写在frame.aspx页面的，因为使用了跨框架弹框
function EditUser() {
    var throughBox = art.dialog.through;
    throughBox({
        lock: true,
        title: '系统用户密码设置',
        width: '450px',
        content: document.getElementById('UserEdit'),
        id: 'EF893L'
    });
}

$(function () {
/**
    if (SysParameter().RestrainOnlineNumber > 0) {
        //如果启用了人数限制，才每隔10秒检查是否超出登陆人数
        setInterval(CheckOnline, "10000");
    }
    **/
    if ($("#chkIsTel").attr("checked")) {
        var caller = true;
    }
    else {
        caller = false;
    }
    if (!caller) {
        $("#topCaller").html("来电弹屏未启用");
        $("#topCaller").removeClass("top_caller").addClass("top_caller_no").attr("disabled", "disabled"); ;
    }
    else {
        switch (TV_Initialize()) {
            case 0:
                $("#topCaller").html("来电弹屏");
                break;
            case 1:
                alert("打开来电设备失败,请检查设备是否已经插入并安装了驱动,并且没有其它程序已经打开设备");
                break;
            case 2:
                $("#topCaller").html("<a href='AppDriver/driver.rar' title='未安装驱动请点击下载'>安装来电弹屏</a>");
                break;
        }
    }

    $("#top_hidefrm").click(function () {
        if ($(this).text() == "隐藏菜单") {
            $(parent.document.getElementById("MainFrameset")).attr("cols", "0,*");
            $(this).html("显示菜单").attr("class", "top_MenuOpen");
        } else {
            $(parent.document.getElementById("MainFrameset")).attr("cols", "160,*");
            $(this).html("隐藏菜单").attr("class", "top_MenuHide");
        }
    });

    $("#showrcode").click(function () {  
            var image = "<img src='Upload/WeiXin/Images/rcode.jpg" + "?" + GetGuid() + "' width=\"200\" height=\"200\" />";
            var throughBox = art.dialog.through;
            throughBox({
                lock: true,
                title: '扫一扫   ' + $("#showrcode").attr("title"),
                width: 200,
                height: 200,
                content: image,
                id: 'EF893L'
            });
    })
});

//加载页面时启动定时器
function CheckOnline() {
    doAjax("../", "CheckOnlineUser", {}, "json",
        function (json) {
            switch (json) {
                case -2:
                    break;
                case -1:
                    alert("已超过系统允许同时在线人数，你已被迫下线！");
                    top.location.href = '../Login.aspx';
                    break;
                case 0:
                    alert("本帐号已在别处登录，你已被迫下线！");
                    top.location.href = '../Login.aspx';
                    break;
            }
        }
    );
}
 